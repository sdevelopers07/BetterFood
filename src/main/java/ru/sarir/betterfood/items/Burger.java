package ru.sarir.betterfood.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class Burger extends BFItemFood {

	public final int duration = 15 * 20;
	
	public Burger() {
		super("burger", 19, 0.1f, true);
		GameRegistry.registerItem(this, "burger");
	}
	
	@Override
	protected void onFoodEaten(ItemStack itemStack, World world, EntityPlayer player) {
		super.onFoodEaten(itemStack, world, player);
		player.addPotionEffect(new PotionEffect(Potion.regeneration.id, duration, 1));
		player.addPotionEffect(new PotionEffect(Potion.nightVision.id, duration, 1));
		player.addPotionEffect(new PotionEffect(Potion.jump.id, duration, 3));
		player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, duration, 3));
		player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, duration, 2));
		player.addPotionEffect(new PotionEffect(Potion.waterBreathing.id, duration, 2));
		player.addPotionEffect(new PotionEffect(Potion.resistance.id, duration, 2));
		player.addPotionEffect(new PotionEffect(Potion.digSpeed.id, duration, 2));
	}

}
