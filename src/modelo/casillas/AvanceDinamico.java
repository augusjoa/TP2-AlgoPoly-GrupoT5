package modelo.casillas;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import modelo.Jugador;
import modelo.interfaces.Visitable;



public class AvanceDinamico implements Visitable{

	private String nombre = "Avance";
	private int casillasAMover;
	
	public int getCantidadDePasos(Jugador unJugador, int tiradaDeDados) {
		casillasAMover = 0;
		if (tiradaDeDados < 7) {
			casillasAMover = (tiradaDeDados - 2);
		}
		else if(tiradaDeDados < 11) {
			casillasAMover = ( unJugador.getDinero().getValor() % tiradaDeDados);
		}		
		else casillasAMover = (tiradaDeDados - unJugador.getCantidadDePropiedades());
		return casillasAMover;
	}
	
	public int getCantidadDePasos(){
		return casillasAMover;
	}
	
	@Override
	public String getNombre(){
		return nombre;
	}
	
	@Override
	public void esVisitadoPorJugador(Jugador unJugador) {
		int cantidadDePasos = getCantidadDePasos(unJugador, unJugador.getNumeroDelDado());
		if(cantidadDePasos != 0) unJugador.moverse(cantidadDePasos);
	}

	@Override
	public VBox loadPanelInfo(VBox panelInfo) {
		
		Label nombre = new Label("Nombre: " + this.nombre);
		
		
		panelInfo.getChildren().add(nombre);
		return panelInfo;
	}
}
