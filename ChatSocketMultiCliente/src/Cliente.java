import java.net.Socket;
import java.util.Scanner;

public class Cliente {
	static final String HOST = "localhost";
	static final int PUERTO=5000;
	Scanner teclado = new Scanner(System.in);
 
 public Cliente( ) {
 try{
	 Socket skCliente = new Socket( this.HOST , this.PUERTO ); //se crea el socket
	 System.out.println("Introduce nombre: ");
	 String nombre= teclado.nextLine();
	 //Socket skCliente = new Socket( "192.168.5.110", this.PUERTO );
	 Escribir hilo1 =new Escribir(skCliente,nombre);//hilo que escribe
 	Leer hilo2= new Leer(skCliente);//hilo que lee
 	while(hilo1.isAlive() && hilo2.isAlive()){
 	}
 	skCliente.close();//se cierra el socket
 	} catch( Exception e ) {
 		System.out.println( e.getMessage() );
 	}
 }
 
 public static void main( String[] arg ) {
	 new Cliente();
 }
}