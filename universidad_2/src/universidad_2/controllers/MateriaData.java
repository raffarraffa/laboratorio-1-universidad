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
import java.util.ArrayList;
import universidad_2.models.Materia;

/**
 *
 * @author raffarraffa
 */
public class MateriaData {

    private int id_materia;
    private String nombre;
    private int anio;
    private boolean estado;

    public MateriaData() {
    }

    public MateriaData(String nombre, int anio, boolean estado) {
        this.nombre = nombre;
        this.anio = anio;
        this.estado = estado;
    }

    public MateriaData(int id_materia, String nombre, int anio, boolean estado) {
        this.id_materia = id_materia;
        this.nombre = nombre;
        this.anio = anio;
        this.estado = estado;
    }

    public ArrayList<Materia> selectMaterias(int id) throws IOException, SQLException { // selecciona materias de un alumno
        ArrayList<Materia> materias = new ArrayList();
        try {
            String consulta = "SELECT * from materia WHERE id_materia IN (SELECT id_materia FROM `inscripcion` WHERE `id_alumno` = (SELECT id_alumno FROM alumno WHERE id_alumno= ?));";
            PreparedStatement stmt = Conexion.getConnection().prepareStatement(consulta);
            stmt.setInt(1, id);
            ResultSet result = stmt.executeQuery();
            if (result == null) {
                System.out.println("mierda");
            } else {
                System.out.println("ok");
            }
            while (result.next()) {
                Materia materia = new Materia();
                materia.setNombre(result.getString("nombre"));
                materia.setAnio(result.getInt("anio"));
                materia.setId_materia(result.getInt("id_materia"));
                materia.setEstado(result.getBoolean("estado"));
                materias.add(materia);
            }
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return materias;

    }

}
