/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import modelos.Fecha;
import modelos.Hora;
import modelos.Materia;
import modelos.Monitoria;
import modelos.Universidad;

/**
 *
 * @author farid
 */
public class ControladorMonitorias {

    private Universidad uni;

    public ControladorMonitorias(Universidad uni) {
        this.uni = uni;
    }

    public void agregarMonitoria(int codigoMateria, Monitoria x) {

        try {
            Materia m = uni.obtenerMateria(codigoMateria);
            if (m == null) {
                throw new Exception("La materia no existe");
            }
            boolean res = m.add(x);
            if (!res) {
                throw new Exception("no se pudo agregar la monitoria a la materia");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void eliminarMonitoria(int codigoMateria, int codigoMonitoria) {
        try {
            Materia m = uni.buscarMateria(codigoMateria);
            if (m == null) {
                throw new Exception("Materia no encontrada");
            }
            boolean res = m.delete(codigoMonitoria);
            if (!res) {
                throw new Exception("no se pudo eliminar la monitoria");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public TableModel mostrarMonitorias(int codigoMateria) {
// Creamos un nuevo modelo de tabla
        DefaultTableModel modelo = new DefaultTableModel();
        //Definimos las columnas del nuevo modelo de tabla
        String ids[] = {"fecha", "hora de inicio", "hora de fin", "tema"};
        modelo.setColumnIdentifiers(ids);
        try {
            //obtenemos al profesor
            Materia m = uni.buscarMateria(codigoMateria);
            ArrayList<Monitoria> monitorias = new ArrayList<>();

            //obtenemos las cuentas
            if (m != null) {
                monitorias = m.getMonitorias();
            } else {
                throw new Exception("materia no existe");
            }

            //Añadimos las filas al modelo de la tabla
            for (int i = 0; i < monitorias.size(); i++) {
                Fecha f = monitorias.get(i).getFecha();
                Hora hi = monitorias.get(i).getHoraInicio();
                Hora hf = monitorias.get(i).getHoraFin();
                String fecha = f.getDia() + "-" + f.getMes() + "-" + f.getAnio();
                String Horai = hi.getHora() + "-" + hi.getMinuto();
                String Horaf = hi.getHora() + "-" + hi.getMinuto();
                modelo.addRow(new Object[]{fecha, Horai, Horaf, monitorias.get(i).getTema()});
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return modelo;
    }

}
