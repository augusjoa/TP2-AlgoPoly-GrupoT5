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
		this.setSpacing(10);
		this.setStyle( "-fx-background-color: lightgrey;");
		this.setPadding(new Insets(10));
		panelInfo = new VBox();
		panelInfo.setPrefWidth(200);
		panelInfo.resize(USE_PREF_SIZE, USE_COMPUTED_SIZE);
		panelInfo.setSpacing(20);
		panelInfo.setPadding(new Insets(30));
		panelInfo.getChildren().addAll(btnTirarDados, btnTirarDados2);
		
		this.getChildren().add(panelInfo);
		panelInfo.requestLayout();
		
		
	}

	public VBox getPanelInfo() {
		return panelInfo;
	}
	
}
