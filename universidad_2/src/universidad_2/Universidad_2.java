package universidad_2;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
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

// Conexion, patron SINGLETON
        System.out.print("Estableciendo primer conexion: ");
        Conexion.getConnection();
        System.out.println("******************************");
// instancias de clases controllers DATA
        MateriaData materia_data = new MateriaData();
        AlumnoData alumno_data = new AlumnoData();
        InscripcionData inscripcion_data = new InscripcionData();

// instancias de clases MODELS
        Materia materia = new Materia();
        Materia materia_new = new Materia();
        Alumno alumno = new Alumno();

// variables locales
        ArrayList<Alumno> alumnos = new ArrayList();
        ArrayList<Materia> materias = new ArrayList();
//
// Test debug (deberian ir en Test Packages)
//

// Test alumno SELECT usando dni -> debe enviarse un dni, devolvera el alumno
        System.out.println("Test selecion alumno con dni 43690464");
        alumno = alumno_data.selectAlumnoDni("43690464");
        System.out.println("Alumno seleccionado : " + alumno.toString());
        System.out.println("*********************************************");

// Test  materias inscripcion  para un alumno
        System.out.println("");
        System.out.println("ITEM 1: permitir listar materias de un alumno");
        System.out.println("Test listado materias para el alumno instanciado");
        materias = materia_data.selectMaterias(alumno);
        for (Materia materia1 : materias) {
            System.out.println(materia1.getAnio() + ", " + materia1.getNombre() + ", " + materia1.isEstado());
        }
        System.out.println("*********************************************");

// Test materia SELECT nombre -> Ingles debe enviarse el nombre de la materia
        System.out.println("Test seleccion materia INGLES");
        materia = materia_data.selectMateria("Ingles");
        System.out.println("Materia seleccionada: " + materia.toString());
        System.out.println("*********************************************");

// Test listado alumnos en una materia (ingles)
        System.out.println("");
        System.out.println("ITEM 2: permitir listar alumnos para una materia");
        System.out.println("Test seleccion alumnos para una materia");
        alumnos = alumno_data.selectAlumnosMateria(materia);
        System.out.println(materia.getNombre() + ", " + materia.getAnio());
        for (Alumno alumno1 : alumnos) {
            System.out.println(alumno1.getApellido());
        }
        System.out.println("*********************************************");

// Test inscribir alumno
        // instancia nuevo alumno
        System.out.println("");
        System.out.println("ITEM 5 se carga neuvo alumno a los efectos poder asignarle una materia");
        Alumno alumno_new = new Alumno("1256989", "GOMEZ", "Juan Manuel", LocalDate.of(1985, 1, 15));
        Alumno alumno_db = new Alumno();
        // insert base datos nuevo alumno
        alumno_data.insertAlumno(alumno_new);
        // verificacion alumno isnertado db
        alumno_db = alumno_data.selectAlumnoDni(alumno_new.getDni());
        System.out.println(alumno_db.getApellido());
        System.out.println("");
        System.out.println("ITEM 3 se incribe  nuevo alumno en ingles");
        // se incribie alumno en materia ingles
        inscripcion_data.insertInscripcion(alumno_db, materia);
        // se verifica materias alumno nuevo
        materias = materia_data.selectMaterias(alumno_db);
        for (Materia materia1 : materias) {
            System.out.println(materia1.getAnio() + ", " + materia1.getNombre() + ", " + materia1.isEstado());
        }
        System.out.println("*********************************************");
// Test desinscribir alumno
        System.out.println("");
        System.out.println("ITEM 3 se desincribe nuevo alumno de ingles");
        // se borra alumno en materia ingles
        inscripcion_data.deleteInscripcion(alumno_db, materia);
        // se verifica materias alumno nuevo
        materias = materia_data.selectMaterias(alumno_db);
        for (Materia materia1 : materias) {
            System.out.println(materia1.getAnio() + ", " + materia1.getNombre() + ", " + materia1.isEstado());
        }
        System.out.println("*********************************************");

// Test  modificacion fecha nacimiento y estado alumnos se utiliza unsolo metodo UPDATE que actualizar cualqueir cambio en base al id_alumno, debera devolver error cuando dni duplicado
        System.out.println("Test modificacion fecha nacimiento y estado");
        // se cambia fecha nacimiento, estado y se verifica cambio en 2 ocasiones
        alumno.setFecha_nacimiento(LocalDate.now());
        alumno.setEstado(false);
//              alumno.setDni("8898888"); // si se intenta ingresar un dni existente arroja exepcion
        alumno_data.udateAlumno(alumno);
        System.out.println(alumno.toString());
        System.out.println("--------------------------------------");
        alumno.setFecha_nacimiento(LocalDate.of(1999, 5, 15));
        alumno.setEstado(true);
        alumno_data.udateAlumno(alumno);
        System.out.println(alumno.toString());
        System.out.println("*********************************************");

    }
}
