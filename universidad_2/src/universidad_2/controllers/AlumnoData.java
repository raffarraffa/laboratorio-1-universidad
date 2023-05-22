/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad_2.controllers;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import universidad_2.models.Alumno;
import universidad_2.models.Materia;

/**
 *
 * @author raffarraffa
 */
public class AlumnoData {

    private int id_alumno;
    private String dni;
    private String apellido;
    private String nombre;
    private LocalDate fecha_nacimiento;
    private boolean estado;
    //private ArrayList<Materia> materias = new ArrayList();

    public AlumnoData() {
    }

    public AlumnoData(String dni, String apellido, String nombre, LocalDate fecha_nacimiento, boolean estado) {
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.fecha_nacimiento = fecha_nacimiento;
        this.estado = estado;
    }

    public AlumnoData(int id_alumno, String dni, String apellido, String nombre, LocalDate fecha_nacimiento, boolean estado) {
        this.id_alumno = id_alumno;
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.fecha_nacimiento = fecha_nacimiento;
        this.estado = estado;
    }

    public int getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(int id_alumno) {
        this.id_alumno = id_alumno;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    // select  todos los alumnos activos
    public ArrayList<Alumno> selectAlumnos(int estado) throws IOException, SQLException {
        ArrayList<Alumno> alumnos = new ArrayList();
        try {
            String consulta;
            if (estado == 1) {
                consulta = "SELECT * from alumno WHERE `estado` = 1 ORDER BY `apellido`;";
            } else {
                consulta = "SELECT * from alumno WHERE 1 ORDER BY `apellido`;";
            }

            PreparedStatement stmt = Conexion.getConnection().prepareStatement(consulta);
            ResultSet result = stmt.executeQuery();
            if (result == null) {
                System.out.println("No se puedo encontrar alumnos");
            } else {
                System.out.println("Alumnos encontrados ");
            }
            while (result.next()) {
                Alumno alumno = new Alumno();
                alumno.setId_alumno(result.getInt("id_alumno"));
                alumno.setDni(result.getString("dni"));
                alumno.setApellido(result.getString("apellido"));
                alumno.setNombre(result.getString("nombre"));
                alumno.setFecha_nacimiento(result.getDate("fecha_nacimiento").toLocalDate());
                alumno.setEstado(result.getBoolean("estado"));
                alumnos.add(alumno);
            }
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return alumnos;
    }

    // busco alumno x dni instancio alumno
    public Alumno selectAlumnoDni(String dni) throws IOException {
        Alumno alumno = new Alumno();
        try {
            String consulta = "SELECT * from alumno WHERE dni like ? ;";
            PreparedStatement stmt = Conexion.getConnection().prepareStatement(consulta);
            stmt.setString(1, dni);
            System.out.println(stmt);
            ResultSet result = stmt.executeQuery();
            if (result == null) {
                System.out.println("Resultado consulta NULL ");
            } else {
                System.out.println("Resultado consulta OK ");
            }
            if (result.next()) {
                alumno.setId_alumno(result.getInt("id_alumno"));
                alumno.setDni(result.getString("dni"));
                alumno.setApellido(result.getString("apellido"));
                alumno.setNombre(result.getString("nombre"));
                alumno.setFecha_nacimiento(result.getDate("fecha_nacimiento").toLocalDate());
                alumno.setEstado(result.getBoolean("estado"));
            }
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return alumno;
    }

    public ArrayList<Alumno> selectAlumnosMateria(Materia materia) throws IOException, SQLException {
        ArrayList<Alumno> alumnos = new ArrayList();
        try {
            String consulta = "SELECT * from alumno WHERE id_alumno IN (SELECT id_alumno FROM `inscripcion` WHERE `id_materia` = (SELECT id_materia FROM materia WHERE id_materia = ?) );";
            PreparedStatement stmt = Conexion.getConnection().prepareStatement(consulta);
            stmt.setInt(1, materia.getId_materia());
            System.out.println(stmt);
            ResultSet result = stmt.executeQuery();
            if (result == null) {
                System.out.println("mierda");
            } else {
                System.out.println("-- ok --");
            }
            while (result.next()) {
                Alumno alumno = new Alumno();
                alumno.setId_alumno(result.getInt("id_alumno"));
                alumno.setDni(result.getString("dni"));
                alumno.setApellido(result.getString("apellido"));
                alumno.setNombre(result.getString("nombre"));
                alumno.setFecha_nacimiento(result.getDate("fecha_nacimiento").toLocalDate());
                alumno.setEstado(result.getBoolean("estado"));
                alumnos.add(alumno);
            }
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return alumnos;
    }

    public int udateAlumno(Alumno alumno) throws IOException {
        int result = 0;
        try {
            String consulta = "UPDATE  `alumno` SET `dni`= ? , `apellido`= ? , `nombre`= ? , `fecha_nacimiento`= ? , `estado`= ?    WHERE `alumno`.`id_alumno` = ? ;";
            //String consulta = "UPDATE  `inscripcion` SET `nota`= ? WHERE `inscripcion`.`id_alumno` = ? AND `id_materia`= ? AND `nota` < ? ;";
            PreparedStatement stmt = Conexion.getConnection().prepareStatement(consulta);
            stmt.setString(1, alumno.getDni());
            stmt.setString(2, alumno.getApellido());
            stmt.setString(3, alumno.getNombre());
            stmt.setDate(4, java.sql.Date.valueOf(alumno.getFecha_nacimiento()));
            stmt.setBoolean(5, alumno.isEstado());
            stmt.setInt(6, alumno.getId_alumno());
            System.out.println(stmt);
            result = stmt.executeUpdate();
            System.out.println("Resultado sentencia " + result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (result == 1) {
            System.out.println("Se actualizo al alumno ");
        } else {
            System.out.println("No se actualizo al alumno");
        }
        return result;
    }

    public int insertAlumno(Alumno alumno) throws IOException {
        int result = 0;
        try {
            String consulta = "INSERT INTO `alumno` (`dni`, `apellido`, `nombre`, `fecha_nacimiento`) VALUE (? , ? , ? ,? );";
            //String consulta = "UPDATE  `inscripcion` SET `nota`= ? WHERE `inscripcion`.`id_alumno` = ? AND `id_materia`= ? AND `nota` < ? ;";
            PreparedStatement stmt = Conexion.getConnection().prepareStatement(consulta);
            stmt.setString(1, alumno.getDni());
            stmt.setString(2, alumno.getApellido());
            stmt.setString(3, alumno.getNombre());
            stmt.setDate(4, java.sql.Date.valueOf(alumno.getFecha_nacimiento()));
            System.out.println(stmt);
            result = stmt.executeUpdate();
            System.out.println("Resultado sentencia " + result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (result == 1) {
            System.out.println("Se creo alumno");
        } else {
            System.out.println("No se creo alumno");
            return 0;
        }
        return result;
    }

    @Override
    public String toString() {
        return id_alumno + "," + dni + ", " + apellido + ", " + nombre + ", " + fecha_nacimiento + ", " + estado;
    }
    // selecciona todos alumno

    public ArrayList<Alumno> selectAlumnosTodos(boolean estado) throws IOException, SQLException {
        ArrayList<Alumno> alumnos = new ArrayList();
        try {
            String consulta;
            if (estado) {
                consulta = "SELECT * from alumno WHERE `estado` = 1  ORDER BY `apellido` ;";
            } else {
                consulta = "SELECT * from alumno WHERE 1 ORDER BY `apellido` ;";
            }
            PreparedStatement stmt = Conexion.getConnection().prepareStatement(consulta);
            System.out.println(stmt);
            ResultSet result = stmt.executeQuery();
            if (result == null) {
                System.out.println("-- no se encontraron alumnos --");
            } else {
                System.out.println("-- ok --");
            }
            while (result.next()) {
                Alumno alumno = new Alumno();
                alumno.setId_alumno(result.getInt("id_alumno"));
                alumno.setDni(result.getString("dni"));
                alumno.setApellido(result.getString("apellido"));
                alumno.setNombre(result.getString("nombre"));
                alumno.setFecha_nacimiento(result.getDate("fecha_nacimiento").toLocalDate());
                alumno.setEstado(result.getBoolean("estado"));
                alumnos.add(alumno);
            }
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return alumnos;
    }
}
