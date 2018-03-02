/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.vistas;

import banco.rnegocio.entidades.*;
import banco.rnegocio.impl.*;
import banco.rnegocio.dao.*;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.StringStack;
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
public class FrmSucursalNueva extends JInternalFrame{
      JLabel lblTitulo,lblId,lblEmpleado;
    JTextField txtId,txtEmpleado,txtSucursal;
    JPanel pnlSuperior,pnlCentral,pnlInferior;
    JButton btnAceptar,btnLimpiar;
    JComboBox<Empleado> cmbempleado;
    List<Empleado> lstempleado;
    JComboBox<Sucursal> cmbciudad;
    List<Ciudad> lstciudad;
        public FrmSucursalNueva(){
        this.setSize(250,200);
        this.setLayout(new BorderLayout());
     
        pnlSuperior= new JPanel();
        pnlCentral= new JPanel();
        pnlInferior= new JPanel();
        pnlSuperior.setLayout(new GridLayout(1, 1, 5, 5));
        pnlCentral.setLayout(new GridLayout(6, 2, 5, 5));
        pnlInferior.setLayout(new GridLayout(1,2,5,5));     
        
        lblTitulo = new JLabel("Datos Sucursal");
                
        lblId= new JLabel("CODIGO:");
        txtId = new JTextField(2);
        lblEmpleado= new JLabel(" EEMPLEADO:");
        CargarEmpleado();
        cmbempleado = new JComboBox(lstempleado.toArray() );
           lblEmpleado= new JLabel(" CIUDAD:");
        CargarCiudad();
           cmbciudad=new JComboBox(lstciudad.toArray());
        btnLimpiar= new JButton("Limpiar");
        btnAceptar= new JButton("Aceptar");
        
        pnlSuperior.add(lblTitulo);
        pnlCentral.add(lblId);
        pnlCentral.add(txtId);
        pnlCentral.add(lblEmpleado);
        pnlCentral.add(txtEmpleado);

        
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
            
            Sucursal sucursal = new Sucursal();
            sucursal.setId_sucursal(Integer.parseInt(txtId.getText()));
            sucursal.setEmpleado((Empleado)cmbempleado.getSelectedItem());
            sucursal.setCiudad((Ciudad)cmbciudad.getSelectedItem());
         
            
            ISucursal sucursalDao = new SucursalImpl();
            
            if(sucursalDao.insertar(sucursal)>0){
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
            public void CargarEmpleado(){
                try {
                 IEmpleado empleadodao=new EmpleadoImpl();
                lstempleado=empleadodao.obtener();
                } catch (Exception e) {
                }
             
               
        };
                  public void CargarCiudad(){
                try {
                 ICiudad ciudaddao=new CiudadImpl();
                 lstciudad=ciudaddao.obtener();
                } catch (Exception e) {
                    
                };
}
}
