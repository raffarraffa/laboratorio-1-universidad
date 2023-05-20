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
//        Conexion.getConnection();

        MateriaData data = new MateriaData();
        ArrayList<Materia> mat = new ArrayList();
        mat = data.selectMaterias(1);// recibe id_alumno
        for (Materia materia : mat) {
            System.out.println(materia);
        }
        LocalDate date = LocalDate.now();

        Alumno alu = new Alumno(1, "4369046", "sadf", "asdf", date, false);

    }
}
