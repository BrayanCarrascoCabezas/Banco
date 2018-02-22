/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.rnegocio.dao;

import banco.rnegocio.entidades.Ciudad;
import java.util.*;

/**
 *
 * @author WILCXMAC
 */
public interface ICiudad {
    
      public int insertar(Ciudad ciudad) throws Exception;

    public int modificar(Ciudad ciudad) throws Exception;

    public int eliminar(Ciudad ciudad) throws Exception;

    public Ciudad obtener(int codigo) throws Exception;

    public List<Ciudad> obtener() throws Exception;
    
}

    
    
    

