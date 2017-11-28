package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class SalirDePantallaCompletaOnAction implements EventHandler<ActionEvent> {

	private Stage unStage;
	private MenuItem unMenuItem;
	
	public SalirDePantallaCompletaOnAction(Stage stage, MenuItem menuItem) {
		unStage = stage;
		unMenuItem = menuItem;
	}

	@Override
	public void handle(ActionEvent event) {
		unStage.setFullScreen(false);
		unMenuItem.setText("Pantalla Completa");
		unMenuItem.setOnAction(new CambiarAPantallacompletaOnAction(unStage, unMenuItem));
	}

}
