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
public class InscripcionData {

    public InscripcionData() {
    }

    public int insertInscripcion(Alumno alumno, Materia materia) throws IOException {
        int result = 0;
        try {
            String consulta = "INSERT INTO `inscripcion`(`id_alumno`, `id_materia`) VALUES (? , ?);";
            PreparedStatement stmt = Conexion.getConnection().prepareStatement(consulta);
            stmt.setInt(1, alumno.getId_alumno());
            stmt.setInt(2, materia.getId_materia());
            result = stmt.executeUpdate();
            System.out.println("Resultado sentencia " + result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (result == 1) {
            System.out.println("Se realizo la inscripcion solictada");
        } else {
            System.out.println("No se realizo la inscripcion solicitada");
        }
        return result;
    }

    public int deleteInscripcion(Alumno alumno, Materia materia) throws IOException {
        int result = 0;
        try {
            //            DELETE FROM inscripcion WHERE `inscripcion`.`id_inscripto` = 8" AND `nota` IS NOT NULL

            //          String consulta = "INSERT INTO `inscripcion`(`id_alumno`, `id_materia`) VALUES (? , ?);";
            String consulta = "DELETE FROM inscripcion WHERE `inscripcion`.`id_alumno` = ? AND `id_materia`= ? AND `nota` IS NULL";
            PreparedStatement stmt = Conexion.getConnection().prepareStatement(consulta);
            stmt.setInt(1, alumno.getId_alumno());
            stmt.setInt(2, materia.getId_materia());
            result = stmt.executeUpdate();
            System.out.println("Resultado sentencia " + result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (result == 1) {
            System.out.println("Se borro la inscripcion solictada");
        } else {
            System.out.println("No borro la inscripcion solicitada");
        }
        return result;
    }

    public int updateNota(Alumno alumno, Materia materia, double nota) throws IOException {
        int result = 0;
        try {
            //            DELETE FROM inscripcion WHERE `inscripcion`.`id_inscripto` = 8" AND `nota` IS NOT NULL

            String consulta = "UPDATE  `inscripcion` SET `nota`= ? WHERE `inscripcion`.`id_alumno` = ? AND `id_materia`= ? ;";
            //String consulta = "UPDATE  `inscripcion` SET `nota`= ? WHERE `inscripcion`.`id_alumno` = ? AND `id_materia`= ? AND `nota` < ? ;";
            PreparedStatement stmt = Conexion.getConnection().prepareStatement(consulta);
            stmt.setDouble(1, nota);
            stmt.setInt(2, alumno.getId_alumno());
            stmt.setInt(3, materia.getId_materia());
            result = stmt.executeUpdate();
            System.out.println("Resultado sentencia " + result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (result == 1) {
            System.out.println("Se borro la inscripcion solictada");
        } else {
            System.out.println("No borro la inscripcion solicitada");
        }
        return result;
    }

    public int updateNotaMasAlta(Alumno alumno, Materia materia, double nota) throws IOException {
        int result = 0;
        try {
            //            DELETE FROM inscripcion WHERE `inscripcion`.`id_inscripto` = 8" AND `nota` IS NOT NULL

//            String consulta = "UPDATE  `inscripcion` SET `nota`= ? WHERE `inscripcion`.`id_alumno` = ? AND `id_materia`= ? ;";
            String consulta = "UPDATE  `inscripcion` SET `nota`= ? WHERE `inscripcion`.`id_alumno` = ? AND `id_materia`= ? AND `nota` < ? ;";
            PreparedStatement stmt = Conexion.getConnection().prepareStatement(consulta);
            stmt.setDouble(1, nota);
            stmt.setInt(2, alumno.getId_alumno());
            stmt.setInt(3, materia.getId_materia());
            stmt.setDouble(4, nota);
            result = stmt.executeUpdate();
            System.out.println("Resultado sentencia " + result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (result == 1) {
            System.out.println("Se borro la inscripcion solictada");
        } else {
            System.out.println("No borro la inscripcion solicitada");
        }
        return result;
    }
}
