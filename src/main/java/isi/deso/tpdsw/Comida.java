package isi.deso.tpdsw;

/**
 *
 * @author santi
 */
public class Comida extends ItemMenu{
    private int calorias;
    private boolean aptoCeliaco;
    private boolean aptoVegetariano;
    private float peso;
    
    public int getCalorias() {
        return calorias;
    }

    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }

    public boolean isAptoCeliaco() {
        return aptoCeliaco;
    }

    public void setAptoCeliaco(boolean aptoCeliaco) {
        this.aptoCeliaco = aptoCeliaco;
    }

    public boolean isAptoVegetariano() {
        return aptoVegetariano;
    }

    public void setAptoVegetariano(boolean aptoVegetariano) {
        this.aptoVegetariano = aptoVegetariano;
    }
    
    @Override
    public float peso(){
        return (float)(peso*1.1);
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
        return aptoVegetariano;
    }
}
