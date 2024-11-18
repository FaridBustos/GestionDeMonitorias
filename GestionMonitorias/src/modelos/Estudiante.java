/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Casa Verano
 */
public class Estudiante extends Usuario implements Serializable {

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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + this.codigo;
        hash = 47 * hash + Objects.hashCode(this.facultad);
        hash = 47 * hash + Objects.hashCode(this.programa);
        hash = 47 * hash + Objects.hashCode(this.estado);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Estudiante other = (Estudiante) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (!Objects.equals(this.facultad, other.facultad)) {
            return false;
        }
        if (!Objects.equals(this.programa, other.programa)) {
            return false;
        }
        return Objects.equals(this.estado, other.estado);
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
