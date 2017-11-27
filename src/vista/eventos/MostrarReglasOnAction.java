package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import vista.VistaReglas;

public class MostrarReglasOnAction implements EventHandler<ActionEvent> {
	
	 @Override
	    public void handle(ActionEvent actionEvent){
	    	Stage reglas = new Stage();
	    	reglas.setTitle("Reglas de Juego");
			reglas.getIcons().add(new Image(getClass().getResourceAsStream("../img/iconGrande.png")));
	    	VistaReglas vistaReglasDeJuego = new VistaReglas();
	    	Scene escena = new Scene(vistaReglasDeJuego,800,600);
	    	reglas.setScene(escena);
	    	reglas.show();
	    }

}
