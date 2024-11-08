package isi.deso.tpdsw.Views;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.table.DefaultTableModel;

abstract public class BuscadorJPanel extends JPanel{
    
    public BuscadorJPanel(String [] jTableColumns) {
        initComponents(jTableColumns);
    }
                            
    private void initComponents(String [] jTableColumns) {

        tableJScrollPane = new JScrollPane();
        tablaJTable = new JTable();
        btnCrear = new JButton();
        buscadorJLabel = new JLabel();
        buscadorTextField = new JTextField();
        titleTextField = new JTextField();

        tablaJTable.setModel(new DefaultTableModel(
            new Object [][] {}, jTableColumns
        ));
        tablaJTable.setFillsViewportHeight(true);
        tablaJTable.setRowHeight(30);

        tableJScrollPane.setViewportView(tablaJTable);

        //btnCrear.setText("Crear Nuevo Vendedor");
        btnCrear.setToolTipText("");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        buscadorJLabel.setText("Buscador:");

        titleTextField.setBackground(new java.awt.Color(255, 0, 0));
        titleTextField.setHorizontalAlignment(JTextField.CENTER);
        //titleTextField.setText("Lista de Vendedores");
        titleTextField.setFocusable(false);
        titleTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                titleTextFieldActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 914, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(tableJScrollPane, GroupLayout.DEFAULT_SIZE, 902, Short.MAX_VALUE)
                        .addComponent(titleTextField)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnCrear)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 532, Short.MAX_VALUE)
                            .addComponent(buscadorJLabel)
                            .addGap(18, 18, 18)
                            .addComponent(buscadorTextField, GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 542, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(titleTextField, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(buscadorTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(buscadorJLabel)
                        .addComponent(btnCrear))
                    .addGap(18, 18, 18)
                    .addComponent(tableJScrollPane)
                    .addContainerGap()))
        );
    }                                               
                   
    private JScrollPane tableJScrollPane;
    private JTextField titleTextField;
    private JButton btnCrear;
    private JLabel buscadorJLabel;
    private JTextField buscadorTextField;
    private JTable tablaJTable;                  
   
    public JButton getBtnCrear(){
        return btnCrear;
    }
    
    public JTextField getTitleTextField(){
        return titleTextField;
    }
    
    public JTable getJTable(){
        return this.tablaJTable;
    }
    
    //abstract 
    void titleTextFieldActionPerformed(java.awt.event.ActionEvent evt){}                                                   

    //abstract
    void btnCrearActionPerformed(java.awt.event.ActionEvent evt){} 
}
