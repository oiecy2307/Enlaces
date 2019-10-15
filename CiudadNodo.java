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


public  class CiudadNodo {
   private String ciudad;
   private ArrayList<Enlace> adyacentes = new ArrayList<Enlace>();
 
    public CiudadNodo(String ciudad) {
        this.ciudad = ciudad;
    }
 
    public String getCiudad() {
        return ciudad;
    }
 
 /* 
 El metodo removeEdge recorre todos los enlaces de un nodo en particular para eliminar un enlace en base a la ciudad 
 o torre destino que es recibida como parametro.
   */
    public void removeEdge(String destino) {
    	
    	for(int i = 0; i<this.adyacentes.size();i++) {
    		
            if (this.adyacentes.get(i).getDestino().getCiudad().compareToIgnoreCase(destino)==0) {
            	
                this.adyacentes.remove(i);
                
                return;
                
            }
            
        }
    	
    	
    }
 
    /*El metodo addEdge evalua si la lista de enlaces está vacia, de asi serlo le agrega el enlace que recibimos como parametro, 
     sino, se busca entre los destinos una coincidencia en base al nombre de la torre, si existe el metodo termina, caso contrario
     el enlace es agregado a la lista de enlaces.
     */
    public void addEdge(Enlace edge) {
    	
    	if(this.adyacentes.isEmpty()) {
    		
    		this.adyacentes.add(edge);
    		
    		return;
    	}
    	
    	
    	for(int i = 0; i<this.adyacentes.size();i++) {
    		
            if (this.adyacentes.get(i).getDestino().getCiudad().compareToIgnoreCase(edge.getDestino().getCiudad())==0) {
            	
            	System.out.println("Si existe el enlace con " + edge.getDestino().getCiudad());
            	
            	return;
            
            }else {
            	
    	adyacentes.add(edge);
    	return;
    	
            }
    	}
    }
 
    public ArrayList<Enlace> getAdjacents() {
        return adyacentes;
    }
 
   
}