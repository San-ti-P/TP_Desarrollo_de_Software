package isi.deso.tpdsw.Daos;

import isi.deso.tpdsw.Models.Cliente;
import isi.deso.tpdsw.Models.EstadoPedido;
import isi.deso.tpdsw.Models.Pedido;
import isi.deso.tpdsw.Models.Vendedor;
import isi.deso.tpdsw.Services.ClienteDaoFactory;
import isi.deso.tpdsw.Services.VendedorDaoFactory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PedidoSQL implements PedidoDao {
    
    private VendedorDao vendedorDao;
    private ClienteDao clienteDao; 
    
    public PedidoSQL(){
        this.vendedorDao = (new VendedorDaoFactory()).getDao("sql");
        this.clienteDao = (new ClienteDaoFactory()).getDao("sql");
    }
    
    @Override
    public ArrayList<Pedido> getAll() {
        ArrayList<Pedido> lista = new ArrayList<>();
        Connection con = DBConnector.getConnector().getConnection();
        String query = "SELECT * FROM pedido WHERE activo=1;";
        try(Statement stm = con.createStatement()) {
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()) {
                int id = rs.getInt("id");
                int clienteId = rs.getInt("clienteid");
                int vendedorId = rs.getInt("vendedorid");
                double precio = rs.getDouble("precio");
                String estado = rs.getString("estado");

                // Obtener cliente y vendedor
                Cliente cliente = clienteDao.getClienteById(clienteId);
                Vendedor vendedor = vendedorDao.getVendedorById(vendedorId);

                // Crear pedido
                Pedido pedido = new Pedido(id, cliente, new ArrayList<>(), vendedor, EstadoPedido.valueOf(estado));
                lista.add(pedido);
            }
        } catch (SQLException ex) {
            System.out.println("Fallo al obtener los datos");
        }
        return lista;
    }
    
    @Override
    public ArrayList<Pedido> searchByName(String nombre) {
        ArrayList<Pedido> lista = new ArrayList<>();
        Connection con = DBConnector.getConnector().getConnection();
        String query = "SELECT * FROM pedido WHERE nombrecliente LIKE '%"+nombre+"%';";

        try(Statement stm = con.createStatement()) {
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()) {
                int id = rs.getInt("id");
                int clienteId = rs.getInt("clienteid");
                int vendedorId = rs.getInt("vendedorid");
                double precio = rs.getDouble("precio");
                String estado = rs.getString("estado");

                // Obtener cliente y vendedor
                Cliente cliente = clienteDao.getClienteById(clienteId);
                Vendedor vendedor = vendedorDao.getVendedorById(vendedorId);

                // Crear pedido
                Pedido pedido = new Pedido(id, cliente, new ArrayList<>(), vendedor, EstadoPedido.valueOf(estado));
                lista.add(pedido);
            }
        } catch (SQLException ex) {
            System.out.println("Fallo al obtener los datos");
        }
        return lista;
    }

    @Override
    public int obtenerUltimoID() {
        Connection con = DBConnector.getConnector().getConnection();
        String query = "SELECT MAX(id) AS max_id FROM pedido;";
        try (Statement stm = con.createStatement()) {
            ResultSet rs = stm.executeQuery(query);
            if (rs.next()) {
                return rs.getInt("max_id");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }
    
    @Override
    public Pedido createPedido(Pedido pedido) {
        Connection con = DBConnector.getConnector().getConnection();
        String query = "INSERT INTO pedido(id, cliente, vendedor, estado) VALUES ("
                + pedido.getId() + ", '"
                + pedido.getCliente().getId() + "', '"
                + pedido.getVendedor().getId() + "', '"
                + pedido.getEstado() + "', '"
                + pedido.getPrecio() + "', '"
                + true + ");";
        try (Statement stm = con.createStatement()) {
            int rs = stm.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return pedido;
    }

    @Override
    public Pedido updatePedido(Pedido pedido) {
        Connection con = DBConnector.getConnector().getConnection();
        String query =  "UPDATE cliente SET id = '"
                + pedido.getId() + ", clienteid = '"
                + pedido.getCliente().getId() + "', vendedorid = '"
                + pedido.getVendedor().getId() + "', estado = '"
                + pedido.getEstado() + "', precio ='"
                + pedido.getPrecio() + ";";
        try (Statement stm = con.createStatement()) {
            int rs = stm.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return pedido;    }

    @Override
    public void deletePedido(int id) {
        Connection con = DBConnector.getConnector().getConnection();
        String query = "UPDATE pedido SET activo = false WHERE id = " + id + ";";
        try (Statement stm = con.createStatement()) {
            int rs = stm.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}