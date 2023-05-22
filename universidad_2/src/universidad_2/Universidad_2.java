package universidad_2;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import universidad_2.controllers.AlumnoData;
import universidad_2.controllers.Conexion;
import universidad_2.controllers.InscripcionData;
import universidad_2.controllers.MateriaData;
import universidad_2.models.Alumno;
import universidad_2.models.Inscripcion;
import universidad_2.models.Materia;

/**
 *
 * @author raffarraffa
 */
public class Universidad_2 {

    public static void main(String[] args) throws IOException, SQLException {
// Test conexion
        System.out.print("Estableciendo primer conexion: ");
        Conexion.getConnection();
        System.out.println("******************************");
// Instancias DATA
        MateriaData materia_data = new MateriaData();
        AlumnoData alumno_data = new AlumnoData();
        InscripcionData inscripcion_data = new InscripcionData();

// Instancias clases
        Materia materia = new Materia();
        Alumno alumno = new Alumno();

// Test materia SELECT nombre -> Ingles
        System.out.println("Test seleccion materia INGLES");
        materia = materia_data.selectMateria("Ingles");
        System.out.println("Materia seleccionada: " + materia.toString());
        System.out.println("*********************************************");
// Test alumno SELECT dni
        System.out.println("Test selecion alumno con dni 43690464");
        alumno = alumno_data.selectAlumnoDni("43690464");
        System.out.println("Alumno seleccionado : " + alumno.toString());
        System.out.println("*********************************************");

// Test  modificacion fecha nacimiento y estado alumnos
        System.out.println("Test modificacion fecha nacimiento y estado");
        alumno.setFecha_nacimiento(LocalDate.now());
        alumno.setEstado(false);
        alumno_data.udateAlumno(alumno);
        System.out.println(alumno.toString());
        System.out.println("--------------------------------------");
        alumno.setFecha_nacimiento(LocalDate.of(1999, 5, 15));
        alumno.setEstado(true);
        System.out.println(alumno_data.udateAlumno(alumno));
        System.out.println(alumno.toString());

        // alta inscripcion
        //inscripcion_materia.insertInscripcion(alumno, materia);
        // borrar inscripcion
        //inscripcion_materia.deleteInscripcion(alumno, materia);
        // UPDATE NOTA
        inscripcion_data.updateNota(alumno, materia, 9.99);
        ArrayList<Materia> datos_materia = materia_data.selectMaterias(1);
        for (Materia mat : datos_materia) {
            System.out.println(mat.toString());
        }
        // consulta alumnos inscriptos  en una materia
        //  AlumnoData data_alumno = new AlumnoData();

        ArrayList<Alumno> datos_alumnos = alumno_data.selectAlumnosMateria(1);
        for (Alumno alu : datos_alumnos) {
            System.out.println(alu.toString());
        }
        System.out.println(alumno);
//        System.out.println(alumno.toString());
// CRUD
//public Alumno(String dni, String apellido, String nombre, LocalDate fecha_nacimiento, boolean estado)
        Alumno alu_nuevo = new Alumno("12345678", "PEREZ", "Jose", LocalDate.of(1999, 5, 15));
        //  System.out.println(alumno_data.insertAlumno(alu_nuevo));

        // nueva materia
//        Materia mat_nueva = new Materia("WEB I", 1);
        Materia mat_nueva = new Materia();

        mat_nueva = materia_data.selectMateria("WEB II");
        mat_nueva.setAnio(2);
        mat_nueva.setEstado(true);
        mat_nueva.setNombre("WEB I");

        // System.out.println(mat_nueva.isEstado());
//        materia_data.insertMateria(mat_nueva);
        materia_data.updateMateria(mat_nueva); // actualizar materia
    }
}
