package isi.deso.tpdsw;

public class MercadoPago extends Pago{
    private String alias;
    private static final double RECARGO = 1.04;
    
    @Override
    public double precioFinal() {
        this.setMonto(pedido.getPrecio() * RECARGO);
        return this.getMonto();
    }
}