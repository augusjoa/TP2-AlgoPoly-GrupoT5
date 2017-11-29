package vista;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modelo.AlgoPoly;

public class VistaJugador {
	
	ImageView imagenVista;
	
	public VistaJugador(AlgoPoly partida, int numeroDeJugador){
		
		String numero = Integer.toString(numeroDeJugador);
		Image imagenJugador = new Image(getClass().getResourceAsStream("img/jugadores/jugador"+numero+".png"));
		imagenVista = new ImageView(imagenJugador);
	}
	
	public ImageView getImagenVista(){
		return imagenVista;
	}
}
