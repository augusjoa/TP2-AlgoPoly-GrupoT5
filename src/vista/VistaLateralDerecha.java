package vista;



import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import modelo.AlgoPoly;

public class VistaLateralDerecha extends VBox {

	private VBox panelInfo;
	
	public VistaLateralDerecha(Juego juego, AlgoPoly unaPartida){
		Button btnTirarDados = new Button("Tirar Dados");
		Button btnTirarDados2 = new Button("Tirar Dados");
		this.setStyle( "-fx-background-color: lightgrey;");
		panelInfo = new VBox();
		panelInfo.setPrefWidth(300);
		panelInfo.resize(USE_PREF_SIZE, USE_COMPUTED_SIZE);
		panelInfo.setSpacing(10);
		panelInfo.setPadding(new Insets(10));
		panelInfo.setStyle( "-fx-background-color: lightblue;");
		panelInfo.getChildren().addAll(btnTirarDados, btnTirarDados2);
		this.getChildren().add(panelInfo);
		this.setSpacing(5);
		panelInfo.requestLayout();
		
		
	}

	public VBox getPanelInfo() {
		return panelInfo;
	}
	
}
