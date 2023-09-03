package uniandes.dpoo.taller1.modelo;

public class Bebida implements Producto{
	
	//Atributos
	
	public String nombre;
	
	public int precio;
	
	//Constructor
	
	public Bebida(String elNombre, int elprecio) {
		
		nombre = elNombre;
		precio = elprecio;
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

}
