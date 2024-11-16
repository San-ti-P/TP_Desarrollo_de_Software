package isi.deso.tpdsw.Daos;

import isi.deso.tpdsw.Models.Bebida;
import isi.deso.tpdsw.Models.Categoria;
import isi.deso.tpdsw.Models.Coordenada;
import isi.deso.tpdsw.Models.Vendedor;

import java.util.ArrayList;

public class CategoriaMemory implements CategoriaDao{
    private ArrayList<Categoria> categorias;

    public CategoriaMemory() {
        categorias = new ArrayList<>();

        categorias.add(Categoria.valueOf("gaseosas"));
        categorias.add(Categoria.valueOf("hamburguesas"));
        categorias.add(Categoria.valueOf("helados"));
        categorias.add(Categoria.valueOf("vinos"));
        categorias.add(Categoria.valueOf("pastas"));
        categorias.add(Categoria.valueOf("carnes"));
        categorias.add(Categoria.valueOf("verduras"));
        categorias.add(Categoria.valueOf("harinas"));
        categorias.add(Categoria.valueOf("cervezas"));
    }

    @Override
    public ArrayList<Categoria> getAll() {
        return categorias;
    }

}
