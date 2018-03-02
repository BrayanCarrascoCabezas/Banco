/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.vistas;

import banco.rnegocio.entidades.*;
import banco.rnegocio.impl.InspectorImpl;
import banco.rnegocio.impl.PrestamoImpl;
import banco.rnegocio.dao.*;
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

public class FrmInspectorNuevo extends JInternalFrame{
    JLabel lblTitulo,lblCodigo,lblNombre,lblDireccion,lblTituloIns,lblPrestamo;
    JTextField txtCodigo,txtNombre,txtDireccion,txtTituloIns;
    List<Prestamo> lstprestamo;
    JComboBox<Prestamo> cmbPrestamo;
    
    JPanel pnlSuperior,pnlCentral,pnlInferior;
    JButton btnAceptar,btnLimpiar;
    
        public FrmInspectorNuevo(){
        this.setSize(300,400);
        this.setLayout(new BorderLayout());
     
        pnlSuperior= new JPanel();
        pnlCentral= new JPanel();
        pnlInferior= new JPanel();
        pnlSuperior.setLayout(new GridLayout(1, 1, 5, 5));
        pnlCentral.setLayout(new GridLayout(5, 2, 5, 5));
        pnlInferior.setLayout(new GridLayout(1,2,5,5));     
        
        lblTitulo = new JLabel("Nuevo inspector");
                
        lblCodigo= new JLabel("CODIGO:");
        lblNombre= new JLabel("NOMBRE:");
        lblDireccion= new JLabel("DIRECCION:");
        lblTituloIns= new JLabel("TITULO:");
        lblPrestamo= new JLabel("ID_PRESTAMO:");
        
        
        txtCodigo = new JTextField(2);
        txtNombre = new JTextField(2);
        txtDireccion= new JTextField(2);
        txtTituloIns= new JTextField(2);
        cargarPrestamo();
        cmbPrestamo=new JComboBox(lstprestamo.toArray());
        
        btnLimpiar= new JButton("Limpiar");
        btnAceptar= new JButton("Aceptar");
        
        pnlSuperior.add(lblTitulo);
        pnlCentral.add(lblCodigo);
        pnlCentral.add(txtCodigo);
        pnlCentral.add(lblNombre);
        pnlCentral.add(txtNombre);
        pnlCentral.add(lblDireccion);
        pnlCentral.add(txtDireccion);
        pnlCentral.add(lblTituloIns);
        pnlCentral.add(txtTituloIns);
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
             
            Inspector inspector = new Inspector();
            inspector.setCodigo(Integer.parseInt(txtCodigo.getText()));
            inspector.setNombre(txtNombre.getText());
            inspector.setDireccion(txtDireccion.getText());
            inspector.setTitulo(txtTituloIns.getText());
            inspector.setPrestamo((Prestamo)cmbPrestamo.getSelectedItem());


            IInspector inspectorDao = new InspectorImpl();
            
            if(inspectorDao.insertar(inspector)>0){
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
            IPrestamo prestamo=new PrestamoImpl();
       lstprestamo=prestamo.obtener();
   
        } catch (Exception e) {System.out.println("ERROR"+e.getMessage());
        }
}
    
}