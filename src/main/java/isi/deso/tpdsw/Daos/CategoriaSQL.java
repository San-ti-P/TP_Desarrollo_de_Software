package isi.deso.tpdsw.Daos;

import isi.deso.tpdsw.Models.Categoria;
import java.sql.*;
import java.util.ArrayList;

public class CategoriaSQL implements CategoriaDao{

    public ArrayList<Categoria> getAll() {
        ArrayList<Categoria> categorias = new ArrayList<>();
        Connection con = DBConnector.getConnector().getConnection();
        String query = "SELECT id, nombre FROM Categoria";

        try (Statement stm = con.createStatement();
             ResultSet rs = stm.executeQuery(query)) {
            while (rs.next()) {
                String id = rs.getString("id");
                String nombre = rs.getString("nombre");
                categorias.add(new Categoria(id, nombre));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener categorías", e);
        }
        return categorias;
    }

}
