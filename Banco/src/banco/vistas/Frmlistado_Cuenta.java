/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.vistas;


import banco.rnegocio.entidades.*;
import banco.rnegocio.impl.*;


import banco.rnegocio.dao.ICuenta;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Frmlistado_Cuenta extends JInternalFrame {
    
     JLabel titulo;
    JTable tabla;
    DefaultTableModel modelo;

    public Frmlistado_Cuenta() {

        this.setSize(800, 600);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        titulo = new JLabel("LISTADO DE CUENTA");
        tabla = new JTable();
        this.add(titulo, BorderLayout.NORTH);
        this.add(tabla, BorderLayout.CENTER);

        cargarTabla();

    }

    public void cargarTabla() {
        modelo = new DefaultTableModel();



        List<Cuenta> lista = new ArrayList<>();
        try {
            ICuenta estDao = new CuentaImpl();
            lista = estDao.obtener();
        } catch (Exception e) {

            JOptionPane.showMessageDialog(this, e.getMessage(), "error", JOptionPane.ERROR_MESSAGE);
        }
        for (Cuenta est : lista) {
            modelo.addRow(new Object[]{est.getCodigo_cuenta(), est.getCliente().toString()});
        }
        tabla.setModel(modelo);
    }
}

