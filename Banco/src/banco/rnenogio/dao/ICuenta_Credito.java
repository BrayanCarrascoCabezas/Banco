/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.rnenogio.dao;

import banco.rnegocio.entidades.Cuenta_Credito;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author WILCXMAC
 */
public interface ICuenta_Credito {
     public int insertar(Cuenta_Credito cuenta_credito) throws Exception;

    public int modificar(Cuenta_Credito cuenta_credito) throws Exception;

    public int eliminar(Cuenta_Credito cuenta_credito) throws Exception;

    public Cuenta_Credito  obtener(int codigo) throws Exception;

    public List<Cuenta_Credito> obtener() throws Exception;
}
