package edu.orangecoastcollege.cs272.ic13.view;

import edu.orangecoastcollege.cs272.ic13.controller.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class SignInScene
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
    private Label signInErrorLabel;


    public void loadSignUp(MouseEvent e)
    {
        ViewNavigator.loadScene("Sign Up", ViewNavigator.SIGN_UP_SCENE);
    }

    public boolean signIn()
    {
        String email = emailAddressTF.getText();
        String password = passwordTF.getText();

        emailErrorLabel.setVisible(email.isEmpty());
        passwordErrorLabel.setVisible(password.isEmpty());

        if (emailErrorLabel.isVisible() || passwordErrorLabel.isVisible())
            return false;

        String result = controller.signInUser(email, password);

        if (result.equals("SUCCESS"))
        {
            signInErrorLabel.setVisible(false);
            ViewNavigator.loadScene("Video Game List", ViewNavigator.VIDEO_GAME_LIST_SCENE);
            return true;
        }

        signInErrorLabel.setText(result);
        signInErrorLabel.setVisible(true);

        return false;
    }

}
