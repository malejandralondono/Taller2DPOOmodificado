package uniandes.dpoo.taller1.modelo;


public class ProductoMenu implements Producto{
	
	//Atributos
	
	public String nombre;
	
	public int precioBase;
	
	//Constructor
	
	public ProductoMenu(String elNombre, int elprecioBase) {
		
		nombre = elNombre;
		precioBase = elprecioBase;
	}
	
	//Metodos
	
	public String getNombre() {
		
		return nombre;
	}

	public int getPrecio() {
		
		return precioBase;
		
	}

	public String generarTextoFactura() {
		
		String textoFactura = getNombre();
		textoFactura += "\n"; 
		int n = getPrecio();
		textoFactura += (String.valueOf(n));
		textoFactura += "\n"; 

		
		return textoFactura;}
	}

