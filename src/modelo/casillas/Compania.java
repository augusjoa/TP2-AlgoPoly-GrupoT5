package modelo.casillas;

import javafx.geometry.Orientation;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import modelo.Dinero;
import modelo.Jugador;
import modelo.interfaces.Adquirible;
import modelo.interfaces.Visitable;

public abstract class Compania implements Adquirible,Visitable {

	private Jugador duenio = null;
	protected Dinero costoDeLaCompania;
	protected int vecesQueCobra;
	protected int vecesQueCobraDoble;
	private Compania otraCompania;
	protected String nombre;
	
	
	public boolean tieneDuenioDoble(){
		if(duenio == null) return false;
		return  duenio.esDuenio(this)  && duenio.esDuenio(otraCompania);
	}
	
	public boolean tieneDuenio(){
		return duenio!=null;
	}
	
	public void cobrarAlquiler(int precio,Jugador unJugador){
		Dinero valorASustraerDoble = new Dinero(precio * unJugador.getNumeroDelDado());
		unJugador.sustraerDinero(valorASustraerDoble);
		duenio.agregarDinero(valorASustraerDoble);
	
	}
	
	public void setOtraCompania(Compania unaCompania){
		otraCompania = unaCompania;
	}
	
	@Override
	public Jugador getDuenio() {
		return duenio;
	}

	@Override
	public Dinero getPrecio() {
		return costoDeLaCompania;
	}

	@Override
	public void setDuenio(Jugador unJugador) {
		duenio = unJugador;
	}
	
	@Override
	public void esVisitadoPorJugador(Jugador unJugador) {
		
		if(tieneDuenio() && tieneDuenioDoble()){
			cobrarAlquiler(vecesQueCobraDoble,unJugador);
		}
		
		else if(!unJugador.esDuenio(this) && tieneDuenio()){
			cobrarAlquiler(vecesQueCobra,unJugador);
		}
	}
	
	@Override
	public void comprar(Jugador unJugador){
		if(!tieneDuenio()){
			unJugador.sustraerDinero(costoDeLaCompania);
			setDuenio(unJugador);
		}
		//catch jugador perdio?
	}
	
	@Override
	public void vender(Jugador unJugador){
		if(unJugador.esDuenio(this)){
			Dinero costoConRetencion = new Dinero(costoDeLaCompania);
			costoConRetencion.aplicarImpuesto(porcentajeRetencionDeVenta);
			unJugador.agregarDinero(costoConRetencion);
			duenio=null;
		}	
	}
	
	@Override
	public VBox loadPanelInfo(VBox panelInfo) {
		
		Label nombre = new Label("Nombre: " + this.nombre);
		nombre.setFont(Font.font("Consolas", FontWeight.BOLD, 14));
		
		Label costoDeLaCompania = new Label("Precio: "+Integer.toString(this.costoDeLaCompania.getValor()));
		costoDeLaCompania.setFont(Font.font("Consolas", FontWeight.BOLD, 14));
		costoDeLaCompania.setWrapText(true);
		
		Label lduenio = new Label();
		if(this.getDuenio()==null){
			lduenio.setText("Duenio: Sin Duenio");
		}
		else{
			lduenio.setText("Duenio: "+Integer.toString(this.getDuenio().getNumeroDelDado()));
		}
		lduenio.setFont(Font.font("Consolas", FontWeight.BOLD, 14));
		lduenio.setWrapText(true);
		
		Label cobro = new Label("Cobra: "+Integer.toString(this.vecesQueCobra)+" x numero del dado.");
		cobro.setFont(Font.font("Consolas", FontWeight.NORMAL, 14));
		cobro.setWrapText(true);
		
		Label cobroDoble = new Label("Si el Jugador también posee " + otraCompania.getNombre()+ " se cobra: " + Integer.toString(this.vecesQueCobraDoble)+" x numero del dado.");
		cobroDoble.setFont(Font.font("Consolas", FontWeight.NORMAL, 14));
		cobroDoble.setWrapText(true);
		
		panelInfo.getChildren().addAll(nombre,lduenio,costoDeLaCompania,new Separator(Orientation.HORIZONTAL),cobro,cobroDoble);
		return panelInfo;
	}
	
}
