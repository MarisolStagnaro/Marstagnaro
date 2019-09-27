package paquete;

import java.io.*;
import java.util.Scanner;

public class Teletipo {
		
		/***LEER ARCHIVO POR CARACTER***/
		/*try {
		bf = new FileReader(arch);
	    int caract = bf.read();
        //Se recorre el fichero hasta encontrar el carácter -1
        //   que marca el final del fichero
        while(caract != -1) {
            //Mostrar en pantalla el carácter leído convertido a char
            if((char)caract == '/')
            	caracteres=caracteres.substring(0,n-1);
            else if(n==0)
            		caracteres+=(char)caract;
            		else
            	caracteres+=(char)caract;
            //Leer el siguiente carácter
            caract = bf.read();
            n++;
        }
		}
    catch (FileNotFoundException e) {
        //Operaciones en caso de no encontrar el fichero
        System.out.println("Error: Fichero no encontrado");
        //Mostrar el error producido por la excepción
        System.out.println(e.getMessage());
    }
    catch (Exception e) {
        //Operaciones en caso de error general
        System.out.println("Error de lectura del fichero");
        System.out.println(e.getMessage());
    }
    	finally {
            //Operaciones que se harán en cualquier caso. Si hay error o no.
            try {
                //Cerrar el fichero si se ha abierto
                if(bf != null)
                    bf.close();
            }
            catch (Exception e) {
                System.out.println("Error al cerrar el fichero");
                System.out.println(e.getMessage());
            }
            */
	/***************************MIO***********************************/
		public static void Caracteres_Control(String arch) throws FileNotFoundException {
		String linea="",linea_modif="";
		char c='a';
		try {
		      FileReader fr = new FileReader(arch);
		      BufferedReader br = new BufferedReader(fr);
		 
		      while((linea = br.readLine()) != null){
		    	  for (int n=0; n<linea.length() && c!='*'; n++) { 
		    		  c = linea.charAt(n);
		    		  if(c!='*') {
		    			  if(c == '/')
		    				  linea_modif=(linea_modif.length()!=0)?linea_modif.substring(0,linea_modif.length()-1):"";
		              	  else
		              		  linea_modif=(c=='&')?"":linea_modif+c;
		    		  }
		    		  else {
		    			  System.out.println("Linea terminada");
		    			  System.out.println("Cadena obtenida:"+linea_modif);
		    			  return;
		    		  }
		    	  }
		      }
		      fr.close();
		    }
		    catch(Exception e) {
		      System.out.println("Excepcion leyendo fichero "+ arch + ": " + e);
		    }

}
		/**********REVISION 1*******/
		/*
		public static String parsearCadenaTeletipo(String inputFileName) throws IOException
		{

			FileInputStream input = new FileInputStream(new File(inputFileName));
			StringBuilder output = new StringBuilder();

			try
			{
				while (input.available() > 0)
				{
					char caracterIngresado = (char) input.read();
					switch (caracterIngresado)
					{
						case '*':
							return output.toString();
						case '/':
							if (output.length() > 0)
								output.deleteCharAt(output.length() - 1);
							break;
						case '&':
							output = new StringBuilder();
							break;
						default:
							output.append(caracterIngresado);
							break;
					}
				}
			}
			finally
			{
				input.close();
			}
			return output.toString();
		}
	    */
		/*****REVISION 2****/
		
		public static void SuprimirCadenas(File archivo) throws FileNotFoundException {
			Scanner sc = new Scanner(archivo);
			PrintWriter salida= new PrintWriter("resultado.out");
			String cadena="";
			int posAnulador,posRetroceso,fin=-1;
			//leo el archivo mientras haya otra linea y no aparezca el *
			while(sc.hasNext() && fin==-1) {
			cadena+=sc.next();
			fin=cadena.lastIndexOf("*");

			}
			if(fin == -1) {
			System.out.println("el archivo no contiene el caracter de fin de tira de caracteres '*' ");
			return ;
			}
			//me quedo con lo que esta antes del *
			cadena=cadena.substring(0, fin);
			posAnulador=cadena.lastIndexOf("&"); //busco la ultima aparicion de &
			// si aparece el anulador me quedo con lo que le sigue
			if(posAnulador!=-1) 
			cadena=cadena.substring(posAnulador+1, cadena.length()); 

			//mientras aparezca el caracter de retroceso elimino el caracter anterior
			posRetroceso=cadena.indexOf("/");
			while(posRetroceso != -1) {
			if(posRetroceso-1<0)
			cadena=cadena.substring(posRetroceso+1,cadena.length());
			else 
			cadena=cadena.substring(0,posRetroceso-1)+cadena.substring(posRetroceso+1,cadena.length());

			posRetroceso=cadena.indexOf("/");

			}
			System.out.println("cadena resultante: "+cadena);
			sc.close();
			}
		
	public static void main(String[] args) throws FileNotFoundException {
	String nombre="archivo.txt";
	try {
		File archivo= new File(nombre);
		SuprimirCadenas(archivo);
	}
	catch (Exception e) {
        System.out.println("Error al cerrar el fichero");
        System.out.println(e.getMessage());
    }
	}

}