package isi.deso.tpdsw;

public class Plato extends ItemMenu implements Comparable<ItemMenu>{
    private static final double FACTOR_ENVASE = 1.1;
    private int calorias;
    private boolean aptoCeliaco;
    private float peso;
    
    @Override
    public String getId() {
        return id;
    }
    @Override
    public String getNombre() {
        return nombre;
    }
    @Override
    public String getDescripcion() {
        return descripcion;
    }
    @Override
    public float getPrecio() {
        return precio;
    }
    @Override
    public Categoria getCategoria() {
        return categoria;
    }
    @Override
    public boolean getAptoVegano() {
        return aptoVegano;
    }
    public int getCalorias() {
        return calorias;
    }

    public boolean getAptoCeliaco() {
        return aptoCeliaco;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }
    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @Override
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    @Override
    public void setPrecio(float precio) {
        this.precio = precio;
    }
    @Override
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    @Override
    public void setAptoVegano(boolean aptoVegano) {
        this.aptoVegano = aptoVegano;
    }
    
    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }

    public void setAptoCeliaco(boolean aptoCeliaco) {
        this.aptoCeliaco = aptoCeliaco;
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
    @Override
    public boolean aptoVegano(){
        return aptoVegano;
    }
    @Override
    public int compareTo(ItemMenu item) {
        return this.id.compareTo(item.getId());
    }
}
