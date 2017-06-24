package shadows.plants.block.internal.cosmetic;

import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import shadows.plants.block.BushBase;
import shadows.plants.common.EnumModule;
import shadows.plants.common.EnumTempZone;
import shadows.plants.common.IMetaPlant;
import shadows.plants.item.internal.cosmetic.ItemBlockMetaBush;
import shadows.plants.util.Data;

public class BlockMetaBush extends BushBase implements IMetaPlant {

	public static final PropertyInteger BASICMETA = PropertyInteger.create("basicmeta", 0, 15);
	public Map<Integer, EnumTempZone> tempmap;
	private int max;

	public BlockMetaBush(String name, Map<Integer, EnumTempZone> map, int maxmeta) {
		super(name, EnumModule.COSMETIC, null);
		setDefaultState(this.blockState.getBaseState().withProperty(BASICMETA, 0));
		tempmap = map;
		if (this.module.isEnabled())
			Data.ITEMS.add(new ItemBlockMetaBush(this));
		max = maxmeta;
	}

	public BlockMetaBush(String name, Map<Integer, EnumTempZone> map, int maxmeta, Block[] blocks) {
		super(name, EnumModule.COSMETIC, blocks);
		setDefaultState(this.blockState.getBaseState().withProperty(BASICMETA, 0));
		tempmap = map;
		if (this.module.isEnabled())
			Data.ITEMS.add(new ItemBlockMetaBush(this));
		max = maxmeta;
	}

	public BlockMetaBush(String name, Map<Integer, EnumTempZone> map, int maxmeta, Block[] blocks, EnumPlantType type) {
		super(name, EnumModule.COSMETIC, blocks, type);
		setDefaultState(this.blockState.getBaseState().withProperty(BASICMETA, 0));
		tempmap = map;
		if (this.module.isEnabled())
			Data.ITEMS.add(new ItemBlockMetaBush(this));
		max = maxmeta;
	}

	@Override
	public int damageDropped(IBlockState state) {
		return getMetaFromState(state);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> list) {
		for (int i = 0; i <= max; ++i) {
			list.add(new ItemStack(this, 1, i));
		}
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(BASICMETA, meta);
	}

	/**
	 * Convert the BlockState into the correct metadata value
	 */
	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(BASICMETA);
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { BASICMETA });
	}

	@Override
	public float getTempMax(IBlockState state) {
		int k = state.getValue(BASICMETA);
		return tempmap.get(k).getMax();
	}

	@Override
	public float getTempMin(IBlockState state) {
		int k = state.getValue(BASICMETA);
		return tempmap.get(k).getMin();
	}

	@Override
	public int getMaxData() {
		return max;
	}

	@Override
	public int getMetaPropValue(IBlockState state) {
		return state.getValue(BASICMETA);
	}

}
