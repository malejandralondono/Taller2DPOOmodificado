package uniandes.dpoo.taller1.consola;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import uniandes.dpoo.taller1.modelo.Bebida;
import uniandes.dpoo.taller1.modelo.Combo;
import uniandes.dpoo.taller1.modelo.Ingrediente;
import uniandes.dpoo.taller1.modelo.Pedido;
import uniandes.dpoo.taller1.modelo.Producto;
import uniandes.dpoo.taller1.modelo.ProductoAjustado;
import uniandes.dpoo.taller1.modelo.ProductoMenu;
import uniandes.dpoo.taller1.modelo.Restaurante;



public class Aplicacion

{
	Restaurante restaurante = null;
	
	public void ejecutarAplicacion() throws IOException
	{
		System.out.println("Bienvenido a Hamburguesas :)");

		boolean continuar = true;
		while (continuar)
		{
			try
			{
				mostrarMenu();
				int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
					 if (opcion_seleccionada == 1)
					ejecutarIniciarRestaurante();
				else if (opcion_seleccionada == 2 && restaurante != null)
					ejecutarMostrarMenu();
				else if (opcion_seleccionada == 3 && restaurante != null)
					ejecutarIniciarNuevoPedido();
				else if (opcion_seleccionada == 4 && restaurante != null)
					ejecutarAgregarElemento();
				else if (opcion_seleccionada == 5 && restaurante != null)
					ejecutarCerrarPedidoGuardarFactura();
				else if (opcion_seleccionada == 6 && restaurante != null)
					ejecutarConsultarPedido();
				else if (opcion_seleccionada == 7)
				{
					System.out.println("Saliendo de la aplicación ...");
					continuar = false;
				}
				else if (restaurante == null)
				{
					System.out.println("Para poder ejecutar esta opción primero debe iniciar restaurante");
				}
				else
				{
					System.out.println("Por favor seleccione una opción válida.");
				}
			}
			catch (NumberFormatException e)
			{
				System.out.println("Debe seleccionar uno de los números de las opciones.");
			}
		}
	}
	
	public void mostrarMenu()
	{
		System.out.println("\nOpciones de la aplicación\n");
		System.out.println("1. Cargar datos del restaurante");
		System.out.println("2. Mostrar el menú del restaurante");
		System.out.println("3. Iniciar un nuevo pedido");
		System.out.println("4. Agregar un elemento a un pedido");
		System.out.println("5. Cerrar un pedido y guardar la factura");
		System.out.println("6. Consultar la información de un pedido dado su id");
		System.out.println("7. Salir de la aplicación\n");
	}
	
	public void ejecutarIniciarRestaurante() throws IOException{
		
		System.out.println("\n" + "Iniciando Restaurante..." + "\n");
		
		restaurante = new Restaurante();

		restaurante.cargarInfoRestaurante("./data/ingredientes.txt", "./data/menu.txt", "./data/combos.txt", "./data/bebidas.txt" );
		
		System.out.println("\n" + "Se ha iniciado el restaurante" + "\n");
		
	}
	
