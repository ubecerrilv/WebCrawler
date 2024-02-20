package modelo;

import java.util.ArrayList;

public abstract class Automata {
	
	protected String estado;
	protected final char[] A = {'A','a','B','b','C','c','D','d','E','e','F','f','G','g','H','h','I','i','J','j','K','k','L','l','M','m','N','n',
			'Ñ','ñ','O','o','P','p','Q','q','R','r','S','s','T','t','U','u','V','v','W','w','X','x','Y','y','Z','z','=',':','_','?','&','-',
			'0','1','2','3','4','5','6','7','8','9'};
	protected ArrayList<Character> alfabeto = new ArrayList<Character>();

	
	public abstract ArrayList<String> analiza(String cadena);
}
