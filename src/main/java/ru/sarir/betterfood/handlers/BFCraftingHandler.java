package ru.sarir.betterfood.handlers;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import ru.sarir.betterfood.items.BFItems;

public class BFCraftingHandler {
	@SubscribeEvent
	public void onCrafting(ItemCraftedEvent event) {
		
		final IInventory craftMatrix = null;
		
		for(int i = 0; i < event.craftMatrix.getSizeInventory(); i++) {
			ItemStack item = event.craftMatrix.getStackInSlot(i);
			if(item != null) {
				
				
				// Knife
				if(item.getItem() == BFItems.knife) {
					ItemStack k = new ItemStack(BFItems.knife, 2, (item.getItemDamage() + 1));
					
					if(k.getItemDamage() >= k.getMaxDamage()) {
						k.stackSize--;
					}
					event.craftMatrix.setInventorySlotContents(i, k);
				}
				
			}
		}
		
	}
}
