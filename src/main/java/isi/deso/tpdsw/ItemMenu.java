package isi.deso.tpdsw;

public abstract class ItemMenu {

    protected String id;
    protected String nombre;
    protected String descripcion;
    protected float precio;
    protected Categoria categoria;
    protected boolean aptoVegano;
    protected Vendedor vendedor;
    
    public abstract float peso();
    public abstract boolean esComida();
    public abstract boolean esBebida();
    public abstract boolean aptoVegano();
    
    public abstract String getId();    
    public abstract String getNombre();
    public abstract String getDescripcion();
    public abstract float getPrecio();
    public abstract Categoria getCategoria();
    public abstract boolean getAptoVegano();
    public abstract void setId(String id);
    public abstract void setNombre(String nombre);
    public abstract void setDescripcion(String descripcion);
    public abstract void setPrecio(float precio);
    public abstract void setCategoria(Categoria categoria);
    public abstract void setAptoVegano(boolean aptoVegano);
}
