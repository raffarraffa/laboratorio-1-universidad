package universidad_2.controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author raffarraffa
 */
public class Conexion {

    private static String user;
    private static String pass;
    private static String url;
    private static Connection connection;

    private Conexion() {
    }

    /**
     * metodo para conectase a la base de datos
     *
     * @return
     * @throws IOException
     */
    public static Connection getConnection() throws IOException {
        String[] arguments = {"src\\config.csv", "false", ","};// patch, bandera 1º linea no valida, separador datos

        if (user == null) {
            getConfigCSV(arguments);
        }
        if (connection == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(url, user, pass);
                System.out.println("Nueva conexion exitosa!");
                System.out.print("***********************");

            } catch (ClassNotFoundException | SQLException e) {
                System.out.println("Fallo " + e);

            }
        } else {
            System.out.println("Utilizando Conexion existente! ");
            // System.out.println("*******************************");
        }
        return connection;
    }

    /**
     * Metodo que lee un archivo csv para extraer las credenciales para acceder a la base de datos en remoto
     *
     * @param args
     * @throws RuntimeException
     * @throws IOException
     */
    public static void getConfigCSV(String[] args) throws RuntimeException, IOException {
        File archivo = new File(args[0]);
        BufferedReader lineas = null;
        try {
            FileReader archivo_leido; // objeto lectura archivo
            archivo_leido = new FileReader(args[0]);
            lineas = new BufferedReader(archivo_leido);
            String linea;
            while ((linea = lineas.readLine()) != null) {
                String[] linea_procesada = linea.split(args[2]);
                Conexion.user = linea_procesada[0];
                Conexion.pass = linea_procesada[1];
                Conexion.url = linea_procesada[2];
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if (lineas != null) {
                lineas.close();
            }
        }

    }
}
