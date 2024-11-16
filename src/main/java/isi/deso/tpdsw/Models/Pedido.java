package isi.deso.tpdsw.Models;

import isi.deso.tpdsw.Services.Observable;
import isi.deso.tpdsw.Services.PedidoObserver;
import isi.deso.tpdsw.Services.VendedoresDistintosException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Pedido implements Observable, Comparable<Pedido> {

    private int id;
    private Cliente cliente;
    private ArrayList<ItemPedido> items;
    private Vendedor vendedor; 
    private Pago pago;
    private EstadoPedido estado;
    private double precio = 0;
    private ArrayList<PedidoObserver> observadores = new ArrayList<>();

    public Pedido(int id, Cliente cliente, ArrayList<ItemPedido> items, Vendedor vendedor, EstadoPedido estado) {
        this.id = id;
        this.cliente = cliente;
        this.items = items;
        this.vendedor = vendedor;
        this.estado = estado;
        this.calcularPrecio();
    }
   
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
    
    public int getId() {
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
    
    public void setId(int id) {
        this.id = id;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public void setItems(ArrayList<ItemPedido> items) throws VendedoresDistintosException {
        if (validarVendedorUnico(items)) {
           this.items = items;
           this.calcularPrecio();
       }
       else {
           throw new VendedoresDistintosException("No hay unicidad de vendedores");
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
    
    @Override
    public void addObserver(PedidoObserver o){
        this.observadores.add(o);
    }
    
    @Override
    public void removeObserver(PedidoObserver o){
        this.observadores.remove(o); 
    }
    
    @Override
    public void notifyObservers(){
        Iterator<PedidoObserver> i = observadores.iterator();
        while(i.hasNext()){
            i.next().update(this); 
        }
    }
    
    @Override
    public int compareTo(Pedido p) {
        return this.id - p.getId();
    }
    
    @Override
    public boolean equals(Object o){
        Pedido otro = (Pedido) o;
        return id == otro.getId();
    }
}