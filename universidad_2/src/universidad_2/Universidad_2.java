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
        Conexion.getConnection(); // llama conexion
        // instancias DATA
        MateriaData materia_data = new MateriaData();
        // MateriaData data_materia = new MateriaData();
        AlumnoData alumno_data = new AlumnoData();

        Materia materia = new Materia();
        materia = materia_data.selectMateria("Ingles");

        Alumno alumno = new Alumno();
        alumno = alumno_data.selectAlumnoDni("43690464");

//        alumno.setFecha_nacimiento(LocalDate.parse("1969-01-25", DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        alumno.setFecha_nacimiento(LocalDate.of(1999, 5, 15));
        alumno.setEstado(false);
        System.out.println(alumno_data.udateAlumno(alumno));

        InscripcionData inscripcion_materia = new InscripcionData();
        // alta inscripcion
        //inscripcion_materia.insertInscripcion(alumno, materia);
        // borrar inscripcion
        //inscripcion_materia.deleteInscripcion(alumno, materia);
        // UPDATE NOTA
        inscripcion_materia.updateNota(alumno, materia, 9.99);
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
