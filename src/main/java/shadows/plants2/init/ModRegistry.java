package shadows.plants2.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.oredict.OreDictionary;
import shadows.plants2.block.BlockCustomVine;
import shadows.plants2.block.BlockEnumBush;
import shadows.plants2.block.BlockEnumCrop;
import shadows.plants2.block.BlockEnumDoubleBush;
import shadows.plants2.block.BlockEnumDoubleHarvestBush;
import shadows.plants2.block.BlockEnumHarvestBush;
import shadows.plants2.block.base.BlockEnum;
import shadows.plants2.block.forgotten.BlockBushLeaves;
import shadows.plants2.block.forgotten.BlockBushling;
import shadows.plants2.data.Constants;
import shadows.plants2.data.IHasRecipe;
import shadows.plants2.data.StackPrimer;
import shadows.plants2.data.enums.HarvestEnums.DoubleHarvestable;
import shadows.plants2.data.enums.HarvestEnums.Harvestable;
import shadows.plants2.data.enums.TheBigBookOfEnums.BushSet;
import shadows.plants2.data.enums.TheBigBookOfEnums.Crops;
import shadows.plants2.data.enums.TheBigBookOfEnums.Desert;
import shadows.plants2.data.enums.TheBigBookOfEnums.Double;
import shadows.plants2.data.enums.TheBigBookOfEnums.Generic;
import shadows.plants2.data.enums.TheBigBookOfEnums.Plants;
import shadows.plants2.data.enums.TheBigBookOfEnums.Vines;
import shadows.plants2.item.ItemBigEnum;
import shadows.plants2.item.ItemExcalibur;
import shadows.plants2.item.ItemFoodBase;
import shadows.plants2.item.ItemPlantball;
import shadows.plants2.item.ItemSeed;

public class ModRegistry {

