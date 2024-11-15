package isi.deso.tpdsw.Models;

public class Categoria {

    private String id;
    private String descripcion;
    private TipoItem tipoItem;
    
    public Categoria(String id, String desc, TipoItem tipo){
        this.id=id;
        this.descripcion=desc;
        this.tipoItem=tipo;
    }

    public static Categoria valueOf(String categoria) {
        switch (categoria.toLowerCase()) {
            case "bebida":
                return new Categoria("1", "Bebida", TipoItem.BEBIDA);
            case "plato":
                return new Categoria("2", "Plato", TipoItem.PLATO);
            case "gaseosas":
                return new Categoria("Cat1", "Gaseosas", TipoItem.BEBIDA);
            case "hamburguesas":
                return new Categoria("Cat2", "Hamburguesas", TipoItem.PLATO);
            case "helados":
                return new Categoria("Cat3", "Helados", TipoItem.PLATO);
            case "vinos":
                return new Categoria("Cat4", "Vinos", TipoItem.BEBIDA);
            case "pastas":
                return new Categoria("Cat5", "Pastas", TipoItem.PLATO);
            case "carnes":
                return new Categoria("Cat6", "Carnes", TipoItem.PLATO);
            case "verduras":
                return new Categoria("Cat7", "Verduras", TipoItem.PLATO);
            case "harinas":
                return new Categoria("Cat8", "Harinas", TipoItem.PLATO);
            case "cervezas":
                return new Categoria("Cat9", "Cervezas", TipoItem.BEBIDA);
            default:
                throw new IllegalArgumentException("Categoría no reconocida: " + categoria);
        }
    }

    public String getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public TipoItem getTipoItem() {
        return tipoItem;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public void setTipoItem(TipoItem tipoItem) {
        this.tipoItem = tipoItem;
    }
}

