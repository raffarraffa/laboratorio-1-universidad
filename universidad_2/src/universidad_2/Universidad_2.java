package universidad_2;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
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
        MateriaData data_materia = new MateriaData();
        AlumnoData data_alumno = new AlumnoData();

        Materia materia = new Materia();
        materia = materia_data.selectMateria("Ingles");

        Alumno alumno = new Alumno();
        alumno = data_alumno.selectAlumnoDni("43690464");
        InscripcionData inscripcion_materia = new InscripcionData();
        //    inscripcion_materia.insertInscripcion(alumno, materia);

        ArrayList<Materia> datos_materia = data_materia.selectMaterias(1);
        for (Materia mat : datos_materia) {
            System.out.println(mat.toString());
        }
        // consulta alumnos inscriptos  en una materia
        //  AlumnoData data_alumno = new AlumnoData();
        ArrayList<Alumno> datos_alumnos = data_alumno.selectAlumnosMateria(1);
        for (Alumno alu : datos_alumnos) {
            System.out.println(alu.toString());
        }
        System.out.println(alumno);
//        System.out.println(alumno.toString());

    }
}
