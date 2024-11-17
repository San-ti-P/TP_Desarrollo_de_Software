package isi.deso.tpdsw.Daos;

import isi.deso.tpdsw.Models.EstrategiaMercadoPago;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class EstrategiaMercadoPagoSQL implements EstrategiaMercadoPagoDao {

    @Override
    public void agregarEstrategiaMercadoPago(EstrategiaMercadoPago e, int id) {

        Connection con = DBConnector.getConnector().getConnection();
        String query = "INSERT INTO EstrategiaMercadoPago(alias, pagoid) VALUES ('"
                + e.getAlias() + "', "
                + id + ");";
        try (Statement stm = con.createStatement()) {
            int rs = stm.executeUpdate(query);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }
}
