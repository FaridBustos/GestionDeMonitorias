/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import interfaces.gestionable;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Casa Verano
 */
public class Curso implements gestionable<Estudiante_Curso>, Serializable {

    private Materia materia;
    private int grupo;
    private ArrayList<Estudiante_Curso> estudiantes;

    public Curso(Materia materia, int grupo) {
        this.materia = materia;
        this.grupo = grupo;
        this.estudiantes = new ArrayList<>();
    }

    @Override
    public boolean add(Estudiante_Curso x) {
        return estudiantes.add(x);
    }

    @Override
    public boolean delete(int codigoEstudiante) {
        Estudiante_Curso x = buscar(codigoEstudiante);
        if (x != null) {
            return estudiantes.remove(x);
        } else {
            return false;
        }
    }

    @Override
    public Estudiante_Curso buscar(int codigoEstudiante) {
        for (int i = 0; i < estudiantes.size(); i++) {
            if (estudiantes.get(i).getEstudiante().getCodigo() == codigoEstudiante) {
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
     * @return the estudiantes
     */
    public ArrayList<Estudiante_Curso> getEstudiantes() {
        return estudiantes;
    }

}
