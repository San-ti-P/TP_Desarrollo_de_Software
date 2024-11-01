/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package isi.deso.tpdsw.Views;


import javax.swing.*;
/**
 *
 * @author santi
 */
public class VendedorJPanel extends javax.swing.JPanel {

    /**
     * Creates new form VendedorJPanel
     */
    public VendedorJPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        VendedorJPanel = new javax.swing.JPanel();
        ListaVendedoresJPanel = new javax.swing.JPanel();
        VendedorTitleTextField = new javax.swing.JTextField();
        buscadorVendedorTextField = new javax.swing.JTextField();
        buscadorVendedorJLabel = new javax.swing.JLabel();
        btnCrearVendedor = new javax.swing.JButton();
        VendedorJScrollPane = new javax.swing.JScrollPane();
        vendedoresJTable = new javax.swing.JTable();

        VendedorTitleTextField.setBackground(new java.awt.Color(255, 0, 0));
        VendedorTitleTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        VendedorTitleTextField.setText("Lista de Vendedores");
        VendedorTitleTextField.setFocusable(false);
        VendedorTitleTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VendedorTitleTextFieldActionPerformed(evt);
            }
        });

        buscadorVendedorJLabel.setText("Buscador:");

        btnCrearVendedor.setText("Crear Nuevo Vendedor");
        btnCrearVendedor.setToolTipText("");
        btnCrearVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearVendedorActionPerformed(evt);
            }
        });

        vendedoresJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, ""},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Dirección", "Menú", "Acciones"
            }
        ));
        vendedoresJTable.setFillsViewportHeight(true);
        vendedoresJTable.setRowHeight(30);
        VendedorJScrollPane.setViewportView(vendedoresJTable);

        javax.swing.GroupLayout ListaVendedoresJPanelLayout = new javax.swing.GroupLayout(ListaVendedoresJPanel);
        ListaVendedoresJPanel.setLayout(ListaVendedoresJPanelLayout);
        ListaVendedoresJPanelLayout.setHorizontalGroup(
            ListaVendedoresJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ListaVendedoresJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ListaVendedoresJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(VendedorJScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 902, Short.MAX_VALUE)
                    .addComponent(VendedorTitleTextField)
                    .addGroup(ListaVendedoresJPanelLayout.createSequentialGroup()
                        .addComponent(btnCrearVendedor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 532, Short.MAX_VALUE)
                        .addComponent(buscadorVendedorJLabel)
                        .addGap(18, 18, 18)
                        .addComponent(buscadorVendedorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        ListaVendedoresJPanelLayout.setVerticalGroup(
            ListaVendedoresJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ListaVendedoresJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(VendedorTitleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(ListaVendedoresJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buscadorVendedorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscadorVendedorJLabel)
                    .addComponent(btnCrearVendedor))
                .addGap(18, 18, 18)
                .addComponent(VendedorJScrollPane)
                .addContainerGap())
        );

        javax.swing.GroupLayout VendedorJPanelLayout = new javax.swing.GroupLayout(VendedorJPanel);
        VendedorJPanel.setLayout(VendedorJPanelLayout);
        VendedorJPanelLayout.setHorizontalGroup(
            VendedorJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 914, Short.MAX_VALUE)
            .addGroup(VendedorJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(ListaVendedoresJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        VendedorJPanelLayout.setVerticalGroup(
            VendedorJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 542, Short.MAX_VALUE)
            .addGroup(VendedorJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(ListaVendedoresJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 914, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(VendedorJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 542, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(VendedorJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void VendedorTitleTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VendedorTitleTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_VendedorTitleTextFieldActionPerformed

    private void btnCrearVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearVendedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCrearVendedorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ListaVendedoresJPanel;
    private javax.swing.JPanel VendedorJPanel;
    private javax.swing.JScrollPane VendedorJScrollPane;
    private javax.swing.JTextField VendedorTitleTextField;
    private javax.swing.JButton btnCrearVendedor;
    private javax.swing.JLabel buscadorVendedorJLabel;
    private javax.swing.JTextField buscadorVendedorTextField;
    private javax.swing.JTable vendedoresJTable;
    // End of variables declaration//GEN-END:variables
   
    
    public JTable getJTable(){
        return this.vendedoresJTable;
    }
}
