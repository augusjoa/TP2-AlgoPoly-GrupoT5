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
import modelo.excepciones.BarrioLleno;

public class BarrioSimple extends Barrio {
	
	private int cantidadDeCasas = 0;
	private Dinero precioCasa;
    private Hashtable<Integer, Dinero> alquileres = new Hashtable<Integer, Dinero>();


	public BarrioSimple(int precioDelBarrio, int unprecioCasa, int alquilersincasa, int alquilerconcasa, String unNombre) {
		
		valorDelBarrio = new Dinero(precioDelBarrio);
		nombre=unNombre;
		precioCasa = new Dinero(unprecioCasa);
		alquileres.put(0, new Dinero (alquilersincasa));
		alquileres.put(1, new Dinero (alquilerconcasa));
	}
	
	
	public int getCantidadDeEdificios() {
		return cantidadDeCasas;
	}
	
	public void agregarCasa(Jugador unJugador) {
		verificarJugador(unJugador);
		verificarLimiteDeCasas();
		jugadorDuenio.getDinero().sustraerDinero(precioCasa);
		valorDelBarrio.agregarDinero(precioCasa);
		cantidadDeCasas ++;
	}

	private void verificarLimiteDeCasas() throws BarrioLleno{
		if(cantidadDeCasas > 0)	throw new BarrioLleno();
	}
	
	public void destruirEdificios() {
		if(cantidadDeCasas!=0){
			valorDelBarrio.sustraerDinero(precioCasa);
			cantidadDeCasas = 0;
		}
	}

	@Override
	public void cobrarAlquilerA(Jugador unJugador) {
		Dinero alquiler = alquileres.get(cantidadDeCasas);
		unJugador.getDinero().sustraerDinero(alquiler);
		jugadorDuenio.getDinero().agregarDinero(alquiler);
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
		
		Label alquiler[];
		alquiler = new Label[2];
		String txtAlquileres[] = new String[] {
			"Alquiler: ",
			"Alquiler con una casa: "
		};
		for(int i = 0; i< alquiler.length; i++) {
			alquiler[i] = new Label(txtAlquileres[i]+ alquileres.get(i).getValor());
			alquiler[i].setFont(Font.font("Consolas", FontWeight.BOLD, 14));
			alquiler[i].setDisable(!(i == getCantidadDeEdificios()));
		}
		
		panelInfo.getChildren().addAll(nombre, duenio, precioTerreno, precioCasaTxt,new Separator(Orientation.HORIZONTAL), alquiler[0],alquiler[1]);
		return panelInfo;
	}
}
