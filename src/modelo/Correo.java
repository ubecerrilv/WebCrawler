package modelo;

import java.util.ArrayList;

public class Correo  {
	/*
	 * ATRIBUTOS
	 * */
	private String estado;
	private final char[] A = {'A','a','B','b','C','c','D','d','E','e','F','f','G','g','H','h','I','i','J','j','K','k','L','l','M','m','N','n',
			'Ñ','ñ','O','o','P','p','Q','q','R','r','S','s','T','t','U','u','V','v','W','w','X','x','Y','y','Z','z','_','&','-',
			'0','1','2','3','4','5','6','7','8','9'};
	private final char[] A2 = {'A','a','B','b','C','c','D','d','E','e','F','f','G','g','H','h','I','i','J','j','K','k','L','l','M','m','N','n',
			'Ñ','ñ','O','o','P','p','Q','q','R','r','S','s','T','t','U','u','V','v','W','w','X','x','Y','y','Z','z'};
	private ArrayList<Character> alfabeto = new ArrayList<Character>();
	private ArrayList<Character> alfabeto2 = new ArrayList<Character>();
	private String cor = "";
	private ArrayList<String> correos;
	

	/*
	 * METODOS
	 * */
	public ArrayList<String> analiza(String cadena) {
		this.estado = "Q0";
		char [] cad = cadena.toCharArray();
		correos = new ArrayList<String>();
		
		//RELLENAR EL ARRAYLIST
		for(int j =0; j<A.length;j++) {
			alfabeto.add(A[j]);
		}
		
		//RELLENAR EL ARRAYLIST
		for(int j =0; j<A2.length;j++) {
			alfabeto2.add(A2[j]);
		}
		
		//AUTÓMATA
		for(int i = 0; i<cad.length;i++) {
			//VERIFICAR SI ES ESTADO FINAL Y FIN DE PAGINA, CASO POSITIVO AGREGAR AL ARRAY
			if((cad[i]==' ' || cad[i]=='>' || cad[i]=='"'|| cad[i]==',') && (this.estado.compareToIgnoreCase("Q5")==0)) {
				correos.add(cor);
				cor="";
			}
			
			
			switch (this.estado) {
			case "Q0":
				if(alfabeto.contains(cad[i])) {
					this.estado="Q1";
					cor =""+cad[i];
				}
				continue;
			
			case "Q1":
				if(alfabeto.contains(cad[i])) {
					this.estado="Q1";
					cor=cor+cad[i];
				}else if(cad[i]=='@'){
					this.estado="Q2";
					cor=cor+cad[i];
				}else {	
					this.estado="Q0";
					cor="";
				}
				continue;
				
			case "Q2":
				if(alfabeto.contains(cad[i])) {
					this.estado="Q3";
					cor=cor+cad[i];
				}else {
					this.estado="Q0";
					cor="";
				}
				continue;
				
			case "Q3":
				if(alfabeto.contains(cad[i])) {
					this.estado="Q3";
					cor=cor+cad[i];
				}else if(cad[i]=='.'){
					this.estado="Q4";
					cor=cor+cad[i];
				}else {	
					this.estado="Q0";
					cor="";
				}
				continue;
				
			case "Q4":
				if(cad[i]=='.') {
					this.estado="Q4";
					cor=cor+cad[i];
				}else if(alfabeto2.contains(cad[i])) {
					this.estado="Q5";
					cor=cor+cad[i];
				}else {	
					this.estado="Q0";
					cor="";
				}
				continue;
				
			case "Q5":
				if(cad[i]=='.') {
					this.estado="Q4";
					cor=cor+cad[i];
				}else if(alfabeto2.contains(cad[i])) {
					this.estado="Q5";
					cor=cor+cad[i];
				}else {	
					this.estado="Q0";
					cor="";
				}
				continue;
	
			}
		}//FIN FOR STRING
		

		
		
		return correos;
	}

}
