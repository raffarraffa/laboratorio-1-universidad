package universidad_2;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import universidad_2.controllers.Conexion;
import universidad_2.controllers.MateriaData;
import universidad_2.models.Alumno;
import universidad_2.models.Materia;

/**
 *
 * @author raffarraffa
 */
public class Universidad_2 {

    public static void main(String[] args) throws IOException, SQLException {
        Conexion.getConnection();

   
    }
}
