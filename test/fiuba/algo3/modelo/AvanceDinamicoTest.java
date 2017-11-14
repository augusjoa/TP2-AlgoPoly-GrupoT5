package fiuba.algo3.modelo;

import org.junit.Assert;
import org.junit.Test;

public class AvanceDinamicoTest {
	
	@Test
	public void testCaerEnLaCasillaCon6oMenos(){
		Jugador unJugador = new Jugador(100000);		
		AvanceDinamico unAvanceDinamico = new AvanceDinamico();
		int posicionInicial = unJugador.posicion;
		
		unAvanceDinamico.avanzar(unJugador, 5);	//El 5 puede ser reemplazado por un objeto tipo dado que devuelva el numero sacado.
		
		Assert.assertEquals(posicionInicial + 3, unJugador.posicion);
	}
}