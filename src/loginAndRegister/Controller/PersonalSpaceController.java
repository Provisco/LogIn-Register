package loginAndRegister.Controller;

/**
 * Created by codecadet on 16/11/16.
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;
import loginAndRegister.Model.UserService;
import loginAndRegister.Navigator;

public class PersonalSpaceController {

    UserService userService;

    @FXML
    private TitledPane PersonalSpace;

    @FXML
    private AnchorPane PersonalData;

    @FXML
    private ToggleButton backbutton;

    @FXML
    private Button changecredentials;

    @FXML
    public void goBack() {
        /*
        if(Navigator.getInstance().controllerSize() == 0){
            return;
        }
        else{*/
        Navigator.getInstance().back();
        // }
    }

    @FXML
    public void changeCredentials() {

        Navigator.getInstance().loadScreen("ChangeCredentials");

       // ((ChangeCredentialsController) Navigator.getInstance().getController("ChangeCredentials")).setUserService(userService);

    }

    /*
    public void setUserService(UserService userService){
        this.userService = userService;
    }
*/


}
