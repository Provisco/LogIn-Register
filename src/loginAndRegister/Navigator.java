package loginAndRegister;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by codecadet on 16/11/16.
 */
public final class Navigator {

    private LinkedList<Scene> scenes = new LinkedList<>();
    private Map<String, Initializable> controllers = new HashMap<>();
    private Stage stage;
    private FXMLLoader fxmlLoader;
    private Parent root;
    private final String VIEW_PATH = "/loginAndRegister/view";
    private static Navigator instance;


    private Navigator() {
        stage = new Stage();
    }

    public static synchronized Navigator getInstance() {
        if (instance == null) {
            instance = new Navigator();
        }
        return instance;
    }


    public void loadScreen(String view) {


        try {
            fxmlLoader = new FXMLLoader(getClass().getResource(VIEW_PATH + "/" + view + ".fxml"));
            root = fxmlLoader.load();

            controllers.put(view, fxmlLoader.getController());


            Scene scene = new Scene(root);
            scenes.push(scene);

            setScene(scene);

        } catch (IOException e) {
            System.out.println("Failure to load loginAndRegister.view " + view + " : " + e.getMessage());
        }

    }

    public void setScene(Scene scene) {

        stage.setScene(scene);

        stage.show();

    }

    public void back() {

        if (scenes.isEmpty()) {
            return;
        }

        scenes.pop();

        setScene(scenes.peek());
    }

    public Initializable getController(String view){return controllers.get(view);
    }


    public int controllerSize(){
        return controllers.size();
    }




    public void emptyHistory(){
        scenes.removeAll(scenes);
    }

    public LinkedList<Scene> getScenes(){
        return scenes;
    }


}
