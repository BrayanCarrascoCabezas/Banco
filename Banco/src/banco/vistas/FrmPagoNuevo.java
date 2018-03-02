/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.vistas;

import banco.rnegocio.dao.ICiudad;
import banco.rnegocio.dao.IPrestamo;
import banco.rnegocio.dao.Ipago;
import banco.rnegocio.entidades.Ciudad;
import banco.rnegocio.entidades.Pago;
import banco.rnegocio.entidades.Prestamo;
import banco.rnegocio.impl.CiudadImpl;
import banco.rnegocio.impl.PagoImpl;
import banco.rnegocio.impl.PrestamoImpl;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author JUNIOR CHAVEZ
 */
public class FrmPagoNuevo extends JInternalFrame {

    JLabel lblTitulo, lblId, lblFecha, lblValor, lblprestamo;
    JTextField txtId, txtFecha, txtValor;
    JPanel pnlSuperior, pnlCentral, pnlInferior;
    JButton btnAceptar, btnLimpiar;

    JComboBox<Prestamo> cmbPrestamo;
    List<Prestamo> lstPrestamo;
//    
//        private int id_pago;
//    private Date fecha;
//    private int valor;
//    private Prestamo prestamo;

    public FrmPagoNuevo() {
        this.setSize(200, 200);
        this.setLayout(new BorderLayout());

        pnlSuperior = new JPanel();
        pnlCentral = new JPanel();
        pnlInferior = new JPanel();
        pnlSuperior.setLayout(new GridLayout(1, 1, 5, 5));
        pnlCentral.setLayout(new GridLayout(4, 2, 5, 5));
        pnlInferior.setLayout(new GridLayout(1, 2, 5, 5));

        lblTitulo = new JLabel("Datos Ciudad");
        lblprestamo = new JLabel("PRESTAMO");

        lblId = new JLabel("CODIGO:");
        txtId = new JTextField(2);
        lblFecha = new JLabel(" FECHA:");
        txtFecha = new JTextField(2);
        lblValor = new JLabel(" VALOR:");
        txtValor = new JTextField(2);
        btnLimpiar = new JButton("Limpiar");
        btnAceptar = new JButton("Aceptar");
        cargarPrestamos();
        cmbPrestamo=new JComboBox(lstPrestamo.toArray());
        pnlSuperior.add(lblTitulo);
        pnlCentral.add(lblId);
        pnlCentral.add(txtId);
        pnlCentral.add(lblFecha);
        pnlCentral.add(txtFecha);
        pnlCentral.add(lblValor);
        pnlCentral.add(txtValor);
        pnlCentral.add(lblprestamo);
        pnlCentral.add(cmbPrestamo);

        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    btnAceptarActionListener(e);
                } catch (Exception ex) {
                    System.out.println("Error:" + ex.getMessage());
                }
            }
        });

        pnlInferior.add(btnLimpiar);
        pnlInferior.add(btnAceptar);
        pnlSuperior.setBackground(Color.getHSBColor(100, 60, 270).brighter());
        pnlCentral.setBackground(Color.getHSBColor(100, 60, 270).brighter());
        this.add(pnlSuperior, BorderLayout.NORTH);
        this.add(pnlCentral, BorderLayout.CENTER);
        this.add(pnlInferior, BorderLayout.SOUTH);
        this.setClosable(true);
    }

    public void btnAceptarActionListener(ActionEvent e) {

        try {

            Pago ciudad = new Pago();
            ciudad.setId_pago(Integer.parseInt(txtId.getText()));
            ciudad.setValor(Integer.parseInt(txtValor.getText()));
            ciudad.setPrestamo((Prestamo)cmbPrestamo.getSelectedItem());
            
           DateFormat simpleformat=new SimpleDateFormat("yyyy-MM-dd") ;   
            try {
            ciudad.setFecha(simpleformat.parse(txtFecha.getText()));
         
            } catch (Exception x) {
                      JOptionPane.showMessageDialog(this,"Error fecha!!" + x.getMessage(),
                "Transacción", JOptionPane.INFORMATION_MESSAGE);
            }
            
            Ipago ciudadDao = new PagoImpl();

            if (ciudadDao.insertar(ciudad) > 0) {
                JOptionPane.showMessageDialog(this, "Registro Correcto!!",
                        "Transacción correcta", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Error de Guardado!!",
                        "ERROR", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception x) {
            JOptionPane.showMessageDialog(this, "Proceso incorrecto!!" + x.getMessage(),
                    "Transacción", JOptionPane.INFORMATION_MESSAGE);

        }

    }

    public void cargarPrestamos() {
        try {
            IPrestamo prestamodao = new PrestamoImpl();
            lstPrestamo = prestamodao.obtener();
        } catch (Exception e) {
        }

    }
}
