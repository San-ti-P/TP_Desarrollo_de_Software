package isi.deso.tpdsw.Daos;

import isi.deso.tpdsw.Models.*;
import isi.deso.tpdsw.Services.ItemNoEncontradoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ItemsPedidoSQL implements ItemsPedidoDao {

    @Override
    public ArrayList<ItemPedido> getAll() {
        ArrayList<ItemPedido> lista = new ArrayList<>();
        Connection con = DBConnector.getConnector().getConnection();
        String query = "SELECT * FROM item_pedido;";
        try (Statement stm = con.createStatement()) {
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                int cantidad = rs.getInt("cantidad");
                int itemId = rs.getInt("item_id");
                int pedidoId = rs.getInt("pedido_id");
                ItemMenu item = getItemById(itemId);
                Pedido pedido = getPedidoById(pedidoId);
                ItemPedido itemPedido = new ItemPedido(item, cantidad, pedido);
                lista.add(itemPedido);
            }
        } catch (SQLException ex) {
            System.out.println("Fallo al obtener los datos");
        }
        return lista;
    }

    @Override
    public ArrayList<ItemPedido> searchByName(String nombre) {
        ArrayList<ItemPedido> lista = new ArrayList<>();
        Connection con = DBConnector.getConnector().getConnection();
        String query = "SELECT * FROM item_pedido ip JOIN item_menu im ON ip.item_id = im.id WHERE im.nombre LIKE '%" + nombre + "%';";
        try (Statement stm = con.createStatement()) {
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                int cantidad = rs.getInt("cantidad");
                int itemId = rs.getInt("item_id");
                int pedidoId = rs.getInt("pedido_id");
                ItemMenu item = getItemById(itemId);
                Pedido pedido = getPedidoById(pedidoId);
                ItemPedido itemPedido = new ItemPedido(item, cantidad, pedido);
                lista.add(itemPedido);
            }
        } catch (SQLException ex) {
            System.out.println("Fallo al obtener los datos");
        }
        return lista;
    }

    private ItemMenu getItemById(int itemId) {
        Connection con = DBConnector.getConnector().getConnection();
        String query = "SELECT * FROM item_menu WHERE id = " + itemId + ";";
        try (Statement stm = con.createStatement()) {
            ResultSet rs = stm.executeQuery(query);
            if (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                float precio = rs.getFloat("precio");
                int vendedorId = rs.getInt("vendedor_id");
                Vendedor vendedor = getVendedorById(vendedorId);

                // Check for attributes unique to Bebida
                try {
                    float graduacionAlcoholica = rs.getFloat("graduacion_alcoholica");
                    int tamaño = rs.getInt("tamaño");
                    boolean aptoVegano = rs.getBoolean("apto_vegano");
                    Categoria categoria = Categoria.valueOf(rs.getString("categoria"));
                    return new Bebida(id, nombre, descripcion, precio, categoria, graduacionAlcoholica, tamaño, aptoVegano, vendedor);
                } catch (SQLException e) {
                    // If attributes unique to Bebida are not found, it must be a Plato
                    int calorias = rs.getInt("calorias");
                    boolean aptoCeliaco = rs.getBoolean("apto_celiaco");
                    float peso = rs.getFloat("peso");
                    boolean aptoVegano = rs.getBoolean("apto_vegano");
                    Categoria categoria = Categoria.valueOf(rs.getString("categoria"));
                    return new Plato(id, nombre, descripcion, calorias, aptoCeliaco, peso, precio, categoria, aptoVegano, vendedor);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Fallo al obtener el item");
        }
        return null;
    }

    private Vendedor getVendedorById(int vendedorId) {
        Connection con = DBConnector.getConnector().getConnection();
        String query = "SELECT * FROM vendedor WHERE id = " + vendedorId + ";";
        try (Statement stm = con.createStatement()) {
            ResultSet rs = stm.executeQuery(query);
            if (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String direccion = rs.getString("direccion");
                double latitud = rs.getDouble("latitud");
                double longitud = rs.getDouble("longitud");
                Coordenada coordenada = new Coordenada(latitud, longitud);
                return new Vendedor(id, nombre, direccion, coordenada);
            }
        } catch (SQLException ex) {
            System.out.println("Fallo al obtener el vendedor");
        }
        return null;
    }

    private Pedido getPedidoById(int pedidoId) {
        Connection con = DBConnector.getConnector().getConnection();
        String query = "SELECT * FROM pedido WHERE id = " + pedidoId + ";";
        try (Statement stm = con.createStatement()) {
            ResultSet rs = stm.executeQuery(query);
            if (rs.next()) {
                int id = rs.getInt("id");
                int clienteId = rs.getInt("cliente_id");
                Cliente cliente = getClienteById(clienteId);
                ArrayList<ItemPedido> items = getItemsByPedidoId(id);
                int vendedorId = rs.getInt("vendedor_id");
                Vendedor vendedor = getVendedorById(vendedorId);
                EstadoPedido estado = EstadoPedido.valueOf(rs.getString("estado"));
                return new Pedido(id, cliente, items, vendedor, estado);
            }
        } catch (SQLException ex) {
            System.out.println("Fallo al obtener el pedido");
        }
        return null;
    }

    private Cliente getClienteById(int clienteId) {
        Connection con = DBConnector.getConnector().getConnection();
        String query = "SELECT * FROM cliente WHERE id = " + clienteId + ";";
        try (Statement stm = con.createStatement()) {
            ResultSet rs = stm.executeQuery(query);
            if (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String direccion = rs.getString("direccion");
                return new Cliente(id, nombre, direccion);
            }
        } catch (SQLException ex) {
            System.out.println("Fallo al obtener el cliente");
        }
        return null;
    }

    private ArrayList<ItemPedido> getItemsByPedidoId(int pedidoId) {
        ArrayList<ItemPedido> items = new ArrayList<>();
        Connection con = DBConnector.getConnector().getConnection();
        String query = "SELECT * FROM item_pedido WHERE pedido_id = " + pedidoId + ";";
        try (Statement stm = con.createStatement()) {
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                int cantidad = rs.getInt("cantidad");
                int itemId = rs.getInt("item_id");
                ItemMenu item = getItemById(itemId);
                Pedido pedido = getPedidoById(pedidoId);
                items.add(new ItemPedido(item, cantidad, pedido));
            }
        } catch (SQLException ex) {
            System.out.println("Fallo al obtener los items del pedido");
        }
        return items;
    }

    @Override
    public ArrayList<ItemPedido> filtrarPedido(Pedido pedido, Predicate<ItemPedido> funcionLambda) throws ItemNoEncontradoException {
        ArrayList<ItemPedido> r = new ArrayList<>(pedido.getItems().stream()
                .filter(funcionLambda)
                .collect(Collectors.toList()));
        if (r.isEmpty()) throw new ItemNoEncontradoException("No se encontraron items que satisfagan la condicion");
        else return r;
    }

    @Override
    public ArrayList<ItemPedido> ordenarPedido(Pedido pedido, Comparator comparador){
        this.getAll();
        ArrayList<ItemPedido> r = new ArrayList(pedido.getItems().stream()
                .sorted(comparador)
                .toList());
        return r;
    }

    @Override
    public ArrayList<ItemPedido> rangoPrecios(Pedido pedido, float precioInferior, float precioSuperior) throws ItemNoEncontradoException {
        ArrayList<ItemPedido> r = new ArrayList<>(pedido.getItems().stream()
                .filter((i) -> i.getItem().getPrecio() >= precioInferior && i.getItem().getPrecio() <= precioSuperior)
                .collect(Collectors.toList()));
        if (r.isEmpty()) throw new ItemNoEncontradoException("No se encontraron items que satisfagan la condicion");
        else return r;
    }

    @Override
    public ArrayList<ItemPedido> filtrarPorRestaurante(Pedido pedido, String nombre) throws ItemNoEncontradoException {
        ArrayList<ItemPedido> r = new ArrayList<>(pedido.getItems().stream()
                .filter((i) -> i.getItem().getVendedor().getNombre().equalsIgnoreCase(nombre))
                .collect(Collectors.toList()));
        if (r.isEmpty()) throw new ItemNoEncontradoException("No se encontraron items que satisfagan la condicion");
        else return r;
    }
}