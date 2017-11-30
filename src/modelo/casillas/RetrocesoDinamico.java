package modelo.casillas;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import modelo.Jugador;
import modelo.interfaces.Visitable;


public class RetrocesoDinamico implements Visitable{

	private String nombre = "Retroceso Dinámico";
	private int casillasAMover;
	
	public int getCantidadDePasos(Jugador unJugador, int numeroDelDado) {
		casillasAMover = 0;
		if (numeroDelDado < 7) {
			casillasAMover = numeroDelDado - unJugador.getCantidadDePropiedades();
		}
		else if (numeroDelDado < 11) {
			casillasAMover =  unJugador.getDinero().getValor() % numeroDelDado;
		}
		else casillasAMover =  numeroDelDado - 2;
		return -casillasAMover;
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
				+"Si sacó 2,3,4,5 o 6 =>  retrocede el número sacado menos la sumatoria de propiedades del jugador. "
				+ "Tanto los terrenos como las casas como los hoteles suman como propiedad.\n"
				+"\n"
				+"Si sacó 7,8,9 o 10 => retrocede #cantidad de efectivo del jugador % numero sacado.\n"
				+"\n"
				+"Si sacó 11 o 12 => retrocede el número sacado menos 2 unidades");
 
		info.setFont(Font.font("Consolas", FontWeight.NORMAL, 14));
		info.setWrapText(true);
				
		panelInfo.getChildren().addAll(nombre,info);
		return panelInfo;
	}

}
