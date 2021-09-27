import java.io.*;
import java.net.*;

public class Client {

    private String hostName ;
    private int portNumber ;
    private Socket socket ;
    private PrintWriter out ;
    private BufferedReader in ;


    Client( String hostName, int portNumber ) {

        this.hostName = hostName ;
        this.portNumber = portNumber ;

        try {
            socket = new Socket(hostName, portNumber);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
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
}