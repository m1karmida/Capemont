import java.sql.*;
import java.util.ArrayList;

public class DBConnectorPostgres {

    public boolean makeLogin( String username, String password) {

        String url = "jdbc:postgresql://localhost/capemont" ; //Parametri da se
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

    public boolean inserisciProdotto( String nome, String categoria, int quantita, float prezzo, int num_acquistato, boolean recente  ) {

        String url = "jdbc:postgresql://localhost/capemont_db" ;
        String user = "postgres" ;
        String pwd = "password" ;
        String query = "INSERT INTO PRODOTTI (CODICE,NOME,CATEGORIA,QUANTITÀ,PREZZO,NUM_ACQUISTATO,RECENTE) VALUES ('11','"+nome+"','"+categoria+"',"+quantita+","+prezzo+","+num_acquistato+","+recente+");" ; ;

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
    public ArrayList<Prodotto> getListaProdottiRecenti() {
        String url = "jdbc:postgresql://localhost/capemont_db" ; //Parametri da se
        String user = "postgres" ;
        String pwd = "password" ;
        String query = "SELECT * FROM PRODOTTI WHERE RECENTE=TRUE;" ;
        ArrayList<Prodotto> prodotti = new ArrayList<Prodotto>() ;

        try {
            Connection conn = DriverManager.getConnection(url,user,pwd) ;
            Statement stm = conn.createStatement() ;
            ResultSet rst = stm.executeQuery(query) ;
            while (rst.next() ) {

                String nome = rst.getString("nome") ;
                String categoria = rst.getString("categoria") ;
                int quantita = Integer.parseInt(rst.getString("QUANTITÀ"));
                float prezzo = Float.parseFloat(rst.getString("prezzo")) ;
                int num_acquistato = Integer.parseInt(rst.getString("num_acquistato")) ;
                boolean recente = Boolean.parseBoolean(rst.getString("recente")) ;
                Prodotto p = new Prodotto(nome,categoria,quantita,prezzo,num_acquistato,recente) ;
                prodotti.add(p) ;

            }

            conn.close() ;

        } catch( Exception e ) {
            e.printStackTrace();
        }

        return prodotti ;

    }
    public ArrayList<Prodotto> getListaProdotti() {

        String url = "jdbc:postgresql://localhost/capemont_db" ; //Parametri da se
        String user = "postgres" ;
        String pwd = "password" ;
        String query = "SELECT * FROM PRODOTTI" ;
        ArrayList<Prodotto> prodotti = new ArrayList<Prodotto>() ;

        try {
            Connection conn = DriverManager.getConnection(url,user,pwd) ;
            Statement stm = conn.createStatement() ;
            ResultSet rst = stm.executeQuery(query) ;
            while (rst.next() ) {

                String nome = rst.getString("nome") ;
                String categoria = rst.getString("categoria") ;
                int quantita = Integer.parseInt(rst.getString("QUANTITÀ"));
                float prezzo = Float.parseFloat(rst.getString("prezzo")) ;
                int num_acquistato = Integer.parseInt(rst.getString("num_acquistato")) ;
                boolean recente = Boolean.parseBoolean(rst.getString("recente")) ;
                Prodotto p = new Prodotto(nome,categoria,quantita,prezzo,num_acquistato,recente) ;
                prodotti.add(p) ;

            }

            conn.close() ;

        } catch( Exception e ) {
            e.printStackTrace();
        }

        return prodotti ;
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
