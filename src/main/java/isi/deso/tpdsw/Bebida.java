package isi.deso.tpdsw;

/**
 *
 * @author santi
 */
public class Bebida extends ItemMenu{

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
            return (float)(tamaño*0.99*1.2);
        }
        else{
            return (float)(tamaño*1.04*1.2);
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
    //public boolean aptoVegano();
    
    public boolean esAlcoholica(){
        if(graduacionAlcoholica>0){
            return true;
        }
        else{
            return false;
        }
    }
}
