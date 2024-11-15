package isi.deso.tpdsw.Daos;

import isi.deso.tpdsw.Models.Cliente;
import isi.deso.tpdsw.Models.EstadoPedido;
import isi.deso.tpdsw.Models.Pedido;
import isi.deso.tpdsw.Models.Vendedor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PedidoSQL implements PedidoDao {
    @Override
    public ArrayList<Pedido> getAll() {
        ArrayList<Pedido> lista = new ArrayList<>();
        Connection con = DBConnector.getConnector().getConnection();
        String query = "SELECT * FROM pedido;";

        try(Statement stm = con.createStatement()) {
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()) {
                int id = rs.getInt("id");
                int clienteId = rs.getInt("cliente_id");
                int vendedorId = rs.getInt("vendedor_id");
                double precio = rs.getDouble("precio");
                String estado = rs.getString("estado");

                // Obtener cliente y vendedor
                Cliente cliente = getClienteById(clienteId);
                Vendedor vendedor = getVendedorById(vendedorId);

                // Crear pedido
                Pedido pedido = new Pedido(id, cliente, new ArrayList<>(), vendedor, EstadoPedido.valueOf(estado));
                lista.add(pedido);
            }
        } catch (SQLException ex) {
            System.out.println("Fallo al obtener los datos");
        }
        return lista;
    }

//  Estos metodos son solamente para cumplir con todos los atributos de Pedido al realizar getAll
    private Cliente getClienteById(int id) {
        // Implementar lógica para obtener Cliente por ID
        return new Cliente(); // Placeholder
    }

    private Vendedor getVendedorById(int id) {
        // Implementar lógica para obtener Vendedor por ID
        return new Vendedor(); // Placeholder
    }

    @Override
    public ArrayList<Pedido> searchByName(String nombre) {
        ArrayList<Pedido> lista = new ArrayList<>();
        Connection con = DBConnector.getConnector().getConnection();
        String query = "SELECT * FROM pedido WHERE nombre_cliente LIKE '%"+nombre+"%';";

        try(Statement stm = con.createStatement()) {
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()) {
                int id = rs.getInt("id");
                int clienteId = rs.getInt("cliente_id");
                int vendedorId = rs.getInt("vendedor_id");
                double precio = rs.getDouble("precio");
                String estado = rs.getString("estado");

                // Obtener cliente y vendedor
                Cliente cliente = getClienteById(clienteId);
                Vendedor vendedor = getVendedorById(vendedorId);

                // Crear pedido
                Pedido pedido = new Pedido(id, cliente, new ArrayList<>(), vendedor, EstadoPedido.valueOf(estado));
                lista.add(pedido);
            }
        } catch (SQLException ex) {
            System.out.println("Fallo al obtener los datos");
        }
        return lista;
    }
}