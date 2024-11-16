package isi.deso.tpdsw.Views;

import isi.deso.tpdsw.Controllers.ClienteController;
import isi.deso.tpdsw.Controllers.PedidoController;
import isi.deso.tpdsw.Controllers.VendedorController;
import isi.deso.tpdsw.Models.Cliente;
import isi.deso.tpdsw.Models.EstadoPedido;
import isi.deso.tpdsw.Models.ItemPedido;
import isi.deso.tpdsw.Models.Pedido;
import isi.deso.tpdsw.Models.Vendedor;
import isi.deso.tpdsw.Services.ClienteDaoFactory;
import isi.deso.tpdsw.Services.VendedorDaoFactory;

import java.util.ArrayList;
import javax.swing.*;


public class EditarPedidoJFrame extends javax.swing.JFrame {

    public EditarPedidoJFrame(PedidoController c) {
        controlador = c;
        initComponents();
        controladorVendedor = new VendedorController((new VendedorDaoFactory()).getDao("sql"));
        controladorCliente = new ClienteController((new ClienteDaoFactory()).getDao("sql"));
        cargarVendedores();
        cargarClientes();
        items = new ArrayList<>();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        clienteComboBox = new javax.swing.JComboBox<>();
        vendedorComboBox = new javax.swing.JComboBox<>();
        btnSeleccionar = new javax.swing.JButton();
        campoSubtotal = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        estadoComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        jLabel1.setText("Cliente:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Editar Pedido");

        jLabel3.setText("Vendedor:");

        jLabel7.setText("Items:");

        jLabel8.setText("Subtotal:");

        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

        campoSubtotal.setFocusable(false);

        jLabel9.setText("Estado:");

        estadoComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "RECIBIDO", "EN_PREPARACION", "EN_ENVIO", "ENTREGADO" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                                .addComponent(btnAceptar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCancelar))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(clienteComboBox, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(vendedorComboBox, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnSeleccionar)
                                        .addGap(0, 0, Short.MAX_VALUE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(campoSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(53, 53, 53)
                        .addComponent(estadoComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(clienteComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vendedorComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSeleccionar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(estadoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {                                           
        Cliente cliente = (Cliente) this.getClienteComboBox().getSelectedItem();
        Vendedor vendedor = (Vendedor) this.getVendedorComboBox().getSelectedItem();

        ArrayList<ItemPedido> items = getItems();
        Pedido p = controlador.editarPedido(cliente, vendedor, items, EstadoPedido.valueOf((String)estadoComboBox.getSelectedItem()));
        for(ItemPedido i : items){
            i.setPedido(p);
        }
        this.setVisible(false);
    }     
    
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {                                            
        this.setVisible(false);
    } 

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {                                               
        Vendedor vendedor = (Vendedor) this.getVendedorComboBox().getSelectedItem();
        //if(vendedor!=null){
            SeleccionarItemsPedidoFormJFrame form = new SeleccionarItemsPedidoFormJFrame(this, vendedor);
            form.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            form.setVisible(true);
        //}
    }                                              

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JTextField campoSubtotal;
    private javax.swing.JComboBox<Cliente> clienteComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JComboBox<Vendedor> vendedorComboBox;
    private javax.swing.JComboBox<String> estadoComboBox;
    // End of variables declaration                   
    private PedidoController controlador;
    private ArrayList<ItemPedido> items;
    private VendedorController controladorVendedor;
    private ClienteController controladorCliente;


    public JComboBox<Cliente> getClienteComboBox() {
        return clienteComboBox;
    }

    public void setClienteComboBox(JComboBox clienteComboBox) {
        this.clienteComboBox = clienteComboBox;
    }
    
    public JComboBox<Vendedor> getVendedorComboBox() {
        return vendedorComboBox;
    }

    public void setVendedorComboBox(JComboBox vendedorComboBox) {
        this.vendedorComboBox = vendedorComboBox;
    }

    public void setItems(ArrayList<ItemPedido> items){
        this.items = items;
        double subtotal = 0;
        for(ItemPedido i : items){
            System.out.println(i.getItem().getPrecio()+"  "+i.getCantidad());
            subtotal = subtotal + (i.getItem().getPrecio()*i.getCantidad());
        }
        campoSubtotal.setText(String.valueOf(subtotal));
    }
    
    public ArrayList<ItemPedido> getItems(){
        return this.items;
    }

    private void cargarClientes() {
        ArrayList<Cliente> clientes = controladorCliente.obtenerClientes();
        clienteComboBox.removeAllItems();
        for (Cliente cliente : clientes) {
            clienteComboBox.addItem(cliente);
        }
    }

    private void cargarVendedores() {
        ArrayList<Vendedor> vendedores = controladorVendedor.obtenerVendedores();
        vendedorComboBox.removeAllItems();
        for (Vendedor vendedor : vendedores) {
            vendedorComboBox.addItem(vendedor);
        }
    }
}
