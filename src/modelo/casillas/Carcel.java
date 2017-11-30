package modelo.casillas;


import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
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
	
	public int getValorDeLaFianza(){
		return valorDeLaFianza.getValor();
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
		nombre.setFont(Font.font("Consolas", FontWeight.BOLD, 14));
		nombre.setWrapText(true);
		
		Label info = new Label("El jugador que caiga aquí quedará encarcelado durante tres turnos."
				+ " El jugador podrá salir de la carcel en el turno dos o tres si paga una fianza de: "
				+ Integer.toString(valorDeLaFianza.getValor())+ " o quedará libre"
						+ " pudiendo moverse al pasar los tres turnos.");
		info.setFont(Font.font("Consolas", FontWeight.NORMAL, 14));
		info.setWrapText(true);
				
		panelInfo.getChildren().addAll(nombre,info);
		return panelInfo;
	}
}
