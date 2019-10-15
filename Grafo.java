package Enlaces;
/*
Maestría en ciencias de las computación
Tecnologias de programación
Agosto-Diciembre 2019
Tutor@: Dra. Lucia Barron Estrada
Alumno: Oscar Eliut Sandoval Alfaro 
*/
import java.util.ArrayList;

import java.util.List;



public class Grafo {
	public ArrayList<CiudadNodo> nodos = new ArrayList<CiudadNodo>();
	

    
  
    public ArrayList<CiudadNodo> getNodes() {
        return nodos;
    }
    
    /*
     * El metodo existeNodo retorna verdadero en caso de que la cadena que se recibe como parametro 
      coindida con el nombre de alguna ciudad o nombre de torre dentro de los nodos contenidos en el 
      grafo, y regresa falso si no existe.
      */
    public boolean existeNodo(String city) {
    	
        for(int i = 0; i<this.nodos.size();i++) {
            if (this.nodos.get(i).getCiudad().compareToIgnoreCase(city)==0) {
                
            	return true;
            }
            
        }
        return false;
    }
    
    
   /*
     El metodo buscarCamino recibe dos objetos CiudadNodo, uno indica el origen y el otro indica el destino
     si ambos nodos existen, se ejecuta el metodo trazarCamino, que devuelve un boolean, si se encuentra una 
     ruta o camino devuelve verdadero, caso contrario devuelve falso. 
     
     Dicho boolean asignado a una variable que dependiendo su valor determina la impresion en consola, si es verdadero 
     imprime la ruta desde el origen hasta el destino, caso contrario imprime que no hay ruta para el origen y el destino 
     en cuestion.
     
         */
    public boolean buscarCamino(CiudadNodo source, CiudadNodo destination) {
    	String aux = "";
    	ArrayList<String> visit = new ArrayList<String>();
    	boolean val = false ;
    	
        if (this.existeNodo(source.getCiudad()) && this.existeNodo(destination.getCiudad())) 
        	
          val =   trazarCamino(source , source, destination, visit);
        
        //quitar comparacion
        if(val==true) {
        	
        	for(int i =0; i<visit.size(); i++) {
          	  aux = aux + " => " + visit.get(i).toString()   ;
          	
             }
        	
        	System.out.println("+ "  + aux);
        	return true;
        	
        }else{
        	
        	System.out.println("- " + source.getCiudad()  +  " => " + destination.getCiudad());
             return false;
        }
          
        
    }
 
    
    /*
     Este metodo busca un nodo dentro del grafo en base a la ciudad, si lo encuentra retorna un objeto
     de tipo CiudadNodo, caso contrario retorna un nulo.
     
     */
    public CiudadNodo obtenNodo(String ciudad) {
    	CiudadNodo aux ;
    	
    	for(int i = 0; i<this.nodos.size(); i ++) {
    		if(this.nodos.get(i).getCiudad().compareToIgnoreCase(ciudad)==0)
    			return (this.nodos.get(i));
    	}
    	
    	return null;
    }
    
    /*El metodo agregaNodo evalua si la lista de nodos está vacia, de asi serlo le agrega el nodo que recibimos como parametro, 
    sino, se busca entre los nodos una coincidencia en base al nombre de la torre, si existe el metodo termina, caso contrario
    el nodo es agregado a la lista de nodos.
    */
    public void agregaNodo(CiudadNodo nodo) {
    	
    	if(this.nodos.isEmpty()) {
    		
    		this.nodos.add(nodo);
    		
    		return;
    	}
    	
    	
    		if(this.existeNodo(nodo.getCiudad())) {
    			
    		return;
    		
    		} else {
    			
    		this.nodos.add(nodo);
    		
    		return;
    	
    		}
    	
    }
    
    
    /*
     El metodo trazarCamino comienza por instanciar un ArrayList de tipo Enlace que contendrá los nodos adyacentes o vecinos del 
     objeto source que entra como parametro, se evalua si el objeto source de tipo CiudadNodo ya ha sido visitado, de ser asi el 
     metodo retorna falso para terminar el programa, caso contrario agrega el nodo a la lista de visitados, despues de agregar el nodo
     se evalua si el nombre de la ciudad es igual al nombre de la ciudad del nodo destino, de ser asi retorna un verdadero, caso contrario
     se recorre la lista de adyacentes del objeto source, para ejecutar el metodo trazarCamino con un nuevo vecino, que en esta nueva ejecucion
     representará al objeto source.
     
     Dado que ya no haya mas vecinos y no se encuentre un camino, se ira removiendo el ultimo visitado durante cada ejecucion.  
     */
    
    private boolean trazarCamino(CiudadNodo source, CiudadNodo origen, CiudadNodo destination, ArrayList<String> visited ) {
    	
    	ArrayList<Enlace> adyacentes = obtenNodo(source.getCiudad()).getAdjacents();
    	
    	if (visited.contains(source.getCiudad())) {
    		
            return false;
        }
    	
        visited.add(source.getCiudad());
        
        if (source.getCiudad().compareToIgnoreCase(destination.getCiudad()) == 0) {
        	
            return true;
        }
        for (int i = 0; i<adyacentes.size();i++) {
        	
            if (trazarCamino(adyacentes.get(i).getDestino(), origen, destination, visited)) {
            	
                return true;
            }
           
        }
        
        visited.remove(visited.get(visited.size()-1));
        return false;
    }
    
 
  
    

    
}
