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
import modelo.excepciones.DineroInsuficiente;
import modelo.excepciones.TieneDuenio;
import modelo.interfaces.Adquirible;
import modelo.interfaces.Visitable;
import vista.Juego;

public class ComprarAdquiribleOnAction implements EventHandler<ActionEvent>{

	AlgoPoly partida;
	Button botonCompra;
	Juego juego;

	public ComprarAdquiribleOnAction(Juego juego,Button botonCompra){
		this.juego=juego;
		this.partida=juego.partida();
		this.botonCompra=botonCompra;
	}

	@Override
	public void handle(ActionEvent event) {
		Visitable casillaActual=partida.getJugadorActual().getCasillaActual();
		Alert alertaCompra = new Alert(AlertType.CONFIRMATION);
		alertaCompra.setTitle(casillaActual.getNombre());
		alertaCompra.setHeaderText("");
		alertaCompra.setContentText("El terreno cuesta: "+((Adquirible)casillaActual).getPrecio().getValor()+"\n¿Quiere comprarlo?");
		Stage stagePagar = (Stage) alertaCompra.getDialogPane().getScene().getWindow();
		stagePagar.getIcons().add(new Image(getClass().getResourceAsStream("../img/icon.png")));
		Optional<ButtonType> result = alertaCompra.showAndWait();
		if (result.get() == ButtonType.OK){
			try{
				((Adquirible)casillaActual).comprar(partida.getJugadorActual());
				botonCompra.setDisable(true);
				juego.updateDinero();
			}
			catch(TieneDuenio exp){
				crearAlertaInformation(casillaActual.getNombre(),"El terreno ya tiene duenio");
			}
			catch(DineroInsuficiente expDin){
				crearAlertaInformation(casillaActual.getNombre(),"No es posible realizar la compra, dinero insuficiente");
			}
		}
	}

		
	public void crearAlertaInformation(String titulo,String texto){
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(titulo);
		alert.setHeaderText("");
		alert.setContentText(texto);
		Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
		stage.setOnCloseRequest(e->e.consume());
		stage.getIcons().add(new Image(getClass().getResourceAsStream("../img/icon.png")));
		stage.showAndWait();
	}
	
}
