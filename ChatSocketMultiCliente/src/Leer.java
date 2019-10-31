import java.io.*;
import java.net.*;

public class Leer extends Thread{//Hilo que lee los mensajes que se reciben
 private Socket socket;

 public Leer( Socket socket){//constructor del hilo
	 super("Hilo leer");
	 this.socket=socket;
	 start();
 }

 public void run(){
	 try{
		 while(true){//bucle para continuar la lectura
			 InputStream aux = socket.getInputStream(); // flujo de datos del socket
			 DataInputStream flujo = new DataInputStream( aux ); //se asocia el flujo de datos a un flujo de lectura
			 System.out.println(flujo.readUTF());//se imprime por pantalla el flujo
		 }
	 }catch(Exception e){
		 System.out.println("Error");}
 	}
}