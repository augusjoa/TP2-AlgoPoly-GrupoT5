package vista.eventos;

import javafx.event.EventHandler;
import javafx.stage.WindowEvent;

public class SalirEventoWindow implements EventHandler<WindowEvent> {

	@Override
	public void handle(WindowEvent event) {
		new SalirEventoOnAction().handle(null);
		
    	event.consume();
    
	}
	
}
