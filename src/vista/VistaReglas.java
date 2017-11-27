package vista;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class VistaReglas extends ScrollPane {

	public VistaReglas(){
		
		this.setPadding(new Insets(10));
		
		Label label = new Label("Reglas del Juego");
		label.getStyleClass().add("titulo");
		
		
		Label reglas = new Label();
		reglas.getStyleClass().add("texto");
		reglas.setWrapText(true);
		reglas.setMaxWidth(770);
		
		Path path = null;
		try {
			path = Paths.get(getClass().getResource("txt/reglasDeJuego.txt").toURI());
		} catch (URISyntaxException e1) {
			e1.printStackTrace();
		}
		try {
			Files.lines(path, StandardCharsets.ISO_8859_1).forEach(v->{
				reglas.setText(reglas.getText() + "\n" + v);
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		reglas.getStyleClass().add("titulo");
		VBox vBox = new VBox();
		vBox.getChildren().addAll(label,reglas);
		
		this.setContent(vBox);
		this.setHbarPolicy(ScrollBarPolicy.NEVER);
		this.setVbarPolicy(ScrollBarPolicy.ALWAYS);
	}
	
}
