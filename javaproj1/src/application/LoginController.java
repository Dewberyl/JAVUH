package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.io.IOException; // Para sa parent root switching of scenes
import javafx.event.ActionEvent;
import javafx.scene.Node; // For switching of scenes AAAAA
import javafx.application.Platform;
import javafx.scene.input.MouseEvent; // Para sa exit
import javafx.animation.FadeTransition;
import javafx.scene.text.Text;
import javafx.util.Duration; // Para sa transition when switching between login and signup pages.


/* Unused imports
 
* Para sa ibang transition sana
import javafx.animation.TranslateTransition;
import java.lang.invoke.MethodHandles.Lookup; -- Idunno what this was for. LOL. Sa fade transit din yata *

* For the ChoiceBox sana...
import javafx.scene.control.ChoiceBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

* For the DialogPane na tinanggal ko...
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;						
 										*/

public class LoginController {
	
	// For the stages and stuff
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	// ImageViews
	
	@FXML
	private ImageView myaboutImageView;
	
	@FXML
	private ImageView myhomeImageView;
	
	@FXML
	private ImageView myliBgImageView;
	
	@FXML
	private ImageView mysuBgImageView;
	
	@FXML
	private ImageView myresetpassImageView;
	
	// Login page
	
	@FXML
	private PasswordField myloginPasswordField;
	
	@FXML
	private Button myLoginButton;
	
	@FXML
	private Button mytologinButton;
	
	@FXML
	private TextField myloginTextField;
	
	@FXML
	private Button myforgotpassButton;
	
	@FXML
	private Button mytosignupButton;
	
	// Sign up page
	
	@FXML
	private PasswordField mysuPasswordField;
	
	@FXML
	private TextField mysuTextField;
	
	@FXML
	private TextField myanswerTextField;
	
	@FXML
	private Button mysignupButton;
	
	@FXML
	private ChoiceBox<String> myquestionChoiceBox; /* pwede ibahin string(?) */
	
	// Reset pass page
	
	@FXML
	private String[] securityQuestions = {"Three words that you live by",
            "What was the first hobby you learned?",
            "What was the name of your first favorite cartoon/movie character?"};
	
	@FXML
	private TextField myresetTextField;
	
	@FXML
	private PasswordField myresetPasswordField;
	
	@FXML
	private ChoiceBox<String> myresetquestionChoiceBox;
	
	@FXML
	private TextField myresetanswerTextField;
	
	@FXML
	private Button myresetButton;
	
	// Home page
	
	@FXML
	private Label myplpLabel;
	
	@FXML
	private Label mygstitleLabel;
	
	@FXML
	private Button mytoaboutButton;
	
	@FXML
	private Button mytohomeButton;
	
	// About us page
	
	@FXML
	private Label myaboutusLabel;
	
	@FXML
	private Label myaboutusLabel2;
	
	@FXML
	private Text myaboutusText;
	
	@FXML
	private Text myaboutusText2;
	
	@FXML
	private Text myaboutusText3;
	
	@FXML
	private Text myaboutusText4;
	
	/* @FXML
	private Text myaboutusText2;
	
	@FXML
	private Text myaboutustitleText;
	
	@FXML
	private Text myabouttitleshadowText;
	
	@FXML
	private Text myaboutshadowText;
	
	@FXML
	private Text myaboutshadowText2; */
	
	// Others
	
	@FXML
	private Button myexitButton;
		
	@FXML
	private Button myminimizeButton;
	
	//...................................................................................................... //

