/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author Casa Verano
 */
public class Estudiante extends Usuario{
    private int codigo;
    private String facultad;
    private String programa;
    private String estado;

    public Estudiante(int codigo, String facultad, String programa, String estado, String username, String password, String role, String fullName) {
        super(username, password, role, fullName);
        this.codigo = codigo;
        this.facultad = facultad;
        this.programa = programa;
        this.estado = estado;
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
     * @return the facultad
     */
    public String getFacultad() {
        return facultad;
    }

    /**
     * @param facultad the facultad to set
     */
    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    /**
     * @return the programa
     */
    public String getPrograma() {
        return programa;
    }

    /**
     * @param programa the programa to set
     */
    public void setPrograma(String programa) {
        this.programa = programa;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }
         
    
    
}
