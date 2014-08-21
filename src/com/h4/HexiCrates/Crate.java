package com.h4.HexiCrates;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.Random;

public class Crate {

    private String crateName;

    private int itemLimit;

    private List sourceItems;
    private List<ItemStack> crateContents;

    private Random randomGenerator = new Random();

    public Crate (String crateName, int itemLimit, List sourceItems) {
        this.crateName = crateName;
        this.itemLimit = itemLimit;
        this.sourceItems = sourceItems;

        this.fillCrate();
    }

    private void fillCrate () {
        int randomInt;

        for (int i = 0; i < itemLimit; i++) {

            // Generate
            randomInt = randomGenerator.nextInt(sourceItems.size());

            // Grab and Split
            String[] itemData = ((String) sourceItems.get(randomInt)).split(":");

            try {
                // Construct Material and Append
                crateContents.add(new ItemStack(Material.matchMaterial(itemData[0]), Integer.parseInt(itemData[2]), Short.parseShort(itemData[1])));
            }catch (NumberFormatException e2) {

            }
        }
    }
}
