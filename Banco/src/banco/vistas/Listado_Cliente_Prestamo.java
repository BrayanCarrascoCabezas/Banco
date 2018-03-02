/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.vistas;

import banco.rnegocio.dao.ICliente_Prestamo;
import banco.rnegocio.entidades.Cliente_Prestamo;
import banco.rnegocio.impl.Cliente_PrestamoImpl;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class Listado_Cliente_Prestamo extends JInternalFrame{
     JLabel titulo;
    JTable tabla;
    DefaultTableModel modelo;

    public Listado_Cliente_Prestamo() {

        this.setSize(800, 600);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        titulo = new JLabel("LISTADO DE CLIENTE PRESTAMOS");
        tabla = new JTable();
        this.add(titulo, BorderLayout.NORTH);
        this.add(tabla, BorderLayout.CENTER);

        cargarTabla();

    }

    public void cargarTabla() {
        modelo = new DefaultTableModel();



        List<Cliente_Prestamo> lista = new ArrayList<>();
        try {
            ICliente_Prestamo estDao = new Cliente_PrestamoImpl();
            lista = estDao.obtener();
        } catch (Exception e) {

            JOptionPane.showMessageDialog(this, e.getMessage(), "error", JOptionPane.ERROR_MESSAGE);
        }
        for (Cliente_Prestamo est : lista) {
            modelo.addRow(new Object[]{est.getIdcliente_prestamo(), est.getCliente(),est.getPrestamo().toString()});
        }
        tabla.setModel(modelo);
    }
}
