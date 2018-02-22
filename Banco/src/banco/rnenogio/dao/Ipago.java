/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.rnenogio.dao;

import banco.rnegocio.entidades.Pago;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author WILCXMAC
 */
public interface Ipago {
        public int insertar(Pago pago) throws Exception;
    
    public int modificar(Pago pago) throws Exception;

    public int eliminar(Pago pago) throws Exception;

    public Pago obtener(int codigo) throws Exception;

    public List<Pago> obtener() throws Exception;  
}
