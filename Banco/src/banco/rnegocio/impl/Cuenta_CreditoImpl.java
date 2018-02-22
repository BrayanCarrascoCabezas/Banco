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
public class Cuenta_CreditoImpl implements ICuenta_Credito{
    
         @Override
    
      public int insertar(Cuenta_Credito cuenta_Credito) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into cuenta_credito  values "
                + "(?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cuenta_Credito.getN_cuenta()));
        lstPar.add(new Parametro(2, cuenta_Credito.getCuenta().getCodigo_cuenta()));
        lstPar.add(new Parametro(3, cuenta_Credito.getSaldo()));
        lstPar.add(new Parametro(4, cuenta_Credito.getU_sobregiro()));
        

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
    public int modificar(Cuenta_Credito cuenta_Credito) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE cuenta_Credito"
                + "   SET n_cuenta=?, codigo_cuenta=?, saldo=?, u_sobregiro=?, "
                        + " where n_cuenta=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cuenta_Credito.getN_cuenta()));
        lstPar.add(new Parametro(2, cuenta_Credito.getCuenta().getCodigo_cuenta()));
        lstPar.add(new Parametro(3, cuenta_Credito.getSaldo()));
        lstPar.add(new Parametro(4, cuenta_Credito.getU_sobregiro()));
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
public int eliminar(Cuenta_Credito cuenta_Credito) throws Exception {
        int numFilasAfectadas = 0;
         String sql = "DELETE FROM cuenta_credito  where n_cuenta=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cuenta_Credito.getN_cuenta()));       
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
    public Cuenta_Credito obtener(int codigo) throws Exception {
        Cuenta_Credito cuenta_Credito = null;
        String sql = "SELECT *   FROM cuenta_credito where n_cuenta=?;";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, codigo));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);
            while (rst.next()) {
                cuenta_Credito = new Cuenta_Credito();
                cuenta_Credito.setN_cuenta(rst.getInt(1));
                ICuenta cuentadao=new CuentaImpl();
                Cuenta cuenta=cuentadao.obtener(rst.getInt(2));
                cuenta_Credito.setCuenta(cuenta);
                cuenta_Credito.setSaldo(rst.getInt(3));
                cuenta_Credito.setU_sobregiro(rst.getInt(4));
            

            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(con!=null)
            con.desconectar();
        }
        return cuenta_Credito;
    }

    @Override
    
    public List<Cuenta_Credito> obtener() throws Exception {
        List<Cuenta_Credito> lista = new ArrayList<>();
         String sql = "SELECT *   FROM cuenta_Credito ";        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            Cuenta_Credito cuenta_Credito=null;
            while (rst.next()) {
                cuenta_Credito = new Cuenta_Credito();
                cuenta_Credito.setN_cuenta(rst.getInt(1));
                ICuenta cuentadao=new CuentaImpl();
                Cuenta cuenta=cuentadao.obtener(rst.getInt(2));
                cuenta_Credito.setCuenta(cuenta);
                cuenta_Credito.setSaldo(rst.getInt(3));
                cuenta_Credito.setU_sobregiro(rst.getInt(4));
                lista.add(cuenta_Credito);
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