	public void swtichToLogin(ActionEvent event) throws IOException {
	    FXMLLoader loader = new FXMLLoader(getClass().getResource("Login_system.fxml"));
	    Parent root = loader.load();
	    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	    scene = new Scene(root);

	    // Nilagay ko muna references to the nodes na gusto ko lagyan ng fading transition.
	    TextField loginusernameField = (TextField) root.lookup("#myloginTextField");
	    PasswordField loginpasswordField = (PasswordField) root.lookup("#myloginPasswordField");
	    Button loginButton = (Button) root.lookup("#myLoginButton");
	    Button resetpassButton = (Button) root.lookup("#myforgotpassButton");

	    // Then saka ako nag-create ng fade transitions for each node below...
	    FadeTransition loginusernameFade = new FadeTransition(Duration.millis(900), loginusernameField);
	    loginusernameFade.setFromValue(0.0);
	    loginusernameFade.setToValue(1.0);

	    FadeTransition loginpasswordFade = new FadeTransition(Duration.millis(900), loginpasswordField);
	    loginpasswordFade.setFromValue(0.0);
	    loginpasswordFade.setToValue(1.0);

	    FadeTransition loginbuttonFade = new FadeTransition(Duration.millis(900), loginButton);
	    loginbuttonFade.setFromValue(0.0);
	    loginbuttonFade.setToValue(1.0);
	    
	    FadeTransition resetbuttonFade = new FadeTransition(Duration.millis(900), resetpassButton);
	    resetbuttonFade.setFromValue(0.0);
	    resetbuttonFade.setToValue(1.0);

	    // Then here naman ay para ma-play lahat ng fade transitions. If wala itong mga 'to, then hindi gagana ang transition.
	    loginusernameFade.play();
	    loginpasswordFade.play();
	    loginbuttonFade.play();
	    resetbuttonFade.play();

	    stage.setScene(scene);
	}
	
	//...................................................................................................... //

	public void swtichToSignUp(ActionEvent event) throws IOException {
	    FXMLLoader loader = new FXMLLoader(getClass().getResource("Signup_system.fxml"));
	    Parent root = loader.load();
	    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	    scene = new Scene(root);

	    // Same processes lang doon sa isa para naman sa Sign Up page.
	    
	    TextField usernameField = (TextField) root.lookup("#mysuTextField");
	    PasswordField passwordField = (PasswordField) root.lookup("#mysuPasswordField");
	    Button signupButton = (Button) root.lookup("#mysignupButton");
	    TextField answerField = (TextField) root.lookup("#myanswerTextField");
	    ChoiceBox<String> questionChoiceBox = (ChoiceBox<String>) root.lookup("#myquestionChoiceBox");

	    FadeTransition usernameFade = new FadeTransition(Duration.millis(900), usernameField);
	    usernameFade.setFromValue(0.0);
	    usernameFade.setToValue(1.0);

	    FadeTransition passwordFade = new FadeTransition(Duration.millis(900), passwordField);
	    passwordFade.setFromValue(0.0);
	    passwordFade.setToValue(1.0);

	    FadeTransition buttonFade = new FadeTransition(Duration.millis(900), signupButton);
	    buttonFade.setFromValue(0.0);
	    buttonFade.setToValue(1.0);
	    
	    FadeTransition answerFade = new FadeTransition(Duration.millis(900), answerField);
	    answerFade.setFromValue(0.0);
	    answerFade.setToValue(1.0);
	    
	    FadeTransition choiceBoxFade = new FadeTransition(Duration.millis(900), questionChoiceBox);
	    choiceBoxFade.setFromValue(0.0);
	    choiceBoxFade.setToValue(1.0);

	    usernameFade.play();
	    passwordFade.play();
	    buttonFade.play();
	    answerFade.play();
	    choiceBoxFade.play();

	    stage.setScene(scene);
	}
	
	//...................................................................................................... //
	
