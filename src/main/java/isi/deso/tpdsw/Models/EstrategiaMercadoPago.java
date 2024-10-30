package isi.deso.tpdsw.Models;

public class EstrategiaMercadoPago implements EstrategiaDePago{
    private String alias;
    private static final double RECARGO = 1.04;

    public String getAlias() {
        return alias;
    }
    public void setAlias(String alias) {
        this.alias = alias;
    }
    
    @Override
    public double precioFinal(double monto) {
        return monto*RECARGO;
    }
}