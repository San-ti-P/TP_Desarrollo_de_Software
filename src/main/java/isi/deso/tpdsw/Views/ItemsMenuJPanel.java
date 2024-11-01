/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package isi.deso.tpdsw.Views;

/**
 *
 * @author santi
 */
public class ItemsMenuJPanel extends BuscadorJPanel{
    
    public ItemsMenuJPanel(){
        super(new String [] {
                "Nombre", "Descripcion", "Precio", "Categoria", "AptoVegano", "Acciones"
            });
        this.getBtnCrear().setText("Crear Nuevo ItemMenu");
        this.getTitleTextField().setText("Lista de ItemsMenu");
    }
    
}
