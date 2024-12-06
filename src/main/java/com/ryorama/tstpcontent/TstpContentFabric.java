package com.ryorama.tstpcontent;

import com.smushytaco.solar_apocalypse.SolarApocalypse;
import com.smushytaco.solar_apocalypse.WorldDayCalculation;
import mod.lwhrvw.astrocraft.Astrocraft;
import mod.lwhrvw.astrocraft.Planet;
import mod.lwhrvw.astrocraft.config.AstrocraftConfig;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;

public class TstpContentFabric implements ModInitializer {

    public static String MOD_ID = "tstp-content-fabric";
    @Override
    public void onInitialize() {
        ServerTickEvents.START_WORLD_TICK.register(world -> {
            if (WorldDayCalculation.INSTANCE.isOldEnough(world.getLevel(), SolarApocalypse.INSTANCE.getConfig().getPhaseOneDay())) {
                Astrocraft.CONFIG.sunAppearance = new AstrocraftConfig.ConfigurablePlanet.Appearance(4.83, Planet.Texture.SUN, false, new AstrocraftConfig.Color(212, 212, 85, 1.0F), 3481750 * SolarApocalypse.INSTANCE.getConfig().getPhaseOneSunSizeMultiplier(),null);
            } else if (WorldDayCalculation.INSTANCE.isOldEnough(world.getLevel(), SolarApocalypse.INSTANCE.getConfig().getPhaseOneDay())) {
                Astrocraft.CONFIG.sunAppearance = new AstrocraftConfig.ConfigurablePlanet.Appearance(4.83, Planet.Texture.SUN, false, new AstrocraftConfig.Color(212, 212, 85, 1.0F), 3481750 * SolarApocalypse.INSTANCE.getConfig().getPhaseTwoSunSizeMultiplier(),null);
            } else {
                Astrocraft.CONFIG.sunAppearance = new AstrocraftConfig.ConfigurablePlanet.Appearance(4.83, Planet.Texture.SUN, false, new AstrocraftConfig.Color(212, 212, 85, 1.0F), 3481750,null);
            }
        });
    }
}