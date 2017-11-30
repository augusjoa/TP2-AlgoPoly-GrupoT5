package modelo.casillas;

import java.util.Hashtable;

import javafx.geometry.Orientation;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import modelo.Dinero;
import modelo.Jugador;
import modelo.excepciones.BarrioNoLleno;
import modelo.excepciones.NoEsDuenioDeLosDosTerrenos;
import modelo.excepciones.BarrioLleno;

public class BarrioDoble extends Barrio {
	
	private static final int LIMITEDECASAS = 2;
	private static final int LIMITEDEHOTEL = 1;
	private int cantidadDeCasas = 0;
	private int cantidadDeHoteles = 0;
	private Dinero precioCasa;
	private Dinero precioHotel;
    private Hashtable<Integer, Dinero> alquileres = new Hashtable<Integer, Dinero>();
    private BarrioDoble otrazona; 

	public BarrioDoble(int precioDelBarrio, int unprecioCasa, int unprecioHotel, int alquilersincasa, int alquilerconcasa, int alquilerconDosCasas, int alquilerconHotel, String unNombre) {
		valorDelBarrio = new Dinero(precioDelBarrio);
		nombre = unNombre;
		precioCasa = new Dinero(unprecioCasa);
		precioHotel = new Dinero(unprecioHotel);
		alquileres.put(0,new Dinero (alquilersincasa));
		alquileres.put(1, new Dinero (alquilerconcasa));
		alquileres.put(2, new Dinero(alquilerconDosCasas));
		alquileres.put(3, new Dinero(alquilerconHotel));
	}
	
	private void verificarConstruccionDeCasas() throws BarrioLleno, NoEsDuenioDeLosDosTerrenos {
		if(!jugadorDuenio.esDuenio(otrazona)){
			throw new NoEsDuenioDeLosDosTerrenos();
		}
		if(cantidadDeCasas == LIMITEDECASAS || cantidadDeHoteles == LIMITEDEHOTEL) {
			throw new BarrioLleno();	
		}
	}
	
	private void verificarOtraZona() throws BarrioNoLleno {
	
	 if (otrazona.getCantidadDeEdificios() == 0 || otrazona.getCantidadDeEdificios() == 1) {
		 if(otrazona.getCantidadDeCasas() != LIMITEDECASAS && otrazona.getCantidadDeHoteles() == 0) {
			 throw new BarrioNoLleno();
		 }
	 }
	}
	
	private int getCantidadDeHoteles() {
		// TODO Auto-generated method stub
		return cantidadDeHoteles;
	}

	private void verificarNumeroDeCasasMaximo() throws BarrioLleno{
		if(cantidadDeCasas != LIMITEDECASAS) throw new BarrioLleno();
	}
	
	public void agregarCasa(Jugador unJugador) {
		verificarJugador(unJugador);
		verificarConstruccionDeCasas();
		jugadorDuenio.sustraerDinero(precioCasa);
		valorDelBarrio.agregarDinero(precioCasa);
		cantidadDeCasas ++;
	}

	public void agregarHotel(Jugador unJugador) {
		verificarJugador(unJugador);
		verificarNumeroDeCasasMaximo();
		verificarOtraZona();
		jugadorDuenio.sustraerDinero(precioHotel);
		valorDelBarrio.agregarDinero(precioHotel);
		destruirCasas();
		cantidadDeHoteles ++;
		
	}

	public void setOtraZona(BarrioDoble unaZona) {
		otrazona = unaZona;
	}
	
	private int getCantidadDeCasas() {
		return cantidadDeCasas;
	}
	
	public int getCantidadDeEdificios() {
		return cantidadDeCasas + cantidadDeHoteles;
	}

	@Override
	public void cobrarAlquilerA(Jugador unJugador) {
		Dinero alquiler = alquileres.get(cantidadDeCasas + cantidadDeHoteles);
		unJugador.sustraerDinero(alquiler);
		jugadorDuenio.agregarDinero(alquiler);		
	}
	
	private void destruirCasas(){
		while(cantidadDeCasas > 0){
			valorDelBarrio.sustraerDinero(precioCasa);
			cantidadDeCasas--;
		}
		cantidadDeCasas = 0;
	}
	
	private void destruirHoteles() {
		if(cantidadDeHoteles!=0){
			valorDelBarrio.sustraerDinero(precioHotel);
			cantidadDeHoteles = 0;
		}
	}
	
	public void destruirEdificios(){
		destruirHoteles();
		destruirCasas();
	}
	
	@Override
	public VBox loadPanelInfo(VBox panelInfo) {
		
		Label nombre = new Label("Nombre: " + this.nombre);
		nombre.setFont(Font.font("Consolas", FontWeight.BOLD, 14));
		
		Label duenio = new Label("");
		if(jugadorDuenio == null) {
			duenio.setText("Dueño: Sin Dueño");
		}else {
			duenio.setText("Dueño: Jugador " +jugadorDuenio.getNumeroDelJugador());
		}
		
		duenio.setFont(Font.font("Consolas", FontWeight.BOLD, 14));
		duenio.setWrapText(true);
		
		Label precioTerreno = new Label("Precio terreno: " + valorDelBarrio.getValor());
		precioTerreno.setFont(Font.font("Consolas", FontWeight.BOLD, 14));
		
		Label precioCasaTxt = new Label("Precio construir casa: " + precioCasa.getValor());
		precioCasaTxt.setFont(Font.font("Consolas", FontWeight.BOLD, 14));
		
		Label precioHotelTxt = new Label("Precio construir Hotel: " + precioHotel.getValor());
		precioHotelTxt.setFont(Font.font("Consolas", FontWeight.BOLD, 14));
		

		Label alquiler[];
		alquiler = new Label[4];
		String txtAlquileres[] = new String[] {
			"Alquiler: ",
			"Alquiler con una casa: ",
			"Alquiler con dos casas: ",
			"Alquiler con Hotel: "
		};
		for(int i = 0; i< alquiler.length; i++) {
			alquiler[i] = new Label(txtAlquileres[i]+ alquileres.get(i).getValor());
			alquiler[i].setFont(Font.font("Consolas", FontWeight.BOLD, 14));
			alquiler[i].setDisable(!(i == getCantidadDeEdificios()));
		}
		
		panelInfo.getChildren().addAll(nombre, duenio, precioTerreno, precioCasaTxt, precioHotelTxt,new Separator(Orientation.HORIZONTAL), alquiler[0],alquiler[1],alquiler[2],alquiler[3]);
		return panelInfo;
	}
}
