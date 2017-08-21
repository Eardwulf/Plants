package shadows.plants2.block;

import java.util.Random;

import net.minecraft.block.IGrowable;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import shadows.plants2.client.RenamedStateMapper;
import shadows.plants2.data.Constants;
import shadows.plants2.data.enums.ILogBasedPropertyEnum;
import shadows.plants2.util.PlantUtil;

public class BlockEnumSapling<E extends Enum<E> & ILogBasedPropertyEnum> extends BlockEnumBush<E> implements IGrowable {

	public static final AxisAlignedBB SAPLING_AABB = new AxisAlignedBB(0.1D, 0.0D, 0.1D, 0.9D, 0.8D, 0.9D);

	public BlockEnumSapling(String name, Class<E> clazz, int predicate) {
		super(name, EnumPlantType.Plains, clazz, predicate);
		setDefaultState(getBlockState().getBaseState().withProperty(property, types.get(0)).withProperty(Constants.INV, false));
		setTickRandomly(true);
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
		return NULL_AABB;
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return SAPLING_AABB;
	}

	@Override
	public void updateTick(World world, BlockPos pos, IBlockState state, Random rand) {
		if (!world.isRemote && world.getLightFromNeighbors(pos.up()) >= 9 && rand.nextInt(7) == 0) {
			this.grow(world, rand, pos, state);
		}
	}

	@Override
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
	}

	@Override
	public int damageDropped(IBlockState state) {
		return state.getValue(property).ordinal();
	}

	@Override
	public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient) {
		return true;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isNormalCube(IBlockState state) {
		return false;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void initModels(ModelRegistryEvent e) {
		for (int i = 0; i < types.size(); i++) {
			PlantUtil.sMRL("saplings", this, i, "inventory=true," + property.getName() + "=" + types.get(i).getName());
		}
		ModelLoader.setCustomStateMapper(this, new RenamedStateMapper("saplings"));
	}

	@Override
	public boolean canUseBonemeal(World world, Random rand, BlockPos pos, IBlockState state) {
		return world.rand.nextFloat() < 0.45F;
	}

	@Override
	public void grow(World world, Random rand, BlockPos pos, IBlockState state) {
		world.setBlockToAir(pos);
		if (!state.getValue(property).getTreeGen().generate(world, rand, pos))
			world.setBlockState(pos, state);
	}

	@Override
	public BlockStateContainer createStateContainer() {
		return new BlockStateContainer.Builder(this).add(property).add(Constants.INV).build();
	}

	@Override
	protected void addStatesToList() {

	}
}
