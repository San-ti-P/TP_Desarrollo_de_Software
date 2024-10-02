package isi.deso.tpdsw;

public class Transferencia extends Pago {
    private String cuit;
    private String cbu;
    private static final double RECARGO = 1.02;
    
    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getCbu() {
        return cbu;
    }

    public void setCbu(String cbu) {
        this.cbu = cbu;
    }
    
    @Override
    public double precioFinal() {
        this.setMonto(pedido.getPrecio() * RECARGO);
        return this.getMonto();
    }
}