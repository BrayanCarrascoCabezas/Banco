/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.vistas;


import banco.rnegocio.dao.ICliente;
import banco.rnegocio.dao.ICuenta;

import banco.rnegocio.entidades.Cliente;
import banco.rnegocio.entidades.Cuenta;

import banco.rnegocio.impl.ClienteImpl;
import banco.rnegocio.impl.CuentaImpl;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class FrmCuentaNueva extends JInternalFrame{
        JLabel lblTitulo,lblId,lblCliente;
    JTextField txtId;
    JPanel pnlSuperior,pnlCentral,pnlInferior;
    JButton btnAceptar,btnLimpiar;
    JComboBox<Cliente>cmbCliente;
    List<Cliente> lstCliente;
    
        public FrmCuentaNueva(){
        this.setSize(200,200);
        this.setLayout(new BorderLayout());
     
        pnlSuperior= new JPanel();
        pnlCentral= new JPanel();
        pnlInferior= new JPanel();
        pnlSuperior.setLayout(new GridLayout(1, 1, 5, 5));
        pnlCentral.setLayout(new GridLayout(2, 2, 5, 5));
        pnlInferior.setLayout(new GridLayout(1,2,5,5));     
        
        lblTitulo = new JLabel("Datos Cuenta");
                
        lblId= new JLabel("CODIGO:");
        txtId = new JTextField(2);
        lblCliente= new JLabel(" CLIENTE:");
      
        btnLimpiar= new JButton("Limpiar");
        btnAceptar= new JButton("Aceptar");
        cargarCliente();
        cmbCliente=new JComboBox(lstCliente.toArray());
        pnlSuperior.add(lblTitulo);
        pnlCentral.add(lblId);
        pnlCentral.add(txtId);
        pnlCentral.add(lblCliente);
        pnlCentral.add(cmbCliente);

        
        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    btnAceptarActionListener(e);
                } catch (Exception ex) {
                    System.out.println("Error:"+ex.getMessage());
                }
            }
        });
                      
        pnlInferior.add(btnLimpiar);
        pnlInferior.add(btnAceptar);
        pnlSuperior.setBackground(Color.getHSBColor(100,60,270).brighter());
        pnlCentral.setBackground(Color.getHSBColor(100,60,270).brighter());
        this.add(pnlSuperior, BorderLayout.NORTH);
        this.add(pnlCentral, BorderLayout.CENTER);
        this.add(pnlInferior, BorderLayout.SOUTH);  
        this.setClosable(true);
    }

    public void btnAceptarActionListener(ActionEvent e){
        
        try {
            
            Cuenta ciudad = new Cuenta();
            ciudad.setCodigo_cuenta(Integer.parseInt(txtId.getText()));
            ciudad.setCliente((Cliente)cmbCliente.getSelectedItem());
            
            ICuenta ciudadDao = new CuentaImpl();
            
            if(ciudadDao.insertar(ciudad)>0){
                JOptionPane.showMessageDialog(this,"Registro Correcto!!",
                        "Transacción correcta",JOptionPane.INFORMATION_MESSAGE);
            }else {
                JOptionPane.showMessageDialog(this,"Error de Guardado!!",
                "ERROR", JOptionPane.ERROR_MESSAGE); 
            }
            
            
        } catch (Exception x) {
              JOptionPane.showMessageDialog(this,"Proceso incorrecto!!" + x.getMessage(),
                "Transacción", JOptionPane.INFORMATION_MESSAGE);
            
        }
        
      
    } 
            public void cargarCliente(){
        
        
            try {
                ICliente clientedao= new ClienteImpl();
                lstCliente=clientedao.obtener();
            } catch (Exception e) {      }
        
        };
}
