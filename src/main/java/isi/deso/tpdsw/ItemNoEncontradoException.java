/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package isi.deso.tpdsw;

/**
 *
 * @author santi
 */
public class ItemNoEncontradoException extends Exception{
    String mensaje;
    public ItemNoEncontradoException(String m){
        this.mensaje=m;
        //System.out.println(mensaje);
    }
    
}
