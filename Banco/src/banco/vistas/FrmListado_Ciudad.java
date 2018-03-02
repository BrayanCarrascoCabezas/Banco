
package banco.vistas;

import banco.rnegocio.dao.ICiudad;
import banco.rnegocio.entidades.Ciudad;
import banco.rnegocio.impl.CiudadImpl;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FrmListado_Ciudad extends JInternalFrame{
 
    JLabel titulo;
    JTable tabla;
    DefaultTableModel modelo;

    public FrmListado_Ciudad() {

        this.setSize(800, 600);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        titulo = new JLabel("LISTADO DE CIUDADES");
        tabla = new JTable();
        this.add(titulo, BorderLayout.NORTH);
        this.add(tabla, BorderLayout.CENTER);

        cargarTabla();

    }

    public void cargarTabla() {
        modelo = new DefaultTableModel();
        modelo.addColumn("ID");

        modelo.addColumn("NOMBRE");


        List<Ciudad> lista = new ArrayList<>();
        try {
            ICiudad estDao = new CiudadImpl();
            lista = estDao.obtener();
        } catch (Exception e) {

            JOptionPane.showMessageDialog(this, e.getMessage(), "error", JOptionPane.ERROR_MESSAGE);
        }
        for (Ciudad est : lista) {
            modelo.addRow(new Object[]{est.getId_ciudad(), est.getNombre().toString()});
        }
        tabla.setModel(modelo);
    }
}

