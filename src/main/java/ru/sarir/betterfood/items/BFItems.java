package ru.sarir.betterfood.items;

import cpw.mods.fml.common.registry.GameRegistry;
import forestry.api.circuits.ChipsetManager;
import forestry.api.multiblock.MultiblockManager;
import forestry.api.recipes.RecipeManagers;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;

public class BFItems {

	public static ItemFood sunflowerSeeds;
	public static Burger burger;
	
	public static Item sunflowerOil; 
	public static Item mayoPotion;
	public static Item milkPotion;
	
	public static BFItemKnife knife;
	
	public static void initItems() {
		sunflowerSeeds = new FoodSunflowerSeeds("sunflowerSeeds", 1, 0.8f, false);
		burger = new Burger();
		
		sunflowerOil = registerItem("sunflowerOil");
		mayoPotion = registerItem("mayoPotion");
		milkPotion = registerItem("milkPotion");
		
		knife = new BFItemKnife();
	}
	
	private static Item registerItem(String name) {
		Item item = new BFItem(name);
		GameRegistry.registerItem(item, name);
		return item;
	}
	
	private static ItemFood registerFood(String unLocalizedName, int amount, float saturation, boolean isWolfFood) {
		ItemFood item = new BFItemFood(unLocalizedName, amount, saturation, isWolfFood);
		GameRegistry.registerItem(item, unLocalizedName);
		return item;
	}
}
