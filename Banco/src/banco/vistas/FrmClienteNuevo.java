/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.vistas;

import banco.rnegocio.entidades.Cliente;
import banco.rnegocio.entidades.Prestamo;
import banco.rnegocio.impl.ClienteImpl;
import banco.rnegocio.impl.PrestamoImpl;
import banco.rnegocio.dao.ICliente;
import banco.rnegocio.dao.IPrestamo;
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

public class FrmClienteNuevo extends JInternalFrame{
    JLabel lblTitulo,lblCodigo,lblNombres,lblApellidos,lblCedula,lblCelular,lblEmail,lblPrestamo;
    JTextField txtCodigo,txtNombres,txtApellidos,txtCedula,txtCelular,txtEmail;
    JComboBox cmbPrestamo;
    List<Prestamo> lstprestamo;
    JPanel pnlSuperior,pnlCentral,pnlInferior;
    JButton btnAceptar,btnLimpiar;
    
        public FrmClienteNuevo(){
        this.setSize(400,600);
        this.setLayout(new BorderLayout());
     
        pnlSuperior= new JPanel();
        pnlCentral= new JPanel();
        pnlInferior= new JPanel();
        pnlSuperior.setLayout(new GridLayout(1, 1, 5, 5));
        pnlCentral.setLayout(new GridLayout(7, 2, 5, 5));
        pnlInferior.setLayout(new GridLayout(1,2,5,5));     
        
        lblTitulo = new JLabel("DATOS DEL CLIENTE");
                
        lblCodigo= new JLabel("CODIGO:");
        lblCedula=new JLabel("CEDULA");
        lblNombres= new JLabel(" NOMBRE:");
        lblApellidos= new JLabel("APELLIDOS:");
        lblCelular=new JLabel("CELULAR");
        lblEmail=new JLabel("EMAIL");
        lblPrestamo=new JLabel("PRESTAMO");
        
        txtCodigo = new JTextField(2);
        txtNombres= new JTextField(2);
        txtApellidos= new JTextField(2);
        txtCelular= new JTextField(2);
        txtEmail= new JTextField(2);
        cmbPrestamo=new JComboBox(lstprestamo.toArray());
        

        btnLimpiar= new JButton("Limpiar");
        btnAceptar= new JButton("Aceptar");
        
        pnlSuperior.add(lblTitulo);
        pnlCentral.add(lblCodigo);
        pnlCentral.add(txtCodigo);
        pnlCentral.add(lblCedula);
        pnlCentral.add(txtCedula);
        pnlCentral.add(lblNombres);
        pnlCentral.add(txtNombres);
        pnlCentral.add(lblApellidos);
        pnlCentral.add(txtApellidos);
        pnlCentral.add(lblCelular);
        pnlCentral.add(txtCelular);
        pnlCentral.add(lblEmail);
        pnlCentral.add(txtEmail);
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
            
            Cliente cliente = new Cliente();
            cliente.setCodigo_cliente(Integer.parseInt(txtCodigo.getText()));
            cliente.setCedula(Integer.parseInt(txtCedula.getText()));
            cliente.setNombres(txtNombres.getText());
            cliente.setApellidos(txtApellidos.getText());
            cliente.setCelular(Integer.parseInt(txtCelular.getText()));
            cliente.setEmail(txtEmail.getText());
            cliente.setPrestamo((Prestamo)cmbPrestamo.getSelectedItem());
            ICliente clienteDao = new ClienteImpl();
            
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
    public void cargarCategoria() {
        try {
       IPrestamo cat=new PrestamoImpl();
       lstprestamo=cat.obtener();
   
        } catch (Exception e) {System.out.println("ERROR"+e.getMessage());
        }
}
}

