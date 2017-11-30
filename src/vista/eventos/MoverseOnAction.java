package vista.eventos;



import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import modelo.AlgoPoly;
import modelo.casillas.AvanceDinamico;
import modelo.casillas.ImpuestoAlLujo;
import modelo.casillas.Quini6;
import modelo.casillas.RetrocesoDinamico;
import modelo.interfaces.Visitable;
import vista.Juego;


public class MoverseOnAction implements EventHandler<ActionEvent> {

	Juego juego;
	AlgoPoly partida;

	
	public MoverseOnAction(AlgoPoly unAlgoPoly,Juego juego) {
		this.partida = unAlgoPoly;
		this.juego = juego;

	}
	
	@Override
	public void handle(ActionEvent event) {
		int numeroDado= partida.getJugadorActual().getNumeroDelDado();
		partida.getJugadorActual().moverse(numeroDado);
		
		
		alertaAlCaerEnAvance();
		alertaAlCaerEnRetroceso();
		
		alertaAlCaerEnCarcel();
		alertaAlCaerEnQuini6();
		alertaAlCaerEnImpuesto();
		
		
		juego.update();
	}

	private void alertaAlCaerEnCarcel() {
		Visitable casillaActual= partida.getJugadorActual().getCasillaActual();
		if(partida.getJugadorActual().getCasillaActual() == partida.tablero().getCarcel()){
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle(casillaActual.getNombre());
	    	alert.setHeaderText("");
	    	alert.setContentText("Se encuentra atrapado en la carcel, deberá pagar una fianza en los proximos turnos o esperar a ser liberado");
	    	Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
	    	stage.getIcons().add(new Image(getClass().getResourceAsStream("../img/icon.png")));
	    	alert.showAndWait();
		}
	}
	
	private void alertaAlCaerEnQuini6() {
		Visitable casillaActual= partida.getJugadorActual().getCasillaActual();
		if(casillaActual == partida.tablero().getCasillero(1)){
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle(casillaActual.getNombre());
	    	alert.setHeaderText("");
	    	int valorPremio = ((Quini6) casillaActual).getValorPremio();
	    	if(valorPremio == 0){
	    		alert.setContentText("Le informamos que no tenemos más premios.");
	    	}
	    	alert.setContentText("Ha ganado un premio de: "+valorPremio);
	    	Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
	    	stage.setOnCloseRequest(e->e.consume());
	    	stage.getIcons().add(new Image(getClass().getResourceAsStream("../img/icon.png")));
	    	Optional<ButtonType> result = alert.showAndWait();
	    	if (result.get() == ButtonType.OK || result.get() == ButtonType.CLOSE){
	    		juego.updateDinero();
	    	}
		}
	}
	
	
	private void alertaAlCaerEnRetroceso(){
		Visitable casillaActual= partida.getJugadorActual().getCasillaActual();
		if( casillaActual == partida.tablero().getCasillero(18)){
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle(casillaActual.getNombre());
	    	alert.setHeaderText("");
	    	alert.setContentText("Retrocedes: "+Integer.toString(((RetrocesoDinamico) casillaActual).getCantidadDePasos()));
	    	Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
	    	stage.setOnCloseRequest(e->e.consume());
	    	stage.getIcons().add(new Image(getClass().getResourceAsStream("../img/icon.png")));
	    	alert.showAndWait();
		}
	}
	
	private void alertaAlCaerEnAvance(){
		Visitable casillaActual= partida.getJugadorActual().getCasillaActual();
		if( casillaActual == partida.tablero().getCasillero(7)){
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle(casillaActual.getNombre());
	    	alert.setHeaderText("");
	    	alert.setContentText("Avanzas: "+Integer.toString(((AvanceDinamico) casillaActual).getCantidadDePasos()));
	    	Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
	    	stage.setOnCloseRequest(e->e.consume());
	    	stage.getIcons().add(new Image(getClass().getResourceAsStream("../img/icon.png")));
	    	alert.showAndWait();
		}
	}
	
	private void alertaAlCaerEnImpuesto(){
		Visitable casillaActual= partida.getJugadorActual().getCasillaActual();
		if( casillaActual == partida.tablero().getCasillero(10)){
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle(casillaActual.getNombre());
	    	alert.setHeaderText("");
	    	alert.setContentText("Perdes un "+Integer.toString(((ImpuestoAlLujo) casillaActual).getPorcentajeDelImpuesto())+"% de tu Dinero.");
	    	Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
	    	stage.setOnCloseRequest(e->e.consume());
	    	stage.getIcons().add(new Image(getClass().getResourceAsStream("../img/icon.png")));
	    	Optional<ButtonType> result = alert.showAndWait();
	    	if (result.get() == ButtonType.OK || result.get() == ButtonType.CLOSE){
	    		juego.updateDinero();
	    	}
		}
	}

}
