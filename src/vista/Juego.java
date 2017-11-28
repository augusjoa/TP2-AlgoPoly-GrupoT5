package vista;

import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import modelo.AlgoPoly;

public class Juego extends BorderPane{
	static final int pixelCasilla=60;
	private VistaTablero vistaTablero;
	private VistaSuperior vistaSuperior;
	private VistaLateralDerecha vistaLateralDerecha;
	private AlgoPoly unaPartida;
	
	public Juego(Stage stage, AlgoPoly unaPartida){
		this.unaPartida = unaPartida;
		vistaSuperior = new VistaSuperior(stage, this);
		vistaTablero = new VistaTablero(this);
		vistaLateralDerecha = new VistaLateralDerecha(stage, this, unaPartida);
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