	public void switchToResetpass (ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Resetpass_system.fxml"));
	    Parent root = loader.load();
	    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	    scene = new Scene(root);

		    // Then here, para naman sa "Forgot your password?" page.
		    
	    TextField resetusernameField = (TextField) root.lookup("#myresetTextField");
	    PasswordField resetpasswordField = (PasswordField) root.lookup("#myresetPasswordField");
	    Button resetButton = (Button) root.lookup("#myresetButton");
	    TextField resetanswerField = (TextField) root.lookup("#myresetanswerTextField");
	    ChoiceBox<String> resetquestionChoiceBox = (ChoiceBox<String>) root.lookup("#myresetquestionChoiceBox");

	    FadeTransition resetusernameFade = new FadeTransition(Duration.millis(900), resetusernameField);
	    resetusernameFade.setFromValue(0.0);
	    resetusernameFade.setToValue(1.0);

	    FadeTransition resetpasswordFade = new FadeTransition(Duration.millis(900), resetpasswordField);
	    resetpasswordFade.setFromValue(0.0);
	    resetpasswordFade.setToValue(1.0);

	    FadeTransition resetbuttonFade = new FadeTransition(Duration.millis(900), resetButton);
	    resetbuttonFade.setFromValue(0.0);
	    resetbuttonFade.setToValue(1.0);
		    
	    FadeTransition resetanswerFade = new FadeTransition(Duration.millis(900), resetanswerField);
	    resetanswerFade.setFromValue(0.0);
	    resetanswerFade.setToValue(1.0);
		    
	    FadeTransition resetchoiceBoxFade = new FadeTransition(Duration.millis(500), resetquestionChoiceBox);
	    resetchoiceBoxFade.setFromValue(0.0);
	    resetchoiceBoxFade.setToValue(1.0);

	    resetusernameFade.play();
	    resetpasswordFade.play();
	    resetbuttonFade.play();
	    resetanswerFade.play();
	    resetchoiceBoxFade.play();
		    
	    stage.setScene(scene); // 'Wag itong kakalimutan kasi hindi maglilipat ang scene if wala nito.
	}
	
	//...................................................................................................... //
	
	public void switchToHome (ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Home_page.fxml"));
	    Parent root = loader.load();
	    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	    scene = new Scene(root);
		    
	    Label gsField = (Label) root.lookup("#mygstitleLabel");
	    Label plpField = (Label) root.lookup("#myplpLabel");
	    Button tologinButton = (Button) root.lookup("#mytologinButton");

	    FadeTransition resetusernameFade = new FadeTransition(Duration.millis(500), gsField);
	    resetusernameFade.setFromValue(0.0);
	    resetusernameFade.setToValue(1.0);

	    FadeTransition resetpasswordFade = new FadeTransition(Duration.millis(500), plpField);
	    resetpasswordFade.setFromValue(0.0);
	    resetpasswordFade.setToValue(1.0);

	    FadeTransition tologinbuttonFade = new FadeTransition(Duration.millis(700), tologinButton);
	    tologinbuttonFade.setFromValue(0.0);
	    tologinbuttonFade.setToValue(1.0);

	    resetusernameFade.play();
	    resetpasswordFade.play();
	    tologinbuttonFade.play();
		    
	    stage.setScene(scene);
	}
	
	//...................................................................................................... //
	
