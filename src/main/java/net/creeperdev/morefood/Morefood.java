package net.creeperdev.morefood;

import net.fabricmc.api.ModInitializer;


public class Morefood implements ModInitializer {


    @Override
    public void onInitialize() {

        System.out.println("[Morefood] Initializing MoreFood by TheCreeper3326");
        ModItems.initialize();

    }

}
