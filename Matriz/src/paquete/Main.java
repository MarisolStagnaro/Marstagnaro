package paquete;

public class Main {

	public static void main(String[] args) {
		int [] mat={-715827882, 0, 0, 0, 715827882, 0, 0, 0, -715827882};
		Matriz m= new Matriz(mat);
		/*System.out.println("el cruce minimo es:"+m.cruceMinimo(mat));*/
		System.out.println("el cruce minimo es:"+m.cruceMinimo(mat));
	}

}
