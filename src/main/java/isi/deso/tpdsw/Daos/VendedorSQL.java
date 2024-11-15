package isi.deso.tpdsw.Daos;

import isi.deso.tpdsw.Models.Vendedor;
import isi.deso.tpdsw.Models.Coordenada;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class VendedorSQL implements VendedorDao {

    @Override
    public ArrayList<Vendedor> getAll() {
        ArrayList<Vendedor> lista = new ArrayList<>();
        Connection con = DBConnector.getConnector().getConnection();
        String query = "SELECT * FROM vendedor;";
        try (Statement stm = con.createStatement()) {
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String direccion = rs.getString("direccion");
                double latitud = rs.getDouble("latitud");
                double longitud = rs.getDouble("longitud");
                Coordenada coordenada = new Coordenada(latitud, longitud);
                Vendedor vendedor = new Vendedor(id, nombre, direccion, coordenada);
                lista.add(vendedor);
            }
        } catch (SQLException ex) {
            System.out.println("Fallo al obtener los datos");
        }
        return lista;
    }

    @Override
    public ArrayList<Vendedor> searchByName(String nombre) {
        ArrayList<Vendedor> lista = new ArrayList<>();
        Connection con = DBConnector.getConnector().getConnection();
        String query = "SELECT * FROM vendedor WHERE nombre LIKE '%" + nombre + "%';";
        try (Statement stm = con.createStatement()) {
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombreReal = rs.getString("nombre");
                String direccion = rs.getString("direccion");
                double latitud = rs.getDouble("latitud");
                double longitud = rs.getDouble("longitud");
                Coordenada coordenada = new Coordenada(latitud, longitud);
                Vendedor vendedor = new Vendedor(id, nombreReal, direccion, coordenada);
                lista.add(vendedor);
            }
        } catch (SQLException ex) {
            System.out.println("Fallo al obtener los datos");
        }
        return lista;
    }
}