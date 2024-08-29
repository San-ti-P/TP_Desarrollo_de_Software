package isi.deso.tpdsw;

public class Cliente {
    private int id;
    private String cuit;
    private String email;
    private String direccion;
    private Coordenada coordenadas;
    
    public int getId() {
        return id;
    }

    public String getCuit() {
        return cuit;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getDireccion() {
        return direccion;
    }
    
    public Coordenada getCoordenadas() {
        return coordenadas;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setCoordenadas(Coordenada coordenadas) {
        this.coordenadas = coordenadas;
    }
}
