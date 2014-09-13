package oblivionmodpack.tweaks.net;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;
import oblivionmodpack.tweaks.OblivionTweaks;
import oblivionmodpack.tweaks.net.message.MessageTileOblivionTweaks;

/*@author ViolentNinjaD

  Licensed under LGPL V3

*/
public class PacketHandler 
{
    public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(OblivionTweaks.MOD_ID.toLowerCase());

    public static void init()
    {
        INSTANCE.registerMessage(MessageTileOblivionTweaks.class, MessageTileOblivionTweaks.class, 0, Side.CLIENT);
    }
}
