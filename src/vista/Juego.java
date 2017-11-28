package vista;

import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Juego extends BorderPane{
	static final int pixelCasilla=30;
	protected VistaTablero vistaTablero;
	protected VistaSuperior vistaSuperior;
	
	
	public Juego(Stage stage){
		
		vistaSuperior = new VistaSuperior(this,stage);
		vistaTablero = new VistaTablero(this);
		//vistaLateralDerecha = new VistaLateralDerecha(this);
		setSuperior();
		setCentro();
		//setDerecha();
	}
	
	private void setSuperior(){
		this.setTop(vistaSuperior);
	}
	
	//private void setDerecha(){
		//this.setRight(vistaLateralDerecha);
	//}
	
	private void setCentro(){
		this.setCenter(vistaTablero);
	}
	
	public int getPixelCasilla(){
		return pixelCasilla;
	}
	
	public BarraMenu getBarraMenu(){
		return vistaSuperior.getBarraMenu();
	}
}
