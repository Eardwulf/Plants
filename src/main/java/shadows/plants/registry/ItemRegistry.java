package shadows.plants.registry;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import shadows.plants.registry.modules.BotaniaModule;
import shadows.plants.registry.modules.ModuleController;
import shadows.plants.util.Config;
import shadows.plants.util.Data;
import shadows.plants.util.Util;

public class ItemRegistry {
	
	
	public static List<Item> ITEMS = new ArrayList<Item>();
	
	private static List<Item> composeItems(List<Item> list){
		//if (!AE2Module.getAE().isEmpty()) list.addAll(AE2Module.getAE());
		//if (!BloodModule.getBM().isEmpty()) list.addAll(BloodModule.getBM());
		if (!BotaniaModule.getB_I().isEmpty() && Loader.isModLoaded(Data.BOTANIA)) list.addAll(BotaniaModule.getB_I());
		//if (!CosmeticModule.getC().isEmpty()) list.addAll(CosmeticModule.getC());
		//if (!HostileModule.getH().isEmpty()) list.addAll(CosmeticModule.getH());
		//if (!MemeModule.getM().isEmpty()) list.addAll(CosmeticModule.getM());
		//if (!ChiselModule.getCM().isEmpty()) list.addAll(ChiselModule.getCM());
		//if (!EmbersModule.getE().isEmpty()) list.addAll(EmbersModule.getE());
		//if (!RootsModule.getR().isEmpty()) list.addAll(RootsModule.getR());
		return list;
	}

	public static void init(){
		if (Config.debug) System.out.println("BlockRegistry loaded");
		ModuleController.itemLoader();
		composeItems(ITEMS);
		register();
		registerModels();
	}
	
	public static void register(){
		for (Item item : ITEMS){
			Util.register(item);
		}
	}
	
	@SideOnly(Side.CLIENT)
	public static void registerModels(){
		for (Item item : ITEMS){
			Util.initModel(item);
		}
	}
	
}
