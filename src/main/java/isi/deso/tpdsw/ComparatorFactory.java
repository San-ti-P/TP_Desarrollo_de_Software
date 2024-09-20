package isi.deso.tpdsw;

import java.util.Comparator;
import java.util.TreeMap;

public class ComparatorFactory {
    private TreeMap<String, Integer> tipos = new TreeMap();
    
    public ComparatorFactory(){
        tipos.put("nombre", 0);
        tipos.put("categoria", 1);
    }
   
    public Comparator<ItemMenu> obtenerPredicado(String arg, String sentido){
        String s = sentido.toLowerCase();
        switch(tipos.get(arg.toLowerCase().strip())){
            case 0 -> {
                return (s.equals("asc"))?Comparator.comparing(ItemMenu::getNombre):Comparator.comparing(ItemMenu::getNombre).reversed();
            }
            case 1 -> {   
                return (s.equals("asc"))?Comparator.comparing((ItemMenu item) -> item.getCategoria().getId()):Comparator.comparing((ItemMenu item) -> item.getCategoria().getId()).reversed();
            }
        }
        return null;
    }
    
}
