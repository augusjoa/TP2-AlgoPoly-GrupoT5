package modelo.casillas;


import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import modelo.Dinero;
import modelo.Jugador;
import modelo.interfaces.Visitable;

public class Carcel implements Visitable{
	private Dinero valorDeLaFianza = new Dinero(45000);
	private String nombre = "Carcel";
	

	public void cobrarFianza(Jugador jugador){
			jugador.getDinero().sustraerDinero(valorDeLaFianza);
			jugador.liberar();

	}
	
	@Override
	public String getNombre(){
		return nombre;
	}
	
	@Override
	public void esVisitadoPorJugador(Jugador jugador) {
		jugador.encarcelar();
	}
	
	@Override
	public VBox loadPanelInfo(VBox panelInfo) {
		
		Label nombre = new Label("Nombre: " + this.nombre);
		
		
		panelInfo.getChildren().add(nombre);
		return panelInfo;
	}
}
