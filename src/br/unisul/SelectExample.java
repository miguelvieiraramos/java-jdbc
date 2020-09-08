package br.unisul;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;

public class SelectExample {

	public static void main(String[] args) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			conn = DatabaseService.getConnPostgres();
			st = conn.createStatement();
			rs = st.executeQuery("SELECT * FROM usuario");
			
			while(rs.next()) {
				int idUsuario = rs.getInt(1);
				String nomeUsuario = rs.getString(2);
				System.out.println(idUsuario + "\n" + nomeUsuario);
			}
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				
				if (st != null) {
					st.close();
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
