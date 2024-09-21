package isi.deso.tpdsw;

import java.util.ArrayList;

public class Pedido {

    private String id;
    private Cliente cliente;
    private ArrayList<ItemPedido> items;
    private Vendedor vendedor;
    
    public String getId() {
        return id;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public ArrayList<ItemPedido> getItems() {
        return items;
    }
    public Vendedor getVendedor(){
        return vendedor;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public void setItems(ArrayList<ItemPedido> items) {
        this.items = items;
    }
    public void setVendedor(Vendedor vendedor){
        this.vendedor = vendedor;
    }

    @Override
    public String toString() {
        return "Pedido{" + "id=" + id + ", cliente=" + cliente.getNombre() + ", items=" + items + ", vendedor=" + vendedor.getNombre() + '}';
    }
}
