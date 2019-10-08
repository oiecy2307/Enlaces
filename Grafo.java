package Enlaces;
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
        
        if(val==true) {
        	
        	for(int i =0; i<visit.size(); i++) {
          	  aux = aux + visit.get(i).toString() + " => "  ;
          	
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
    
    
    private boolean trazarCamino(CiudadNodo source, CiudadNodo origen, CiudadNodo destination, ArrayList<String> visited ) {
    	
    	ArrayList<Enlace> adyacentes = obtenNodo(source.getCiudad()).getAdjacents();
    	
    	if (visited.contains(source.getCiudad())) {
    		
            return false;
        }
    	
        visited.add(source.getCiudad());
        
        if (source == destination) {
        	
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
