package ru.sarir.betterfood.fluids;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import ru.sarir.betterfood.Globals;

public class BFFluidBlock extends BlockFluidClassic {

	@SideOnly(Side.CLIENT)
	protected IIcon stillIcon;
	@SideOnly(Side.CLIENT)
	protected IIcon flowingIcon;
	
	protected String name;
	
	public BFFluidBlock(String name, Fluid fluid) {
		super(fluid, Material.water);
		
		this.name = name;
		
		setBlockName("block" + name.substring(0,1).toUpperCase() + name.substring(1));
		GameRegistry.registerBlock(this, "block" + name.substring(0,1).toUpperCase() + name.substring(1));
		
		fluid.setBlock(this);
		fluid.setUnlocalizedName(this.getUnlocalizedName());
	}
	
	@Override
	public IIcon getIcon(int side, int meta) {
		return (side != 0) && (side != 1) ? flowingIcon : stillIcon;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister register) {
		stillIcon = register.registerIcon(Globals.MODID + ":fluid" + name.substring(0,1).toUpperCase() + name.substring(1) + "Still");
		flowingIcon = register.registerIcon(Globals.MODID + ":fluid" + name.substring(0,1).toUpperCase() + name.substring(1) + "Flowing");
	}

	@Override
	public boolean canDisplace(IBlockAccess world, int x, int y, int z) {
		if (world.getBlock(x, y, z).getMaterial().isLiquid())
			return false;
		return super.canDisplace(world, x, y, z);
	}

	@Override
	public boolean displaceIfPossible(World world, int x, int y, int z) {
		if (world.getBlock(x, y, z).getMaterial().isLiquid())
			return false;
		return super.displaceIfPossible(world, x, y, z);
	}

}
