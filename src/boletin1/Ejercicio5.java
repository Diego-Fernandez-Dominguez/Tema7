package boletin1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio5 {
	public static void main(String[] args) {

		String conexion = "jdbc:mysql://localhost/institutodb";
		String usuario = "root";
		String password = "DiegoSQL123";

		int idCal;
		int idEst;
		int idCur;
		int idPro;
		String tipoEva;
		double nota;
		String fecha;

		try (Connection con = DriverManager.getConnection(conexion, usuario, password)) {
			System.out.println("La conexion ha ido perfe");

			Statement st = con.createStatement();

			st.executeUpdate(
					"insert into Calificaciones(id_calificacion, id_estudiante, id_curso, id_profesor, tipo_evaluacion, nota, fecha_evaluacion) values(4,3,3,4,'Examen',3.5 ,'2024-12-12')");

		} catch (SQLException e) {
			System.err.println("Error: " + e);
		}
	}
}
