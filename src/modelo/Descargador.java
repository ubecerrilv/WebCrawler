package modelo;

	import java.io.BufferedInputStream;
	import java.io.IOException;
	import java.net.MalformedURLException;
	import java.net.URL;
	import java.net.URLConnection;


	public class Descargador {

	    public String obtenerHTML(String urlS) {

	        try {
	            URL url = new URL(urlS);
	            
	            URLConnection urlc = url.openConnection();

	            BufferedInputStream buffer = new BufferedInputStream(urlc.getInputStream());

	            StringBuilder HTML = new StringBuilder();
	            int byteRead;
	            while ((byteRead = buffer.read()) != -1)

	                HTML.append((char) byteRead);

	            buffer.close();
	           // System.out.println(HTML.toString());
	            
	            return HTML.toString();

	           

	            /*System.out.println("The size of the web page is " + builder.length() + " bytes.");*/

	        } catch (MalformedURLException ex) {

	            ex.printStackTrace();
	            return "";

	        } catch (IOException ex) {

	            ex.printStackTrace();
	            return"";

	        }

	    }
	}


