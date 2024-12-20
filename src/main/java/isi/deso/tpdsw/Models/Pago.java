package isi.deso.tpdsw.Models;

import java.util.Date;

public class Pago {
    private Date fecha;
    private double montoFinal;
    private Pedido pedido;
    private EstrategiaDePago estrategia;

    public Pago(){ }
    
    public Pago(Date fecha, Pedido pedido, EstrategiaDePago estrategia){
        this.fecha = fecha;
        this.estrategia = estrategia;
        this.setPedido(pedido);
    }
    
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getMontoFinal() {
        return montoFinal;
    }
 
    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
        this.montoFinal = estrategia.precioFinal(pedido.getPrecio());
    }
    
    public EstrategiaDePago getEstrategia() {
        return estrategia;
    }

    public void setEstrategia(EstrategiaDePago estrategia) {
        this.estrategia = estrategia;
    }
    
}
