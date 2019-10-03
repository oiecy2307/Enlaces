package Enlaces;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Enlaces {
	
public Enlaces() throws FileNotFoundException, IOException {
	
	leerArchivoTxt("/Users/Oscar/Desktop/Enlaces.txt");
}
	
public static void main(String [] args) throws IOException{
	new Enlaces();
}



public  void leerArchivoTxt(String archivo) throws FileNotFoundException, IOException {
	Grafo g = new Grafo();
	String cadena;
	FileReader fr = new FileReader(archivo);
	BufferedReader bf = new BufferedReader(fr);
	
	while((cadena = bf.readLine())!=null) {
		
		revisarPatron(cadena,  g);
		
		
	}
	bf.close();
}


public static void revisarPatron(String cadena, Grafo g) {
	String regEx1 = "^((([A-z])([a-zA-Z0-9]{0,14})\\s*(->|-|<-)\\s*([A-z])([a-zA-Z0-9]{0,14})\\s*[.])|(([A-z])([a-zA-Z0-9]{0,14})\\s*(=>|<=)\\s*([A-z])([a-zA-Z0-9]{0,14})(\\s*)[?]))";
	String[] torres ;
	String aux; 
	Pattern p =  Pattern.compile(regEx1);
	Matcher m = p.matcher(cadena);
	StringTokenizer st ;
	CiudadNodo origen ;
	CiudadNodo destino;
	 
	if(m.find()) {
	cadena =m.group();
	
	
	if(cadena.contains(".") && cadena.contains("->")){
		//Asignar enlace de izquierda  a derecha
		aux = m.group().replaceAll("(->|<-|-|\\.)", " ");
		torres = aux.split(" ");
		origen = new CiudadNodo(torres[0]);
		destino = new CiudadNodo(torres[1]);
		g.agregaNodo(origen);
		g.agregaNodo(destino);
		g.obtenNodo(origen.getCiudad()).addEdge(new Enlace(origen,destino));

		
		return;
		
	}
	
	if(cadena.contains(".") && cadena.contains("<-")){
	//Asignar enlace de derecha a izquierda
		aux = m.group().replaceAll("(->|<-|-|\\.)", " ");
		torres = aux.split(" ");
		origen = new CiudadNodo(torres[1]);
		destino = new CiudadNodo(torres[0]);
		g.agregaNodo(origen);
		g.agregaNodo(destino);
		g.obtenNodo(origen.getCiudad()).addEdge(new Enlace(origen,destino));

		return;
	}
	if(cadena.contains(".") && cadena.contains("-")){
	//quitar enlace 
		aux = m.group().replaceAll("(-|\\.)", " ");
		torres = aux.split(" ");
		origen = new CiudadNodo(torres[0]);
		destino = new CiudadNodo(torres[1]);
		
		//System.out.println(st.nextToken().toString() + " quitar link ");
		return;
	}
	
	if(cadena.contains("?") && cadena.contains("=>")){
		 
			aux = m.group().replaceAll("(=>|<=|\\?)", " ");
			torres = aux.split(" ");
			origen = g.obtenNodo(torres[0]);
			destino = g.obtenNodo(torres[1]);
			g.hasPathDfs(origen, destino);
			
			return;
		}
	
	if(cadena.contains("?") && cadena.contains("<=")){
		
			aux = m.group().replaceAll("(=>|<=|\\?)", " ");
			torres = aux.split(" ");
			origen = g.obtenNodo(torres[1]);
			destino = g.obtenNodo(torres[0]);
			g.hasPathDfs(origen, destino);
			
			return;
		}
	}
	System.out.println("Linea Invalida");
	return;

}


}
