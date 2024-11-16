package isi.deso.tpdsw.Daos;

import isi.deso.tpdsw.Models.*;

import java.util.ArrayList;

public class CategoriaMemory implements CategoriaDao{
    private ArrayList<Categoria> categorias;

    public CategoriaMemory() {
        categorias = new ArrayList<>();

        categorias.add(new Categoria(1, "Platos Principales", TipoItem.PLATO));
        categorias.add(new Categoria(2, "Bebidas Alcoholicas", TipoItem.BEBIDA));
        categorias.add(new Categoria(3, "Postres", TipoItem.PLATO));
        categorias.add(new Categoria(4, "Bebidas Sin Alcohol", TipoItem.BEBIDA));
        categorias.add(new Categoria(5, "Gaseosas", TipoItem.BEBIDA));
        categorias.add(new Categoria(6, "Hamburguesas", TipoItem.PLATO));
        categorias.add(new Categoria(7, "Helados", TipoItem.PLATO));
        categorias.add(new Categoria(8, "Vinos", TipoItem.BEBIDA));
        categorias.add(new Categoria(9, "Pastas", TipoItem.PLATO));
        categorias.add(new Categoria(10, "Carnes", TipoItem.PLATO));
        categorias.add(new Categoria(11, "Verduras", TipoItem.PLATO));
        categorias.add(new Categoria(12, "Harinas", TipoItem.PLATO));
        categorias.add(new Categoria(13, "Cervezas", TipoItem.BEBIDA));
    }

    @Override
    public ArrayList<Categoria> getAll() {
        return categorias;
    }

    @Override
    public Categoria getCategoriaById(int categoriaId) {
        for (Categoria categoria : categorias) {
            if (categoria.getId() == categoriaId) {
                return categoria;
            }
        }
        return null;
    }

}
