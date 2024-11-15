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
        String query = "SELECT * FROM item_menu im, bebida b WHERE im.id = b.id;";
        try (Statement stm = con.createStatement()) {
            ResultSet rs = stm.executeQuery(query);
            int id = rs.getInt("id");
            String nombre = rs.getString("nombre");
            String descripcion = rs.getString("descripcion");
            float precio = rs.getFloat("precio");
            int vendedorId = rs.getInt("vendedor_id");
            Vendedor vendedor = vendedorDao.getVendedorById(vendedorId);

            float graduacionAlcoholica = rs.getFloat("graduacion_alcoholica");
            int tamaño = rs.getInt("tamaño");
            boolean aptoVegano = rs.getBoolean("apto_vegano");
            Categoria categoria = Categoria.valueOf(rs.getString("categoria"));
            lista.add(new Bebida(id, nombre, descripcion, precio, categoria, graduacionAlcoholica, tamaño, aptoVegano, vendedor));
                
        } catch (SQLException ex) {
            //Logger.getLogger(PersonaJDBC.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Fallo al obtener los datos");
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
}
