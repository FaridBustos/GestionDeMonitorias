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
public class Materia implements gestionable<Monitoria> {

    private String nombre;
    private int codigo;
    private Estudiante monitor;
    private ArrayList<Monitoria> monitorias;

    public Materia(String nombre, int codigo, Estudiante monitor) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.monitor = monitor;
        this.monitorias = new ArrayList<>();
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
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
     * @return the monitor
     */
    public Estudiante getMonitor() {
        return monitor;
    }

    /**
     * @param monitor the monitor to set
     */
    public void setMonitor(Estudiante monitor) {
        this.monitor = monitor;
    }

    /**
     * @return the monitorias
     */
    public ArrayList<Monitoria> getMonitorias() {
        return monitorias;
    }

    //historia 20
    @Override
    public boolean add(Monitoria x) {
        return monitorias.add(x);
    }

    @Override
    public boolean delete(int codigo) {
        Monitoria mon = buscar(codigo);
        if (mon != null) {
            return monitorias.remove(mon);
        }
        return false;
    }

    @Override
    public Monitoria buscar(int codigo) {
        for (int i = 0; i < monitorias.size(); i++) {
            if (monitorias.get(i).getCodigo() == codigo) {
                return monitorias.get(i);
            }
        }
        return null;
    }
}
