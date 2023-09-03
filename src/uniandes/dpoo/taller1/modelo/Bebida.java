package uniandes.dpoo.taller1.modelo;

public class Bebida implements Producto{
	
	//Atributos
	
	private String nombre;
	
	private int precio;
	
	private int calorias;
	
	//Constructor
	
	public Bebida(String elNombre, int elPrecio, int lasCalorias) {
		
		nombre = elNombre;
		precio = elPrecio;
		calorias= lasCalorias;
	}

	public String getNombre() {
		return nombre;
	}

	public int getPrecio() {
		return precio;
	}

	public String generarTextoFactura() {
		
		String textoFactura = getNombre();
		textoFactura += "\n"; 
		int n = getPrecio();
		textoFactura += (String.valueOf(n));
		textoFactura += "\n"; 

		
		return textoFactura;
	}

	public int getCalorias() {
		return calorias;
	}

}
