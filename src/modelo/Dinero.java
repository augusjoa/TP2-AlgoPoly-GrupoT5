package modelo;

public class Dinero {
	
	private int valor;

	public Dinero(int valor) {
		this.valor = valor;
	}
	
	public int getValor() {
		return this.valor;
	}

	public Dinero agregarDinero(Dinero unDinero) {
		valor += unDinero.getValor();
		return this;
	}

	public boolean sustraerDinero(Dinero unDinero) {
		if(valor < unDinero.getValor()) {
			return false;
		}
		valor -= unDinero.getValor();
		return true;
	}

	public boolean comprar(Dinero unPrecio) {
		if(this.valor > unPrecio.getValor()) {
			this.valor -= unPrecio.getValor();
			return true;
		}
		return false;
	}
	
}
