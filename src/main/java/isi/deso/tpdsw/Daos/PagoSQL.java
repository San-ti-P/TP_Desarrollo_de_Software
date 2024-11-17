package isi.deso.tpdsw.Daos;

import isi.deso.tpdsw.Models.EstrategiaMercadoPago;
import isi.deso.tpdsw.Models.EstrategiaTransferencia;
import isi.deso.tpdsw.Models.Pago;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PagoSQL implements PagoDao {

    @Override
    public ArrayList<Pago> getAll() {
        return null;
    }
    @Override
    public void agregarPago(Pago pago, String tipo) {
        Connection con = DBConnector.getConnector().getConnection();
        int id = obtenerUltimoID() + 1;
        java.sql.Date sqlDate = new java.sql.Date(pago.getFecha().getTime());
        String query = "INSERT INTO pago(fecha, montoFinal, pedidoId) VALUES ('"
                + sqlDate + "', '"
                + pago.getMontoFinal() + "', "
                + pago.getPedido().getId() + ");";
        try (Statement stm = con.createStatement()) {
            int rs = stm.executeUpdate(query);
            if (tipo.equalsIgnoreCase("transferencia")) {
                (new EstrategiaTransferenciaSQL()).agregarEstrategiaTransferencia((EstrategiaTransferencia) pago.getEstrategia(), id);
            } else if (tipo.equalsIgnoreCase("mercadoPago")) {
                (new EstrategiaMercadoPagoSQL()).agregarEstrategiaMercadoPago((EstrategiaMercadoPago) pago.getEstrategia(), id);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int obtenerUltimoID() {
        Connection con = DBConnector.getConnector().getConnection();
        String query = "SELECT MAX(id) AS max_id FROM pago;";
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
