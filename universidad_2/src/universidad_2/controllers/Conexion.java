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

    public static Connection getConnection() throws IOException {
        String[] arguments = {"src\\config.csv", "false", ","};// patch, bandera 1º linea no valida, separador datos

//        if (user == null) {
//            getConfigCSV(arguments);
//        }
        if (connection == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
//                connection = DriverManager.getConnection(url, user, pass);
                connection = DriverManager.getConnection("jdbc:mysql://mysql-rafalopez.alwaysdata.net/rafalopez_tuds", "rafalopez_tuds", "MalditaEDA");
                System.out.println("Conectado exitosamente!");

            } catch (ClassNotFoundException | SQLException e) {
                System.out.println("mierda" + e);

            }
        } else {
            System.out.println("Ya esta");
        }
        return connection;
    }

    public static void setUrl(String url) {
        Conexion.url = url;
    }

    public static void setUser(String user) {
        Conexion.user = user;
    }

    public static void setPassword(String password) {
        Conexion.pass = pass;
    }

    public static void getConfigCSV(String[] args) throws RuntimeException, IOException {
        File archivo = new File(args[0]);
        BufferedReader lineas = null;
        try {
            FileReader archivo_leido; // objeto lectura archivo
            archivo_leido = new FileReader(args[0]);
            lineas = new BufferedReader(archivo_leido);
            String linea = "", datos = "";
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
