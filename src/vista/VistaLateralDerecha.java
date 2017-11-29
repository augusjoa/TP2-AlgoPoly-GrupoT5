package vista;



import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import modelo.AlgoPoly;

public class VistaLateralDerecha extends VBox {

	
	public VistaLateralDerecha(Juego juego, AlgoPoly unaPartida){
		Button btnTirarDados = new Button("Tirar Dados");
		this.setSpacing(10);
		this.setPadding(new Insets(15));
		this.getChildren().add(btnTirarDados);
		
	}
	
}
