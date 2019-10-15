package Enlaces;
/*
Maestría en ciencias de las computación
Tecnologias de programación
Agosto-Diciembre 2019
Tutor@: Dra. Lucia Barron Estrada
Alumno: Oscar Eliut Sandoval Alfaro 
*/


public  class Enlace {
  	    private CiudadNodo origen;
  	    private CiudadNodo destino;
  	    
  	 
  	    public Enlace(CiudadNodo origen, CiudadNodo destino) {
  	        this.origen = origen;
  	        this.destino = destino;
  	        
  	    }
  	 /*
  	  Getters y Setters para la clase Enlace.

  	  */
  	    public CiudadNodo getOrigen() {
  	        return origen;
  	    }
  	 
  	    public void setOrigen(CiudadNodo origen) {
  	        this.origen = origen;
  	    }
  	 
  	    public CiudadNodo getDestino() {
  	        return destino;
  	    }
  	 
  	    public void setDestination(CiudadNodo destino) {
  	        this.destino = destino;
  	    }
  	 

  	   
  }