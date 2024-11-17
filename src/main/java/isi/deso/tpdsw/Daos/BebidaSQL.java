package isi.deso.tpdsw.Daos;

import isi.deso.tpdsw.Models.Bebida;
import isi.deso.tpdsw.Models.Categoria;
import isi.deso.tpdsw.Models.Vendedor;
import isi.deso.tpdsw.Services.CategoriaDaoFactory;
import isi.deso.tpdsw.Services.VendedorDaoFactory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BebidaSQL implements BebidaDao{
    private VendedorDao vendedorDao;
    private CategoriaDao categoriaDao;
    
    public BebidaSQL(){
        this.vendedorDao = (new VendedorDaoFactory()).getDao("sql");
        this.categoriaDao = (new CategoriaDaoFactory()).getDao("sql");
    }

    @Override
    public ArrayList<Bebida> getAll() {
        ArrayList<Bebida> lista = new ArrayList<>();
        Connection con = DBConnector.getConnector().getConnection();
        String query = "SELECT * FROM itemmenu im, bebida b WHERE im.id = b.id AND im.activo=1;";
        try (Statement stm = con.createStatement()) {
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                float precio = rs.getFloat("precio");
                int categoriaId = rs.getInt("categoriaId");
                boolean aptoVegano = rs.getBoolean("aptoVegano");
                int vendedorId = rs.getInt("vendedorId");

                Vendedor vendedor = vendedorDao.getVendedorById(vendedorId);
                Categoria categoria = categoriaDao.getCategoriaById(categoriaId);

                int id = rs.getInt("id");
                float graduacionAlcoholica = rs.getFloat("graduacionAlcoholica");
                int tamaño = rs.getInt("tamaño");
                lista.add(new Bebida(id, nombre, descripcion, precio, categoria, graduacionAlcoholica, tamaño, aptoVegano, vendedor));
            }
        } catch (SQLException ex) {
            System.out.println("Fallo al obtener los datos en getAll Bebida");
        }
        return lista;
    }

    @Override
    public ArrayList<Bebida> searchByName(String nombre) {
        ArrayList<Bebida> lista = new ArrayList<>();
        Connection con = DBConnector.getConnector().getConnection();
        String query = "SELECT * FROM itemmenu im, bebida b WHERE im.id = b.id AND im.activo=1 AND im.nombre LIKE '%"+nombre+"%';";
        try (Statement stm = con.createStatement()) {
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombreReal = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                float precio = rs.getFloat("precio");
                int categoriaId = rs.getInt("categoriaId");
                int vendedorId = rs.getInt("vendedorId");

                Vendedor vendedor = vendedorDao.getVendedorById(vendedorId);
                Categoria categoria = categoriaDao.getCategoriaById(categoriaId);

                float graduacionAlcoholica = rs.getFloat("graduacionAlcoholica");
                int tamaño = rs.getInt("tamaño");
                boolean aptoVegano = rs.getBoolean("aptoVegano");
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
        String updateItemMenuQuery = "UPDATE itemmenu SET " +
                "nombre = '" + bebida.getNombre() + "', " +
                "descripcion = '" + bebida.getDescripcion() + "', " +
                "precio = " + bebida.getPrecio() + ", " +
                "categoriaId = '" + bebida.getCategoria().getId() + "', " +
                "aptoVegano = " + bebida.getAptoVegano() + ", " +
                "vendedor_id = " + bebida.getVendedor().getId() +
                " WHERE id = " + bebida.getId() + ";";

        String updateBebidaQuery = "UPDATE bebida SET " +
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
        String insertItemMenuQuery = "INSERT INTO itemmenu (id, nombre, descripcion, precio, categoriaId, aptoVegano, vendedorId, activo) VALUES ("
                + bebida.getId() + ", '"
                + bebida.getNombre() + "', '"
                + bebida.getDescripcion() + "', "
                + bebida.getPrecio() + ", '"
                + bebida.getCategoria().getId() + "', "
                + bebida.getAptoVegano() + ", "
                + bebida.getVendedor().getId() + ", "
                + "true);";

        String insertBebidaQuery = "INSERT INTO bebida (id, graduacionAlcoholica, tamaño) VALUES ("
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
        String deleteItemMenuQuery = "UPDATE itemmenu SET activo = false WHERE id = " + id + ";";

        try (Statement stm = con.createStatement()) {
            stm.executeUpdate(deleteItemMenuQuery);
        } catch (SQLException e) {
            System.out.println("Error al eliminar la bebida");
        }
    }

    @Override
    public ArrayList<Bebida> getByVendedor(Vendedor v){
        ArrayList<Bebida> lista = new ArrayList<>();
        int idVendedor = v.getId();
        Connection con = DBConnector.getConnector().getConnection();
        String query = "SELECT * FROM itemmenu im, bebida b WHERE im.id = b.id AND im.activo=1 AND im.vendedorId="+idVendedor+";";
        try (Statement stm = con.createStatement()) {
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                float precio = rs.getFloat("precio");
                int categoriaId = rs.getInt("categoriaId");
                boolean aptoVegano = rs.getBoolean("aptoVegano");
                
                Categoria categoria = categoriaDao.getCategoriaById(categoriaId);

                int id = rs.getInt("im.id");
                float graduacionAlcoholica = rs.getFloat("graduacionAlcoholica");
                int tamaño = rs.getInt("tamaño");
                lista.add(new Bebida(id, nombre, descripcion, precio, categoria, graduacionAlcoholica, tamaño, aptoVegano, v));
            }
        } catch (SQLException ex) {
            System.out.println("Fallo al obtener los datos en getAll Bebida");
        }
        return lista;
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

    @Override
    public Bebida getById(int id) {
        Connection con = DBConnector.getConnector().getConnection();
        String query = "SELECT * FROM itemmenu im, bebida b WHERE im.id = b.id AND im.activo=1 AND im.id="+id+";";
        try (Statement stm = con.createStatement()) {
            ResultSet rs = stm.executeQuery(query);
            if (rs.next()) {
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                float precio = rs.getFloat("precio");
                int vendedorId = rs.getInt("vendedorId");
                int categoriaId = rs.getInt("categoriaId");

                Vendedor vendedor = vendedorDao.getVendedorById(vendedorId);
                Categoria categoria = categoriaDao.getCategoriaById(categoriaId);

                float graduacionAlcoholica = rs.getFloat("graduacionAlcoholica");
                int tamaño = rs.getInt("tamaño");
                boolean aptoVegano = rs.getBoolean("aptoVegano");
                return new Bebida(id, nombre, descripcion, precio, categoria, graduacionAlcoholica, tamaño, aptoVegano, vendedor);
            }
            else return null;
        } catch (SQLException ex) {
            System.out.println("Fallo al obtener los datos en getAll Plato");
        }
        return null;
    }
}
