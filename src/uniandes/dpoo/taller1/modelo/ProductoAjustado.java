package uniandes.dpoo.taller1.modelo;

import java.util.ArrayList;
import java.util.List;

public class ProductoAjustado implements Producto{
	
	//Atributos 
	
	private Producto Base; 
	
	private List<Ingrediente> Agregados;
	
	private List<Ingrediente> Eliminados;

	//Constructor
	
	public ProductoAjustado(Producto base) {
		
		Base = base;
		Agregados = new ArrayList<Ingrediente>();
		Eliminados= new ArrayList<Ingrediente>();
	};

	//Metodos
	
	public void agregarIngrediente(Ingrediente nuevoIngrediente) {
		
		Agregados.add(nuevoIngrediente);
	}
	
	public void eliminarIngrediente(Ingrediente nuevoIngrediente) {
		
		Eliminados.add(nuevoIngrediente);
	}
	
	public String getNombre() {

		String Nombre = Base.getNombre() + "\n";
		
		if (Agregados.size()>=1)	{
			
			Nombre += ("\n"+"Con"+ "\n");
			
			for (int i = 0; i < Agregados.size() ; i++)
			{
				String n = Agregados.get(i).getNombre();
				
				Nombre += (n + "\n");
			}
		}	
		if (Eliminados.size()>=1)	{
			
			Nombre += ("\n"+"Sin"+ "\n");
			
			for (int i = 0; i < Eliminados.size() ; i++)
			{
				String n = Eliminados.get(i).getNombre();
				
				Nombre += (n + "\n");
			}}
		return Nombre;
	}

	public int getPrecio() {

		int Precio = Base.getPrecio();
		
		if (Agregados.size()>=1)	{
			
			
			for (int i = 0; i < Agregados.size() ; i++)
			{
				int n = Agregados.get(i).getCostoAdicional();
				
				Precio += n;
			}
		}	
		
		return Precio;
	}

	public String generarTextoFactura() {
		
		String textoFactura = this.getNombre();
		textoFactura += "\n"; 
		int n = this.getPrecio();
		textoFactura += (String.valueOf(n));
		textoFactura += "\n"; 

		
		return textoFactura;}

	@Override
	public int getCalorias() {
		// TODO Auto-generated method stub
		return 0;
	}

}
