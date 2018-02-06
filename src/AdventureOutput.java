import com.google.gson.Gson;
import com.mashape.unirest.http.exceptions.UnirestException;


import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Scanner;

public class AdventureOutput {

    /**
     * Method to travel from one room to another.
     * @param aRoom the room to be traveled to
     * @param started if the adventure has started
     * @param reachEnd if the adventure has reached its end
     */
    public static void proceedWithAdventure(Room aRoom, boolean started, String endingRoom){

        // 1). Print Description
        System.out.println(aRoom.getDescription());

        // 2). If room is starting room, print statement below.
        if(!started){
            System.out.println("Your journey beings here.");
        }

        // 3). If room is the ending room, print statement below.
        if(aRoom.getName().equals(endingRoom)){
            System.out.println("You have reached your final destination!");
            System.exit(1);
        }

        // 4). Print items in room.
        aRoom.printItemsInRoom();

        // 5). Print directions player can go
        aRoom.printDirectionsToGo();

    }
}
