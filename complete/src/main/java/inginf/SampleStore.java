package inginf;

import java.util.ArrayList;

public class SampleStore {

    private ArrayList<Assembly> assemblies = new ArrayList<Assembly>();

    private ArrayList<Item> items = new ArrayList<Item>();
    public ArrayList<Item> getItems() {
        return items;
        initializeAssemblies();
    }

    private void initializeAssemblies() {
        Assembly assembly1 = new Assembly("Assembly 1");
        Assembly assembly2 = new Assembly("Assembly 2");
        Assembly assembly3 = new Assembly("Assembly 3");

        assemblies.add(assembly1);
        assemblies.add(assembly2);
        assemblies.add(assembly3);
    }

    public ArrayList<Assembly> getAssemblies() {
        return assemblies;
    }

    public SampleStore() {   

        Item itemAuto = new Item("Auto", 
            "Auto als komplette Baugruppe",
            "zusammengebaut");

        Item itemAchse = new Item("Achse", 
            "Achse als komplette Baugruppe",
            "zusammengebaut");

        Item itemRad = new Item("Rad", 
            "Rad als Einzelteil", 
            "PVC");
        itemRad.setWeightedWeight(10);
        
        Item itemHaube = new Item("Haube",
         "Oberteil als Einzelteil", "PVC");
        itemHaube.setCalculatedWeight(20);

        Item itemSteckAchse = new Item("Steckachse", 
            "Steckachse als Einzelteil", 
            "Stahl");
        itemSteckAchse.setEstimatedWeight(5);

        itemAuto.getUses().add(
            new ItemInstance(
                "Vorderachse", 
                itemAchse));
        itemAuto.getUses().add(
            new ItemInstance(
                "Hinterachse", 
                itemAchse));
        itemAuto.getUses().add(
            new ItemInstance(
                "Aufbau", 
                itemHaube));
        itemAuto.getUses().add(
            new ItemInstance(
                "Reserverad", itemRad));

        itemAchse.getUses().add(
            new ItemInstance("Rad links", itemRad));
        itemAchse.getUses().add(
            new ItemInstance("Rad rechts", itemRad));
        itemAchse.getUses().add(
            new ItemInstance("Steckachse", itemSteckAchse));

        items.add(itemAuto);
        items.add(itemAchse);
        items.add(itemRad);
        items.add(itemHaube);
        items.add(itemSteckAchse);

        for (Item item : items) {
            item.Id = items.indexOf(item);
        }
    }
}