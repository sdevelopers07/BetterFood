package ru.sarir.betterfood;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import ru.sarir.betterfood.proxy.CommonProxy;

@Mod(modid = Globals.MODID, version = Globals.VERSION, name = Globals.NAME, dependencies = "required-after:IC2;after:Forestry")
public class BetterFood {
	
	@Instance(Globals.MODID)
	public static BetterFood instance;
	
	@SidedProxy(clientSide = Globals.CLIENT_PROXY, serverSide = Globals.SERVER_PROXY)
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent preEvent) {
		this.proxy.preInit(preEvent);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		this.proxy.init(event);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent postEvent) {
		this.proxy.postInit(postEvent);
	}
}
