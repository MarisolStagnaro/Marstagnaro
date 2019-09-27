package paquete;

public class Matriz {
	
	int[] m1=new int[9];
	public Matriz(int [] m2) {
		 this.m1=m2;
	 }
/*	
	int cruceMinimo(int [] m){
		int j=1,i=0,m=2147483646;
		for (int i=0;i<7;i+=3){
			int s=0;
			s+=m[i];
			if(i%2==0){
				int j= m[j]<m[j+3]?j:j+3;
				s+=Math.min(m[j],m[j+3]);
				s+= (j%2!=0) ? (Math.min(m[2],m[5])):Math.min(Math.min(m[2],m[5]),m[8]);
			}
			else {
				int mi= m[j]<m[j+3] && m[j]<m[j+6]?j:m[j+3]<m[j+6]?j+3:j+6;
				s+=Math.min(Math.min(m[1],m[4]),m[7]);
				s+= (mi%2!=0) ? (Math.min(m[2],m[5])):Math.min(Math.min(m[2],m[5]),m[8]); 	
			}
			s1= s1>s? s:s1;
		}
			
		
		return s1;
}
*/
int cruceMinimo(int v[]) {
		int i=0,fJ=5,k,fK,j,n,m=2147483646;
		while (i<7){						
			j=(i==6)? 7:1;			
			while(j<fJ) {
				fK=(j==1)? 5:9;
				k=(j==7)? 5:2;
				while(k<fK){		
					n=v[i]+v[j]+v[k];
					m=(m<n)? m:n;
					k+=3;
				}
				j+=3;
			}
			fJ=8;
			i+=3;
		}
		return m;	
}
	
	public int[] getM() {
		return m1;
	}

	public void setM(int[] m2) {
		this.m1 = m2;
	}
}
