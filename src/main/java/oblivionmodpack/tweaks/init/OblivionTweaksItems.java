package oblivionmodpack.tweaks.init;

import cpw.mods.fml.common.registry.GameRegistry;
import oblivionmodpack.tweaks.item.ItemEggpersonEgg;
import oblivionmodpack.tweaks.item.ItemOblivion;
import oblivionmodpack.tweaks.item.ItemRustyIngot;
import oblivionmodpack.tweaks.item.ItemRustyTap;
import oblivionmodpack.tweaks.reference.Names;

/*@author ViolentNinjaD

  Licensed under LGPL V3

*/
public class OblivionTweaksItems 
{
    public static final ItemOblivion eggpersonEgg = new ItemEggpersonEgg();
    public static final ItemOblivion rustyIngot = new ItemRustyIngot();
    public static final ItemOblivion rustyTap = new ItemRustyTap();

    public static void init()
    {
        GameRegistry.registerItem(eggpersonEgg, Names.Items.EGGPERSON_EGG);
        GameRegistry.registerItem(rustyIngot, Names.Items.RUSTY_INGOT);
        GameRegistry.registerItem(rustyTap, Names.Items.RUSTY_TAP);
    }
}
