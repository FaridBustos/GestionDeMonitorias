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
public class Monitoria implements gestionable<Estudiante> {

    private int codigo;
    private ArrayList<Estudiante> asistencias;
    private Fecha fecha;
    private Hora horaInicio;
    private Hora horaFin;
    private String tema;

    public Monitoria(int codigo, Fecha fecha, Hora horaInicio, Hora horaFin, String tema) {
        this.codigo = codigo;
        this.asistencias = new ArrayList<>();
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.tema = tema;
    }

    /**
     * @return the asistencias
     */
    public ArrayList<Estudiante> getAsistencias() {
        return asistencias;
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

    // historia 19
    @Override
    public boolean add(Estudiante x) {
        return getAsistencias().add(x);
    }

    @Override
    public boolean delete(int codigo) {
        Estudiante es = buscar(codigo);
        if (es != null) {
            return getAsistencias().remove(es);
        }
        return false;
    }

    @Override
    public Estudiante buscar(int codigo) {
        for (int i = 0; i < getAsistencias().size(); i++) {
            if (getAsistencias().get(i).getCodigo() == codigo) {
                return getAsistencias().get(i);
            }
        }
        return null;
    }

    /**
     * @param asistencias the asistencias to set
     */
    public void setAsistencias(ArrayList<Estudiante> asistencias) {
        this.asistencias = asistencias;
    }

    /**
     * @return the tema
     */
    public String getTema() {
        return tema;
    }

    /**
     * @param tema the tema to set
     */
    public void setTema(String tema) {
        this.tema = tema;
    }

}
