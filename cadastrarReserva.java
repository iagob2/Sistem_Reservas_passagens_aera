package Sistema;
 
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
 
public class cadastrarReserva {
 
    private JFrame frame;
    private Voo voo;
    private JLabel mensagemLabel;
    private JRadioButton buttonSP; // Declare como campos de classe
    private JRadioButton buttonRJ;
    private JRadioButton buttonPG;
 
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    cadastrarReserva window = new cadastrarReserva();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
 
    public cadastrarReserva() {
        initialize();
        // Remova a criação do objeto Voo no construtor
    }
 
    private void initialize() {
        frame = new JFrame();
        frame.setBackground(new Color(255, 255, 255));
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
 
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 436, 263);
        frame.getContentPane().add(panel);
        panel.setLayout(null);
 
        JLabel lblNewLabel = new JLabel("Escolha seu voo:");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel.setBounds(146, 10, 133, 34);
        panel.add(lblNewLabel);
 
        JButton btnNewButton = new JButton("Realizar Reserva");
        btnNewButton.setBackground(Color.GREEN);
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                realizarReserva();
                
            }
            
        });
        btnNewButton.setBounds(159, 215, 133, 21);
        panel.add(btnNewButton);
 
        buttonSP = new JRadioButton("São Paulo"); // Inicialize aqui
        buttonSP.setFont(new Font("Tahoma", Font.PLAIN, 12));
        buttonSP.setBounds(159, 79, 103, 21);
        panel.add(buttonSP);
 
        buttonRJ = new JRadioButton("Rio de Janeiro");
        buttonRJ.setFont(new Font("Tahoma", Font.PLAIN, 12));
        buttonRJ.setBounds(159, 102, 103, 21);
        panel.add(buttonRJ);
 
        buttonPG = new JRadioButton("Praia Grande");
        buttonPG.setFont(new Font("Tahoma", Font.PLAIN, 12));
        buttonPG.setBounds(159, 129, 103, 21);
        panel.add(buttonPG);
 
        // Agrupe os botões de rádio
        ButtonGroup group = new ButtonGroup();
        group.add(buttonSP);
        group.add(buttonRJ);
        group.add(buttonPG);
 
        // Adicione um JLabel para exibir a mensagem
        mensagemLabel = new JLabel("");
        mensagemLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        mensagemLabel.setBounds(159, 160, 300, 21);
        panel.add(mensagemLabel);
    }
    
    
 
    private void realizarReserva() {
        // Verifica qual destino foi selecionado
        String destinoSelecionado = null;
        if (buttonSP.isSelected()) {
            destinoSelecionado = "São Paulo";
        } else if (buttonRJ.isSelected()) {
            destinoSelecionado = "Rio de Janeiro";
        } else if (buttonPG.isSelected()) {
            destinoSelecionado = "Praia Grande";
        }
        
        try (Connection conexao = Conexao.obterConexao()) {
            if (conexao != null) {
                if (destinoSelecionado != null) {
                    String query = "INSERT INTO Reservas (numero_voo, origem, destino, assentos_disponiveis) VALUES (?, ?, ?, ?)";
                    try (PreparedStatement ps = conexao.prepareStatement(query)) {
                        ps.setString(1, "abc56");
                        ps.setString(2, "Santos");
                        ps.setString(3, destinoSelecionado);
                        ps.setInt(4, 40);
                        ps.executeUpdate();
                        
                        mensagemLabel.setText("Reserva realizada com sucesso!");
                    }
                } else {
                    mensagemLabel.setText("Por favor, selecione um destino.");
                }
            } else {
                mensagemLabel.setText("Erro ao conectar ao banco de dados.");
            }
        } catch (SQLException ex) {
            mensagemLabel.setText("Erro ao realizar a reserva.");
            ex.printStackTrace();
        }
        
        
        
        Voo voo = new Voo("abc56",1,0,40);
 
        // Recupera o voo correspondente ao destino selecionado
        if (destinoSelecionado != null) {
            String destino = voo.getDestino();
 
 
            // Realiza a reserva se houver assentos disponíveis
            if (destino != null && voo.getAssentosDisponiveis() > 0) {
                voo.realizarReserva();
                mensagemLabel.setText("Reserva realizada com sucesso!");
            } else {
                mensagemLabel.setText("Desculpe, não há assentos disponíveis para este voo.");
            }
        } else {
            mensagemLabel.setText("Por favor, selecione um destino.");
        }
        
        dispose(); // Fecha a tela atual

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Pagamento pagamento = new Pagamento();
                pagamento.setVisible(true);
            }
        });
    }

	private void dispose() {
		// TODO Auto-generated method stub
		
	}
 
   
}
