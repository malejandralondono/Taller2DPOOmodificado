package uniandes.dpoo.taller1.modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class Restaurante{
	
	//Atributos
	
	private List<Ingrediente> Ingredientes;
	
	private List<ProductoMenu> MenuBase;

	private List<Combo> Combos;
	
	private Pedido pedidoEnCurso;
	
	private List<Pedido> Pedidos;
	
	//Constructor
	
	public Restaurante() {
		
		Ingredientes = new ArrayList<Ingrediente>(); 
		MenuBase = new ArrayList<ProductoMenu>();
		pedidoEnCurso = null;
		Pedidos = new ArrayList<Pedido>();;
		Combos = new ArrayList<Combo>();;
		
	}
	
		
	//Metodos
	
	public void iniciarPedido(String nombreCliente , String direccionCliente) {
		
		this.pedidoEnCurso = new Pedido(nombreCliente, direccionCliente);
	}
	
	public void cerrarGuardarPedido() {
		pedidoEnCurso.guardarFactura();
	}
	
	public Pedido getPedidoEnCurso() {return pedidoEnCurso;}
	
	public List<ProductoMenu> getMenuBase(){return MenuBase;}
	
	public List<Ingrediente> getIngredientes(){return Ingredientes;}
	
	public List<Combo> getCombos(){return Combos;}
	
	public List<Pedido> getPedidos(){return Pedidos;}
			
	public void cargarInfoRestaurante(String archivoIngredientes, String archivoMenu, String archivoCombos ) throws IOException {
		
		cargarIngredientes(archivoIngredientes);
		cargarMenu(archivoMenu);
		cargarCombos(archivoCombos);
		
		
	}
	
	private void cargarIngredientes(String archivoIngredientes) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new FileReader(archivoIngredientes));
		
		String linea = br.readLine();
		while (linea != null) {
			String[] partes = linea.split(";");
			String nombreIngrediente = partes[0];
			int precio = Integer.parseInt(partes[1]);
			
			Ingrediente elingrediente = new Ingrediente(nombreIngrediente, precio);
			Ingredientes.add(elingrediente);

			linea = br.readLine(); 
		}

		br.close();
		
		}
		
	private void cargarMenu(String archivoMenu) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new FileReader(archivoMenu));
		
		String linea = br.readLine();
		while (linea != null) {
			String[] partes = linea.split(";");
			String nombreProducto = partes[0];
			int precio = Integer.parseInt(partes[1]);
			
			ProductoMenu elProducto = new ProductoMenu(nombreProducto, precio);
			MenuBase.add(elProducto);
			
			linea = br.readLine(); 
		}

		br.close();
				
		}
		
	private void cargarCombos(String archivoCombos) throws IOException {
		
				
		BufferedReader br = new BufferedReader(new FileReader(archivoCombos));
		
		String linea = br.readLine();
		while (linea != null) {
			String[] partes = linea.split(";");
			String nombreCombo = partes[0];
			int porcentajeDescuento = Integer.parseInt((partes[1]).split("%")[0]);
			String producto1Combo = partes[2];
			String producto2Combo = partes[3];
			String producto3Combo = partes[4];
			
			List<Producto> itemsDelCombo = new ArrayList<Producto>();
			
			ProductoMenu Producto1 = BuscarProductoPorNombre(producto1Combo);
			ProductoMenu Producto2 = BuscarProductoPorNombre(producto2Combo);
			ProductoMenu Producto3 = BuscarProductoPorNombre(producto3Combo);
			
			itemsDelCombo.add(Producto1);
			itemsDelCombo.add(Producto2);
			itemsDelCombo.add(Producto3);
			
			Combo elCombo = new Combo(nombreCombo, porcentajeDescuento, itemsDelCombo);
			Combos.add(elCombo);
			
			
			linea = br.readLine(); 
		}

		br.close();
		}
	
	private ProductoMenu BuscarProductoPorNombre(String nombre) {
		
		ProductoMenu elProducto = null;
		for (int i = 0; i < MenuBase.size() && elProducto == null; i++)
		{
			if (MenuBase.get(i).getNombre().equals(nombre))
				elProducto = MenuBase.get(i);
		}
		return elProducto;
	}
	
}
	