	public void switchToAbout (ActionEvent event) throws IOException {
	  	FXMLLoader loader = new FXMLLoader(getClass().getResource("Aboutus_page.fxml"));
	    Parent root = loader.load();
	    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();			    
	    scene = new Scene(root);
			    
		Text aboutText1 = (Text) root.lookup("#myaboutusText");
		Text aboutText2 = (Text) root.lookup("#myaboutusText2");
		Text aboutText3 = (Text) root.lookup("#myaboutusText3");
		Text aboutText4 = (Text) root.lookup("#myaboutusText4");
		Label about1Field = (Label) root.lookup("#myaboutusLabel");
		Label about2Field = (Label) root.lookup("#myaboutusLabel2");
		
		FadeTransition aboutFade1 = new FadeTransition(Duration.millis(900), aboutText1);
		aboutFade1.setFromValue(0.0);
		aboutFade1.setToValue(1.0);
	    
	    FadeTransition aboutFade2 = new FadeTransition(Duration.millis(900), aboutText2);
	    aboutFade2.setFromValue(0.0);
	    aboutFade2.setToValue(1.0);
	    
	    FadeTransition aboutFade3 = new FadeTransition(Duration.millis(900), aboutText3);
	    aboutFade3.setFromValue(0.0);
	    aboutFade3.setToValue(1.0);
	    
	    FadeTransition aboutFade4 = new FadeTransition(Duration.millis(900), aboutText4);
	    aboutFade4.setFromValue(0.0);
	    aboutFade4.setToValue(1.0);
	    
	    FadeTransition about1Fade = new FadeTransition(Duration.millis(900), about1Field);			    
	    about1Fade.setFromValue(0.0);
	    about1Fade.setToValue(1.0);
	    
	    FadeTransition about2Fade = new FadeTransition(Duration.millis(900), about2Field);			    
	    about2Fade.setFromValue(0.0);
	    about2Fade.setToValue(1.0);
	   
	    aboutFade1.play();
	    aboutFade2.play();
	    aboutFade3.play();
	    aboutFade4.play();
	    about1Fade.play();
	    about2Fade.play();
		
	    // Label about2Field = (Label) root.lookup("#myaboutusLabel");
		
		/*Text abouttitleButton = (Text) root.lookup("#myaboutustitleText");
		Text abouttitleshadowButton = (Text) root.lookup("#myabouttitleshadowText");
		Text aboutshadowField = (Text) root.lookup("#myaboutshadowText");
		Text about2shadowField = (Text) root.lookup("#myaboutshadowText2");

	    FadeTransition aboutFade = new FadeTransition(Duration.millis(500), aboutField);
	    aboutFade.setFromValue(0.0);
	    aboutFade.setToValue(1.0);
			
	    FadeTransition about2Fade = new FadeTransition(Duration.millis(500), about2Field);			    
	    about2Fade.setFromValue(0.0);
	    about2Fade.setToValue(1.0);

		FadeTransition abouttitleFade = new FadeTransition(Duration.millis(500), abouttitleButton);
		abouttitleFade.setFromValue(0.0);
		abouttitleFade.setToValue(1.0);
		
		FadeTransition abouttitleshadowFade = new FadeTransition(Duration.millis(500), abouttitleshadowButton);
		abouttitleshadowFade.setFromValue(0.0);
		abouttitleshadowFade.setToValue(1.0);
		
		FadeTransition aboutshadowFade = new FadeTransition(Duration.millis(500), aboutshadowField);
		aboutshadowFade.setFromValue(0.0);
		aboutshadowFade.setToValue(1.0);
		
		FadeTransition about2shadowFade = new FadeTransition(Duration.millis(500), about2shadowField);
		about2shadowFade.setFromValue(0.0);
		about2shadowFade.setToValue(1.0);

	    aboutFade.play();
	    about2Fade.play();
	    abouttitleFade.play();
	    abouttitleshadowFade.play();
	    aboutshadowFade.play();
	    about2shadowFade.play(); */
			    
	    stage.setScene(scene);
		}
	
	public void setStage(Stage stage) {
        this.stage = stage;
    }
	
	public void exitProgram(MouseEvent event) {
		Platform.exit();
	}
	
	public void minimizeProgram(MouseEvent event) {
	    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	    stage.setIconified(true);
	}
	
	//...................................................................................................... //
	
	// Password ChoiceBox
	
	// This is called to initialize the controller
		/*@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
			myChoiceBox.getItems().addAll(food);
			myChoiceBox.setOnAction(this::getFood);
			
			// :: is a reference operator to make a reference to a method and link that method to choice box
		}
		public void getFood(ActionEvent event) {
			String myFood = myChoiceBox.getValue();
			myLabel.setText(myFood);
		}*/
		
	
	
