package isi.deso.tpdsw.Daos;

import isi.deso.tpdsw.Models.Categoria;
import isi.deso.tpdsw.Models.Plato;
import isi.deso.tpdsw.Models.Vendedor;
import isi.deso.tpdsw.Services.CategoriaDaoFactory;
import isi.deso.tpdsw.Services.VendedorDaoFactory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PlatoSQL implements PlatoDao{
    private VendedorDao vendedorDao;
    private CategoriaDao categoriaDao;
    public PlatoSQL(){
        this.vendedorDao = (new VendedorDaoFactory()).getDao("sql");
        this.categoriaDao = (new CategoriaDaoFactory()).getDao("sql");
    }

    @Override
    public ArrayList<Plato> getAll() {
        ArrayList<Plato> lista = new ArrayList<>();
        Connection con = DBConnector.getConnector().getConnection();
        String query = "SELECT * FROM itemmenu im, plato p WHERE im.id = p.id AND im.activo=1;";
        try (Statement stm = con.createStatement()) {
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombreReal = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                float precio = rs.getFloat("precio");
                int vendedorId = rs.getInt("vendedorId");
                int categoriaId = rs.getInt("categoriaId");

                Vendedor vendedor = vendedorDao.getVendedorById(vendedorId);
                Categoria categoria = categoriaDao.getCategoriaById(categoriaId);

                int calorias = rs.getInt("calorias");
                boolean aptoCeliaco = rs.getBoolean("aptoCeliaco");
                float peso = rs.getFloat("peso");
                boolean aptoVegano = rs.getBoolean("aptoVegano");
                lista.add(new Plato(id, nombreReal, descripcion, calorias, aptoCeliaco, peso, precio, categoria, aptoVegano, vendedor));
            }
        } catch (SQLException ex) {
            System.out.println("Fallo al obtener los datos en getAll Plato");
        }
        return lista;
    }

    @Override
    public ArrayList<Plato> searchByName(String nombre) {
        ArrayList<Plato> lista = new ArrayList<>();
        Connection con = DBConnector.getConnector().getConnection();
        String query = "SELECT * FROM itemmenu im, plato p WHERE im.id = p.id AND im.activo=1 AND im.nombre LIKE '%"+nombre+"%';";
        try (Statement stm = con.createStatement()) {
            ResultSet rs = stm.executeQuery(query);
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String nombreReal = rs.getString("nombre");
                    String descripcion = rs.getString("descripcion");
                    float precio = rs.getFloat("precio");
                    int vendedorId = rs.getInt("vendedorId");
                    int categoriaId = rs.getInt("categoriaId");

                    Vendedor vendedor = vendedorDao.getVendedorById(vendedorId);
                    Categoria categoria = categoriaDao.getCategoriaById(categoriaId);

                    int calorias = rs.getInt("calorias");
                    boolean aptoCeliaco = rs.getBoolean("aptoCeliaco");
                    float peso = rs.getFloat("peso");
                    boolean aptoVegano = rs.getBoolean("aptoVegano");
                    lista.add(new Plato(id, nombreReal, descripcion, calorias, aptoCeliaco, peso, precio, categoria, aptoVegano, vendedor));
                }
        } catch (SQLException ex) {
            System.out.println("Fallo al obtener el item");
        }
        return lista;
    }

    @Override
    public Plato createPlato(Plato plato) {
        Connection con = DBConnector.getConnector().getConnection();

        String insertItemMenuQuery = "INSERT INTO itemmenu (id, nombre, descripcion, precio, categoriaId, aptoVegano, vendedorId, activo) VALUES ("
                + plato.getId() + ", '"
                + plato.getNombre() + "', '"
                + plato.getDescripcion() + "', "
                + plato.getPrecio() + ", '"
                + plato.getCategoria().getId() + "', "
                + plato.getAptoVegano() + ", "
                + plato.getVendedor().getId() + ", "
                + "true);";

        String insertPlatoQuery = "INSERT INTO plato (id, calorias, aptoCeliaco, peso) VALUES ("
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
        String updateItemMenuQuery = "UPDATE itemmenu SET " +
                "nombre = '" + plato.getNombre() + "', " +
                "descripcion = '" + plato.getDescripcion() + "', " +
                "precio = " + plato.getPrecio() + ", " +
                "categoriaId = '" + plato.getCategoria().getId() + "', " +
                "aptoVegano = " + plato.getAptoVegano() + ", " +
                "vendedorId = " + plato.getVendedor().getId() +
                " WHERE id = " + plato.getId() + ";";

        String updatePlatoQuery = "UPDATE plato SET " +
                "calorias = " + plato.getCalorias() + ", " +
                "aptoCeliaco = " + plato.getAptoCeliaco() + ", " +
                "peso = " + plato.getPeso() +
                " WHERE id = " + plato.getId() + ";";

        try (Statement stm = con.createStatement()) {
            stm.executeUpdate(updateItemMenuQuery);
            stm.executeUpdate(updatePlatoQuery);
            System.out.println("Inserte plato + item");
        } catch (SQLException e) {
            System.out.println("Error al actualiza el plato");
        }
        return plato;
    }

    @Override
    public void deletePlato(int id) {
        Connection con = DBConnector.getConnector().getConnection();
        String deleteItemMenuQuery = "UPDATE itemmenu SET activo = false WHERE id = " + id + ";";

        try (Statement stm = con.createStatement()) {
            stm.executeUpdate(deleteItemMenuQuery);
        } catch (SQLException e) {
            System.out.println("Error al eliminar el plato");
        }
    }

    @Override
    public ArrayList<Plato> getByVendedor(Vendedor v) {
        ArrayList<Plato> lista = new ArrayList<>();
        int idVendedor = v.getId();
        Connection con = DBConnector.getConnector().getConnection();
        String query = "SELECT * FROM itemmenu im, plato p WHERE im.id = p.id AND im.activo=1 AND im.vendedorId="+idVendedor+";";
        try (Statement stm = con.createStatement()) {
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("im.id");
                String nombreReal = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                float precio = rs.getFloat("precio");
                int categoriaId = rs.getInt("categoriaId");

                Categoria categoria = categoriaDao.getCategoriaById(categoriaId);

                int calorias = rs.getInt("calorias");
                boolean aptoCeliaco = rs.getBoolean("aptoCeliaco");
                float peso = rs.getFloat("peso");
                boolean aptoVegano = rs.getBoolean("aptoVegano");
                lista.add(new Plato(id, nombreReal, descripcion, calorias, aptoCeliaco, peso, precio, categoria, aptoVegano, v));
            }
        } catch (SQLException ex) {
            System.out.println("Fallo al obtener los datos en getAll Plato");
        }
        return lista;
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

    @Override
    public Plato getById(int id) {
        Connection con = DBConnector.getConnector().getConnection();
        String query = "SELECT * FROM itemmenu im, plato p WHERE im.id = p.id AND im.activo=1 AND im.id="+id+";";
        try (Statement stm = con.createStatement()) {
            ResultSet rs = stm.executeQuery(query);
            if (rs.next()) {
                String nombreReal = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                float precio = rs.getFloat("precio");
                int vendedorId = rs.getInt("vendedorId");
                int categoriaId = rs.getInt("categoriaId");

                Vendedor vendedor = vendedorDao.getVendedorById(vendedorId);
                Categoria categoria = categoriaDao.getCategoriaById(categoriaId);

                int calorias = rs.getInt("calorias");
                boolean aptoCeliaco = rs.getBoolean("aptoCeliaco");
                float peso = rs.getFloat("peso");
                boolean aptoVegano = rs.getBoolean("aptoVegano");
                return new Plato(id, nombreReal, descripcion, calorias, aptoCeliaco, peso, precio, categoria, aptoVegano, vendedor);
            }
            else return null;
        } catch (SQLException ex) {
            System.out.println("Fallo al obtener los datos en getAll Plato");
        }
        return null;
    }
}
