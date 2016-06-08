package ru.sarir.betterfood.proxy;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.MinecraftForge;
import ru.sarir.betterfood.handlers.HookTexture;

public class ClientProxy extends CommonProxy {
	public void preInit(FMLPreInitializationEvent preEvent) {
		super.preInit(preEvent);
	}

	public void init(FMLInitializationEvent event) {
		super.init(event);
	}

	public void postInit(FMLPostInitializationEvent postEvent) {
		super.postInit(postEvent);
		
		MinecraftForge.EVENT_BUS.register(new HookTexture());
	}
}
