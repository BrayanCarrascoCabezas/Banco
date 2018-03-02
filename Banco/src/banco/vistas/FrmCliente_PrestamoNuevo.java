/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.vistas;

import banco.rnegocio.dao.ICliente;
import banco.rnegocio.dao.ICliente_Prestamo;
import banco.rnegocio.dao.IPrestamo;
import banco.rnegocio.entidades.Cliente;
import banco.rnegocio.entidades.Cliente_Prestamo;
import banco.rnegocio.entidades.Prestamo;
import banco.rnegocio.impl.ClienteImpl;
import banco.rnegocio.impl.Cliente_PrestamoImpl;
import banco.rnegocio.impl.PrestamoImpl;
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
public class FrmCliente_PrestamoNuevo extends JInternalFrame{
       JLabel lblTitulo,lblClientePrestamo,lblCliente,lblPrestamo;
    JTextField txtClientePrestamo;
    JComboBox<Prestamo> cmbPrestamo;
    List<Prestamo> lstprestamo;
    JComboBox<Cliente> cmbCliente;
    List<Cliente> lstCliente;
    JPanel pnlSuperior,pnlCentral,pnlInferior;
    JButton btnAceptar,btnLimpiar;
    
        public FrmCliente_PrestamoNuevo(){
        this.setSize(400,600);
        this.setLayout(new BorderLayout());
     
        pnlSuperior= new JPanel();
        pnlCentral= new JPanel();
        pnlInferior= new JPanel();
        pnlSuperior.setLayout(new GridLayout(1, 1, 5, 5));
        pnlCentral.setLayout(new GridLayout(7, 2, 5, 5));
        pnlInferior.setLayout(new GridLayout(1,2,5,5));     
        
        lblTitulo = new JLabel("DATOS DEL CLIENTE");
                
        lblClientePrestamo= new JLabel("ID:");
        lblCliente=new JLabel("CLIENTE");
        lblPrestamo= new JLabel(" PRESTAMO:");

        
        txtClientePrestamo = new JTextField(2);
        cargarCliente();
        cmbCliente=new JComboBox(lstCliente.toArray());
       cargarPrestamo();
        cmbPrestamo=new JComboBox(lstprestamo.toArray());
        

        btnLimpiar= new JButton("Limpiar");
        btnAceptar= new JButton("Aceptar");
        
        pnlSuperior.add(lblTitulo);
        pnlCentral.add(lblClientePrestamo);
        pnlCentral.add(txtClientePrestamo);
        pnlCentral.add(lblCliente);
        pnlCentral.add(cmbCliente);
        pnlCentral.add(lblPrestamo);
        pnlCentral.add(cmbPrestamo);
 


        
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
            
            Cliente_Prestamo cliente = new Cliente_Prestamo();
            cliente.setIdcliente_prestamo(Integer.parseInt(txtClientePrestamo.getText()));
            cliente.setCliente((Cliente)cmbCliente.getSelectedItem());
            cliente.setPrestamo((Prestamo)cmbPrestamo.getSelectedItem());
            ICliente_Prestamo clienteDao = new Cliente_PrestamoImpl();
            
            if(clienteDao.insertar(cliente)>0){
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
    public void cargarPrestamo() {
        try {
       IPrestamo cat=new PrestamoImpl();
       lstprestamo=cat.obtener();
   
        } catch (Exception e) {System.out.println("ERROR"+e.getMessage());
        }}
        
        public void cargarCliente(){
        
        
            try {
                ICliente clientedao= new ClienteImpl();
                lstCliente=clientedao.obtener();
            } catch (Exception e) {System.out.println("ERROR"+e.getMessage());
            }
        
        };

}
