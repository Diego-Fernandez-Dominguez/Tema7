package boletin1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio2 {
	public static void main(String[] args) {

		String conexion = "jdbc:mysql://localhost/institutodb";
		String usuario = "root";
		String password = "DiegoSQL123";

		String telefono;
		String email;
		String fechaNacimiento;
		String apellido;
		String nombre;
		String especialidad;
		int id;
		int año;

		try (Connection con = DriverManager.getConnection(conexion, usuario, password)) {
			System.out.println("La conexion ha ido perfe");

			Statement st = con.createStatement();

			st.executeUpdate("update Estudiantes set telefono = '987654321' where id_estudiante = 4");

			st.executeUpdate("update Profesores set especialidad = 'Rasca-Pelotas' where id_profesor = 4");

			st.executeUpdate(
					"update Cursos set descripcion = 'Casi me echan del trabajo, es un curso de informatica, perdon jefe :(' where id_curso = 4");

			// Mostrar los datos de la tabla "Estudiantes"
			System.out.println("\nDatos de Estudiantes:");
			ResultSet rs = st.executeQuery("SELECT * FROM Estudiantes");

			while (rs.next()) {
				id = rs.getInt("id_estudiante");
				nombre = rs.getString("nombre");
				apellido = rs.getString("apellido");
				fechaNacimiento = rs.getString("fecha_nacimiento");
				email = rs.getString("email");
				telefono = rs.getString("telefono");

				System.out.println("ID: " + id + ", Nombre: " + nombre + ", Apellido: " + apellido
						+ ", Fecha Nacimiento: " + fechaNacimiento + ", Email: " + email + ", Teléfono: " + telefono);
			}

			System.out.println("\nDatos de Profesores:");

			rs = st.executeQuery("SELECT * FROM Profesores");

			while (rs.next()) {
				id = rs.getInt("id_profesor");
				nombre = rs.getString("nombre");
				apellido = rs.getString("apellido");
				especialidad = rs.getString("especialidad");
				email = rs.getString("email");

				System.out.println("ID: " + id + ", Nombre: " + nombre + ", Apellido: " + apellido + ", Especialidad: "
						+ especialidad + ", Email: " + email);
			}

			System.out.println("\nDatos de Cursos:");

			rs = st.executeQuery("SELECT * FROM Cursos");

			while (rs.next()) {
				id = rs.getInt("id_curso");
				nombre = rs.getString("nombre");
				apellido = rs.getString("descripcion");
				año = rs.getInt("año_escolar");

				System.out.println(
						"ID: " + id + ", Nombre: " + nombre + ", Descripción: " + apellido + ", Año Escolar: " + año);
			}

		} catch (SQLException e) {
			System.err.println("Error: " + e);
		}
	}
}
