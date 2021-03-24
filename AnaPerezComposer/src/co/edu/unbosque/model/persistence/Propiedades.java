package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JFileChooser;

public class Propiedades {
	private Properties prop= new Properties();
  //	private String archivoprop= "./Data/Propiedades.txt";	
	private JFileChooser seleccionarArchivo = new JFileChooser();
	private File archivoSeleccionado;

	public void ejecutarFileChosser() {
		seleccionarArchivo.showOpenDialog(null);
		archivoSeleccionado = seleccionarArchivo.getSelectedFile();
	}

	public int escribirPropiedades() {
		try {
			prop.setProperty("NombreArchivo","ComposerRegueton");
			prop.setProperty("nombreProyecto","archivo.Properties");
			prop.setProperty("nombreNpmbreCodigoFuente","Propiedades.Java");
			prop.store(new FileOutputStream(archivoSeleccionado), null);
		}
		catch (IOException ex) {
			return -1;
		}
		return 0;
	}
	
	public String leerPropiedades() {
		String linea="";
		try {
			prop.load(new FileInputStream(archivoSeleccionado));

			prop.list(System.out);

			linea+="nombre  del Proyecto"+prop.getProperty("nombreProyecto")+"\n";
			linea +="nombre del Archivo: "+prop.getProperty("nombreArchivo")+"\n";
			linea +="nombre  de la clase Java: " +prop.getProperty("nombreCodigofuente")+"\n";
		}
		catch (IOException ex) {
			return null;
		}
		return linea;
	}
}
