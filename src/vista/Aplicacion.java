package vista;

import vista.eventos.AplicacionOnKeyPressedEvento;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import modelo.AlgoPoly;
import vista.eventos.SalirEventoWindow;

public class Aplicacion extends Application {

	public static void main(String[] args) {
        launch(args);
    }
	
	@Override
    public void start(final Stage stage) throws Exception{
		
		stage.setTitle("AlgoPoly");
		stage.setResizable(false);
		stage.setOnCloseRequest(new SalirEventoWindow());
        stage.getIcons().add(new Image(getClass().getResourceAsStream("img/iconGrande.png")));
        
        AlgoPoly unaPartida = new AlgoPoly();
        
        Juego vistaJuego = new Juego(stage, unaPartida);
        Scene escenaJuego = new Scene(vistaJuego,800,600);
        
        escenaJuego.setOnKeyPressed(new AplicacionOnKeyPressedEvento(vistaJuego.getBarraMenu()));
        
        
        MenuPrincipal menuPrincipal = new MenuPrincipal(stage, escenaJuego);
        Scene escenaPrincipal = new Scene(menuPrincipal, 800,600);
        
        stage.setScene(escenaPrincipal);
        stage.show();

	}
	
}
