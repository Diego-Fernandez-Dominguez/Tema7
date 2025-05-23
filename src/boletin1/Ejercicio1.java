package boletin1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio1 {
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

			// Inserto un estudiante
			st.executeUpdate(
					"insert into Estudiantes(id_estudiante, nombre, apellido, fecha_nacimiento, email, telefono) values (4, 'Euseboi', 'Jimenez', '2004-03-12', 'euseboielmejor@gmail.com', '123456789')");

			// Inserto un profesor
			st.executeUpdate(
					"insert into Profesores(id_profesor, nombre, apellido, especialidad, email) values (4, 'Antonio', 'Manuela', 'Toca-Huevos', 'antonio.manuela@iessarampion.com')");

			// Inserto un curso
			st.executeUpdate(
					"insert into Cursos(id_curso, nombre, descripcion, año_escolar) values (4, 'CursoToGuapo', 'Curso en el que te enseñamos a hacer tortitas', 2025)");

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
