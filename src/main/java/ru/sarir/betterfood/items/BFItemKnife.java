package ru.sarir.betterfood.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import ru.sarir.betterfood.Globals;

public class BFItemKnife extends ItemSword {
	
	public BFItemKnife() {
		super(ToolMaterial.GOLD);
		this.setUnlocalizedName("knife");
		this.maxStackSize = 1;
		this.setMaxDamage(200);
		this.setNoRepair();
		this.setCreativeTab(Globals.creativeTab);
		this.setTextureName(Globals.MODID + ":knife");
		
		GameRegistry.registerItem(this, "knife");
	}
	
	@Override
	public boolean doesContainerItemLeaveCraftingGrid(ItemStack itemStack) {
		return false;
	}

	@Override
	public boolean getShareTag() {
		return true;
	}

	public boolean hasContainerItem(ItemStack itemStack) {
		return true;
	}

	@Override
	public ItemStack getContainerItem(ItemStack itemStack) {
		ItemStack stack = itemStack.copy();

		stack.setItemDamage(stack.getItemDamage() + 1);
		stack.stackSize = 1;

		return stack;
	}
}
