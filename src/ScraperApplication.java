import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class ScraperApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader (getClass().getResource("application.fxml"));
        ScraperApplication_controller controller= new ScraperApplication_controller();
        loader.setController(controller);

        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        stage.setTitle("Web Scrapping");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args){
        Application.launch(args);
    }
    
}