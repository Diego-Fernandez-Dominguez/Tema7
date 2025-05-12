package boletin1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio9 {
	public static void main(String[] args) {

		String conexion = "jdbc:mysql://localhost/institutodb";
		String usuario = "root";
		String password = "DiegoSQL123";

		String fechaNacimiento;
		String nombre;

		try (Connection con = DriverManager.getConnection(conexion, usuario, password)) {
			System.out.println("La conexion ha ido perfe");

			Statement st = con.createStatement();

			// Mostrar los datos de la tabla "Estudiantes"
			System.out.println("\nDatos de Estudiantes:");
			ResultSet rs = st.executeQuery("SELECT * FROM Estudiantes");

			while (rs.next()) {
				nombre = rs.getString("nombre");
				fechaNacimiento = rs.getString("fecha_nacimiento");

				System.out.println("Nombre: " + nombre + ", Fecha Nacimiento: " + fechaNacimiento);
			}

		} catch (SQLException e) {
			System.err.println("Error: " + e);
		}
	}

}
