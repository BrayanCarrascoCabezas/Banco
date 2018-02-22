/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.rnegocio.impl;

import banco.rnegocio.dao.IPrestamo;
import banco.rnegocio.dao.ISucursal;
import banco.accesodatos.*;
import banco.rnegocio.entidades.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author WILCXMAC
 */
public class PrestamoImpl implements IPrestamo{
    
    @Override
    
      public int insertar(Prestamo prestamo) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into prestamos  values "
                + "(?,?,?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, prestamo.getId_prestamo()));
        lstPar.add(new Parametro(3, prestamo.getImporte()));
        lstPar.add(new Parametro(4, prestamo.getAbono()));
        lstPar.add(new Parametro(5, prestamo.getFecha()));
        lstPar.add(new Parametro(6, prestamo.getValor()));
        lstPar.add(new Parametro(2, prestamo.getSucursal().getId_sucursal()));

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
    public int modificar(Prestamo prestamo) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE prestamos"
                + "   SET id_prestamo=?, importe=?, abono=?, fecha=?, id_sucursal=?, "
                        + " where id_prestamo=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, prestamo.getId_prestamo()));
        lstPar.add(new Parametro(3, prestamo.getImporte()));
        lstPar.add(new Parametro(4, prestamo.getAbono()));
        lstPar.add(new Parametro(5, prestamo.getFecha()));
        lstPar.add(new Parametro(6, prestamo.getValor()));
        lstPar.add(new Parametro(2, prestamo.getSucursal().getId_sucursal()));
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
public int eliminar(Prestamo prestamo) throws Exception {
        int numFilasAfectadas = 0;
         String sql = "DELETE FROM prestamos  where codigo_prestamo=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, prestamo.getId_prestamo()));       
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
    public Prestamo obtener(int codigo) throws Exception {
        Prestamo prestamo = null;
        String sql = "SELECT *   FROM prestamos where id_prestamo=?;";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, codigo));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);
            while (rst.next()) {
                prestamo = new Prestamo();
                prestamo.setId_prestamo(rst.getInt(1));
                prestamo.setAbono(rst.getInt(4));
                prestamo.setImporte(rst.getInt(3));
                prestamo.setFecha(rst.getDate(5));
                prestamo.setValor(rst.getInt(6));
                ISucursal sucursaldao=new SucursalImpl();
                Sucursal sucursal= sucursaldao.obtener(rst.getInt(2));
                prestamo.setSucursal(sucursal);

            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(con!=null)
            con.desconectar();
        }
        return prestamo;
    }

    @Override
    
    public List<Prestamo> obtener() throws Exception {
        List<Prestamo> lista = new ArrayList<>();
         String sql = "SELECT *   FROM prestamos ";        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            Prestamo prestamo=null;
            while (rst.next()) {
         
                prestamo = new Prestamo();
                prestamo.setId_prestamo(rst.getInt(1));
                prestamo.setAbono(rst.getInt(4));
                prestamo.setImporte(rst.getInt(3));
                prestamo.setFecha(rst.getDate(5));
                prestamo.setValor(rst.getInt(6));
                ISucursal sucursaldao=new SucursalImpl();
                Sucursal sucursal= sucursaldao.obtener(rst.getInt(2));
                prestamo.setSucursal(sucursal);
                lista.add(prestamo);
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
