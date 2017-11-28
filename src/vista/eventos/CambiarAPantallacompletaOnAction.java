package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class CambiarAPantallacompletaOnAction implements EventHandler<ActionEvent> {

	Stage unStage;
	MenuItem unMenuItem;
	
	public CambiarAPantallacompletaOnAction(Stage stage, MenuItem menuitem) {
		unStage = stage;
		unMenuItem = menuitem;
	}

	@Override
	public void handle(ActionEvent event) {
		unStage.setFullScreen(true);
		unMenuItem.setText("Salir de Pantalla Completa");
		unMenuItem.setOnAction(new SalirDePantallaCompletaOnAction(unStage, unMenuItem));
		
	}

}
