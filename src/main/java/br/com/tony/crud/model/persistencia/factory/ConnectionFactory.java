package br.com.tony.crud.model.persistencia.factory;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Responsible for servers settings and connection method
 *
 * @author <a href="https://github.com/itstoony">...</a>
 */

public class ConnectionFactory {


    // mysql username
    private static final String USERNAME = "root";

    // password
    private static final String PASSWORD = "123456";

    // database path, port, database's name
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/loja";

    /*
     * Database connection
     */


    public static Connection createConnectionToMySQL() throws Exception {
        /*
         * makes the class be loaded by the JVM
         * @Exception Generic Exception
         */
        Class.forName("com.mysql.cj.jdbc.Driver");

        // creates connection with the database
        return DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
    }

    public static void main(String[] args) throws Exception {

        /*
         * recover database connection
         */

        Connection con = createConnectionToMySQL();

        /*
         * test if connection is null
         */

        if (con != null) {
            System.out.println("Connection accomplished successfully!");
            con.close();
        }

    }
}
