package br.unisul;
import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseService {
	public static Connection getConnPostgres() {
		Connection conn = null;
		
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tutorial", "miguel", "senha");
		} catch(Exception e) {
			System.err.println(e);
		}
		
		return conn;
	}
}
