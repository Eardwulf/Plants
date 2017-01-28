package shadows.plants.block;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import shadows.plants.common.EnumModule;
import shadows.plants.util.Data;

public class BushBase extends BlockBush{
	
		public EnumModule plantType;
		public List<Block> soil = new ArrayList<Block>();
		
	public BushBase(String name, EnumModule type, @Nullable List<Block> soilIn){
		setRegistryName(name);
		setUnlocalizedName(Data.MODID + "." + name);
        setCreativeTab(Data.TAB);
        setHardness(0.0F);
        setSoundType(SoundType.PLANT);
        disableStats();
        plantType = type;
        if (soilIn != null) soil.addAll(soilIn);
        soil.add(Blocks.GRASS_PATH);
        soil.add(Blocks.GRASS);
	}
	
	public BushBase(EnumModule type, String name, Block soilIn){
		setRegistryName(name);
		setUnlocalizedName(Data.MODID + "." + name);
        setCreativeTab(Data.TAB);
        setHardness(0.0F);
        setSoundType(SoundType.PLANT);
        disableStats();
        plantType = type;
        soil.add(soilIn);
	}
	
    public EnumModule getType(BushBase block){
    	return block.plantType;
    }
    
    @Override
    public boolean canSustainPlant(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing direction, net.minecraftforge.common.IPlantable plantable)
    {
    	return soil.contains(world.getBlockState(pos).getBlock()) || state.getBlock() instanceof BlockDirt;
    }

    @Override
    protected boolean canSustainBush(IBlockState state)
    {
    	return soil.contains(state.getBlock()) || state.getBlock() instanceof BlockDirt;
    }
    
    @SideOnly(Side.CLIENT) @Override
    public Block.EnumOffsetType getOffsetType()
    {
        return Block.EnumOffsetType.XZ;
    }
    
    
}
