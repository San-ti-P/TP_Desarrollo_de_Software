package isi.deso.tpdsw;

import java.util.Date;

public abstract class Pago {
    private Date fecha;
    private double monto;
    protected Pedido pedido;

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    
    public abstract double precioFinal();
    
}
