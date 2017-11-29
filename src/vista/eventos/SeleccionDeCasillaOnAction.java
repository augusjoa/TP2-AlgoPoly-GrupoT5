package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.interfaces.Visitable;

public class SeleccionDeCasillaOnAction implements EventHandler<ActionEvent> {

	private Visitable unaCasilla;
	public SeleccionDeCasillaOnAction(Visitable casillero) {
		unaCasilla = casillero;
	}

	@Override
	public void handle(ActionEvent event) {
		

	}

}
