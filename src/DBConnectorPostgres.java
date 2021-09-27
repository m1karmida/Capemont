import java.sql.*;

public class DBConnectorPostgres {

    public boolean makeLogin( String username, String password) {

        String url = "jdbc:postgresql://localhost/capemont" ;
        String user = "postgres" ;
        String pwd = "password" ;
        String query = "SELECT * FROM UTENTI WHERE USERNAME='"+username+"' AND PASSWORD='"+password+"' ;" ;

        try {
            Connection conn = DriverManager.getConnection(url,user,pwd) ;
            Statement stm = conn.createStatement() ;
            ResultSet rst = stm.executeQuery(query) ;
            if ( rst.next() ) return true ;

            conn.close() ;
        } catch ( SQLException ex ) {
            System.out.println(ex.getMessage()) ;
        }
        return false ;
    }

    public boolean makeRegister( String username, String password) {


        String url = "jdbc:postgresql://localhost/capemont" ;
        String user = "postgres" ;
        String pwd = "password" ;
        String query = "INSERT INTO UTENTI VALUES ('"+username+"','"+password+"') ;" ;

        try {
            Connection conn = DriverManager.getConnection(url,user,pwd) ;
            Statement stm = conn.createStatement() ;
            int exec_insert = stm.executeUpdate(query) ;
            if ( exec_insert > 0 ) return true ;

            conn.close() ;
        } catch ( SQLException ex ) {
            System.out.println(ex.getMessage()) ;
        }
        return false ;
    }

    public static void main( String [] args ) {

        String url = "jdbc:postgresql://localhost/capemont" ;
        String user = "postgres" ;
        String pwd = "password" ;
        String query = "SELECT * FROM CAPOCCHIA" ;

        try {
            Connection conn = DriverManager.getConnection(url,user,pwd) ;
            Statement stm = conn.createStatement() ;
            ResultSet rst = stm.executeQuery(query) ;
            while( rst.next() ) {
                System.out.println(rst.getString("pene")) ;
            }
            conn.close() ;
        } catch ( SQLException ex ) {
            System.out.println(ex.getMessage()) ;
        }
    }
}
