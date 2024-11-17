/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import interfaces.gestionable;
import java.util.ArrayList;

/**
 *
 * @author Casa Verano
 */
public class Curso implements gestionable<Estudiante_Curso> {
    private Materia materia;
    private int grupo;
    private Profesor profesor;
    private ArrayList<Estudiante_Curso> estudiantes;

    public Curso(Materia materia, int grupo, Profesor profesor) {
        this.materia = materia;
        this.grupo = grupo;
        this.profesor = profesor;
        this.estudiantes = new ArrayList<>();
    }
    
    

    @Override
    public boolean add(Estudiante_Curso x) {
        return estudiantes.add(x);
    }

    @Override
    public boolean delete(int codigo) {
        Estudiante_Curso x = buscar(codigo);
        if(x != null){
            return estudiantes.remove(x);
        }else{
            return false;
        }
    }

    @Override
    public Estudiante_Curso buscar(int codigo) {
        for (int i = 0; i < estudiantes.size(); i++) {
            if(estudiantes.get(i).getEstudiante().getCodigo() == codigo){
                return estudiantes.get(i);
            }
        }
        return null;
    }

    /**
     * @return the materia
     */
    public Materia getMateria() {
        return materia;
    }

    /**
     * @param materia the materia to set
     */
    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    /**
     * @return the grupo
     */
    public int getGrupo() {
        return grupo;
    }

    /**
     * @param grupo the grupo to set
     */
    public void setGrupo(int grupo) {
        this.grupo = grupo;
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

    /**
     * @return the estudiantes
     */
    public ArrayList<Estudiante_Curso> getEstudiantes() {
        return estudiantes;
    }
    
    
    
}
