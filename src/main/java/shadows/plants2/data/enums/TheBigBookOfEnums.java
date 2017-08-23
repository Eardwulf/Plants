package shadows.plants2.data.enums;

import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import shadows.plants2.data.Constants;
import shadows.plants2.data.IPostInitUpdate;
import shadows.plants2.data.StackPrimer;

public class TheBigBookOfEnums {

	public static enum Logs implements ILogBasedPropertyEnum {
		,;

		private WorldGenAbstractTree treeGen;

		@Override
		public void setTreeGen(WorldGenAbstractTree gen) {
			treeGen = gen;
		}

		@Override
		public WorldGenAbstractTree getTreeGen() {
			return treeGen;
		}

	}

	public static enum NetherLogs implements ILogBasedPropertyEnum, IParticleProvider {
		ASH(EnumParticleTypes.SMOKE_LARGE),
		BLAZE(EnumParticleTypes.FLAME);

		private WorldGenAbstractTree treeGen;
		private EnumParticleTypes particle;

		NetherLogs(EnumParticleTypes particle) {
			this.particle = particle;
		}

		@Override
		public void setTreeGen(WorldGenAbstractTree gen) {
			treeGen = gen;
		}

		@Override
		public WorldGenAbstractTree getTreeGen() {
			return treeGen;
		}

		@Override
		public EnumParticleTypes getParticle() {
			return particle;
		}

	}

	public static enum Plants implements IFlowerEnum {
		ABELIOPHYLLUM_D(false),
		ABROMA_A(true),
		ABUTILON_I(true),
		ACAENA_S(true),
		ACALYPHA_A(true),
		ACALYPHA_R(false),
		ACANTHOLIMON_G(true),
		ACHILLEA(true),
		ACHIMENES_E(true),
		ACINOS_A(true),
		ACIPHYLLA_G(true),
		ADENOPHORA_T(true),
		ADONIS_A(true),
		AECHMEA_A(true),
		AESCHYNANTHUS_S(true),
		AETHIONEMA_S(true),
		AGAPANTHUS_A(true),
		AGERATUM_C(true),
		AGROSTEMMA_G(true),
		AIRA_C(true),
		AJUGA_A(true),
		ALBUCA_F(true),
		ALCEA_B(true),
		ALKANNA_T(true),
		ALLIARIA_P(true),
		ALLIUM_C(true),
		ALOE_B(false),
		ALOPECURUS_G(false),
		ALSOBIA_D(false),
		ALSTROEMERIA_P(true),
		ALYOGYNE_H(true),
		AMARYLLIS_B(true),
		AMBROSIA_T(true),
		AMESIELLA_P(true),
		AMMOBIUM_A(true),
		AMPHIPAPPUS(true),
		ANACYCLUS_V(true),
		ANAGALLIS_A(true),
		ANCHUSA_A(true),
		ARGOCOFFEEOPSIS_L(true),
		ASCLEPIAS_S(true),
		ASCLEPIAS_T(true),
		ASPALATHUS_V(true),
		ASTILBE_C(false),
		BARBAREA_V(true),
		BEGONIA_E(true),
		BRACHYSTELMA_S(true),
		CARDAMINE_C(true),
		CEPHALOPHYLLUM_P(true),
		CHRYSANTHEMUM_M(true),
		CLOVE(false),
		CORYDALIS(true),
		CORYDALIS_F(true),
		CRASSULA_S(true),
		DISA_F(true),
		EPIPOGIUM_A(true),
		FABACEAE(true),
		GALANTHUS(true),
		HELIOTROPIUM_P(true),
		HELLEBORE(true),
		HESPERIS_M(true),
		IMPATIENS_C(false),
		ISOLEPIS_B(false),
		NARTHECIUM_A(true),
		NEMESIA_M(false),
		PEONY(true),
		PLUCHEA_G(true),
		PSORALEA_C(true),
		PSORALEA_M(false),
		PUERARIA_M(true),
		RHANTERIUM_E(true),
		RORIPPA_S(false),
		RUDBECKIA_H(true),
		STREBLORRHIZA_S(false),
		SUMATRA_D(false),
		THISMIA_A(false),
		TRILLIUM(true),
		VERATRUM_V(false),
		VERONICA_A(true),
		VIOLA_C(true),;

