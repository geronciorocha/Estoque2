/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GET;

import javax.swing.JOptionPane;

/**
 *
 * @author Cliente
 */
public class DialogComboBox extends Object{
    public static Object getItem(Object[] itens){
        return JOptionPane.showInputDialog(null, "", "", 
                JOptionPane.INFORMATION_MESSAGE, null, itens, itens [0]);
    }
}
