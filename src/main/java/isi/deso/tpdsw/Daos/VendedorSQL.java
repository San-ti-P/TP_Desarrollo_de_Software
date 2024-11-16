package isi.deso.tpdsw.Daos;

import isi.deso.tpdsw.Models.Vendedor;
import isi.deso.tpdsw.Models.Coordenada;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class VendedorSQL implements VendedorDao  {

    @Override
    public ArrayList<Vendedor> getAll() {
        ArrayList<Vendedor> lista = new ArrayList<>();
        Connection con = DBConnector.getConnector().getConnection();
        String query = "SELECT * FROM vendedor WHERE activo=1;";
        try (Statement stm = con.createStatement()) {
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String direccion = rs.getString("direccion");
                double latitud = rs.getDouble("lat");
                double longitud = rs.getDouble("lng");
                Coordenada coordenada = new Coordenada(latitud, longitud);
                Vendedor vendedor = new Vendedor(id, nombre, direccion, coordenada);
                lista.add(vendedor);
            }
        } catch (SQLException ex) {
            //Logger.getLogger(PersonaJDBC.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Fallo al obtener los datos");
        }
        return lista;
    }

    @Override
    public ArrayList<Vendedor> searchByName(String nombre) {
        ArrayList<Vendedor> lista = new ArrayList<>();
        Connection con = DBConnector.getConnector().getConnection();
        String query = "SELECT * FROM vendedor WHERE nombre LIKE '%" + nombre + "%'  AND activo=1;";
        try (Statement stm = con.createStatement()) {
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombreReal = rs.getString("nombre");
                String direccion = rs.getString("direccion");
                double latitud = rs.getDouble("lat");
                double longitud = rs.getDouble("lng");
                Coordenada coordenada = new Coordenada(latitud, longitud);
                Vendedor vendedor = new Vendedor(id, nombreReal, direccion, coordenada);
                lista.add(vendedor);
            }
        } catch (SQLException ex) {
            System.out.println("Fallo al obtener los datos");
        }
        return lista;
    }
    
    @Override
    public int obtenerUltimoID() {
        Connection con = DBConnector.getConnector().getConnection();
        String query = "SELECT MAX(id) AS max_id FROM vendedor;";
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
    public Vendedor getVendedorById(int vendedorId) {
        Connection con = DBConnector.getConnector().getConnection();
        String query = "SELECT * FROM vendedor WHERE id = " + vendedorId + ";";
        try (Statement stm = con.createStatement()) {
            ResultSet rs = stm.executeQuery(query);
            if (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String direccion = rs.getString("direccion");
                double latitud = rs.getDouble("lat");
                double longitud = rs.getDouble("lng");
                Coordenada coordenada = new Coordenada(latitud, longitud);
                return new Vendedor(id, nombre, direccion, coordenada);
            }
        } catch (SQLException ex) {
            System.out.println("Fallo al obtener el vendedor");
        }
        return null;
    }
    
    @Override
    public Vendedor createVendedor(Vendedor vendedor) {
        Connection con = DBConnector.getConnector().getConnection();
        String query = "INSERT INTO vendedor(id, nombre,direccion, lat, lng, activo) VALUES ("
                + vendedor.getId() + ", '"
                + vendedor.getNombre() + "', '"
                + vendedor.getDireccion() + "', "
                + vendedor.getCoordenadas().getLat() + ", "
                + vendedor.getCoordenadas().getLng() + ", "
                + true + ");";
        try (Statement stm = con.createStatement()) {
            int rs = stm.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vendedor;
    }
    
    @Override
    public Vendedor updateVendedor(Vendedor vendedor) {
        Connection con = DBConnector.getConnector().getConnection();
        String query = "UPDATE vendedor SET nombre = '"
                + vendedor.getNombre() + "', direccion = '"
                + vendedor.getDireccion() + "', lat = "
                + vendedor.getCoordenadas().getLat() + ", lng = "
                + vendedor.getCoordenadas().getLng() + " WHERE id = "
                + vendedor.getId() + ";";
        try (Statement stm = con.createStatement()) {
            int rs = stm.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vendedor;
    }

    @Override
    public void deleteVendedor(int id) {
        Connection con = DBConnector.getConnector().getConnection();
        String query = "UPDATE vendedor SET activo = false WHERE id = " + id + ";";
        try (Statement stm = con.createStatement()) {
            int rs = stm.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}