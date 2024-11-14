/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package isi.deso.tpdsw.Daos;

import isi.deso.tpdsw.Models.Cliente;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author maria
 */
public class ClienteSQL implements ClienteDao {

    @Override
    public ArrayList<Cliente> getAll() {
        ArrayList<Cliente> lista = new ArrayList<>();
        Connection con = DBConnector.getConnector().getConnection();
        String query = "SELECT * FROM cliente;";
        try(Statement stm = con.createStatement()) {
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String cuit = rs.getString("cuit");
                String email = rs.getString("email");
                String direccion = rs.getString("direccion");
                //Terminar segun estructura de la bdd
                //Coordenada cord = rs.
                
                //Cliente c = new Cliente(id, nombre, cuit, email, direccion, cord);
                //lista.add(c);
            }
        } catch (SQLException ex) {
            //Logger.getLogger(PersonaJDBC.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Fallo al obtener los datos");
        }
        return lista;
    }

    @Override
    public ArrayList<Cliente> searchByName(String nombre) {
        ArrayList<Cliente> lista = new ArrayList<>();
        Connection con = DBConnector.getConnector().getConnection();
        String query = "SELECT * FROM cliente WHERE nombre LIKE '%"+nombre+"%';";
        try(Statement stm = con.createStatement()) {
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()) {
                int id = rs.getInt("id");
                String nombreReal = rs.getString("nombre");
                String cuit = rs.getString("cuit");
                String email = rs.getString("email");
                String direccion = rs.getString("direccion");
                //Terminar segun estructura de la bdd
                //Coordenada cord = rs.
                
                //Cliente c = new Cliente(id, nombreReal, cuit, email, direccion, cord);
                //lista.add(c);
            }
        } catch (SQLException ex) {
            //Logger.getLogger(PersonaJDBC.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Fallo al obtener los datos");
        }
        return lista;
    }
    
}