	public static final List<Block> BLOCKS = new ArrayList<Block>();
	public static final List<Item> ITEMS = new ArrayList<Item>();
	public static final List<IRecipe> RECIPES = new ArrayList<IRecipe>();
	public static final List<Potion> POTIONS = new ArrayList<Potion>();
	public static final CreativeTabs TAB = new CreativeTabs("plants") {

		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(PLANT_1, 1, Plants.ALLIUM_C.ordinal() % 16);
		}

	};

	//public static final BlockEnumLog<Logs> LOG_0 = new BlockEnumLog<Logs>("log_0", Logs.class, 0);
	//public static final BlockEnumSapling<Logs> SAPLING_0 = new BlockEnumSapling<Logs>("sapling_0", Logs.class, 0);
	//public static final BlockEnumLeaves<Logs> LEAVES_0 = new BlockEnumLeaves<Logs>("leaves_0", SAPLING_0, Logs.class, 0);

	public static final BlockEnumBush<Plants> PLANT_0 = new BlockEnumBush<Plants>("cosmetic_0", EnumPlantType.Plains, Plants.class, 0);
	public static final BlockEnumBush<Plants> PLANT_1 = new BlockEnumBush<Plants>("cosmetic_1", EnumPlantType.Plains, Plants.class, 1);
	public static final BlockEnumBush<Plants> PLANT_2 = new BlockEnumBush<Plants>("cosmetic_2", EnumPlantType.Plains, Plants.class, 2);
	public static final BlockEnumBush<Plants> PLANT_3 = new BlockEnumBush<Plants>("cosmetic_3", EnumPlantType.Plains, Plants.class, 3);
	public static final BlockEnumBush<Plants> PLANT_4 = new BlockEnumBush<Plants>("cosmetic_4", EnumPlantType.Plains, Plants.class, 4);

	public static final BlockEnumBush<Desert> DESERT_0 = new BlockEnumBush<Desert>("desert_0", EnumPlantType.Desert, Desert.class, 0);
	public static final BlockEnumBush<Desert> DESERT_1 = new BlockEnumBush<Desert>("desert_1", EnumPlantType.Desert, Desert.class, 1);

	public static final BlockEnumDoubleBush<Double> DOUBLE_0 = new BlockEnumDoubleBush<Double>("double_0", EnumPlantType.Plains, Double.class, 0);

	public static final ItemBigEnum<Generic> GENERIC = new ItemBigEnum<Generic>("generic", Generic.values());
	public static final Item PLANTBALL = new ItemPlantball();

	public static final Item OKRA = new ItemFoodBase("okra", 3, 1.3f);
	public static final Item PINEAPPLE = new ItemFoodBase("pineapple", 7, 0.6f, new PotionEffect(MobEffects.RESISTANCE, 20, 5), 0.01F); //u just ate an entire pineapple maybe u have some luck too and be invulnerable
	public static final Item AMARANTHUS_H = new ItemFoodBase("amaranthus_h", 5, 0.3f);
	public static final Item AMBROSIA_A = new ItemFoodBase("ambrosia_a", 3, 0.5f, new PotionEffect(MobEffects.REGENERATION, 10, 3), 0.06F); //Medicinal to certain native american tribes
	public static final Item APOCYNUM_C = new ItemFoodBase("apocynum_c", 1, 2.0f);
	public static final Item DAUCUS_C = new ItemFoodBase("daucus_c", 4, 1.1f, new PotionEffect(MobEffects.POISON, 10, 1), 0.24F);
	public static final Item PHYTOLACCA_A = new ItemFoodBase("phytolacca_a", 5, 1.0f, new PotionEffect(MobEffects.WITHER, 8, 1), 0.89F); //Poisonous when uncooked, maybe get a cooked variant?
	public static final Item PLANTAGO_M = new ItemFoodBase("plantago_m", 3, 0.4f, new PotionEffect(MobEffects.ABSORPTION, 8), 0.45F); //These things are like *really* healthy
	public static final Item RUBUS_O = new ItemFoodBase("rubus_o", 6, 0.5f);
	public static final Item RUBUS_P = new ItemFoodBase("rubus_p", 3, 0.5f);
	public static final Item SAFFRON = new ItemFoodBase("saffron", 1, 0.2f);
	public static final Item SOLANUM_C = new ItemFoodBase("solanum_c", 2, 0.5f);
	public static final Item SOLANUM_D = new ItemFoodBase("solanum_d", 3, 0.6f);
	public static final Item SOLANUM_N = new ItemFoodBase("solanum_n", 5, 1.1f);
	public static final Item ALYXIA_B = new ItemFoodBase("alyxia_b", 2, 1.4f);
	public static final Item ACTAEA_P = new ItemFoodBase("actaea_p", 4, 1.2f);
	public static final Item ALTERNANTHERA_F = new ItemFoodBase("alternanthera_f", 7, 0.3f);
	public static final Item AMPELOPSIS_A = new ItemFoodBase("ampelopsis_a", 1, 3.0f);
	public static final Item AKEBIA_Q = new ItemFoodBase("akebia_q", 4, 1.3f);
	public static final Item BLACKBERRY = new ItemFoodBase("blackberry", 2, 1.1F);
	public static final Item BLUEBERRY = new ItemFoodBase("blueberry", 2, 0.9F);
	public static final Item RASPBERRY = new ItemFoodBase("raspberry", 2, 1.4F);
	public static final Item HUCKLEBERRY = new ItemFoodBase("huckleberry", 3, 0.5F);

	public static final Item AMARANTHUS_H_SEEDS = new ItemSeed<Crops>("amaranthus_h_seeds", EnumPlantType.Crop, "plants2:crop_0", Crops.AMARANTHUS_H);
	public static final Item OKRA_SEEDS = new ItemSeed<Crops>("okra_seeds", EnumPlantType.Crop, "plants2:crop_0", Crops.OKRA);
	public static final Item PINEAPPLE_SEEDS = new ItemSeed<Crops>("pineapple_seeds", EnumPlantType.Crop, "plants2:crop_1", Crops.PINEAPPLE);

	public static final BlockEnumHarvestBush<Harvestable> HARVEST_0 = new BlockEnumHarvestBush<Harvestable>("harvest_0", EnumPlantType.Plains, Harvestable.class, 0);
	public static final BlockEnumHarvestBush<Harvestable> HARVEST_1 = new BlockEnumHarvestBush<Harvestable>("harvest_1", EnumPlantType.Plains, Harvestable.class, 1);

	public static final BlockEnumCrop<Crops> CROP_0 = new BlockEnumCrop<Crops>("crop_0", Crops.class, 0, new Item[] { AMARANTHUS_H, OKRA }, new Item[] { AMARANTHUS_H_SEEDS, OKRA_SEEDS });
	public static final BlockEnumCrop<Crops> CROP_1 = new BlockEnumCrop<Crops>("crop_1", Crops.class, 1, new Item[] { PINEAPPLE, null }, new Item[] { PINEAPPLE_SEEDS, null });

	public static final BlockEnumDoubleHarvestBush<DoubleHarvestable> DOUBLE_HARVEST_0 = new BlockEnumDoubleHarvestBush<DoubleHarvestable>("double_harvest_0", EnumPlantType.Plains, DoubleHarvestable.class, 0);

	public static final Block ADLUMIA_F = new BlockCustomVine("adlumia_f", Vines.ADLUMIA_F);
	public static final Block AFGEKIA_M = new BlockCustomVine("afgekia_m", Vines.AFGEKIA_M);
	public static final Block ANDROSACE_A = new BlockCustomVine("androsace_a", Vines.ANDROSACE_A);
	public static final Block AKEBIA_Q_VINE = new BlockCustomVine("akebia_q_vine", Vines.AKEBIA_Q, new StackPrimer(AKEBIA_Q));
	public static final Block AMPELOPSIS_A_VINE = new BlockCustomVine("ampelopsis_a_vine", Vines.AMPELOPSIS_A, new StackPrimer(AMPELOPSIS_A));

	public static final BlockEnum<BushSet> BUSH = new BlockBushLeaves();
	public static final Block BUSHLING = new BlockBushling();

	@SubscribeEvent
	public void onBlockRegister(Register<Block> event) {
		event.getRegistry().registerAll(BLOCKS.toArray(new Block[0]));
	}

	@SubscribeEvent
	public void onItemRegister(Register<Item> event) {
		event.getRegistry().registerAll(ITEMS.toArray(new Item[0]));
		if (Loader.isModLoaded(Constants.BOTANIA_ID))
			event.getRegistry().register(new ItemExcalibur());
	}

	@SubscribeEvent
	public void onRecipeRegister(Register<IRecipe> event) {
		recipes(event);
		event.getRegistry().registerAll(RECIPES.toArray(new IRecipe[0]));
	}

	@SubscribeEvent
	public void onPotionRegister(Register<Potion> event) {
		event.getRegistry().registerAll(POTIONS.toArray(new Potion[0]));
	}

	public static void oreDict(FMLInitializationEvent e) {
		OreDictionary.registerOre("dyeBlue", new ItemStack(GENERIC, 1, Generic.DYE_BLUE.ordinal()));
		OreDictionary.registerOre("dye", new ItemStack(GENERIC, 1, Generic.DYE_BLUE.ordinal()));
		OreDictionary.registerOre("dyeBlack", new ItemStack(GENERIC, 1, Generic.DYE_BLACK.ordinal()));
		OreDictionary.registerOre("dye", new ItemStack(GENERIC, 1, Generic.DYE_BLACK.ordinal()));
		OreDictionary.registerOre("dyeBrown", new ItemStack(GENERIC, 1, Generic.DYE_BROWN.ordinal()));
		OreDictionary.registerOre("dye", new ItemStack(GENERIC, 1, Generic.DYE_BROWN.ordinal()));
		OreDictionary.registerOre("dyeWhite", new ItemStack(GENERIC, 1, Generic.DYE_WHITE.ordinal()));
		OreDictionary.registerOre("dye", new ItemStack(GENERIC, 1, Generic.DYE_WHITE.ordinal()));

		for (Block block : ForgeRegistries.BLOCKS) {
			if (block instanceof BlockBush && Item.getItemFromBlock(block) != Items.AIR) {
				OreDictionary.registerOre("plant", new ItemStack(block, 1, OreDictionary.WILDCARD_VALUE));
			}
		}
	}

	public static void recipes(Register<IRecipe> e) {
		for (Block block : BLOCKS) {
			if (block instanceof IHasRecipe)
				((IHasRecipe) block).initRecipes(e);
		}
		for (Item item : ITEMS) {
			if (item instanceof IHasRecipe)
				((IHasRecipe) item).initRecipes(e);
		}
	}
}
