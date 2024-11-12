package isi.deso.tpdsw.Views;

import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import isi.deso.tpdsw.Controllers.ItemMenuController;

public class EditarItemMenuJFrame extends javax.swing.JFrame {

    public EditarItemMenuJFrame(ItemMenuController c) {
        controlador = c;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        TitleJLabel = new javax.swing.JLabel();
        categoriaComboBox = new javax.swing.JComboBox<>();
        aptoVeganoCheckBox = new javax.swing.JCheckBox();
        tipoComboBox = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        campoNombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        campoDescripcion = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        campoPrecio = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        vendedorComboBox = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        tipoJPanel = new javax.swing.JPanel();
        PlatoJPanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        campoCalorias = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        aptoCeliacoCheckBox = new javax.swing.JCheckBox();
        jLabel11 = new javax.swing.JLabel();
        campoPeso = new javax.swing.JTextField();
        BebidaJPanel = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        campoGradAlcohol = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        campoTamanio = new javax.swing.JTextField();
        botonesJPanel = new javax.swing.JPanel();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.PAGE_AXIS));

        TitleJLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        TitleJLabel.setText("Crear Nuevo ItemMenu");

        categoriaComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        tipoComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Plato", "Bebida" }));
        tipoComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoComboBoxActionPerformed(evt);
            }
        });

        jLabel4.setText("Apto vegano:");

        jLabel6.setText("Tipo:");

        jLabel1.setText("Nombre:");

        jLabel3.setText("Descripción:");

        jLabel7.setText("Precio:");

        jLabel8.setText("Categoría:");

        vendedorComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel9.setText("Vendedor:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoDescripcion)
                            .addComponent(campoNombre)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6))
                        .addGap(73, 73, 73)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoPrecio)
                            .addComponent(tipoComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TitleJLabel)
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(109, 109, 109)
                                .addComponent(aptoVeganoCheckBox)))
                        .addGap(0, 84, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(55, 55, 55)
                        .addComponent(categoriaComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(55, 55, 55)
                        .addComponent(vendedorComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TitleJLabel)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(categoriaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(aptoVeganoCheckBox)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vendedorComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tipoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        getContentPane().add(jPanel1);

        tipoJPanel.setLayout(new java.awt.CardLayout());

        jLabel5.setText("Calorías:");

        jLabel10.setText("Apto celíaco:");

        jLabel11.setText("Peso:");

        javax.swing.GroupLayout PlatoJPanelLayout = new javax.swing.GroupLayout(PlatoJPanel);
        PlatoJPanel.setLayout(PlatoJPanelLayout);
        PlatoJPanelLayout.setHorizontalGroup(
            PlatoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PlatoJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PlatoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addGap(40, 40, 40)
                .addGroup(PlatoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PlatoJPanelLayout.createSequentialGroup()
                        .addComponent(aptoCeliacoCheckBox)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(campoPeso, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                    .addComponent(campoCalorias))
                .addContainerGap())
        );
        PlatoJPanelLayout.setVerticalGroup(
            PlatoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PlatoJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PlatoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(campoCalorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PlatoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(aptoCeliacoCheckBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PlatoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(campoPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        tipoJPanel.add(PlatoJPanel, "Plato");

        jLabel12.setText("Grad. alcohol:");

        jLabel13.setText("Tamaño:");

        javax.swing.GroupLayout BebidaJPanelLayout = new javax.swing.GroupLayout(BebidaJPanel);
        BebidaJPanel.setLayout(BebidaJPanelLayout);
        BebidaJPanelLayout.setHorizontalGroup(
            BebidaJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BebidaJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BebidaJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(BebidaJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(campoGradAlcohol)
                    .addComponent(campoTamanio, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))
                .addContainerGap())
        );
        BebidaJPanelLayout.setVerticalGroup(
            BebidaJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BebidaJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BebidaJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(campoGradAlcohol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(BebidaJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(campoTamanio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        tipoJPanel.add(BebidaJPanel, "Bebida");

        getContentPane().add(tipoJPanel);

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");

        javax.swing.GroupLayout botonesJPanelLayout = new javax.swing.GroupLayout(botonesJPanel);
        botonesJPanel.setLayout(botonesJPanelLayout);
        botonesJPanelLayout.setHorizontalGroup(
            botonesJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, botonesJPanelLayout.createSequentialGroup()
                .addContainerGap(114, Short.MAX_VALUE)
                .addComponent(btnAceptar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancelar)
                .addContainerGap())
        );
        botonesJPanelLayout.setVerticalGroup(
            botonesJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, botonesJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(botonesJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        getContentPane().add(botonesJPanel);

        pack();
    }// </editor-fold>                        

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {                                           
        String nombre = this.getCampoNombre().getText();
        String descripcion = this.getCampoDescripcion().getText();
        String precio = this.getCampoPrecio().getText();
        String categoria = this.getCategoriaComboBox().getSelectedItem().toString();
        String aptoVegano = this.getAptoVeganoCheckBox().getText();
        String vendedor = this.getVendedorComboBox().getSelectedItem().toString();
        String tipo = this.getTipoComboBox().getSelectedItem().toString();
        
        if(tipo.equalsIgnoreCase("Bebida")){
            String gradAlcohol = this.getCampoGradAlcohol().getText();
            String tamanio = this.getCampoTamanio().getText();
            controlador.editarBebida(nombre, descripcion, precio, categoria, aptoVegano, vendedor, gradAlcohol, tamanio);
        }
        else if(tipo.equalsIgnoreCase("Plato")){
            String calorias = this.getCampoCalorias().getText();
            String aptoCeliaco = this.getAptoCeliacoCheckBox().getText();
            String peso = this.getCampoPeso().getText();
            controlador.editarPlato(nombre, descripcion, precio, categoria, aptoVegano, vendedor, calorias, aptoCeliaco, peso);
        }
        
        this.setVisible(false);
    }                                          

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {                                            
        this.setVisible(false);
    }
      
    private void tipoComboBoxActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
        CardLayout ly = (CardLayout) tipoJPanel.getLayout();
        String sel = (String)tipoComboBox.getSelectedItem();
        if(sel.equals("Plato")){
            ly.show(tipoJPanel, "Plato");
        }
        else if(sel.equals("Bebida")){
            ly.show(tipoJPanel, "Bebida");
        }
    }                                            


    // Variables declaration - do not modify                     
    private javax.swing.JPanel BebidaJPanel;
    private javax.swing.JPanel PlatoJPanel;
    private javax.swing.JLabel TitleJLabel;
    private javax.swing.JCheckBox aptoCeliacoCheckBox;
    private javax.swing.JCheckBox aptoVeganoCheckBox;
    private javax.swing.JPanel botonesJPanel;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JTextField campoCalorias;
    private javax.swing.JTextField campoDescripcion;
    private javax.swing.JTextField campoGradAlcohol;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JTextField campoPeso;
    private javax.swing.JTextField campoPrecio;
    private javax.swing.JTextField campoTamanio;
    private javax.swing.JComboBox<String> categoriaComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> tipoComboBox;
    private javax.swing.JPanel tipoJPanel;
    private javax.swing.JComboBox<String> vendedorComboBox;
    // End of variables declaration                   
    private ItemMenuController controlador;
    
    public JPanel getBebidaJPanel() {
        return BebidaJPanel;
    }

    public void setBebidaJPanel(JPanel BebidaJPanel) {
        this.BebidaJPanel = BebidaJPanel;
    }

    public JPanel getPlatoJPanel() {
        return PlatoJPanel;
    }

    public void setPlatoJPanel(JPanel PlatoJPanel) {
        this.PlatoJPanel = PlatoJPanel;
    }

    public JLabel getTitleJLabel() {
        return TitleJLabel;
    }

    public void setTitleJLabel(JLabel TitleJLabel) {
        this.TitleJLabel = TitleJLabel;
    }

    public JCheckBox getAptoCeliacoCheckBox() {
        return aptoCeliacoCheckBox;
    }

    public void setAptoCeliacoCheckBox(JCheckBox aptoCeliacoCheckBox) {
        this.aptoCeliacoCheckBox = aptoCeliacoCheckBox;
    }

    public JCheckBox getAptoVeganoCheckBox() {
        return aptoVeganoCheckBox;
    }

    public void setAptoVeganoCheckBox(JCheckBox aptoVeganoCheckBox) {
        this.aptoVeganoCheckBox = aptoVeganoCheckBox;
    }

    public JPanel getBotonesJPanel() {
        return botonesJPanel;
    }

    public void setBotonesJPanel(JPanel botonesJPanel) {
        this.botonesJPanel = botonesJPanel;
    }

    public JButton getBtnAceptar() {
        return btnAceptar;
    }

    public void setBtnAceptar(JButton btnAceptar) {
        this.btnAceptar = btnAceptar;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }

    public void setBtnCancelar(JButton btnCancelar) {
        this.btnCancelar = btnCancelar;
    }

    public JTextField getCampoCalorias() {
        return campoCalorias;
    }

    public void setCampoCalorias(JTextField campoCalorias) {
        this.campoCalorias = campoCalorias;
    }

    public JTextField getCampoDescripcion() {
        return campoDescripcion;
    }

    public void setCampoDescripcion(JTextField campoDescripcion) {
        this.campoDescripcion = campoDescripcion;
    }

    public JTextField getCampoGradAlcohol() {
        return campoGradAlcohol;
    }

    public void setCampoGradAlcohol(JTextField campoGradAlcohol) {
        this.campoGradAlcohol = campoGradAlcohol;
    }

    public JTextField getCampoNombre() {
        return campoNombre;
    }

    public void setCampoNombre(JTextField campoNombre) {
        this.campoNombre = campoNombre;
    }

    public JTextField getCampoPeso() {
        return campoPeso;
    }

    public void setCampoPeso(JTextField campoPeso) {
        this.campoPeso = campoPeso;
    }

    public JTextField getCampoPrecio() {
        return campoPrecio;
    }

    public void setCampoPrecio(JTextField campoPrecio) {
        this.campoPrecio = campoPrecio;
    }

    public JTextField getCampoTamanio() {
        return campoTamanio;
    }

    public void setCampoTamanio(JTextField campoTamanio) {
        this.campoTamanio = campoTamanio;
    }

    public JComboBox<String> getCategoriaComboBox() {
        return categoriaComboBox;
    }

    public void setCategoriaComboBox(JComboBox<String> categoriaComboBox) {
        this.categoriaComboBox = categoriaComboBox;
    }

    public JComboBox<String> getTipoComboBox() {
        return tipoComboBox;
    }

    public void setTipoComboBox(JComboBox<String> tipoComboBox) {
        this.tipoComboBox = tipoComboBox;
    }

    public JComboBox<String> getVendedorComboBox() {
        return vendedorComboBox;
    }

    public void setVendedorComboBox(JComboBox<String> vendedorComboBox) {
        this.vendedorComboBox = vendedorComboBox;
    }
}
