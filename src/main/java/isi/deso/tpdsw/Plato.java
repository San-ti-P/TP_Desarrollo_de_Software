package isi.deso.tpdsw;

public class Plato extends ItemMenu{
    private static final double FACTOR_ENVASE = 1.1;
    private int calorias;
    private boolean aptoCeliaco;
    private boolean aptoVegano;
    private float peso;
    
    public int getCalorias() {
        return calorias;
    }

    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }

    public boolean getAptoCeliaco() {
        return aptoCeliaco;
    }

    public void setAptoCeliaco(boolean aptoCeliaco) {
        this.aptoCeliaco = aptoCeliaco;
    }

    public boolean getAptoVegano() {
        return aptoVegano;
    }

    public void setAptoVegetariano(boolean aptoVegetariano) {
        this.aptoVegano = aptoVegetariano;
    }
    
    @Override
    public float peso(){
        return (float)(peso*FACTOR_ENVASE);
    }
    @Override
    public boolean esComida(){
        return true;
    }
    @Override
    public boolean esBebida(){
        return false;
    }
    
    public boolean aptoVegano(){
        return aptoVegano;
    }
}
