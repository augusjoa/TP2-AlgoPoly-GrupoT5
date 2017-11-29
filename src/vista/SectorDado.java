package vista;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class SectorDado extends VBox {

	private Button btnTirarDados;
	private Label textoDados;
	
	public SectorDado(Button tirarDados, Label textoDados){
		this.btnTirarDados = tirarDados;
		this.textoDados = textoDados;
		this.getChildren().addAll(btnTirarDados, textoDados);
		
		this.setAlignment(Pos.CENTER);
		this.setSpacing(10);
	}
	
	public Button getBotonTirarDado(){
		return btnTirarDados;
	}
	
	public Label getTextoDados(){
		return textoDados;
	}
}
