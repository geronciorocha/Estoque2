/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GET;

import bd.DAO.CidadeCodigo;
import jInternalFrameEstoque.JD_cliente;

/**
 *
 * @author Cliente
 */
public class GetCidadeCodigo extends CidadeCodigo{
    public GetCidadeCodigo(){
        JD_cliente cidade = new JD_cliente(null, true);
        cidade.setVisible(true);
        cidade.toFront();
        //this.CidadeCodigo = cidadeCodigo;
    }
    public static CidadeCodigo cidadeCodigo;
}
