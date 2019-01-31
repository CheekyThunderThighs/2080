/*
 * Caleb Brewer
 * 11/25/18
 * FXML file that contains code for the main screen of the game, handling all
 * the actual gameplay in the game
 */
package lecyberpunkgaym;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class MainGameController implements Initializable {

    // Instance variables
    int gamePosition = 0;
    int intimidation = 0;
    int userStrength = 1;
    int userDefense = 1;
    String location;
    int userHP = 10; // If used further, would need to be set to maxHP if maxHP goes up
    int userMaxHP = 10;
    int lvl = 1;
    int enemyHP = 7;

    // Java FX items
    @FXML
    private AnchorPane mainPane;
    @FXML
    private ImageView imgMainDisplay;
    @FXML
    private Label lblMainPrompt;
    @FXML
    private Label lblLocation;
    @FXML
    private TextField txtUserInput;
    @FXML
    private Label lblName;
    @FXML
    private ImageView imgPlayer;
    @FXML
    private Button btnAttack;
    @FXML
    private Button btnDefend;
    @FXML
    private Label lblEnemyHP;
    @FXML
    private Label lblStats;
    @FXML
    private ImageView imgEnemy;
    @FXML
    private AnchorPane paneWinLose;
    @FXML
    private ImageView imgWin;
    @FXML
    private ImageView imgLose;
    @FXML
    private Pane paneText;
    @FXML
    private Pane paneImage;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // Set the text of the main prompt
        lblMainPrompt.setText("> In the year 2035, the majority of jobs have been\n"
                + "  automated, leaving millions jobless worldwide.\n"
                + "> Protests sprung out but lead to nothing other than\n"
                + "  rioting and anarchy when corporations refused to\n"
                + "  take any form of action\n"
                + "> Poverty and crime have surged to levels never before\n"
                + "  seen worldwide\n"
                + "> So, where is it that you live?");

        // Make all FX items that become visible later on invisble
        imgPlayer.setVisible(false);
        imgEnemy.setVisible(false);
        lblStats.setVisible(false);
        lblEnemyHP.setVisible(false);
        btnAttack.setVisible(false);
        btnDefend.setVisible(false);

    }

    // Activates whenever the user inputs something into the text field
    @FXML
    private void txtUserCityInput(ActionEvent event) {

        // This will allow the program to know where we are in the game
        gamePosition++;

        // Clear both the MainPrompt and txtUserInput to make way for the next part of the intro
        if (gamePosition == 1) {
            // Set location label to inputted name via a string
            location = txtUserInput.getText();
            lblLocation.setText(location);
            txtUserInput.clear(); // Clears the last user input
            lblMainPrompt.setText("> Just like the majority of other cities, the\n"
                    + "  government attempted to stop the chaos using brute\n"
                    + "  force, but failed\n"
                    + "> All that's left of " + location + " is a broken city, a\n"
                    + "  broken system, and broken people, which brings us to\n"
                    + "  you. What is your name?");

        }
        // Set imgPLayer, lblName, and lblStats to visible
        if (gamePosition == 2) {
            imgPlayer.setVisible(true);
            lblStats.setVisible(true);
            String userName = txtUserInput.getText(); // Sets the name via user input
            lblName.setText(userName); // Will change the lblName to user's input
            txtUserInput.clear(); // Clear previous user input
            // Set the text of the user's stats
            lblStats.setText("Level: " + lvl + "\nHP: " + userHP + "\nIntimidation: " + intimidation + "\nStrength: " + userStrength + "\nDefene: " + userDefense);
            // Set the text of the main prompt to the next part of game
            lblMainPrompt.setText("> You wake up in your bedroom to commotion in your home\n"
                    + "> Whoever it is, they aren't being gentle with your\n"
                    + "  belongings. What will you do? \n"
                    + "> A.) Open your door and confront the intruder\n"
                    + "> B.) Wait it out");
        }
        if (gamePosition == 3) {
            // Stands for gamePosition2 choice, will be used in the if/else statement
            String gp2Choice = txtUserInput.getText();
            // Display an event based on the previous choice made by the user
            /* Remember that this if/else statement will be at gamePosition 4 */
            if ("A".equals(gp2Choice)) {
                txtUserInput.clear(); // Clear prevous user input
                imgEnemy.setVisible(true); // Displays the picture of the enemy
                intimidation = +1; // Will allow for more text based actions in the future
                lblMainPrompt.setText("> You aren't unfamiliar with hostile encounters, so\n"
                        + "  you decide to confront the problem\n"
                        + "> You open the door to your room in a total mess, a\n"
                        + "  man searching through your things \n"
                        + "> He turns around in shock aiming a gun towards you\n"
                        + "> You reach to your side and pull your gun on him\n"
                        + "> This will not end peacefully");
                // Make Attack, Defend, and Items buttons visible for a fight
                // Make enemy HP bar visible and set the text of the label
                if (gamePosition == 5 || "A".equals(gp2Choice)) {
                    txtUserInput.clear();
                    lblEnemyHP.setVisible(true);
                    lblEnemyHP.setText("HP: " + enemyHP + "/7");
                    btnAttack.setVisible(true);
                    btnDefend.setVisible(true);
                }
                // does the same as option A but with different events
            } else if ("B".equals(gp2Choice)) {
                txtUserInput.clear();
                imgEnemy.setVisible(true);
                userHP = userHP - 2;
                lblStats.setText("Level: " + lvl + "\nHP: " + userHP + "\nIntimidation: " + intimidation + "\nStrength: " + userStrength + "\nDefene: " + userDefense);
                lblMainPrompt.setText("> You decide it would be best to wait out whatever\n"
                        + "  is happening in the other room\n"
                        + "> You realize that this however was not the best\n"
                        + "  choice you could have made\n"
                        + "> The door swings open revealing an armed man, who\n"
                        + "  shoots your leg out of shock, crippling it. You pull out your\n"
                        + "  gun an prepare for a fight");
                // Make Attack, Defend, and Items buttons visible for a fight
                if (gamePosition == 5 || "B".equals(gp2Choice)) {
                    txtUserInput.clear();
                    lblEnemyHP.setVisible(true);
                    lblEnemyHP.setText("HP: " + enemyHP + "/7");
                    btnAttack.setVisible(true);
                    btnDefend.setVisible(true);
                }
            }
        }
    }

    // Will attack on enemy based on user strength
    @FXML
    private void btnAttackAction(ActionEvent event) throws Exception {

        // Set the lbl to the new HP based on attacks
        lblEnemyHP.setText("HP: " + enemyHP + "/7");
        lblStats.setText("Level: " + lvl + "\nHP: " + userHP + "\nIntimidation: " + intimidation + "\nStrength: " + userStrength + "\nDefene: " + userDefense);

        // Handle the death of a user
        if (userHP <= 0) {
            // Displays a "Game Over" screen
            // Also sets all images in the main pane invisible so things look cleaner
            paneText.setVisible(false);
            paneImage.setVisible(false);
            imgMainDisplay.setVisible(false);
            lblMainPrompt.setVisible(false);
            lblLocation.setVisible(false);
            lblName.setVisible(false);
            txtUserInput.setVisible(false);
            imgPlayer.setVisible(false);
            btnAttack.setVisible(false);
            btnDefend.setVisible(false);
            lblEnemyHP.setVisible(false);
            lblStats.setVisible(false);
            imgEnemy.setVisible(false);
            paneWinLose.setVisible(true);
            imgLose.setVisible(true);
            imgWin.setVisible(false);
        }
        // Handle death of enemy
        if (enemyHP <= 0) {
            // displays a "You Win" screen
            // Also makes everything within the mainPane invisible
            paneText.setVisible(false);
            paneImage.setVisible(false);
            imgMainDisplay.setVisible(false);
            lblMainPrompt.setVisible(false);
            lblLocation.setVisible(false);
            lblName.setVisible(false);
            txtUserInput.setVisible(false);
            imgPlayer.setVisible(false);
            btnAttack.setVisible(false);
            btnDefend.setVisible(false);
            lblEnemyHP.setVisible(false);
            lblStats.setVisible(false);
            imgEnemy.setVisible(false);
            paneWinLose.setVisible(true);
            imgLose.setVisible(false);
            imgWin.setVisible(true);
        } else {
            // Handle attacks of user
            enemyHP = (int) (enemyHP - (userStrength + (Math.random() * 1)));
            userHP = (int) (userHP - (userDefense * (Math.random() * 1)));
        }
    }

    // Will defend against enemy attacks based on user defense
    @FXML
    private void btnDefendAction(ActionEvent event) throws Exception {

        // Set new HP after turn
        lblEnemyHP.setText("HP: " + enemyHP + "/7");
        lblStats.setText("Level: " + lvl + "\nHP: " + userHP + "\nIntimidation: " + intimidation + "\nStrength: " + userStrength + "\nDefene: " + userDefense);

        // Handle deaths and defense of a user
        if (userHP <= 0) {
            // Displays a "Game Over" screen as well as makes mainPane items invisible
            paneText.setVisible(false);
            paneImage.setVisible(false);
            imgMainDisplay.setVisible(false);
            lblMainPrompt.setVisible(false);
            lblLocation.setVisible(false);
            lblName.setVisible(false);
            txtUserInput.setVisible(false);
            imgPlayer.setVisible(false);
            btnAttack.setVisible(false);
            btnDefend.setVisible(false);
            lblEnemyHP.setVisible(false);
            lblStats.setVisible(false);
            imgEnemy.setVisible(false);
            paneWinLose.setVisible(true);
            imgLose.setVisible(true);
            imgWin.setVisible(false);
        } else {
            // Handles the user defending based on user's defense
            userHP = (int) (userHP - (userDefense * (Math.random() * 1)));
        }
    }
}