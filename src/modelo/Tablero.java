package modelo;


import java.util.ArrayList;
import modelo.casillas.Carcel;
import modelo.casillas.Quini6;
import modelo.casillas.*;
import modelo.interfaces.Visitable;


public class Tablero {
	
	private ArrayList <Visitable> casilleros = new ArrayList<Visitable>();
	private static Tablero tableroUnico = null;
	public static Tablero TableroUnico() {
		if(tableroUnico == null) tableroUnico = new Tablero();
		return tableroUnico;
	}
	
	private Tablero() {
			
		BarrioFactory bFactory = new BarrioFactory();
		
		casilleros.add(new Salida());
		casilleros.add(new Quini6());
		BarrioDoble bsasSur = bFactory.crearBuenosAiresSur();
		BarrioDoble bsasNorte = bFactory.crearBuenosAiresNorte();
		bsasSur.setOtraZona(bsasNorte);
		bsasNorte.setOtraZona(bsasSur);
		Compania edesur = new Edesur();
		Compania aysa = new Aysa();
		edesur.setOtraCompania(aysa);
		aysa.setOtraCompania(edesur);
		
		casilleros.add(bsasSur);
		casilleros.add(edesur);
		casilleros.add(bsasNorte);
		Carcel carcel = new Carcel();
		casilleros.add(carcel);
		
		
		BarrioDoble cordobaSur = bFactory.crearCordobaSur();
		BarrioDoble cordobaNorte = bFactory.crearCordobaNorte();
		cordobaNorte.setOtraZona(cordobaSur);
		cordobaSur.setOtraZona(cordobaNorte);
		Compania subte = new Subte();
		Compania tren = new Tren();
		subte.setOtraCompania(tren);
		tren.setOtraCompania(subte);
		
		casilleros.add(cordobaSur);
		casilleros.add(new AvanceDinamico());
		casilleros.add(subte);
		casilleros.add(cordobaNorte);
		casilleros.add(new ImpuestoAlLujo());
		
		casilleros.add(bFactory.crearSantaFe());
		casilleros.add(aysa);
		BarrioDoble saltaNorte = bFactory.crearSaltaNorte();
		BarrioDoble saltaSur = bFactory.crearSaltaSur();
		saltaNorte.setOtraZona(saltaSur);
		saltaSur.setOtraZona(saltaNorte);
		casilleros.add(saltaNorte);
		casilleros.add(saltaSur);
		casilleros.add(new Policia());
		
		casilleros.add(tren);
		casilleros.add(bFactory.crearNeuquen());
		casilleros.add(new RetrocesoDinamico());
		casilleros.add(bFactory.crearTucuman());
	}
	
	
	public int cantidadDeCasillas() {
		return casilleros.size();
	}

	//public Visitable siguienteCasilla(Visitable v, int cant)
	//public void siguienteCasilla() {
		//if(iterador == null || !iterador.hasNext() ) iterador = casilleros.listIterator();
		//iterador.next();

	public Visitable avanzarCasillas(Visitable casillaDelJugador, int numDelDado){
		int posActual = casilleros.indexOf(casillaDelJugador);
		posActual = (posActual+numDelDado)%cantidadDeCasillas();
		return casilleros.get(posActual);	
	}
	
	public int getPosDeCasilla(Visitable casilla){
		return casilleros.indexOf(casilla);
	}
	
	public Visitable getCasillero(int pos){
		return casilleros.get(pos);
	}

	public Visitable irACarcel() {
		return casilleros.get(5);	//Ver como hacer para saber donde está la carcel. esto es HC 
	}

	
}
