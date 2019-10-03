package Enlaces;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public  class CiudadNodo {
   private String ciudad;
 
   private ArrayList<Enlace> adyacentes = new ArrayList<Enlace>();
 
    public CiudadNodo(String ciudad) {
        this.ciudad = ciudad;
    }
 
    public String getCiudad() {
        return ciudad;
    }
 
 
 
    public void addEdge(Enlace edge) {
    	adyacentes.add(edge);
    }
 
    public ArrayList<Enlace> getAdjacents() {
        return adyacentes;
    }
 
    @Override
    public String toString() {
        return "Node [city=" + ciudad + ", adjacents=" + adyacentes + "]";
    }
}