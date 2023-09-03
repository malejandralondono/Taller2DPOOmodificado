package uniandes.dpoo.taller1.modelo;

public class Ingrediente {

	//Atributos
	
	private String nombre;
	
	private int costoAdicional;
	
	private int calorias;
	
	//Constructor
	
	public Ingrediente(String elNombre, int elcostoAdicional, int lasCalorias) {
		
		nombre = elNombre;
		costoAdicional = elcostoAdicional;
		calorias = lasCalorias; 
				
	}
	
	//Metodos
	
	public String getNombre() {
		
		return nombre;
		
		}
	
	public int getCostoAdicional() {
		
		return costoAdicional;
		
		}
	
	public int getCalorias() {
		return calorias;
	}
}
