package shadows.plants.block.internal.cosmetic;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import shadows.plants.block.BushBase;
import shadows.plants.common.EnumModule;
import shadows.plants.util.Data;

public class BlockHarvestable extends BushBase{
	
	public static final PropertyBool FRUIT = PropertyBool.create("fruit");
	public static ItemStack crops;
	
	public BlockHarvestable(String name, ItemStack crop){
		super(name, EnumModule.COSMETIC, null);
		setDefaultState(this.blockState.getBaseState().withProperty(FRUIT, false));
		setTickRandomly(true);
		crops = crop;
	}
	
	@Override
	 public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ){
		if(player.getHeldItemMainhand() == Data.EMPTYSTACK){
			if(state.getValue(FRUIT)){
				Block.spawnAsEntity(world, pos, crops);
				world.setBlockState(pos, this.getDefaultState());
			}
		}
		return false;
	}
	
	 @Override
	    public IBlockState getStateFromMeta(int meta)
	    {
	        if(meta == 0)return this.blockState.getBaseState().withProperty(FRUIT, false);
	        return this.blockState.getBaseState().withProperty(FRUIT, true);
	    }

	    @Override
	    public int getMetaFromState(IBlockState state)
	    {
	        if(state.getValue(FRUIT)) return 1;
	        return 0;
	    }
	    
	    @Override
	    protected BlockStateContainer createBlockState()
	    {
	        return new BlockStateContainer(this, new IProperty[] {FRUIT});
	    }
	
	    @Override
	    public void updateTick(World world, BlockPos pos, IBlockState state, Random rand){
	        super.updateTick(world, pos, state, rand);

	        if (world.getLightFromNeighbors(pos.up()) > 5)
	        {
	            if (!state.getValue(FRUIT))
	            {

	                if(net.minecraftforge.common.ForgeHooks.onCropsGrowPre(world, pos, state, rand.nextInt((15)) <= 2))
	                {
	                    world.setBlockState(pos, state.withProperty(FRUIT, true), 2);
	                    net.minecraftforge.common.ForgeHooks.onCropsGrowPost(world, pos, state, world.getBlockState(pos));
	                }
	            }
	        }
	    }
	
	
}
