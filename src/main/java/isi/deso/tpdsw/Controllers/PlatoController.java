package isi.deso.tpdsw.Controllers;

import isi.deso.tpdsw.Daos.PlatoDao;
import isi.deso.tpdsw.Models.Categoria;
import isi.deso.tpdsw.Models.Plato;
import isi.deso.tpdsw.Models.Vendedor;
import isi.deso.tpdsw.Services.PlatoDaoFactory;

public class PlatoController {
    private PlatoDao dao;
    
    public PlatoController(PlatoDao dao){
        this.dao = dao;
    }
    
    public Plato crearPlato(Plato p){
        dao.createPlato(p);
        return p;
    }
    public Plato editarPlato(Plato p) {
        dao.updatePlato(p);
        return p;
    }

}
