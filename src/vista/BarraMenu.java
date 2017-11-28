package vista;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.stage.Stage;
import vista.eventos.CambiarAPantallacompletaOnAction;
import vista.eventos.MostrarReglasOnAction;
import vista.eventos.MutearOnAction;
import vista.eventos.SalirEventoOnAction;

public class BarraMenu extends MenuBar{

	MenuItem opcionPantallaCompleta;
	Stage stage;
	
	public BarraMenu(Stage stage, Juego juego) {
		
		this.stage = stage;
		
        Menu menuOpciones = new Menu("Opciones");
        Menu menuAyuda = new Menu("Ayuda");
        Menu menuJuego = new Menu("Juego");
        
        MenuItem opcionMutearSonido = new MenuItem("Mutear Sonido");
        opcionMutearSonido.setOnAction(new MutearOnAction(stage));	//supongo que hacia falta la ventana completa para decir que no hay sonido.
        
        opcionPantallaCompleta = new MenuItem("Pantalla Completa");
        opcionPantallaCompleta.setOnAction(new CambiarAPantallacompletaOnAction(stage , opcionPantallaCompleta));
        
        MenuItem opcionReglas = new MenuItem("Reglas de Juego");
        opcionReglas.setOnAction(new MostrarReglasOnAction());
       
        MenuItem opcionAcercaDe = new MenuItem("Acerda de");
        MenuItem opcionNuevoJuego = new MenuItem("Juego Nuevo");
        
        MenuItem opcionSalir = new MenuItem("Salir");
        opcionSalir.setOnAction(new SalirEventoOnAction());
        
                
        menuOpciones.getItems().addAll(opcionMutearSonido, new SeparatorMenuItem(), opcionPantallaCompleta);
        menuAyuda.getItems().addAll(opcionReglas,new SeparatorMenuItem(),opcionAcercaDe);
        menuJuego.getItems().addAll(opcionNuevoJuego,new SeparatorMenuItem(), opcionSalir );
        
        this.getMenus().addAll(menuJuego,menuOpciones,menuAyuda);
	}

	public void aplicarCambiarBoton(){
		opcionPantallaCompleta.setText("Pantalla Completa");
		opcionPantallaCompleta.setOnAction(new CambiarAPantallacompletaOnAction(stage , opcionPantallaCompleta));
	}
	
}
