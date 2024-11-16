package isi.deso.tpdsw.Daos;

import isi.deso.tpdsw.Models.Bebida;
import isi.deso.tpdsw.Models.Categoria;
import isi.deso.tpdsw.Models.Coordenada;
import isi.deso.tpdsw.Models.Vendedor;

import java.util.ArrayList;

public class BebidaMemory implements BebidaDao{
    private ArrayList<Bebida> bebidas;

    public BebidaMemory() {
        bebidas = new ArrayList<>();
        // Agregar datos de prueba
        bebidas.add(new Bebida(1, "Sprite", "Descripcion 1", 10.0f, Categoria.valueOf("gaseosas"), 5.0f, 500, true, new Vendedor(1, "Vendedor 1", "Direccion 1", new Coordenada(10.0, 20.0))));
        bebidas.add(new Bebida(2, "IPA", "Descripcion 2", 20.0f, Categoria.valueOf("cervezas"), 10.0f, 1000, false, new Vendedor(2, "Vendedor 2", "Direccion 2", new Coordenada(30.0, 40.0))));
    }

    @Override
    public ArrayList<Bebida> getAll() {
        return bebidas;
    }

    @Override
    public ArrayList<Bebida> searchByName(String nombre) {
        ArrayList<Bebida> result = new ArrayList<>();
        for (Bebida bebida : bebidas) {
            if (bebida.getNombre().contains(nombre)) {
                result.add(bebida);
            }
        }
        return result;
    }

    @Override
    public Bebida updateBebida(Bebida bebida) {
        for (int i = 0; i < bebidas.size(); i++) {
            if (bebidas.get(i).getId() == bebida.getId()) {
                bebidas.set(i, bebida);
                return bebida;
            }
        }
        return null;
    }

    @Override
    public Bebida createBebida(Bebida bebida) {
        bebidas.add(bebida);
        return bebida;
    }

    @Override
    public void deleteBebida(int id) {
        bebidas.removeIf(bebida -> bebida.getId() == id);
    }

    @Override
    public int obtenerUltimoID() {
        int maxId = 0;
        for (Bebida bebida : bebidas) {
            if (bebida.getId() > maxId) {
                maxId = bebida.getId();
            }
        }
        return maxId;
    }
}
