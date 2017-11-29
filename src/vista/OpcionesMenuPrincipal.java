package vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import vista.eventos.CambiarEscena;
import vista.eventos.MostrarReglasOnAction;
import vista.eventos.SalirEventoOnAction;

public class OpcionesMenuPrincipal extends VBox{

	public OpcionesMenuPrincipal(Stage stage, Scene escenaJugar){
		this.setPadding(new Insets(20));
		this.setSpacing(10);
		this.setAlignment(Pos.CENTER);
				
		Image fondo = new Image(getClass().getResource("img/fondo.jpg").toExternalForm());
		BackgroundImage bk = new BackgroundImage(fondo, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
		this.setBackground(new Background(bk));
		
		
		Button bInstrucciones = new Button();
		bInstrucciones.setText("Reglas de Juego");
		bInstrucciones.setFont(Font.font("Consolas", FontWeight.BOLD, 17));
		bInstrucciones.setOnAction(new MostrarReglasOnAction());
		
		Button bJugar = new Button();
		bJugar.setText("Jugar!");
		bJugar.setFont(Font.font("Consolas", FontWeight.BOLD, 17));
		bJugar.setOnAction(new CambiarEscena(stage, escenaJugar));

		
		Button bSalir = new Button();
		bSalir.setText("Salir");
		bSalir.setFont(Font.font("Consolas", FontWeight.BOLD, 17));
		bSalir.setOnAction(new SalirEventoOnAction());
		
		
		
		this.getChildren().addAll(bJugar, bInstrucciones, bSalir);
	}
}
