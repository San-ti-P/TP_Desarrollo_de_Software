package isi.deso.tpdsw.Controllers;

import isi.deso.tpdsw.Daos.PlatoDao;
import isi.deso.tpdsw.Models.Categoria;
import isi.deso.tpdsw.Models.Plato;
import isi.deso.tpdsw.Models.Vendedor;
import isi.deso.tpdsw.Services.PlatoDaoFactory;

public class PlatoController {
    private PlatoDao dao;
    
    public PlatoController(){
        this.dao = (new PlatoDaoFactory()).getDao("sql");
    }
    
    public Plato crearPlato(int id, String nombre, String descripcion, int calorias, boolean aptoCeliaco, float peso, float precio, Categoria categoria, boolean aptoVegano, Vendedor vendedor){
        return new Plato(id, nombre, descripcion, calorias, aptoCeliaco, peso, precio, categoria, aptoVegano, vendedor);
    }
    public Plato editarPlato(int id, String nombre, String descripcion, int calorias, boolean aptoCeliaco, float peso, float precio, Categoria categoria, boolean aptoVegano, Vendedor vendedor) {
        return new Plato(id, nombre, descripcion, calorias, aptoCeliaco, peso, precio, categoria, aptoVegano, vendedor);
    }

}
