package isi.deso.tpdsw.Daos;

import isi.deso.tpdsw.Models.Categoria;
import isi.deso.tpdsw.Models.TipoItem;
import java.sql.*;
import java.util.ArrayList;

public class CategoriaSQL implements CategoriaDao{

    public ArrayList<Categoria> getAll() {
        ArrayList<Categoria> categorias = new ArrayList<>();
        Connection con = DBConnector.getConnector().getConnection();
        String query = "SELECT id, descripcion, tipoItem FROM categoria";

        try (Statement stm = con.createStatement()) {
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id"); // Cambiado a int
                String descripcion = rs.getString("descripcion");
                String tipoItem = rs.getString("tipoItem");

                // Verifica el valor del campo tipoItem y crea el objeto Categoria
                TipoItem tipo;
                if (tipoItem.equalsIgnoreCase("PLATO")) {
                    tipo = TipoItem.PLATO;
                } else {
                    tipo = TipoItem.BEBIDA;
                }
                categorias.add(new Categoria(id, descripcion, tipo));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener categorías", e);
        }
        return categorias;
    }

    
    @Override
    public int obtenerUltimoID() {
        Connection con = DBConnector.getConnector().getConnection();
        String query = "SELECT MAX(id) AS max_id FROM categoria;";
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

}
