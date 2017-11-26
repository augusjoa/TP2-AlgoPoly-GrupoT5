package modelo;

import modelo.excepciones.DineroInsuficiente;
import modelo.interfaces.Adquirible;

public class Dinero {
	private static final int porcentajeRetencionDeVenta = 15;
	private int valor;
		
	public Dinero(int valor) {
		this.valor = valor;
	}
	
	public Dinero(Dinero unDinero) {
		this.valor = unDinero.valor;
	}
	
	public int _getValor() { //Solo para las pruebas se debe utilizar
		return valor;
	}

	public void agregarDinero(Dinero unDinero) {
		valor += unDinero.valor;
	}

	public void sustraerDinero(Dinero unDinero) throws DineroInsuficiente {
		if(valor < unDinero.valor) throw new DineroInsuficiente();
		valor -= unDinero.valor;
	}

	//public boolean comprar(Adquirible unAdquirible) {
		//return sustraerDinero(unAdquirible.getPrecio());
	//}

	//public Dinero vender(Adquirible unAdquirible) {
		//valor += (int) ((unAdquirible.getPrecio().valor * ( 100 - porcentajeRetencionDeVenta )) / 100 );
		//return this;
	//}
	
	public void aplicarImpuesto(int porcentajeDelImpuesto){
		int valorActual= valor;
		int valorConImpuesto= (valor*porcentajeDelImpuesto)/100;
		valor= valorActual-valorConImpuesto;
	}
	
}
