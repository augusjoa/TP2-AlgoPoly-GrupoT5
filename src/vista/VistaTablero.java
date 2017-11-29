package vista;

import java.util.Vector;

import javafx.beans.binding.DoubleBinding;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
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
import javafx.scene.text.Text;
import modelo.AlgoPoly;
import modelo.interfaces.Visitable;
import vista.eventos.SeleccionDeCasillaOnAction;

public class VistaTablero extends GridPane {

	Juego juego;
	int cantidadFilas = 6;
	int cantidadDeCasilleros;
	AlgoPoly partida;
	
	public VistaTablero(Juego juego){

		partida=juego.partida();
		cantidadDeCasilleros=partida.tablero().cantidadDeCasillas();
		
		this.setAlignment(Pos.CENTER);

		this.setGridLinesVisible(true);
		
		final RowConstraints rowsEdge = new RowConstraints();
		rowsEdge.setPercentHeight( 14 );
		
		final RowConstraints rowsMid = new RowConstraints();
		rowsMid.setPercentHeight( 10 );

		final ColumnConstraints colEdge = new ColumnConstraints();
		colEdge.setPercentWidth( 14 );

		final ColumnConstraints colMid = new ColumnConstraints();
		colMid.setPercentWidth( 10 );
		
		this.getColumnConstraints().addAll(colEdge,  colMid, colMid, colMid, colMid, colEdge );
		this.getRowConstraints().addAll(rowsEdge,  rowsMid, rowsMid, rowsMid, rowsMid, rowsEdge );

		final StackPane imagePane = new StackPane();
		this.add( imagePane, 1, 1, 4, 4);
		
		final DoubleBinding multipliedHeight = this.heightProperty().multiply( 0.4 );
		final DoubleBinding multipliedWidth = this.widthProperty().multiply( 0.4 );

		imagePane.maxHeightProperty().bind( multipliedHeight );
		imagePane.maxWidthProperty().bind( multipliedWidth );
		imagePane.minHeightProperty().bind( multipliedHeight );
		imagePane.minWidthProperty().bind( multipliedWidth );
		imagePane.prefHeightProperty().bind( multipliedHeight );
		imagePane.prefWidthProperty().bind( multipliedWidth );

		final ImageView imageView =	new ImageView( "http://1.bp.blogspot.com/-Wjc79oqi1y0/VHitLAU44BI/AAAAAAAAG80/0UZ9n2JmvEo/s1600/Logo%2BMonopoly.png" );
		imageView.setPreserveRatio( true );
		imageView.fitWidthProperty().bind( imagePane.widthProperty().divide( 1 ) );
		imagePane.setStyle( "-fx-background-color: red;" );
	  	imagePane.getChildren().add( imageView );
	  	
	  	int contador=cantidadDeCasilleros-1;
	  	for (int i = 0 ; i < cantidadFilas ; i++) {
            for (int j = 0; j < cantidadFilas; j++) {
            	if(i==0 || i==cantidadFilas-1 || j==0 || j==cantidadFilas-1){
            		agregarBoton(i,j,contador);
            		contador--;
            	}         	
            }
        }
	  	
	  	agregarJugadores();
	}
	
	private void agregarBoton(int columna,int fila,int contadorDeLista){
		Button boton = new Button();
		boton.setMaxWidth(Long.MAX_VALUE);
		boton.setMaxHeight(Long.MAX_VALUE);
		boton.setText(getNombreDelBoton(contadorDeLista));
		boton.setOnAction(new SeleccionDeCasillaOnAction(partida.tablero().getCasillero(vector[contadorDeLista])));
		this.add(boton, columna, fila);
	}
	
	//vector ver donde va
	private int vector[]={0,19,18,17,16,15,1,14,2,13,3,12,4,11,5,6,7,8,9,10};
	private String getNombreDelBoton(int contador){
		Visitable casilla = partida.tablero().getCasillero(vector[contador]);
		return casilla.getNombre();
	}
	
	private void agregarJugadores(){
		Circle jugador = new Circle(10);
		jugador.setFill(Color.GREEN);
		jugador.setTranslateX(125);
		jugador.setTranslateY(25);
		
		this.add(jugador, 5, 5);
		
		Circle jugador2 = new Circle(10);
		jugador2.setFill(Color.BLUE);
		jugador2.setTranslateX(100);
		jugador2.setTranslateY(25);
		this.add(jugador2, 5, 5);
		
		Circle jugador3 = new Circle(10);
		jugador3.setFill(Color.BLACK);
		jugador3.setTranslateX(75);
		jugador3.setTranslateY(25);
		this.add(jugador3, 5, 5);
	}
	

	
}
