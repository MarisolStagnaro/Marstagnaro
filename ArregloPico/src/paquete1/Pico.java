package paquete1;

public class Pico {

	public int ArrayPico(int [] vec) {
		int i=0,cant=vec.length-1;
		while(i<cant)
			if(vec[i+1]<vec[i++]) 
				return i-1;
		return cant;
	}
	/****revision 2***/
	public static int posicionPico(int[] vec) {
		int i=1;
		while(i<vec.length && vec[i-1]<vec[i])
			i++;
		return i-1;
	}
	
	public static void main(String[] args) {
		/*int [] v= {1,2,3,1,0,-2};
		int [] v2= {1,2,3,4,5,6};
		int [] v3={5,6,13,14,16,80,90,135,56,26,12,6,2,1,0};
		int [] v1= {1,2,3};
		Pico p= new Pico();
		int pos=p.ArrayPico(v);
		System.out.println("La posicion del pico es:"+pos);*/
		int i=0;
		int [] v2 = {1,2,3,4,5,100,300,500,-5,-9,-12};
		int [] v1= {1,2,3,1,0,-2};
		int [] v4= {1,2,3,4,5,6};
		int [] v3={5,6,13,14,16,80,90,135,56,26,12,6,2,1,0};
		int [] v= {1,2,1};
		/*REVISION 1
		  while ((v[i]-v[i+1])<0) {
			i++;
		}
		System.out.println(i);*/
		int pos=posicionPico(v);
		System.out.println("La posicion del pico es:"+pos);
	}

}
