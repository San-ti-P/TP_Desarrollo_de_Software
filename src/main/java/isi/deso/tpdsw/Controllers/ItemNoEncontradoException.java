package isi.deso.tpdsw.Controllers;

public class ItemNoEncontradoException extends Exception{
    String mensaje;
    
    public ItemNoEncontradoException(String m){
        this.mensaje = m;
    }
}
