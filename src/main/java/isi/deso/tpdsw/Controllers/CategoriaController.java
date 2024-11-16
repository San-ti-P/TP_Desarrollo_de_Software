package isi.deso.tpdsw.Controllers;
import isi.deso.tpdsw.Daos.CategoriaDao;
import isi.deso.tpdsw.Models.Categoria;
import isi.deso.tpdsw.Services.CategoriaDaoFactory;
import java.util.ArrayList;

public class CategoriaController {

    private CategoriaDao dao;

    public CategoriaController() {
        this.dao = (new CategoriaDaoFactory()).getDao("sql");
    }

    public ArrayList<Categoria> obtenerCategorias() {
        return dao.getAll();
    }
}