package jInternalFrameEstoque;

import GET.GetCidadeCodigo;
import POST.PostAliquotaSimplesNacional;
import bd.DAO.AliquotaSimplesNacional;
import bd.DAO.Cep;
import bd.DAO.CidadeCodigo;
import bd.DAO.ConfigTaxaCartao;
import bd.DAO.Configuracao;
import bd.DAO.ContaBancaria;
import bd.DAO.Contabilista;
import bd.DAO.Empresa;
import bd.DAO.GupoProduto;
import jMoneyField.JMoneyField;
import bd.DAO.Pardigital;
import bd.DAO.TipoPagamento;
import bd.DAO.TipoPagamentoCartao;
import bd.DAO.TipoPagamentoCartaoPK;
import bd.DAO.TipoPagamentoPromissoria;
import dao.Controller;
import java.awt.Color;
import utilitarios.Biblioteca;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import util.ColoracaoTabela;

public class JIFEmpresa extends javax.swing.JInternalFrame {

    private Empresa EMPRESA = new Controller().ControllerFind(Empresa.class, 1);
    private final List<TipoPagamento> tipoPagamentoList = (List<TipoPagamento>) new Controller().ControllerFindAll(TipoPagamento.class);
    private final List<GupoProduto> gupoProdutoList = (List<GupoProduto>) new Controller().ControllerFindAll(GupoProduto.class);

    public JIFEmpresa() throws Exception {
            initComponents();
            jLabel72.setVisible(false);
            createTables();
            TableCellRenderer colorRenderer = new ColoracaoTabela(null);
            jTable1.setDefaultRenderer(Object.class, colorRenderer);
            jTable1.setDefaultRenderer(String.class, colorRenderer);
            for (int i = 0; i < jTable1.getModel().getColumnCount(); i++) {
                jTable1.getColumnModel().getColumn(i).setHeaderRenderer(new ColoracaoTabela(null).ColorTableHeader(jTable1, Color.BLACK));
            }

            jTable2.setDefaultRenderer(Integer.class, colorRenderer);
            jTable2.setDefaultRenderer(String.class, colorRenderer);
            for (int i = 0; i < jTable2.getModel().getColumnCount(); i++) {
                jTable2.getColumnModel().getColumn(i).setHeaderRenderer(new ColoracaoTabela(null).ColorTableHeader(jTable2, Color.BLACK));
            }

            jTable3.setDefaultRenderer(Integer.class, colorRenderer);
            jTable3.setDefaultRenderer(String.class, colorRenderer);
            for (int i = 0; i < jTable3.getModel().getColumnCount(); i++) {
                jTable3.getColumnModel().getColumn(i).setHeaderRenderer(new ColoracaoTabela(null).ColorTableHeader(jTable3, Color.BLACK));
            }

            jTable4.setDefaultRenderer(Object.class, colorRenderer);
            for (int i = 0; i < jTable4.getModel().getColumnCount(); i++) {
                jTable4.getColumnModel().getColumn(i).setHeaderRenderer(new ColoracaoTabela(null).ColorTableHeader(jTable4, Color.BLACK));
            }

            jTable5.setDefaultRenderer(Object.class, colorRenderer);
            for (int i = 0; i < jTable5.getModel().getColumnCount(); i++) {
                jTable5.getColumnModel().getColumn(i).setHeaderRenderer(new ColoracaoTabela(null).ColorTableHeader(jTable5, Color.BLACK));
            }

            jTable6.setDefaultRenderer(Integer.class, colorRenderer);
            jTable6.setDefaultRenderer(String.class, colorRenderer);
            for (int i = 0; i < jTable6.getModel().getColumnCount(); i++) {
                jTable6.getColumnModel().getColumn(i).setHeaderRenderer(new ColoracaoTabela(null).ColorTableHeader(jTable6, Color.BLACK));
            }

            jTable7.setDefaultRenderer(Object.class, colorRenderer);
            jTable7.setDefaultRenderer(Integer.class, colorRenderer);
            jTable7.setDefaultRenderer(String.class, colorRenderer);
            for (int i = 0; i < jTable7.getModel().getColumnCount(); i++) {
                jTable7.getColumnModel().getColumn(i).setHeaderRenderer(new ColoracaoTabela(null).ColorTableHeader(jTable7, Color.BLACK));
            }

            setValueEmpresa();
            trataComboBoxGrupo();
            trataComboBoxFormaPagamento();
            fechaCampos();
    }

    DefaultTableModel modelTableFormaPagamento;
    DefaultTableModel modelTableFormaPagamento2;
    DefaultTableModel modelTableFormaPagamento3;
    DefaultTableModel modelTableFormaPagamentoAvista;
    DefaultTableModel modelTableSimplesNacional;

    //int row = 0;

    public void AbrirCamposOpcartao2() {
        jRadioButton7.setEnabled(true);
        jRadioButton8.setEnabled(true);
        jComboBox5.setEnabled(true);
        jTextField32.setEnabled(true);
        jTextField33.setEnabled(true);
        jButton2.setEnabled(true);
        jCheckBox19.setEnabled(true);
        jTable2.setEnabled(true);
    }
    
    public void FecharCamposOpcartao2() {
        jRadioButton7.setEnabled(false);
        jRadioButton8.setEnabled(false);
        jComboBox5.setEnabled(false);
        jTextField32.setEnabled(false);
        jTextField33.setEnabled(false);
        jButton2.setEnabled(false);
        jCheckBox19.setEnabled(false);
        jTable2.setEnabled(false);
    }
    
    public void AbrirCamposOpcartao() {
        jComboBox8.setEnabled(true);
        jSpinner1.setEnabled(true);
        jCheckBox14.setEnabled(true);
        jComboBox6.setEnabled(true);
        jTable3.setEnabled(true);
    }
    public void FecharCamposOpcartao() {
        jComboBox8.setEnabled(false);
        jSpinner1.setEnabled(false);
        jCheckBox14.setEnabled(false);
        jComboBox6.setEnabled(false);
        jTable3.setEnabled(false);
    }
    
    public void AbrirCamposDescontoMaximoProduto() {
        jComboBox12.setEnabled(true);
        jMoneyField1.setEnabled(true);
        jButton9.setEnabled(true);
        jButton12.setEnabled(true);
        jTable7.setEnabled(true);
    }

    public void AbrirCamposDescontoMaximo() {
        jMoneyField2.setEnabled(true);
        jButton10.setEnabled(true);
    }

    public void FecharCamposDescontoMaximoGrupo() {
        jComboBox12.setEnabled(false);
        jMoneyField1.setEnabled(false);
        jButton9.setEnabled(false);
        jButton12.setEnabled(false);
        jTable7.setEnabled(false);
    }

    public void FecharCamposDescontoMaximo() {
        jMoneyField2.setEnabled(false);
        jButton10.setEnabled(false);
        jLabel72.setVisible(false);
    }

    public void AbrirCamposBoleto() {
        jComboBox3.setEnabled(true);
        jButton1.setEnabled(true);
        jTable1.setEnabled(true);
    }

    public void FecharCamposBoleto() {
        jComboBox3.setEnabled(false);
        jButton1.setEnabled(false);
        jTable1.setEnabled(false);
    }

    public void AbrirCamposPromissoria() {
        jComboBox7.setEnabled(true);
        jButton4.setEnabled(true);
    }

    public void FecharCamposPromissoria() {
        jComboBox7.setEnabled(false);
        jButton4.setEnabled(false);
    }

    public boolean ConsultaDescontoMaximo() {
        Configuracao configuracao = EMPRESA.getConfiguracao();
        boolean retorno = false;
        if (configuracao != null) {
            try {
                if (configuracao.getDescontoMaximoVendedor() != BigDecimal.ZERO) {
                    retorno = true;
                }
            } catch (Exception ex) {
            }
            EMPRESA.setConfiguracao(configuracao);
        }
        return retorno;
    }

    public void situacaoTributaria(boolean b) {
        jCheckBox9.setEnabled(b);
        jCheckBox10.setEnabled(b);
        jCheckBox11.setEnabled(b);
        jCheckBox12.setEnabled(b);
        jCheckBox13.setEnabled(b);
        jCheckBox14.setEnabled(b);
    }

