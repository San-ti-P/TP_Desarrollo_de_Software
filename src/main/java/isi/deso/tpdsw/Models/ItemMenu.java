package isi.deso.tpdsw.Models;

public abstract class ItemMenu {

    protected int id;
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
    
    public abstract int getId();    
    public abstract String getNombre();
    public abstract String getDescripcion();
    public abstract float getPrecio();
    public abstract Categoria getCategoria();
    public abstract boolean getAptoVegano();
    public abstract Vendedor getVendedor();
    public abstract void setId(int id);
    public abstract void setNombre(String nombre);
    public abstract void setDescripcion(String descripcion);
    public abstract void setPrecio(float precio);
    public abstract void setCategoria(Categoria categoria);
    public abstract void setAptoVegano(boolean aptoVegano);
    public abstract void setVendedor(Vendedor vendedor);
}
