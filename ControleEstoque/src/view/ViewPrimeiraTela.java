package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modal.bean.Produto;
import model.dao.ProdutoDAO;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;

public class ViewPrimeiraTela extends JFrame {

	private JPanel contentPane;
	private JTextField txtDesc;
	private JLabel JlabelPass;
	private JTextField txtQtd;
	private JLabel lblNewLabel;
	private JTextField txtPreco;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewPrimeiraTela frame = new ViewPrimeiraTela();
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
	public ViewPrimeiraTela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLogar = new JButton("Cadastrar");
		btnLogar.setForeground(Color.BLACK);
		btnLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Produto p = new Produto();
				ProdutoDAO dao = new ProdutoDAO();
				p.setDescricao(txtDesc.getText());
				p.setQtd(Integer.parseInt(txtQtd.getText()));
				p.setPreco(Double.parseDouble(txtPreco.getText()));
				dao.create(p);
				
			}
		});
		btnLogar.setBounds(152, 107, 119, 23);
		contentPane.add(btnLogar);
		
		txtDesc = new JTextField();
		txtDesc.setBounds(10, 36, 155, 20);
		contentPane.add(txtDesc);
		txtDesc.setColumns(10);
		
		JLabel JLabel = new JLabel("Produto");
		JLabel.setBounds(10, 11, 46, 14);
		contentPane.add(JLabel);
		
		JlabelPass = new JLabel("Quantidade");
		JlabelPass.setBounds(183, 11, 88, 14);
		contentPane.add(JlabelPass);
		
		txtQtd = new JTextField();
		txtQtd.setBounds(183, 36, 58, 20);
		contentPane.add(txtQtd);
		txtQtd.setColumns(10);
		
		lblNewLabel = new JLabel("Pre\u00E7o");
		lblNewLabel.setBounds(287, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		txtPreco = new JTextField();
		txtPreco.setBounds(287, 36, 86, 20);
		contentPane.add(txtPreco);
		txtPreco.setColumns(10);
	}
}
