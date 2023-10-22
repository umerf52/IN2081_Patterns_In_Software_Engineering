package de.tum.in.ase.pse.storage;

import java.util.HashMap;
import java.util.Map;

/**
 * This class contains key-value-pair operations in a list that contains the favorite tools of the users
 */
public class FavoriteTools {
    /**
     * 1. TODO: Update the data structure to a more suitable type
     */
    private final Map<String, Tool> toolDataStructure;

    public FavoriteTools() {
        toolDataStructure = new HashMap<>();
    }

    /**
     *
     * @param userID the id of the user
     * @return the favorite tool of the user with that userID
     */
    public Tool getFavoriteTool(String userID) {
        /**
         * 2. TODO: Adapt implementation to new data structure
         */
        return toolDataStructure.getOrDefault(userID, null);
    }

    /**
     *
     * @param userID the id of the user with the favorite tool
     * @param tool the tool to be added as a favorite to user with id userID
     */
    public void addFavoriteTool(String userID, Tool tool) {
        /**
         * 3. TODO: Adapt implementation to new data structure
         * Notice the flaw in this rather bad implementation: Overwriting an existing preference does not
         * work, even though it is a necessary feature in the requirements. Your data structure should therefore
         * fix this as well.
         */
        toolDataStructure.put(userID, tool);
        System.out.println(tool.toString() + " was added to " + userID + "'s favourites");
    }

    /**
     * This function returns the whole dataStructure
     *
     * @return The all of the favorites in our data structure
     * 4. TODO: Update the methods signature and implementation to return our new data structure
     */
    public Map<String, Tool> getAllFavorites() {
        return this.toolDataStructure;
    }
}

