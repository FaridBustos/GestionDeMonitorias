/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Archivos;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import modelos.Universidad;

/**
 *
 * @author farid
 */
public class ArchivoUniversidad {

    public void guardar(Universidad uni) {
        try {
            ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("universidad.obj"));
            salida.writeObject(uni);
            salida.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public Universidad recuperar() {
        Universidad uni = null;
        try {
            ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("universidad.obj"));
            uni = (Universidad) entrada.readObject();
            entrada.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return uni;

    }

}