	public void ejecutarMostrarMenu(){
		
		System.out.println("\n" + "Cargando Menu Restaurante..." + "\n");
		System.out.println("MENÚ HAMBURGUESAS"+ "\n");
		
		List<ProductoMenu> MenuBase = restaurante.getMenuBase();
		System.out.println("PRODUCTOS INDIVIDUALES"+ "\n");
		
			for (int i = 0; i < MenuBase.size() ; i++)
			{

				String n = MenuBase.get(i).getNombre();
				int p = MenuBase.get(i).getPrecio();
				
				System.out.println(String.valueOf(i+1));
				System.out.println(String.valueOf(n));
				System.out.println(String.valueOf(p));
				System.out.println("\n");
			}
			
		List<Ingrediente> Ingredientes = restaurante.getIngredientes();
		System.out.println( "\n" + "ADICIONES"+ "\n");
		
			for (int i = 0; i < Ingredientes.size() ; i++)
			{
	
				String n = Ingredientes.get(i).getNombre();
				int p = Ingredientes.get(i).getCostoAdicional();
				
				System.out.println(String.valueOf(i+1));
				System.out.println(String.valueOf(n));
				System.out.println(String.valueOf(p));
				System.out.println("\n");
			}
		
		List<Combo> Combos = restaurante.getCombos();
		System.out.println( "\n" + "COMBOS"+ "\n");
			
			for (int i = 0; i < Combos.size() ; i++)
			{
	
				String n = Combos.get(i).getNombre();
				int p = Combos.get(i).getPrecio();
				
				System.out.println(String.valueOf(i+1));
				System.out.println(String.valueOf(n));
				System.out.println(String.valueOf(p));
				System.out.println("\n");
			}
	
		List<Bebida> Bebidas = restaurante.getBebidas();
		System.out.println( "\n" + "BEBIDAS"+ "\n");
			
			for (int i = 0; i < Bebidas.size() ; i++)
			{
	
				String n = Bebidas.get(i).getNombre();
				int p = Bebidas.get(i).getPrecio();
				
				System.out.println(String.valueOf(i+1));
				System.out.println(String.valueOf(n));
				System.out.println(String.valueOf(p));
				System.out.println("\n");
			}
	}
	
	public void ejecutarIniciarNuevoPedido(){
		
		System.out.println("\n" + "Para poder iniciar un nuevo pedido ingrese los siguientes datos: " + "\n");
		
		String nombre = input("Nombre");
		String direccion = input("Direccion");
		
		restaurante.iniciarPedido(nombre, direccion);
		
		System.out.println("\n" + "Se ha iniciado su pedido" + "\n");
		
		
	}
	
