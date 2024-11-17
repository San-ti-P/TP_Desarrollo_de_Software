package isi.deso.tpdsw.Daos;

import isi.deso.tpdsw.Models.EstrategiaTransferencia;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class EstrategiaTransferenciaSQL implements EstrategiaTransferenciaDao{

    @Override
    public void agregarEstrategiaTransferencia(EstrategiaTransferencia e, int id) {

        Connection con = DBConnector.getConnector().getConnection();
        String query = "INSERT INTO EstrategiaTransferencia(cuit, cbu, pagoid) VALUES ('"
                + e.getCuit() + "', '"
                + e.getCbu() + "', "
                + id + ");";
        try (Statement stm = con.createStatement()) {
            int rs = stm.executeUpdate(query);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }

}
