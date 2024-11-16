package isi.deso.tpdsw.Daos;

import isi.deso.tpdsw.Models.Bebida;

import java.util.ArrayList;

public class BebidaMemory implements BebidaDao{

    @Override
    public ArrayList<Bebida> getAll() {
        return null;
    }

    @Override
    public ArrayList<Bebida> searchByName(String nombre) {
        return null;
    }

    @Override
    public Bebida updateBebida(Bebida bebida) {
        return null;
    }

    @Override
    public Bebida createBebida(Bebida bebida) {
        return null;
    }

    @Override
    public void deleteBebida(int id) {

    }

    @Override
    public int obtenerUltimoID() {
        return 0;
    }
}
