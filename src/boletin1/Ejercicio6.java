package boletin1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio6 {
	public static void main(String[] args) {

		String conexion = "jdbc:mysql://localhost/institutodb";
		String usuario = "root";
		String password = "DiegoSQL123";

		int id=0;

		try (Connection con = DriverManager.getConnection(conexion, usuario, password)) {
			System.out.println("La conexion ha ido perfe");

			Statement st = con.createStatement();

			st.executeUpdate("update Estudiantes set telefono = '987654321' where id_estudiante = 4");

			ResultSet rs = st.executeQuery("SELECT id_estudiante FROM estudiantes where nombre = 'Ana' and apellido='González'");

			while (rs.next()) {
				id = rs.getInt("id_estudiante");
			}
			
			System.out.println(id);

		} catch (SQLException e) {
			System.err.println("Error: " + e);
		}
	}

}
