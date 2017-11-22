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

	public Dinero vender(Dinero unPrecio) {
		valor = (int) (unPrecio.getValor() * 0.85);		//perdida del 15% al vender algo, ver de mejorar. no se si va en Dinero en si.
		return this;
	}
	
}
