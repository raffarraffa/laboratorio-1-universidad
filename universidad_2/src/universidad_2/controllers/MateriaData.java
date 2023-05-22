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
import universidad_2.models.Alumno;
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

    // selecciona materias de un alumno recibe  alumno por parametro
    public ArrayList<Materia> selectMaterias(Alumno alumno) throws IOException, SQLException {
        ArrayList<Materia> materias = new ArrayList();
        try {
            String consulta = "SELECT * from materia WHERE id_materia IN (SELECT id_materia FROM `inscripcion` WHERE `id_alumno` = (SELECT id_alumno FROM alumno WHERE id_alumno= ?));";
            PreparedStatement stmt = Conexion.getConnection().prepareStatement(consulta);
            stmt.setInt(1, alumno.getId_alumno());
            ResultSet result = stmt.executeQuery();
            if (result.getRow() == 0) {
                System.out.println(" -- No se encontraron materias para el alumno solicitado--");
            } else {
                System.out.println("-- ok --");
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

    public Materia selectMateria(String nombre) throws IOException {
        Materia materia = new Materia();
        try {

            System.out.println("Metodo \"selectMateria(nombre)\" ");
            String consulta = "SELECT * from materia WHERE nombre like ? ;";
            PreparedStatement stmt = Conexion.getConnection().prepareStatement(consulta);
            stmt.setString(1, nombre);
            ResultSet result = stmt.executeQuery();
            if (result == null) {
                System.out.println("Resultado consulta NULL ");
            } else {
                System.out.println("Resultado consulta OK ");
            }
            if (result.next()) {
                materia.setId_materia(result.getInt("id_materia"));
                materia.setNombre(result.getString("nombre"));
                materia.setAnio(result.getInt("anio"));
                materia.setEstado(result.getBoolean("estado"));
            }
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return materia;
    }

    public int insertMateria(Materia materia) throws IOException {
        int result = 0;
        try {
            String consulta = "INSERT INTO `materia` (`nombre`, `anio`) VALUE (? , ? );";
            PreparedStatement stmt = Conexion.getConnection().prepareStatement(consulta);
            stmt.setString(1, materia.getNombre());
            stmt.setInt(2, materia.getAnio());
            result = stmt.executeUpdate();
            System.out.println("Resultado sentencia " + result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (result == 1) {
            System.out.println("Se creo materia");
        } else {
            System.out.println("No se creo materia");
            return 0;
        }
        return result;
    }

    public int updateMateria(Materia materia) throws IOException {
        int result = 0;
        try {
            String consulta = "UPDATE  `materia` SET `nombre` = ? , `anio`= ? ,`estado` = ? WHERE `id_materia` = ? ;";

            //String consulta = "UPDATE  `inscripcion` SET `nota`= ? WHERE `inscripcion`.`id_alumno` = ? AND `id_materia`= ? AND `nota` < ? ;";
            PreparedStatement stmt = Conexion.getConnection().prepareStatement(consulta);
            stmt.setString(1, materia.getNombre());
            stmt.setInt(2, materia.getAnio());
            stmt.setBoolean(3, materia.isEstado());
            stmt.setInt(4, materia.getId_materia());
            result = stmt.executeUpdate();
            System.out.println(stmt);
            System.out.println("Resultado sentencia " + result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (result == 1) {
            System.out.println("Se actualizo materia");
        } else {
            System.out.println("No se actualizo materia");
            return 0;
        }
        return result;
    }

    // Premitir al personal administrativo listar los alumnos inscriptos en una materia
}
