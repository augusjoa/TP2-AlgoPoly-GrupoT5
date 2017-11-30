package modelo.interfaces;

import javafx.scene.layout.VBox;
import modelo.Jugador;


public interface Visitable {
	public abstract void esVisitadoPorJugador(Jugador unJugador);
	public abstract String getNombre();
	public abstract VBox loadPanelInfo(VBox elPanel);
}
