package modelo.casillas;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
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
		nombre.setFont(Font.font("Consolas", FontWeight.BOLD, 14));
		nombre.setWrapText(true);
		
		Label info = new Label("Al jugador que caiga aquí se le resta un "+Integer.toString(porcentajeDelImpuesto)+" % de su dinero.");
		info.setFont(Font.font("Consolas", FontWeight.NORMAL, 14));
		info.setWrapText(true);
				
		panelInfo.getChildren().addAll(nombre,info);
		return panelInfo;
	}

}
