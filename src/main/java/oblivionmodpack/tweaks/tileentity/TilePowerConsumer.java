package oblivionmodpack.tweaks.tileentity;

import cofh.api.energy.EnergyStorage;
import cofh.api.energy.IEnergyHandler;
import ic2.api.energy.event.EnergyTileLoadEvent;
import ic2.api.energy.event.EnergyTileUnloadEvent;
import ic2.api.energy.tile.IEnergySink;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.ForgeDirection;

/*@author ViolentNinjaD

  Licensed under LGPL V3

*/
public class TilePowerConsumer extends TileOblivionTweaks implements IEnergyHandler, IEnergySink
{
    private EnergyStorage energyStorage = new EnergyStorage(10000);
    private boolean ic2registered = false;
    private int RFRecieve;

    public TilePowerConsumer()
    {

    }

    @Override
    public void writeToNBT(NBTTagCompound nbt)
    {
        super.writeToNBT(nbt);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt)
    {
        super.readFromNBT(nbt);
    }

    @Override
    public void updateEntity()
    {
        super.updateEntity();
        if (!ic2registered)
        {
            MinecraftForge.EVENT_BUS.post(new EnergyTileLoadEvent(this));
            ic2registered = true;
        }
    }

    //Redstone Flux Compatibility Code
    @Override
	public int receiveEnergy(ForgeDirection forgeDirection, int i, boolean b)
    {
        RFRecieve = this.energyStorage.receiveEnergy(i, b);
        return this.energyStorage.receiveEnergy(i, b);
	}

	@Override
	public int extractEnergy(ForgeDirection forgeDirection, int i, boolean b)
    {
		return 0;
	}

	@Override
	public int getEnergyStored(ForgeDirection forgeDirection)
    {
		return energyStorage.getEnergyStored();
    }

	@Override
	public int getMaxEnergyStored(ForgeDirection forgeDirection) {
		return 10000;
	}

	@Override
	public boolean canConnectEnergy(ForgeDirection forgeDirection)
    {
		return true;
    }

    //EU Compatibility Code
    public static final int RF_EU = 4;

    @Override
    public void invalidate()
    {
        if (ic2registered) {
            MinecraftForge.EVENT_BUS.post(new EnergyTileUnloadEvent(this));
            ic2registered = false;
        }
        super.invalidate();
    }

    @Override
    public void onChunkUnload()
    {
        if (ic2registered) {
            MinecraftForge.EVENT_BUS.post(new EnergyTileUnloadEvent(this));
            ic2registered = false;
        }
        super.onChunkUnload();
    }

    @Override
    public double getDemandedEnergy()
    {
        return RFRecieve / RF_EU;
    }

    @Override
    public int getSinkTier()
    {
        return 2;
    }

    @Override
    public double injectEnergy(ForgeDirection forgeDirection, double v, double v2)
    {
        return RFRecieve / RF_EU;
    }

    @Override
    public boolean acceptsEnergyFrom(TileEntity tileEntity, ForgeDirection forgeDirection)
    {
        return true;
    }
}
