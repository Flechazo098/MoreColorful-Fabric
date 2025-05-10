package com.ChalkerCharles.morecolorful.client.compat.modmenu;

import com.ChalkerCharles.morecolorful.Config;
import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import me.shedaniel.autoconfig.AutoConfig;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class ModMenuIntegration implements ModMenuApi {

    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory () {
        return parent -> AutoConfig.getConfigScreen(Config.ModConfig.class, parent).get();
    }
}
