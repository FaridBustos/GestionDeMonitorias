/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import modelos.Estudiante;
import modelos.Universidad;

/**
 *
 * @author farid
 */
public class ControladorEstudiantes {

    private Universidad uni;

    public ControladorEstudiantes(Universidad uni) {
        this.uni = uni;
    }

    public void agregarEstudiante(int codigo, String usuario, String contrasena, String facultad, String programa, String nombre, String estado) {
        try {
            boolean resul = uni.ingresarUsuario(new Estudiante(codigo, facultad, programa, estado, usuario, contrasena, "estudiante", nombre));
            if (!resul) {
                throw new Exception("Ocurrio un problema al intentar crear el estudiante.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void eliminarEstudiante(int codigo) {
        try {
            boolean resul = uni.eliminarEstudiante(codigo);
            if (!resul) {
                throw new Exception("Ocurrio un problema al intentar eliminar el estudiante.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public TableModel mostrarEstudiantes() {
        //obtenemos las cuentas
        ArrayList<Estudiante> estudiantes = uni.obtenerEstudiantes();

        // Creamos un nuevo modelo de tabla
        DefaultTableModel modelo = new DefaultTableModel();

        //Definimos las columnas del nuevo modelo de tabla
        String ids[] = {"codigo", "nombre", "facultad", "programa", "estado"};
        modelo.setColumnIdentifiers(ids);

        //Añadimos las filas al modelo de la tabla
        for (int i = 0; i < estudiantes.size(); i++) {
            modelo.addRow(new Object[]{estudiantes.get(i).getCodigo(), estudiantes.get(i).getFullName(), estudiantes.get(i).getFacultad(), estudiantes.get(i).getPrograma(), estudiantes.get(i).getEstado()});
        }

        //Retornamos el modelo de la tabla
        return modelo;
    }

}
