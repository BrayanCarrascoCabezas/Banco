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

public class Frmlistado_Pago extends JInternalFrame {
  JLabel titulo;
    JTable tabla;
    DefaultTableModel modelo;

    public Frmlistado_Pago() {

        this.setSize(800, 600);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        titulo = new JLabel("LISTADO DE PAGOS");
        tabla = new JTable();
        this.add(titulo, BorderLayout.NORTH);
        this.add(tabla, BorderLayout.CENTER);

        cargarTabla();

    }

    public void cargarTabla() {
        modelo = new DefaultTableModel();


        List<Pago> lista = new ArrayList<>();
        try {
            Ipago estDao = new PagoImpl();
            lista = estDao.obtener();
        } catch (Exception e) {

            JOptionPane.showMessageDialog(this, e.getMessage(), "error", JOptionPane.ERROR_MESSAGE);
        }
        for (Pago est : lista) {
            modelo.addRow(new Object[]{est.getId_pago(),est.getFecha(),est.getValor(),est.getPrestamo().getId_prestamo()});
        }
        tabla.setModel(modelo);
}
    }
