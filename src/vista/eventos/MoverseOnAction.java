package vista.eventos;



import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import modelo.AlgoPoly;
import modelo.Jugador;
import modelo.casillas.AvanceDinamico;
import modelo.casillas.ImpuestoAlLujo;
import modelo.casillas.Quini6;
import modelo.casillas.RetrocesoDinamico;
import modelo.interfaces.Adquirible;
import modelo.interfaces.Visitable;
import vista.Juego;


public class MoverseOnAction implements EventHandler<ActionEvent> {

	Juego juego;
	AlgoPoly partida;
	Button botonPagarFianza;
	Button botonCompra;
	Button botonVenta;
	
	public MoverseOnAction(AlgoPoly unAlgoPoly,Juego juego,Button botonPagarFianza,Button botonCompra,Button botonVenta) {
		this.partida = unAlgoPoly;
		this.juego = juego;
		this.botonPagarFianza=botonPagarFianza;
		this.botonCompra=botonCompra;
		this.botonVenta=botonVenta;
	}
	
	@Override
	public void handle(ActionEvent event) {
		int numeroDado= partida.getJugadorActual().getNumeroDelDado();
		partida.getJugadorActual().moverse(numeroDado);
		
		habilitarCompraCasillero();
		habilitarVentaCasillero();
		
		alertaAlCaerEnAvance();
		alertaAlCaerEnRetroceso();
		alertaAlCaerEnCarcel();
		alertaAlCaerEnQuini6();
		alertaAlCaerEnImpuesto();
		
		
		juego.update();
	}
	
	public void habilitarVentaCasillero(){
		Jugador jugadorActual= partida.getJugadorActual();
		Visitable casillaActual = jugadorActual.getCasillaActual();
		if(casillaActual instanceof Adquirible){
			if(((Adquirible) casillaActual).getDuenio() ==jugadorActual){
				botonVenta.setDisable(false);
			}
		}
	}
	
	public void habilitarCompraCasillero(){
		Visitable casillaActual= partida.getJugadorActual().getCasillaActual();
		if(casillaActual instanceof Adquirible){
			botonCompra.setDisable(false);
		}
	}
	
	public void crearAlerta(String nombre,String texto){
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(nombre);
    	alert.setHeaderText("");
    	alert.setContentText(texto);
    	Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
    	stage.setOnCloseRequest(e->e.consume());
    	stage.getIcons().add(new Image(getClass().getResourceAsStream("../img/icon.png")));
    	Optional<ButtonType> result = alert.showAndWait();
    	if (result.get() == ButtonType.OK){
    		juego.updateDinero();
    	}
	}

	private void alertaAlCaerEnCarcel() {
		Visitable casillaActual= partida.getJugadorActual().getCasillaActual();
		if(partida.getJugadorActual().getCasillaActual() == partida.tablero().getCarcel()){
			String texto= "Se encuentra atrapado en la carcel, deberá pagar una fianza en los proximos turnos o esperar a ser liberado";
			crearAlerta(casillaActual.getNombre(),texto);
			botonPagarFianza.setDisable(false);
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
		if(casillaActual == partida.tablero().getCasillero(18)){
			String texto= "Retrocedes: "+Integer.toString(((RetrocesoDinamico) casillaActual).getCantidadDePasos());
			crearAlerta(casillaActual.getNombre(),texto);
		}
	}
	
	private void alertaAlCaerEnAvance(){
		Visitable casillaActual= partida.getJugadorActual().getCasillaActual();
		if( casillaActual == partida.tablero().getCasillero(7)){
			String texto="Avanzas: "+Integer.toString(((AvanceDinamico) casillaActual).getCantidadDePasos());
			crearAlerta(casillaActual.getNombre(),texto);
		}
	}
	
	private void alertaAlCaerEnImpuesto(){
		Visitable casillaActual= partida.getJugadorActual().getCasillaActual();
		if( casillaActual == partida.tablero().getCasillero(10)){
			String texto= "Perdes un "+Integer.toString(((ImpuestoAlLujo) casillaActual).getPorcentajeDelImpuesto())+"% de tu Dinero.";
			crearAlerta(casillaActual.getNombre(),texto);
		}
	}

}
