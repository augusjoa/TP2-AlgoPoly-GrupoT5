package modelo;


import org.junit.Assert;
import org.junit.Test;

public class AlgoPolyTest {
	@Test
	public void testAlCrearAlgoPolyEsteTieneJugadores() {
		AlgoPoly unAlgoPoly = new AlgoPoly();
		
		Assert.assertNotEquals(0, unAlgoPoly.cantidadDeJugadoresActivos());
	}
	
	@Test
	public void testCuandoTodosPasaronTurnoLeTocaAlPrimerJugador() {
		AlgoPoly unAlgoPoly = new AlgoPoly();
		int cantidadDeJugadores = unAlgoPoly.cantidadDeJugadoresActivos();
		
		Jugador primerJugador;
		
		Jugador siguienteAlUltimo;
		
		primerJugador = unAlgoPoly.siguienteJugador();
		for(int i=1; i < cantidadDeJugadores; i++) {
			unAlgoPoly.siguienteJugador();
		}
		siguienteAlUltimo = unAlgoPoly.siguienteJugador();
		
		Assert.assertEquals(primerJugador, siguienteAlUltimo);
	}
}
