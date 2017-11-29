package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CambiarEscena implements EventHandler<ActionEvent>{

	private Stage stage;
	private Scene escena;
	
	public CambiarEscena(Stage stage, Scene escena) {
		this.stage=stage;
		this.escena=escena;
	}

	@Override
	public void handle(ActionEvent event) {
		stage.hide();
		stage.centerOnScreen();
		stage.setScene(escena);
		stage.show();
	}
}