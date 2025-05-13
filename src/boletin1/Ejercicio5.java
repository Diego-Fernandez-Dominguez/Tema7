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

		try (Connection con = DriverManager.getConnection(conexion, usuario, password)) {
			System.out.println("La conexion ha ido perfe");

			Statement st = con.createStatement();

			st.executeUpdate(
					"insert into Calificaciones(id_calificacion, id_estudiante, id_curso, id_profesor, tipo_evaluacion, nota, fecha_evaluacion) values(4,3,3,4,'Examen',3.5 ,'2024-12-12')");

			st.executeUpdate(
					"insert into Calificaciones(id_calificacion, id_estudiante, id_curso, id_profesor, tipo_evaluacion, nota, fecha_evaluacion) values(5,1,2,3,'Prueba',7 ,'2025-03-01')");
			
			st.executeUpdate(
					"insert into Calificaciones(id_calificacion, id_estudiante, id_curso, id_profesor, tipo_evaluacion, nota, fecha_evaluacion) values(6,2,1,1, 'Trabajo',5.3 ,'1900-06-23')");
			
		} catch (SQLException e) {
			System.err.println("Error: " + e);
		}
	}
}
