/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POST;

import bd.DAO.AliquotaSimplesNacional;
import jInternalFrameEstoque.JD_inserir_impostos;

/**
 *
 * @author Cliente
 */
public class PostAliquotaSimplesNacional {

    public PostAliquotaSimplesNacional(){
        JD_inserir_impostos jd_impostos = new JD_inserir_impostos(null, true);
        jd_impostos.setVisible(true); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static AliquotaSimplesNacional aliquotaSimplesNacional;
    
    public static AliquotaSimplesNacional getAliquotaSimplesNacional() {
        new PostAliquotaSimplesNacional();
        return aliquotaSimplesNacional;
    }

    public static AliquotaSimplesNacional setAliquotaSimplesNacional(AliquotaSimplesNacional aliquotaSimplesNacional) {
        PostAliquotaSimplesNacional.aliquotaSimplesNacional = aliquotaSimplesNacional;
        JD_inserir_impostos jd_impostos = new JD_inserir_impostos(null, true);
        jd_impostos.setVisible(true);
        return PostAliquotaSimplesNacional.aliquotaSimplesNacional;
    }
    
}
