
package isi.deso.tpdsw.Services;

import isi.deso.tpdsw.Daos.PedidoDao;
import isi.deso.tpdsw.Daos.PedidoMemory;
import isi.deso.tpdsw.Daos.PedidoSQL;

import java.util.TreeMap;

public class PedidoDaoFactory {
    private final TreeMap<String, Integer> tipos = new TreeMap<>();

    public PedidoDaoFactory(){
        tipos.put("memory", 0);
        tipos.put("sql", 1);
    }
   
    public PedidoDao getDao(String tipo){
        String t = tipo.toLowerCase();
        switch(tipos.get(t)){
            case 0 -> {
                return new PedidoMemory();
            }
            case 1 -> {   
                return new PedidoSQL();
            }
        }
        return null;
    }
}
