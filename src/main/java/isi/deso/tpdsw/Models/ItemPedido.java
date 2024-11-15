package isi.deso.tpdsw.Models;

public class ItemPedido {
    
    private int cantidad;
    private ItemMenu item;
    private Pedido pedido;

    public ItemPedido(ItemMenu item, int cantidad, Pedido pedido) {
        this.cantidad = cantidad;
        this.item = item;
        this.pedido = pedido;
    }
    
    public int getCantidad() {
        return cantidad;
    }
    public ItemMenu getItem() {
        return item;
    }
    public Pedido getPedido() {
        return pedido;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public void setItem(ItemMenu item) {
        this.item = item;
    }
    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public String toString() {
        return "{Item=" + item + ", cantidad=" + cantidad + '}';
    }
}
