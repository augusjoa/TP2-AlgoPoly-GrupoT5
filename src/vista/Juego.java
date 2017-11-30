package vista;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modelo.AlgoPoly;

public class Juego extends BorderPane{
	private VistaTablero vistaTablero;
	private VistaSuperior vistaSuperior;
	private VistaLateralDerecha vistaLateralDerecha;
	private AlgoPoly partida;
	
	public Juego(Stage stage){
		
		partida = new AlgoPoly();
		partida.iniciarPartida();
		
		vistaSuperior = new VistaSuperior(stage, this);
		vistaTablero = new VistaTablero(this);
		vistaLateralDerecha = new VistaLateralDerecha(this, partida);
		
		setSuperior();
		setDerecha();
		setCentro();
		
		
	}
	
	public void update(){
		vistaTablero.update();
		//vistaSuperior.update();
		//vistaLateralDerecha.update();
	}
	
	public void updateVista(){
		vistaSuperior.update();
	}
	
	public void updateDinero(){
		vistaSuperior.updateDinero();
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
	
	public AlgoPoly partida(){
		return this.partida;
	}
	
	public BarraMenu getBarraMenu(){
		return vistaSuperior.getBarraMenu();
	}

	public VBox getPanelInfo() {
		return vistaLateralDerecha.getPanelInfo();
	}
}