    public void setValueEmpresa() {
        try {
            if (EMPRESA.getExibirCodigoProduto() == 0) {
                jRadioButton3.setSelected(true);
            } else {
                jRadioButton4.setSelected(true);
            }
        } catch (Exception ex) {
            jRadioButton3.setSelected(true);
        }

        try {
            if (EMPRESA.getTpEmissao() == 0) {
                jRadioButton1.setSelected(true);
            } else if (EMPRESA.getTpEmissao() == 1) {
                jRadioButton2.setSelected(true);
            }
        } catch (NullPointerException ex) {
            jRadioButton1.setSelected(true);
        }

        try {
            if (EMPRESA.getAtividade().isEmpty()) {
                EMPRESA.setAtividade(" ");
            } else {
                jComboBox4.setSelectedItem(EMPRESA.getAtividade());
            }
        } catch (NullPointerException e) {

        }

        try {
            if (EMPRESA.getTef() == 1) {
                jRadioButton7.setSelected(true);
            } else {
                jRadioButton8.setSelected(true);
            }
        } catch (NullPointerException e) {
            EMPRESA.setTef(0);
            jRadioButton8.setSelected(true);
        }
        if (EMPRESA.getEmissaoBoleto() == 1) {
            jCheckBox1.setSelected(true);
        } else {
            jCheckBox1.setSelected(false);
        }
        if (EMPRESA.getEmissaoPromissoria() == 1) {
            jCheckBox13.setSelected(true);
        } else {
            jCheckBox13.setSelected(false);
        }

        jComboBox1.setSelectedItem(EMPRESA.getEnquadramento());
        jComboBox2.setSelectedItem(EMPRESA.getTipoTributario());
        if (EMPRESA.getTpEmissao() == 0) {
            jRadioButton1.setSelected(true);
        } else if (EMPRESA.getTpEmissao() == 1) {
            jRadioButton1.setSelected(false);
        }

        try {
            if (EMPRESA.getGasGlp() == 1) {
                jCheckBox15.setSelected(true);
            } else {
                jCheckBox15.setSelected(false);
            }
        } catch (Exception e) {
            jCheckBox15.setSelected(false);
        }

        try {
            if (EMPRESA.getPrestadorServico() == 1) {
                jCheckBox16.setSelected(true);
            } else {
                jCheckBox16.setSelected(false);
            }
        } catch (Exception e) {
            jCheckBox16.setSelected(false);
        }

        try {
            if (EMPRESA.getConfiguracao().getControlaEstoqueServico() == 1) {
                jRadioButton9.setSelected(true);
            } else {
                jRadioButton10.setSelected(true);
            }
        } catch (Exception e) {
            jRadioButton10.setSelected(true);
        }

        try {
            jTextField1.setText(String.valueOf(EMPRESA.getCodigoEmpresa()));
        } catch (Exception e) {
        }
        try {
            jTextField_razao_social1.setText(String.valueOf(EMPRESA.getNomeEmpresa()));
        } catch (Exception e) {
        }
        try {
            jTextField_nome_fantazia1.setText(String.valueOf(EMPRESA.getFantasiaEmpresa()));
        } catch (Exception e) {
        }
        try {
            jTextField4.setText(String.valueOf(EMPRESA.getCnpjEmpresa()));
        } catch (Exception e) {
        }
        try {
            jTextField5.setText(String.valueOf(EMPRESA.getIeEmpresa()));
        } catch (Exception e) {
        }
        try {
            jTextField6.setText(String.valueOf(EMPRESA.getImEmpresa()));
        } catch (Exception e) {
        }
        try {
            jTextField7.setText(String.valueOf(EMPRESA.getCepEmpresa()));
        } catch (Exception e) {
        }
        try {
            jTextField_endereco.setText(String.valueOf(EMPRESA.getEnderecoEmpresa()));
        } catch (Exception e) {
        }
        try {
            jTextField_numero_endereco1.setText(String.valueOf(EMPRESA.getNumeroEmpresa()));
        } catch (Exception e) {
        }
        try {
            jTextField8.setText(String.valueOf(EMPRESA.getBairroEmpresa()));
        } catch (Exception e) {
        }
        try {
            jTextField12.setText(String.valueOf(EMPRESA.getComplemento()));
        } catch (Exception e) {
        }
        try {
            jTextField9.setText(String.valueOf(EMPRESA.getCodigoMunicipio().getCodigo()));
        } catch (Exception e) {
        }
        try {
            jTextField.setText(String.valueOf(EMPRESA.getCodigoMunicipio().getNome()));
        } catch (Exception e) {
        }
        try {
            jTextField2.setText(String.valueOf(EMPRESA.getCodigoMunicipio().getCodigoUf()));
        } catch (Exception e) {
        }
        try {
            jTextField3.setText(String.valueOf(EMPRESA.getCodigoMunicipio().getUf()));
        } catch (Exception e) {
        }
        try {
            jTextField13.setText(EMPRESA.getTelefone());
        } catch (Exception e) {
        }
        try {
            jTextField14.setText(String.valueOf(EMPRESA.getEmail()));
        } catch (Exception e) {
        }
        try {
            jDateChooser_data_cadastro1.setDate(EMPRESA.getDataCadastro());
        } catch (Exception e) {
        }
        try {
            jTextField11.setText(String.valueOf(EMPRESA.getCodigoMunicipio().getCodigoPais()));
        } catch (Exception e) {
        }
        try {
            jTextField10.setText("BRASIL");
        } catch (Exception e) {
        }
        try {
            jTextField21.setText(String.valueOf(EMPRESA.getCrt()));
        } catch (Exception e) {
        }
        try {
            jTextField35.setText(EMPRESA.getSmtp());
        } catch (Exception e) {
        }
        try {
            switch (jTextField35.getText()) {
                case "smtp.gmail.com":
                    jComboBox10.setSelectedItem("Gmail");
                    break;
                case "smtp-mail.outlook.com":
                    jComboBox10.setSelectedItem("Hotmail");
                    break;
                default:
                    jComboBox10.setSelectedItem("Outros");
                    break;
            }
        } catch (Exception e) {
        }
        try {
            jTextField36.setText(EMPRESA.getPorta());
        } catch (Exception e) {
        }
        try {
            jTextField37.setText(EMPRESA.getEmail2());
        } catch (Exception e) {
        }
        try {
            jPasswordField1.setText(EMPRESA.getSenhaEmail());
        } catch (Exception e) {
        }
        try {
            jPasswordField2.setText(EMPRESA.getSenhaEmail());
        } catch (Exception e) {
        }
        try {
            jTextField38.setText(String.valueOf(EMPRESA.getContabilista().getNomeContabilista()));
        } catch (Exception ex) {
        }
        try {
            jTextField39.setText(String.valueOf(EMPRESA.getContabilista().getCpfContabilista()));
        } catch (Exception ex) {
        }
        try {
            jTextField40.setText(String.valueOf(EMPRESA.getContabilista().getCnpjContabilista()));
        } catch (Exception ex) {
        }
        try {
            jTextField41.setText(String.valueOf(EMPRESA.getContabilista().getInscCrc()));
        } catch (Exception ex) {
        }
        try {
            jTextField42.setText(String.valueOf(EMPRESA.getContabilista().getCep().getCep()));
        } catch (Exception ex) {
        }
        try {
            jTextField43.setText(String.valueOf(EMPRESA.getContabilista().getLogradouro()));
        } catch (Exception ex) {
        }
        try {
            jTextField44.setText(String.valueOf(EMPRESA.getContabilista().getNumero()));
        } catch (Exception ex) {
        }
        try {
            jTextField45.setText(String.valueOf(EMPRESA.getContabilista().getComplemento()));
        } catch (Exception ex) {
        }
        try {
            jTextField46.setText(String.valueOf(EMPRESA.getContabilista().getBairro()));
        } catch (Exception ex) {
        }
        try {
            jTextField47.setText(String.valueOf(EMPRESA.getContabilista().getTelefone()));
        } catch (Exception ex) {
        }
        try {
            jTextField48.setText(String.valueOf(EMPRESA.getContabilista().getFax()));
        } catch (Exception ex) {
        }
        try {
            jTextField49.setText(String.valueOf(EMPRESA.getContabilista().getEmail()));
        } catch (Exception ex) {
        }
        try {
            jTextField50.setText(EMPRESA.getContabilista().getCodigoCidade());
        } catch (Exception ex) {
        }
        try {
            jTextField51.setText(EMPRESA.getContabilista().getCidade());
        } catch (Exception ex) {
        }

        try {
            if (EMPRESA.getConfiguracao().getCalcComissao() == 0) {
                jCheckBox20.setSelected(true);
                if (null == EMPRESA.getConfiguracao().getTipoComissao()) {
                    jRadioButton11.setSelected(false);
                    jRadioButton12.setSelected(false);
                } else {
                    switch (EMPRESA.getConfiguracao().getTipoComissao()) {
                        case 1:
                            jRadioButton12.setSelected(true);
                            break;
                        case 0:
                            jRadioButton11.setSelected(true);
                            break;
                        default:
                            break;
                    }
                }
            } else {
                jCheckBox20.setSelected(false);
            }
        } catch (Exception e) {
            jRadioButton11.setSelected(false);
            jRadioButton12.setSelected(false);
        }

        if (EMPRESA.getConfiguracao().getTipoCusteio() == null
                ? true : EMPRESA.getConfiguracao().getTipoCusteio() == 0) {
            jCheckBox21.setSelected(false);
        } else {
            jCheckBox21.setSelected(true);
        }

        try {
            if (EMPRESA.getConfiguracao().getDescontoMaximoGrupo() == null
                    ? true : EMPRESA.getConfiguracao().getDescontoMaximoGrupo() == 0) {
                jCheckBox17.setSelected(false);
            } else {
                jCheckBox17.setSelected(true);
                HashMap filtro = new HashMap();
                filtro.put("desc", new BigDecimal(0.00));
                List<GupoProduto> listGrupo = new Controller().ControllerFindByValueMaximo(GupoProduto.class, filtro);
                for (int i = 0; i < listGrupo.size(); i++) {
                    setValueTableDescontoGrupo(listGrupo.get(i));
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(JIFEmpresa.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (int i = 0; i < EMPRESA.getAliquotaSimplesNacionalList().size(); i++) {
            modelTableSimplesNacional.setNumRows(jTable6.getRowCount() + 1);
            jTable6.setModel(modelTableSimplesNacional);
            try {
                jTable6.setValueAt(EMPRESA.getAliquotaSimplesNacionalList().get(i).getImposto(), jTable6.getRowCount() - 1, 0);
            } catch (Exception e) {
            }
            try {
                jTable6.setValueAt(EMPRESA.getAliquotaSimplesNacionalList().get(i).getValor().toString(), jTable6.getRowCount() - 1, 1);
            } catch (Exception e) {
            }
            try {
                jTable6.setValueAt(String.valueOf(EMPRESA.getAliquotaSimplesNacionalList().get(i).getTipo()), jTable6.getRowCount() - 1, 2);
            } catch (Exception e) {
            }
            try {
                jTable6.setValueAt(EMPRESA.getAliquotaSimplesNacionalList().get(i), jTable6.getRowCount() - 1, 3);
            } catch (Exception e) {
            }
        }

        for (int i = 0; i < EMPRESA.getTipoPagamentoBoleto().size(); i++) {
            modelTableFormaPagamento.setNumRows(jTable1.getRowCount() + 1);
            jTable1.setModel(modelTableFormaPagamento);
            jTable1.setValueAt(EMPRESA.getTipoPagamentoBoleto().get(i).getDescricaoTipoPagamento(), jTable1.getRowCount() - 1, 0);
        }

        for (int i = 0; i < EMPRESA.getTipoPagamentoAvistaList().size(); i++) {
            modelTableFormaPagamentoAvista.setNumRows(jTable5.getRowCount() + 1);
            jTable5.setModel(modelTableFormaPagamentoAvista);
            try {
                jTable5.setValueAt(EMPRESA.getTipoPagamentoAvistaList().get(i), jTable5.getRowCount() - 1, 0);
            } catch (ArrayIndexOutOfBoundsException a) {
            }
        }

        for (int i = 0; i < EMPRESA.getTipoPagamentoPromissoriaList().size(); i++) {
            modelTableFormaPagamento2.setNumRows(jTable4.getRowCount() + 1);
            jTable4.setModel(modelTableFormaPagamento2);
            jTable4.setValueAt(EMPRESA.getTipoPagamentoPromissoriaList().get(i).getTipoPagamento(), jTable4.getRowCount() - 1, 0);
        }

        for (int i = 0; i < EMPRESA.getTipoPagamentoCartaoList().size(); i++) {
            modelTableFormaPagamento3.setNumRows(jTable3.getRowCount() + 1);
            jTable3.setModel(modelTableFormaPagamento3);
            jTable3.setValueAt(EMPRESA.getTipoPagamentoCartaoList().get(i).getTipoPagamento(), jTable3.getRowCount() - 1, 0);
            jTable3.setValueAt(EMPRESA.getTipoPagamentoCartaoList().get(i).getTipo(), jTable3.getRowCount() - 1, 1);
            if (EMPRESA.getTipoPagamentoCartaoList().get(i).getTipo().equals("Dia Fixo")) {
                jTable3.setValueAt(EMPRESA.getTipoPagamentoCartaoList().get(i).getDiaFixo(), jTable3.getRowCount() - 1, 2);
            } else if (EMPRESA.getTipoPagamentoCartaoList().get(i).getTipo().equals("Intervalo de dias")) {
                jTable3.setValueAt(EMPRESA.getTipoPagamentoCartaoList().get(i).getQtdDia(), jTable3.getRowCount() - 1, 2);
            }
            jTable3.setValueAt(
                    EMPRESA.getTipoPagamentoCartaoList().get(i).getRecebimentoPacelado() == 0 ? "Parcelado" : "A vista",
                    jTable3.getRowCount() - 1, 3
            );
            jTable3.setValueAt(
                    EMPRESA.getTipoPagamentoCartaoList().get(i),
                    jTable3.getRowCount() - 1, 4
            );

        }

        homologacaoProducao();

        if (ConsultaDescontoMaximo()) {
            SetDescontoMaximo();

        }
    }

    public void homologacaoProducao() {
        try {
            if (EMPRESA.getTpEmissao() == 0) {
                jTabbedPane2.setEnabledAt(1, false);
                jTabbedPane2.setEnabledAt(0, true);
                jTabbedPane2.setSelectedIndex(0);
            } else {
                jTabbedPane2.setEnabledAt(1, true);
                jTabbedPane2.setEnabledAt(0, false);
                jTabbedPane2.setSelectedIndex(1);
            }
            
            Pardigital pardigital = new Controller().ControllerFind(Pardigital.class, EMPRESA.getTpEmissao() == 0 ? 2 : 1);
            if (pardigital.getCodigo() == 2) {
                try {
                    jTextField53.setText(pardigital.getUltimanf65());
                } catch (Exception e) {
                }
                try {
                    jTextField52.setText(pardigital.getUltimanf55());
                } catch (Exception e) {
                }
                try {
                    jTextField22.setText(pardigital.getSerie55());
                } catch (Exception e) {
                }
                try {
                    jTextField23.setText(pardigital.getSerie65());
                } catch (Exception e) {
                }
                try {
                    jTextField24.setText(pardigital.getCsc());
                } catch (Exception e) {
                }
            } else {
                try {
                    jTextField31.setText(pardigital.getUltimanf65());
                } catch (Exception e) {
                }
                try {
                    jTextField30.setText(pardigital.getUltimanf55());
                } catch (Exception e) {
                }
                try {
                    jTextField25.setText(pardigital.getSerie55());
                } catch (Exception e) {
                }
                try {
                    jTextField26.setText(pardigital.getSerie65());
                } catch (Exception e) {
                }
                try {
                    jTextField27.setText(pardigital.getCsc());
                } catch (Exception e) {
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(JIFEmpresa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void centralizar() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    }

    public void abreCampos() {

        situacaoTributaria(!jTextField21.getText().equals("1"));

        AbrirCamposOpcartao();
        AbrirCamposOpcartao2();
        jRadioButton3.setEnabled(true);
        jRadioButton4.setEnabled(true);

        if (jCheckBox18.isSelected()) {
            AbrirCamposDescontoMaximo();
        }

        if (jCheckBox17.isSelected()) {
            AbrirCamposDescontoMaximoProduto();
        }

        if (jCheckBox1.isSelected()) {
            AbrirCamposPromissoria();
        }

        if (jCheckBox16.isSelected()) {
            jRadioButton9.setEnabled(true);
            jRadioButton10.setEnabled(true);
        } else {
            jRadioButton9.setEnabled(false);
            jRadioButton10.setEnabled(false);
        }

        if (jCheckBox1.isSelected()) {
            AbrirCamposBoleto();
        }

        if (jCheckBox13.isSelected()) {
            AbrirCamposPromissoria();
        }

        jCheckBox20.setEnabled(true);
        jTable6.setEnabled(true);
        jTable5.setEnabled(true);
        jTable1.setEnabled(true);
        jTable4.setEnabled(true);

        jRadioButton11.setEnabled(true);
        jRadioButton12.setEnabled(true);

        jCheckBox21.setEnabled(true);
        jTable2.setEnabled(true);
        jCheckBox18.setEnabled(true);
        jCheckBox17.setEnabled(true);

        jCheckBox14.setEnabled(true);

        switch (jComboBox4.getSelectedItem().toString()) {
            case "Varejista em geral":
                jCheckBox15.setEnabled(true);
                jCheckBox16.setEnabled(true);
                break;
            case "Mercado, Supermercado, Hipermercado":
                jCheckBox15.setEnabled(true);
                jCheckBox16.setEnabled(false);
                break;
            case "Autopeças e Oficinas":
                jCheckBox16.setEnabled(true);
                jCheckBox15.setEnabled(false);
                break;
            default:
                jCheckBox15.setEnabled(false);
                jCheckBox16.setEnabled(false);
                break;
        }

        jButton6.setEnabled(true);
        jButton8.setEnabled(true);
        jButton11.setEnabled(true);
        jTextField22.setEnabled(true);
        jTextField23.setEnabled(true);
        jTextField24.setEnabled(true);
        jTextField25.setEnabled(true);
        jTextField26.setEnabled(true);
        jTextField27.setEnabled(true);
        jTextField53.setEnabled(true);
        jTextField52.setEnabled(true);
        jTextField30.setEnabled(true);
        jTextField31.setEnabled(true);

        jComboBox9.setEnabled(true);
        jComboBox4.setEnabled(true);
        //jComboBox8.setEnabled(true);
        jRadioButton1.setEnabled(true);
        jRadioButton2.setEnabled(true);
        //jComboBox6.setEnabled(true);
        jButton3.setEnabled(true);
        jButton5.setEnabled(true);

        jCheckBox13.setEnabled(true);
        jComboBox7.setEnabled(true);
        jButton4.setEnabled(true);
        jTable4.setEnabled(true);
        jTextField_razao_social1.setEnabled(true);
        jTextField_nome_fantazia1.setEnabled(true);

        jTextField7.setEnabled(true);
        jTextField_endereco.setEnabled(true);
        jTextField_numero_endereco1.setEnabled(true);
        jTextField8.setEnabled(true);
        jTextField9.setEnabled(true);
        jComboBox1.setEnabled(true);
        jTextField14.setEnabled(true);
        jTextField13.setEnabled(true);
        jTextField12.setEnabled(true);
        jRadioButton1.setEnabled(true);
        jRadioButton2.setEnabled(true);
        jCheckBox1.setEnabled(true);
        jComboBox10.setEnabled(true);
        jTextField35.setEnabled(true);
        jTextField36.setEnabled(true);
        jComboBox2.setEnabled(true);
        jTextField35.setEnabled(true);
        jTextField36.setEnabled(true);
        jTextField37.setEnabled(true);
        jPasswordField1.setEnabled(true);
        jPasswordField2.setEnabled(true);

        jComboBox5.setEnabled(true);
        jTextField32.setEnabled(true);
        jTextField33.setEnabled(true);
        jButton2.setEnabled(true);
        jTextField38.setEnabled(true);
        jTextField39.setEnabled(true);
        jTextField40.setEnabled(true);
        jTextField41.setEnabled(true);
        jTextField42.setEnabled(true);
        jTextField43.setEnabled(true);
        jTextField44.setEnabled(true);
        jTextField45.setEnabled(true);
        jTextField46.setEnabled(true);
        jTextField47.setEnabled(true);
        jTextField48.setEnabled(true);
        jTextField49.setEnabled(true);
        jTextField50.setEnabled(true);
        //jTable3.setEnabled(true);
    }

    public void fechaCampos() {
        situacaoTributaria(false);
        jRadioButton3.setEnabled(false);
        jRadioButton4.setEnabled(false);
        jCheckBox18.setEnabled(false);
        FecharCamposDescontoMaximo();
        FecharCamposDescontoMaximoGrupo();
        FecharCamposPromissoria();
        FecharCamposBoleto();
        FecharCamposOpcartao();
        FecharCamposOpcartao2();

        jTable6.setEnabled(false);
        jCheckBox20.setEnabled(false);
        jTable5.setEnabled(false);
        jTable1.setEnabled(false);
        jTable4.setEnabled(false);
        jButton6.setEnabled(false);
        jButton8.setEnabled(false);
        jButton11.setEnabled(false);
        jRadioButton11.setEnabled(false);
        jRadioButton12.setEnabled(false);

        jCheckBox21.setEnabled(false);
        jComboBox4.setEnabled(false);
        jRadioButton9.setEnabled(false);
        jRadioButton10.setEnabled(false);
        jTable2.setEnabled(false);
        jCheckBox17.setEnabled(false);

        //jCheckBox14.setEnabled(false);
        jCheckBox15.setEnabled(false);
        jCheckBox16.setEnabled(false);

        jTextField22.setEnabled(false);
        jTextField23.setEnabled(false);
        jTextField24.setEnabled(false);
        jTextField25.setEnabled(false);
        jTextField26.setEnabled(false);
        jTextField27.setEnabled(false);
        jTextField53.setEnabled(false);
        jTextField52.setEnabled(false);
        jTextField30.setEnabled(false);
        jTextField31.setEnabled(false);

        jCheckBox6.setEnabled(false);
        jCheckBox4.setEnabled(false);
        jCheckBox9.setEnabled(false);

        ///jComboBox8.setEnabled(false);
        jRadioButton1.setEnabled(false);
        jRadioButton2.setEnabled(false);
        //jSpinner1.setEnabled(false);
        //jComboBox6.setEnabled(false);
        jButton3.setEnabled(false);
        jButton5.setEnabled(false);

        //jTable3.setEnabled(false);
        jRadioButton7.setEnabled(false);
        jRadioButton8.setEnabled(false);
        jComboBox5.setEnabled(false);
        jComboBox2.setEnabled(false);
        jTextField32.setEnabled(false);
        jTextField33.setEnabled(false);
        jButton2.setEnabled(false);
        jTable2.setEnabled(false);
        jComboBox6.setEnabled(false);

        jCheckBox1.setEnabled(false);

        jTable1.setEnabled(false);

        jCheckBox13.setEnabled(false);
        jCheckBox7.setEnabled(false);
        jButton4.setEnabled(false);
        jTable4.setEnabled(false);

        jTextField1.setEnabled(false);
        jTextField_razao_social1.setEnabled(false);
        jTextField_nome_fantazia1.setEnabled(false);
        jTextField7.setEnabled(false);
        jTextField_endereco.setEnabled(false);
        jTextField_numero_endereco1.setEnabled(false);
        jTextField8.setEnabled(false);
        jTextField9.setEnabled(false);
        jTextField2.setEnabled(false);
        jDateChooser_data_cadastro1.setEnabled(false);
        jComboBox1.setEnabled(false);
        jTextField14.setEnabled(false);
        jTextField13.setEnabled(false);
        jTextField12.setEnabled(false);
        jRadioButton1.setEnabled(false);
        jRadioButton2.setEnabled(false);
        jComboBox10.setEnabled(false);
        jTextField35.setEnabled(false);
        jTextField36.setEnabled(false);
        jTextField35.setEnabled(false);
        jTextField36.setEnabled(false);
        jTextField37.setEnabled(false);
        jPasswordField1.setEnabled(false);
        jPasswordField2.setEnabled(false);

        jTextField38.setEnabled(false);
        jTextField39.setEnabled(false);
        jTextField40.setEnabled(false);
        jTextField41.setEnabled(false);
        jTextField42.setEnabled(false);
        jTextField43.setEnabled(false);
        jTextField44.setEnabled(false);
        jTextField45.setEnabled(false);
        jTextField46.setEnabled(false);
        jTextField47.setEnabled(false);
        jTextField48.setEnabled(false);
        jTextField49.setEnabled(false);
        jTextField50.setEnabled(false);

    }

    //int cancelar = 0;

    public void consulta(int codigo) {
        try {
            HashMap filtro = new HashMap();
            filtro.put("codigo", codigo);
            List<CidadeCodigo> codcidadeList = new Controller().ControllerFindByCodId(CidadeCodigo.class, filtro);
            setTextCidade(codcidadeList == null ? null
                    : !codcidadeList.isEmpty() ? codcidadeList.get(0) : null);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(JIFEmpresa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setTextCidade(CidadeCodigo codcidade) {
        if (codcidade != null) {
            jTextField9.setText(codcidade.getCodigo() != null ? String.valueOf(codcidade.getCodigo()) : "");
            jTextField.setText(codcidade.getNome() != null ? codcidade.getNome() : "");
            jTextField2.setText(codcidade.getCodigoUf() != null ? codcidade.getCodigoUf().toString() : "");
            jTextField3.setText(codcidade.getUf() != null ? codcidade.getUf() : "");
            jTextField11.setText(codcidade.getCodigoPais() != null ? codcidade.getCodigoPais().toString() : "");
        } else {
            jTextField9.setText("");
            jTextField.setText("");
            jTextField2.setText("");
            jTextField3.setText("");
            jTextField11.setText("");
        }
    }

    public void buscaBanco(ContaBancaria contaBancaria) {

        if (contaBancaria != null) {
            jTextField16.setText(String.valueOf(contaBancaria.getContaBanco()));
            jTextField17.setText(String.valueOf(contaBancaria.getDigitoConta()));
            jTextField19.setText(String.valueOf(contaBancaria.getAgenciaBanco()));
            jTextField18.setText(String.valueOf(contaBancaria.getDigitoAgencia()));
            jTextField20.setText(String.valueOf(contaBancaria.getNomeBanco()));
        } else {
            jTextField16.setText("");
            jTextField17.setText("");
            jTextField19.setText("");
            jTextField18.setText("");
            jTextField20.setText("");
        }

    }

    public void formatarTabelaDesconto() {

        if (jTable7.getColumnModel().getColumnCount() > 0) {
            jTable7.getColumnModel().getColumn(0).setMinWidth(350);
            jTable7.getColumnModel().getColumn(0).setPreferredWidth(350);
            jTable7.getColumnModel().getColumn(0).setMaxWidth(350);

            jTable7.getColumnModel().getColumn(1).setMinWidth(100);
            jTable7.getColumnModel().getColumn(1).setPreferredWidth(100);
            jTable7.getColumnModel().getColumn(1).setMaxWidth(100);

            jTable7.getColumnModel().getColumn(2).setMinWidth(0);
            jTable7.getColumnModel().getColumn(2).setPreferredWidth(0);
            jTable7.getColumnModel().getColumn(2).setMaxWidth(0);
        }
    }

    public void SetDescontoMaximo() {
        if (EMPRESA.getConfiguracao().getDescontoMaximoVendedor() != null
                ? EMPRESA.getConfiguracao().getDescontoMaximoVendedor().compareTo(BigDecimal.ZERO) != 0 : false) {
            jMoneyField2.setText(EMPRESA.getConfiguracao().getDescontoMaximoVendedor().toString());
            jCheckBox18.setSelected(true);
            if (!jMoneyField2.getText().equals("0,00")) {
                jLabel72.setVisible(true);
            }
        }
    }

    public void CriaConfiguracaoTaxaCartao() {
        try {
            if (jTable3.getSelectedRow() > -1) {
                if (jTextField33.getText().equals("0,00")) {
                    JOptionPane.showMessageDialog(this, "O valor informado é inválido.", "", 0);
                } else {
                    if (contem4()) {
                        bd.DAO.TipoPagamento tipoPagamento
                                = (bd.DAO.TipoPagamento) jTable3.getValueAt(jTable3.getSelectedRow(), 0);

                        ConfigTaxaCartao cartao = new ConfigTaxaCartao();
                        try {
                            cartao.setDescricao(jTextField32.getText().toUpperCase());
                        } catch (Exception ex) {
                        }
                        try {
                            cartao.setTipoIncidencia(jComboBox5.getSelectedIndex());
                        } catch (Exception ex) {
                        }
                        try {
                            cartao.setTipoPagamento(tipoPagamento);
                        } catch (Exception ex) {
                        }
                        try {
                            cartao.setValor(new BigDecimal(jTextField33.getText().replace(",", ".")));
                        } catch (Exception ex) {
                        }
                        try {
                            cartao.setAPrazo(jCheckBox19.isSelected() ? 1 : 0);
                        } catch (Exception ex) {
                        }

                        cartao = new Controller().ControllerPersistMerge(ConfigTaxaCartao.class, cartao);
                        
                        EMPRESA.getTipoPagamentoCartaoList().get(jTable3.getSelectedRow())
                            .getTipoPagamento().getConfigTaxaCartaoList().add(cartao);
                        
                        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
                        model.setNumRows(jTable2.getRowCount() + 1);
                        jTable2.setModel(model);

                        try {
                            jTable2.setValueAt(
                                    jCheckBox19.isSelected() ? "A prazo" : "A vista",
                                    jTable2.getRowCount() - 1, 0);
                        } catch (Exception ex) {
                        }

                        try {
                            jTable2.setValueAt(
                                    jComboBox5.getModel().getElementAt(jComboBox5.getSelectedIndex()),
                                    jTable2.getRowCount() - 1, 1);
                        } catch (Exception ex) {
                        }

                        try {
                            jTable2.setValueAt(jTextField32.getText(), jTable2.getRowCount() - 1, 2);
                        } catch (Exception ex) {
                        }

                        try {
                            JMoneyField field = new JMoneyField();
                            field.setText(jTextField33.getText());
                            jTable2.setValueAt(field.getText(), jTable2.getRowCount() - 1, 3);
                        } catch (Exception ex) {
                        }

                        try {
                            jTable2.setValueAt(cartao.getId(), jTable2.getRowCount() - 1, 5);
                        } catch (Exception ex) {
                        }
                    } else {
                        StringBuilder builder = new StringBuilder();
                        builder.append("Já existe uma configuração para modalidade ");
                        builder.append(jCheckBox19.isSelected() ? "A prazo" : "A vista");
                        JOptionPane.showMessageDialog(this, builder.toString(), "", 0);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Selecione uma forma de pagamento na tabela", "", 0);
            }

        } catch (Exception ex) {
            Logger.getLogger(JIFEmpresa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        codigoProdutoDANFE = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        jPopupMenu_remove_promossoria = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        Remove1 = new javax.swing.JPopupMenu();
        Remov1 = new javax.swing.JMenuItem();
        Remove2 = new javax.swing.JPopupMenu();
        Remov2 = new javax.swing.JMenuItem();
        jPanel7 = new javax.swing.JPanel();
        refreshButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jTextField_nome_fantazia1 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel_ie1 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel_cnpj1 = new javax.swing.JLabel();
        jTextField_endereco = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jTextField_razao_social1 = new javax.swing.JTextField();
        jTextField_numero_endereco1 = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jTextField9 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextField21 = new javax.swing.JTextField();
        jDateChooser_data_cadastro1 = new com.toedter.calendar.JDateChooser();
        jPanel8 = new javax.swing.JPanel();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel11 = new javax.swing.JPanel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jLabel34 = new javax.swing.JLabel();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        jLabel35 = new javax.swing.JLabel();
        jCheckBox8 = new javax.swing.JCheckBox();
        jCheckBox9 = new javax.swing.JCheckBox();
        jCheckBox10 = new javax.swing.JCheckBox();
        jCheckBox11 = new javax.swing.JCheckBox();
        jCheckBox12 = new javax.swing.JCheckBox();
        jSeparator3 = new javax.swing.JSeparator();
        jCheckBox15 = new javax.swing.JCheckBox();
        jCheckBox16 = new javax.swing.JCheckBox();
        jPanel29 = new javax.swing.JPanel();
        jRadioButton9 = new javax.swing.JRadioButton();
        jRadioButton10 = new javax.swing.JRadioButton();
        jLabel41 = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        jRadioButton11 = new javax.swing.JRadioButton();
        jRadioButton12 = new javax.swing.JRadioButton();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jCheckBox20 = new javax.swing.JCheckBox();
        jCheckBox21 = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jTextField22 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jTextField23 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jTextField24 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jTextField52 = new javax.swing.JTextField();
        jTextField53 = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jTextField25 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jTextField26 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jTextField27 = new javax.swing.JTextField();
        jLabel73 = new javax.swing.JLabel();
        jTextField30 = new javax.swing.JTextField();
        jTextField31 = new javax.swing.JTextField();
        jLabel74 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jComboBox10 = new javax.swing.JComboBox<>();
        jLabel45 = new javax.swing.JLabel();
        jTextField35 = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        jTextField36 = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        jTextField37 = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel49 = new javax.swing.JLabel();
        jPasswordField2 = new javax.swing.JPasswordField();
        jPanel1 = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jPanel9 = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel25 = new javax.swing.JPanel();
        jTabbedPane6 = new javax.swing.JTabbedPane();
        jPanel27 = new javax.swing.JPanel();
        jCheckBox17 = new javax.swing.JCheckBox();
        jPanel26 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable7 = new javax.swing.JTable();
        jComboBox12 = new javax.swing.JComboBox<>();
        jButton9 = new javax.swing.JButton();
        jMoneyField1 = new ClassesEntidades.JMoneyField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        jPanel28 = new javax.swing.JPanel();
        jLabel68 = new javax.swing.JLabel();
        jMoneyField2 = new ClassesEntidades.JMoneyField();
        jButton10 = new javax.swing.JButton();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jCheckBox18 = new javax.swing.JCheckBox();
        jLabel72 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jComboBox9 = new javax.swing.JComboBox<>();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jTextField15 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextField16 = new javax.swing.JTextField();
        jTextField17 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextField18 = new javax.swing.JTextField();
        jTextField19 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextField20 = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jPanel13 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jComboBox7 = new javax.swing.JComboBox<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jCheckBox13 = new javax.swing.JCheckBox();
        jPanel12 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jTextField32 = new javax.swing.JTextField();
        jComboBox5 = new javax.swing.JComboBox<>();
        jLabel36 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel38 = new javax.swing.JLabel();
        jRadioButton8 = new javax.swing.JRadioButton();
        jLabel39 = new javax.swing.JLabel();
        jRadioButton7 = new javax.swing.JRadioButton();
        jTextField33 = new JMoneyField();
        jCheckBox19 = new javax.swing.JCheckBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jComboBox6 = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jLabel42 = new javax.swing.JLabel();
        jComboBox8 = new javax.swing.JComboBox<>();
        jCheckBox14 = new javax.swing.JCheckBox();
        jSpinner1 = new javax.swing.JSpinner();
        jPanel18 = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        jTextField38 = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        jTextField39 = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jTextField40 = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        jTextField41 = new javax.swing.JTextField();
        jLabel57 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jTextField42 = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        jTextField43 = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        jTextField44 = new javax.swing.JTextField();
        jTextField45 = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jTextField46 = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        jTextField47 = new javax.swing.JTextField();
        jLabel63 = new javax.swing.JLabel();
        jTextField48 = new javax.swing.JTextField();
        jLabel64 = new javax.swing.JLabel();
        jTextField49 = new javax.swing.JTextField();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jTextField50 = new javax.swing.JTextField();
        jTextField51 = new javax.swing.JTextField();
        jPanel19 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jButton8 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jPanel20 = new javax.swing.JPanel();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        jPanel21 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jPanel22 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();

        jMenuItem1.setText("Remover forma de pagamento");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu_remove_promossoria.add(jMenuItem1);

        jMenuItem2.setText("Remover");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem2);

        jMenuItem3.setText("Remover");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jPopupMenu2.add(jMenuItem3);

        Remov1.setText("Remover forma de pagamento");
        Remov1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Remov1ActionPerformed(evt);
            }
        });
        Remove1.add(Remov1);

        Remov2.setText("Remover forma de pagamento");
        Remov2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Remov2ActionPerformed(evt);
            }
        });
        Remove2.add(Remov2);

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastro de Empresas");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/img/parametrizar.gif"))); // NOI18N
        setVisible(true);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        refreshButton.setText("Editar");
        refreshButton.setFocusable(false);
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        saveButton.setText("Gravar");
        saveButton.setEnabled(false);
        saveButton.setFocusable(false);
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(refreshButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(refreshButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jTextField_nome_fantazia1.setDoubleBuffered(true);
        jTextField_nome_fantazia1.setEnabled(false);
        jTextField_nome_fantazia1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_nome_fantazia1ActionPerformed(evt);
            }
        });

        jLabel14.setText("Data do Cad.:");

        jLabel_ie1.setText("IE:");
        jLabel_ie1.setPreferredSize(new java.awt.Dimension(18, 14));

        jLabel22.setText("Razão social:");

        jLabel28.setText("Nome Fantazia:");

        jLabel_cnpj1.setText("CNPJ:");

        jTextField_endereco.setDoubleBuffered(true);
        jTextField_endereco.setEnabled(false);
        jTextField_endereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_enderecoActionPerformed(evt);
            }
        });

        jLabel17.setText("Código:");

        jLabel15.setText("Nº:");

        jLabel29.setText("CEP:");

        jLabel30.setText("Endereço:");

        jLabel31.setText("Bairro:");

        jTextField_razao_social1.setDoubleBuffered(true);
        jTextField_razao_social1.setEnabled(false);
        jTextField_razao_social1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_razao_social1ActionPerformed(evt);
            }
        });

        jTextField_numero_endereco1.setDoubleBuffered(true);
        jTextField_numero_endereco1.setEnabled(false);
        jTextField_numero_endereco1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_numero_endereco1ActionPerformed(evt);
            }
        });

        jLabel33.setText("Cidade:");

        jTextField1.setBackground(new java.awt.Color(255, 255, 204));
        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField1.setEnabled(false);

        jTextField4.setEnabled(false);

        jTextField5.setEnabled(false);
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jLabel1.setText("IM:");

        jTextField6.setEnabled(false);
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jTextField7.setEnabled(false);

        jTextField8.setEnabled(false);

        jLabel2.setText("UF:");

        jTextField.setBackground(new java.awt.Color(255, 255, 204));
        jTextField.setEnabled(false);
        jTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldActionPerformed(evt);
            }
        });

        jTextField2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField2.setEnabled(false);
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel3.setText("Enquadramento:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Micro empresa - ME", "Empresa de pequeno porte - EPP", "Empresa normal" }));
        jComboBox1.setEnabled(false);
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        jLabel4.setText("Tipo tributário:");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Simples nacional", "Lucro presumido", "Lucro real" }));
        jComboBox2.setEnabled(false);
        jComboBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox2ItemStateChanged(evt);
            }
        });

        jTextField9.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField9.setEnabled(false);
        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });
        jTextField9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField9KeyPressed(evt);
            }
        });

        jTextField3.setBackground(new java.awt.Color(255, 255, 204));
        jTextField3.setEnabled(false);

        jLabel5.setText("Pais:");

        jTextField10.setBackground(new java.awt.Color(255, 255, 204));
        jTextField10.setEnabled(false);

        jTextField11.setEnabled(false);

        jLabel6.setText("Complemento:");

        jTextField12.setEnabled(false);

        jLabel7.setText("Tel:");

        jTextField13.setEnabled(false);

        jLabel8.setText("E-mail:");

        jTextField14.setEnabled(false);

        jLabel13.setText("CRT :");

        jTextField21.setEnabled(false);

        jDateChooser_data_cadastro1.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(jDateChooser_data_cadastro1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel31)
                                    .addGap(53, 53, 53))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel33)
                                    .addGap(35, 35, 35)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(67, 67, 67)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(48, 48, 48)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel22)
                                .addGap(4, 4, 4)
                                .addComponent(jTextField_razao_social1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel28)
                                .addGap(10, 10, 10)
                                .addComponent(jTextField_nome_fantazia1, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel_cnpj1)
                                .addGap(56, 56, 56)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(jLabel_ie1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1)
                                .addGap(6, 6, 6)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel29)
                                .addGap(62, 62, 62)
                                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel30)
                                .addGap(4, 4, 4)
                                .addComponent(jTextField_endereco, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(jLabel15)
                                .addGap(4, 4, 4)
                                .addComponent(jTextField_numero_endereco1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(4, 4, 4)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(334, 334, 334)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(20, 20, 20))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jLabel3)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel4))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_razao_social1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel22))))
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel28))
                    .addComponent(jTextField_nome_fantazia1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_cnpj1)
                            .addComponent(jLabel_ie1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))))
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_endereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_numero_endereco1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel29)
                            .addComponent(jLabel15))))
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel31)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel33))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)
                        .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5))
                    .addComponent(jDateChooser_data_cadastro1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(148, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Configurar Empresa", jPanel3);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jTabbedPane4.setForeground(new java.awt.Color(204, 0, 0));
        jTabbedPane4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mercado, Supermercado, Hipermercado", "Farmacias, Drogarias, Perfumaria", "Autopeças e Oficinas", "Atacadista", "Bares, Restaurantes, Lanchonete", "Varejista em geral" }));
        jComboBox4.setEnabled(false);
        jComboBox4.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox4ItemStateChanged(evt);
            }
        });

        jLabel34.setText("Atividade comercial:");

        jCheckBox2.setSelected(true);
        jCheckBox2.setText("Controle de Estoque e Administração");
        jCheckBox2.setEnabled(false);
        jCheckBox2.setOpaque(false);

        jCheckBox3.setSelected(true);
        jCheckBox3.setText("PDV - NFC-e ");
        jCheckBox3.setEnabled(false);
        jCheckBox3.setOpaque(false);

        jCheckBox4.setSelected(true);
        jCheckBox4.setText("Terminal de Venda");
        jCheckBox4.setEnabled(false);
        jCheckBox4.setOpaque(false);

        jCheckBox5.setSelected(true);
        jCheckBox5.setText("Contas a Pagar");
        jCheckBox5.setEnabled(false);
        jCheckBox5.setOpaque(false);

        jCheckBox6.setSelected(true);
        jCheckBox6.setText("Contas a Receber");
        jCheckBox6.setEnabled(false);
        jCheckBox6.setOpaque(false);

        jCheckBox7.setSelected(true);
        jCheckBox7.setText("PDV - Não Fiscal");
        jCheckBox7.setEnabled(false);
        jCheckBox7.setOpaque(false);

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("Funções");

        jCheckBox8.setSelected(true);
        jCheckBox8.setText("SNGPC - Sistema Nacional de Gerenciamento de Produtos Controlados");
        jCheckBox8.setEnabled(false);
        jCheckBox8.setOpaque(false);

        jCheckBox9.setSelected(true);
        jCheckBox9.setText("SINTEGRA");
        jCheckBox9.setEnabled(false);
        jCheckBox9.setOpaque(false);

        jCheckBox10.setSelected(true);
        jCheckBox10.setText("SPED Fiscal");
        jCheckBox10.setEnabled(false);
        jCheckBox10.setOpaque(false);

        jCheckBox11.setSelected(true);
        jCheckBox11.setText("ECF - Escrituração Contábil Fiscal");
        jCheckBox11.setEnabled(false);
        jCheckBox11.setOpaque(false);

        jCheckBox12.setSelected(true);
        jCheckBox12.setText("Bloco K");
        jCheckBox12.setEnabled(false);
        jCheckBox12.setOpaque(false);

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jCheckBox15.setText("Venda de Gás GLP");
        jCheckBox15.setEnabled(false);
        jCheckBox15.setOpaque(false);

        jCheckBox16.setText("Prestador de serviço");
        jCheckBox16.setEnabled(false);
        jCheckBox16.setOpaque(false);
        jCheckBox16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCheckBox16MouseClicked(evt);
            }
        });

        jPanel29.setBackground(new java.awt.Color(255, 255, 255));
        jPanel29.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Controlar estoque com pedido NÃO FATURADO", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jRadioButton9.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup4.add(jRadioButton9);
        jRadioButton9.setText("SIM");
        jRadioButton9.setEnabled(false);

        jRadioButton10.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup4.add(jRadioButton10);
        jRadioButton10.setText("NÃO");
        jRadioButton10.setEnabled(false);

        jLabel41.setForeground(new java.awt.Color(153, 0, 0));
        jLabel41.setText("<html>Controla estoque com pedido não FATURADO<br> se existir serviço no pedido</html>");

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jRadioButton10, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                            .addComponent(jRadioButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel29Layout.createSequentialGroup()
                .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton10)
                .addContainerGap())
        );

        jPanel30.setBackground(new java.awt.Color(255, 255, 255));
        jPanel30.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Modelos de comissionamento", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jRadioButton11.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup5.add(jRadioButton11);
        jRadioButton11.setEnabled(false);

        jRadioButton12.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup5.add(jRadioButton12);
        jRadioButton12.setEnabled(false);

        jLabel75.setText("Comissão única aplicada a todos os");
        jLabel75.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel75.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jLabel75.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel75MouseClicked(evt);
            }
        });

        jLabel76.setText("PRODUTOS");
        jLabel76.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel76.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jLabel76.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel76MouseClicked(evt);
            }
        });

        jLabel77.setText("Comissão variável, aplicada por");
        jLabel77.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel77MouseClicked(evt);
            }
        });

        jLabel78.setText("GRUPOS DE PRODUTOS");
        jLabel78.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel78.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jLabel78.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel78MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addComponent(jRadioButton12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel77, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel78, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addComponent(jRadioButton11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel30Layout.createSequentialGroup()
                                .addComponent(jLabel76, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                            .addComponent(jLabel75, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel76, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jRadioButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addComponent(jLabel77)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jRadioButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jCheckBox20.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox20.setText("Calculadora de comissão");
        jCheckBox20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCheckBox20MouseClicked(evt);
            }
        });

        jCheckBox21.setText("Aplicar Custo médio na entrada");
        jCheckBox21.setEnabled(false);
        jCheckBox21.setOpaque(false);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox8)
                            .addComponent(jCheckBox9)
                            .addComponent(jCheckBox10)
                            .addComponent(jCheckBox11)
                            .addComponent(jCheckBox12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox20, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel11Layout.createSequentialGroup()
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jCheckBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jCheckBox2)
                                .addComponent(jCheckBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jCheckBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jCheckBox7, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jCheckBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(71, 71, 71)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jCheckBox16, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel11Layout.createSequentialGroup()
                                    .addComponent(jCheckBox15)
                                    .addGap(18, 18, 18)
                                    .addComponent(jCheckBox21, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(119, 119, 119)))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel34)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jCheckBox2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox6))
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox15)
                            .addComponent(jCheckBox21))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jCheckBox8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox12))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jCheckBox20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jTabbedPane4.addTab("Confiança Sistemas Comercial", jPanel11);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 621, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane4.getAccessibleContext().setAccessibleName("");

        jTabbedPane1.addTab("Software", jPanel8);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel16.setText("Série NF-e:");

        jTextField22.setEnabled(false);
        jTextField22.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField22FocusLost(evt);
            }
        });
        jTextField22.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField22KeyReleased(evt);
            }
        });

        jLabel18.setText("Série NFC-e:");

        jTextField23.setEnabled(false);
        jTextField23.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField23FocusLost(evt);
            }
        });
        jTextField23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField23ActionPerformed(evt);
            }
        });
        jTextField23.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField23KeyReleased(evt);
            }
        });

        jLabel19.setText("CSC NFC-e (65) :");

        jTextField24.setEnabled(false);
        jTextField24.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField24FocusLost(evt);
            }
        });

        jLabel24.setText("Número NF-e:");

        jLabel25.setText("Número NFC-e:");

        jTextField52.setEnabled(false);

        jTextField53.setEnabled(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(jLabel16)
                    .addComponent(jLabel18))
                .addGap(41, 41, 41)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField24)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextField23, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField22, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25)
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField52, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField53, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 163, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField52, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextField22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField23, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jTextField24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Certificado Digital - Homologação", jPanel5);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel20.setText("Série NF-e:");

        jTextField25.setEnabled(false);

        jLabel21.setText("Série NFC-e:");

        jTextField26.setEnabled(false);

        jLabel23.setText("CSC NFC-e (65) :");

        jTextField27.setEnabled(false);

        jLabel73.setText("Número NF-e:");

        jTextField30.setEnabled(false);
        jTextField30.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField30FocusLost(evt);
            }
        });

        jTextField31.setEnabled(false);
        jTextField31.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField31FocusLost(evt);
            }
        });
        jTextField31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField31ActionPerformed(evt);
            }
        });

        jLabel74.setText("Número NFC-e:");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21))
                .addGap(41, 41, 41)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField27)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField26, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField25, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel74)
                            .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextField31, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField30, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 177, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextField30, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField31, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jTextField27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Certificado Digital - Produção", jPanel6);

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "   Configurar E-MAIL   ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel44.setText("Provedor:");

        jComboBox10.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gmail", "Hotmail", "Outros" }));
        jComboBox10.setEnabled(false);
        jComboBox10.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox10ItemStateChanged(evt);
            }
        });

        jLabel45.setText("Host SMTP:");

        jTextField35.setEnabled(false);

        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel46.setText("Porta:");

        jTextField36.setEnabled(false);

        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel47.setText("E-mail:");

        jTextField37.setEnabled(false);

        jLabel48.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel48.setText("Senha:");

        jPasswordField1.setEnabled(false);

        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel49.setText("Confirmar senha:");

        jPasswordField2.setEnabled(false);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(17, 17, 17)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jComboBox10, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel45)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField35))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jTextField36, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jTextField37)
                    .addComponent(jPasswordField1)
                    .addComponent(jPasswordField2))
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(jComboBox10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel45)
                    .addComponent(jTextField35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(jTextField36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47)
                    .addComponent(jTextField37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel49)
                    .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Nota fiscal eletrônica - NF-e", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        buttonGroup3.add(jRadioButton1);
        jRadioButton1.setText("Homologação");
        jRadioButton1.setEnabled(false);
        jRadioButton1.setOpaque(false);
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup3.add(jRadioButton2);
        jRadioButton2.setText("Produção");
        jRadioButton2.setEnabled(false);
        jRadioButton2.setOpaque(false);
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jRadioButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton2)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2))
                .addGap(0, 5, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(93, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Certificado Digital / Config. E-mail", jPanel4);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        jPanel25.setBackground(new java.awt.Color(255, 255, 255));

        jPanel27.setBackground(new java.awt.Color(255, 255, 255));

        jCheckBox17.setText("Aplicar desconto maximo a grupo de produtos");
        jCheckBox17.setEnabled(false);
        jCheckBox17.setOpaque(false);
        jCheckBox17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox17ActionPerformed(evt);
            }
        });

        jPanel26.setBackground(new java.awt.Color(255, 255, 255));
        jPanel26.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(204, 204, 204), null, null));

        jTable7.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jTable7.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable7.setEnabled(false);
        jTable7.setRowHeight(20);
        jTable7.setSelectionBackground(new java.awt.Color(102, 153, 255));
        jScrollPane8.setViewportView(jTable7);

        jComboBox12.setMaximumRowCount(10);
        jComboBox12.setEnabled(false);

        jButton9.setText("Confirmar");
        jButton9.setEnabled(false);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jMoneyField1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jMoneyField1.setEnabled(false);

        jLabel26.setText("Grupo:");

        jLabel27.setText("Desconto:");

        jButton12.setText("Remover");
        jButton12.setEnabled(false);
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox12, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addComponent(jMoneyField1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton12)))
                .addContainerGap(122, Short.MAX_VALUE))
            .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel26Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26)
                    .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(0, 0, 0)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jMoneyField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9)
                    .addComponent(jButton12))
                .addContainerGap(293, Short.MAX_VALUE))
            .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                    .addContainerGap(59, Short.MAX_VALUE)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addComponent(jCheckBox17)
                        .addGap(0, 330, Short.MAX_VALUE))
                    .addComponent(jPanel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCheckBox17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane6.addTab("Desconto por grupo de produtos", jPanel27);

        jPanel28.setBackground(new java.awt.Color(255, 255, 255));

        jLabel68.setText("Desconto máximo (%):");

        jMoneyField2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jMoneyField2.setEnabled(false);
        jMoneyField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jMoneyField2KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jMoneyField2KeyReleased(evt);
            }
        });

        jButton10.setText("Confirmar");
        jButton10.setEnabled(false);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jLabel69.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(255, 0, 0));
        jLabel69.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel69.setText("Informe um valor referente ao desconto máximo possível para ser aplicado em uma venda.");

        jLabel70.setText("Obs.: Essa configuração de desconto só se aplica a produtos sem configuração de desconto. Caso o produto faça parte");

        jLabel71.setText("de uma promoção ou de um grupo que já tenha uma configuração de desconto esta configuração não funcionará.");

        jCheckBox18.setText("Configurar desconto máximo");
        jCheckBox18.setEnabled(false);
        jCheckBox18.setOpaque(false);
        jCheckBox18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox18ActionPerformed(evt);
            }
        });

        jLabel72.setForeground(new java.awt.Color(0, 153, 0));
        jLabel72.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel72.setText("Desconto configurado com sucesso!!");

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel70)
                    .addComponent(jLabel71))
                .addContainerGap())
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox18)
                    .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel68)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel72)
                            .addGroup(jPanel28Layout.createSequentialGroup()
                                .addComponent(jMoneyField2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton10)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCheckBox18)
                .addGap(88, 88, 88)
                .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel68)
                    .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jMoneyField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton10)))
                .addGap(0, 0, 0)
                .addComponent(jLabel72)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                .addComponent(jLabel70)
                .addGap(0, 0, 0)
                .addComponent(jLabel71)
                .addGap(46, 46, 46))
        );

        jTabbedPane6.addTab("Configurar desconto máximo", jPanel28);

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane6)
                .addContainerGap())
        );

        jTabbedPane3.addTab("Configuração Geral", jPanel25);

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel43.setText("Forma de pagamento que influencia na movimentação de dinheiro a vista:");

        jComboBox9.setMaximumRowCount(10);
        jComboBox9.setEnabled(false);
        jComboBox9.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox9ItemStateChanged(evt);
            }
        });

        jTable5.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable5.setComponentPopupMenu(Remove1);
        jTable5.setRowHeight(20);
        jTable5.setSelectionBackground(new java.awt.Color(102, 153, 255));
        jScrollPane6.setViewportView(jTable5);

        jButton5.setText("Confirmar");
        jButton5.setEnabled(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel43)
                            .addComponent(jComboBox9, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane3.addTab("A vista / Movimnto de caixa", jPanel16);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        jLabel32.setText("Forma de pagamento que utilizarar Boleto de cobrança:");

        jComboBox3.setMaximumRowCount(10);
        jComboBox3.setEnabled(false);
        jComboBox3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox3ItemStateChanged(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.setComponentPopupMenu(Remove2);
        jTable1.setRowHeight(20);
        jTable1.setSelectionBackground(new java.awt.Color(102, 153, 255));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Confirmar");
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Boleto Bancário", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        jLabel9.setText("Cod.:");

        jTextField15.setBackground(new java.awt.Color(255, 255, 204));
        jTextField15.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField15.setEnabled(false);
        jTextField15.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField15KeyPressed(evt);
            }
        });

        jLabel10.setText("Conta bancária DV:");

        jTextField16.setBackground(new java.awt.Color(255, 255, 204));
        jTextField16.setEnabled(false);

        jTextField17.setBackground(new java.awt.Color(255, 255, 204));
        jTextField17.setEnabled(false);

        jLabel11.setText("Agencia DV:");

        jTextField18.setBackground(new java.awt.Color(255, 255, 204));
        jTextField18.setEnabled(false);

        jTextField19.setBackground(new java.awt.Color(255, 255, 204));
        jTextField19.setEnabled(false);

        jLabel12.setText("Banco:");

        jTextField20.setBackground(new java.awt.Color(255, 255, 204));
        jTextField20.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(159, Short.MAX_VALUE)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12)
                        .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel11))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBox1.setText("Gerar Boleto Bancário");
        jCheckBox1.setOpaque(false);
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jCheckBox1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jCheckBox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane3.addTab("Boleto de Cobrança", jPanel10);

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));

        jLabel40.setText("Forma de pagamento que utilizarar Promissória de cobrança:");

        jComboBox7.setMaximumRowCount(10);
        jComboBox7.setEnabled(false);
        jComboBox7.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox7ItemStateChanged(evt);
            }
        });

        jTable4.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable4.setComponentPopupMenu(jPopupMenu_remove_promossoria);
        jTable4.setRowHeight(20);
        jTable4.setSelectionBackground(new java.awt.Color(102, 153, 255));
        jScrollPane5.setViewportView(jTable4);

        jButton4.setText("Confirmar");
        jButton4.setEnabled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jCheckBox13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBox13.setText("Gerar Promissória");
        jCheckBox13.setOpaque(false);
        jCheckBox13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jCheckBox13)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel40)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox7, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jCheckBox13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane3.addTab("Promissória", jPanel13);

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel37.setText("Selecione a incidência:");

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Taxa fixa por operação", "Taxa variável por quantidade de venda", "Taxa variável valor de venda" }));

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 0, 51));
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("Valores incidentes em operações com cartão");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Pagamento", "Incidência", "Descrição", "Valor", "tipoPagamento", "codigo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setComponentPopupMenu(jPopupMenu2);
        jTable2.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setMinWidth(100);
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(100);
            jTable2.getColumnModel().getColumn(0).setMaxWidth(100);
            jTable2.getColumnModel().getColumn(1).setMinWidth(200);
            jTable2.getColumnModel().getColumn(1).setPreferredWidth(200);
            jTable2.getColumnModel().getColumn(1).setMaxWidth(200);
            jTable2.getColumnModel().getColumn(2).setMinWidth(230);
            jTable2.getColumnModel().getColumn(2).setPreferredWidth(230);
            jTable2.getColumnModel().getColumn(2).setMaxWidth(230);
            jTable2.getColumnModel().getColumn(3).setMinWidth(100);
            jTable2.getColumnModel().getColumn(3).setPreferredWidth(100);
            jTable2.getColumnModel().getColumn(3).setMaxWidth(100);
            jTable2.getColumnModel().getColumn(4).setMinWidth(0);
            jTable2.getColumnModel().getColumn(4).setPreferredWidth(0);
            jTable2.getColumnModel().getColumn(4).setMaxWidth(0);
            jTable2.getColumnModel().getColumn(5).setMinWidth(0);
            jTable2.getColumnModel().getColumn(5).setPreferredWidth(0);
            jTable2.getColumnModel().getColumn(5).setMaxWidth(0);
        }

        jButton2.setText("Confirmar");
        jButton2.setFocusable(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel38.setText("Descrição:");

        buttonGroup2.add(jRadioButton8);
        jRadioButton8.setText("Maquina (PinPad)");
        jRadioButton8.setOpaque(false);
        jRadioButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton8ActionPerformed(evt);
            }
        });

        jLabel39.setText("Valor (%):");

        buttonGroup2.add(jRadioButton7);
        jRadioButton7.setText("TEF - Transferência Eletrônica de Fundos");
        jRadioButton7.setOpaque(false);
        jRadioButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton7ActionPerformed(evt);
            }
        });

        jCheckBox19.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox19.setText("A prazo");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel37)
                            .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField32, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel38))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel39)
                            .addComponent(jTextField33, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jRadioButton7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButton8))
                            .addComponent(jCheckBox19, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton7)
                    .addComponent(jRadioButton8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel37)
                        .addGap(0, 0, 0)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2)))
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel14Layout.createSequentialGroup()
                            .addComponent(jLabel39)
                            .addGap(0, 0, 0)
                            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jLabel38)))
                .addGap(4, 4, 4)
                .addComponent(jCheckBox19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable3.setComponentPopupMenu(jPopupMenu1);
        jTable3.getTableHeader().setReorderingAllowed(false);
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable3);

        jComboBox6.setEnabled(false);
        jComboBox6.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox6ItemStateChanged(evt);
            }
        });

        jButton3.setText("Confirmar");
        jButton3.setEnabled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jScrollPane4.setBackground(new java.awt.Color(255, 255, 255));

        jTextPane1.setBorder(null);
        jTextPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextPane1.setText("Selecione as forma de pagamento para utilizar as função cartão");
        jTextPane1.setDisabledTextColor(new java.awt.Color(255, 0, 51));
        jTextPane1.setEnabled(false);
        jScrollPane4.setViewportView(jTextPane1);

        jLabel42.setText("Tipo:");

        jComboBox8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Dia Fixo", "Intervalo de dias" }));
        jComboBox8.setEnabled(false);
        jComboBox8.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox8ItemStateChanged(evt);
            }
        });

        jCheckBox14.setText("Recebimento das operações parcelada, dividido na mesma quantidade de vezes que o cliente pacelar");
        jCheckBox14.setEnabled(false);
        jCheckBox14.setOpaque(false);
        jCheckBox14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox14ActionPerformed(evt);
            }
        });

        jSpinner1.setEnabled(false);
        jSpinner1.setValue(1);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel42)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox8, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSpinner1))
                            .addComponent(jComboBox6, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel12Layout.createSequentialGroup()
                        .addComponent(jCheckBox14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel42)
                            .addComponent(jComboBox8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                        .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(1, 1, 1)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox14)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        jTabbedPane3.addTab("Operações com cartões", jPanel12);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane3)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Financeiro", jPanel9);

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));

        jLabel50.setText("Nome do Contador:");

        jTextField38.setEnabled(false);

        jLabel51.setText("CPF:");

        jTextField39.setEnabled(false);

        jLabel52.setFont(new java.awt.Font("Tahoma", 2, 10)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 0, 0));
        jLabel52.setText("Campo obrigatório");

        jLabel53.setFont(new java.awt.Font("Tahoma", 2, 10)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 0, 0));
        jLabel53.setText("Campo obrigatório");

        jLabel54.setText("CNPJ:");

        jTextField40.setEnabled(false);

        jLabel56.setText("Inscrição do CRC:");

        jTextField41.setEnabled(false);

        jLabel57.setFont(new java.awt.Font("Tahoma", 2, 10)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(255, 0, 0));
        jLabel57.setText("Campo obrigatório");

        jLabel55.setText("CEP:");

        jTextField42.setEnabled(false);
        jTextField42.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField42KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField42KeyReleased(evt);
            }
        });

        jLabel58.setText("Logradouro:");

        jTextField43.setEnabled(false);

        jLabel59.setText("Número:");

        jTextField44.setEnabled(false);

        jTextField45.setEnabled(false);

        jLabel60.setText("Complemento:");

        jLabel61.setText("Bairro:");

        jTextField46.setEnabled(false);

        jLabel62.setText("Telefône:");

        jTextField47.setEnabled(false);

        jLabel63.setText("Fax:");

        jTextField48.setEnabled(false);

        jLabel64.setText("E-mail:");

        jTextField49.setEnabled(false);

        jLabel65.setFont(new java.awt.Font("Tahoma", 2, 10)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(255, 0, 0));
        jLabel65.setText("Campo obrigatório");

        jLabel66.setText("Cidade:");

        jLabel67.setFont(new java.awt.Font("Tahoma", 2, 10)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(255, 0, 0));
        jLabel67.setText("Campo obrigatório");

        jTextField50.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField50.setEnabled(false);
        jTextField50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField50ActionPerformed(evt);
            }
        });
        jTextField50.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField50KeyPressed(evt);
            }
        });

        jTextField51.setBackground(new java.awt.Color(255, 255, 204));
        jTextField51.setEnabled(false);
        jTextField51.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField51ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel64)
                    .addComponent(jLabel50)
                    .addComponent(jLabel51)
                    .addComponent(jLabel55)
                    .addComponent(jLabel58)
                    .addComponent(jLabel59)
                    .addComponent(jLabel61)
                    .addComponent(jLabel62)
                    .addComponent(jLabel66))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel18Layout.createSequentialGroup()
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTextField42, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel53, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                                    .addComponent(jTextField39, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField44, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel18Layout.createSequentialGroup()
                                        .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField40, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel56)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField41, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel57)))
                                    .addGroup(jPanel18Layout.createSequentialGroup()
                                        .addComponent(jLabel60)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField45))))
                            .addComponent(jTextField43)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel18Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextField46, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField49)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel18Layout.createSequentialGroup()
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTextField38, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel18Layout.createSequentialGroup()
                                        .addComponent(jTextField47, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel63)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField48, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel18Layout.createSequentialGroup()
                                        .addComponent(jTextField50, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField51)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(21, 21, 21))))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50)
                    .addComponent(jTextField38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jLabel52)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel51)
                            .addComponent(jTextField39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addComponent(jLabel53))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel54)
                            .addComponent(jLabel56)
                            .addComponent(jTextField41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addComponent(jLabel57)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel55)
                    .addComponent(jTextField42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel58)
                    .addComponent(jTextField43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel59)
                    .addComponent(jTextField44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel60)
                    .addComponent(jTextField45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel61)
                    .addComponent(jTextField46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel62)
                    .addComponent(jTextField47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel63)
                    .addComponent(jTextField48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel64)
                    .addComponent(jTextField49, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jLabel65)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel66)
                        .addComponent(jTextField50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel67)
                .addContainerGap(159, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Contador", jPanel18);

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));

        jButton6.setText("Inserir Impostos");
        jButton6.setEnabled(false);
        jButton6.setFocusable(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jScrollPane7.setBackground(new java.awt.Color(255, 255, 255));

        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane7.setViewportView(jTable6);

        jButton8.setText("Editar Impostos");
        jButton8.setEnabled(false);
        jButton8.setFocusable(false);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton11.setText("Remover Impostos");
        jButton11.setEnabled(false);
        jButton11.setFocusable(false);
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton8)
                        .addComponent(jButton11)))
                .addContainerGap())
        );

        jPanel19Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton11, jButton6, jButton8});

        jTabbedPane1.addTab("Composição de preço", jPanel19);

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));

        jPanel24.setBackground(new java.awt.Color(255, 255, 255));
        jPanel24.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Tipo de papel", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        codigoProdutoDANFE.add(jRadioButton5);
        jRadioButton5.setSelected(true);
        jRadioButton5.setText("Bobina 88 mm");
        jRadioButton5.setEnabled(false);
        jRadioButton5.setOpaque(false);

        codigoProdutoDANFE.add(jRadioButton6);
        jRadioButton6.setText("A4");
        jRadioButton6.setEnabled(false);
        jRadioButton6.setOpaque(false);
        jRadioButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton6)
                    .addComponent(jRadioButton5))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton5)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(439, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(319, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("DANFE NFC-e - MOD 65", jPanel21);

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));
        jPanel23.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Código do Produto no DANFE", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        codigoProdutoDANFE.add(jRadioButton4);
        jRadioButton4.setText("Código de barras / Ref. do produto");
        jRadioButton4.setOpaque(false);

        codigoProdutoDANFE.add(jRadioButton3);
        jRadioButton3.setText("Código do produto");
        jRadioButton3.setOpaque(false);

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton4))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton4)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(335, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(322, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("DANFE NF-e - MOD 55", jPanel22);

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane5)
                .addContainerGap())
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane5)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Configuração do DANFE", jPanel20);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 645, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField_nome_fantazia1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_nome_fantazia1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_nome_fantazia1ActionPerformed

    private void jTextField_numero_endereco1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_numero_endereco1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_numero_endereco1ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed

        if (refreshButton.getText().equals("Editar")) {
            abreCampos();
            refreshButton.setText("Cancelar");
            saveButton.setEnabled(true);
        } else {
            try {
                fechaCampos();
                saveButton.setEnabled(false);
                refreshButton.setEnabled(true);
                refreshButton.setText("Editar");
                EMPRESA = new Controller().ControllerFind(Empresa.class, 1);
                createTables();
                setValueEmpresa();
            } catch (Exception ex) {
                Logger.getLogger(JIFEmpresa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_refreshButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        Salvar();
    }//GEN-LAST:event_saveButtonActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField_enderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_enderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_enderecoActionPerformed

    private void jTextField_razao_social1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_razao_social1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_razao_social1ActionPerformed

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9ActionPerformed

    private void jTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldActionPerformed

    private void jTextField9KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField9KeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER && !jTextField9.getText().isEmpty()) {
            consulta(Integer.parseInt(jTextField9.getText()));
        } else if (evt.getKeyCode() == KeyEvent.VK_F2) {
            setTextCidade(GetCidadeCodigo.getCidadeCodigo());
        }

    }//GEN-LAST:event_jTextField9KeyPressed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed

        if (jRadioButton1.isSelected()) {
            EMPRESA.setTpEmissao(0);
        } else if (jRadioButton2.isSelected()) {
            EMPRESA.setTpEmissao(1);
        }
        homologacaoProducao();

    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        if (jRadioButton1.isSelected()) {
            EMPRESA.setTpEmissao(0);
        } else if (jRadioButton2.isSelected()) {
            EMPRESA.setTpEmissao(1);
        }
        homologacaoProducao();

    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed

        if (jCheckBox1.isSelected()) {
            AbrirCamposBoleto();
        } else {
            FecharCamposBoleto();
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jTextField15KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField15KeyPressed

    }//GEN-LAST:event_jTextField15KeyPressed

    private void jTextField24FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField24FocusLost

    }//GEN-LAST:event_jTextField24FocusLost

    private void jTextField23FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField23FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField23FocusLost

    private void jTextField22FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField22FocusLost

    }//GEN-LAST:event_jTextField22FocusLost

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (!contem()) {
            try {
                HashMap filtro = new HashMap();
                filtro.put("descricaoTipoPagamento", jComboBox3.getSelectedItem().toString());
                List<TipoPagamento> tipoPagamento
                        = new Controller().ControllerFindByNameDesc(TipoPagamento.class, filtro);
                if (tipoPagamento != null) {
                    modelTableFormaPagamento.setNumRows(jTable1.getRowCount() + 1);
                    jTable1.setModel(modelTableFormaPagamento);
                    jTable1.setValueAt(tipoPagamento.get(0), jTable1.getRowCount() - 1, 0);
                    EMPRESA.getTipoPagamentoBoleto().add(tipoPagamento.get(0));
                    trataComboBoxFormaPagamento();
                }
            } catch (Exception ex) {
                Logger.getLogger(JIFEmpresa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        if (jButton3.getText().equals("Editar")) {
            AbrirCamposOpcartao();
            jButton3.setText("Confirmar");
            FecharCamposOpcartao2();
        } else if (jButton3.getText().equals("Confirmar")) {
            if (!contem3()) {
                try {
                    if (VerificaCampos()) {
                        HashMap filtro = new HashMap();
                        filtro.put("descricaoTipoPagamento", jComboBox6.getSelectedItem().toString());
                        List<TipoPagamento> tipoPagamento
                                = new Controller().ControllerFindByNameDesc(TipoPagamento.class, filtro);
                        TipoPagamentoCartaoPK tipoPagamentoCartaoPK = new TipoPagamentoCartaoPK(
                                tipoPagamento.get(0).getCodigoTipoPagamento(),
                                EMPRESA.getCodigoEmpresa()
                        );
                        TipoPagamentoCartao tipoPagamentoCartao = new TipoPagamentoCartao();

                        if (jComboBox8.getSelectedItem().toString().equals("Dia Fixo")) {
                            tipoPagamentoCartao.setTipoPagamentoCartaoPK(tipoPagamentoCartaoPK);
                            tipoPagamentoCartao.setTipo(jComboBox8.getSelectedItem().toString());
                            tipoPagamentoCartao.setDiaFixo(Integer.parseInt(jSpinner1.getValue().toString()));
                            tipoPagamentoCartao.setQtdDia(0);
                        } else if (jComboBox8.getSelectedItem().toString().equals("Intervalo de dias")) {
                            if (Integer.parseInt(jSpinner1.getValue().toString()) >= 1) {
                                tipoPagamentoCartao.setTipoPagamentoCartaoPK(tipoPagamentoCartaoPK);
                                tipoPagamentoCartao.setTipo(jComboBox8.getSelectedItem().toString());
                                tipoPagamentoCartao.setDiaFixo(0);
                                tipoPagamentoCartao.setQtdDia(Integer.parseInt(jSpinner1.getValue().toString()));
                            } else {
                                JOptionPane.showMessageDialog(rootPane, "Informe o intervalo de dias após a venda que receberar os valores referênte as vendas realizadas via cartão.");
                                jSpinner1.requestFocus();
                            }
                        }
                        if (jCheckBox14.isSelected()) {
                            tipoPagamentoCartao.setRecebimentoPacelado(0);
                        } else {
                            tipoPagamentoCartao.setRecebimentoPacelado(1);
                        }
                        tipoPagamentoCartao.setEmpresa(EMPRESA);
                        tipoPagamentoCartao.setTipoPagamento(tipoPagamento.get(0));
                        new Controller().ControllerPersistMerge(TipoPagamentoCartao.class, tipoPagamentoCartao);

                        modelTableFormaPagamento3.setNumRows(jTable3.getRowCount() + 1);
                        jTable3.setModel(modelTableFormaPagamento3);

                        ///jTable3.setValueAt(jTextField.getText(), jTable3.getRowCount() - 1, 2);
                        jTable3.setValueAt(jComboBox6.getSelectedItem(), jTable3.getRowCount() - 1, 0);
                        jTable3.setValueAt(jComboBox8.getSelectedItem(), jTable3.getRowCount() - 1, 1);
                        jTable3.setValueAt(jSpinner1.getValue().toString(), jTable3.getRowCount() - 1, 2);
                        jTable3.setValueAt(
                                jCheckBox14.isSelected() ? "Parcelado" : "A vista",
                                jTable3.getRowCount() - 1, 3
                            );
                        jTable3.setValueAt(tipoPagamentoCartao, jTable3.getRowCount() - 1, 4);
                        trataComboBoxFormaPagamento();
                        FecharCamposOpcartao();
                        AbrirCamposOpcartao2();
                        jButton3.setText("Editar");
                        jTable3.addRowSelectionInterval(jTable3.getRowCount() - 1, jTable3.getRowCount() - 1);
                    }
                } catch (NullPointerException e) {
                } catch (Exception ex) {
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Esta forma de pagamento já está sendo utilizada,\nEscolha outra.", "Erro forma de pagamento", 0);
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        if (!contem2()) {
            try {
                HashMap filtro = new HashMap();
                filtro.put("descricaoTipoPagamento", jComboBox7.getSelectedItem().toString());
                List<TipoPagamento> tipoPagamento
                        = new Controller().ControllerFindByNameDesc(TipoPagamento.class, filtro);
                if (tipoPagamento != null) {
                    modelTableFormaPagamento2.setNumRows(jTable4.getRowCount() + 1);
                    jTable4.setModel(modelTableFormaPagamento2);
                    jTable4.setValueAt(tipoPagamento.get(0), jTable4.getRowCount() - 1, 0);
                    EMPRESA.getTipoPagamentoPromissoriaList()
                            .add(new TipoPagamentoPromissoria(EMPRESA, tipoPagamento.get(0)));
                    trataComboBoxFormaPagamento();
                }
            } catch (Exception ex) {
                Logger.getLogger(JIFEmpresa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


    }//GEN-LAST:event_jButton4ActionPerformed

    private void jCheckBox13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox13ActionPerformed

        if (jCheckBox13.isSelected()) {
            AbrirCamposPromissoria();
        } else {
            FecharCamposPromissoria();
        }

    }//GEN-LAST:event_jCheckBox13ActionPerformed

    private void jComboBox8ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox8ItemStateChanged
        if (evt.getItem().equals("Dia Fixo")) {
            if (jComboBox8.getSelectedItem().toString().equals("Dia Fixo")) {
                jSpinner1.setValue(1);
                jSpinner1.setEnabled(true);
            }
        } else if (evt.getItem().equals("Intervalo de dias")) {
            jSpinner1.setEnabled(true);
            jSpinner1.requestFocus();
        }
    }//GEN-LAST:event_jComboBox8ItemStateChanged

    private void jDayChooser1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jDayChooser1AncestorAdded

    }//GEN-LAST:event_jDayChooser1AncestorAdded

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if (!contem()) {
            try {
                modelTableFormaPagamentoAvista.setNumRows(jTable5.getRowCount() + 1);
                jTable5.setModel(modelTableFormaPagamentoAvista);
                

                HashMap filtro = new HashMap();
                filtro.put("descricaoTipoPagamento", jComboBox9.getSelectedItem().toString());
                List<TipoPagamento> tipoPagamento
                        = new Controller().ControllerFindByNameDesc(TipoPagamento.class, filtro);
                if (!tipoPagamento.isEmpty()) {
                    EMPRESA.getTipoPagamentoAvistaList().add(tipoPagamento.get(0));
                    jTable5.setValueAt(tipoPagamento.get(0), jTable5.getRowCount() - 1, 0);
                    trataComboBoxFormaPagamento();
                }
            } catch (Exception ex) {
                Logger.getLogger(JIFEmpresa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jRadioButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton7ActionPerformed
        EMPRESA.setTef(1);
    }//GEN-LAST:event_jRadioButton7ActionPerformed

    private void jRadioButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton8ActionPerformed
        EMPRESA.setTef(2);
    }//GEN-LAST:event_jRadioButton8ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        CriaConfiguracaoTaxaCartao();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        if (!evt.getItem().toString().equals("")) {
            EMPRESA.setEnquadramento(evt.getItem().toString());
        }
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox2ItemStateChanged
        if (!evt.getItem().toString().equals("")) {
            EMPRESA.setTipoTributario(evt.getItem().toString());
            if (!evt.getItem().toString().equals("Simples nacional")) {
                EMPRESA.setCrt('3');
                jTextField21.setText("3");
            } else {
                EMPRESA.setCrt('1');
                jTextField21.setText("1");
            }
            situacaoTributaria(!jTextField21.getText().equals("1"));
        }
    }//GEN-LAST:event_jComboBox2ItemStateChanged

    private void jComboBox10ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox10ItemStateChanged
        if (evt.getItem().equals("Gmail")) {
            jTextField35.setText("smtp.gmail.com");
            jTextField35.setEnabled(false);
            jTextField36.setText("465");
            jTextField36.setEnabled(false);
        } else if (evt.getItem().equals("Hotmail")) {
            jTextField35.setText("smtp-mail.outlook.com");
            jTextField35.setEnabled(false);
            jTextField36.setText("587");
            jTextField36.setEnabled(false);
        } else if (evt.getItem().equals("Outros")) {
            //jTextField35.setText("");
            jTextField35.setEnabled(true);
            jTextField36.setText("");
            jTextField36.setEnabled(true);
        }
        {

        }

    }//GEN-LAST:event_jComboBox10ItemStateChanged

    private void jTextField23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField23ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField23ActionPerformed

    private void jTextField42KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField42KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField42KeyPressed

    private void jTextField42KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField42KeyReleased
        if (jTextField42.getText().length() == 9) {
            try {
                HashMap filtro = new HashMap();
                filtro.put("cep", jTextField42.getText());
                List<Cep> listCep = (List<Cep>) new Controller().ControllerFindByCodId(Cep.class, filtro);

                if (listCep == null ? false : listCep.isEmpty()) {
                    br.com.parg.viacep.CEP cepWeb = new br.com.parg.viacep.CEP();
                    if (jTextField42.getText().length() == 8) {
                        br.com.parg.viacep.Start st = new br.com.parg.viacep.Start();
                        st.run(jTextField42.getText());
                        cepWeb = st.getCep();
                        if (cepWeb != null) {
                            bd.DAO.Cep cep = new bd.DAO.Cep();
                            cep.setBairro(cepWeb.Bairro);
                            cep.setCep(cepWeb.CEP);
                            cep.setCidade(cepWeb.Localidade);
                            cep.setLogradouro(cepWeb.Logradouro);
                            cep.setUf(cepWeb.Uf);
                            new Controller().ControllerPersistMerge(bd.DAO.Cep.class, cep);
                        }
                    }
                }

                if (listCep == null ? false : !listCep.isEmpty()) {
                    jTextField43.setText(listCep.get(0).getLogradouro());
                    jTextField46.setText(listCep.get(0).getBairro());
                    jTextField50.setText(listCep.get(0).getCidade());
                }
                filtro.clear();
                filtro.put("nome", listCep.get(0).getCidade());
                List<CidadeCodigo> listCidade = (List<CidadeCodigo>) new Controller().ControllerFindByNameDesc(CidadeCodigo.class, filtro);
                if (listCidade == null ? false : !listCidade.isEmpty()) {
                    jTextField51.setText(listCidade.get(0).getNome());
                }
            } catch (Exception ex) {
                Logger.getLogger(JIFEmpresa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jTextField42KeyReleased

    private void jComboBox4ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox4ItemStateChanged
        if (evt.getItem().toString().equals("Varejista em geral")) {
            jCheckBox15.setEnabled(true);
            jCheckBox16.setEnabled(true);

            jRadioButton9.setEnabled(true);
            jRadioButton10.setEnabled(true);

        } else if (evt.getItem().toString().equals("Mercado, Supermercado, Hipermercado")) {
            jCheckBox15.setEnabled(true);
            jCheckBox16.setEnabled(false);
            jCheckBox16.setSelected(false);
            jRadioButton9.setEnabled(false);
            jRadioButton10.setEnabled(false);

        } else if (evt.getItem().toString().equals("Autopeças e Oficinas")) {
            jCheckBox16.setEnabled(true);
            jCheckBox15.setEnabled(false);
            jCheckBox15.setSelected(false);
            jRadioButton9.setEnabled(true);
            jRadioButton10.setEnabled(true);

        } else {
            jCheckBox15.setEnabled(false);
            jCheckBox15.setSelected(false);
            jCheckBox16.setEnabled(false);
            jCheckBox16.setSelected(false);

            jRadioButton9.setEnabled(true);
            jRadioButton10.setEnabled(true);
        }
    }//GEN-LAST:event_jComboBox4ItemStateChanged

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try {
            AliquotaSimplesNacional alq = PostAliquotaSimplesNacional.getAliquotaSimplesNacional();
            alq.setEmpresa(EMPRESA);

            if (alq != null ? (alq.getEmpresa() != null
                    && alq.getImposto() != null
                    && alq.getTipo() != null
                    && alq.getValor() != null) : false) {
                alq = new Controller().ControllerPersistMerge(AliquotaSimplesNacional.class, alq);
                JOptionPane.showMessageDialog(null, "Configuração do Simples Nacional configurada com sucesso!");
                modelTableSimplesNacional.setNumRows(jTable6.getRowCount() + 1);
                jTable6.setModel(modelTableSimplesNacional);
                jTable6.setValueAt(alq.getImposto(), jTable6.getRowCount() - 1, 0);
                jTable6.setValueAt(alq.getValor().toString(), jTable6.getRowCount() - 1, 1);
                jTable6.setValueAt(String.valueOf(alq.getTipo()), jTable6.getRowCount() - 1, 2);
                jTable6.setValueAt(alq, jTable6.getRowCount() - 1, 3);
            }
        } catch (Exception ex) {
            Logger.getLogger(JIFEmpresa.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        try {
            TipoPagamento tp = (TipoPagamento) jTable4.getValueAt(jTable4.getSelectedRow(), 0);
            if (new Controller().ControllerRemove(tp.getTipoPagamentoPromissoriaList().get(0))
                    && EMPRESA.getTipoPagamentoPromissoriaList().remove(tp.getTipoPagamentoPromissoriaList().get(0))) {
                modelTableFormaPagamento2 = (DefaultTableModel) jTable4.getModel();
                modelTableFormaPagamento2.removeRow(jTable4.getSelectedRow());
                jTable4.setModel(modelTableFormaPagamento2);
            }
        } catch (Exception ex) {
            Logger.getLogger(JIFEmpresa.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        if (!contemDescontoMaximo() && !jMoneyField1.getText().equals("0,00")) {

            try {
                GupoProduto grupo = gupoProdutoList.get(jComboBox12.getSelectedIndex());
                grupo.setDesconto(new BigDecimal(jMoneyField1.getText().replace(",", ".")));
                grupo = new Controller().ControllerPersistMerge(GupoProduto.class, grupo);
                setValueTableDescontoGrupo(grupo);
            } catch (Exception ex) {
            }
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jCheckBox17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox17ActionPerformed
        if (jCheckBox17.isSelected()) {
            formatarTabelaDesconto();
            AbrirCamposDescontoMaximoProduto();
        } else {
            jTable7 = new JTable(null);
            FecharCamposDescontoMaximoGrupo();
        }

    }//GEN-LAST:event_jCheckBox17ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        try {

            Configuracao configuracao = EMPRESA.getConfiguracao();
            configuracao.setDescontoMaximoVendedor(new BigDecimal(jMoneyField2.getText().replace(".", "").replace(",", ".")));
            EMPRESA.setConfiguracao(configuracao);
            if (ConsultaDescontoMaximo()) {
                SetDescontoMaximo();
                jLabel72.setVisible(true);
                JOptionPane.showMessageDialog(null, "Desconto configurado com sucesso!!");
            }
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jCheckBox18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox18ActionPerformed
        if (jCheckBox18.isSelected()) {
            AbrirCamposDescontoMaximo();
        } else {
            jMoneyField2.setText("0,00");
            jButton10.doClick();
            FecharCamposDescontoMaximo();

        }
    }//GEN-LAST:event_jCheckBox18ActionPerformed

    private void jMoneyField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jMoneyField2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMoneyField2KeyPressed

    private void jMoneyField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jMoneyField2KeyReleased
        jLabel72.setVisible(false);
        if (new BigDecimal(jMoneyField2.getText().replace(".", "").replace(",", ".")).compareTo(new BigDecimal(100.00)) != -1) {
            jMoneyField2.setText("0,00");
            JOptionPane.showMessageDialog(null, "Desconto inválido.", "Erro", 0);
        }
    }//GEN-LAST:event_jMoneyField2KeyReleased

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked

    }//GEN-LAST:event_jTable3MouseClicked

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        try {
            bd.DAO.TipoPagamento ob = (bd.DAO.TipoPagamento) jTable3.getValueAt(jTable3.getSelectedRow(), 0);
            
            if (ob != null) {
                for (int i = 0; i < ob.getConfigTaxaCartaoList().size(); i++) {
                    ConfigTaxaCartao obj = ob.getConfigTaxaCartaoList().get(i);
                    new Controller().ControllerRemove(obj);
                }

                new Controller().ControllerRemove(ob.getTipoPagamentoCartaoList().get(0));

                DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
                model.removeRow(jTable3.getSelectedRow());
                jTable3.setModel(model);
            }
        } catch (Exception ex) {
            Logger.getLogger(JIFEmpresa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed

        Integer codigoConfigTaxaCartao = null;
        if (jTable2.getSelectedRow() > -1) {
            try {
                codigoConfigTaxaCartao = (Integer) jTable2.getValueAt(jTable2.getSelectedRow(), 5);
                if (codigoConfigTaxaCartao > 0) {
                    ConfigTaxaCartao cartao = new Controller().ControllerFind(ConfigTaxaCartao.class, codigoConfigTaxaCartao);

                    if (cartao != null) {
                        new Controller().ControllerRemove(cartao);

                        TipoPagamento tp = cartao.getTipoPagamento();
                        tp.getConfigTaxaCartaoList().remove(cartao);
                        
                        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
                        model.removeRow(jTable2.getSelectedRow());
                        jTable2.setModel(model);
                        EMPRESA.getTipoPagamentoCartaoList()
                            .get(jTable3.getSelectedRow()).getTipoPagamento().getConfigTaxaCartaoList().remove(cartao);
                        jTable3.setValueAt(tp, jTable3.getRowCount() - 1, 0);
                        jTable3.setValueAt(tp.getTipoPagamentoCartaoList().get(0), jTable3.getRowCount() - 1, 4);
                    }
                }
            } catch (Exception x) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma taxa para ser removida!", "Confiança Sistemas", 0);
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jCheckBox16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBox16MouseClicked
        if (jCheckBox16.isSelected()) {
            jRadioButton9.setEnabled(true);
            jRadioButton10.setEnabled(true);
        } else {
            jRadioButton9.setEnabled(false);
            jRadioButton10.setEnabled(false);
        }
    }//GEN-LAST:event_jCheckBox16MouseClicked

    private void jCheckBox14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox14ActionPerformed

    private void jTextField30FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField30FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField30FocusLost

    private void jTextField31FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField31FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField31FocusLost

    private void jTextField31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField31ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField31ActionPerformed

    private void Remov1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Remov1ActionPerformed
        try {
            EMPRESA.getTipoPagamentoAvistaList().remove((TipoPagamento) jTable5.getValueAt(jTable5.getSelectedRow(), 0));
            modelTableFormaPagamentoAvista = (DefaultTableModel) jTable5.getModel();
            modelTableFormaPagamentoAvista.removeRow(jTable5.getSelectedRow());
            jTable5.setModel(modelTableFormaPagamentoAvista);
        } catch (Exception ex) {
            Logger.getLogger(JIFEmpresa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Remov1ActionPerformed

    private void Remov2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Remov2ActionPerformed
        try {
            if (jTable1.isEnabled()) {
                HashMap filtro = new HashMap();
                filtro.put("descricaoTipoPagamento", jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
                List<TipoPagamento> tipoPagamento
                        = new Controller().ControllerFindByNameDesc(TipoPagamento.class, filtro);
                if (tipoPagamento != null) {
                    EMPRESA.getTipoPagamentoBoleto().remove(tipoPagamento.get(0));
                    modelTableFormaPagamento = (DefaultTableModel) jTable1.getModel();
                    modelTableFormaPagamento.removeRow(jTable1.getSelectedRow());
                    jTable1.setModel(modelTableFormaPagamento);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(JIFEmpresa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Remov2ActionPerformed

    private void jCheckBox20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBox20MouseClicked

        jRadioButton11.setSelected(jCheckBox20.isSelected());

        if (jCheckBox20.isSelected()) {
            jRadioButton11.setEnabled(true);
            jRadioButton12.setEnabled(true);
        } else {
            jRadioButton11.setEnabled(false);
            jRadioButton12.setEnabled(false);
        }

    }//GEN-LAST:event_jCheckBox20MouseClicked

    private void jLabel75MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel75MouseClicked
        jRadioButton11.doClick();
    }//GEN-LAST:event_jLabel75MouseClicked

    private void jLabel76MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel76MouseClicked
        jRadioButton11.doClick();
    }//GEN-LAST:event_jLabel76MouseClicked

    private void jLabel77MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel77MouseClicked
        jRadioButton12.doClick();
    }//GEN-LAST:event_jLabel77MouseClicked

    private void jLabel78MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel78MouseClicked
        jRadioButton12.doClick();
    }//GEN-LAST:event_jLabel78MouseClicked

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        try {
            AliquotaSimplesNacional alq = (AliquotaSimplesNacional) jTable6.getValueAt(jTable6.getSelectedRow(), 3);
            alq = PostAliquotaSimplesNacional.setAliquotaSimplesNacional(alq);

            if (alq != null ? (alq.getEmpresa() != null
                    && alq.getImposto() != null
                    && alq.getTipo() != null
                    && alq.getValor() != null) : false) {

                JOptionPane.showMessageDialog(null, "Configuração do Simples Nacional configurada com sucesso!");
                jTable6.setModel(modelTableSimplesNacional);
                jTable6.setValueAt(alq.getImposto(), jTable6.getSelectedRow(), 0);
                jTable6.setValueAt(alq.getValor().toString(), jTable6.getSelectedRow(), 1);
                jTable6.setValueAt(String.valueOf(alq.getTipo()), jTable6.getSelectedRow(), 2);
                jTable6.setValueAt(alq, jTable6.getSelectedRow(), 3);
            }
        } catch (Exception ex) {
            Logger.getLogger(JIFEmpresa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed

        if (jTable6.getSelectedRow() > -1) {
            try {
                AliquotaSimplesNacional aliquotaSimplesNacional
                        = (AliquotaSimplesNacional) jTable6.getValueAt(jTable6.getSelectedRow(), 3);
                if (new Controller().ControllerRemove(aliquotaSimplesNacional)) {
                    DefaultTableModel model = (DefaultTableModel) jTable6.getModel();
                    model.removeRow(jTable6.getSelectedRow());
                }
            } catch (Exception ex) {
                Logger.getLogger(JIFEmpresa.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma linha na tabela", "Erro", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButton11ActionPerformed

    private void jRadioButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton6ActionPerformed
    }//GEN-LAST:event_jRadioButton6ActionPerformed

    private void jTextField50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField50ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField50ActionPerformed

    private void jTextField50KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField50KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            consulta(Integer.parseInt(jTextField9.getText()));
        } else if (evt.getKeyCode() == KeyEvent.VK_F2) {
            setTextCidade(GetCidadeCodigo.getCidadeCodigo());
        }
    }//GEN-LAST:event_jTextField50KeyPressed

    private void jTextField51ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField51ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField51ActionPerformed

    private void jTextField22KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField22KeyReleased
        if (jTextField22.getText().length() > 3) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField22KeyReleased

    private void jTextField23KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField23KeyReleased
        if (jTextField23.getText().length() > 3) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField23KeyReleased

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        try {
            GupoProduto gupo = (GupoProduto) jTable7.getValueAt(jTable7.getSelectedRow(), 2);
            gupo.setDesconto(BigDecimal.ZERO);
            new Controller().ControllerPersistMerge(GupoProduto.class, gupo);
            DefaultTableModel md = (DefaultTableModel) jTable7.getModel();
            md.removeRow(jTable7.getSelectedRow());
            jTable7.setModel(md);
        } catch (Exception ex) {
            Logger.getLogger(JIFEmpresa.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton12ActionPerformed

    private void jComboBox9ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox9ItemStateChanged

    }//GEN-LAST:event_jComboBox9ItemStateChanged

    private void jComboBox3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox3ItemStateChanged

    }//GEN-LAST:event_jComboBox3ItemStateChanged

    private void jComboBox7ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox7ItemStateChanged

    }//GEN-LAST:event_jComboBox7ItemStateChanged

    private void jComboBox6ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox6ItemStateChanged

    }//GEN-LAST:event_jComboBox6ItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Remov1;
    private javax.swing.JMenuItem Remov2;
    private javax.swing.JPopupMenu Remove1;
    private javax.swing.JPopupMenu Remove2;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.ButtonGroup codigoProdutoDANFE;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox10;
    private javax.swing.JCheckBox jCheckBox11;
    private javax.swing.JCheckBox jCheckBox12;
    private javax.swing.JCheckBox jCheckBox13;
    private javax.swing.JCheckBox jCheckBox14;
    private javax.swing.JCheckBox jCheckBox15;
    private javax.swing.JCheckBox jCheckBox16;
    private javax.swing.JCheckBox jCheckBox17;
    private javax.swing.JCheckBox jCheckBox18;
    private javax.swing.JCheckBox jCheckBox19;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox20;
    private javax.swing.JCheckBox jCheckBox21;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JCheckBox jCheckBox9;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox<String> jComboBox10;
    private javax.swing.JComboBox<String> jComboBox12;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JComboBox<String> jComboBox7;
    private javax.swing.JComboBox<String> jComboBox8;
    private javax.swing.JComboBox<String> jComboBox9;
    private com.toedter.calendar.JDateChooser jDateChooser_data_cadastro1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_cnpj1;
    private javax.swing.JLabel jLabel_ie1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private ClassesEntidades.JMoneyField jMoneyField1;
    private ClassesEntidades.JMoneyField jMoneyField2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JPopupMenu jPopupMenu_remove_promossoria;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton10;
    private javax.swing.JRadioButton jRadioButton11;
    private javax.swing.JRadioButton jRadioButton12;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JRadioButton jRadioButton9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JTabbedPane jTabbedPane6;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JTable jTable7;
    public static javax.swing.JTextField jTextField;
    private javax.swing.JTextField jTextField1;
    public static javax.swing.JTextField jTextField10;
    public static javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    public static javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    public static javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField26;
    private javax.swing.JTextField jTextField27;
    public static javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField30;
    private javax.swing.JTextField jTextField31;
    private javax.swing.JTextField jTextField32;
    private javax.swing.JTextField jTextField33;
    private javax.swing.JTextField jTextField35;
    private javax.swing.JTextField jTextField36;
    private javax.swing.JTextField jTextField37;
    private javax.swing.JTextField jTextField38;
    private javax.swing.JTextField jTextField39;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField40;
    private javax.swing.JTextField jTextField41;
    private javax.swing.JTextField jTextField42;
    private javax.swing.JTextField jTextField43;
    private javax.swing.JTextField jTextField44;
    private javax.swing.JTextField jTextField45;
    private javax.swing.JTextField jTextField46;
    private javax.swing.JTextField jTextField47;
    private javax.swing.JTextField jTextField48;
    private javax.swing.JTextField jTextField49;
    private javax.swing.JTextField jTextField5;
    public static javax.swing.JTextField jTextField50;
    public static javax.swing.JTextField jTextField51;
    private javax.swing.JTextField jTextField52;
    private javax.swing.JTextField jTextField53;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    public static javax.swing.JTextField jTextField9;
    private javax.swing.JTextField jTextField_endereco;
    private javax.swing.JTextField jTextField_nome_fantazia1;
    private javax.swing.JTextField jTextField_numero_endereco1;
    private javax.swing.JTextField jTextField_razao_social1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables

    public void AlimentaTabelaSimplesNacional() {
        for (int i = 0; i < EMPRESA.getTipoPagamentoCartaoList().size(); i++) {
            modelTableFormaPagamento3.setNumRows(jTable3.getRowCount() + 1);
            jTable3.setModel(modelTableFormaPagamento3);
            jTable3.setValueAt(EMPRESA.getTipoPagamentoCartaoList().get(i).getTipoPagamento().getDescricaoTipoPagamento(), jTable3.getRowCount() - 1, 0);
            jTable3.setValueAt(EMPRESA.getTipoPagamentoCartaoList().get(i).getTipo(), jTable3.getRowCount() - 1, 1);
            if (EMPRESA.getTipoPagamentoCartaoList().get(i).getTipo().equals("Dia Fixo")) {
                jTable3.setValueAt(EMPRESA.getTipoPagamentoCartaoList().get(i).getDiaFixo(), jTable3.getRowCount() - 1, 2);
            } else if (EMPRESA.getTipoPagamentoCartaoList().get(i).getTipo().equals("Intervalo de dias")) {
                jTable3.setValueAt(EMPRESA.getTipoPagamentoCartaoList().get(i).getQtdDia(), jTable3.getRowCount() - 1, 2);
            }

            jTable3.setValueAt(
                    EMPRESA.getTipoPagamentoCartaoList().get(i).getRecebimentoPacelado() == 0 ? "Parcelado" : "A vista",
                    jTable3.getRowCount() - 1, 3
            );

        }
    }

    public void trataComboBoxFormaPagamento() {
        ArrayList<String> formasPagamentoUtilizada = new ArrayList<>();
        for (int j = 0; j < jTable5.getRowCount(); j++) {
            formasPagamentoUtilizada.add(jTable5.getValueAt(j, 0).toString());
        }
        for (int j = 0; j < jTable1.getRowCount(); j++) {
            formasPagamentoUtilizada.add(jTable1.getValueAt(j, 0).toString());
        }

        for (int k = 0; k < jTable4.getRowCount(); k++) {
            formasPagamentoUtilizada.add(jTable4.getValueAt(k, 0).toString());
        }

        for (int k = 0; k < jTable3.getRowCount(); k++) {
            formasPagamentoUtilizada.add(jTable3.getValueAt(k, 0).toString());
        }

        for (int i = 0; i < tipoPagamentoList.size(); i++) {
            if (!formasPagamentoUtilizada.contains(tipoPagamentoList.get(i).getDescricaoTipoPagamento())) {
                jComboBox3.addItem(tipoPagamentoList.get(i).getDescricaoTipoPagamento());
            }
        }

        jComboBox3.removeAllItems();
        for (int i = 0; i < tipoPagamentoList.size(); i++) {
            if (!formasPagamentoUtilizada.contains(tipoPagamentoList.get(i).getDescricaoTipoPagamento())) {
                jComboBox3.addItem(tipoPagamentoList.get(i).getDescricaoTipoPagamento());
                jComboBox9.addItem(tipoPagamentoList.get(i).getDescricaoTipoPagamento());
                jComboBox6.addItem(tipoPagamentoList.get(i).getDescricaoTipoPagamento());
                jComboBox7.addItem(tipoPagamentoList.get(i).getDescricaoTipoPagamento());
            }
        }

    }

    public void trataComboBoxGrupo() {
        for (int i = 0; i < gupoProdutoList.size(); i++) {
            jComboBox12.addItem(gupoProdutoList.get(i).getDescricaoGrupo());
        }
    }

    public boolean contemDescontoMaximo() {
        boolean contem = false;
        for (int i = 0; i < jTable7.getRowCount(); i++) {
            //System.out.println("1 "+EMPRESA.getTipoPagamentoList().get(i).getDescricaoTipoPagamento());
            //System.out.println("2 "+jComboBox3.getSelectedItem());
            if (jTable7.getValueAt(i, 2).equals(jComboBox12.getSelectedItem())) {
                contem = true;
            }
        }
        if (contem) {
            JOptionPane.showMessageDialog(null, "Este Grupo Selecionado já foi selecionado e incluido!");
        }

        return contem;
    }

    public boolean contem() {
        boolean contem = false;
        for (int i = 0; i < EMPRESA.getTipoPagamentoBoleto().size(); i++) {
            System.out.println("1 " + EMPRESA.getTipoPagamentoBoleto().get(i).getDescricaoTipoPagamento());
            System.out.println("2 " + jComboBox3.getSelectedItem());
            if (EMPRESA.getTipoPagamentoBoleto().get(i).getDescricaoTipoPagamento().equals(jComboBox3.getSelectedItem().toString())) {
                contem = true;
            }
        }

        if (contem) {
            JOptionPane.showMessageDialog(null, "Esta forma de pagamento já foi selecionada e incluida!");
        }

        return contem;
    }

    public boolean contem2() {
        boolean contem = false;
        for (int i = 0; i < EMPRESA.getTipoPagamentoPromissoriaList().size(); i++) {
            if (EMPRESA.getTipoPagamentoPromissoriaList().get(i).getTipoPagamento().getDescricaoTipoPagamento().equals(jComboBox7.getSelectedItem().toString())) {
                contem = true;
            }
        }

        if (contem) {
            JOptionPane.showMessageDialog(null, "Esta forma de pagamento já foi selecionada e incluida!");
        }

        return contem;
    }

    public boolean VerificaCampos() {
        boolean retorno = true;
        StringBuilder sb = new StringBuilder();
        try {
            if (jComboBox8.getSelectedItem().toString().isEmpty()) {
                retorno = false;
                sb.append("Selecione um tipo");
                sb.append(System.getProperty("line.separator"));
            }
        } catch (Exception ex) {
            retorno = false;
            sb.append("Selecione um tipo");
            sb.append(System.getProperty("line.separator"));
        }

        try {
            if (Integer.parseInt(jSpinner1.getValue().toString()) <= 0) {
                retorno = false;
                sb.append("Informe uma quantidade de dias");
                sb.append(System.getProperty("line.separator"));
            }
        } catch (Exception ex) {
            retorno = false;
            sb.append("Informe uma quantidade de dias");
            sb.append(System.getProperty("line.separator"));
        }

        try {
            if (jComboBox6.getSelectedItem().toString().isEmpty()) {
                retorno = false;
                sb.append("Selecione uma forma de pagamento");
                sb.append(System.getProperty("line.separator"));
            }
        } catch (Exception ex) {
            retorno = false;
            sb.append("Selecione uma forma de pagamento");
            sb.append(System.getProperty("line.separator"));
        }

        if (!retorno) {
            JOptionPane.showMessageDialog(null, sb);
        }

        return retorno;
    }

    public void Salvar() {

        try {
            /**
             * ******************************************************
             * SALVAR MODEL PARDIGITAL
             * *******************************************************
             */
            SalvaParDigital();

            /**
             * ******************************************************
             * SALVAR MODEL CONFIGURACAO
             * *******************************************************
             */
            SalvaConfiguracao();

            /**
             * ******************************************************
             * SALVAR MODEL CONTABILISTA
             * *******************************************************
             */
            SalvarContabilista();

            /**
             * ******************************************************
             * SALVAR MODEL EMPRESA
             * *******************************************************
             */
            SalvaEmpresa();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(JIFEmpresa.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }

        fechaCampos();
        JOptionPane.showMessageDialog(null, "Alterações realizada com sucesso!");
        saveButton.setEnabled(false);
        refreshButton.setText("Editar");
    }

    public String formataCep(String cep) {
        String retorno = "";
        if (!cep.isEmpty()) {
            if (cep.length() == 8) {
                retorno = cep.substring(0, 5) + "-" + cep.substring(5);
            }
            if (cep.length() == 9) {
                retorno = cep;
            }
        }
        return retorno;
    }

    public boolean contem3() {
        boolean contem = false;
        for (int i = 0; i < EMPRESA.getTipoPagamentoCartaoList().size(); i++) {
            try {
                if (EMPRESA.getTipoPagamentoCartaoList().get(i).getTipoPagamento().getDescricaoTipoPagamento().equals(jComboBox6.getSelectedItem().toString())) {
                    contem = true;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "Escolha uma forma de pagamento válida", "Erro", 0);
                break;
            }
        }

        if (contem) {
            JOptionPane.showMessageDialog(null, "Esta forma de pagamento já foi selecionada e incluida!");
        }

        return contem;
    }

    public boolean contem4(){
        for (int i = 0; i < jTable2.getRowCount(); i++) {
            if(jTable2.getValueAt(i,0).toString().equals(
                        jCheckBox19.isSelected() ? "A prazo" : "A vista")){
                return false;
            }
        }
        return true;
    }
    
    private bd.DAO.Pardigital SalvaParDigital() throws Exception {
        ///PRODUCAO
        Pardigital pardigital = new Controller().ControllerFind(Pardigital.class, EMPRESA.getTpEmissao() == 0 ? 2 : 1);
        try {
            if (pardigital.getCodigo() == 1) {
                pardigital.setCsc(jTextField27.getText());
            }
        } catch (Exception ex) {
        }
        try {
            if (pardigital.getCodigo() == 1) {
                pardigital.setSerie55(jTextField25.getText());
            }
        } catch (Exception ex) {
        }
        try {
            if (pardigital.getCodigo() == 1) {
                pardigital.setSerie55(jTextField26.getText());
            }
        } catch (Exception ex) {
        }
        try {
            if (pardigital.getCodigo() == 1) {
                pardigital.setUltimanf55(jTextField30.getText());
            }
        } catch (Exception ex) {
        }
        try {
            if (pardigital.getCodigo() == 1) {
                pardigital.setUltimanf65(jTextField31.getText());
            }
        } catch (Exception ex) {
        }

        //HOMOLOGACAO
        try {
            if (pardigital.getCodigo() == 2) {
                pardigital.setCsc(jTextField24.getText());
            }
        } catch (Exception ex) {
        }

        try {
            if (pardigital.getCodigo() == 2) {
                pardigital.setSerie55(jTextField22.getText().trim());
            }
        } catch (Exception ex) {
        }
        try {
            if (pardigital.getCodigo() == 2) {
                pardigital.setSerie65(jTextField23.getText().trim());
            }
        } catch (Exception ex) {
        }
        try {
            if (pardigital.getCodigo() == 2) {
                pardigital.setUltimanf55(jTextField52.getText().trim());
            }
        } catch (Exception ex) {
        }
        try {
            if (pardigital.getCodigo() == 2) {
                pardigital.setUltimanf65(jTextField53.getText().trim());
            }
        } catch (Exception ex) {
        }

        new Controller().ControllerPersistMerge(Pardigital.class, pardigital);

        return pardigital;
    }

    private bd.DAO.Configuracao SalvaConfiguracao() throws Exception {

        Configuracao configuracao = EMPRESA.getConfiguracao();

        try {
            if (jRadioButton9.isSelected()) {
                configuracao.setControlaEstoqueServico(1);
            } else {
                configuracao.setControlaEstoqueServico(0);
            }
        } catch (Exception ex) {
            configuracao.setControlaEstoqueServico(0);
        }

        try {
            configuracao.setCalcComissao(jCheckBox20.isSelected() ? 0 : 1);
        } catch (Exception ex) {
        }

        try {
            configuracao.setTipoComissao(jRadioButton11.isSelected() ? 0 : 1);
        } catch (Exception ex) {
        }

        configuracao.setTipoCusteio(jCheckBox21.isSelected() ? 1 : 0);

        configuracao.setDescontoMaximoGrupo(jCheckBox17.isSelected() ? 1 : 0);

        new Controller().ControllerPersistMerge(Configuracao.class, configuracao);

        //list.set(0, configuracao.getEmpresa());
        return configuracao;
    }

    private bd.DAO.Empresa SalvaEmpresa() throws Exception {
        EMPRESA.setNomeEmpresa(jTextField_razao_social1.getText().toUpperCase());
        EMPRESA.setFantasiaEmpresa(jTextField_nome_fantazia1.getText().toUpperCase());
        EMPRESA.setCnpjEmpresa(jTextField4.getText());
        EMPRESA.setIeEmpresa(jTextField5.getText());
        EMPRESA.setImEmpresa(jTextField6.getText());
        EMPRESA.setCepEmpresa(jTextField7.getText().replace("-", "").replace(".", ""));
        EMPRESA.setEnderecoEmpresa(jTextField_endereco.getText());
        EMPRESA.setNumeroEmpresa(jTextField_numero_endereco1.getText());
        EMPRESA.setBairroEmpresa(jTextField8.getText());
        EMPRESA.setComplemento(jTextField8.getText());
        EMPRESA.setCodigoUf(Integer.parseInt(jTextField2.getText()));
        EMPRESA.setUfEmpresa(jTextField3.getText());
        EMPRESA.setEmail(jTextField14.getText());
        EMPRESA.setExibirCodigoProduto(jRadioButton3.isSelected() ? 0 : 1);
        EMPRESA.setSmtp(jTextField35.getText());
        EMPRESA.setPorta(jTextField36.getText());
        EMPRESA.setEmail2(jTextField37.getText());
        EMPRESA.setEmissaoBoleto(jCheckBox1.isSelected() ? 1 : 0);
        EMPRESA.setGasGlp(jCheckBox15.isSelected() ? 1 : 0);
        EMPRESA.setPrestadorServico(jCheckBox16.isSelected() ? 1 : 0);
        EMPRESA.setAtividade(jComboBox4.getSelectedItem().toString());
        EMPRESA.setEmissaoPromissoria(jCheckBox13.isSelected() ? 1 : 0);

        if (!jTextField9.getText().isEmpty()) {
            HashMap filtro = new HashMap();
            filtro.put("codigo", Integer.parseInt(jTextField9.getText().trim()));
            List<CidadeCodigo> codcidadeList = (List<CidadeCodigo>) new Controller().ControllerFindByCodId(CidadeCodigo.class, filtro);
            if (codcidadeList.isEmpty()) {
                throw new Exception("A cidade informada é inválida.");
            } else {
                EMPRESA.setCodigoMunicipio(codcidadeList.get(0));
            }
        } else {
            throw new Exception("A cidade informada é inválida.");
        }

        if (jTextField13.getText().length() == 10 || jTextField13.getText().length() == 11) {
            EMPRESA.setTelefone(jTextField13.getText());
        } else {
            throw new Exception("O telefone informado é inválido.");
        }

        if (jPasswordField1.getText().equals(jPasswordField2.getText())) {
            EMPRESA.setSenhaEmail(jPasswordField1.getText());
        } else {
            JOptionPane.showMessageDialog(null, "As senhas informada para o E-mail são diferente.", "Erro ao validar senha", 0);
            throw new IllegalStateException("As senhas informada para o E-mail são diferente.");
        }

        new Controller().ControllerPersistMerge(Empresa.class, EMPRESA);

        return EMPRESA;
    }

    public bd.DAO.Contabilista SalvarContabilista() throws Exception {

        bd.DAO.Contabilista contabilista = EMPRESA.getContabilista();
        try {
            try {
                if (contabilista == null) {
                    contabilista = new Contabilista();
                    EMPRESA.setContabilista(contabilista);
                }
            } catch (NullPointerException e) {
                contabilista = new Contabilista();
                EMPRESA.setContabilista(contabilista);
            }
            contabilista.setNomeContabilista(jTextField38.getText().toUpperCase());

            if (!jTextField39.getText().isEmpty() && jTextField39.getText().length() == 11) {
                if (Biblioteca.validaCpfCnpj(jTextField39.getText())) {
                    contabilista.setCpfContabilista(jTextField39.getText());
                } else {
                    JOptionPane.showMessageDialog(null, "Informe um CPF válido para o contador.", "Contador", 0);
                    throw new IllegalStateException("Informe um CPF válido para o contador");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Informe um CPF válido para o contador.", "Contador", 0);
                throw new IllegalStateException("Informe um CPF válido para o contador");
            }

            if (!jTextField40.getText().isEmpty() && jTextField40.getText().length() == 14) {
                if (Biblioteca.validaCpfCnpj(jTextField40.getText())) {
                    contabilista.setCnpjContabilista(jTextField40.getText());
                } else {
                    JOptionPane.showMessageDialog(null, "Informe um CNPJ válido para o contador.", "Contador", 0);
                    throw new IllegalStateException("Informe um CNPJ válido para o contador");
                }
            }

            if (!jTextField41.getText().isEmpty()) {
                contabilista.setInscCrc(jTextField41.getText());
            } else {
                JOptionPane.showMessageDialog(null, "Informe um número de CRC válido para o contador.", "Contador", 0);
                throw new IllegalStateException("Informe um CRC válido para o contador");
            }

            HashMap filtro = new HashMap();
            filtro.put("cep", jTextField42.getText());
            List<Cep> listCep = (List<Cep>) new Controller().ControllerFindByCodId(Cep.class, filtro);
            if (listCep == null ? false : !listCep.isEmpty()) {
                contabilista.setCep(listCep.get(0));
            } else {
                contabilista.setCep(null);
            }

            contabilista.setLogradouro(jTextField43.getText());
            contabilista.setNumero(jTextField44.getText());
            contabilista.setComplemento(jTextField45.getText());
            contabilista.setBairro(jTextField46.getText());
            contabilista.setTelefone(jTextField47.getText());
            contabilista.setFax(jTextField48.getText());
            if (!jTextField49.getText().isEmpty()) {
                if (jTextField49.getText().contains("@")) {
                    contabilista.setEmail(jTextField49.getText());
                } else {
                    JOptionPane.showMessageDialog(null, "Informe um número de E-MAIL válido para o contador.", "Contador", 0);
                    throw new IllegalStateException("Informe um E-MAIL válido para o contador");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Informe um número de E-MAIL válido para o contador.", "Contador", 0);
                throw new IllegalStateException("Informe um E-MAIL válido para o contador");
            }

            try {
                CidadeCodigo cidade = new Controller().ControllerFind(CidadeCodigo.class, Integer.parseInt(jTextField50.getText()));
                contabilista.setCodigoCidade(String.valueOf(cidade.getCodigo()));
                contabilista.setCidade(cidade.getNome());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(rootPane, "Verifique a cidade do contador antes de continuar.", "", 0);
            }
            new Controller().ControllerPersistMerge(Contabilista.class, contabilista);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(JIFEmpresa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return contabilista;
    }

    private void setValueTableDescontoGrupo(GupoProduto grupo) {
        DefaultTableModel modelTableGrupoDesconto = (DefaultTableModel) jTable7.getModel();
        modelTableGrupoDesconto.setNumRows(jTable7.getRowCount() + 1);
        jTable7.setModel(modelTableGrupoDesconto);
        JMoneyField money = new JMoneyField();
        money.setText(grupo.getDesconto().toString());
        jTable7.setValueAt(grupo.getDescricaoGrupo(), jTable7.getRowCount() - 1, 0);
        jTable7.setValueAt(money.getText(), jTable7.getRowCount() - 1, 1);
        jTable7.setValueAt(grupo, jTable7.getRowCount() - 1, 2);
    }

    private void createTables() {
        modelTableSimplesNacional = new DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Impostos",
                    "Valor",
                    "Tipo",
                    "obj"
                }
        ) {
            Class[] types = new Class[]{
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                bd.DAO.AliquotaSimplesNacional.class
            };
            boolean[] canEdit = new boolean[]{
                false,
                false,
                false,
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
        jTable6.setModel(modelTableSimplesNacional);
        jTable6.getColumnModel().getColumn(3).setMinWidth(0);
        jTable6.getColumnModel().getColumn(3).setPreferredWidth(0);
        jTable6.getColumnModel().getColumn(3).setMaxWidth(0);

        modelTableFormaPagamento = new DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Forma de pagamento"
                }
        ) {
            Class[] types = new Class[]{
                Object.class
            };
            boolean[] canEdit = new boolean[]{
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
        jTable1.setModel(modelTableFormaPagamento);

        modelTableFormaPagamentoAvista = new DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Forma de pagamento",}
        ) {
            Class[] types = new Class[]{
                Object.class
            };
            boolean[] canEdit = new boolean[]{
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
        jTable5.setModel(modelTableFormaPagamentoAvista);

        modelTableFormaPagamento2 = new DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Forma de pagamento"
                }
        ) {
            Class[] types = new Class[]{
                Object.class
            };
            boolean[] canEdit = new boolean[]{
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
        jTable4.setModel(modelTableFormaPagamento2);

        modelTableFormaPagamento3 = new DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Forma de pagamento", "Tipo", "Em", "Remcebimento", ""
                }
        ) {
            Class[] types = new Class[]{
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, Object.class
            };
            boolean[] canEdit = new boolean[]{
                false, false, false, false,false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
        jTable3.setModel(modelTableFormaPagamento3);

        DefaultTableModel modelTableGrupoDesconto = new DefaultTableModel(
                new String[]{
                    "Grupo",
                    "Desconto (%)",
                    ""
                }, 0
        ) {
            Class[] types = new Class[]{
                java.lang.String.class,
                java.lang.String.class,
                GupoProduto.class
            };
            boolean[] canEdit = new boolean[]{
                false,
                false,
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
        jTable7.setModel(modelTableGrupoDesconto);

        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {
                    return;
                }
                int selected = jTable1.getSelectedRow();
                if (selected != -1) {
                    try {
                        buscaBanco(EMPRESA.getTipoPagamentoBoleto().get(selected).getCodigoBanco());
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(rootPane, "Houve um erro ao consultar a conta bancária.\nVerifica se as forma de pagamento destinada a emissão de boleto tem um conta bancária parametrizada.");
                        System.err.println(ex);
                    }
                }
            }
        });

        jTable2.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {
                    return;
                }
                int selected = jTable2.getSelectedRow();
                if (selected != -1) {

                }
            }
        });

        jTable3.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {
                    return;
                }
                int selected = jTable3.getSelectedRow();
                if (selected != -1) {
                    bd.DAO.TipoPagamento tipoPagamento = (bd.DAO.TipoPagamento) jTable3.getValueAt(jTable3.getSelectedRow(), 0);
                    DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
                    model.setNumRows(0);
                    jTable2.setModel(model);
                    for (int i = 0; i < tipoPagamento.getConfigTaxaCartaoList().size(); i++) {
                        model = (DefaultTableModel) jTable2.getModel();
                        model.setNumRows(jTable2.getRowCount() + 1);
                        jTable2.setModel(model);

                        try {
                            jTable2.setValueAt(
                                    tipoPagamento.getConfigTaxaCartaoList().get(i).getAPrazo() == 1 ? "A prazo" : "A vista",
                                    jTable2.getRowCount() - 1, 0);
                        } catch (NullPointerException exx) {
                            jTable2.setValueAt(
                                    "A vista",
                                    jTable2.getRowCount() - 1, 0);
                        } catch (Exception ex) {
                        }

                        try {
                            jTable2.setValueAt(
                                    jComboBox5.getModel().getElementAt(tipoPagamento.getConfigTaxaCartaoList().get(i).getTipoIncidencia()),
                                    i, 1);
                        } catch (Exception ex) {
                        }

                        try {
                            jTable2.setValueAt(tipoPagamento.getConfigTaxaCartaoList().get(i).getDescricao(), i, 2);
                        } catch (Exception ex) {
                        }

                        try {
                            JMoneyField field = new JMoneyField();
                            field.setText(tipoPagamento.getConfigTaxaCartaoList().get(i).getValor().toString());
                            jTable2.setValueAt(field.getText(), i, 3);
                        } catch (Exception ex) {
                        }

                        try {
                            jTable2.setValueAt(tipoPagamento.getConfigTaxaCartaoList().get(i).getId(), i, 5);
                        } catch (Exception ex) {
                        }
                    }
                }
            }
        });
    }
}