		EnumDyeColor color;
		boolean flowers;

		Plants(boolean flowers, EnumDyeColor c) {
			color = c;
			this.flowers = flowers;
		}

		Plants(boolean flowers) {
			this(flowers, EnumDyeColor.WHITE);
		}

		@Override
		public EnumDyeColor getColor() {
			return color;
		}

		@Override
		public boolean useForRecipes() {
			return true;
		}

		@Override
		public boolean hasFlowers() {
			return flowers;
		}

	}

	public static enum Desert implements IFlowerEnum {
		APACHE_PLUME(true),
		ARIZONA_POPPY(true),
		ASIAN_MUSTARD(true),
		BIGELOWS_MONKEY_FLOWER(true),
		BLACKTACK_PHACELIA(true),
		BLAZING_STAR(true),
		BLUE_FLAX(true),
		BRISTLY_FIDDLENECK(true),
		BROWN_EYES(true),
		BUCKBRUSH(true),
		BUTTON_BRITTLEBUSH(true),
		CANAIGRE(true),
		CHOCOLATE_DROPS(false),
		CHUPAROSA(false),
		CLUSTERED_BROOMRAPE(true),
		COULTERS_JEWELFLOWER(true),
		DISTANT_SCORPIONWEED(true),
		NEGLECTED_SCORPIONWEED(true),
		SAGEBRUSH(false);

		EnumDyeColor color;
		boolean flowers;

		Desert(boolean flowers, EnumDyeColor c) {
			color = c;
			this.flowers = flowers;
		}

		Desert(boolean flowers) {
			this(flowers, EnumDyeColor.WHITE);
		}

		@Override
		public EnumDyeColor getColor() {
			return color;
		}

		@Override
		public boolean useForRecipes() {
			return true;
		}

		@Override
		public boolean hasFlowers() {
			return flowers;
		}

	}

	public static enum Double implements IFlowerEnum {
		ABELIA_C(true),
		ABRONIA_A(true),
		ACANTHUS_B(true),
		ADENOCARPUS_F(true),
		AGONIS_T(true),
		ALONSOA_M(true);

		EnumDyeColor color;
		boolean flowers;

		Double(boolean flowers, EnumDyeColor c) {
			color = c;
			this.flowers = flowers;
		}

		Double(boolean flowers) {
			this(flowers, EnumDyeColor.WHITE);
		}

		@Override
		public EnumDyeColor getColor() {
			return color;
		}

		@Override
		public int getPredicateIndex() {
			return this.ordinal() / 8;
		}

		@Override
		public boolean useForRecipes() {
			return true;
		}

		@Override
		public int getMetadata() {
			return this.ordinal() % 8;
		}

		@Override
		public boolean hasFlowers() {
			return flowers;
		}

	}

	public static enum Generic implements IPropertyEnum {
		COTTON,
		DYE_BLACK,
		DYE_BLUE,
		DYE_BROWN,
		DYE_WHITE
	}

	public static enum Vines implements IPropertyEnum {
		ADLUMIA_F,
		AFGEKIA_M,
		ANDROSACE_A,
		AKEBIA_Q,
		AMPELOPSIS_A
	}

	public static enum Crops implements IPropertyEnum {
		AMARANTHUS_H,
		OKRA,
		PINEAPPLE,;

		@Override
		public int getPredicateIndex() {
			return this.ordinal() / 2;
		}

	}

	public static enum BushSet implements IPropertyEnum, IPostInitUpdate {
		BLACKBERRY("plants2:blackberry"),
		BLUEBERRY("plants2:blueberry"),
		DECIDUOUS(""),
		EVERGREEN(""),
		HUCKLEBERRY("plants2:huckleberry"),
		RASPBERRY("plants2:raspberry");

		private StackPrimer primer;
		private String dropName;

		BushSet(String dropName) {
			this.dropName = dropName;
			if (dropName.equals(""))
				this.dropName = "minecraft:air";
			Constants.UPDATES.add(this);
		}

		public StackPrimer getHarvest() {
			return primer;
		}

		private void setItem(Item item) {
			primer = new StackPrimer(item);
		}

		@Override
		public void postInit(FMLPostInitializationEvent e) {
			this.setItem(ForgeRegistries.ITEMS.getValue(new ResourceLocation(dropName)));
		}

	}

}
