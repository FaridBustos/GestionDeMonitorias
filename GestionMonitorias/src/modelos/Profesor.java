/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.util.ArrayList;

/**
 *
 * @author Casa Verano
 */
public class Profesor extends Usuario{
    private int codigo;
    private ArrayList<Curso> cursos;
    private ArrayList<RProfesor> resenas;

    public Profesor(int codigo, String username, String password, String role, String fullName) {
        super(username, password, role, fullName);
        this.codigo = codigo;
        this.cursos = new ArrayList<>();
        this.resenas = new ArrayList<>();
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the cursos
     */
    public ArrayList<Curso> getCursos() {
        return cursos;
    }

    /**
     * @return the resemas
     */
    public ArrayList<RProfesor> getResenas() {
        return resenas;
    }
    
    
    
   
    
}
