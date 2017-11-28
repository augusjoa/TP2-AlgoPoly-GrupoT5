package vista;

import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Juego extends BorderPane{
	//protected VistaTablero vistaTablero;
	//protected VistaInferior vistaInferior;
	protected VistaSuperior vistaSuperior;
	
	
	public Juego(Stage stage){
		
		vistaSuperior = new VistaSuperior(this,stage);
		//vistaLateralDerecha = new VistaLateralDerecha(this);
		//vistaTablero = new VistaTablero(this);
		setSuperior();
		setDerecha();
	}
	
	private void setSuperior(){
		this.setTop(vistaSuperior);
	}
	
	private void setDerecha(){
		//this.setRight(vistaLateralDerecha);
	}
	
	//private void setCentro(){
		//this.setCenter(vistaTablero);
	//}
	
	public BarraMenu getBarraMenu(){
		return vistaSuperior.getBarraMenu();
	}
}
