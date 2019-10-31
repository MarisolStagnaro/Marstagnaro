import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	static final int PUERTO=5000;
	private ServerSocket skServidor;
	private ClienteConectado cliente;
	public Servidor( ) {
		try {
			skServidor = new ServerSocket( PUERTO );
			//skServidor.setSoTimeout(40000);
			System.out.println("Escucho puerto " + PUERTO );//se muestra por pantalla el puerto que esta escuchando
			for ( int numCli = 0; numCli < 5; numCli++ ) {//bucle para contar tres clientes
				Socket skCliente = skServidor.accept(); // Crea objeto para atender a los clientes
				System.out.println("Sirvo cliente" + numCli);//se muestra a que clientes esta atendiendo
				cliente = new ClienteConectado(skCliente);
			}
			System.out.println("Demasiados clientes por hoy");//mensaje para cuando termina el bucle
		} catch( Exception e ) {
			System.out.println( e.getMessage() );
		}
	}
	public static void main( String[] arg ) {
		new Servidor();
	}
 }