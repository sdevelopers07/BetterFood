package ru.sarir.betterfood.handlers;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraftforge.client.event.TextureStitchEvent;
import ru.sarir.betterfood.fluids.BFFluids;

public class HookTexture {
	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void textureHook(TextureStitchEvent.Post event) {
		BFFluids.fluidMayo.setIcons(BFFluids.mayo.getBlockTextureFromSide(1), BFFluids.mayo.getBlockTextureFromSide(2));
		BFFluids.fluidSunflowerOil.setIcons(BFFluids.sunflowerOil.getBlockTextureFromSide(1), BFFluids.sunflowerOil.getBlockTextureFromSide(2));
	}
}
