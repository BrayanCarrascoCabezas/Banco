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
public class InspectorImpl implements IInspector{
    
   @Override
     
     public int insertar(Inspector inspector) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into inspector  values "
                + "(?,?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, inspector.getCodigo()));
        lstPar.add(new Parametro(2, inspector.getNombre()));
        lstPar.add(new Parametro(3, inspector.getDireccion()));
        lstPar.add(new Parametro(4, inspector.getTitulo()));
        lstPar.add(new Parametro(5, inspector.getPrestamo().getId_prestamo()));
  
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
    public int modificar(Inspector inspector) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE inspector"
                + "   SET codigo=?, nombre=?, direccion=?, titulo=?, id_prestamo=?, "
                + " where codigo_inspector=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, inspector.getCodigo()));
        lstPar.add(new Parametro(2, inspector.getNombre()));
        lstPar.add(new Parametro(3, inspector.getDireccion()));
        lstPar.add(new Parametro(4, inspector.getTitulo()));
        lstPar.add(new Parametro(5, inspector.getPrestamo().getId_prestamo()));
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
    public int eliminar(Inspector inspector) throws Exception {
        int numFilasAfectadas = 0;
         String sql = "DELETE FROM inspector  where codigo=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, inspector.getCodigo()));       
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
    public Inspector obtener(int codigo) throws Exception {
        Inspector inspector = null;
        String sql = "SELECT *   FROM inspector where codigo=?;";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, codigo));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);
            while (rst.next()) {
                inspector = new Inspector();
                inspector.setCodigo(rst.getInt(1));
                inspector.setNombre(rst.getString(2));
                inspector.setDireccion(rst.getString(3));
                inspector.setTitulo(rst.getString(4));
   
                IPrestamo prestamodao = new PrestamoImpl();
                Prestamo prestamo = prestamodao.obtener(rst.getInt(5));
                inspector.setPrestamo(prestamo);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(con!=null)
            con.desconectar();
        }
        return inspector;
    }

    @Override
    public List<Inspector> obtener() throws Exception {
        List<Inspector> lista = new ArrayList<>();
         String sql = "SELECT *   FROM inspector ";        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            Inspector inspector=null;
            while (rst.next()) {
                inspector = new Inspector();
               inspector.setCodigo(rst.getInt(1));
                inspector.setNombre(rst.getString(2));
                inspector.setDireccion(rst.getString(3));
                inspector.setTitulo(rst.getString(4));
   
                IPrestamo prestamodao = new PrestamoImpl();
                Prestamo prestamo = prestamodao.obtener(rst.getInt(5));
                inspector.setPrestamo(prestamo);
                lista.add(inspector);
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
