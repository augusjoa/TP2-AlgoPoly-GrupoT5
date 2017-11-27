package modelo;

import org.junit.Assert;
import org.junit.Test;

import modelo.casillas.*;
import modelo.interfaces.Visitable;

public class TableroTest {
	@Test
	public void testAlCrearTableroTiene20Casillas() {
		Tablero tablero = Tablero.TableroUnico();
		
		Assert.assertEquals(20, tablero.cantidadDeCasillas());
	}

	@Test
	public void testAlAvanzarUnaPosicionEstoyEnQuini6(){
		Tablero tablero = Tablero.TableroUnico();
		Visitable salida = tablero.getCasillero(0);
		Visitable quini6 = tablero.avanzarCasillas(salida, 1);
		
		Assert.assertEquals(1, tablero.getPosDeCasilla(quini6)) ;
		
	}
	
	@Test
	public void testAlAvanzarUnaPosicionFueraDeRangoEsteAvanzaCorrectamente(){
		Tablero tablero = Tablero.TableroUnico();
		Visitable salida = tablero.getCasillero(0);
		Visitable quini6 = tablero.avanzarCasillas(salida, 21);
		
		Assert.assertEquals(1, tablero.getPosDeCasilla(quini6)) ;
	}
	
	@Test
	public void elTableroSabeDondeEstaLaCarcel(){
		Tablero tablero = Tablero.TableroUnico();
		Visitable carcel = tablero.getCarcel();
		
		Visitable carcelEsperada = tablero.getCasillero(5);
		
		Assert.assertEquals(carcelEsperada, carcel);
	}
}
