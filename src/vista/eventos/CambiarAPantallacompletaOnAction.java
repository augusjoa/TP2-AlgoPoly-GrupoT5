package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class CambiarAPantallacompletaOnAction implements EventHandler<ActionEvent> {

	Stage stage;
	MenuItem opcionPantallaCompleta;
	
	public CambiarAPantallacompletaOnAction(Stage stage, MenuItem menuitem) {
		this.stage = stage;
		opcionPantallaCompleta = menuitem;
	}

	@Override
	public void handle(ActionEvent event) {
		stage.hide();
		opcionPantallaCompleta.setText("Salir de Pantalla Completa");
		opcionPantallaCompleta.setOnAction(new SalirDePantallaCompletaOnAction(stage, opcionPantallaCompleta));
		stage.setFullScreen(true);
		stage.show();
	}

}
