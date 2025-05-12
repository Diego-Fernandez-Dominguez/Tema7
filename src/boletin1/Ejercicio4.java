package boletin1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio4 {
	public static void main(String[] args) {

		String conexion = "jdbc:mysql://localhost/institutodb";
		String usuario = "root";
		String password = "DiegoSQL123";

		String nombre;
		int id;
		int año;

		try (Connection con = DriverManager.getConnection(conexion, usuario, password)) {
			System.out.println("La conexion ha ido perfe");

			Statement st = con.createStatement();

			st.executeUpdate("insert into Cursos(id_curso, nombre, año_escolar) values (4, 'Historia 1º', 2025)");
			st.executeUpdate("insert into Cursos(id_curso, nombre, año_escolar) values (5, 'Biología 1º', 2025)");
			st.executeUpdate(
					"insert into Cursos(id_curso, nombre, año_escolar) values (6, 'Educación Física 1º', 2025)");
			st.executeUpdate("insert into Cursos(id_curso, nombre, año_escolar) values (7, 'Música 1º', 2025)");
			st.executeUpdate("insert into Cursos(id_curso, nombre, año_escolar) values (8, 'Tecnología 1º', 2025)");

			System.out.println("\nDatos de Cursos:");

			ResultSet rs = st.executeQuery("SELECT * FROM Cursos");

			while (rs.next()) {
				id = rs.getInt("id_curso");
				nombre = rs.getString("nombre");
				año = rs.getInt("año_escolar");

				System.out.println("ID: " + id + ", Nombre: " + nombre + ", Año Escolar: " + año);
			}

		} catch (SQLException e) {
			System.err.println("Error: " + e);
		}
	}
}
