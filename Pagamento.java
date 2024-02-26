package Sistema;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Pagamento extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextArea mensagemLabel;
    private JRadioButton ida;
    private JRadioButton IdaEVolta;
    private int op;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Pagamento frame = new Pagamento();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Pagamento() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(null);

        setContentPane(contentPane);
        contentPane.setLayout(null);
        JLabel lblNewLabel = new JLabel("Escolha a forma de Pagamento");
        lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel.setBounds(58, 16, 309, 32);
        contentPane.add(lblNewLabel);
        JRadioButton rdbtnNewRadioButton = new JRadioButton("Débito");
        rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
        rdbtnNewRadioButton.setBounds(69, 168, 61, 23);
        contentPane.add(rdbtnNewRadioButton);
        JRadioButton rdbtnCrdito = new JRadioButton("Crédito");
        rdbtnCrdito.setFont(new Font("Tahoma", Font.PLAIN, 12));
        rdbtnCrdito.setBounds(168, 168, 65, 23);
        contentPane.add(rdbtnCrdito);
        JRadioButton rdbtnDinheiro = new JRadioButton("Dinheiro");
        rdbtnDinheiro.setFont(new Font("Tahoma", Font.PLAIN, 12));
        rdbtnDinheiro.setBounds(277, 168, 69, 23);
        contentPane.add(rdbtnDinheiro);
        JButton Button = new JButton("Avançar");
        Button.setFont(new Font("Tahoma", Font.BOLD, 12));
        Button.setBounds(168, 218, 89, 32);
        contentPane.add(Button);

        mensagemLabel = new JTextArea();
        mensagemLabel.setBounds(249, 94, 118, 32);
        contentPane.add(mensagemLabel);

        JLabel lblNewLabel_1 = new JLabel("valor:");
        lblNewLabel_1.setBounds(203, 99, 38, 14);
        contentPane.add(lblNewLabel_1);

        ida = new JRadioButton("somente ida");
        ida.setFont(new Font("Tahoma", Font.PLAIN, 12));
        ida.setBounds(58, 55, 98, 23);
        contentPane.add(ida);

        IdaEVolta = new JRadioButton("ida e volta");
        IdaEVolta.setFont(new Font("Tahoma", Font.PLAIN, 12));
        IdaEVolta.setBounds(58, 88, 98, 23);
        contentPane.add(IdaEVolta);

        ButtonGroup group = new ButtonGroup();
        group.add(ida);
        group.add(IdaEVolta);
        
        JButton bt1 = new JButton("calcular");
        bt1.setFont(new Font("Tahoma", Font.BOLD, 12));
        bt1.setBounds(248, 59, 98, 23);
        contentPane.add(bt1);
        
        bt1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Calcular();
            }
        });

        Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                realizarPagamento();
            }
        });
    }
    
    public void Calcular() {
    	if (ida.isSelected()) {
            op = 1;
        } else if (IdaEVolta.isSelected()) {
            op = 2;
        }

    	Voo voo = new Voo("adc569", 0, 1, 20);
    	String valor = String.valueOf(voo.realizarPagamento(op));
        mensagemLabel.setText(valor);
    }
    
    

    private void realizarPagamento() {
        System.out.println("pagamento");

        // Adiciona uma verificação se o valor foi calculado antes de prosseguir
        if (mensagemLabel.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, calcule o valor antes de avançar.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        // Obtém informações para o pagamento
        String numeroVoo = "abc56"; // Exemplo, você deve obter o número do voo de alguma forma
        String formaPagamento = ""; // Adapte para obter a forma de pagamento selecionada
        double valorPagamento = Double.parseDouble(mensagemLabel.getText());

        // Insere informações na tabela Pagamentos
        try (Connection conexao = Conexao.obterConexao()) {
            String query = "INSERT INTO Pagamentos (numero_voo, forma_pagamento, valor) VALUES (?, ?, ?)";
            try (PreparedStatement ps = conexao.prepareStatement(query)) {
                ps.setString(1, numeroVoo);
                ps.setString(2, formaPagamento);
                ps.setDouble(3, valorPagamento);
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao registrar o pagamento.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        dispose(); // Fecha a tela atual

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ImprimirPassagem imprimirPassagem = new ImprimirPassagem();
                imprimirPassagem.setVisible(true);
            }
        });
    }
}