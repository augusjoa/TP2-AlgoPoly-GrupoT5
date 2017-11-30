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
		unStage.hide();
		unMenuItem.setText("Pantalla Completa");
		unMenuItem.setOnAction(new CambiarAPantallacompletaOnAction(unStage, unMenuItem));
		unStage.setFullScreen(false);
		//unStage.getScene().getRoot().setManaged(true);
		//unStage.getScene().getRoot().requestLayout();
		//unStage.requestFocus();
		unStage.show();
	}

}
