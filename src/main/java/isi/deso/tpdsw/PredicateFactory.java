/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package isi.deso.tpdsw;

import java.util.TreeMap;
import java.util.function.Predicate;

/**
 *
 * @author santi
 */
public class PredicateFactory {
    private TreeMap<String, Integer> tipos = new TreeMap();
    
    public PredicateFactory(){
        tipos.put("id", 0);
        tipos.put("nombre", 1);
        tipos.put("aptovegano", 2);
        tipos.put("categoria", 3);
    }
   
    public Predicate<ItemMenu> obtenerPredicado(String arg, String valor){
        String val = valor.toLowerCase();
        switch(tipos.get(arg.toLowerCase().strip())){
            case 0 -> {
                return (a) -> a.getId().equals(val);
            }
            case 1 -> {   
                return (a) -> a.getNombre().equals(val);
            }
            case 2 -> {
                return (a) -> a.getAptoVegano()==(Boolean.parseBoolean(val));
            }
            case 3 -> {
                return (a) -> a.getCategoria().getId().equals(val);
            }
        }
        return null;
    }
    
}
