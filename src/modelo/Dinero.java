package modelo;

import modelo.excepciones.DineroInsuficiente;

public class Dinero {
	
	private int valor;
		
	public Dinero(int valor) {
		this.valor = valor;
	}
	
	public Dinero(Dinero unDinero) {
		this.valor = unDinero.valor;
	}
	
	public int getValor() { //Solo para las pruebas se debe utilizar
		return valor;
	}

	public void agregarDinero(Dinero unDinero) {
		valor += unDinero.valor;
	}

	public void sustraerDinero(Dinero unDinero) throws DineroInsuficiente {
		if(valor < unDinero.valor) throw new DineroInsuficiente();
		valor -= unDinero.valor;
	}

	public void aplicarImpuesto(int porcentajeDelImpuesto){
		int valorActual= valor;
		int valorConImpuesto= (valor*porcentajeDelImpuesto)/100;
		valor= valorActual-valorConImpuesto;
	}
	@Override
	public boolean equals(Object unDinero) {
		if(unDinero == null || unDinero.getClass() != this.getClass()) return false;
		return valor ==  ((Dinero) unDinero).getValor();	
	}
	
}
