import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class Client {

    private String hostName ;
    private int portNumber ;
    private Socket socket ;
    private PrintWriter out ;
    private BufferedReader in ;
    private ObjectInputStream obj_in ;
    private ObjectOutputStream obj_out ;


    Client( String hostName, int portNumber ) {

        this.hostName = hostName ;
        this.portNumber = portNumber ;

        try {
            socket = new Socket(hostName, portNumber);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            obj_in = new ObjectInputStream(socket.getInputStream()) ;

        } catch ( Exception e ) {
            e.printStackTrace();
        }


    }

    public void closeConnection() {
        try {

            socket.close();

        } catch ( IOException e ) { e.printStackTrace(); }

    }
    public static void main(String[] args) throws IOException {

        Client c = new Client("127.0.0.1",5000) ;
        c.makeLogin("user","password") ;
        c.closeConnection();

        Client c1 = new Client("127.0.0.1",5000) ;
        c1.makeLogin("user1","pass1") ;
        c1.closeConnection();

        Client c2 = new Client("127.0.0.1",5000) ;
        c2.makeRegister("pippo","password2");
        c2.closeConnection();

        Client c3 = new Client("127.0.0.1",5000) ;
        c3.getListaProdotti() ;
        c3.closeConnection();


        Prodotto p = new Prodotto("Lampada","Arredamento",1000,150,10,false) ;
        Client c4 = new Client("127.0.0.1",5000) ;
        c4.inserisciProdotto(p); ;
        c4.closeConnection();

    }

    public void makeLogin( String username, String password ) {

        out.println("LOGIN "+username+" "+password) ;
        try {
            String ret = in.readLine();
            System.out.println(ret) ;
        } catch ( Exception e ) {
            e.printStackTrace();
        }

    }

    public void makeRegister( String username, String password) {
        out.println("REGISTER "+username+" "+password) ;

        try {
            String ret = in.readLine() ;
            System.out.println(ret) ;
        } catch( Exception e ) {
            e.printStackTrace();
        }
    }

    public void inserisciProdotto(Prodotto p) {

        System.out.println("INSERISCIPRODOTTO "+p.getNome()+" "+p.getCategoria()+" "+p.getQuantita()+" "+p.getPrezzo()+" "+p.getNum_acquistato()+" "+p.isRecente()) ;
        out.println("INSERISCIPRODOTTO "+p.getNome()+" "+p.getCategoria()+" "+p.getQuantita()+" "+p.getPrezzo()+" "+p.getNum_acquistato()+" "+p.isRecente()) ;
        try {
            String ret = in.readLine() ;
            System.out.println(ret) ;
        } catch( Exception e ) {
            e.printStackTrace();
        }

    }

    public ArrayList<Prodotto> getListaProdotti() {

        out.println("GETLISTAPRODOTTI ") ;

        ArrayList<Prodotto> prod = new ArrayList<Prodotto>() ;

        try {
            prod = (ArrayList<Prodotto>) obj_in.readObject() ;
            for ( Prodotto p : prod ) {
                System.out.println(p.toString()) ;
            }
        } catch ( Exception e ) {
            e.printStackTrace();
        }

        return prod ;
    }
}