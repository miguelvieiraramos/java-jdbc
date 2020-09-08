package br.unisul;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

public class InsertExample {

	public static void main(String[] args) {
		String nome = JOptionPane.showInputDialog("Nome: ");
		addUsuario(nome);
		JOptionPane.showMessageDialog(null, "O usuário " + nome + " foi inserido.");
	}
	
	public static void addUsuario(String nome) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = DatabaseService.getConnPostgres();
			ps = conn.prepareStatement("INSERT INTO usuario(nome) VALUES(?)");
			ps.setString(1, nome);
			ps.execute();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null) {
					ps.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
