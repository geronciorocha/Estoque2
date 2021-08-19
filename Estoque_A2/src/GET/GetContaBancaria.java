/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GET;

import bd.DAO.ContaBancaria;

/**
 *
 * @author Cliente
 */
public class GetContaBancaria {
    
    protected static ContaBancaria contaBancaria;
    
    public GetContaBancaria(){
        new JdGetContaBancaria(null, true).setVisible(true);
    }

    public static ContaBancaria getContaBancaria() {
        new GetContaBancaria();
        return contaBancaria;
    }
    
}
