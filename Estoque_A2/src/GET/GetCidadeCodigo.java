/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GET;

import bd.DAO.CidadeCodigo;

/**
 *
 * @author Cliente
 */
public class GetCidadeCodigo {
    public GetCidadeCodigo(){
        new JdGetCidadeCodigo(null, true).setVisible(true);
    }
    protected static CidadeCodigo cidadeCodigo;

    public static CidadeCodigo getCidadeCodigo() {
        new GetCidadeCodigo();
        return cidadeCodigo;
    }
    
}
