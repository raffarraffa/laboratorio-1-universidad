/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad_2.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
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
    private ArrayList<Materia> materias = new ArrayList();

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

    public ArrayList<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(ArrayList<Materia> materias) throws IOException, SQLException {
        MateriaData materia_data = new MateriaData();
        this.materias = materia_data.selectMaterias(id_alumno);
    }

}
