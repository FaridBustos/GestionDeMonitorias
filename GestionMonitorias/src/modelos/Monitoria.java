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
public class Monitoria {
    private ArrayList<Estudiante> asistencias;
    private ArrayList<Object> resenas;
    private Fecha fecha;
    private Hora horaInicio;
    private Hora horaFin;

    public Monitoria(Fecha fecha, Hora horaInicio, Hora horaFin) {
        this.asistencias = new ArrayList<>();
        this.resenas = new ArrayList<>();
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    /**
     * @return the asistencias
     */
    public ArrayList<Estudiante> getAsistencias() {
        return asistencias;
    }

    /**
     * @param asistencias the asistencias to set
     */
    public void setAsistencias(ArrayList<Estudiante> asistencias) {
        this.asistencias = asistencias;
    }

    /**
     * @return the resenas
     */
    public ArrayList<Object> getResenas() {
        return resenas;
    }

    /**
     * @param resenas the resenas to set
     */
    public void setResenas(ArrayList<Object> resenas) {
        this.resenas = resenas;
    }

    /**
     * @return the fecha
     */
    public Fecha getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the horaInicio
     */
    public Hora getHoraInicio() {
        return horaInicio;
    }

    /**
     * @param horaInicio the horaInicio to set
     */
    public void setHoraInicio(Hora horaInicio) {
        this.horaInicio = horaInicio;
    }

    /**
     * @return the horaFin
     */
    public Hora getHoraFin() {
        return horaFin;
    }

    /**
     * @param horaFin the horaFin to set
     */
    public void setHoraFin(Hora horaFin) {
        this.horaFin = horaFin;
    }
    
    
}
