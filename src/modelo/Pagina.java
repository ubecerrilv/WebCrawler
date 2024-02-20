package modelo;

import java.util.ArrayList;

public class Pagina extends Automata{
	/*
	 * ATRIBUTOS
	 * */
	
	private String pag = "";
	private ArrayList<String> paginas;
	
	
	/*
	 * METODOS
	 * */
	public ArrayList<String> analiza (String cadena) {
		this.estado = "Q0";
		char [] cad = cadena.toCharArray();
		paginas = new ArrayList<String>();
		
		//RELLENAR EL ARRAYLIST
		for(int j =0; j<A.length;j++) {
			alfabeto.add(A[j]);
		}
		
		//AUTÓMATA
		for(int i = 0; i<cad.length;i++) {
			//VERIFICAR SI ES ESTADO FINAL Y FIN DE PAGINA, CASO POSITIVO AGREGAR AL ARRAY
			if((cad[i]==' ' || cad[i]=='>' || cad[i]=='"'|| cad[i]==',') && (this.estado.compareToIgnoreCase("Q11")==0||this.estado.compareToIgnoreCase("Q12")==0||
					                            this.estado.compareToIgnoreCase("Q13")==0)) {
				paginas.add(pag);
				pag="";
			}
			
			
			switch (this.estado) {
			case "Q0":
				if(cad[i]=='h') {
					this.estado="Q1";
					pag =""+cad[i];
				}
				continue;
			
			case "Q1":
				if(cad[i]=='t') {
					this.estado="Q2";
					pag=pag+cad[i];
				}else {
					this.estado="Q0";
					pag="";
				}
				continue;
				
			case "Q2":
				if(cad[i]=='t') {
					this.estado="Q3";
					pag=pag+cad[i];
				}else {
					this.estado="Q0";
					pag="";
				}
				continue;
				
			case "Q3":
				if(cad[i]=='p') {
					this.estado="Q4";
					pag=pag+cad[i];
				}else {
					this.estado="Q0";
					pag="";
				}
				continue;
				
			case "Q4":
				if(cad[i]=='s') {
					this.estado="Q5";
					pag=pag+cad[i];
				}else if(cad[i]==':') {
					this.estado="Q6";
					pag=pag+cad[i];
				}else {
					this.estado="Q0";
					pag="";
				}
				continue;
				
			case "Q5":
				if(cad[i]==':') {
					this.estado="Q6";
					pag=pag+cad[i];
				}else {
					this.estado="Q0";
					pag="";
				}
				continue;
				
			case "Q6":
				if(cad[i]=='/') {
					this.estado="Q7";
					pag=pag+cad[i];
				}else {
					this.estado="Q0";
					pag="";
				}
				continue;
				
			case "Q7":
				if(cad[i]=='/') {
					this.estado="Q8";
					pag=pag+cad[i];
				}else {
					this.estado="Q0";
					pag="";
				}
				continue;
//COLOCAR ALFABETO				
				
			case "Q8":
				if(alfabeto.contains(cad[i])) {
					this.estado="Q9";
					pag=pag+cad[i];
				}else {
					this.estado="Q0";
					pag="";
				}
				continue;
			case "Q9":
				if(alfabeto.contains(cad[i])) {
					this.estado="Q9";
					pag=pag+cad[i];
				}else if(cad[i]=='.') {
					this.estado="Q10";
					pag=pag+cad[i];
				}else {
					this.estado="Q0";
					pag="";
				}
				continue;
				
			case "Q10":
				if(alfabeto.contains(cad[i])) {
					this.estado="Q11";
					pag=pag+cad[i];
				}else {
					this.estado="Q0";
					pag="";
				}
				continue;
				
			case "Q11":
				if(cad[i]=='.') {
					this.estado="Q10";
					pag=pag+cad[i];
				}else if(alfabeto.contains(cad[i])) {
					this.estado="Q11";
					pag=pag+cad[i];
				}else if(cad[i]=='/') {
					this.estado="Q12";
					pag=pag+cad[i];
				}else {
					this.estado="Q0";
					pag="";
				}
				continue;
				
			case "Q12":
				if(cad[i]=='/') {
					this.estado="Q12";
					pag=pag+cad[i];
				}else if(alfabeto.contains(cad[i])) {
					this.estado="Q13";
					pag=pag+cad[i];
				}else {
					this.estado="Q0";
					pag="";
				}
				continue;
				
			case "Q13":
				if(alfabeto.contains(cad[i])) {
					this.estado="Q13";
					pag=pag+cad[i];
				}else if(cad[i]=='/') {
					this.estado="Q12";
					pag=pag+cad[i];
				}else if(cad[i]=='.') {
					this.estado="Q11";
					pag=pag+cad[i];
				}else {
					this.estado="Q0";
					pag="";
				}
				continue;
			}
		}//FIN FOR DEL STRING
	
		

		return paginas;
	}


	public void setPaginas(ArrayList<String> paginas) {
		this.paginas = paginas;
	}
	
	
}
