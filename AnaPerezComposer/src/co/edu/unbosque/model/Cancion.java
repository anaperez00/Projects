package co.edu.unbosque.model;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import co.edu.unbosque.model.persistence.ArchivoFile;
import co.edu.unbosque.model.persistence.Propiedades;

public class Cancion {

	private Palabra p;

	public Cancion () {
	 p = new Palabra();
	}

	public String crearCancion () {
		String estrofa="";
		String frase="";
		String cancion="";

		for (int i=0;i<3;i++) {
			for(int j=0;j<4;j++) {
				frase =p.getPalabra1()[(int) (Math.random()*4)]
						+p.getPalabra2()[(int)(Math.random()*4)]
								+p.getPalabra3()[(int)(Math.random()*4)]
										+p.getPalabra4()[(int)(Math.random()*4)]	
												+p.getPalabra5()[(int)(Math.random()*4)]	
														+p.getPalabra6()[(int)(Math.random()*4)]	;
				estrofa += frase+"\n";
			}
			cancion = estrofa+="\n";
		}
		return  cancion;
	}

	public String gestionarArchivoCadena(String nombre, String dato) {
		ArchivoFile archivo = new ArchivoFile ();
		archivo.ejecutarFileChosser();
		archivo.escribirArchivo(nombre +"\n" +dato);
		return archivo.leerArchivo();
	}

	public String gestionarPropiedades () {
		Propiedades prop = new Propiedades ();
		prop.ejecutarFileChosser();
		prop.escribirPropiedades();
		return "PROPIEDADES"+prop.leerPropiedades();
		
	}
}

