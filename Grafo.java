package Enlaces;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;


public class Grafo {
	public ArrayList<CiudadNodo> nodos = new ArrayList<CiudadNodo>();
	
	
	/*public Grafo(ArrayList<CiudadNodo> nodos, ArrayList<Enlace> enlaces) {
		this.nodos=nodos;
		this.enlaces = enlaces;
	}*/
	
	
    public void addNodo(CiudadNodo nodo) {
        
        nodos.add(nodo);
    }
    
    public  List getNodos() {
        return nodos;
    }
 
    public ArrayList<CiudadNodo> getNodes() {
        return nodos;
    }
    
    public boolean existeNodo(String city) {
        for(int i = 0; i<this.nodos.size();i++) {
            if (this.nodos.get(i).getCiudad().equals(city)) {
                //System.out.println("Si existe la " + city);
            	return true;
            }
            //return false;
        }
        
        //Aqui validamos que se agregue la torre si no existe
       // System.out.println("no existe la " + city);
        return false;
    }
 
    public boolean hasPathDfs(CiudadNodo source, CiudadNodo destination) {
    	String aux = "";
    	ArrayList<String> visit = new ArrayList<String>();
    	//HashSet visitados = new  HashSet();
    	boolean val = false ;
        if (this.existeNodo(source.getCiudad()) && this.existeNodo(destination.getCiudad())) 
        	
          val =  hasPathDfs(source , source, destination, visit);
        
        if(val==true) {
        	//visit  = new ArrayList<String>(visitados);
        	for(int i =0; i<visit.size(); i++) {
          	  aux = aux + visit.get(i).toString() + " => "  ;
          	
             }
        	System.out.println("+ "  + aux);
        	return true;
        }
        else {
        	System.out.println("- " + source.getCiudad()  +  " => " + destination.getCiudad());
            return false;
        }
          
        
    }
 
    public CiudadNodo obtenNodo(String ciudad) {
    	CiudadNodo aux ;
    	for(int i = 0; i<this.nodos.size(); i ++) {
    		if(this.nodos.get(i).getCiudad().equals(ciudad))
    			return (this.nodos.get(i));
    	}    	
    	return null;
    }
    
    public void agregaNodo(CiudadNodo nodo) {
    	if(this.nodos.isEmpty()) {
    		this.nodos.add(nodo);
    		return;
    	}
    	
    	
    		if(this.existeNodo(nodo.getCiudad())) {
    		return;
    		}else {
    		this.nodos.add(nodo);
    	return;}
    	
    }
    
    private boolean hasPathDfs(CiudadNodo source, CiudadNodo origen, CiudadNodo destination, ArrayList<String> visited ) {
    	ArrayList<Enlace> adyacentes = obtenNodo(source.getCiudad()).getAdjacents();
    	
    	if (visited.contains(source.getCiudad())) {
            return false;
        }
        visited.add(source.getCiudad());
        if (source == destination) {
            return true;
        }
        for (int i = 0; i<adyacentes.size();i++) {
        	//if(origen.getCiudad().equals(adyacentes.get(i).getOrigen().getCiudad())) 
        		//hasPathDfs(adyacentes.get(i+1).getDestino(), origen, destination, visited);
        		//if(visited.get(visited.size()-1).equals(destination.getCiudad()))
        		//visited.clear();
            if (hasPathDfs(adyacentes.get(i).getDestino(), origen, destination, visited)) {
                return true;
            }
           
        }
        visited.remove(visited.get(visited.size()-1));
        return false;
    }
    
 
    @Override
    public String toString() {
        return "Grafo [Ciudades=" + nodos + "]";
    }
    
    

    
}
