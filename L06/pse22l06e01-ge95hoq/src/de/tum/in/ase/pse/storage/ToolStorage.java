package de.tum.in.ase.pse.storage;

import java.util.ArrayList;
import java.util.List;

/**
 * This class contains the tool storage logic as implemented by your coworker and relies on lists.
 * Since only few items should be stored within this type of toolStorage and there is no need for efficiently
 * retrieving single items, lists were used by your coworker (even though he would have used them anyways if they wouldn't
 * have fit here -> His golden hammer)
 */
public class ToolStorage {
    private List<Tool> list;

    public ToolStorage() {
        list = new ArrayList<>();
    }

    public void addTool(Tool tool) {
        list.add(tool);
    }

    public List<Tool> getAllTools() {
        return list;
    }
}
