package loginAndRegister;

import loginAndRegister.Controller.LoginController;
import loginAndRegister.Model.MockUserService;
import loginAndRegister.Model.User;
import loginAndRegister.Model.UserService;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() throws IOException {



        //Wire controller to the service
        //LoginController loginController = fxmlLoader.getController();
        //loginController.setUserService(userService);



    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        //Add a test user
        UserService userService = new MockUserService();
        User userTester = new User("Name", "123123", "name@name.com");
        userService.addUser(new User("Name", "123123", "name@name.com"));//para testar se existe
        new User("01", "10", "10");



        //estou a instanciar todos os controlers e todas as scenes
        Navigator.getInstance().loadScreen("LogIn");
        Navigator.getInstance().loadScreen("PersonalSpace");
        Navigator.getInstance().loadScreen("ChangeCredentials");
        //chamar aqui um metodo para limpar o historico das scenes ou containers;
       // Navigator.getInstance().emptyHistory();

        LoginController loginController = (LoginController) Navigator.getInstance().getController("LogIn");
        loginController.setUserService(userService);

        LoginController loginController1 = (LoginController) Navigator.getInstance().getController("PersonalSpace");
        loginController1.setUserService(userService);

        LoginController loginController2 = (LoginController) Navigator.getInstance().getController("ChangeCredentials");
        loginController2.setUserService(userService);



    }

}