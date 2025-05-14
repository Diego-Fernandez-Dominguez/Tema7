package boletin1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ejercicio10 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		String conexion = "jdbc:mysql://localhost/institutodb";
		String usuario = "root";
		String password = "DiegoSQL123";

		String fechaNacimiento;
		String nombre;
		int id = 0;

		try (Connection con = DriverManager.getConnection(conexion, usuario, password)) {

			Statement st = con.createStatement();
			Statement st2 = con.createStatement();
			Statement st3 = con.createStatement();

			System.out.println("Dime el nombre del curso: ");
			nombre = sc.nextLine();

			ResultSet rs1 = st.executeQuery("SELECT id_curso FROM Cursos where nombre = '" + nombre + "'");

			while (rs1.next()) {

				id = rs1.getInt("id_curso");

			}
			
			ResultSet rs2 = st2.executeQuery("SELECT id_estudiante FROM matriculas where id_curso = " + id);
			
			while (rs2.next()) {

				id = rs2.getInt("id_estudiante");

				ResultSet rs3 = st3.executeQuery("SELECT * FROM estudiantes where id_estudiante = " + id);

				while (rs3.next()) {
					nombre = rs3.getString("nombre");
					fechaNacimiento = rs3.getString("fecha_nacimiento");

					System.out.println("Nombre: " + nombre + ", Fecha: " + fechaNacimiento);

				}
			}

		} catch (SQLException e) {
			System.err.println("Error: " + e);
		}
	}

}
