/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import modelos.Curso;
import modelos.Estudiante;
import modelos.Estudiante_Curso;
import modelos.Profesor;
import modelos.Universidad;

/**
 *
 * @author Casa Verano
 */
public class ControladorEstudianteCurso {

    private Universidad uni;

    public ControladorEstudianteCurso(Universidad uni) {
        this.uni = uni;
    }

    public void agregarEstudianteCurso(int codigoEstudiante, int codigoProfesor, int codigoMateria, int grupo, float nota1, float nota2, float nota3) {
        try {
            Profesor p = uni.buscarProfesor(codigoProfesor);
            Estudiante e = uni.buscarEstudiante(codigoEstudiante);

            if (p == null) {
                throw new Exception("no existe el profesor.");
            }

            if (e == null) {
                throw new Exception("no existe el estudiante.");
            }

            boolean res = p.buscarCurso(codigoMateria, grupo).add(new Estudiante_Curso(e, nota1, nota2, nota3, "activo"));
            if (!res) {
                throw new Exception("no se pudo anadir el estudiante al curso");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void eliminarEstudianteCurso(int codigoProfesor, int codigoMateria, int grupo, int codgioEstudiante) {
        try {
            Profesor P = uni.buscarProfesor(codigoProfesor);
            if (P == null) {
                throw new Exception("No se pudo encontrar al profesor");
            }

            Curso c = P.buscarCurso(codigoMateria, grupo);

            if (c == null) {
                throw new Exception("No se pudo encontrar el curso del profesor");
            }

            boolean res = c.delete(codgioEstudiante);

            if (!res) {
                throw new Exception("Error al eliminar el curso");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public TableModel mostrarEstudiantesCurso(int codigoProfesor, int codigoMateria, int grupo) {

        // Creamos un nuevo modelo de tabla
        DefaultTableModel modelo = new DefaultTableModel();
        
        //Definimos las columnas del nuevo modelo de tabla
        String ids[] = {"codigo", "nombre", "nota final", "Gano la materia"};
        
        modelo.setColumnIdentifiers(ids);
        
        try {
            //obtenemos al profesor
            Profesor p = uni.buscarProfesor(codigoProfesor);
            if (p == null) {
                throw new Exception("Profesor no encontrado.");
            }
            
           Curso c = p.buscarCurso(codigoMateria, grupo);
           if (c == null) {
                throw new Exception("Curso no encontrado.");
            }
           
           ArrayList<Estudiante_Curso> estudiantes = c.getEstudiantes();
           

            //Añadimos las filas al modelo de la tabla
            for (int i = 0; i < estudiantes.size(); i++) {
                modelo.addRow(new Object[]{estudiantes.get(i).getEstudiante().getCodigo(), estudiantes.get(i).getEstudiante().getFullName(), estudiantes.get(i).calcularNotaFinal(), estudiantes.get(i).ganoMateria()});
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return modelo;

    }

}
