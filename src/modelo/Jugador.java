package modelo;

import java.util.Collection;
import java.util.HashSet;

import modelo.casillas.Barrio;
import modelo.casillas.BarrioDoble;
import modelo.casillas.Carcel;
import modelo.casillas.Compania;
import modelo.estadoJugador.Encarcelado;
import modelo.estadoJugador.EstadoJugador;
import modelo.estadoJugador.Libre;
import modelo.interfaces.Adquirible;
import modelo.interfaces.Visitable;



public class Jugador {
	
	
	private Dinero dinero = new Dinero(100000);
	//private boolean detenido = false;	
	private Collection <Barrio> barriosAdquiridos = new HashSet<Barrio>();
	private Collection <Compania> companiasAdquiridas = new HashSet<Compania>();
	private DobleDado dado = new DobleDado();
	private Visitable casillaActual;
	protected Tablero tablero = Tablero.TableroUnico();
	private EstadoJugador estado = new Libre();

	
	public Dinero getDinero() {
		return dinero;
	}

	
	public void agregarDinero(Dinero unDinero) {
		dinero.agregarDinero(unDinero);
	}
	
	public void sustraerDinero(Dinero unDinero) {
		dinero.sustraerDinero(unDinero);
	}


	public int getCantidadDePropiedades() {
		int total = this.barriosAdquiridos.size();
		for (Barrio unBarrio : barriosAdquiridos) {
			total += unBarrio.getCantidadDeEdificios();
		}
		return total + this.companiasAdquiridas.size(); 
	}

	public void comprar(Barrio unBarrio) {
		unBarrio.comprar(this);
		barriosAdquiridos.add(unBarrio);		
	}
	
	public void comprar(Compania unaCompania) {	
		unaCompania.comprar(this);
		companiasAdquiridas.add(unaCompania);		
	}

	public void vender(Barrio unBarrio) {
		unBarrio.vender(this);
		barriosAdquiridos.remove(unBarrio);
	}
	
	public void vender(Compania unaCompania) {
		unaCompania.vender(this);
		companiasAdquiridas.remove(unaCompania);
	}
	
	public boolean esDuenio(Barrio unBarrio) {
		return barriosAdquiridos.contains(unBarrio);
	}
	
	public boolean esDuenio(Compania unaCompania) {
		return companiasAdquiridas.contains(unaCompania);
	}

	public int tirarDados() {
		return dado.tirarDados();
	}
	public int getNumeroDelDado() {
		return dado.getDobleDado();
	}

/*	public void jugadorDetenido() {
		detenido = true;
	}
	
	/public void jugadorLiberado() {
		detenido = false;
	}
*/
	public boolean puedeMoverse() {
		return this.estado.puedeMoverse();
	}

	public void moverse(int cantidadDeCasillas) {
		estado.moverse(this, cantidadDeCasillas, casillaActual);
		casillaActual.esVisitadoPorJugador(this);
	}
	
	public void setCasillaActual(Visitable unVisitable){
		casillaActual = unVisitable;
		
	}
	
	public Visitable getCasillaActual(){
	 	return casillaActual;
	}
	
	public void agregarCasa(Barrio unBarrio) {
		unBarrio.agregarCasa(this);
	}
	
	public void agregarHotel(BarrioDoble unBarrio) {
		unBarrio.agregarHotel(this);
	}
	
	public boolean perdio(){
		return (dinero.getValor() < 0 && getCantidadDePropiedades()==0);
	}


	public void irPreso() {
		casillaActual = tablero.getCarcel();
		casillaActual.esVisitadoPorJugador(this);
	}


	public void cambiarEstado(EstadoJugador estado) {
		this.estado = estado;		
	}


	public void encarcelar() {
		this.cambiarEstado(new Encarcelado());
	}
	
	public void pagarFianza(Carcel unaCarcel) {
		this.estado.pagarFianza(this, unaCarcel);
	}

	public void liberar() {
		this.cambiarEstado(new Libre());
	}
	
	public boolean tiradaInvalida() {
		return dado.dadosSonIguales();
	}
	
	public int getTurnosRestantes() {
		return this.estado.getTurnosRestantes();
	}

	public void iniciarTurno() {
		this.estado.restarTurnos(this);
	}
}