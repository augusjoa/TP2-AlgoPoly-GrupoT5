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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class VistaReglas extends ScrollPane {

	public VistaReglas(){
		
		this.setPadding(new Insets(10));
		
		Label titulo = new Label("Reglas de Juego");
		titulo.setFont(Font.font("Consolas", FontWeight.BOLD, 20));
		Label reglas = new Label();
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
		
		VBox vBox = new VBox();
		vBox.getChildren().addAll(titulo,reglas);
		
		this.setContent(vBox);
		this.setHbarPolicy(ScrollBarPolicy.NEVER);
		this.setVbarPolicy(ScrollBarPolicy.ALWAYS);
	}
	
}
