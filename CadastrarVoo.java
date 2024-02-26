package Sistema;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CadastrarVoo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField caixa01;
	private JTextField caixa02;
	private JTextField caixa03;
	private JTextField caixa04;
	private JLabel texto03;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarVoo frame = new CadastrarVoo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CadastrarVoo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 483, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastrar Voo:");
		lblNewLabel.setBounds(172, 11, 95, 14);
		contentPane.add(lblNewLabel);
		
		JLabel texto01 = new JLabel("numeroVoo:");
		texto01.setBounds(67, 36, 114, 14);
		contentPane.add(texto01);
		
		caixa01 = new JTextField();
		caixa01.setBounds(191, 36, 109, 20);
		contentPane.add(caixa01);
		caixa01.setColumns(10);
		
		JLabel texto02 = new JLabel("Numero da Origem:");
		texto02.setBounds(67, 61, 114, 14);
		contentPane.add(texto02);
		
		caixa02 = new JTextField();
		caixa02.setBounds(191, 59, 109, 20);
		contentPane.add(caixa02);
		caixa02.setColumns(10);
		
		texto03 = new JLabel("Numero da Destino:");
		texto03.setBounds(67, 86, 114, 14);
		contentPane.add(texto03);
		
		caixa03 = new JTextField();
		caixa03.setBounds(191, 84, 109, 20);
		contentPane.add(caixa03);
		caixa03.setColumns(10);
		
		JLabel texto04 = new JLabel("AssentosDisponiveis");
		texto04.setBounds(67, 111, 114, 14);
		contentPane.add(texto04);
		
		caixa04 = new JTextField();
		caixa04.setBounds(191, 109, 109, 20);
		contentPane.add(caixa04);
		caixa04.setColumns(10);
		
		JButton Button = new JButton("Cadastrar");
		Button.setBounds(158, 162, 109, 23);
		contentPane.add(Button);
		
		// Adicionando um ouvinte de eventos ao botão
        Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Recuperando os valores dos campos de texto
            	String numeroVoo = caixa01.getText();
                int numeroOrigem = Integer.parseInt(caixa02.getText());
                int numeroDestino = Integer.parseInt(caixa03.getText());
                int assentosDisponiveis = Integer.parseInt(caixa04.getText());

                // Chamando o objeto para cadastrar o voo
             // Criando um novo objeto Voo com os valores dos campos de texto
                Voo novoVoo = new Voo(numeroVoo, numeroOrigem, numeroDestino, assentosDisponiveis);
                
                System.out.println("Voo cadastrado com sucesso!");
            }
        });
	}
}