package Enlaces;



public  class Enlace {
  	    private CiudadNodo origen;
  	    private CiudadNodo destino;
  	    
  	 
  	    public Enlace(CiudadNodo origen, CiudadNodo destino) {
  	        this.origen = origen;
  	        this.destino = destino;
  	        
  	    }
  	 
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
  	 
  	 
  	
  	    @Override
  	    public String toString() {
  	        return "\n Enlace [origin=" + origen.getCiudad() + ", destination=" + destino.getCiudad() ;
  	    }
  }