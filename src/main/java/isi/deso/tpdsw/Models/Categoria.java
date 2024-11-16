package isi.deso.tpdsw.Models;

public class Categoria {

    private int id;
    private String descripcion;
    private TipoItem tipoItem;
    
    public Categoria(int id, String desc, TipoItem tipo){
        this.id = id;
        this.descripcion=desc;
        this.tipoItem=tipo;
    }

    public static Categoria valueOf(String categoria) {
        switch (categoria.toLowerCase()) {
            case "gaseosas":
                return new Categoria(1, "Gaseosas", TipoItem.BEBIDA);
            case "hamburguesas":
                return new Categoria(2, "Hamburguesas", TipoItem.PLATO);
            case "helados":
                return new Categoria(3, "Helados", TipoItem.PLATO);
            case "vinos":
                return new Categoria(4, "Vinos", TipoItem.BEBIDA);
            case "pastas":
                return new Categoria(5, "Pastas", TipoItem.PLATO);
            case "carnes":
                return new Categoria(6, "Carnes", TipoItem.PLATO);
            case "verduras":
                return new Categoria(7, "Verduras", TipoItem.PLATO);
            case "harinas":
                return new Categoria(8, "Harinas", TipoItem.PLATO);
            case "cervezas":
                return new Categoria(9, "Cervezas", TipoItem.BEBIDA);
            default:
                throw new IllegalArgumentException("Categoría no reconocida: " + categoria);
        }
    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public TipoItem getTipoItem() {
        return tipoItem;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public void setTipoItem(TipoItem tipoItem) {
        this.tipoItem = tipoItem;
    }

    @Override
    public String toString() {
        return this.descripcion;
    }


}

