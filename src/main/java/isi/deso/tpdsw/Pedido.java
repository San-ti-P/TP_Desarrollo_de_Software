package isi.deso.tpdsw;

import java.util.ArrayList;
import java.util.HashSet;

public class Pedido {

    private String id;
    private Cliente cliente;
    private ArrayList<ItemPedido> items;
    private Vendedor vendedor; 
    private Pago pago;
    private EstadoPedido estado;
    private double precio = 0;

    public double getPrecio() {
        return precio;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }
    
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
    
    public void setItems(ArrayList<ItemPedido> items) throws VendedoresDistintos {
        if (validarVendedorUnico(items)) {
           this.items = items;
           this.calcularPrecio();
       }
       else {
           throw new VendedoresDistintos("No hay unicidad de vendedores");
       }   
    }        
    
    private boolean validarVendedorUnico(ArrayList<ItemPedido> items) {
        HashSet<Vendedor> vendedores = new HashSet<>();
        for (ItemPedido item : items) {
            vendedores.add(item.getItem().getVendedor());
        }
        return vendedores.size() == 1;
    }
    
    public void setVendedor(Vendedor vendedor){
        this.vendedor = vendedor;
    }
    
    private void calcularPrecio() {
        for (ItemPedido item : this.items) {
            this.precio = this.precio + (item.getItem().getPrecio() * item.getCantidad());
        }
    }
    
    @Override
    public String toString() {
        return "Pedido{" + "id=" + id + ", cliente=" + cliente.getNombre() + ", items=" + items + ", vendedor=" + vendedor.getNombre() + '}';
    }
}