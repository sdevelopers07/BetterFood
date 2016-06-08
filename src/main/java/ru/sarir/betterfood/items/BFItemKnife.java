package ru.sarir.betterfood.items;

import cpw.mods.fml.common.registry.GameRegistry;
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
}
