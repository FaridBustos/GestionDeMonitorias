/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import modelos.Estudiante;
import modelos.Profesor;
import modelos.Resena;
import modelos.Universidad;

/**
 *
 * @author farid
 */
public class ControladorResenas {

    private Universidad uni;

    public ControladorResenas(Universidad uni) {
        this.uni = uni;
    }

    public void agregarResena(int codigoProfesor, int codigoResena, float puntaje, String descripcion) {
        try {
            Profesor p = uni.buscarProfesor(codigoProfesor);
            if (p != null) {
                p.agregarResena(new Resena(codigoResena, descripcion, puntaje, (Estudiante) uni.getUsuarioActual()));

            } else {
                throw new Exception("Profesor no existe");
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    public void eliminarResena(int codigoProfesor, int codigoResena) {

        try {
            Profesor p = uni.buscarProfesor(codigoProfesor);
            if (p != null) {
                boolean res = p.getResenas().remove(p.buscarResena(codigoResena));
                if (!res) {
                    throw new Exception("no se pudo eliminar al profesor");
                }
            } else {
                throw new Exception("Profesor no existe");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public TableModel mostrarResenas(int codigoProfesor) {
        // Creamos un nuevo modelo de tabla
        DefaultTableModel modelo = new DefaultTableModel();
        //Definimos las columnas del nuevo modelo de tabla
        String ids[] = {"codigo", "Puntaje", "descripcion", "autor"};
        modelo.setColumnIdentifiers(ids);
        try {
            //obtenemos al profesor
            Profesor p = uni.buscarProfesor(codigoProfesor);
            ArrayList<Resena> resenas = new ArrayList<>();

            //obtenemos las cuentas
            if (p != null) {
                resenas = p.getResenas();
            } else {
                throw new Exception("Profesor no existe");
            }

            //Añadimos las filas al modelo de la tabla
            for (int i = 0; i < resenas.size(); i++) {
                modelo.addRow(new Object[]{resenas.get(i).getCodigo(), resenas.get(i).getPuntaje(), resenas.get(i).getDescripcion(), resenas.get(i).getEstudiante().getFullName()});
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return modelo;

    }

}
