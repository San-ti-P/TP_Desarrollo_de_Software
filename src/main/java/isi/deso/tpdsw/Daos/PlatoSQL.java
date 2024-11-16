package isi.deso.tpdsw.Daos;

import isi.deso.tpdsw.Models.Categoria;
import isi.deso.tpdsw.Models.Plato;
import isi.deso.tpdsw.Models.Vendedor;
import isi.deso.tpdsw.Services.VendedorDaoFactory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PlatoSQL implements PlatoDao{
    
    private VendedorDao vendedorDao;
    
    public PlatoSQL(){
        this.vendedorDao = (new VendedorDaoFactory()).getDao("sql");
    }
    

    @Override
    public ArrayList<Plato> getAll() {
        ArrayList<Plato> lista = new ArrayList<>();
        Connection con = DBConnector.getConnector().getConnection();
        String query = "SELECT * FROM item_menu im, plato p WHERE im.id = p.id;";
        try (Statement stm = con.createStatement()) {
            ResultSet rs = stm.executeQuery(query);
            int id = rs.getInt("id");
            String nombreReal = rs.getString("nombre");
            String descripcion = rs.getString("descripcion");
            float precio = rs.getFloat("precio");
            int vendedorId = rs.getInt("vendedor_id");
            Vendedor vendedor = vendedorDao.getVendedorById(vendedorId);

            int calorias = rs.getInt("calorias");
            boolean aptoCeliaco = rs.getBoolean("apto_celiaco");
            float peso = rs.getFloat("peso");
            boolean aptoVegano = rs.getBoolean("apto_vegano");
            Categoria categoria = Categoria.valueOf(rs.getString("categoria"));
            lista.add(new Plato(id, nombreReal, descripcion, calorias, aptoCeliaco, peso, precio, categoria, aptoVegano, vendedor));
                
        } catch (SQLException ex) {
            //Logger.getLogger(PersonaJDBC.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Fallo al obtener los datos");
        }
        return lista;
    }

    @Override
    public ArrayList<Plato> searchByName(String nombre) {
        ArrayList<Plato> lista = new ArrayList<>();
        Connection con = DBConnector.getConnector().getConnection();
        String query = "SELECT * FROM item_menu im, plato p WHERE im.id = p.id AND im.nombre LIKE '%"+nombre+"%';";
        try (Statement stm = con.createStatement()) {
            ResultSet rs = stm.executeQuery(query);
                if (rs.next()) {
                    int id = rs.getInt("id");
                    String nombreReal = rs.getString("nombre");
                    String descripcion = rs.getString("descripcion");
                    float precio = rs.getFloat("precio");
                    int vendedorId = rs.getInt("vendedor_id");
                    Vendedor vendedor = vendedorDao.getVendedorById(vendedorId);

                    int calorias = rs.getInt("calorias");
                    boolean aptoCeliaco = rs.getBoolean("apto_celiaco");
                    float peso = rs.getFloat("peso");
                    boolean aptoVegano = rs.getBoolean("apto_vegano");
                    Categoria categoria = Categoria.valueOf(rs.getString("categoria"));

            }
        } catch (SQLException ex) {
            System.out.println("Fallo al obtener el item");
        }
        return lista;
    }

    @Override
    public Plato createPlato(Plato plato) {
        Connection con = DBConnector.getConnector().getConnection();

        String insertItemMenuQuery = "INSERT INTO ItemMenu (id, nombre, descripcion, precio, categoria_id, aptoVegano, vendedor_id, activo) VALUES ("
                + plato.getId() + ", '"
                + plato.getNombre() + "', '"
                + plato.getDescripcion() + "', "
                + plato.getPrecio() + ", '"
                + plato.getCategoria().getId() + "', "
                + plato.getAptoVegano() + ", "
                + plato.getVendedor().getId() + ", "
                + "true);";

        String insertPlatoQuery = "INSERT INTO Plato (id, calorias, aptoCeliaco, peso) VALUES ("
                + plato.getId() + ", "
                + plato.getCalorias() + ", "
                + plato.getAptoCeliaco() + ", "
                + plato.getPeso() + ");";

        try (Statement stm = con.createStatement()) {
            stm.executeUpdate(insertItemMenuQuery);
            stm.executeUpdate(insertPlatoQuery);
        } catch (SQLException e) {
            System.out.println("Error al crear el plato");
        }
        return plato;
    }

    @Override
    public Plato updatePlato(Plato plato) {
        Connection con = DBConnector.getConnector().getConnection();
        String updateItemMenuQuery = "UPDATE ItemMenu SET " +
                "nombre = '" + plato.getNombre() + "', " +
                "descripcion = '" + plato.getDescripcion() + "', " +
                "precio = " + plato.getPrecio() + ", " +
                "categoria_id = '" + plato.getCategoria().getId() + "', " +
                "aptoVegano = " + plato.getAptoVegano() + ", " +
                "vendedor_id = " + plato.getVendedor().getId() +
                " WHERE id = " + plato.getId() + ";";

        String updatePlatoQuery = "UPDATE Plato SET " +
                "calorias = " + plato.getCalorias() + ", " +
                "aptoCeliaco = " + plato.getAptoCeliaco() + ", " +
                "peso = " + plato.getPeso() +
                " WHERE id = " + plato.getId() + ";";

        try (Statement stm = con.createStatement()) {
            stm.executeUpdate(updateItemMenuQuery);
            stm.executeUpdate(updatePlatoQuery);
        } catch (SQLException e) {
            System.out.println("Error al actualiza el plato");
        }
        return plato;
    }

    @Override
    public void deletePlato(int id) {
        Connection con = DBConnector.getConnector().getConnection();
        String deletePlatoQuery = "DELETE FROM Plato WHERE id = " + id + ";";
        String deleteItemMenuQuery = "DELETE FROM ItemMenu WHERE id = " + id + ";";

        try (Statement stm = con.createStatement()) {
            stm.executeUpdate(deletePlatoQuery);
            stm.executeUpdate(deleteItemMenuQuery);
        } catch (SQLException e) {
            System.out.println("Error al eliminar el plato");
        }
    }

    @Override
    public int obtenerUltimoID() {
        Connection con = DBConnector.getConnector().getConnection();
        String query = "SELECT MAX(id) AS max_id FROM plato;";
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
