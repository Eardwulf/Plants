package shadows.plants2.block;

import net.minecraft.block.BlockStairs;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent.Register;
import shadows.placebo.Placebo;
import shadows.placebo.block.IEnumBlockAccess;
import shadows.placebo.client.IHasModel;
import shadows.placebo.interfaces.IHasRecipe;
import shadows.placebo.interfaces.IItemBlock;
import shadows.placebo.interfaces.IPlankEnum;
import shadows.placebo.itemblock.ItemBlockBase;
import shadows.placebo.util.PlaceboUtil;
import shadows.plants2.Plants2;

public class BlockEnumStairs extends BlockStairs implements IHasModel, IHasRecipe, IItemBlock {

	IPlankEnum e;

	public <T extends IPlankEnum> BlockEnumStairs(T e, IEnumBlockAccess<T> block) {
		super(block.getStateFor(e));
		setRegistryName(e.getName() + "_stairs");
		setUnlocalizedName(Plants2.INFO.getID() + "." + e.getName() + "_stairs");
		setCreativeTab(Plants2.INFO.getDefaultTab());
		Plants2.INFO.getBlockList().add(this);
		ItemBlock ib = createItemBlock();
		if (ib != null) Plants2.INFO.getItemList().add(ib);
		this.e = e;
	}

	@Override
	public ItemBlock createItemBlock() {
		return new ItemBlockBase(this);
	}

	@Override
	public void initRecipes(Register<IRecipe> ev) {
		Ingredient i = Ingredient.fromStacks(e.get());
		Plants2.HELPER.addShaped(new ItemStack(this, 4), 3, 3, i, null, null, i, i, null, i, i, i);
	}

	@Override
	public void initModels(ModelRegistryEvent e) {
		PlaceboUtil.sMRL("stairs/" + getRegistryName().getResourcePath(), this, 0, "facing=south,half=bottom,shape=straight");
		Placebo.PROXY.useRenamedMapper(this, "stairs/" + getRegistryName().getResourcePath());
	}
	
	@Override
	public String getUnlocalizedName() {
		return "tile.plants2.stairs." + e.getName();
	}

}
