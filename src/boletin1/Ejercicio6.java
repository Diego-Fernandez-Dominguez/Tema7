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

		int idEst = 0;
		int idCur = 0;

		try (Connection con = DriverManager.getConnection(conexion, usuario, password)) {
			System.out.println("La conexion ha ido perfe");

			Statement st = con.createStatement();

			ResultSet rs = st
					.executeQuery("SELECT id_estudiante FROM estudiantes where nombre = 'Ana' and apellido='González'");

			while (rs.next()) {
				idEst = rs.getInt("id_estudiante");
			}

			rs = st.executeQuery("SELECT id_curso FROM cursos where nombre = 'Matemáticas 1º'");

			while (rs.next()) {
				idCur = rs.getInt("id_curso");
			}

			rs = st.executeQuery("SELECT * FROM calificaciones");

			st.executeUpdate("update Calificaciones set nota = nota + 1 where id_estudiante = " + idEst
					+ " and id_curso = " + idCur);

		} catch (SQLException e) {
			System.err.println("Error: " + e);
		}
	}

}
