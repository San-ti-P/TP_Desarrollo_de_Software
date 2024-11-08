package isi.deso.tpdsw.Views;

import isi.deso.tpdsw.Controllers.Controller;
import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonRendererEditor extends AbstractCellEditor implements TableCellRenderer, TableCellEditor {
    private final JPanel panel;
    private final JButton btnEditar;
    private final JButton btnEliminar;
    private Controller controlador;
    
    
    public ButtonRendererEditor(Controller controlador, BuscadorJPanel panelBoton) {
        this.controlador = controlador;

        // Configura el panel y los botones
        panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));
        btnEditar = new JButton("Editar");
        btnEliminar = new JButton("Eliminar");
        
        // Agrega los botones al panel
        panel.add(btnEditar);
        panel.add(btnEliminar);

        // Acciones para los botones
        btnEditar.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes agregar la lógica de edición
//                JOptionPane.showMessageDialog(panel, "Editar fila seleccionada"); // aca va la logica de editar
                
                int row = panelBoton.getJTable().getSelectedRow();
                
                    if (row != -1) {
                        controlador.editarFila(row);
                    }
                fireEditingStopped();
            }
            
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes agregar la lógica de eliminación
                JOptionPane.showMessageDialog(panel, "Eliminar fila seleccionada"); // aca va la logica de eliminar
                fireEditingStopped();
            }
        });
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        return panel;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        return panel;
    }

    @Override
    public Object getCellEditorValue() {
        return null;
    }}