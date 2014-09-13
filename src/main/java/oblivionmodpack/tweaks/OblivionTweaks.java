package oblivionmodpack.tweaks;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import oblivionmodpack.tweaks.init.OblivionTweaksItems;
import oblivionmodpack.tweaks.proxy.IProxy;
import oblivionmodpack.tweaks.utility.LogHelper;

/*@author ViolentNinjaD

  Licensed under LGPL V3

*/
@Mod(modid = OblivionTweaks.MOD_ID, name = OblivionTweaks.MOD_NAME, version = OblivionTweaks.MOD_VERSION)
public class OblivionTweaks 
{
    public static final String MOD_ID = "OblivionTweaks";
    public static final String MOD_NAME = "Oblivion Tweaks";
    public static final String MOD_VERSION = "1.7.10";

    @Mod.Instance
    public static OblivionTweaks instance;

    @SidedProxy(clientSide = "oblivionmodpack.tweaks.proxy.ClientProxy", serverSide = "oblivionmodpack.tweaks.proxy.ServerProxy")
    public static IProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        LogHelper.info("Pre-init has begun!");
        OblivionTweaksItems.init();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        LogHelper.info("Init has begun!");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        LogHelper.info("Post-init has begun!");
    }
}
