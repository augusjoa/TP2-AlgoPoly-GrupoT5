package modelo.casillas;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import modelo.Jugador;
import modelo.interfaces.Visitable;



public class AvanceDinamico implements Visitable{

	private String nombre = "Avance Dinámico";
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
		nombre.setFont(Font.font("Consolas", FontWeight.BOLD, 14));
		nombre.setWrapText(true);
		
		Label info = new Label("El jugador que caiga aqui se moverá siguiendo la siguiente lógica: \n"
				+"\n"
				+"Si sacó 2,3,4,5 o 6 => entonces avanza el número sacado - 2 casilleros.\n"
				+"\n"
				+"Si sacó 7,8,9 o 10 => entonces avanza Dinero del jugador % numero sacado.\n"
				+"\n"
				+"Si sacó 11 o 12 => avanza el numero sacado menos la sumatoria de propiedades del jugador.\n"
				+"Tanto los terrenos como las casas como los hoteles suman como propiedad.");
 
		info.setFont(Font.font("Consolas", FontWeight.NORMAL, 14));
		info.setWrapText(true);
				
		panelInfo.getChildren().addAll(nombre,info);
		return panelInfo;
	}
}
