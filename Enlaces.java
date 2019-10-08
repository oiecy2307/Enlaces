package Enlaces;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import java.util.List;


import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Enlaces {
	
public Enlaces() throws FileNotFoundException, IOException {
	
	leerArchivoTxt("/Users/Oscar/Desktop/Enlaces.txt");
}
	
public static void main(String [] args) throws IOException{
	new Enlaces();
}


/*
El metodo leerArchivo recibe como cadena la ruta del archivo que será procesado para evaluar cada 
linea contenida y validar su contenido a traves del metodo revisarPatron. 
*/
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


/*
El metodo revisarPatron recibe una cadena proveniente de una linea leida previamente de un archivo de texto, y un objeto grafo
al que se le iran colocando los nodos conforme avanza el programa. La cadena es evaluada a traves de una expresion regular, y 
dado que se cumple que la cadena es valida en base a la regex, se evaluan los escenarios donde la cadena trae consigo la instruccion de
asignar un enlace de izquierda a derecha o viceversa, preguntar si existe comuncacion de izquierda a derecha o viceversa, y por 
ultimo eliminar el enlace entre los nodos descritos, de izquierda a derecha.
En caso de que la cadena no satisfaga a la expresion regular, el metodo termina.
 */
public static void revisarPatron(String cadena, Grafo g) {
	String regEx1 = "^((([A-z])([a-zA-Z0-9]{0,14})\\s*(->|-|<-)\\s*([A-z])([a-zA-Z0-9]{0,14})\\s*[.])|(([A-z])([a-zA-Z0-9]{0,14})\\s*(=>|<=)\\s*([A-z])([a-zA-Z0-9]{0,14})(\\s*)[?]))";
	String[] torres ;
	String aux; 
	Pattern p =  Pattern.compile(regEx1);
	Matcher m = p.matcher(cadena);

	CiudadNodo origen ;
	CiudadNodo destino;
	 
	if(m.find()) {
	cadena =m.group();
	
	//Si la cadena contiene . y -> entonces indica la creacion de un enlace de izquierda a derecha
	//Al grafo que es recibido por parametro se le agregan los nodos y se crea un enlace entre ellos.
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
	
	//Si la cadena contiene . y <- entonces indica la creacion de un enlace de derecha a izquierda
	//Al grafo que es recibido por parametro se le agregan los nodos y se crea un enlace entre ellos.
	if(cadena.contains(".") && cadena.contains("<-")){
	
		aux = m.group().replaceAll("(->|<-|-|\\.)", " ");
		torres = aux.split(" ");
		origen = new CiudadNodo(torres[1]);
		destino = new CiudadNodo(torres[0]);
		g.agregaNodo(origen);
		g.agregaNodo(destino);
		g.obtenNodo(origen.getCiudad()).addEdge(new Enlace(origen,destino));

		return;
	}
	
	//Si la cadena contiene . y - entonces indica la eliminacion de un enlace de izquierda a derecha
	//Al grafo que es recibido por parametro, se toma el nodo en cuestion (izquierdo) y se elimina el enlace con respecto al derecho.
	if(cadena.contains(".") && cadena.contains("-")){
	 
		aux = m.group().replaceAll("(-|\\.)", " ");
		torres = aux.split(" ");
		origen = new CiudadNodo(torres[0]);
		destino = new CiudadNodo(torres[1]);
		g.obtenNodo(torres[0]).removeEdge(torres[1]);
		
		return;
	}
	
	//Si la cadena contiene . y => entonces indica la interrogante de un camino o enlance de izquierda a derecha
	//Al grafo que es recibido por parametro es inspeccionado para encontrar un camino entre los nodos en cuestion.
	if(cadena.contains("?") && cadena.contains("=>")){
		 
			aux = m.group().replaceAll("(=>|<=|\\?)", " ");
			torres = aux.split(" ");
			origen = g.obtenNodo(torres[0]);
			destino = g.obtenNodo(torres[1]);
			g.buscarCamino(origen, destino);
			
			return;
		}
	
	//Si la cadena contiene . y <= entonces indica la interrogante de un camino o enlance de derecha a izquierda  
	//Al grafo que es recibido por parametro es inspeccionado para encontrar un camino entre los nodos en cuestion.
	if(cadena.contains("?") && cadena.contains("<=")){
		
			aux = m.group().replaceAll("(=>|<=|\\?)", " ");
			torres = aux.split(" ");
			origen = g.obtenNodo(torres[1]);
			destino = g.obtenNodo(torres[0]);
			g.buscarCamino(origen, destino);
			
			return;
		}
	}
	
	//Si la cadena no satisface a la expresion regular, el metodo termina, permitiendo una nueva ejecucion con la siguiente cadena.
	System.out.println("Linea Invalida");
	return;

}


}
