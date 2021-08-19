/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jInternalFrameEstoque;

import GET.DialogComboBox;
import POST.PostAliquotaSimplesNacional;
import bd.DAO.AliquotaSimplesNacional;
import bd.DAO.ConfigCstAlqSimples;
import bd.DAO.Cst;
import bd.DAO.CstPis;
import dao.Controller;
import java.awt.Color;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import util.ColoracaoTabela;

/**
 *
 * @author Cliente
 */
public class JD_inserir_impostos extends javax.swing.JDialog {
    //public static AliquotaSimplesNacional alq = null;
    
    
    public JD_inserir_impostos(
            java.awt.Frame parent, 
            boolean modal
    ){
        super(parent, modal);
        initComponents();
        TableCellRenderer colorRenderer = new ColoracaoTabela(null);
        jT_cst.setDefaultRenderer(String.class, colorRenderer);
        for (int i = 0; i < jT_cst.getModel().getColumnCount(); i++) {
            jT_cst.getColumnModel().getColumn(i).setHeaderRenderer(new ColoracaoTabela(null).ColorTableHeader(jT_cst, Color.BLACK));
        }
        
        abreCampos1(true);
        
        setValue(PostAliquotaSimplesNacional.aliquotaSimplesNacional);
    }

    List<ConfigCstAlqSimples> listConfigCstAlqSimples = new ArrayList<>();
    
    
    public void abreCampos1(boolean b){
        jComboBox1.setEnabled(true);
        jComboBox2.setEnabled(true);
        jMoneyField2.setEnabled(true);
        jButton4.setEnabled(true);
        if(b)
        fechaCampos2(false);
    }
    public void fechaCampos1(boolean b){
        jComboBox1.setEnabled(false);
        jComboBox2.setEnabled(false);
        jMoneyField2.setEnabled(false);
        jButton4.setEnabled(false);
        if(b)
        abreCampos2(false);
    }
    public void abreCampos2(boolean b){
        if(b)
        fechaCampos1(false);
    }
    public void fechaCampos2(boolean b){
        if(b)
        abreCampos1(false);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMoneyField2 = new ClassesEntidades.JMoneyField();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jT_cst = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/img/parametrizar.gif")).getImage());
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Impostos:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Valor:");

        jMoneyField2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jMoneyField2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jMoneyField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMoneyField2ActionPerformed(evt);
            }
        });
        jMoneyField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jMoneyField2KeyReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Tipo:");

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Check.png"))); // NOI18N
        jButton1.setText("Confirmar");
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setOpaque(false);
        jButton1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Delete1.png"))); // NOI18N
        jButton2.setText("Cancelar");
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setOpaque(false);
        jButton2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jComboBox2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ICMS", "PIS/PASEP", "COFINS", "CPP", "CSLL", "IRPJ" }));
        jComboBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox2ItemStateChanged(evt);
            }
        });
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jComboBox1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Percentual (%)", "Valor ($)" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        jT_cst.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CST", "CST", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jT_cst.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jT_cst.getTableHeader().setReorderingAllowed(false);
        jT_cst.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jT_cstMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jT_cst);
        if (jT_cst.getColumnModel().getColumnCount() > 0) {
            jT_cst.getColumnModel().getColumn(0).setMinWidth(100);
            jT_cst.getColumnModel().getColumn(0).setPreferredWidth(100);
            jT_cst.getColumnModel().getColumn(0).setMaxWidth(100);
            jT_cst.getColumnModel().getColumn(1).setMinWidth(350);
            jT_cst.getColumnModel().getColumn(1).setPreferredWidth(350);
            jT_cst.getColumnModel().getColumn(1).setMaxWidth(350);
            jT_cst.getColumnModel().getColumn(2).setMinWidth(0);
            jT_cst.getColumnModel().getColumn(2).setPreferredWidth(0);
            jT_cst.getColumnModel().getColumn(2).setMaxWidth(0);
        }

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.gif"))); // NOI18N
        jButton4.setText("Adicionar CST");
        jButton4.setFocusable(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/remove.gif"))); // NOI18N
        jButton3.setText("Remover CST");
        jButton3.setFocusable(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jMoneyField2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(10, 10, 10))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jMoneyField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(2, 2, 2)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton3, jButton4});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        try {
            if(PostAliquotaSimplesNacional.aliquotaSimplesNacional==null){
                PostAliquotaSimplesNacional.aliquotaSimplesNacional = new AliquotaSimplesNacional();
            }
            PostAliquotaSimplesNacional.aliquotaSimplesNacional.setImposto(jComboBox2.getSelectedItem().toString());
            if(jComboBox1.getSelectedItem().toString().contains("%")){
                PostAliquotaSimplesNacional.aliquotaSimplesNacional.setTipo('%');
            }else if(jComboBox1.getSelectedItem().toString().contains("$")){
                PostAliquotaSimplesNacional.aliquotaSimplesNacional.setTipo('$');
            }
            PostAliquotaSimplesNacional.aliquotaSimplesNacional.setValor(new BigDecimal(jMoneyField2.getText().replace(".", "").replace(",", ".")));
            PostAliquotaSimplesNacional.aliquotaSimplesNacional.getConfigCstAlqSimplesList().addAll(listConfigCstAlqSimples);
            
            PostAliquotaSimplesNacional.aliquotaSimplesNacional =
                    new Controller().ControllerPersistMerge(AliquotaSimplesNacional.class, PostAliquotaSimplesNacional.aliquotaSimplesNacional);
            dispose();
        } catch (Exception ex) {
            Logger.getLogger(JD_inserir_impostos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMoneyField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jMoneyField2KeyReleased
        
    }//GEN-LAST:event_jMoneyField2KeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        PostAliquotaSimplesNacional.aliquotaSimplesNacional = null;
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox2ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ItemStateChanged

    private void jMoneyField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMoneyField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMoneyField2ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       
            try {
                if (jComboBox2.getSelectedItem().toString().equalsIgnoreCase("ICMS")) {
                    List <Cst> listCst = (List <Cst>) new Controller().ControllerFindAll(Cst.class);
                    Cst cst = (Cst) DialogComboBox.getItem(listCst.toArray());
                    if(cst!=null)
                    addRowTable(cst.getNumeroCst(), cst.getDescricaoCst(), addlistConfigCstAlqSimples(cst.getNumeroCst()));
                } else if (jComboBox2.getSelectedItem().toString().equalsIgnoreCase("PIS/PASEP") || jComboBox2.getSelectedItem().toString().equalsIgnoreCase("COFINS")) {
                    List <CstPis> listCst = (List <CstPis>) new Controller().ControllerFindAll(CstPis.class);
                    CstPis cst = (CstPis) DialogComboBox.getItem(listCst.toArray());
                    if(cst!=null)
                    addRowTable(cst.getNumeroCst(), cst.getDescricaoCst(), addlistConfigCstAlqSimples(cst.getNumeroCst()));
                }
            } catch (Exception ex) {
                Logger.getLogger(JD_inserir_impostos.class.getName()).log(Level.SEVERE, null, ex);
            }
            abreCampos2(true);
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        PostAliquotaSimplesNacional.aliquotaSimplesNacional = null;
        dispose();
    }//GEN-LAST:event_formWindowClosing

    private void jT_cstMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jT_cstMouseClicked
        System.out.println(jT_cst.getSelectedRow());
    }//GEN-LAST:event_jT_cstMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        removeCstTable();
    }//GEN-LAST:event_jButton3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButton1;
    public javax.swing.JButton jButton2;
    public javax.swing.JButton jButton3;
    public javax.swing.JButton jButton4;
    public javax.swing.JComboBox<String> jComboBox1;
    public javax.swing.JComboBox<String> jComboBox2;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel5;
    public ClassesEntidades.JMoneyField jMoneyField2;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jT_cst;
    // End of variables declaration//GEN-END:variables

    
   
    
    public ConfigCstAlqSimples addlistConfigCstAlqSimples(String cst) {
        ConfigCstAlqSimples config = new ConfigCstAlqSimples(getCST(cst));
        config.setCodigoAlqSimples(PostAliquotaSimplesNacional.aliquotaSimplesNacional);
        listConfigCstAlqSimples.add(config);
        return config;
    }
    
    public void removeCstTable() {
        if (jT_cst.getSelectedRow() > -1) {
            try {
                ConfigCstAlqSimples config = (ConfigCstAlqSimples) jT_cst.getValueAt(jT_cst.getSelectedRow(), 2);
                new Controller().ControllerRemove(config);
                DefaultTableModel model = (DefaultTableModel) jT_cst.getModel();
                model.removeRow(jT_cst.getSelectedRow());
                jT_cst.setModel(model);
            } catch (Exception ex) {
                Logger.getLogger(JD_inserir_impostos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(this, "Selecione uma linha na tabela.", "", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public Object getCST(String cst){
        
        try {
            if (jComboBox2.getSelectedItem().toString().equalsIgnoreCase("ICMS")) {
                return new Controller().ControllerFind(Cst.class, cst);
            } else if (jComboBox2.getSelectedItem().toString().equalsIgnoreCase("PIS/PASEP") || jComboBox2.getSelectedItem().toString().equalsIgnoreCase("COFINS")) {
                return new Controller().ControllerFind(CstPis.class, cst);
            }
        } catch (Exception ex) {
            Logger.getLogger(JD_inserir_impostos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void setValue(AliquotaSimplesNacional alq){
        if(alq!=null){
            jComboBox2.setSelectedItem(alq.getImposto()!=null ? alq.getImposto() : "");
            jComboBox1.setSelectedItem(alq.getTipo() != null ? String.valueOf(alq.getTipo()) : "");
            jMoneyField2.setText(alq.getValor() != null ? String.format("%.2f", alq.getValor().doubleValue()) : "0,00");
            
            for (int i = 0; i < alq.getConfigCstAlqSimplesList().size(); i++) {
                addRowTable(
                         alq.getConfigCstAlqSimplesList().get(i).getCstIcms()!=null?
                         alq.getConfigCstAlqSimplesList().get(i).getCstIcms().getNumeroCst() :
                                 
                         alq.getConfigCstAlqSimplesList().get(i).getCstPiscofins()!=null?
                         alq.getConfigCstAlqSimplesList().get(i).getCstPiscofins().getNumeroCst() : ""       
                         ,
                         alq.getConfigCstAlqSimplesList().get(i).getCstIcms()!=null?
                         alq.getConfigCstAlqSimplesList().get(i).getCstIcms().getDescricaoCst() :
                                 
                         alq.getConfigCstAlqSimplesList().get(i).getCstPiscofins()!=null?
                         alq.getConfigCstAlqSimplesList().get(i).getCstPiscofins().getDescricaoCst() : ""
                         
                         ,
                         alq.getConfigCstAlqSimplesList().get(i)
                         
                );
            }
        }
    }
    
    private void addRowTable(String codigo, String cst, ConfigCstAlqSimples config) {
        DefaultTableModel model = (DefaultTableModel) jT_cst.getModel();

        model.addRow(new Vector(model.getRowCount() + 1));
        jT_cst.setModel(model);
        jT_cst.setRowSelectionInterval(jT_cst.getRowCount() - 1, jT_cst.getRowCount() - 1);
        jT_cst.setValueAt(codigo, jT_cst.getSelectedRow(), 0);
        jT_cst.setValueAt(cst, jT_cst.getSelectedRow(), 1);
        jT_cst.setValueAt(config, jT_cst.getSelectedRow(), 2);
    }
    
}
