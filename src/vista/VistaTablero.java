package vista;

import javafx.geometry.Pos;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class VistaTablero extends GridPane {

	Juego juego;
	int cantidadDeCasilleros = 8;
	
	public VistaTablero(Juego juego){
		this.juego = juego;
		this.setAlignment(Pos.CENTER);

		this.setGridLinesVisible(true);
		
		for (int i = 0; i < cantidadDeCasilleros; i++) {
		    ColumnConstraints cc = new ColumnConstraints(juego.getPixelCasilla());
		    this.getColumnConstraints().add(cc);
		}
		
		for (int i = 0; i < cantidadDeCasilleros; i++) {
			RowConstraints rc = new RowConstraints(juego.getPixelCasilla());
		    this.getRowConstraints().add(rc);
		}
	}
	
}
