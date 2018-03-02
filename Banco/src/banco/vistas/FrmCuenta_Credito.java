/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.vistas;

import banco.rnegocio.dao.ICuenta;
import banco.rnegocio.dao.ICuenta_Credito;
import banco.rnegocio.dao.ICuenta_ahorros;
import banco.rnegocio.entidades.Cuenta;
import banco.rnegocio.entidades.Cuenta_Ahorros;
import banco.rnegocio.entidades.Cuenta_Credito;
import banco.rnegocio.impl.CuentaImpl;
import banco.rnegocio.impl.Cuenta_AhorrosImpl;
import banco.rnegocio.impl.Cuenta_CreditoImpl;
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
public class FrmCuenta_Credito extends JInternalFrame{
          JLabel lblTitulo,lblNum_Cuenta,lblCuenta,lblSaldo,lblSobregiro;
    JTextField txtNum_Cuenta,txtSaldo,txtSobregiro;
    JComboBox<Cuenta> cmbCuenta;
    List<Cuenta> lstcuenta;

    JPanel pnlSuperior,pnlCentral,pnlInferior;
    JButton btnAceptar,btnLimpiar;
    
//    private int n_cuenta;
//    private Cuenta cuenta;
//    private int saldo;
//    private int u_sobregiro;
    
        public FrmCuenta_Credito(){
        this.setSize(400,600);
        this.setLayout(new BorderLayout());
     
        pnlSuperior= new JPanel();
        pnlCentral= new JPanel();
        pnlInferior= new JPanel();
        pnlSuperior.setLayout(new GridLayout(1, 1, 5, 5));
        pnlCentral.setLayout(new GridLayout(7, 2, 5, 5));
        pnlInferior.setLayout(new GridLayout(1,2,5,5));     
        
        lblTitulo = new JLabel("DATOS DEL CLIENTE");
                
        lblNum_Cuenta= new JLabel("ID:");
        lblCuenta=new JLabel("CUENTA");
        lblSaldo= new JLabel(" SALDO:");
        lblSobregiro= new JLabel(" SOBREGIRO:");

        
        txtNum_Cuenta = new JTextField(2);
        txtSaldo = new JTextField(2);
        txtSobregiro = new JTextField(2);
  
       cargarCuenta();
        cmbCuenta=new JComboBox(lstcuenta.toArray());
        

        btnLimpiar= new JButton("Limpiar");
        btnAceptar= new JButton("Aceptar");
        
        pnlSuperior.add(lblTitulo);
        pnlCentral.add(lblNum_Cuenta);
        pnlCentral.add(txtNum_Cuenta);
        pnlCentral.add(lblCuenta);
        pnlCentral.add(cmbCuenta);
        pnlCentral.add(lblSaldo);
        pnlCentral.add(txtSaldo);
        pnlCentral.add(lblSobregiro);
        pnlCentral.add(txtSobregiro);
 


        
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
            
            Cuenta_Credito cliente = new Cuenta_Credito();
            cliente.setN_cuenta(Integer.parseInt(txtNum_Cuenta.getText()));
            cliente.setCuenta((Cuenta)cmbCuenta.getSelectedItem());
            cliente.setSaldo(Integer.parseInt(txtSaldo.getText()));
            cliente.setU_sobregiro(Integer.parseInt(txtSobregiro.getText()));
            ICuenta_Credito clienteDao = new Cuenta_CreditoImpl();
            
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
    public void cargarCuenta() {
        try {
       ICuenta cat=new CuentaImpl();
       lstcuenta=cat.obtener();
   
        } catch (Exception e) {System.out.println("ERROR"+e.getMessage());
        }}
}
