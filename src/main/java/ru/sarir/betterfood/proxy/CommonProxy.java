package ru.sarir.betterfood.proxy;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import ic2.api.crops.CropCard;
import ic2.api.crops.Crops;
import net.minecraft.item.ItemStack;
import ru.sarir.betterfood.blocks.BFBlocks;
import ru.sarir.betterfood.blocks.crops.CropICSunflower;
import ru.sarir.betterfood.fluids.BFFluids;
import ru.sarir.betterfood.items.BFItems;
import ru.sarir.betterfood.recipes.BFRecipes;

public class CommonProxy {
	
	public void preInit(FMLPreInitializationEvent preEvent) {
		BFBlocks.initBlocks();
		BFItems.initItems();
		BFFluids.initFluids();
		BFRecipes.initRecipes();
		
		CropCard crop = new CropICSunflower();
		
		Crops.instance.registerCrop(crop);
		Crops.instance.registerBaseSeed(new ItemStack(BFItems.sunflowerSeeds, 4), crop, 1, 1, 1, 1);
	}

	public void init(FMLInitializationEvent event) {}

	public void postInit(FMLPostInitializationEvent postEvent) {}
}
