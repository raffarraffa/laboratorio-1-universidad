/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.controllers;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import universidad.models.Alumno;
import universidad.models.Materia;

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
            System.out.println("Se realizo la inscripcion solicitada");
        } else {
            System.out.println("No se realizo la inscripcion solicitada");
        }
        return result;
    }

    public int deleteInscripcion(Alumno alumno, Materia materia) throws IOException {
        int result = 0;
        try {
            String consulta = "DELETE FROM inscripcion WHERE `inscripcion`.`id_alumno` = ? AND `id_materia`= ? ";//AND `nota` IS NULL
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

    public double verificaNotaAlumno(Alumno alumno, Materia materia) throws IOException {
        double nota = -1;
        try {
            String consulta = "SELECT  `nota` FROM inscripcion  WHERE `inscripcion`.`id_alumno` = ? AND `id_materia`= ? ;";
            PreparedStatement stmt = Conexion.getConnection().prepareStatement(consulta);
            stmt.setDouble(1, alumno.getId_alumno());
            stmt.setInt(2, materia.getId_materia());
            System.out.println(stmt);
            ResultSet result = stmt.executeQuery();
            System.out.println("Resultado sentencia " + result);
            if (result.next()) {
                nota = result.getDouble("nota");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nota;
    }

    public HashMap<String, ArrayList<String>> selectInscriptos() throws IOException, SQLException {
        HashMap<String, ArrayList<String>> inscripciones = new HashMap<>();
        String consulta;
        /*   consulta = "SELECT i.id_alumno, concat(a.apellido, ' ' ,a.nombre)as nombre_completo, GROUP_CONCAT(m.nombre) AS 'materias_insc'"
                + " FROM inscripcion i JOIN alumno a ON i.id_alumno = a.id_alumno "
                + "JOIN materia m ON i.id_materia = m.id_materia "
                + "GROUP BY i.id_alumno,  ORDER BY concat(a.apellido, ' ' ,a.nombre) ASC;";
         */
        consulta = "SELECT i.id_alumno, CONCAT(a.apellido, ' ', a.nombre) AS nombre_completo, GROUP_CONCAT(m.nombre) AS materias_insc\n"
                + "FROM inscripcion i\n"
                + "JOIN alumno a ON i.id_alumno = a.id_alumno\n"
                + "JOIN materia m ON i.id_materia = m.id_materia\n"
                + "GROUP BY i.id_alumno, a.apellido, a.nombre\n"
                + "ORDER BY i.id_alumno, nombre_completo;";

//        String consulta = "SELECT subquery.id_alumno, subquery.nombre_completo, GROUP_CONCAT(subquery.nombre_materia) AS materias_insc FROM (   SELECT i.id_alumno, CONCAT(a.apellido, ' ', a.nombre) AS nombre_completo, m.nombre AS nombre_materia     FROM inscripcion i    JOIN alumno a ON i.id_alumno = a.id_alumno     JOIN materia m ON i.id_materia = m.id_materia ) AS subquery GROUP BY subquery.id_alumno, subquery.nombre_completo ORDER BY nombre_completo;";
        PreparedStatement stmt = Conexion.getConnection().prepareStatement(consulta);
        ResultSet result = stmt.executeQuery();
        while (result.next()) {
            ArrayList<String> insc = new ArrayList<>();
            String key = Integer.toString(result.getInt("id_alumno"));
            insc.add(result.getString("nombre_completo"));
            insc.add(result.getString("materias_insc"));
//            String value = result.getString("nombre") + ", " + result.getString("materias_insc");
            inscripciones.put(key, insc);
        }
        return inscripciones;
    }

    /**
     *
     * @param alumno
     * @param inscripto materias inscripto
     * @return
     * @throws IOException
     * @throws SQLException
     */
    public ArrayList<Materia> selectMaterias(Alumno alumno, boolean inscripto) throws IOException, SQLException {
        @SuppressWarnings("unchecked")
        ArrayList<Materia> materias = new ArrayList();
        try {
            String consulta;
            if (inscripto) {
                consulta = "SELECT * from materia WHERE id_materia IN (SELECT id_materia FROM `inscripcion` WHERE `id_alumno` = (SELECT id_alumno FROM alumno WHERE id_alumno= ?));";
            } else {
                consulta = "SELECT * from materia WHERE id_materia NOT IN (SELECT id_materia FROM `inscripcion` WHERE `id_alumno` = (SELECT id_alumno FROM alumno WHERE id_alumno= ?));";
            }
            PreparedStatement stmt = Conexion.getConnection().prepareStatement(consulta);
            stmt.setInt(1, alumno.getId_alumno());
            System.out.println(stmt);
            try (ResultSet result = stmt.executeQuery()) {
                if (!result.next()) {
                    System.out.println(" -- No se encontraron materias para el alumno solicitado " + alumno.getApellido());
                } else {
                    System.out.println("-- Mostrando materias para el alumno " + alumno.getApellido());
                }
                result.beforeFirst();
                while (result.next()) {
                    Materia materia = new Materia();
                    materia.setNombre(result.getString("nombre"));
                    materia.setAnio(result.getInt("anio"));
                    materia.setId_materia(result.getInt("id_materia"));
                    materia.setEstado(result.getBoolean("estado"));
                    materias.add(materia);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return materias;
    }
    public ArrayList<Materia> materiasNoInscripto(Alumno alumno) throws IOException, SQLException {
        @SuppressWarnings("unchecked")
        ArrayList<Materia> materias = new ArrayList();
        try {
            String consulta = "SELECT * from materia WHERE id_materia NOT IN (SELECT id_materia FROM `inscripcion` WHERE `id_alumno` = (SELECT id_alumno FROM alumno WHERE id_alumno= ?));";
            PreparedStatement stmt = Conexion.getConnection().prepareStatement(consulta);
            stmt.setInt(1, alumno.getId_alumno());
            System.out.println(stmt);
            try (ResultSet result = stmt.executeQuery()) {
                if (!result.next()) {
                    System.out.println(" -- No se encontraron materias " + alumno.getApellido());
                } else {
                    System.out.println("-- Mostrando materias no inscriptas " + alumno.getApellido());
                }
                result.beforeFirst();
                while (result.next()) {
                    Materia materia = new Materia();
                    materia.setNombre(result.getString("nombre"));
                    materia.setAnio(result.getInt("anio"));
                    materia.setId_materia(result.getInt("id_materia"));
                    materia.setEstado(result.getBoolean("estado"));
                    materias.add(materia);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return materias;
    }

}
