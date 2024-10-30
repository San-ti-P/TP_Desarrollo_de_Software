package isi.deso.tpdsw.Models;

import isi.deso.tpdsw.Controllers.PedidoObserver;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Cliente implements PedidoObserver {
    private int id;
    private String nombre;
    private String cuit;
    private String email;
    private String direccion;
    private Coordenada coordenadas;
    private ArrayList<Pedido> pedidos; 
    
    public Cliente(){
        this.pedidos = new ArrayList<Pedido>(); 
    }
    
    public void agregarPedido(Pedido pedido){
        pedidos.add(pedido);
    }
    
    public void eliminarPedido(Pedido pedido){
        pedidos.remove(pedido);
    }
    
    public int getId() {
        return id;
    }

    public String getNombre(){
        return nombre;
    }
    
    public String getCuit() {
        return cuit;
    }
    
    public String getEmail() {
        return email;
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

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setCoordenadas(Coordenada coordenadas) {
        this.coordenadas = coordenadas;
    }
    
    @Override
    public void update(Pedido p){
        if(p.getEstado() == EstadoPedido.EN_ENVIO){
        
            Scanner scanner = new Scanner(System.in); 
            System.out.println("Cliente 1: Como le gustaria pagar?: ");
            System.out.println("Las opciones son: TRANSFERENCIA (2% de recargo), MERCADOPAGO (4% de recargo)");
            String entradaMetodoPago = scanner.nextLine().toLowerCase().strip();
            EstrategiaDePago e; 
            
            if (entradaMetodoPago.equalsIgnoreCase("transferencia")) {
                EstrategiaTransferencia transferencia = new EstrategiaTransferencia(); 
                System.out.println("Ingrese cuit: ");
                String entradaCuit = scanner.nextLine().toLowerCase().strip();
                System.out.println("Ingrese cbu: ");
                String entradaCbu= scanner.nextLine().toLowerCase().strip();
                transferencia.setCuit(entradaCuit);
                transferencia.setCbu(entradaCbu); 
                e = transferencia;
            }
            else if (entradaMetodoPago.equalsIgnoreCase("mercadopago")) {
                EstrategiaMercadoPago mp = new EstrategiaMercadoPago(); 
                System.out.println("Ingrese alias: ");
                String entradaAlias = scanner.nextLine().toLowerCase().strip();
                mp.setAlias(entradaAlias);
                e = mp; 
            }
            else {
                System.out.println("error todo mal loco");
                return; 
            }
            Pago pago = new Pago(new Date(), p, e);
            p.setPago(pago);
        }
    }
}