	//...................................................................................................... //
	
	
    /* COMMENTS
      
      
    *** Para sa DialogPane
	@FXML
    private void Login() {
        String username = myloginTextField.getText();
        String password = myloginPasswordField.getText();

        if ("Jamie".equals(username) && "Jamie".equals(password)) {
            Alert(Alert.AlertType.INFORMATION, "Login Success", "Welcome, " + username + "!");
        } else {
            Alert(Alert.AlertType.ERROR, "Login Error", "Invalid username or password.");
        }
    }

    private void Alert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);

        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add(getClass().getResource("application.css").toExternalForm()); // Assuming you have a CSS file named alert.css
        dialogPane.getStyleClass().add("my-alert");

        alert.showAndWait();
    }

	
    *** Trial and error ko for the minimize and maximize functions in a tab, LMAO.
    @FXML
    private void handleExit() {
        stage.close();
    }

    @FXML
    private void handleMinimize() {
        stage.setIconified(true);
    }

	
	*** Sinubukan ko yung choice box ayusin, LOL. Tinamad ako kasi mali-mali.
	@FXML
    private ChoiceBox<String> myquestionChoiceBox;

    public void initialize() {
        ObservableList<String> options = FXCollections.observableArrayList(
            "Three words that you live by",
            "What was the first hobby you learned?",
            "What was the name of your first favorite cartoon/movie character?"
        );
        myquestionChoiceBox.setItems(options);
    }
    
    
	
	
	*** Para sa fading transition when switching from one page to another; masakit sa mata, LOL.
	   	Isang buong page kasi ang may transition kapag ito ang gamit.
	public void swtichToLogin(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    scene = new Scene(root);

    FadeTransition fadeTransition = new FadeTransition(Duration.millis(500), root);
    fadeTransition.setFromValue(0.0);
    fadeTransition.setToValue(1.0);

    stage.setScene(scene);
    fadeTransition.play();
}


	public void swtichToSignUp(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("Signup.fxml"));
    	stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	scene = new Scene(root);

    	FadeTransition fadeTransition = new FadeTransition(Duration.millis(500), root);
    	fadeTransition.setFromValue(0.0);
    	fadeTransition.setToValue(1.0);

    	stage.setScene(scene);
    	fadeTransition.play();
    
}
	
	
	*** Original switching function without any transitions or effects.
	public void swtichToLogin (ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
		  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();

	}
	public void swtichToSignUp (ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Signup.fxml"));
		  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
	} 
	
	
	*** For the in-between letter spacing na hindi rin maganda.
	@FXML
	public void initialize() {
	    setLetterSpacing(mygstitleText, 2.0);
	}

	private void setLetterSpacing(Text text, double spacing) {
	    StringBuilder spacedText = new StringBuilder();
	    for (char c : text.getText().toCharArray()) {
	        spacedText.append(c).append("\u200A".repeat((int) spacing));
	    }
	    text.setText(spacedText.toString());
	}
	
	
	*** Experiment sa text
	@FXML
    public void initialize() {
        setLetterSpacing(myaboutusText2, "The Pamantasan ng Lungsod ng Pasig is the realization of our long cherished dream for all Pasigueños. Now, we can proudly claim that the Pasig City Government has provided for the complete education needs of its constituents – from day care to college.", 1);
        myaboutusText2.setTextAlignment(TextAlignment.CENTER);
	}

    private void setLetterSpacing(Text text, String content, int spacing) {
        if (text != null) {
            StringBuilder spacedText = new StringBuilder();
            for (char c : content.toCharArray()) {
                spacedText.append(c);
                for (int i = 0; i < spacing; i++) {
                    spacedText.append(" ");
                }
            }
            text.setText(spacedText.toString());
        }
    } 
    
    
    *** If may fading transition din yung anchorpane...
  	public void switchToAbout(ActionEvent event) throws IOException {

	    FXMLLoader loader = new FXMLLoader(getClass().getResource("Aboutus.fxml"));
	    Parent root = loader.load();
	    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	    scene = new Scene(root);
	    
	    AnchorPane rootPane = (AnchorPane) scene.getRoot();
	    rootPane.setTranslateY(scene.getHeight());
	    rootPane.setOpacity(0.0); // Initially, set the opacity to 0
	    stage.setScene(scene);

	    TranslateTransition translateTransition = new TranslateTransition(Duration.millis(700), rootPane);
	    translateTransition.setToY(0);
	    translateTransition.play();

	    FadeTransition fadeTransition = new FadeTransition(Duration.millis(700), rootPane);
	    fadeTransition.setToValue(1.0);
	    fadeTransition.play();
	}
	
	
	*** Maximiziation
	    public void maximizeProgram(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        if (stage.isMaximized()) {
            stage.setMaximized(false);
        } else {
            stage.setMaximized(true);
        }
    }
    
    
    
    */
	
	}
