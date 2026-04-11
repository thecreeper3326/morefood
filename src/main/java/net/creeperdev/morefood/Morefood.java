package net.creeperdev.morefood;

import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Morefood implements ModInitializer {
    public Logger LOGGER = LogManager.getLogger("MoreFood");

    @Override
    public void onInitialize() {
        LOGGER.info("Initializing MoreFood");
        ModItems.initialize();
        LOGGER.info("Done");


    }

}
