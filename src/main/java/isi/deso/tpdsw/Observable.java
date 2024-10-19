package isi.deso.tpdsw;

public interface Observable {
    public void addObserver(PedidoObserver o);
    public void removeObserver(PedidoObserver o);
    public void notifyObservers();
}