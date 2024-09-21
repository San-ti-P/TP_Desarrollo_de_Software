package isi.deso.tpdsw;

public class ItemPedido {
    
    private int cantidad;
    private ItemMenu item;
    private Pedido pedido;

    public ItemPedido(ItemMenu item, int cantidad) {
        this.cantidad = cantidad;
        this.item = item;
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
    
}
