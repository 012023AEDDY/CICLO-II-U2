package pe.edu.upeu.tictactoe;

import atlantafx.base.theme.PrimerLight;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.BootstrapFX;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class TicTacToeApplication extends Application {
	ConfigurableApplicationContext configurableApplicationContext;
		Parent parent;
	public static void main(String[] args) {
		System.out.println("stats okey");
		launch(args);

		//SpringApplication.run(TicTacToeApplication.class, args);
	}
	@Override
	public void init() throws Exception {
		SpringApplicationBuilder builder = new
				SpringApplicationBuilder(TicTacToeApplication.class);

		builder.application().setWebApplicationType(WebApplicationType.NONE);
		configurableApplicationContext =
				builder.run(getParameters().getRaw().toArray(new String[0]));
		FXMLLoader fxmlLoader = new
				FXMLLoader(getClass().getResource("/fxml/tictac.fxml"));

		fxmlLoader.setControllerFactory(configurableApplicationContext::getBean);
		parent= fxmlLoader.load();
	}
//todo este codigo antes de ejecutar el codigo


	@Override
	public void start(Stage stage) throws Exception {
		Scene scene = new Scene(parent);//este parent el diseño de nuestra pntalla
		// Obtener el tamaño preferido del contenido
		double preferredWidth = parent.prefWidth(-1); // -1 significa queno se restringe el cálculo
		double preferredHeight = parent.prefHeight(-1);
		// Configurar el tamaño mínimo basado en el tamaño preferido
		stage.setMinWidth(preferredWidth);
		stage.setMinHeight(preferredHeight);
		//todo este codigo de arriba es tamaño de la venta de nuestro juego

		//y este abajo le da el estilo a nuestro juego
		Application.setUserAgentStylesheet(new
				PrimerLight().getUserAgentStylesheet());
		//scene.getStylesheets().add(getClass().getResource("/css/bootstrap3.css").toExternalForm());
		scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
		stage.setScene (scene);
		stage.setTitle("Spring Java-FX");
		stage.show();

	//esta clase es fijo para cada proyecto
	}
}
