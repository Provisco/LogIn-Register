package loginAndRegister.Controller;

import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import loginAndRegister.Model.User;
import loginAndRegister.Model.UserService;
import loginAndRegister.Navigator;
import java.net.URL;
import java.util.ResourceBundle;


public class LoginController implements Initializable {


    UserService userService;


    @FXML
    private Pane background;

    @FXML
    private Label codecadet;

    @FXML
    private Label password;

    @FXML
    private TextField codecadetinput;

    @FXML
    private TextField passwordinput;

    @FXML
    private Button loginbutton;

    @FXML
    private ImageView logo;

    @FXML
    private Hyperlink registerMode;

    @FXML
    private Label statusText;

    @FXML
    private Label email;

    @FXML
    private TextField emailinput;

    @FXML
    private Button registernow;

    @FXML
    private Label counterText;

    @FXML
    private Button goback;



    @FXML
    public void logInClick() {

        if (userService.authenticate(codecadetinput.getText(), passwordinput.getText())) {
            System.out.println("Login successful");
            statusText.setText("Login successful");

            Navigator.getInstance().loadScreen("PersonalSpace");
        } else {
            System.out.println("username or password incorrect");
            statusText.setText("Wrong credentials, try again");
        }


        System.out.println(codecadetinput.getText());
    }

    @FXML
    public void register() {

        registerMode.setVisible(false);
        loginbutton.setVisible(false);
        emailinput.setVisible(true);
        email.setVisible(true);
        emailinput.setVisible(true);
        registernow.setVisible(true);
        counterText.setVisible(true);
        goback.setVisible(true);
        statusText.setVisible(true);

    }



    public void registerNow(){


        //password must contain: >=8chars, 1 nmb, 1[a-z], 1[A-Z], 1wierdchar
        String pwRegex = "^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$";
        //email must contain:
        String emailRegex = "^[_A-Za-z0-9-]+(\\\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\\\.[A-Za-z0-9-]+)*(\\\\.[A-Za-z]{2,})$";


        //Isto nao esta a funcionar
        if (codecadetinput.getText() == "" || passwordinput.getText() == "" || emailinput.getText() == "") {
            statusText.setId("You can't leave any spaces in blank");
        }
        if (userService.findByName(codecadetinput.getText()) != null) {
            statusText.setText("Username already in use");
        }
        if (!passwordinput.getText().matches(pwRegex)) {
            statusText.setText("Password type does not meet requirements");
        }
        if (!emailinput.getText().matches(emailRegex)) {
            statusText.setText("Email type does not meet requirements");
        }
        if (userService.addUser(new User(codecadetinput.getText(), passwordinput.getText(), emailinput.getText()))) {
            statusText.setText("Registration complete");
            counterText.setText(String.valueOf(userService.count()) + " codecadets have joined");
        }


    }


    @FXML
    public void goBack() {

        registerMode.setVisible(true);
        loginbutton.setVisible(true);
        emailinput.setVisible(false);
        email.setVisible(false);
        emailinput.setVisible(false);
        registernow.setVisible(false);
        counterText.setVisible(false);
        goback.setVisible(false);
        statusText.setVisible(true);

    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}


