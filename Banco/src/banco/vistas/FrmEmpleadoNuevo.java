/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.vistas;
import banco.rnegocio.entidades.Empleado;
import banco.rnegocio.impl.EmpleadoImpl;
import banco.rnenogio.dao.IEmpleado;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
public class FrmEmpleadoNuevo extends JInternalFrame{
    JLabel lblTitulo,lblId,lblNombre,lblApellido,lblFecha,lblAntiguedad;
    JTextField txtId,txtNombre,txtApellido,txtFecha_Ingreso,txtAntiguedad;
    JPanel pnlSuperior,pnlCentral,pnlInferior;
    JButton btnAceptar,btnLimpiar;
    
        public FrmEmpleadoNuevo(){
            
        this.setSize(200,200);
        this.setLayout(new BorderLayout());
     
        pnlSuperior= new JPanel();
        pnlCentral= new JPanel();
        pnlInferior= new JPanel();
        pnlSuperior.setLayout(new GridLayout(1, 1, 5, 5));
        pnlCentral.setLayout(new GridLayout(2, 2, 5, 5));
        pnlInferior.setLayout(new GridLayout(1,2,5,5));     
        
        lblTitulo = new JLabel("Datos Empleado");
                
        lblId= new JLabel("CODIGO:");
        txtId = new JTextField(2);
        lblNombre= new JLabel(" NOMBRE:");
        txtNombre = new JTextField(2);
         lblApellido= new JLabel(" APELLIDO:");
        txtApellido = new JTextField(2);
         lblFecha= new JLabel(" FECHA INGRESO:");
        txtFecha_Ingreso = new JTextField(2);
         lblAntiguedad= new JLabel(" ANTIGUEDAD:");
        txtAntiguedad = new JTextField(2);
        btnLimpiar= new JButton("Limpiar");
        btnAceptar= new JButton("Aceptar");
        
        pnlSuperior.add(lblTitulo);
        pnlCentral.add(lblId);
        pnlCentral.add(txtId);
        pnlCentral.add(lblNombre);
        pnlCentral.add(txtNombre);
         pnlCentral.add(lblApellido);
        pnlCentral.add(txtApellido);
         pnlCentral.add(lblFecha);
        pnlCentral.add(txtFecha_Ingreso);
         pnlCentral.add(lblAntiguedad);
        pnlCentral.add(txtAntiguedad);

        
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
            
            Empleado empleado = new Empleado();
            empleado.setId_empleado(Integer.parseInt(txtId.getText()));
            empleado.setNombres(txtNombre.getText());
            empleado.setApellidos(txtApellido.getText());
            DateFormat simpleformat=new SimpleDateFormat("yyyy-MM-dd") ;   
            try {
            empleado.setFecha_ingreso(simpleformat.parse(txtFecha_Ingreso.getText()));
            empleado.setAntiguedad(simpleformat.parse(txtAntiguedad.getText()));
            } catch (Exception x) {
                      JOptionPane.showMessageDialog(this,"Error fecha!!" + x.getMessage(),
                "Transacción", JOptionPane.INFORMATION_MESSAGE);
            }

            
            IEmpleado empleadoDao = new EmpleadoImpl();
            
            if(empleadoDao.insertar(empleado)>0){
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
}
