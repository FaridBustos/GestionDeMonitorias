/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import modelos.Curso;
import modelos.Materia;
import modelos.Profesor;
import modelos.Universidad;

/**
 *
 * @author farid
 */
public class ControladorCursos {

    private Universidad uni;

    public ControladorCursos(Universidad uni) {
        this.uni = uni;
    }

    public void agregarCurso(int codigoMateria, int codigoProfesor, int grupo) {
        try {
            Profesor p = uni.buscarProfesor(codigoProfesor);
            Materia m = uni.buscarMateria(grupo);
            if (p == null) {
                throw new Exception("no existe el profesor.");
            }
            if (m == null) {
                throw new Exception("no existe la materia.");
            }

            boolean res = p.agregarCurso(new Curso(m, grupo));
            if (!res) {
                throw new Exception("no se pudo anadir el curso");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void eliminarCurso(int codigoProfesor, int codigoMateria, int grupo) {
        try {
            Profesor P = uni.buscarProfesor(codigoProfesor);
            if (P == null) {
                throw new Exception("No se pudo encontrar al profesor");
            }
            boolean res = P.eliminarCurso(codigoMateria, grupo);
            if (!res) {
                throw new Exception("Error al eliminar el curso");
            }
        } catch (Exception e) {
        }
    }

    public TableModel mostrarCursos(int codigoProfesor) {
// Creamos un nuevo modelo de tabla
        DefaultTableModel modelo = new DefaultTableModel();
        //Definimos las columnas del nuevo modelo de tabla
        String ids[] = {"Materia", "Grupo"};
        modelo.setColumnIdentifiers(ids);
        try {
            //obtenemos al profesor
            Profesor p = uni.buscarProfesor(codigoProfesor);
            ArrayList<Curso> cursos = new ArrayList<>();

            //obtenemos las cuentas
            if (p != null) {
                cursos = p.getCursos();
            } else {
                throw new Exception("materia no existe");
            }

            //Añadimos las filas al modelo de la tabla
            for (int i = 0; i < cursos.size(); i++) {
                modelo.addRow(new Object[]{cursos.get(i).getMateria().getNombre(), cursos.get(i).getGrupo()});
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return modelo;
    }

}
