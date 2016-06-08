package ru.sarir.betterfood.items;

import net.minecraft.item.Item;
import ru.sarir.betterfood.Globals;

public class BFItem extends Item {

	public BFItem(String name) {
		super();
		
		this.setUnlocalizedName(name);
		this.setCreativeTab(Globals.creativeTab);
		this.setTextureName(Globals.MODID + ":" + name);
	}
}
