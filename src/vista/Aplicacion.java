package vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import vista.eventos.SalirEventoWindow;

public class Aplicacion extends Application {

	public static void main(String[] args) {
        launch(args);
    }
	
	@Override
    public void start(final Stage stage) throws Exception{
		
		stage.setTitle("AlgoPoly");
        stage.setOnCloseRequest(new SalirEventoWindow());
        stage.getIcons().add(new Image(getClass().getResourceAsStream("img/iconGrande.png")));
        
        Juego vistaJuego = new Juego(stage);
        Scene escenaJuego = new Scene(vistaJuego,800,600);
        
        MenuPrincipal menuPrincipal = new MenuPrincipal(stage, escenaJuego);
        Scene escenaPrincipal = new Scene(menuPrincipal, 800,600);
        
        stage.setScene(escenaPrincipal);
        stage.show();

	}
	
}