	public void ejecutarAgregarElemento()
	{
		
		if (restaurante.getPedidoEnCurso()==null) 
		{
			
		System.out.println("Debe iniciar un pedido para poder añadir un elemento");
		
		}
		
		else 
		{
			
		Pedido p = restaurante.getPedidoEnCurso();
			
		Producto elProducto = null;
		
		System.out.println("\n" + "Que tipo de elemento desea agregar a su pedido: " + "\n" + "Seleccione una opción");
		
		System.out.println("\n" + "1. PRODUCTO INDIVIDUAL" + "\n" + "2. COMBO"+ "\n"+ "3. BEBIDA"+ "\n" );
		
		String opcion = input("1/2/3");

		if (opcion.equals("1")) 
		{
			
			List<ProductoMenu> MenuBase = restaurante.getMenuBase();
			System.out.println("PRODUCTOS INDIVIDUALES"+ "\n");
			
				for (int i = 0; i < MenuBase.size() ; i++)
				{

					String n = MenuBase.get(i).getNombre();
					
					System.out.println(String.valueOf(i+1));
					System.out.println(String.valueOf(n));
					System.out.println("\n");
				}
			int elegido = Integer.parseInt(input("\n" + "Seleccione el número del producto a añadir"));
			
			if (elegido>MenuBase.size()) 
			{System.out.println("Seleccion Invalida"+ "\n");}
			
			else {
			elProducto = MenuBase.get(elegido-1);}			
		}
		
		else if (opcion.equals("2")) 
		{
			
			List<Combo> Combos = restaurante.getCombos();
			System.out.println( "\n" + "COMBOS"+ "\n");
				
				for (int i = 0; i < Combos.size() ; i++)
				{
		
					String n = Combos.get(i).getNombre();
					
					System.out.println(String.valueOf(i+1));
					System.out.println(String.valueOf(n));
					System.out.println("\n");
				}
			int elegido = Integer.parseInt(input("\n" + "Seleccione el número del combo a añadir"));
			
			if (elegido>Combos.size()) 
			{System.out.println("Seleccion Invalida"+ "\n");}
			
			else {
				elProducto = Combos.get(elegido-1);}
		
		}
		
		else if (opcion.equals("3")) 
		{
			
			List<Bebida> bebidas = restaurante.getBebidas();
			System.out.println("BEBIDAS"+ "\n");
			
				for (int i = 0; i < bebidas.size() ; i++)
				{

					String n = bebidas.get(i).getNombre();
					
					System.out.println(String.valueOf(i+1));
					System.out.println(String.valueOf(n));
					System.out.println("\n");
				}
			int elegido = Integer.parseInt(input("\n" + "Seleccione el número del producto a añadir"));
			
			if (elegido>bebidas.size()) 
			{System.out.println("Seleccion Invalida"+ "\n");}
			
			else {
			elProducto = bebidas.get(elegido-1);}			
		}
		
		else {{System.out.println( "\n" + "Seleccione una opción permitida"+ "\n");}
		
		}
		if (!elProducto.equals(null))
		{		
		List<Ingrediente> Ingredientes = restaurante.getIngredientes();
		Boolean cont = true;			
		Boolean cambio = false;
		ProductoAjustado elProductoAj = new ProductoAjustado(elProducto);
		
		while (cont)
		{
			System.out.println( "\n" + "Desea agregar o eliminar algún ingrediente al producto agregado?"+ "\n");
			System.out.println("\n" + "1. SI" + "\n" + "2. NO"+ "\n" );
			
			String op = input("1/2");
			
			if (op.equals("1")) 
			{
			cambio = true;
			System.out.println( "\n" + "INGREDIENTES"+ "\n");
			
			for (int i = 0; i < Ingredientes.size() ; i++)
			{
	
				String n = Ingredientes.get(i).getNombre();
				int t = Ingredientes.get(i).getCostoAdicional();
				
				System.out.println(String.valueOf(i+1));
				System.out.println(String.valueOf(n));
				System.out.println(String.valueOf(t));
				System.out.println("\n");
			}
			int e = Integer.parseInt(input("\n" + "Seleccione el número del ingrediente a añadir o a eliminar"));
			
			if (e>Ingredientes.size()) 
			{System.out.println("Seleccion Invalida"+ "\n");}
			
			else {
			Ingrediente ing  = Ingredientes.get(e-1);
			System.out.println("\n" + "Desea agregar o eliminar el ingrediente seleccionado"+ "\n");
			System.out.println("\n" + "1. AGREGAR" + "\n" + "2. ELIMINAR"+ "\n" );
			String o  = input("1/2");
			
			if (o.equals("1")) {elProductoAj.agregarIngrediente(ing);
								System.out.println("\n" + "Se ha añadido el ingrediente"+ "\n");}
			else if (o.equals("2")) {elProductoAj.eliminarIngrediente(ing);
								System.out.println("\n" + "Se ha eliminado el ingrediente"+ "\n");}
			
				}
			}
			if (op.equals("2")) 
			{cont = false;}
			}
		if (cambio) {p.agregarProducto(elProductoAj);}
		else {
		p.agregarProducto(elProducto);}
		
		System.out.println("\n" + "Se ha agregado el producto a su pedido"+ "\n" );
		}}}

	public void ejecutarCerrarPedidoGuardarFactura() {
		
		
		if (restaurante.getPedidoEnCurso()==null) 
			{System.out.println("No hay ningun pedido iniciado");}
		
		else 
			{	
			Pedido p = restaurante.getPedidoEnCurso();
			List<Pedido> ps = restaurante.getPedidos();
			ps.add(p);
			restaurante.cerrarGuardarPedido();
			System.out.println("\n"+"Se ha guardado su factura: "+ "\n" + "el id de su factura es: " + String.valueOf((restaurante.getPedidoEnCurso()).getIdPedido()));
			
			}
		}
		
	public void ejecutarConsultarPedido() throws IOException {
		
		String pdido = input("Por favor ingrese el id del pedido a consultar");
				
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("./facturas/"+ pdido +".txt"));
			
		} catch (FileNotFoundException e) {
			System.out.println("No hay pedido con tal id, ingrese un id valido.");
			e.printStackTrace();
		}
		
		String st;

        while ((st = br.readLine()) != null)
 
            {System.out.println(st);}
        
        br.close();
		}
	
	private String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) throws IOException
	{
		Aplicacion app = new Aplicacion();
		app.ejecutarAplicacion();
	}
}