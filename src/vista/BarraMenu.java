package vista;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.stage.Stage;
import vista.eventos.MostrarReglasOnAction;

public class BarraMenu extends MenuBar{

	public BarraMenu(Stage stage, Juego juego) {

        Menu menuSonido = new Menu("Sonido");
        Menu menuAyuda = new Menu("Ayuda");
        
        MenuItem opcionMutearSonido = new MenuItem("Mutear Sonido");
        MenuItem opcionReglas = new MenuItem("Reglas de Juego");
        MenuItem opcionAcercaDe = new MenuItem("Acerda de");
        
        opcionReglas.setOnAction(new MostrarReglasOnAction());        
        
        menuSonido.getItems().add(opcionMutearSonido);
        menuAyuda.getItems().addAll(opcionReglas,new SeparatorMenuItem(),opcionAcercaDe);
        
        this.getMenus().addAll(menuSonido,menuAyuda);
	}

}
