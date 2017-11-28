package vista;

import vista.OpcionesMenuPrincipal;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class MenuPrincipal extends BorderPane{
	private Stage stage;
	private Scene escenaJuego;
	
	public MenuPrincipal(Stage stage, Scene escenaJuego){
		this.stage= stage;
		this.escenaJuego= escenaJuego;
		
		setVistaCentral();		
	}
	
	private void setVistaCentral() {
		this.setCenter(new OpcionesMenuPrincipal(stage, escenaJuego));
	}
	
	
}
