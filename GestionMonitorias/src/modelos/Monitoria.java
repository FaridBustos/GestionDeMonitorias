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

    public Monitoria(int codigo, Fecha fecha, Hora horaInicio, Hora horaFin) {
        this.codigo = codigo;
        this.asistencias = new ArrayList<>();
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
        return asistencias.add(x);
    }

    @Override
    public boolean delete(int codigo) {
        Estudiante es = buscar(codigo);
        if (es != null) {
            return asistencias.remove(es);
        }
        return false;
    }

    @Override
    public Estudiante buscar(int codigo) {
        for (int i = 0; i < asistencias.size(); i++) {
            if (asistencias.get(i).getCodigo() == codigo) {
                return asistencias.get(i);
            }
        }
        return null;
    }

}
