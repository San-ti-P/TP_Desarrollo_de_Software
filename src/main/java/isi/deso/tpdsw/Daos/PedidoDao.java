package isi.deso.tpdsw.Daos;

import isi.deso.tpdsw.Models.Pedido;
import java.util.ArrayList;

public interface PedidoDao {
    public ArrayList<Pedido> getAll();
    public ArrayList<Pedido> searchByName(String nombre);
    public Pedido createPedido(Pedido pedido);
    public Pedido updatePedido(Pedido pedido);
    public void deletePedido(int id);
    public int obtenerUltimoID();
}
