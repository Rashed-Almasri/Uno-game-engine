package engine.managers;

import engine.piles.Pile;
import engine.managers.interfaces.PlayerInputManager;
import enums.CardColor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class StandardPlayerInputManager implements PlayerInputManager {
    private static StandardPlayerInputManager playerInputManager;

    public static StandardPlayerInputManager getInstance() {
        if(playerInputManager == null){
            playerInputManager = new StandardPlayerInputManager();
        }
        return playerInputManager;
    }

    private String getInput(String toPrint){
        String input = "";

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print(toPrint + " : ");
            input = reader.readLine();
        }
        catch (IOException e) {
                //
        }

        return input;
    }

    private boolean validateColor(String color){
        color = color.toLowerCase();

        return (color.equals("green") || color.equals("yellow") || color.equals("red") || color.equals("blue"));
    }

    private boolean validateInteger(String input){
        try{
            Integer.parseInt(input);
            return true;
        }
        catch(NumberFormatException e){
            return false;
        }
    }

    private boolean validateIndex(Pile playerHand, String input){
        if(!validateInteger(input)){
            return false;
        }

        return (Integer.parseInt(input) >= 1 && Integer.parseInt(input) <= playerHand.getSize());
    }

    private CardColor getColorValueOfString(String input){
        return switch (input) {
            case "red" -> CardColor.Red;
            case "blue" -> CardColor.Blue;
            case "green" -> CardColor.Green;
            case "yellow" -> CardColor.Yellow;
            default -> null;
        };
    }
    @Override
    public CardColor getColor() {
        String input = getInput("Choose a color");
        while(!validateColor(input)){
            input = getInput("Choose a valid color");
        }

        return getColorValueOfString(input.toLowerCase());
    }

    @Override
    public int getCardIndex(Pile playerHand) {
        String input = getInput("Enter card index");
        while(!validateIndex(playerHand, input)){
            input = getInput("Enter a valid card index");
        }

        return Integer.parseInt(input) - 1;
    }
}
