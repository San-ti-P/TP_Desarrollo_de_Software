package isi.deso.tpdsw.Daos;

import isi.deso.tpdsw.Models.Cliente;
import isi.deso.tpdsw.Models.Coordenada;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ClienteSQL implements ClienteDao {

    @Override
    public ArrayList<Cliente> getAll() {
        ArrayList<Cliente> lista = new ArrayList<>();
        Connection con = DBConnector.getConnector().getConnection();
        String query = "SELECT * FROM cliente;";
        try (Statement stm = con.createStatement()) {
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String cuit = rs.getString("cuit");
                String email = rs.getString("email");
                String direccion = rs.getString("direccion");
                double latitud = rs.getDouble("lat");
                double longitud = rs.getDouble("lng");
                Coordenada coordenadas = new Coordenada(latitud, longitud);

                Cliente c = new Cliente(id, nombre, cuit, email, direccion, coordenadas);
                lista.add(c);
            }
        } catch (SQLException ex) {
            System.out.println("Fallo al obtener los datos");
        }
        return lista;
    }

    @Override
    public ArrayList<Cliente> searchByName(String nombre) {
        ArrayList<Cliente> lista = new ArrayList<>();
        Connection con = DBConnector.getConnector().getConnection();
        String query = "SELECT * FROM cliente WHERE nombre LIKE '%" + nombre + "%';";
        try (Statement stm = con.createStatement()) {
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombreReal = rs.getString("nombre");
                String cuit = rs.getString("cuit");
                String email = rs.getString("email");
                String direccion = rs.getString("direccion");
                double latitud = rs.getDouble("lat");
                double longitud = rs.getDouble("lng");
                Coordenada coordenadas = new Coordenada(latitud, longitud);

                Cliente c = new Cliente(id, nombreReal, cuit, email, direccion, coordenadas);
                lista.add(c);
            }
        } catch (SQLException ex) {
            System.out.println("Fallo al obtener los datos");
        }
        return lista;
    }

    @Override
    public int obtenerUltimoID() {
        Connection con = DBConnector.getConnector().getConnection();
        String query = "SELECT MAX(id) AS max_id FROM cliente;";
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
    public Cliente createCliente(Cliente cliente) {
        Connection con = DBConnector.getConnector().getConnection();
        String query = "INSERT INTO cliente(id, nombre, cuit, email, direccion, lat, lng, activo) VALUES ("
                + cliente.getId() + ", '"
                + cliente.getNombre() + "', '"
                + cliente.getCuit() + "', '"
                + cliente.getEmail() + "', '"
                + cliente.getDireccion() + "', "
                + cliente.getCoordenadas().getLat() + ", "
                + cliente.getCoordenadas().getLng() + ", "
                + true + ");";
        try (Statement stm = con.createStatement()) {
            int rs = stm.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cliente;
    }

    @Override
    public Cliente updateCliente(Cliente cliente) {
        Connection con = DBConnector.getConnector().getConnection();
        String query = "UPDATE cliente SET nombre = '"
                + cliente.getNombre() + "', cuit = '"
                + cliente.getCuit() + "', email = '"
                + cliente.getEmail() + "', direccion = '"
                + cliente.getDireccion() + "', lat = "
                + cliente.getCoordenadas().getLat() + ", lng = "
                + cliente.getCoordenadas().getLng() + " WHERE id = "
                + cliente.getId() + ";";
        try (Statement stm = con.createStatement()) {
            int rs = stm.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cliente;
    }

    @Override
    public void deleteCliente(int id) {
        Connection con = DBConnector.getConnector().getConnection();
        String query = "UPDATE cliente SET activo = false WHERE id = " + id + ";";
        try (Statement stm = con.createStatement()) {
            int rs = stm.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}