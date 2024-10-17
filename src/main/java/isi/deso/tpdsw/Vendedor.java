package isi.deso.tpdsw;

import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Iterator;

public class Vendedor {
    final static private double RADIOTIERRA = 6378.0;
    private int id;
    private String nombre;
    private String direccion;
    private Coordenada coordenadas;
    private TreeSet<ItemMenu> menu;
    private TreeSet<Pedido> pedidos;

    public Vendedor(){
        menu = new TreeSet<ItemMenu>();
        pedidos = new TreeSet<Pedido>();
    }
    
    public int getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public Coordenada getCoordenadas() {
        return coordenadas;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setCoordenadas(Coordenada coordenadas) {
        this.coordenadas = coordenadas;
    }
    
    private static double semiverseno(double angulo){
        return Math.pow(Math.sin(angulo/((double)2)), 2);
    }
    
    public double distancia(Cliente cliente){
        double latCliente = Math.toRadians(cliente.getCoordenadas().getLat());
        double lngCliente = Math.toRadians(cliente.getCoordenadas().getLng());
        double latVendedor = Math.toRadians(coordenadas.getLat());
        double lngVendedor = Math.toRadians(coordenadas.getLng());
        return 2*RADIOTIERRA*Math.asin(Math.sqrt(Vendedor.semiverseno(latCliente-latVendedor)+Math.cos(latCliente)*Math.cos(latVendedor)*Vendedor.semiverseno(lngCliente-lngVendedor)));
    }
    
    public void agregarItemMenu(ItemMenu item){
        menu.add(item);
    }
    
    public void eliminarItemMenu(ItemMenu item){
        menu.remove(item);
    }
    
    public void agregarPedido(Pedido pedido){
        pedidos.add(pedido);
    }
    
    public void eliminarPedido(Pedido pedido){
        pedidos.remove(pedido);
    }
    
    public ArrayList<Bebida> listaBebidas(){
        Iterator<ItemMenu> i = menu.iterator();
        ArrayList<Bebida> bebidas = new ArrayList<Bebida>();
        while(i.hasNext()){
            ItemMenu item = i.next();
            if(item.esBebida()){
                bebidas.add((Bebida)item);
            }
        }
        return bebidas;
    }
    
    public ArrayList<Bebida> listaBebidasSinAlcohol(){
        Iterator<ItemMenu> i = menu.iterator();
        ArrayList<Bebida> bebidas = new ArrayList<Bebida>();
        while(i.hasNext()){
            ItemMenu item = i.next();
            if(item.esBebida()){
                Bebida bebida = (Bebida)item;
                if(!bebida.esAlcoholica()){
                    bebidas.add(bebida);
                }
            }
        }
        return bebidas;
    }
    
    public ArrayList<Plato> listaComidas(){
        Iterator<ItemMenu> i = menu.iterator();
        ArrayList<Plato> platos = new ArrayList<Plato>();
        while(i.hasNext()){
            ItemMenu item = i.next();
            if(item.esComida()){
                platos.add((Plato)item);
            }
        }
        return platos;
    }
    
    public ArrayList<Plato> listaComidasVeganas(){
        Iterator<ItemMenu> i = menu.iterator();
        ArrayList<Plato> platos = new ArrayList<Plato>();
        while(i.hasNext()){
            ItemMenu item = i.next();
            if(item.esComida()){
                Plato plato = (Plato)item;
                if(plato.aptoVegano()){
                    platos.add(plato);
                }
            }
        }
        return platos;
    }
    public ArrayList<Pedido> pedidosPorEstado(EstadoPedido estado){
        Iterator<Pedido> i = pedidos.iterator();
        ArrayList<Pedido> subPedidos = new ArrayList<Pedido>();
        while(i.hasNext()){
            Pedido p = i.next();
            if (p.getEstado() == estado){
                subPedidos.add(p);
            }
        }
        return subPedidos;
    }
}

