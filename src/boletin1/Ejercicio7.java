package boletin1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Ejercicio7 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		String conexion = "jdbc:mysql://localhost/institutodb";
		String usuario = "root";
		String password = "DiegoSQL123";

		int id = 0;
		String nombre = "";
		String apellido = "";
		String fecha = "";
		String email = "";
		String telefono = "";

		String consulta = "insert into estudiantes (nombre, apellido, fecha_nacimiento, email, telefono) values (?, ?, ?, ?, ?)";

		try (Connection con = DriverManager.getConnection(conexion, usuario, password)) {

			System.out.println("Digame el nombre del susodicho");
			nombre = sc.nextLine();

			System.out.println("Digame tambien su apellido");
			apellido = sc.nextLine();

			System.out.println("¿Y cuando nacio?");
			fecha = sc.nextLine();

			System.out.println("Y donde le puedo enviar un correo");
			email = sc.nextLine();

			System.out.println("Y si quiero llamarle al telefono como lo hago");
			telefono = sc.nextLine();

			PreparedStatement st = con.prepareStatement(consulta);
			st.setString(1, nombre);
			st.setString(2, apellido);
			st.setString(3, fecha);
			st.setString(4, email);
			st.setString(5, telefono);
			
			id = st.executeUpdate();

			System.out.println("\nDatos de Estudiantes:");
			ResultSet rs = st.executeQuery("SELECT * FROM Estudiantes");

			while (rs.next()) {
				id = rs.getInt("id_estudiante");
				nombre = rs.getString("nombre");
				apellido = rs.getString("apellido");
				fecha = rs.getString("fecha_nacimiento");
				email = rs.getString("email");
				telefono = rs.getString("telefono");

				System.out.println("ID: " + id + ", Nombre: " + nombre + ", Apellido: " + apellido
						+ ", Fecha Nacimiento: " + fecha + ", Email: " + email + ", Teléfono: " + telefono);
			}

		} catch (SQLException e) {
			System.err.println("Error: " + e);
		}

	}

}
