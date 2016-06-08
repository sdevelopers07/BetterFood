package ru.sarir.betterfood;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import ru.sarir.betterfood.items.BFItems;

public class CreativeTab extends CreativeTabs{
	
	public CreativeTab(String label) {
		super(label);
	}

	@Override
	public Item getTabIconItem() {
		return BFItems.burger;
	}
}
