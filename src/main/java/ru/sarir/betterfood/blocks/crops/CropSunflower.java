package ru.sarir.betterfood.blocks.crops;

import java.util.Random;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import ru.sarir.betterfood.Globals;
import ru.sarir.betterfood.items.BFItems;

public class CropSunflower extends BlockBush implements IGrowable {

	protected int maxGrowthStage = 5;

    @SideOnly(Side.CLIENT)
    protected IIcon[] iIcon;
	
	public CropSunflower() {
		setTickRandomly(true);
		float f = 0.5F;
		setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.25F, 0.5F + f);
		setCreativeTab(Globals.creativeTab);
		setHardness(0.0F);
		setStepSound(soundTypeGrass);
		disableStats();
		setBlockName("plantSunflower");
        setBlockTextureName(Globals.MODID + ":Sunflower_5");
		GameRegistry.registerBlock(this, "plantSunflower");
	}
	
	@Override
	protected boolean canPlaceBlockOn(Block parBlock) {
		return parBlock == Blocks.farmland;
	}
	
	public void incrementGrowStage(World parWorld, Random parRand, int parX, int parY, int parZ) {
		int growStage = parWorld.getBlockMetadata(parX, parY, parZ) + MathHelper.getRandomIntegerInRange(parRand, 1, 3);

		if (growStage > maxGrowthStage) {
			growStage = maxGrowthStage;
		}

		parWorld.setBlockMetadataWithNotify(parX, parY, parZ, growStage, 2);
	}
	
	@Override
	public Item getItemDropped(int metadata, Random rand, int fortune) {
		if(metadata == 5) {
			return new ItemStack(Blocks.double_plant, 1, 0).getItem();
		} else return BFItems.sunflowerSeeds;
	}
	
	@Override
	public int getRenderType() {
		return 1;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int parSide, int parGrowthStage) {
		return iIcon[parGrowthStage];
	}
    
	@Override
	public boolean func_149851_a(World world, int x, int y, int z, boolean p_149851_5_) {
		return world.getBlockMetadata(x, y, z) != maxGrowthStage;
	}

	@Override
	public boolean func_149852_a(World p_149852_1_, Random p_149852_2_, int p_149852_3_, int p_149852_4_, int p_149852_5_) {
		return true;
	}

	@Override
	public void func_149853_b(World world, Random rand, int x, int y, int z) {
		incrementGrowStage(world, rand, x, y, z);
	}
	
	@Override
	public void updateTick(World parWorld, int parX, int parY, int parZ, Random parRand) {
		super.updateTick(parWorld, parX, parY, parZ, parRand);
		int growStage = parWorld.getBlockMetadata(parX, parY, parZ) + parRand.nextInt(2);

		if (growStage > maxGrowthStage) {
			growStage = maxGrowthStage;
		}

		parWorld.setBlockMetadataWithNotify(parX, parY, parZ, growStage, 2);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister parIIconRegister) {
		iIcon = new IIcon[maxGrowthStage + 1];
		iIcon[0] = parIIconRegister.registerIcon(Globals.MODID + ":SunFlower_1");
		iIcon[1] = parIIconRegister.registerIcon(Globals.MODID + ":SunFlower_2");
		iIcon[2] = parIIconRegister.registerIcon(Globals.MODID + ":SunFlower_3");
		iIcon[3] = parIIconRegister.registerIcon(Globals.MODID + ":SunFlower_4");
		iIcon[4] = parIIconRegister.registerIcon(Globals.MODID + ":SunFlower_4");
		iIcon[5] = parIIconRegister.registerIcon(Globals.MODID + ":SunFlower_5");
	}

}
