package isi.deso.tpdsw.Views;

import isi.deso.tpdsw.Controllers.ItemMenuController;
import isi.deso.tpdsw.Models.ItemMenu;
import isi.deso.tpdsw.Models.ItemPedido;
import isi.deso.tpdsw.Models.Vendedor;
import isi.deso.tpdsw.Services.BebidaDaoFactory;
import isi.deso.tpdsw.Services.PlatoDaoFactory;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class SeleccionarItemsPedidoFormJFrame extends javax.swing.JFrame {

    public SeleccionarItemsPedidoFormJFrame(PedidosFormJFrame pedidosForm, Vendedor v) {
        initComponents();
        this.pedidosForm = pedidosForm;
        controlador = new ItemMenuController(null, (new BebidaDaoFactory().getDao("sql")), (new PlatoDaoFactory().getDao("sql")));
        //Aca se deben cargar en la tabla todos los items del vendedor
        ArrayList<ItemMenu> items = controlador.getByVendedor(v);
        DefaultTableModel modelo = ((DefaultTableModel)jTable.getModel());
        for(ItemMenu i: items){
            modelo.addRow(new Object[]{i.getId(), i.getNombre(), i.getCategoria(), i.getPrecio(), 0});
        }
        
    }

    public SeleccionarItemsPedidoFormJFrame(EditarPedidoJFrame editarForm, Vendedor v) {
        initComponents();
        this.editarForm = editarForm;
        controlador = new ItemMenuController(null, (new BebidaDaoFactory().getDao("sql")), (new PlatoDaoFactory().getDao("sql")));
        //Aca se deben cargar en la tabla todos los items del vendedor
        ArrayList<ItemMenu> items = controlador.getByVendedor(v);
        DefaultTableModel modelo = ((DefaultTableModel)jTable.getModel());
        for(ItemMenu i: items){
            modelo.addRow(new Object[]{i.getId(), i.getNombre(), i.getCategoria(), i.getPrecio(), 0});
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Categoría", "Precio", "Cantidad"
            }
        ));
        jScrollPane1.setViewportView(jTable);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Seleccionar Items");

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(298, Short.MAX_VALUE)
                .addComponent(btnAceptar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancelar)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 367, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(51, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(38, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        ArrayList<ItemPedido> items = new ArrayList<>();
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        int filas = model.getRowCount();
        for(int i=0; i<filas; i++){
            int cant = Integer.parseInt(model.getValueAt(i, 4).toString());
            if(cant!=0){
                //Solicitar ItemMenu a la bdd
                int id = Integer.parseInt(model.getValueAt(i, 0).toString());
                ItemMenu item = controlador.getById(id);

                
                ItemPedido nuevo = new ItemPedido(item, cant, null);
                items.add(nuevo);
            }
        }
        if(pedidosForm == null) this.editarForm.setItems(items);
        else this.pedidosForm.setItems(items);
        this.setVisible(false);
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    // End of variables declaration//GEN-END:variables
    private PedidosFormJFrame pedidosForm;
    private EditarPedidoJFrame editarForm;
    private ItemMenuController controlador;
}
