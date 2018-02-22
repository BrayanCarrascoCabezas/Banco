/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.rnegocio.impl;

import banco.accesodatos.*;
import banco.rnegocio.entidades.*;
import banco.rnenogio.dao.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author WILCXMAC
 */
public class PagoImpl implements Ipago{
    
    @Override
     
     public int insertar(Pago pago) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into pago  values "
                + "(?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, pago.getId_pago()));
        lstPar.add(new Parametro(2, pago.getFecha()));
        lstPar.add(new Parametro(3, pago.getValor()));
        lstPar.add(new Parametro(4, pago.getPrestamo().getId_prestamo()));
  
        Conexion con = null;
        try {
            con = new Conexion();
            numFilasAfectadas = con.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            throw e;
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return numFilasAfectadas;
    }

    @Override
    public int modificar(Pago pago) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE pago"
                + "   SET id_pago=?, fecha=?, valor=?, id_prestamo=?, "
                + " where id_pago=?";
        List<Parametro> lstPar = new ArrayList<>();
      
        lstPar.add(new Parametro(1, pago.getId_pago()));
        lstPar.add(new Parametro(2, pago.getFecha()));
        lstPar.add(new Parametro(3, pago.getValor()));
        lstPar.add(new Parametro(4, pago.getPrestamo().getId_prestamo()));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            numFilasAfectadas = con.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            throw e;
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return numFilasAfectadas;
    }

    @Override
    public int eliminar(Pago pago) throws Exception {
        int numFilasAfectadas = 0;
         String sql = "DELETE FROM pago  where id_pago=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, pago.getId_pago()));       
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            numFilasAfectadas = con.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            throw e;
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return numFilasAfectadas;
    }

    @Override
    public Pago obtener(int codigo) throws Exception {
        Pago pago = null;
        String sql = "SELECT *   FROM pago where id_pago=?;";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, codigo));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);
            while (rst.next()) {
                pago = new Pago();
                pago.setId_pago(rst.getInt(1));
                pago.setFecha(rst.getDate(2));
                pago.setValor(rst.getInt(3));
            
   
                IPrestamo prestamodao = new PrestamoImpl();
                Prestamo prestamo = prestamodao.obtener(rst.getInt(4));
                pago.setPrestamo(prestamo);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(con!=null)
            con.desconectar();
        }
        return pago;
    }

    @Override
    public List<Pago> obtener() throws Exception {
        List<Pago> lista = new ArrayList<>();
         String sql = "SELECT *   FROM pago ";        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            Pago pago=null;
            while (rst.next()) {
                pago = new Pago();
                 pago.setId_pago(rst.getInt(1));
                pago.setFecha(rst.getDate(2));
                pago.setValor(rst.getInt(3));
            
   
                IPrestamo prestamodao = new PrestamoImpl();
                Prestamo prestamo = prestamodao.obtener(rst.getInt(4));
                pago.setPrestamo(prestamo);
                lista.add(pago);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(con!=null)
            con.desconectar();
        }
        return lista;
    }    
}
