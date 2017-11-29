package vista;

import java.util.Vector;

import javafx.beans.binding.DoubleBinding;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import modelo.AlgoPoly;
import modelo.Tablero;
import modelo.interfaces.Visitable;
import vista.eventos.SeleccionDeCasillaOnAction;

public class VistaTablero extends GridPane {

	AlgoPoly partida;
	Tablero tablero;
	Juego juego;
	int cantidadDeCasilleros;
	int cantidadFilas = 6;
	int posEnLista[]={0,19,18,17,16,15,1,14,2,13,3,12,4,11,5,6,7,8,9,10};
	int posX[]={5,4,3,2,1,0,0,0,0,0,0,1,2,3,4,5,5,5,5,5};
	int posY[]={5,5,5,5,5,5,4,3,2,1,0,0,0,0,0,0,1,2,3,4};
	VistaJugador[] vistaJugador;
	
	public VistaTablero(Juego juego){

		partida=juego.partida();
		tablero=partida.tablero();
		cantidadDeCasilleros=tablero.cantidadDeCasillas();
		
		this.setAlignment(Pos.CENTER);

		this.setGridLinesVisible(true);
		
		final RowConstraints fila = new RowConstraints();
		fila.setPercentHeight( 14 );

		final ColumnConstraints columna = new ColumnConstraints();
		columna.setPercentWidth( 14 );
		
		this.getColumnConstraints().addAll(columna,  columna, columna, columna, columna, columna );
		this.getRowConstraints().addAll(fila,  fila, fila, fila, fila, fila );

		final StackPane panel = new StackPane();
		this.add( panel, 1, 1, 4, 4);
		
		final DoubleBinding multipliedHeight = this.heightProperty().multiply( 0.56 );
		final DoubleBinding multipliedWidth = this.widthProperty().multiply( 0.56 );

		panel.maxHeightProperty().bind( multipliedHeight );
		panel.maxWidthProperty().bind( multipliedWidth );
		panel.minHeightProperty().bind( multipliedHeight );
		panel.minWidthProperty().bind( multipliedWidth );
		panel.prefHeightProperty().bind( multipliedHeight );
		panel.prefWidthProperty().bind( multipliedWidth );

		final ImageView imageView =	new ImageView( "http://1.bp.blogspot.com/-Wjc79oqi1y0/VHitLAU44BI/AAAAAAAAG80/0UZ9n2JmvEo/s1600/Logo%2BMonopoly.png" );
		imageView.setPreserveRatio( true );
		imageView.fitWidthProperty().bind( panel.widthProperty().divide( 1 ) );
		panel.setStyle( "-fx-background-color: red;" );
	  	panel.getChildren().add( imageView );
	  	
	  	agregarBotones(cantidadDeCasilleros-1);
	  	agregarJugadores(partida);
	  	
	  	
	}
	
	private void agregarBotones(int contador){
		for (int i = 0 ; i < cantidadFilas ; i++) {
            for (int j = 0; j < cantidadFilas; j++) {
            	if(i==0 || i==cantidadFilas-1 || j==0 || j==cantidadFilas-1){
            		VistaCasillero casillero = new VistaCasillero(tablero,posEnLista[contador]);
            		this.add(casillero.getBotonCasillero(), i,j);
            		contador--;
            	}         	
            }
        }
	}
	
	
	private void agregarJugadores(AlgoPoly partida){
		
		for(int i=1; i<=partida.cantidadDeJugadores;i++){
			vistaJugador = new VistaJugador[i];
			Visitable casillaActualDelJugador = partida.getJugadorActual().getCasillaActual();
			int posicionJugador = tablero.getPosDeCasilla(casillaActualDelJugador);
			
			VistaJugador vistaJugador = new VistaJugador(partida,i);
			
			this.add(vistaJugador.getImagenVista(), posX[posicionJugador],posY[posicionJugador]);
		}		
	}
	
	public void update(){
//		//this.getChildren().clear();
//		for(int i=1; i<=partida.cantidadDeJugadores;i++){
//			this.clearConstraints(vistaJugador[i].getImagenVista());
//			vistaJugador = new VistaJugador[i];
//			Visitable casillaActualDelJugador = partida.getJugadorActual().getCasillaActual();
//			int posicionJugador = tablero.getPosDeCasilla(casillaActualDelJugador);
//			this.add(new VistaJugador(partida,i).getImagenVista(), posX[posicionJugador],posY[posicionJugador]);
//		}	
	}
	
//	private void agregarJugadoresPosInicial(AlgoPoly partida){
//		
//		Visitable casillaActualDelJugador = partida.getJugadorActual().getCasillaActual();
//		int posicionJugador = tablero.getPosDeCasilla(casillaActualDelJugador);
//		int x= posX(posicionJugador)
//		int y= posY(posicionJugador)
//	}
	

	
}
