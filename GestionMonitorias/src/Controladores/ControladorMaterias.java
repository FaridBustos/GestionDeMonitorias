/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import modelos.Estudiante;
import modelos.Estudiante_Curso;
import modelos.Materia;
import modelos.Profesor;
import modelos.Universidad;

/**
 *
 * @author farid
 */
public class ControladorMaterias {

    private Universidad uni;

    public ControladorMaterias(Universidad uni) {
        this.uni = uni;
    }

    public void agregarMateria(int codigoMateria, int codigoMonitor, String nombre) {

        try {
            Estudiante es = uni.buscarEstudiante(codigoMonitor);
            if (es == null) {
                throw new Exception("El monitor no pudo ser encontrado");
            }

            boolean resul = uni.ingresarMateria(new Materia(nombre, codigoMateria, es));

            if (!resul) {
                throw new Exception("Ocurrio un problema al intentar crear la materia.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void eliminarMateria(int codigo) {
        try {
            boolean resul = uni.eliminarMateria(codigo);
            if (!resul) {
                throw new Exception("Ocurrio un problema al intentar eliminar la materia.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public TableModel mostrarMaterias() {
        //obtenemos las cuentas
        ArrayList<Materia> materias = uni.getMaterias();

        // Creamos un nuevo modelo de tabla
        DefaultTableModel modelo = new DefaultTableModel();

        //Definimos las columnas del nuevo modelo de tabla
        String ids[] = {"codigo", "nombre", "monitor", "tasa de mortalidad", "tasa de exito", "Ven por segunda vez", "asistencias a monitorias"};
        modelo.setColumnIdentifiers(ids);

        //Añadimos las filas al modelo de la tabla
        for (int i = 0; i < materias.size(); i++) {
            modelo.addRow(new Object[]{materias.get(i).getCodigo(), materias.get(i).getNombre(), materias.get(i).getMonitor().getFullName(), uni.tasaDeMortalidad(materias.get(i).getCodigo()), uni.tasaDeExito(materias.get(i).getCodigo()), uni.tasaDeRepitentes(materias.get(i).getCodigo()), uni.asistenciasUnicasAMonitorias(materias.get(i).getCodigo())});
        }

        //Retornamos el modelo de la tabla
        return modelo;

    }

    public TableModel mostrarEstudiantesEnMateria(int codigoMateria) {
        //obtenemos las cuentas
        ArrayList<Estudiante_Curso> estudiantes = uni.obtenerTodosLosEstudiantesDeUnaMateria(codigoMateria);

        // Creamos un nuevo modelo de tabla
        DefaultTableModel modelo = new DefaultTableModel();

        //Definimos las columnas del nuevo modelo de tabla
        String ids[] = {"codigo", "nombre", "Nota Final"};
        modelo.setColumnIdentifiers(ids);

        //Añadimos las filas al modelo de la tabla
        for (int i = 0; i < estudiantes.size(); i++) {
            modelo.addRow(new Object[]{estudiantes.get(i).getEstudiante().getCodigo(), estudiantes.get(i).getEstudiante().getFullName(), estudiantes.get(i).calcularNotaFinal()});
        }

        //Retornamos el modelo de la tabla
        return modelo;
    }

    public TableModel mostrarCaidos(int codigoMateria, int codigoProfesor) {
        ArrayList<Estudiante_Curso> estudiantes = new ArrayList<>();
        // Creamos un nuevo modelo de tabla
        DefaultTableModel modelo = new DefaultTableModel();

        //Definimos las columnas del nuevo modelo de tabla
        String ids[] = {"codigo", "nombre", "Nota Final"};
        modelo.setColumnIdentifiers(ids);

        try {
            Profesor p = uni.buscarProfesor(codigoProfesor);
            if (p == null) {
                throw new Exception("Profesor no existe");
            }

            estudiantes = p.estudiantesConBajoRendimiento(codigoMateria);

            //Añadimos las filas al modelo de la tabla
            for (int i = 0; i < estudiantes.size(); i++) {
                modelo.addRow(new Object[]{estudiantes.get(i).getEstudiante().getCodigo(), estudiantes.get(i).getEstudiante().getFullName(), estudiantes.get(i).calcularNotaFinal()});
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return modelo;
    }

}
