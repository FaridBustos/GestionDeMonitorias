/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import modelos.Profesor;
import modelos.Universidad;

/**
 *
 * @author farid
 */
public class ControladorProfesores {

    private Universidad uni;

    public ControladorProfesores(Universidad uni) {
        this.uni = uni;
    }

    public void agregarProfesor(int codigo, String usuario, String contrasena, String nombre) {
        try {
            boolean resul = uni.ingresarUsuario(new Profesor(codigo, usuario, contrasena, "docente", nombre));
            if (!resul) {
                throw new Exception("Ocurrio un problema al intentar crear al profesor.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void eliminarProfesor(int codigo) {
        try {
            boolean resul = uni.eliminarProfesor(codigo);
            if (!resul) {
                throw new Exception("Ocurrio un problema al intentar eliminar el profesor.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public TableModel mostrarProfesores() {
        //obtenemos las cuentas
        ArrayList<Profesor> profesores = uni.obtenerProfesores();

        // Creamos un nuevo modelo de tabla
        DefaultTableModel modelo = new DefaultTableModel();

        //Definimos las columnas del nuevo modelo de tabla
        String ids[] = {"codigo", "nombre"};
        modelo.setColumnIdentifiers(ids);

        //Añadimos las filas al modelo de la tabla
        for (int i = 0; i < profesores.size(); i++) {
            modelo.addRow(new Object[]{profesores.get(i).getCodigo(), profesores.get(i).getFullName()});
        }

        //Retornamos el modelo de la tabla
        return modelo;
    }

}
