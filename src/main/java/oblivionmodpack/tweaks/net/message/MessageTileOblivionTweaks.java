package oblivionmodpack.tweaks.net.message;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.tileentity.TileEntity;
import oblivionmodpack.tweaks.tileentity.TileOblivionTweaks;

/*@author ViolentNinjaD

  Licensed under LGPL V3

*/
public class MessageTileOblivionTweaks implements IMessage, IMessageHandler<MessageTileOblivionTweaks, IMessage>
{
    public int x, y, z;
    public byte orientation, state;
    public String customName, owner;

    public MessageTileOblivionTweaks()
    {

    }

    public MessageTileOblivionTweaks(TileOblivionTweaks tileOblivionTweaks)
    {
        this.x = tileOblivionTweaks.xCoord;
        this.y = tileOblivionTweaks.yCoord;
        this.z = tileOblivionTweaks.zCoord;
        this.orientation = (byte) tileOblivionTweaks.getOrientation().ordinal();
        this.state = (byte) tileOblivionTweaks.getState();
        this.customName = tileOblivionTweaks.getCustomName();
        this.owner = tileOblivionTweaks.getOwner();
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        this.x = buf.readInt();
        this.y = buf.readInt();
        this.z = buf.readInt();
        this.orientation = buf.readByte();
        this.state = buf.readByte();
        int customNameLength = buf.readInt();
        this.customName = new String(buf.readBytes(customNameLength).array());
        int ownerLength = buf.readInt();
        this.owner = new String(buf.readBytes(ownerLength).array());
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        buf.writeInt(x);
        buf.writeInt(y);
        buf.writeInt(z);
        buf.writeByte(orientation);
        buf.writeByte(state);
        buf.writeInt(customName.length());
        buf.writeBytes(customName.getBytes());
        buf.writeInt(owner.length());
        buf.writeBytes(owner.getBytes());
    }

    @Override
    public IMessage onMessage(MessageTileOblivionTweaks message, MessageContext ctx)
    {
        TileEntity tileEntity = FMLClientHandler.instance().getClient().theWorld.getTileEntity(message.x, message.y, message.z);

        if (tileEntity instanceof TileOblivionTweaks)
        {
            ((TileOblivionTweaks) tileEntity).setOrientation(message.orientation);
            ((TileOblivionTweaks) tileEntity).setState(message.state);
            ((TileOblivionTweaks) tileEntity).setCustomName(message.customName);
            ((TileOblivionTweaks) tileEntity).setOwner(message.owner);
        }

        return null;
    }

    @Override
    public String toString()
    {
        return String.format("MessageTileOblivionTweaks - x:%s, y:%s, z:%s, orientation:%s, state:%s, customName:%s, owner:%s", x, y, z, orientation, state, customName, owner);
    }
}
