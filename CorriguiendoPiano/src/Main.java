import java.util.ArrayList;
import java.util.Iterator;

public class Main {
	public static void main(String[] args) throws Exception {
		Partitura p = new Partitura("Partitura7.txt");

		p.imprimirMovimientosNecesarios(procesarPartitura(p.getPartitura()), "salida.txt");
	}

	public static ArrayList<String> procesarPartitura(ArrayList<String> partitura) {
		ArrayList<String> res = new ArrayList<>();

		// La primer tecla siempre va
		res.add(partitura.get(0));

		// C es 0
		int indice = Integer.valueOf(partitura.get(0).charAt(0)) - 64 - 3;
		System.out.println("Indice"+indice);
		System.out.println(Integer.valueOf(partitura.get(0).charAt(0)));
		
		
		if (Integer.valueOf(partitura.get(0).charAt(0)) == 'A') {
			indice = 5;
		} else if (Integer.valueOf(partitura.get(0).charAt(0)) == 'B') {
			indice = 6;
		}

		int octavaIndice;
		// En caso de ser sostenido
		if (partitura.get(0).charAt(partitura.get(0).length() - 1) == '#') {
			octavaIndice = partitura.get(0).charAt(partitura.get(0).length() - 2);
			indice++;
		} else {
			octavaIndice = partitura.get(0).charAt(partitura.get(0).length() - 1);
		}

		Iterator<String> iterador = partitura.iterator();
		// El primero ya lo mire, sigo con el resto
		iterador.next();

		// Voy recorriendo
		while (iterador.hasNext()) {

			int octava;
			String valor = iterador.next();
			int numActual = (valor.charAt(0) - 64 - 3);
			if (Integer.valueOf(valor.charAt(0)) == 'A') {
				numActual = 5;
			} else if (Integer.valueOf(valor.charAt(0)) == 'B') {
				numActual = 6;
			}
			// En caso de ser sostenido
			if (valor.charAt(valor.length() - 1) == '#') {
				octava = valor.charAt(valor.length() - 2);
				numActual++;
			} else {
				octava = valor.charAt(valor.length() - 1);
			}

			if ((numActual > indice && numActual - indice > 2)
					|| (octava - octavaIndice != 0 && indice - numActual < 1)) {
				// Ahora me muevo a la posicion nueva
				indice = numActual;
				octavaIndice = octava;
				res.add(valor);
			}
		}
		return res;
	}
}