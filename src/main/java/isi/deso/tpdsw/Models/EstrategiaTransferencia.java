package isi.deso.tpdsw.Models;

public class EstrategiaTransferencia implements EstrategiaDePago {
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
    public double precioFinal(double monto){
        return monto*RECARGO;
    }
}