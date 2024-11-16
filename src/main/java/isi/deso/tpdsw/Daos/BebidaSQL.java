package isi.deso.tpdsw.Daos;

import isi.deso.tpdsw.Models.Bebida;
import isi.deso.tpdsw.Models.Categoria;
import isi.deso.tpdsw.Models.Vendedor;
import isi.deso.tpdsw.Services.VendedorDaoFactory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BebidaSQL implements BebidaDao{
    private VendedorDao vendedorDao;
    
    public BebidaSQL(){
        this.vendedorDao = (new VendedorDaoFactory()).getDao("sql");
    }

    @Override
    public ArrayList<Bebida> getAll() {
        ArrayList<Bebida> lista = new ArrayList<>();
        Connection con = DBConnector.getConnector().getConnection();
        String query = "SELECT * FROM itemMenu im, bebida b WHERE im.id = b.id;";
        try (Statement stm = con.createStatement()) {
            ResultSet rs = stm.executeQuery(query);
            if (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                float precio = rs.getFloat("precio");
                int vendedorId = rs.getInt("vendedor_id");
                Vendedor vendedor = vendedorDao.getVendedorById(vendedorId);

                float graduacionAlcoholica = rs.getFloat("graduacionAlcoholica");
                int tamaño = rs.getInt("tamaño");
                boolean aptoVegano = rs.getBoolean("aptoVegano");
                Categoria categoria = Categoria.valueOf(rs.getString("categoria"));
                lista.add(new Bebida(id, nombre, descripcion, precio, categoria, graduacionAlcoholica, tamaño, aptoVegano, vendedor));
            }
        } catch (SQLException ex) {
            //Logger.getLogger(PersonaJDBC.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Fallo al obtener los datos en getAll Bebida");
        }
        return lista;
    }

    @Override
    public ArrayList<Bebida> searchByName(String nombre) {
        ArrayList<Bebida> lista = new ArrayList<>();
        Connection con = DBConnector.getConnector().getConnection();
        String query = "SELECT * FROM item_menu im, bebida b WHERE im.id = b.id AND im.nombre LIKE '%"+nombre+"%';";
        try (Statement stm = con.createStatement()) {
            ResultSet rs = stm.executeQuery(query);
            if (rs.next()) {
                int id = rs.getInt("id");
                String nombreReal = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                float precio = rs.getFloat("precio");
                int vendedorId = rs.getInt("vendedor_id");
                Vendedor vendedor = vendedorDao.getVendedorById(vendedorId);

                float graduacionAlcoholica = rs.getFloat("graduacion_alcoholica");
                int tamaño = rs.getInt("tamaño");
                boolean aptoVegano = rs.getBoolean("apto_vegano");
                Categoria categoria = Categoria.valueOf(rs.getString("categoria"));
                lista.add(new Bebida(id, nombreReal, descripcion, precio, categoria, graduacionAlcoholica, tamaño, aptoVegano, vendedor));
            }
            
        } catch (SQLException ex) {
            System.out.println("Fallo al obtener el item");
        }
        return lista;
    }

    @Override
    public Bebida updateBebida(Bebida bebida) {
        Connection con = DBConnector.getConnector().getConnection();
        String updateItemMenuQuery = "UPDATE ItemMenu SET " +
                "nombre = '" + bebida.getNombre() + "', " +
                "descripcion = '" + bebida.getDescripcion() + "', " +
                "precio = " + bebida.getPrecio() + ", " +
                "categoria_id = '" + bebida.getCategoria().getId() + "', " +
                "aptoVegano = " + bebida.getAptoVegano() + ", " +
                "vendedor_id = " + bebida.getVendedor().getId() +
                " WHERE id = " + bebida.getId() + ";";

        String updateBebidaQuery = "UPDATE Bebida SET " +
                "graduacionAlcoholica = " + bebida.getGraduacionAlcoholica() + ", " +
                "tamaño = " + bebida.getTamaño() +
                " WHERE id = " + bebida.getId() + ";";

        try (Statement stm = con.createStatement()) {
            stm.executeUpdate(updateItemMenuQuery);
            stm.executeUpdate(updateBebidaQuery);
        } catch (SQLException e) {
            System.out.println("Error al actualizar la bebida");
        }
        return bebida;
    }

    @Override
    public Bebida createBebida(Bebida bebida) {
        Connection con = DBConnector.getConnector().getConnection();
        String insertItemMenuQuery = "INSERT INTO ItemMenu (id, nombre, descripcion, precio, categoria_id, aptoVegano, vendedor_id, activo) VALUES ("
                + bebida.getId() + ", '"
                + bebida.getNombre() + "', '"
                + bebida.getDescripcion() + "', "
                + bebida.getPrecio() + ", '"
                + bebida.getCategoria().getId() + "', "
                + bebida.getAptoVegano() + ", "
                + bebida.getVendedor().getId() + ", "
                + "true);";

        String insertBebidaQuery = "INSERT INTO Bebida (id, graduacionAlcoholica, tamaño) VALUES ("
                + bebida.getId() + ", "
                + bebida.getGraduacionAlcoholica() + ", "
                + bebida.getTamaño() + ");";

        try (Statement stm = con.createStatement()) {
            stm.executeUpdate(insertItemMenuQuery);
            stm.executeUpdate(insertBebidaQuery);
        } catch (SQLException e) {
            System.out.println("Error al crear la bebida");
        }
        return bebida;
    }

    @Override
    public void deleteBebida(int id) {
        Connection con = DBConnector.getConnector().getConnection();
        String deleteBebidaQuery = "DELETE FROM Bebida WHERE id = " + id + ";";
        String deleteItemMenuQuery = "DELETE FROM ItemMenu WHERE id = " + id + ";";

        try (Statement stm = con.createStatement()) {
            stm.executeUpdate(deleteBebidaQuery);
            stm.executeUpdate(deleteItemMenuQuery);
        } catch (SQLException e) {
            System.out.println("Error al eliminar la bebida");
        }
    }

    @Override
    public int obtenerUltimoID() {
        Connection con = DBConnector.getConnector().getConnection();
        String query = "SELECT MAX(id) AS max_id FROM bebida;";
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
