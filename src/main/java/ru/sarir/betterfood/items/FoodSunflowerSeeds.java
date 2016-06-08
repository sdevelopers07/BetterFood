package ru.sarir.betterfood.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;
import ru.sarir.betterfood.blocks.BFBlocks;

public class FoodSunflowerSeeds extends BFItemFood implements IPlantable {

	public FoodSunflowerSeeds(String unLocalizedName, int amount, float saturation, boolean isWolfFood) {
		super(unLocalizedName, amount, saturation, isWolfFood);
		GameRegistry.registerItem(this, unLocalizedName);
	}

	@Override
	public boolean onItemUse(ItemStack parItemStack, EntityPlayer parPlayer, World parWorld, int parX, int parY,
			int parZ, int par7, float par8, float par9, float par10) {
		// not sure what this parameter does, copied it from potato
		if (par7 != 1) {
			return false;
		}
		// check if player has capability to edit
		else if (parPlayer.canPlayerEdit(parX, parY + 1, parZ, par7, parItemStack)) {
			// check that the soil block can sustain the plant
			// and that block above is air so there is room for plant to grow
			if (parWorld.getBlock(parX, parY, parZ).canSustainPlant(parWorld, parX, parY, parZ, ForgeDirection.UP, this)
					&& parWorld.isAirBlock(parX, parY + 1, parZ) && parWorld.getBlock(parX, parY, parZ).equals(Blocks.farmland)) {
				// place the plant block
				parWorld.setBlock(parX, parY + 1, parZ, BFBlocks.plantSunflower);
				// decrement the stack of seed items
				--parItemStack.stackSize;
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	@Override
	public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z) {
		return EnumPlantType.Crop;
	}

	@Override
	public Block getPlant(IBlockAccess world, int x, int y, int z) {
		return BFBlocks.plantSunflower;
	}

	@Override
	public int getPlantMetadata(IBlockAccess world, int x, int y, int z) {
		return 0;
	}

}
