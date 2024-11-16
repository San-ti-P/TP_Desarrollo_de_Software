package isi.deso.tpdsw.Controllers;

import isi.deso.tpdsw.Daos.BebidaDao;
import isi.deso.tpdsw.Models.Bebida;

public class BebidaController {
    private BebidaDao dao;

    public BebidaController(BebidaDao dao) {
        this.dao = dao;
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
