/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.rnenogio.dao;

import banco.rnegocio.entidades.Cuenta_Ahorros;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author WILCXMAC
 */
public interface ICuenta_ahorros {
        public int insertar(Cuenta_Ahorros cuenta_ahorro) throws Exception;

    public int modificar(Cuenta_Ahorros cuenta_ahorro) throws Exception;

    public int eliminar(Cuenta_Ahorros cuenta_ahorro) throws Exception;

    public Cuenta_Ahorros  obtener(int codigo) throws Exception;

    public List<Cuenta_Ahorros> obtener() throws Exception;
}
