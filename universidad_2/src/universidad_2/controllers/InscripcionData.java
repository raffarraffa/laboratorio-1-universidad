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

    public void insertInscripcion(Alumno alumno, Materia materia) throws IOException {
        try {
            String consulta = "INSERT INTO `inscripcion`(`id_alumno`, `id_materia`) VALUES (? , ?);";
            PreparedStatement stmt = Conexion.getConnection().prepareStatement(consulta);
            stmt.setInt(1, alumno.getId_alumno());
            stmt.setInt(2, materia.getId_materia());
            int result = stmt.executeUpdate();
            System.out.println("Resultado sentencia " + result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
