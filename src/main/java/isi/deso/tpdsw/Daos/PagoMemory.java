package isi.deso.tpdsw.Daos;

import isi.deso.tpdsw.Models.Pago;
import java.util.ArrayList;

public class PagoMemory implements PagoDao{

    @Override
    public ArrayList<Pago> getAll() {
        ArrayList<Pago> pagos = new ArrayList<>();
        // Add logic to populate the list with Pago objects
        // Example:
        // pagos.add(new Pago(...));
        return pagos;
    }
}
