/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.vistas;

import banco.rnegocio.dao.ICuenta_Credito;
import banco.rnegocio.dao.ICuenta_ahorros;
import banco.rnegocio.entidades.Cuenta_Ahorros;
import banco.rnegocio.entidades.Cuenta_Credito;
import banco.rnegocio.impl.Cuenta_AhorrosImpl;
import banco.rnegocio.impl.Cuenta_CreditoImpl;
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
public class Frmlistado_CuentaCredito extends JInternalFrame{
        JLabel titulo;
    JTable tabla;
    DefaultTableModel modelo;

    public Frmlistado_CuentaCredito() {

        this.setSize(800, 600);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        titulo = new JLabel("LISTADO DE CUENTA CREDITO");
        tabla = new JTable();
        this.add(titulo, BorderLayout.NORTH);
        this.add(tabla, BorderLayout.CENTER);

        cargarTabla();

    }

    public void cargarTabla() {
        modelo = new DefaultTableModel();



        List<Cuenta_Credito> lista = new ArrayList<>();
        try {
            ICuenta_Credito estDao = new Cuenta_CreditoImpl();
            lista = estDao.obtener();
        } catch (Exception e) {

            JOptionPane.showMessageDialog(this, e.getMessage(), "error", JOptionPane.ERROR_MESSAGE);
        }
        for (Cuenta_Credito est : lista) {
            modelo.addRow(new Object[]{est.getN_cuenta(), est.getCuenta(),est.getSaldo(),est.getU_sobregiro()});
        }
        tabla.setModel(modelo);
    }
}
