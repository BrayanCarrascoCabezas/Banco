/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.vistas;

import javafx.application.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import java.util.*;
import javafx.scene.text.*;
import javafx.scene.paint.*;
import java.lang.reflect.*;
import java.text.*;
import javafx.beans.*;
import javafx.collections.*;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;
import javafx.stage.*;
import javafx.scene.image.*;
import banco.rnegocio.dao.*;
import banco.rnegocio.entidades.*;
import banco.rnegocio.impl.*;
import banco.accesodatos.*;
import java.awt.BorderLayout;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Frmlistado_Cliente extends JInternalFrame {
  JLabel titulo;
    JTable tabla;
    DefaultTableModel modelo;

    public Frmlistado_Cliente() {

        this.setSize(800, 600);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        titulo = new JLabel("LISTADO DE CLIENTES");
        tabla = new JTable();
        this.add(titulo, BorderLayout.NORTH);
        this.add(tabla, BorderLayout.CENTER);

        cargarTabla();

    }

    public void cargarTabla() {
        modelo = new DefaultTableModel();


        List<Cliente> lista = new ArrayList<>();
        try {
            ICliente estDao = new ClienteImpl();
            lista = estDao.obtener();
        } catch (Exception e) {

            JOptionPane.showMessageDialog(this, e.getMessage(), "error", JOptionPane.ERROR_MESSAGE);
        }
        for (Cliente est : lista) {
            modelo.addRow(new Object[]{est.getCodigo_cliente(),est.getPrestamo().getId_prestamo(),est.getNombres(),est.getApellidos(),est.getCedula(),est.getEmail(),est.getCelular()});
        }
        tabla.setModel(modelo);
}
    }
    
