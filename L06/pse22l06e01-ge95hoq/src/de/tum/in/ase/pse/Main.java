package de.tum.in.ase.pse;

import de.tum.in.ase.pse.storage.*;

final class Main {

    private Main() {
        // prevents calls from subclass, Main class can't be instantiated
        throw new UnsupportedOperationException();
    }

    public static void main(String[] args) {
        ToolStorage preOrderedTools = new ToolStorage();
        preOrderedTools.addTool(Tool.CULTIVATOR);
        preOrderedTools.addTool(Tool.HAMMER);
        preOrderedTools.addTool(Tool.GLOVES);
        preOrderedTools.addTool(Tool.GOLDEN_HAMMER);

        ToolStorage storedTools = new ToolStorage();
        storedTools.addTool(Tool.ADJUSTABLE_WRENCH);
        storedTools.addTool(Tool.BRADAWL);
        storedTools.addTool(Tool.BOLT);
        storedTools.addTool(Tool.COPING_SAW);

        FavoriteTools favoriteTools = new FavoriteTools();
        favoriteTools.addFavoriteTool("joey", storedTools.getAllTools().get(0));
        favoriteTools.addFavoriteTool("chandler", storedTools.getAllTools().get(1));
        favoriteTools.addFavoriteTool("ross", preOrderedTools.getAllTools().get(2));

        Tool tool = favoriteTools.getFavoriteTool("joey");
        System.out.println("joey's tool is: " + tool.toString());

    }
}
