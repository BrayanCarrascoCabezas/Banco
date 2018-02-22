/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.vistas;

import banco.rnegocio.entidades.Ciudad;
import banco.rnegocio.entidades.Prestamo;
import banco.rnegocio.entidades.Sucursal;
import banco.rnegocio.impl.CiudadImpl;
import banco.rnegocio.impl.PrestamoImpl;
import banco.rnegocio.impl.SucursalImpl;
import banco.rnenogio.dao.ICiudad;
import banco.rnenogio.dao.IPrestamo;
import banco.rnenogio.dao.ISucursal;
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
public class FrmPrestamoNuevo extends JInternalFrame {
       JLabel lblTitulo,lblId,lblImporte,lblAbono,lblFecha,lblValor,lblSucursal;
    JTextField txtId,txtImporte,txtAbono,txtFecha,txtValor;
    JPanel pnlSuperior,pnlCentral,pnlInferior;
    JButton btnAceptar,btnLimpiar;
    JComboBox<Sucursal> cmbSucursal;
    List<Sucursal> lstSucursal;
      
        public FrmPrestamoNuevo(){
        this.setSize(200,200);
        this.setLayout(new BorderLayout());
     
        pnlSuperior= new JPanel();
        pnlCentral= new JPanel();
        pnlInferior= new JPanel();
        pnlSuperior.setLayout(new GridLayout(1, 1, 5, 5));
        pnlCentral.setLayout(new GridLayout(2, 2, 5, 5));
        pnlInferior.setLayout(new GridLayout(1,2,5,5));     
        
        lblTitulo = new JLabel("Datos Ciudad");
                
        lblId= new JLabel("CODIGO:");
        txtId = new JTextField(2);
        lblImporte= new JLabel(" IMPORTE:");
        txtImporte = new JTextField(2);
            lblAbono= new JLabel(" ABONO:");
        txtAbono = new JTextField(2);
            lblFecha= new JLabel(" FECHA:");
        txtFecha = new JTextField(2);
            lblValor= new JLabel(" VALOR:");
        txtValor = new JTextField(2);
        CargarSucursal();
        cmbSucursal=new JComboBox(lstSucursal.toArray());
        btnLimpiar= new JButton("Limpiar");
        btnAceptar= new JButton("Aceptar");
        
        pnlSuperior.add(lblTitulo);
        pnlCentral.add(lblId);
        pnlCentral.add(txtId);
        pnlCentral.add(lblImporte);
        pnlCentral.add(txtImporte);
           pnlCentral.add(lblAbono);
        pnlCentral.add(txtAbono);
           pnlCentral.add(lblFecha);
        pnlCentral.add(txtFecha);
           pnlCentral.add(lblValor);
        pnlCentral.add(txtValor);
   pnlCentral.add(lblSucursal);
        pnlCentral.add(cmbSucursal);
        
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
            
            Prestamo prestamo = new Prestamo();
            prestamo.setId_prestamo(Integer.parseInt(txtId.getText()));
            prestamo.setImporte(Integer.parseInt(txtImporte.getText()));
            prestamo.setAbono(Integer.parseInt(txtAbono.getText()));
             DateFormat simpleformat=new SimpleDateFormat("yyyy-MM-dd") ;  
             try {
                   prestamo.setFecha(simpleformat.parse(txtFecha.getText()));
            } catch (Exception x) {
                  JOptionPane.showMessageDialog(this,"error en fecha!!" + x.getMessage(),
                "Transacción", JOptionPane.INFORMATION_MESSAGE);
            }
      
            prestamo.setValor(Integer.parseInt(txtValor.getText()));
            prestamo.setSucursal((Sucursal)cmbSucursal.getSelectedItem());
            
            
            IPrestamo prestamoDao = new PrestamoImpl();
            
            if(prestamoDao.insertar(prestamo)>0){
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
    
    public void CargarSucursal(){
        try {
        ISucursal sucursaldao=new SucursalImpl();
        lstSucursal=sucursaldao.obtener();
        } catch (Exception e) {
                  JOptionPane.showMessageDialog(this,"Proceso incorrecto!!" + e.getMessage(),
                "Transacción", JOptionPane.INFORMATION_MESSAGE);
        }

    
    }
}
