package vista.eventos;

import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import vista.Juego;

public class ConfirmarNuevoJuegoOnAction implements EventHandler<ActionEvent> {

	private Stage unStage;
	public ConfirmarNuevoJuegoOnAction(Stage stage) {
		unStage = stage;
	}

	@Override
    public void handle(ActionEvent actionEvent){
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("Juego Nuevo");
    	alert.setHeaderText("");
    	alert.setContentText("¿Esta seguro que desea iniciar Nueva Partida?");
    	Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
    	stage.getIcons().add(new Image(getClass().getResourceAsStream("../img/icon.png")));
    	
    	Optional<ButtonType> result = alert.showAndWait();
    	if (result.get() == ButtonType.OK){
    		unStage.setScene(new Scene(new Juego(unStage),1280,720));
       	}
    }

}
