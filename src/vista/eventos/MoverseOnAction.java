package vista.eventos;



import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import modelo.AlgoPoly;
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
		
		alertaAlCaerEnQuini6();
		alertaAlCaerEnCarcel();
		
		juego.update();

	}

	private void alertaAlCaerEnCarcel() {
		if(partida.getJugadorActual().getCasillaActual() == partida.tablero().getCarcel()){
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("¡¡¡Atrapado en la Carcel!!!");
	    	alert.setHeaderText("");
	    	alert.setContentText("Usted cayo en la carcel, deberá pagar una fianza en los proximos turnos o esperar a ser liberado");
	    	Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
	    	stage.getIcons().add(new Image(getClass().getResourceAsStream("../img/icon.png")));
	    	alert.showAndWait();
//	    	Image image = new Image(getClass().getResource("../img/casilleros/carcel.jpg").toExternalForm());
//	    	ImageView imageView = new ImageView(image);
//	    	alert.setGraphic(imageView);
		}
	}

	private void alertaAlCaerEnQuini6() {
		if(partida.getJugadorActual().getCasillaActual() == partida.tablero().getCasillero(0)){
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("¡¡¡Ganaste el Quini 6!!!");
	    	alert.setHeaderText("");
	    	alert.setContentText("Ha ganado un premio");
	    	Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
	    	stage.getIcons().add(new Image(getClass().getResourceAsStream("../img/icon.png")));
	    	alert.showAndWait();
		}
	}

}
