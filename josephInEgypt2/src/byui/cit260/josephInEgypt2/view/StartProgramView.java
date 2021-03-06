/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.josephInEgypt2.view;

import byui.cit260.josephInEgypt2.control.ProgramControl;
import byui.cit260.josephInEgypt2.model.Player;
import java.io.IOException;

import java.util.Scanner;
import josephinegypt2.JosephInEgypt2;

/**
 *
 * @author Britt
 */
public class StartProgramView extends View {
    public StartProgramView(){
        super("\n\n***********************************" );
        
        System.out.println("                                 "
                + "\n This is the game of Joseph in Egypt  "
                + "\n In this game you will help Joseph    "
                + "\n collcect enought resources to last   "
                + "\n his people throught the 7 years of    "
                + "\n famine.                              " );
        
        System.out.println("                               "
                + "\n As Joseph, you will need to administer "
                + "\n all the preparations for the 7 harsh years "
                + "\n of famine. You are responsible for storing "
                + "\n enough grain, legume, and honey in the "
                + "\n warehouse to last the people of Egypt "
                + "\n through the 7 years of famine."
                + "\n                                        "
                + "\n You will have all of the resources "
                + "\n needed within the 25 location in Egypt." 
                +"\n                                          " 
                + "\n The game will last 20 turns. At the "
                + "\n end of 20 turns you will be told if "
                + "\n you succeeded in saving the people. "
                + "\n It requires 10 barrels of grain, "
                + "\n 10 barrels of legume and 4 barrels of "
                + "\n honey to save the people and win the game.  "
                + "\n"
                + "\n*********************************************" );
    }
    public void startProgram() {
        try {
            // Display the banner screen
            this.displayBanner();
            //Get the players name
            String playersName = this.getPlayersName();
            //Create a new player
            Player player = ProgramControl.createPlayer(playersName);
            //DISPLAY a customized welcome message
            this.displayWelcomMessage(player);
            //DISPLAY the main menu  
            MainMenuView mainMenu = new MainMenuView();
            mainMenu.display();
        } catch (Exception e) {
            System.out.println("Error reading input" + e.getMessage());
        }

    }

    public void displayBanner() {
        System.out.println();
        
    }

    private String getPlayersName() {
        
        boolean valid = false; // indicates if the name has been received
        String playersName = null;
        
        try{
        while(!valid) { //while a valid name has not been retrieved
            //prompt for the player's name
            this.console.println("Enter the player's name below");
            
            //get the name from the keyboard and trimm of the blanks
            playersName= this.keyboard.readLine();
            playersName = playersName.trim();
            
            //if the name is invalid (less than two characters in length)
            if (playersName.length() < 2){
                this.console.println("Invalid name - the name must not be blank");
                continue; //  and repeat again
            }
            break; //out of the repitition
        }    
            
        }catch (Exception e) {
            ErrorView.display(this.getClass().getName(),"\"Error reading input\" "
                    +  e.getMessage());
        }
        
        return playersName; // return the name
    
    
    }

    private void displayWelcomMessage(Player player) {
        System.out.println("\n=============================");
        System.out.println("\t Welcome to the game " + player.getName());
        System.out.println("\t We hope you have a lot of fun");
        System.out.println("\n==============================");
    }

    @Override
    public boolean doAction(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
