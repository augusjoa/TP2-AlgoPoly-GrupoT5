package modelo.casillas;

public class BarrioFactory {
	public Barrio crearTucuman() {
		Barrio tucuman = new BarrioSimple(25000, 7000, 2500, 4500, "Tucuman" );
		return tucuman;
	}

	public Barrio crearSantaFe() {
		Barrio santafe = new BarrioSimple(15000, 4000, 1500, 3500,"Santa Fe");
		return santafe;
	}
	
	public Barrio crearNeuquen() {
		Barrio neuquen = new BarrioSimple(17000, 4800, 1800, 3800, "Neuquen");
		return neuquen;
	}
	
	public BarrioDoble crearBuenosAiresSur() {
		BarrioDoble bsasSur = new BarrioDoble(20000, 5000, 8000, 2000, 3000, 3500, 5000, "BsAs Sur");
		return bsasSur;
	}
	
	public BarrioDoble crearBuenosAiresNorte() {
		BarrioDoble bsasNorte = new BarrioDoble(25000, 5500, 9000, 2500, 3500, 4000, 6000, "BsAs Norte");
		return bsasNorte;
	}
	
	public BarrioDoble crearCordobaSur() {
		BarrioDoble cordobaSur = new BarrioDoble(18000, 2000, 3000, 1000, 1500, 2500, 3000, "Cordoba Sur");
		return cordobaSur;
	}
	
	public BarrioDoble crearCordobaNorte() {
		BarrioDoble cordobaNorte = new BarrioDoble(20000, 2200, 3500, 1300, 1800, 2900, 3500, "Cordoba Norte");
		return cordobaNorte;
	}
	
	public BarrioDoble crearSaltaSur() {
		BarrioDoble saltaSur = new BarrioDoble(23000, 4500, 7500, 2000, 3250, 3850, 5500, "Salta Sur");
		return saltaSur;
	}
	
	public BarrioDoble crearSaltaNorte() {
		BarrioDoble saltaNorte = new BarrioDoble(23000, 4500, 7500, 2000, 3250, 3850, 5500, "Salta Norte");
		return saltaNorte;
	}

}
