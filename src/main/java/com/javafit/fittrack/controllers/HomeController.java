public class HomeController {
    @FXML
    private Label welcomeLabel;

    public void initialize(User user) {
        welcomeLabel.setText("Good Morning, " + user.getUsername() + "!");
    }
}