package loginAndRegister.Controller;

/**
 * Created by codecadet on 17/11/16.
 */

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import loginAndRegister.Model.UserService;
import loginAndRegister.Navigator;


public class ChangeCredentialsController {


    private UserService userService;

    @FXML
    private ToggleButton backbuttonchangecredentials;

    @FXML
    private TextField usernameinput;

    @FXML
    private Button changeusernamebutton;

    @FXML
    private TextField passwordinput;

    @FXML
    private Button changepasswordbutton;

    @FXML
    private TextField email;

    @FXML
    private Button changeemailbutton;


    @FXML
    public void goBack() {
        Navigator.getInstance().back();
    }

    @FXML
    public void changeEmail() {

    }

    @FXML
    public void changePassword() {

    }

    @FXML
    public void changeUsername() {

    }
/*
    public void setUserService(UserService userService){
        this.userService = userService;
    }
*/
}
