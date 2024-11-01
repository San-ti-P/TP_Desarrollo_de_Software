/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package isi.deso.tpdsw.Views;

/**
 *
 * @author santi
 */
public class ClientesJPanel extends BuscadorJPanel{
    
    public ClientesJPanel(){
        super(new String [] {
                "Nombre", "Dirección", "Cuit", "Direccion", "Pedidos", "Acciones"
            });
        this.getBtnCrear().setText("Crear Nuevo Cliente");
        this.getTitleTextField().setText("Lista de Clientes");
    }
    
}
