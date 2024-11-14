package isi.deso.tpdsw.Services;

public class ItemNoEncontradoException extends Exception{
    String mensaje;
    
    public ItemNoEncontradoException(String m){
        this.mensaje = m;
    }
}
