package isi.deso.tpdsw.Services;

import isi.deso.tpdsw.Services.PedidoObserver;

public interface Observable {
    public void addObserver(PedidoObserver o);
    public void removeObserver(PedidoObserver o);
    public void notifyObservers();
}
