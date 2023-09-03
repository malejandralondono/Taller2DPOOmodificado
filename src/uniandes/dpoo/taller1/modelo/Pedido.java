package uniandes.dpoo.taller1.modelo;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Pedido {
	
	//Atributos
	
	private String nombreCliente;
	
	private String direccionCliente;
	
	private static int numeroPedidos = 0;
	
	private int idPedido;
	
	private ArrayList<Producto> itemsPedido;
	
	//Constructor
	
	public Pedido(String elNombreCliente, String laDireccionCliente) {
		
		nombreCliente = elNombreCliente;
		direccionCliente = laDireccionCliente;
		numeroPedidos ++;
		idPedido = numeroPedidos ;
		itemsPedido= new ArrayList<Producto>();
		
	}

	//Metodos
	
	public int getIdPedido() {
		
		return idPedido;
	}
	
	public void agregarProducto(Producto nuevoItem) {
		
		itemsPedido.add(nuevoItem);
	}
	
	public void guardarFactura() {
		
		String f = generarTextoFactura();
		Path path = Paths.get("./facturas/"+ String.valueOf(idPedido) +".txt");
		
		try {Files.writeString(path, f, StandardCharsets.UTF_8);}
		
		catch (IOException ex) {System.out.print("Invalid Path");}
	}
	
	private int getPrecioNetoPedido(){
		
		int precioNeto = 0;
		
		for (int i = 0; i < itemsPedido.size() ; i++)
		{
			int p = itemsPedido.get(i).getPrecio();
			
			precioNeto += p;}
		
		return precioNeto;}
	
	private int getPrecioTotalPedido() {
		
		int precioTotal = 0;
		int precioIVA = getPrecioIVAPedido();
		int precioNeto = getPrecioNetoPedido();
		
		precioTotal = precioIVA + precioNeto;
		
		return precioTotal;}
	
	private int getPrecioIVAPedido(){
		
		int precioIVA = 0;
		int precioNeto = getPrecioNetoPedido();
		
		precioIVA = (19*precioNeto)/100;
		
		return precioIVA;}
	
	private String generarTextoFactura(){
		
		String textoFactura = "\n"+ "id de su pedido: " + String.valueOf(idPedido) + "\n";
		textoFactura += "\n" + "Cliente: " + nombreCliente + "\n";
		textoFactura += "Dirección: " + direccionCliente + "\n";

		textoFactura += "\n" + "Productos: " + "\n";
		for (int i = 0; i < itemsPedido.size() ; i++)
		{
			Producto it = itemsPedido.get(i);
			textoFactura += "\n" + (i+1)+ "\n";
			textoFactura += it.generarTextoFactura();
		}
		
		int precioIVA = getPrecioIVAPedido();
		textoFactura += "\n" + "IVA: " +precioIVA + "\n";
		int precioNeto = getPrecioNetoPedido();
		textoFactura += "Precio neto: " +precioNeto + "\n";
		int precioTotal = getPrecioTotalPedido();
		textoFactura += "Precio total: " +precioTotal + "\n";
		
		return textoFactura;}
	
}
