package shadows.plants2.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import shadows.plants2.data.enums.ILogBasedPropertyEnum;
import shadows.plants2.data.enums.IParticleProvider;

public class BlockEnumParticleLeaves<E extends Enum<E> & ILogBasedPropertyEnum & IParticleProvider> extends BlockEnumLeaves<E> {

	public BlockEnumParticleLeaves(String name, Block sapling, Class<E> clazz, int predicate) {
		super(name, sapling, clazz, predicate);
	}

	public void randomDisplayTick(IBlockState state, World world, BlockPos pos, Random rand) {
		if (rand.nextFloat() < 0.1F)
				world.spawnParticle(state.getValue(property).getParticle(), pos.getX() + 0.5, pos.getY() - 0.8, pos.getZ() + 0.5, getDouble(rand), -0.1, getDouble(rand));
	}
	
	public double getDouble(Random rand) {
		return MathHelper.nextDouble(rand, -0.05, 0.05);
	}

}
