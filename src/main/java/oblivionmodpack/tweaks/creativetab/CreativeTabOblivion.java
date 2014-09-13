package oblivionmodpack.tweaks.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import oblivionmodpack.tweaks.OblivionTweaks;
import oblivionmodpack.tweaks.init.OblivionTweaksItems;

/*@author ViolentNinjaD

  Licensed under LGPL V3

*/
public class CreativeTabOblivion 
{
    public static final CreativeTabs TAB_MAIN = new CreativeTabs("oblivionMain")
    {
        @Override
        public Item getTabIconItem()
        {
            return OblivionTweaksItems.eggpersonEgg;
        }
    };
}
