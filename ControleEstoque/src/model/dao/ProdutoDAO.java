package model.dao;

import connection.ConnectionFactory;
import modal.bean.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ProdutoDAO {

	public void create (Produto p) {
		
		Connection con = ConnectionFactory.conectar();
		PreparedStatement stmt = null;
		
		//preparando sql para insert
		try {
			stmt = con.prepareStatement("INSERT INTO produto (descricao,qtd,preco) VALUES (?,?,?)");
			stmt.setString(1, p.getDescricao());
			stmt.setInt(2, p.getQtd());
			stmt.setDouble(3, p.getPreco());
			
			stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar!");
			e.printStackTrace();
		}
				
	}
	
	
	
	
}
