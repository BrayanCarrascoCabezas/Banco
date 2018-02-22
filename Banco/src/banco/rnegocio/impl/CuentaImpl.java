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
public class CuentaImpl implements ICuenta{
    
    @Override
     
    public int insertar(Cuenta cuenta) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into cuenta  values "
                + "(?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cuenta.getCodigo_cuenta()));
        lstPar.add(new Parametro(2, cuenta.getCliente().getCodigo_cliente()));

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
    public int modificar(Cuenta cuenta) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE cuenta"
                + "   SET codigo_cuenta=?, codigo_cliente=? where id_cuenta=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cuenta.getCodigo_cuenta()));
        lstPar.add(new Parametro(2, cuenta.getCliente().getCodigo_cliente()));
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
    public int eliminar(Cuenta cuenta) throws Exception {
        int numFilasAfectadas = 0;
         String sql = "DELETE FROM cuenta  where codigo_cuenta=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cuenta.getCodigo_cuenta()));       
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
    public Cuenta obtener(int codigo) throws Exception {
        Cuenta cuenta = null;
        String sql = "SELECT *   FROM cuenta where codigo_cuenta=?;";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, codigo));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);
            while (rst.next()) {
                cuenta = new Cuenta();
                cuenta.setCodigo_cuenta(rst.getInt(1));
                ICliente clientedao= new ClienteImpl();
                Cliente cliente=clientedao.obtener(rst.getInt(2));
                cuenta.setCliente(cliente);

            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(con!=null)
            con.desconectar();
        }
        return cuenta;
    }

    @Override
    public List<Cuenta> obtener() throws Exception {
        List<Cuenta> lista = new ArrayList<>();
         String sql = "SELECT *   FROM cuenta ";        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            Cuenta cuenta=null;
            while (rst.next()) {
                
                cuenta = new Cuenta();
                cuenta.setCodigo_cuenta(rst.getInt(1));
                ICliente clientedao= new ClienteImpl();
                Cliente cliente=clientedao.obtener(rst.getInt(2));
                cuenta.setCliente(cliente);
                lista.add(cuenta);
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
