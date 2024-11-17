/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

/**
 *
 * @author Casa Verano
 */
public interface gestionable<E> {
    public boolean add(E x);
    
    public boolean delete(int codigo);
    
    public E buscar(int codigo);
    
}
