package isi.deso.tpdsw;

/**
 *
 * @author santi
 */
public class Bebida extends ItemMenu{
    private static final double FACTOR_ALCOHOLICA = 0.99;
    private static final double FACTOR_ANALCOHOLICA = 1.04;
    private static final double FACTOR_ENVASE = 1.2;
    
    private float graduacionAlcoholica;
    private int tamaño;
    
    public Bebida(String id, String nombre, String descripcion, float precio, Categoria categoria, float graduacion, int tam){
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.categoria = categoria;
        graduacionAlcoholica = graduacion;
        tamaño = tam;
    }
    
    public float getGraduacionAlcoholica() {
        return graduacionAlcoholica;
    }

    public void setGraduacionAlcoholica(float graduacionAlcoholica) {
        this.graduacionAlcoholica = graduacionAlcoholica;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }
    
    @Override
    public float peso(){
        if(this.esAlcoholica()){
            return (float)(tamaño*FACTOR_ALCOHOLICA*FACTOR_ENVASE);
        }
        else{
            return (float)(tamaño*FACTOR_ANALCOHOLICA*FACTOR_ENVASE);
        }
    }
    @Override
    public boolean esComida(){
        return false;
    }
    @Override
    public boolean esBebida(){
        return true;
    }
    public boolean aptoVegano(){
        return false;
    };
    
    public boolean esAlcoholica(){
        if(graduacionAlcoholica>0){
            return true;
        }
        else{
            return false;
        }
    }
}
