/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package isi.deso.tpdsw.Views;

/**
 *
 * @author santi
 */
public class PedidosJPanel extends BuscadorJPanel{
    
    public PedidosJPanel(){
        super(new String [] {
                "Cliente", "Vendedor", "Estado", "Acciones"
            });
        this.getBtnCrear().setText("Crear Nuevo Pedido");
        this.getTitleTextField().setText("Lista de Pedidos");
    }
    
}
