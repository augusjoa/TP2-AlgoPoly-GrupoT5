package vista;

import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import modelo.AlgoPoly;

public class Juego extends BorderPane{
	static final int pixelCasilla=60;
	private VistaTablero vistaTablero;
	private VistaSuperior vistaSuperior;
	private VistaLateralDerecha vistaLateralDerecha;
	private AlgoPoly partida;
	
	public Juego(Stage stage){
		
		partida = new AlgoPoly();
		partida.iniciarPartida();
		
		vistaSuperior = new VistaSuperior(stage, this, partida);
		vistaTablero = new VistaTablero(this);
		vistaLateralDerecha = new VistaLateralDerecha(this, partida);
		
		setSuperior();
		setCentro();
		setDerecha();
	}
	
	private void setSuperior(){
		this.setTop(vistaSuperior);
	}
	
	private void setDerecha(){
		this.setRight(vistaLateralDerecha);
	}
	
	private void setCentro(){
		this.setCenter(vistaTablero);
	}
	
	public int getPixelCasilla(){
		return pixelCasilla;
	}
	
	public AlgoPoly partida(){
		return this.partida;
	}
	
	public BarraMenu getBarraMenu(){
		return vistaSuperior.getBarraMenu();
	}
}
