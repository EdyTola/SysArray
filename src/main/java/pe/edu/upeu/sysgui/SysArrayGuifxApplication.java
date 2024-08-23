package pe.edu.upeu.sysgui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SysArraysGuifxApplication extends Application {
	private static ConfigurableApplicationContext
			configurableApplicationContext;
	private Parent parent;
	public static void main(String[] args) {
		//SpringApplication.run(SysArraysGuifxApplication.class, args);
		launch(args);
	}

	private static void launch(String[] args) {
	}

	@Override
	public void init() throws Exception {
		SpringApplicationBuilder builder = new
				SpringApplicationBuilder(SysArraysGuifxApplication.class);

		builder.application().setWebApplicationType(WebApplicationType.NONE);
		configurableApplicationContext =
				builder.run(getParameters().getRaw().toArray(new String[0]));
		FXMLLoader fxmlLoader = new
				FXMLLoader(getClass().getResource("/fxml/mainfx.fxml"));

		fxmlLoader.setControllerFactory(configurableApplicationContext::getBean);
		parent= fxmlLoader.load();
	}
}
