package uniandes.dpoo.taller1.modelo;

import java.util.Iterator;
import java.util.List;

public class Combo implements Producto{
	
	//Atributos
	
	private int descuento;
	
	private String nombreCombo;
		
	private List<Producto> itemsCombo;
	
	//Constructor
	
	public Combo(String elNombreCombo, int eldescuento, List<Producto> itemsDelCombo) {
		
		descuento = eldescuento;
		nombreCombo = elNombreCombo;
		itemsCombo = itemsDelCombo;
				
	}
	
	//Metodos
	
	public String getNombre() {
		
		return nombreCombo;
		
		}
	
	public String generarTextoFactura() {
		
		String textoFactura = getNombre();
		textoFactura += "\n"; 
		int n = getPrecio();
		textoFactura += (String.valueOf(n));
		textoFactura += "\n"; 

		
		return textoFactura;}
	
	public int getPrecio() {
		
		int precioFinal = 0;
		
		Iterator<Producto> iter = itemsCombo.iterator();
		
		while (iter.hasNext()) {
			
			
			precioFinal += iter.next().getPrecio();
		}
		
		precioFinal = precioFinal-((descuento*precioFinal)/100);
		
		return precioFinal;
		}

	public int getCalorias() {
		
		int caloriasTotales = 0;
		
		Iterator<Producto> iter = itemsCombo.iterator();
		
		while (iter.hasNext()) {
			
			
			caloriasTotales += iter.next().getCalorias();
		}
		
		return caloriasTotales;
	}
		
}

