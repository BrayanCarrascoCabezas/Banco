/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.rnenogio.dao;

import banco.rnegocio.entidades.Inspector;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author WILCXMAC
 */
public interface IInspector {
        public int insertar(Inspector inspector) throws Exception;

    public int modificar(Inspector inspector) throws Exception;

    public int eliminar(Inspector inspector) throws Exception;

    public Inspector obtener(int codigo) throws Exception;

    public List<Inspector> obtener() throws Exception;
}
