package application;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class SampleController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView image1;

    @FXML
    private ImageView image2;

    @FXML
    private AnchorPane blackBackground;

    @FXML
    private AnchorPane blueBackground;

    @FXML
    private AnchorPane purpleBackground;
    
    @FXML
    private JFXButton button0;

    @FXML
    private JFXButton button1;

    @FXML
    private JFXButton button2;

    @FXML
    private JFXButton button3;

    @FXML
    private JFXButton button4;
    
    boolean show=true;

    @FXML
    void initialize() {
       
    	blackBackground.setVisible(false);
    	blueBackground.setVisible(false);
    	purpleBackground.setVisible(false);
    	
    	fadeTransition(.1, blackBackground, 1, 0);
    	transition(.1, blueBackground, -500, 0);
    	transition(.1, purpleBackground, 500, 0);
    	
    	image1.setOnMouseClicked(e->{
    		blackBackground.setVisible(true);
    		blueBackground.setVisible(true);
    		
    		fadeTransition(.5, blackBackground, 0, 0.3);
        	transition(.5, blueBackground, 0, 0);
    		
    	});
    	
    	blackBackground.setOnMouseClicked(e->{
    		fadeTransition(.1, blackBackground, 1, 0);
        	transition(.1, blueBackground, -500, 0);
        	transition(.1, purpleBackground, 500, 0);
        	blackBackground.setVisible(false);
    	});
    	
    	image2.setOnMouseClicked(e->{
    		blackBackground.setVisible(true);
    		purpleBackground.setVisible(true);
    		fadeTransition(.5, blackBackground, 0, 0.3);
        	transition(.5, purpleBackground, 0, 0);
    		
    	});
    	
    	
    	HideFloatinActionMenu();
    	show=false;
    	
    	button0.setOnAction(e->{
    		
    		if (show) {
    			HideFloatinActionMenu();
    			show=false;
			}
    		else {
    			
    			showFloatindActionMenu();
    			show=true;
    		}
    		
    		
    	});

    }
    
    private void showFloatindActionMenu() {
    	transition(.3, button1, 0, 0);
    	scalaAnimation(.3, button1, 1, 1);
    	
    	transition(.3, button2, 0, 0);
    	scalaAnimation(.3, button2, 1, 1);
    	
    	transition(.3, button3, 0, 0);
    	scalaAnimation(.3, button3, 1, 1);
    	
    	transition(.3, button4, 0, 0);
    	scalaAnimation(.3, button4, 1, 1);
		
		
	}

	private void HideFloatinActionMenu() {
		
    	transition(.3, button1, 0, 70);
    	scalaAnimation(.3, button1, -1, -1);
    	
    	transition(.3, button2, 20, 70);
    	scalaAnimation(.3, button2, -1, -1);
    	
    	transition(.3, button3, 50, 60);
    	scalaAnimation(.3, button3, -1, -1);
    	
    	transition(.3, button4, 70, 70);
    	scalaAnimation(.3, button4, -1, -1);
		
	}

	public ScaleTransition scalaAnimation(double duration,Node node,double byX,double byY) {
    	
    	ScaleTransition scaleTransition=new ScaleTransition(Duration.seconds(duration),node);
    	scaleTransition.setByX(byX);
    	scaleTransition.setByY(byY);
    	scaleTransition.play();
    	return scaleTransition;
    }
    public FadeTransition fadeTransition(double duration,Node node,double from,double to) {
    	FadeTransition fadeTransition=new FadeTransition(Duration.seconds(duration),node);
    	fadeTransition.setFromValue(from);
    	fadeTransition.setToValue(to);
    	fadeTransition.play();
    	return fadeTransition;
    }
    
    public TranslateTransition transition(double duration,Node node,double byX,double byY) {
    	TranslateTransition transition=new TranslateTransition(Duration.seconds(duration),node);
    	transition.setToX(byX);
    	transition.setToY(byY);
    	transition.play();
    	return transition;
    }
}
