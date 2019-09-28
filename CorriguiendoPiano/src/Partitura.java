import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class Partitura {
	ArrayList<String> partitura;

	public Partitura(String path) throws Exception {
		partitura = new ArrayList<String>();
		File f = new File(path);
		Scanner sc = new Scanner(f);
		int notas = sc.nextInt();
		//sc.nextLine();
		// Voy agregando a un array
		int i=1;
		partitura.add(sc.nextLine());
		partitura.add(sc.nextLine());
		partitura.remove(0);
		while (i<notas) {
			partitura.add(sc.nextLine());
			i++;
		}
		sc.close();

		if (notas != partitura.size()) {
			throw new Exception("Error de lectura");
		}
	}

	public void imprimirMovimientosNecesarios(ArrayList<String> resultado, String path) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(new File(path));
		Iterator<String> iterador = resultado.iterator();

		// Voy recorriendo
		while (iterador.hasNext()) {
			pw.println(iterador.next());
		}
		pw.close();
	}

	public ArrayList<String> getPartitura() {
		return partitura;
	}
}
