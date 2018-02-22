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
public class Cuenta_AhorrosImpl implements ICuenta_ahorros{
     @Override
    
      public int insertar(Cuenta_Ahorros cuenta_Ahorros) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into cuenta_Ahorros  values "
                + "(?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cuenta_Ahorros.getN_cuenta()));
        lstPar.add(new Parametro(2, cuenta_Ahorros.getCuenta().getCodigo_cuenta()));
        lstPar.add(new Parametro(3, cuenta_Ahorros.getSaldo()));
        lstPar.add(new Parametro(4, cuenta_Ahorros.getInteres()));
        

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
    public int modificar(Cuenta_Ahorros cuenta_Ahorros) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE cuenta_Ahorros"
                + "   SET n_cuenta=?, codigo_cuenta=?, saldo=?, interes=?, "
                        + " where id_cuenta_Ahorros=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cuenta_Ahorros.getN_cuenta()));
        lstPar.add(new Parametro(2, cuenta_Ahorros.getCuenta().getCodigo_cuenta()));
        lstPar.add(new Parametro(3, cuenta_Ahorros.getSaldo()));
        lstPar.add(new Parametro(4, cuenta_Ahorros.getInteres()));
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
public int eliminar(Cuenta_Ahorros cuenta_Ahorros) throws Exception {
        int numFilasAfectadas = 0;
         String sql = "DELETE FROM cuenta_Ahorros  where n_cuenta=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cuenta_Ahorros.getN_cuenta()));       
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
    public Cuenta_Ahorros obtener(int codigo) throws Exception {
        Cuenta_Ahorros cuenta_Ahorros = null;
        String sql = "SELECT *   FROM cuenta_Ahorros where n_cuenta=?;";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, codigo));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);
            while (rst.next()) {
                cuenta_Ahorros = new Cuenta_Ahorros();
                cuenta_Ahorros.setN_cuenta(rst.getInt(1));
                ICuenta cuentadao=new CuentaImpl();
                Cuenta cuenta=cuentadao.obtener(rst.getInt(2));
                cuenta_Ahorros.setCuenta(cuenta);
                cuenta_Ahorros.setSaldo(rst.getInt(3));
                cuenta_Ahorros.setInteres(rst.getInt(4));
            

            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(con!=null)
            con.desconectar();
        }
        return cuenta_Ahorros;
    }

    @Override
    
    public List<Cuenta_Ahorros> obtener() throws Exception {
        List<Cuenta_Ahorros> lista = new ArrayList<>();
         String sql = "SELECT *   FROM cuenta_Ahorros ";        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            Cuenta_Ahorros cuenta_Ahorros=null;
            while (rst.next()) {
                cuenta_Ahorros = new Cuenta_Ahorros();
                cuenta_Ahorros.setN_cuenta(rst.getInt(1));
                ICuenta cuentadao=new CuentaImpl();
                Cuenta cuenta=cuentadao.obtener(rst.getInt(2));
                cuenta_Ahorros.setCuenta(cuenta);
                cuenta_Ahorros.setSaldo(rst.getInt(3));
                cuenta_Ahorros.setInteres(rst.getInt(4));
                lista.add(cuenta_Ahorros);
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
