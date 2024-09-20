package isi.deso.tpdsw;

public class Categoria {

    private String id;
    private String descripcion;
    private TipoItem tipoItem;
    
    public Categoria(String id, String desc, TipoItem tipo){
        this.id=id;
        this.descripcion=desc;
        this.tipoItem=tipo;
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

