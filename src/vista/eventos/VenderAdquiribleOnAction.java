package vista.eventos;

import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import modelo.AlgoPoly;
import modelo.interfaces.Adquirible;
import modelo.interfaces.Visitable;
import vista.Juego;

public class VenderAdquiribleOnAction implements EventHandler<ActionEvent> {

	Juego juego;
	Button botonVenta;
	AlgoPoly partida;
	
	public VenderAdquiribleOnAction(Juego juego,Button botonVenta){
		this.juego=juego;
		this.partida=juego.partida();
		this.botonVenta=botonVenta;
	}
	
	@Override
	public void handle(ActionEvent arg0) {
		Visitable casillaActual=partida.getJugadorActual().getCasillaActual();
		Alert alertaCompra = new Alert(AlertType.CONFIRMATION);
		alertaCompra.setTitle(casillaActual.getNombre());
		alertaCompra.setHeaderText("");
		alertaCompra.setContentText("¿Esta seguro que desea vender toda la propiedad?");
		Stage stagePagar = (Stage) alertaCompra.getDialogPane().getScene().getWindow();
		stagePagar.getIcons().add(new Image(getClass().getResourceAsStream("../img/icon.png")));
		Optional<ButtonType> result = alertaCompra.showAndWait();
		if (result.get() == ButtonType.OK){
			((Adquirible)casillaActual).vender(partida.getJugadorActual());
			System.out.println("vendio");
			botonVenta.setDisable(true);
			juego.updateVistaSuperior();
		}
	}

}
