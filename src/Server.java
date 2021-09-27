import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args) throws IOException {

        int portNumber = 5000;
        ServerSocket serverSocket = new ServerSocket(portNumber);
        Socket clientSocket = new Socket() ;
        PrintWriter out ;
        BufferedReader in ;

        DBConnectorPostgres db = new DBConnectorPostgres() ;

        String inputLine;
        while ( true ) {
            clientSocket = serverSocket.accept() ;
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader( new InputStreamReader(clientSocket.getInputStream()));
            String cmd = in.readLine() ;
            String[] split = cmd.split(" ") ;
            if ( split[0].equals("LOGIN")) {
                System.out.println(" RICHIESTA LOGIN USERNAME : "+split[1]+" PASSWORD : "+split[2]) ;
                if ( db.makeLogin(split[1],split[2]) )
                    out.println("OK") ;
                else
                    out.println("NO") ;
            }

            else if ( split[0].equals("REGISTER")) {
                System.out.println("RICHIESTA REGISTRAZIONE USERNAME : "+split[1]+" PASSWORD : "+split[2]) ;
                if ( db.makeRegister(split[1],split[2])) {
                    out.println("REGISTRAZIONE EFFETTUATA!") ;
                }
                else {
                    out.println("LA REGISTRAZIONE NON E' ANDATA A BUON FINE") ;
                }
            }
        }
    }
}
