package boletin1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ejercicio8 {

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

		try (Connection con = DriverManager.getConnection(conexion, usuario, password)) {

			System.out.println("Digame el id");
			id = sc.nextInt();

			Statement st = con.createStatement();

			st.executeUpdate("delete from estudiantes where id_estudiante = " + id);

			ResultSet rs = st.executeQuery("select * from estudiantes");

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
