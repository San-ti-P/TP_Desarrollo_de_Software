package isi.deso.tpdsw;

/**
 *
 * @author santi
 */
public abstract class ItemMenu {
    protected String id;
    protected String nombre;
    protected String descripcion;
    protected float precio;
    protected Categoria categoria;
    
    public abstract float peso();
    public abstract boolean esComida();
    public abstract boolean esBebida();
    //public abstract boolean aptoVegano();
}
