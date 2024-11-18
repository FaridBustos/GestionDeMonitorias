/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import modelos.Universidad;

/**
 *
 * @author farid
 */
public class ControladorLogin {

    private Universidad uni;

    public ControladorLogin(Universidad uni) {
        this.uni = uni;
    }

    public boolean iniciarSesion(String usuario, String contrasena) {
        for (int i = 0; i < uni.getUsuarios().size(); i++) {
            if (uni.getUsuarios().get(i).getUsername().equalsIgnoreCase(usuario)) {
                if (uni.getUsuarios().get(i).getPassword().equalsIgnoreCase(contrasena)) {
                    uni.setUsuarioActual(uni.getUsuarios().get(i));
                    return true;
                }
            }
        }
        return false;
    }

    private void buscar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
