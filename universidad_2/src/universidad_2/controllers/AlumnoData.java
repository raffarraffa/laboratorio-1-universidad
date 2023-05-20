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
import static jdk.nashorn.internal.objects.Global.getDate;
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

    // busco alumno x dni instancio alumno
    public Alumno selectAlumnoDni(String dni) throws IOException {
        Alumno alumno = new Alumno();
        try {
            String consulta = "SELECT * from alumno WHERE dni like ? ;";
            PreparedStatement stmt = Conexion.getConnection().prepareStatement(consulta);
            stmt.setString(1, dni);
            ResultSet result = stmt.executeQuery();
            System.out.println("dsfgh");
            if (result == null) {
                System.out.println("mierda");
            } else {
                System.out.println("ok");
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

    public ArrayList<Alumno> selectAlumnosMateria(int id_materia) throws IOException, SQLException { // selecciona materias de un alumno
        ArrayList<Alumno> alumnos = new ArrayList();
        try {
            String consulta = "SELECT * from alumno WHERE id_alumno IN (SELECT id_alumno FROM `inscripcion` WHERE `id_materia` = (SELECT id_materia FROM materia WHERE id_materia = ?) );";
            PreparedStatement stmt = Conexion.getConnection().prepareStatement(consulta);
            stmt.setInt(1, id_materia);
            ResultSet result = stmt.executeQuery();
            if (result == null) {
                System.out.println("mierda");
            } else {
                System.out.println("ok");
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

    @Override
    public String toString() {
        return id_alumno + "," + dni + ", " + apellido + ", " + nombre + ", " + fecha_nacimiento + ", " + estado;
    }

}
