package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.Scene;
// import javafx.scene.control.Button; // para sa minimize and maximize buttons


public class Main extends Application {
	// private boolean isMaximized = false; // Nilagay ko 'to para sa maximize button, but then I changed my code...
	@Override
	public void start(Stage primaryStage) {
		try {
			//primaryStage.initStyle(StageStyle.UNDECORATED);
			
			// primaryStage.setMaximized(true); // Start maximized
			
			Parent root = FXMLLoader.load(getClass().getResource("Home_page.fxml"));
			/* FXMLLoader loader = new FXMLLoader(gezztClass().getResource("Login.fxml"));
			Parent root = loader.load(); Para yata sana sa switching of scenes ito? I used another code. */
			Scene scene = new Scene(root,1279,719);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
			
			/* LoginController controller = loader.getController();
            controller.setStage(primaryStage); Para rin yata sa scene switching na hindi ko na ginamit. */
            
			// Para sa minimize and exit functions
			
			/*	Button myminimizeButton = (Button) scene.lookup("#myminimizeButton");
	            Button myexitButton = (Button) scene.lookup("#myexitButton");

	            myminimizeButton.setOnAction(e -> primaryStage.setIconified(true));
	            myexitButton.setOnAction(e -> primaryStage.close());

	            primaryStage.setScene(scene);
	            primaryStage.show();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		    
	    }
	
			* Ito kapag may maximize function, kaso nagagalaw 'yung contents kaya tinanggal ko na lang.
			 
			Button myminimizeButton = (Button) scene.lookup("#myminimizeButton");
            Button mymaximizeButton = (Button) scene.lookup("#mymaximizeButton");
            Button myexitButton = (Button) scene.lookup("#myexitButton");
			
            myminimizeButton.setOnAction(e -> primaryStage.setIconified(true));
            mymaximizeButton.setOnAction(e -> {
                if (isMaximized) {
                    primaryStage.setWidth(600);
                    primaryStage.setHeight(500);
                    primaryStage.centerOnScreen();
                    isMaximized = false;
                } else {
                    primaryStage.setMaximized(true);
                    isMaximized = true;
                }
            });
            
            myexitButton.setOnAction(e -> primaryStage.close());
            
            * Here ends the button actions.

            */
			
			// Continue after those button actions added...
            

