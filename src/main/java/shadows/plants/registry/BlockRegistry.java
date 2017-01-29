package shadows.plants.registry;


import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import shadows.plants.registry.modules.AE2Module;
import shadows.plants.registry.modules.BotaniaModule;
import shadows.plants.registry.modules.CosmeticModule;
import shadows.plants.registry.modules.ModuleController;
import shadows.plants.util.Config;
import shadows.plants.util.Data;
import shadows.plants.util.Util;


public class BlockRegistry {
	
	
	private static List<Block> BLOCKS(){
		List<Block> list = new ArrayList<Block>();
		list.clear();
		if (!AE2Module.getList().isEmpty() && Loader.isModLoaded(Data.AE2)) list.addAll(AE2Module.getList());
		//if (!BloodModule.getBM().isEmpty()) list.addAll(BloodModule.getBM());
		if (Data.BOTANIA_ENABLED) list.addAll(BotaniaModule.getBlockList());
		if (Data.COSMETIC_ENABLED) list.addAll(CosmeticModule.getBlockList());
		//if (!HostileModule.getH().isEmpty()) list.addAll(CosmeticModule.getH());
		//if (!MemeModule.getM().isEmpty()) list.addAll(CosmeticModule.getM());
		//if (!ChiselModule.getCM().isEmpty()) list.addAll(ChiselModule.getCM());
		//if (!EmbersModule.getE().isEmpty()) list.addAll(EmbersModule.getE());
		//if (!RootsModule.getR().isEmpty()) list.addAll(RootsModule.getR());
		return list;
	}

	public static void init(){
		if (Config.debug) System.out.println("BlockRegistry loaded");
		ModuleController.blockLoader();
		register();
	}

	
	public static void register(){
		for (Block block : BLOCKS()){
			Util.register(block);
		}
	}
	
	@SideOnly(Side.CLIENT)
	public static void initModels(){
		for (Block block : BLOCKS()){
			Util.initModel(block);
		}
	}
	
	
}
