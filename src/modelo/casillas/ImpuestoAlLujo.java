package modelo.casillas;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import modelo.Dinero;
import modelo.Jugador;
import modelo.interfaces.Visitable;

public class ImpuestoAlLujo implements Visitable {

	private int porcentajeDelImpuesto= 10;
	private String nombre="Impuesto al Lujo";
	private Dinero dineroDelJugador;
	
	public void aplicarImpuesto(Jugador jugador){
		this.dineroDelJugador= jugador.getDinero();
		dineroDelJugador.aplicarImpuesto(porcentajeDelImpuesto);
	}
	
	public int getPorcentajeDelImpuesto(){
		return porcentajeDelImpuesto;
	}
	
	@Override
	public String getNombre(){
		return nombre;
	}
	
	@Override
	public void esVisitadoPorJugador(Jugador unJugador) {
		aplicarImpuesto(unJugador);
	}
	@Override
	public VBox loadPanelInfo(VBox panelInfo) {
		
		Label nombre = new Label("Nombre: " + this.nombre);
		
		
		panelInfo.getChildren().add(nombre);
		return panelInfo;
	}

}
