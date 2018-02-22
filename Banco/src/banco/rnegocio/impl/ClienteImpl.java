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
public class ClienteImpl implements ICliente{
    
    
     @Override
     
     public int insertar(Cliente cliente) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into cliente  values "
                + "(?,?,?,?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cliente.getCodigo_cliente()));
        lstPar.add(new Parametro(2, cliente.getCedula()));
        lstPar.add(new Parametro(3, cliente.getNombres()));
        lstPar.add(new Parametro(4, cliente.getApellidos()));
        lstPar.add(new Parametro(5, cliente.getCelular()));
        lstPar.add(new Parametro(6, cliente.getEmail()));
        lstPar.add(new Parametro(7, cliente.getPrestamo().getId_prestamo()));
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
    public int modificar(Cliente cliente) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE cliente"
                + "   SET codigo_cliente=?, cedula=?, nombres=?, apellidos=?, celular=?, "
                + "email=?,cod_prestamo"
                + " where codigo_cliente=?";
        List<Parametro> lstPar = new ArrayList<>();
       lstPar.add(new Parametro(1, cliente.getCodigo_cliente()));
        lstPar.add(new Parametro(2, cliente.getCedula()));
        lstPar.add(new Parametro(3, cliente.getNombres()));
        lstPar.add(new Parametro(4, cliente.getApellidos()));
        lstPar.add(new Parametro(5, cliente.getCelular()));
        lstPar.add(new Parametro(6, cliente.getEmail()));
        lstPar.add(new Parametro(7, cliente.getPrestamo().getId_prestamo()));
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
    public int eliminar(Cliente cliente) throws Exception {
        int numFilasAfectadas = 0;
         String sql = "DELETE FROM cliente  where codigo_cliente=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cliente.getCodigo_cliente()));       
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
    public Cliente obtener(int codigo) throws Exception {
        Cliente cliente = null;
        String sql = "SELECT *   FROM cliente where codigo_cliente=?;";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, codigo));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);
            while (rst.next()) {
                cliente = new Cliente();
                cliente.setCodigo_cliente(rst.getInt(1));
                cliente.setCedula(rst.getInt(2));
                cliente.setNombres(rst.getString(3));
                cliente.setApellidos(rst.getString(4));
                cliente.setCelular(rst.getInt(5));
                cliente.setEmail(rst.getString(6));

                IPrestamo prestamodao = new PrestamoImpl();
                Prestamo prestamo = prestamodao.obtener(rst.getInt(7));
                cliente.setPrestamo(prestamo);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(con!=null)
            con.desconectar();
        }
        return cliente;
    }

    @Override
    public List<Cliente> obtener() throws Exception {
        List<Cliente> lista = new ArrayList<>();
         String sql = "SELECT *   FROM cliente ";        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            Cliente cliente=null;
            while (rst.next()) {
                cliente = new Cliente();
                cliente.setCodigo_cliente(rst.getInt(1));
                cliente.setCedula(rst.getInt(2));
                cliente.setNombres(rst.getString(3));
                cliente.setApellidos(rst.getString(4));
                cliente.setCelular(rst.getInt(5));
                cliente.setEmail(rst.getString(6));

                IPrestamo prestamodao = new PrestamoImpl();
                Prestamo prestamo = prestamodao.obtener(rst.getInt(7));
                cliente.setPrestamo(prestamo);
                lista.add(cliente);
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
