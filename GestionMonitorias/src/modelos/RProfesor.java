/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author Casa Verano
 */
public class RProfesor extends Resena {

    private Profesor profesor;

    public RProfesor(int codigo, Profesor profesor, String descripcion, float puntaje, Estudiante estudiante) {
        super(codigo, descripcion, puntaje, estudiante);
        this.profesor = profesor;
    }

    /**
     * @return the profesor
     */
    public Profesor getProfesor() {
        return profesor;
    }

    /**
     * @param profesor the profesor to set
     */
    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

}
