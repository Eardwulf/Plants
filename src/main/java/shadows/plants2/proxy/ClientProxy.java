package shadows.plants2.proxy;

import binnie.botany.tile.FlowerRenderInfo;
import binnie.botany.tile.TileEntityFlower;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import shadows.plants2.client.IHasModel;
import shadows.plants2.init.ModRegistry;
import shadows.plants2.tile.TileFlowerpot;

public class ClientProxy implements IProxy {

	@Override
	public void preInit(FMLPreInitializationEvent e) {
		MinecraftForge.EVENT_BUS.register(this);
	}

	@Override
	public void init(FMLInitializationEvent e) {
		Minecraft.getMinecraft().getBlockColors().registerBlockColorHandler(new IBlockColor() {

			@Override
			public int colorMultiplier(IBlockState state, IBlockAccess world, BlockPos pos, int tint) {
				if (tint == 1)
					return world.getBiome(pos).getGrassColorAtPos(pos);

				TileEntity t = world.getTileEntity(pos);

				if (tint >= 10 && t instanceof TileFlowerpot) {

					TileFlowerpot pot = (TileFlowerpot) t;

					FlowerRenderInfo render = new FlowerRenderInfo(pot.getFlowerItemStack().getTagCompound());
					if (tint == 10)
						return render.getStem().getColor(render.isWilted());
					if (tint == 11)
						return render.getPrimary().getColor(render.isWilted());
					if (tint == 12)
						return render.getSecondary().getColor(render.isWilted());

				}
				return -1;
			}
		}, ModRegistry.FLOWERPOT);
	}

	@Override
	public void postInit(FMLPostInitializationEvent e) {

	}

	@SubscribeEvent
	public void onModelRegister(ModelRegistryEvent e) {
		for (Block b : ModRegistry.BLOCKS)
			if (b instanceof IHasModel)
				((IHasModel) b).initModels(e);
		for (Item i : ModRegistry.ITEMS)
			if (i instanceof IHasModel)
				((IHasModel) i).initModels(e);
	}

}
