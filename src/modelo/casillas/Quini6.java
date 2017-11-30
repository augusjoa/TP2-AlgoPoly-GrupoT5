package modelo.casillas;

import java.util.Hashtable;

import com.sun.javafx.scene.control.skin.LabelSkin;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import modelo.Dinero;
import modelo.Jugador;
import modelo.interfaces.Visitable;

public class Quini6 implements Visitable {
	private Hashtable<Jugador, Integer> jugadores = new Hashtable<Jugador, Integer>();
	private Dinero primerPremio = new Dinero(50000);
	private Dinero segundoPremio = new Dinero(30000);
	private String nombre = "Quini 6";
	private Jugador jugador;
	
	private void obtenerPremio(Jugador unJugador){
		this.jugador= unJugador;
		if(!this.jugadores.containsKey(jugador)){
			jugador.agregarDinero(primerPremio);
			jugadores.put(jugador, 1);
		}
		else if(jugadores.get(jugador)==1){
			jugador.agregarDinero(segundoPremio);
			jugadores.replace(jugador, 2);
		}
		else if(jugadores.get(jugador)==2){
			jugadores.replace(jugador, 3);
		}
	}
	
	public int getValorPremio(){
		if(jugadores.get(jugador)==1){
			return primerPremio.getValor();
		}
		else if(jugadores.get(jugador)==2){
			return segundoPremio.getValor();
		}
		else return 0;
	}
	
	@Override
	public String getNombre(){
		return nombre;
	}

	@Override
	public void esVisitadoPorJugador(Jugador unJugador) {
		obtenerPremio(unJugador);
	}
	
	@Override
	public VBox loadPanelInfo(VBox panelInfo) {
		
		Label nombre = new Label("Nombre: " + this.nombre);
		nombre.setFont(Font.font("Consolas", FontWeight.BOLD, 14));
				
		Label descripcion = new Label("Descripción:  ");
		descripcion.setFont(Font.font("Consolas", FontWeight.BOLD, 14));
		
		Label premio1 = new Label("\tPrimer Premio: " + primerPremio.getValor());
		premio1.setFont(Font.font("Consolas", FontWeight.BOLD, 14));
		
		Label premio2 = new Label("\tPrimer Premio: " + segundoPremio.getValor() + "un texto super largo para probar si lo de cambio e lineas anda, no se ni que estoy escribiendo aca");
		premio2.setFont(Font.font("Consolas", FontWeight.BOLD, 14));
		premio2.wrapTextProperty().set(true);
		
		panelInfo.getChildren().addAll(nombre, descripcion, premio1, premio2);
		return panelInfo;
	}
}
