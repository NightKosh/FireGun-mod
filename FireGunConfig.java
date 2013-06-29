
package FireGun;

import java.io.File;
import net.minecraftforge.common.Configuration;

/**
 * FireGun mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class FireGunConfig {
    
    public static int fireGunId;
    private static FireGunConfig instance;
    
    
    private FireGunConfig(File configFile) {
        getConfigs(new Configuration(configFile));
    }

    public static FireGunConfig getInstance(File configFile) {
        if (instance == null) {
            return new FireGunConfig(configFile);
        } else {
            return instance;
        }
    }

    public final void getConfigs(Configuration config) {
        config.load();

        fireGunId = config.getItem("FireGun", 8889 - 256).getInt();

        config.save();
    }

}
