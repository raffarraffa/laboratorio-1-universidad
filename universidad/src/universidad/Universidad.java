package universidad;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import universidad.controllers.AlumnoData;
import universidad.controllers.Conexion;
import universidad.controllers.InscripcionData;
import universidad.controllers.MateriaData;
import universidad.models.Alumno;
import universidad.models.Inscripcion;
import universidad.models.Materia;

/**
 *
 * @author raffarraffa
 */
public class Universidad {

    public static void main(String[] args) throws IOException, SQLException {

// Conexion, patron SINGLETON
        System.out.println("\t\t\t *******************************************************************");
        System.out.println("\t\t\t *  LABORATORIO I                                                  *");
        System.out.println("\t\t\t *  Profesores  Luis Javier Mercado - Juan José Saez               *");
        System.out.println("\t\t\t *******************************************************************");
        System.out.println("\t\t\t *                 ~ GRUPO 15 C 1 año 2023 ~                       *");
        System.out.println("\t\t\t *******************************************************************\n\n\n");

        System.out.println("*******************************************************");
        System.out.print(" Estableciendo conexion: ");
        Conexion.getConnection();
        System.out.println("*******************************************************\n");

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
        System.out.println("*******************************************************\n");
        System.out.println("Test seleccionar alumno por DNI");
        System.out.println("Selecion alumno con dni 43690464");
        alumno = alumno_data.selectAlumnoDni("43690464");
        System.out.println("Alumno seleccionado : " + alumno.toString());
        System.out.println("*******************************************************\n");
        continua();

// Test  materias inscripcion  para un alumno
        System.out.println("ITEM 1: permitir listar materias de un alumno");
        System.out.println("Test listado materias para el alumno instanciado previamente");
        materias = inscripcion_data.selectMaterias(alumno,true);
        for (Materia materia1 : materias) {
            System.out.println(materia1.getAnio() + ", " + materia1.getNombre() + ", " + materia1.isEstado());
        }
        continua();

// Test materia SELECT nombre -> Ingles debe enviarse el nombre de la materia
        System.out.println("Test seleccion materia INGLES");
        materia = materia_data.selectMateria("Ingles");
        System.out.println("Materia seleccionada: " + materia.toString());
        continua();
// Test listado alumnos en una materia (ingles)
        System.out.println("");
        System.out.println("ITEM 2: permitir listar alumnos para una materia");
        System.out.println("Test seleccion alumnos para una materia");
        alumnos = alumno_data.selectAlumnosMateria(materia);
        System.out.println(materia.getNombre() + ", " + materia.getAnio());
        for (Alumno alumno1 : alumnos) {
            System.out.println(alumno1.getApellido());
        }
        continua();
// Test inscribir alumno
        // instancia nuevo alumno
        System.out.println("ITEM 5 se carga nuevo alumno");
        // calcula run dni random
        Random random = new Random();
        int dni = random.nextInt(90000) + 10000;
        String apellido = solicitaString("apellido");
        String nombre = solicitaString("nombre");
        Alumno alumno_new = new Alumno(String.valueOf(dni), apellido.toUpperCase(), nombre, LocalDate.of(1985, 1, 15));
        Alumno alumno_db = new Alumno();
        // insert base datos nuevo alumno
        alumno_data.insertAlumno(alumno_new);
        // verificacion alumno isnertado db
        alumno_db = alumno_data.selectAlumnoDni(alumno_new.getDni());
        System.out.println(alumno_db.getApellido());
        continua();

        System.out.println("ITEM 3 se incribe  nuevo alumno en ingles");
        // se incribie alumno en materia ingles
        inscripcion_data.insertInscripcion(alumno_db, materia);
        // se verifica materias alumno nuevo
        materias = inscripcion_data.selectMaterias(alumno_db,false);
        for (Materia materia1 : materias) {
            System.out.println(materia1.getAnio() + ", " + materia1.getNombre() + ", " + materia1.isEstado());
        }
        continua();
// Test desinscribir alumno

        System.out.println("ITEM 3 se desincribe nuevo alumno de ingles");
        // se borra alumno en materia ingles
        inscripcion_data.deleteInscripcion(alumno_db, materia);
        // se verifica materias alumno nuevo
        materias = inscripcion_data.selectMaterias(alumno_db,true);
        for (Materia materia1 : materias) {
            System.out.println(materia1.getAnio() + ", " + materia1.getNombre() + ", " + materia1.isEstado());
        }
        continua();

// Test calificar alumno
        // Se debe reincribir para calificar
        inscripcion_data.insertInscripcion(alumno_db, materia);
        System.out.println("ITEM 4 calificar alumno");
        System.out.println("Se implento 2 esquemas diferentes: guarda nota mas alta, guarda ultima nota");
        inscripcion_data.updateNota(alumno_db, materia, 8.5);
        System.out.println("Nota alumno " + inscripcion_data.verificaNotaAlumno(alumno_db, materia));
        continua();

// Test  modificacion fecha nacimiento y estado alumnos se utiliza unsolo metodo UPDATE que actualizar cualqueir cambio en base al id_alumno, debera devolver error cuando dni duplicado
        System.out.println("ITEM 5 se editan alumno");
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
        continua();
        System.out.println("ITEM 5 se editan materia ingles");
        materia.setNombre("CHINO");
        materia_data.updateMateria(materia);
        materia = materia_data.selectMateria("CHINO");
        System.out.println("Materia seleccionada: " + materia.toString());
        System.out.println("*********************************************");
        System.out.println("se verifica si esxte ingles");
        materia = materia_data.selectMateria("Ingles");
        System.out.println("Materia seleccionada: " + materia.toString());
        System.out.println("*********************************************");
        // restaurar porque dara error
        System.out.println("Se restaura nombre proque sino en proxima ejecusion dara error al no estar INGLES");
        materia = materia_data.selectMateria("CHINO");
        materia.setNombre("Ingles");
        materia_data.updateMateria(materia);
        materia = materia_data.selectMateria("Ingles");
        System.out.println("Materia seleccionada: " + materia.toString());
        continua();
// solictud materias todas
        materias = materia_data.selectMaterias(1);
        for (Materia materia1 : materias) {
            System.out.println(materia1.toString());
        }
        System.out.println("*******************************************************************\n\n\n\n\n");

        System.out.println("\t\t\t *******************************************************************");
        System.out.println("\t\t\t *                Integrantes:                                     *");
        System.out.println("\t\t\t *                             Vallejos Tulian, Roberta Estefania  *");
        System.out.println("\t\t\t *                             Villalobos, Ruben Cristian          *");
        System.out.println("\t\t\t *                             Toloza, Santiago Leonel             *");
        System.out.println("\t\t\t *                             Lopez, Enrique Rafael               *");
        System.out.println("\t\t\t *******************************************************************\n\n\n\n\n");

    }

    public static void continua() {
        Scanner scanner = new Scanner(System.in);
        String continua = null;
        System.out.println("*******************************************************");
        System.out.println("Presione ENTER para continuar ");
        continua = scanner.nextLine();
        System.out.println("*******************************************************\n\n");
    }

    public static String solicitaString(String dato) {
        Scanner scanner = new Scanner(System.in);
        String string;
        System.out.println("*******************************************************");
        System.out.println("Ingrese " + dato + "-> ");
        string = scanner.nextLine();
        System.out.println("*******************************************************\n\n");
        return string;
    }

}
