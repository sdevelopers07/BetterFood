package ru.sarir.betterfood.fluids;

import forestry.core.fluids.Fluids;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidStack;
import ru.sarir.betterfood.items.BFItems;

public class BFFluids {

	public static Fluid fluidMayo;
	public static Fluid fluidSunflowerOil;
	
	public static Block mayo;
	public static Block sunflowerOil;
	
	public static void initFluids() {
		fluidMayo = new BFFluid("fluidMayo", 1000, 0, 300, 20000, false);
		fluidSunflowerOil = new BFFluid("fluidSunflowerOil", 800, 0, 300, 5500, false);
		
		mayo = new BFFluidBlock("mayo", fluidMayo);
		sunflowerOil = new BFFluidBlock("sunflowerOil", fluidSunflowerOil);
		
		FluidContainerRegistry.registerFluidContainer(new FluidStack(fluidSunflowerOil, 250), new ItemStack(BFItems.sunflowerOil), new ItemStack(Items.glass_bottle));
		FluidContainerRegistry.registerFluidContainer(new FluidStack(fluidMayo, 250), new ItemStack(BFItems.mayoPotion), new ItemStack(Items.glass_bottle));
		FluidContainerRegistry.registerFluidContainer(new FluidStack(Fluids.MILK.getFluid(), 250), new ItemStack(BFItems.milkPotion), new ItemStack(Items.glass_bottle));
	}
}
