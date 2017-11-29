package vista;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import modelo.Tablero;
import modelo.interfaces.Visitable;

public class VistaCasillero {

	Tablero tablero;
	Visitable casillero;
	Button botonCasillero;	
	
	public VistaCasillero(Tablero tablero,int posEnLista){
		
		this.tablero=tablero;
		this.casillero=tablero.getCasillero(posEnLista);
		this.botonCasillero = new Button();
		botonCasillero.setMaxWidth(Long.MAX_VALUE);
		botonCasillero.setMaxHeight(Long.MAX_VALUE);
		botonCasillero.setText(getNombreDelBoton());
		botonCasillero.setAlignment(Pos.TOP_CENTER);
		botonCasillero.setFont(Font.font("Consolas", FontWeight.BOLD, 15));
	}
	
	public Button getBotonCasillero(){
		return botonCasillero;
	}
	
	private String getNombreDelBoton(){
		return casillero.getNombre();
	}
}
