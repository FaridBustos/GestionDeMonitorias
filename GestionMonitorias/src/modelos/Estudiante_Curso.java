/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author Casa Verano
 */
public class Estudiante_Curso {

    private Estudiante estudiante;
    private float nota1;
    private float nota2;
    private float nota3;
    private String estado;

    public Estudiante_Curso(Estudiante estudiante, float nota1, float nota2, float nota3, String estado) {
        this.estudiante = estudiante;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        this.estado = estado;
    }

    public float calcularNotaFinal() {
        return (getNota1() + getNota2() + getNota3()) / 3;
    }

    public boolean ganoMateria() {
        return calcularNotaFinal() >= 300;
    }

    /**
     * @return the estudiante
     */
    public Estudiante getEstudiante() {
        return estudiante;
    }

    /**
     * @param estudiante the estudiante to set
     */
    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    /**
     * @return the nota1
     */
    public float getNota1() {
        return nota1;
    }

    /**
     * @param nota1 the nota1 to set
     */
    public void setNota1(float nota1) {
        this.nota1 = nota1;
    }

    /**
     * @return the nota2
     */
    public float getNota2() {
        return nota2;
    }

    /**
     * @param nota2 the nota2 to set
     */
    public void setNota2(float nota2) {
        this.nota2 = nota2;
    }

    /**
     * @return the nota3
     */
    public float getNota3() {
        return nota3;
    }

    /**
     * @param nota3 the nota3 to set
     */
    public void setNota3(float nota3) {
        this.nota3 = nota3;
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

    public boolean estudianteRetiro() {
        return this.estado.equalsIgnoreCase("retirado");
    }

    public boolean estudianteActivo() {
        return this.estado.equalsIgnoreCase("activo");
    }
}
