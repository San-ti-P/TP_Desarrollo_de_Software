package isi.deso.tpdsw.Controllers;

import isi.deso.tpdsw.Models.ItemPedido;
import java.util.HashMap;
import java.util.function.Predicate;

public class PredicateFactory {
    private HashMap<String, Integer> tipos = new HashMap();
    
    public PredicateFactory(){
        tipos.put("id", 0);
        tipos.put("nombre", 1);
        tipos.put("aptovegano", 2);
        tipos.put("categoria", 3);
    }
   
    public Predicate<ItemPedido> obtenerPredicado(String arg, String valor){
        String val = valor.toLowerCase();
        switch(tipos.get(arg.toLowerCase().strip())){
            case 0 -> {
                return (a) -> a.getItem().getId().toLowerCase().equals(val);
            }
            case 1 -> {   
                return (a) -> a.getItem().getNombre().toLowerCase().equals(val);
            }
            case 2 -> {
                return (a) -> a.getItem().getAptoVegano()==(Boolean.parseBoolean(val));
            }
            case 3 -> {
                return (a) -> a.getItem().getCategoria().getDescripcion().toLowerCase().equals(val) || a.getItem().getCategoria().getId().toLowerCase().equals(val);
            }
        }
        return null;
    }
    
}
