package uniandes.dpoo.taller1.modelo;


public class ProductoMenu implements Producto{
	
	//Atributos
	
	private String nombre;
	
	private int precioBase;
	
	private int calorias;
	
	
	
	//Constructor
	
	public ProductoMenu(String elNombre, int elPrecioBase, int lasCalorias) {
		
		nombre = elNombre;
		precioBase = elPrecioBase;
		calorias = lasCalorias;
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

	@Override
	public int getCalorias() {
		return calorias;
	}
	}

