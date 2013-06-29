
package FireGun;

import FireGun.item.ItemFireGun;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * FireGun mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
@Mod(modid = "FireGun", name = "FireGun", version = "1.0.0")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class FireGunMod {

    @Instance("FireGunMod")
    public static FireGunMod instance;
    @SidedProxy(clientSide = "FireGun.client.ClientProxy", serverSide = "FireGun.CommonProxy")
    public static CommonProxy proxy;
    public static Item fireGun;

    public FireGunMod() {
        instance = this;
    }

    @PreInit
    public void preInit(FMLPreInitializationEvent event) {
        FireGunConfig.getInstance(event.getModConfigurationDirectory().getAbsoluteFile());
    }

    @Init
    public void load(FMLInitializationEvent event) {

        // create fireGun
        fireGun = new ItemFireGun(FireGunConfig.fireGunId);
        LanguageRegistry.addName(fireGun, "Fire Gun");

        // reciep
        GameRegistry.addRecipe(new ItemStack(fireGun), "dDD", "ooo", " bi", 'd', Block.dispenser, 'D', Item.diamond, 'o', Block.obsidian, 'b', Block.stoneButton, 'i', Item.ingotIron);
    }

    @Mod.PostInit
    public void postInit(FMLPostInitializationEvent event) {
    }
}
