package edu.orangecoastcollege.cs272.ic13.view;

import edu.orangecoastcollege.cs272.ic13.controller.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class SignUpScene
{
    private static Controller controller = Controller.getInstance();
    @FXML
    private TextField emailAddressTF;
    @FXML
    private Label emailErrorLabel;
    @FXML
    private TextField passwordTF;
    @FXML
    private Label passwordErrorLabel;
    @FXML
    private Label signUpErrorLabel;
    @FXML
    private TextField nameTF;
    @FXML
    private Label nameErrorLabel;

    public void loadSignIn(MouseEvent e)
    {
        ViewNavigator.loadScene("Sign In", ViewNavigator.SIGN_IN_SCENE);
    }

    public boolean signUp()
    {
        String email = emailAddressTF.getText();
        String password = passwordTF.getText();
        String name = nameTF.getText();

        emailErrorLabel.setVisible(email.isEmpty());
        passwordErrorLabel.setVisible(password.isEmpty());
        nameErrorLabel.setVisible(name.isEmpty());

        if (emailErrorLabel.isVisible() || passwordErrorLabel.isVisible() || nameErrorLabel.isVisible())
            return false;

        String result = controller.signUpUser(name, email, password);

        if (result.equals("SUCCESS"))
        {
            signUpErrorLabel.setVisible(false);
            ViewNavigator.loadScene("Video Game List", ViewNavigator.VIDEO_GAME_LIST_SCENE);
            return true;
        }

        signUpErrorLabel.setText(result);
        signUpErrorLabel.setVisible(true);

        return false;
    }
}
