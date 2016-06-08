package ru.sarir.betterfood.fluids;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class BFFluid extends Fluid {

	public BFFluid(String fluidName, int density, int luminosity, int temperature, int viscosity, boolean gaseous) {
		super(fluidName);
		this.setDensity(density);
		this.setLuminosity(luminosity);
		this.setTemperature(temperature);
		this.setViscosity(viscosity);
		this.setGaseous(gaseous);
		
		FluidRegistry.registerFluid(this);
	}

}
