package uniandes.dpoo.taller1.modelo;

public class Ingrediente {

	//Atributos
	
	private String nombre;
	
	private int costoAdicional;
	
	//Constructor
	
	public Ingrediente(String elNombre, int elcostoAdicional) {
		
		nombre = elNombre;
		costoAdicional = elcostoAdicional;
				
	}
	
	//Metodos
	
	public String getNombre() {
		
		return nombre;
		
		}
	
	public int getCostoAdicional() {
		
		return costoAdicional;
		
		}
}
