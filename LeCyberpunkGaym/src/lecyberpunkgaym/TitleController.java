/*
 * Caleb Brewer
 * 11/22/18
 * File for the title screen of the game
 */
package lecyberpunkgaym;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class TitleController implements Initializable {
    
    // Java FX items
    @FXML
    private Button btnPlay;
    @FXML
    private AnchorPane titlePane;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    // Activates whenever the play button is pressed and switches the loaded FXML
    // file to the main game
    @FXML
    private void btnPlayAction(ActionEvent event) throws Exception {
        
        // Switches from the title fxml to the mainGame fxml
        AnchorPane pane = FXMLLoader.load(getClass().getResource("MainGame.fxml"));
        titlePane.getChildren().setAll(pane);
    }
}