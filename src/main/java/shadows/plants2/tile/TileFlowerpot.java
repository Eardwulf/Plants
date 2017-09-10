package shadows.plants2.tile;

import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntityFlowerPot;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import shadows.plants2.data.enums.TheBigBookOfEnums.FlowerpotPlants;

public class TileFlowerpot extends TileEntityFlowerPot {

	public static final PropertyEnum<FlowerpotPlants> PROPERTY = PropertyEnum.create("type", FlowerpotPlants.class);

	private FlowerpotPlants flower = FlowerpotPlants.NONE;
	private ItemStack stack = ItemStack.EMPTY;

	@Override
	public void readFromNBT(NBTTagCompound tag) {
		super.readFromNBT(tag);
		flower = FlowerpotPlants.values()[tag.getInteger("flower")];
		stack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(tag.getString("item"))), 1, tag.getInteger("meta"));
		NBTTagCompound nTag = tag.getCompoundTag("stack_nbt");
		if (nTag.getSize() != 0) stack.setTagCompound(nTag);
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound tag) {
		super.writeToNBT(tag);
		tag.setInteger("flower", flower.ordinal());
		tag.setString("item", stack.getItem().getRegistryName().toString());
		tag.setInteger("meta", stack.getMetadata());
		tag.setTag("stack_nbt", stack.getTagCompound() == null ? new NBTTagCompound() : stack.getTagCompound());
		return tag;
	}

	public FlowerpotPlants getFlower() {
		return flower;
	}

	public void setFlower(FlowerpotPlants flower) {
		this.flower = flower;
	}

	@Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) {
		readFromNBT(pkt.getNbtCompound());
	}

	@Override
	public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newState) {
		return oldState.getBlock() != newState.getBlock();
	}

	@Override
	public ItemStack getFlowerItemStack() {
		return stack.copy();
	}

	@Override
	public Item getFlowerPotItem() {
		return stack.getItem();
	}

	@Override
	public int getFlowerPotData() {
		return stack.getMetadata();
	}

	@Override
	public void setItemStack(ItemStack stack) {
		this.stack = stack.copy();
	}

	@Override
	public SPacketUpdateTileEntity getUpdatePacket() {
		return new SPacketUpdateTileEntity(this.pos, 150, this.getUpdateTag());
	}

}
