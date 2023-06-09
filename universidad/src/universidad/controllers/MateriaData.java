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
import universidad.models.Alumno;
import universidad.models.Materia;

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
    public Materia selectMateria(String nombre) throws IOException {
        Materia materia = new Materia();
        try {

            System.out.println("Metodo \"selectMateria(nombre)\" ");
            String consulta = "SELECT * from materia WHERE nombre like ? ;";
            PreparedStatement stmt = Conexion.getConnection().prepareStatement(consulta);
            stmt.setString(1, nombre);
            System.out.println(stmt);
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
            System.out.println(stmt);
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

    /**
     * estado: 0 no activas, 1 activas, 2 todas
     *
     * @param estado
     * @return
     * @throws IOException
     * @throws SQLException
     */
    public ArrayList<Materia> selectMaterias(int estado) throws IOException, SQLException {
        ArrayList<Materia> materias = new ArrayList();
        try {
            String consulta="";
            switch (estado) {
                case (0):
                    consulta = "SELECT * from materia WHERE `estado` = 0 ORDER BY `nombre` ;";
                    break;
                case (1):
                    consulta = "SELECT * from materia WHERE `estado` = 1 ORDER BY `nombre` ;";
                    break;
                case (2):
                    consulta = "SELECT * from materia WHERE 1 ORDER BY `nombre`;";
                    break;
            }

            PreparedStatement stmt = Conexion.getConnection().prepareStatement(consulta);
            ResultSet result = stmt.executeQuery();
            if (result == null) {
                System.out.println("No se puedo encontrar materias");
            } else {
                System.out.println("Materias encontradas ");
            }
            while (result.next()) {
                Materia materia = new Materia();
                materia.setId_materia(result.getInt("id_materia"));
                materia.setNombre(result.getString("nombre"));
                materia.setAnio(result.getInt("anio"));
                materia.setEstado(result.getBoolean("estado"));
                materias.add(materia);
            }
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return materias;
    }

    // Premitir al personal administrativo listar los alumnos inscriptos en una materia
}
