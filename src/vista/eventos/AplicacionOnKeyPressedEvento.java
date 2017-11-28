package vista.eventos;

import vista.BarraMenu;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class AplicacionOnKeyPressedEvento implements EventHandler<KeyEvent> {

    private BarraMenu menuBar;

    public AplicacionOnKeyPressedEvento(BarraMenu menuBar) {
        this.menuBar = menuBar;
    }

    @Override
    public void handle(KeyEvent event) {
        if (event.getCode() == KeyCode.ESCAPE) {
            menuBar.aplicarCambiarBoton();
        }
    }
}
