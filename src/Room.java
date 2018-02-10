
import java.util.ArrayList;
import java.util.Arrays;


/**
 * Defines a room object.
 */
public class Room {
    /**
     * Variables initialized according to the room's properties.
     */
    private String name;
    private String description;
    private ArrayList<String> items;
    private Direction[] directions;


    /**
     * @return name of the room
     */
    public String getName() {
        return name;
    }

    /**
     * @return the description of the room
     */
    public String getDescription() {
        return description;
    }

     /**
      * @return a string arraylist of the items in the room
      */
     public ArrayList<String> getItems() {
         return items;
     }

    /**
     * @return a direction array that consists of the possible directions one may proceed to
     */
    public Direction[] getDirections() {
        return directions;
    }

    /**
     * Sets an item arraylist since it might not be initialized.
     * @throws IllegalArgumentException if items is null
     */
    public void setItems() {
        this.items = new ArrayList<>();
    }

    /**
     * Removes an item from the items arraylist
     * @throws IllegalArgumentException if items is null
     */
    public void removeItems(int indexToBeRemoved) {
        if(indexToBeRemoved < 0 || indexToBeRemoved > this.items.size() - 1){
            throw new IllegalArgumentException(ErrorConstants.INDEX_OUT_OF_RANGE);
        }
        this.items.remove(indexToBeRemoved);
    }

    /**
     * Removes an item from the items arraylist
     * @throws IllegalArgumentException if items is null
     */
    public void addItems(String item) {
        if(item == null){
            throw new IllegalArgumentException(ErrorConstants.NULL_INPUT);
        }
        this.items.add(item);
    }

    /**
     * Custom compare method to determine if two arrays of items are equal
     * @param another set of string item arraylist
     * @return true if first and second set are equal, false otherwise
     */
    public boolean itemsEquals(ArrayList<String> another){
        if(another == null) {
            throw new IllegalArgumentException(ErrorConstants.NULL_INPUT);
        }
        if(this.getItems().size() == another.size()) {
            for (int i = 0; i < another.size(); i++) {
                if(!another.contains(this.getItems().get(i))){
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Custom equals to method to compare two Room objects
     * @param another another Room object
     * @return true if two Room objects are equal, false otherwise.
     * @throws IllegalArgumentException if input is null
     */
     public boolean equals(Room another){
         if(another == null) {
             throw new IllegalArgumentException(ErrorConstants.NULL_INPUT);
         }
         if(another.getItems() == null){
             another.setItems();
         }
         if(this.getItems() == null){
             this.setItems();
         }
         return this.name.equals(another.name) && this.description.equals(another.description)
                 && this.itemsEquals(another.getItems())
                 && Direction.arrayEquals(this.getDirections(), another.getDirections());
     }


    /**
     * Compares if two arrays of Room objects are equal.
     * @param roomArr1 first Room array
     * @param roomArr2 second Room array
     * @return true if the two array contain equal Room objects, false otherwise.
     * @throws IllegalArgumentException if either arr 1 or arr 2 is null
     */
    @SuppressWarnings("Duplicates")
    public static boolean arrayEquals(Room[] roomArr1, Room[] roomArr2){
        if(roomArr1 == null || roomArr2 == null) {
            throw new IllegalArgumentException(ErrorConstants.NULL_INPUT);
        }

        if(roomArr1.length == roomArr2.length){
            for (int i = 0; i < roomArr1.length; i++) {
                if(!roomArr1[i].equals(roomArr2[i])){
                    return false;
                }
            }
            return true;
        }
        return false;
    }


    /**
     * Finds if a direction exists in the Direction array.
     * @param inputDirection the direction inputted by user
     * @return the direction object if it is found, null otherwise.
     * @throws IllegalArgumentException if inputDirection is null
     */
    public Direction findDirection(String inputDirection){
        if(inputDirection == null) {
            throw new IllegalArgumentException(ErrorConstants.NULL_INPUT);
        }

        inputDirection = inputDirection.trim();
        for(Direction direction: directions){
            if(direction.getDirectionName().equalsIgnoreCase(inputDirection)){
                return direction;
            }
        }
        return null;
    }

    /**
     * Finds the index of a item in the item array
     * @param inputItem the item to be searched for
     * @return the index of the item if it is found, -1 otherwise.
     * @throws IllegalArgumentException if inputItem is null
     */
    public int findItemIndex(String inputItem) {
        if(inputItem == null) {
            throw new IllegalArgumentException(ErrorConstants.NULL_INPUT);
        }

        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).equalsIgnoreCase(inputItem)) {
                return i;
            }
        }
        return -1;
    }

    /**S
     * Prints all the items in the room object.
     */
    public void printItemsInRoom(){
        // If item array is not initialized, prints following message.
        if(this.getItems() == null){
            System.out.println("This room contains nothing!");
            return;
        }

        // Case if items is empty
        if(this.getItems().size() == 0){
            System.out.println("This room contains nothing!");
        } else {
            System.out.print("This room contains: ");

            // Case when items = 1
            if(this.getItems().size() == 1){
                System.out.println(this.getItems().get(0));
            }

            // Case when items = 2
            else if(this.getItems().size() == 2) {
                System.out.println(this.getItems().get(0) + " and " + this.getItems().get(1));
            }

            // Case when items >= 3
            else {
                for (int i = 0; i < this.getItems().size(); i++) {
                    if (i == this.getItems().size() - 1) {
                        System.out.println("and " + this.getItems().get(i));
                    } else{
                        System.out.print(this.getItems().get(i) + ", ");
                    }
                }
            }
        }
    }

    /**
     * Prints all direction names in the Direction array.
     */
    public void printDirectionsToGo(){
        if(this.getDirections().length == 0){
            System.out.println("You can't go anywhere!");
        } else {
            System.out.print("From here, you can go: ");

            // Case when items = 1
            if(this.getDirections().length == 1){
                System.out.println(this.getDirections()[0].getDirectionName());
            }

            // Case when items = 2
            else if(this.getDirections().length == 2){
                System.out.println(this.getDirections()[0].getDirectionName() +
                        " and " + this.getDirections()[1].getDirectionName());
            }

            // Case when items >= 3
            else {
                for (int i = 0; i < this.getDirections().length; i++) {
                    if (i == this.getDirections().length - 1) {
                        System.out.println("and " + this.getDirections()[i].getDirectionName());
                    } else{
                        System.out.print(this.getDirections()[i].getDirectionName() + ", ");
                    }
                }
            }
        }
    }

}






