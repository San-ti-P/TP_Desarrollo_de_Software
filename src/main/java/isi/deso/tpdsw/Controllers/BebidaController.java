package isi.deso.tpdsw.Controllers;

import isi.deso.tpdsw.Daos.BebidaDao;
import isi.deso.tpdsw.Models.Bebida;
import isi.deso.tpdsw.Services.BebidaDaoFactory;

public class BebidaController {
    private BebidaDao dao;

    public BebidaController() {
        this.dao = (new BebidaDaoFactory()).getDao("sql");
    }

    public Bebida crearBebida(Bebida b){
        dao.createBebida(b);
        return b;
    }

    public Bebida editarBebida(Bebida b) {
        dao.updateBebida(b);
        return b;
    }
}
