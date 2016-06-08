package ru.sarir.betterfood.items;

import net.minecraft.item.ItemFood;
import ru.sarir.betterfood.Globals;

public class BFItemFood extends ItemFood {

	public BFItemFood(String unLocalizedName, int amount, float saturation, boolean isWolfFood) {
		super(amount, saturation, isWolfFood);
		
		this.setUnlocalizedName(unLocalizedName);
		this.setCreativeTab(Globals.creativeTab);
		this.setTextureName(Globals.MODID + ":" + unLocalizedName);
	}

}
