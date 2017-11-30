package modelo.casillas;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import modelo.Dinero;


public class Aysa extends Compania {
	
	private String nombre = "Aysa";
	
	public Aysa(){
		costoDeLaCompania= new Dinero(30000);
		vecesQueCobra=300;
		vecesQueCobraDoble=500;
	}

	@Override
	public String getNombre(){
		return nombre;
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
		
		Label cobroDoble = new Label("Cobro con ambas companias de servicio: "+Integer.toString(this.vecesQueCobraDoble)+" x numero del dado.");
		cobroDoble.setFont(Font.font("Consolas", FontWeight.NORMAL, 14));
		cobroDoble.setWrapText(true);
		
		panelInfo.getChildren().addAll(nombre,lduenio,costoDeLaCompania,cobro,cobroDoble);
		return panelInfo;
	}
	
}
