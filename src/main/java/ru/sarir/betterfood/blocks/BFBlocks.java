package ru.sarir.betterfood.blocks;

import net.minecraft.block.Block;
import ru.sarir.betterfood.blocks.crops.CropSunflower;

public class BFBlocks {
	
	public static Block plantSunflower;
	
	public static void initBlocks() {
		plantSunflower = new CropSunflower();
	}
}
