package net.wjka.dnm;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.wjka.dnm.item.ModdedItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DungeonsandMinecraft implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MOD_ID = "dungeons_and_minecraft"; //MOD ID String. DON'T EDIT

    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


	@Override
	public void onInitialize() { //similiar to main(); -> entry point for fabric
		ModdedItems.InitRegisterItems(); //Registring of all Items will be done via this method!
		CommandRegistrationCallback.EVENT.register((dispatcher, dedicated, registryAccess) -> { //custom command registration
			CommandClass.register(dispatcher);
		});
		//register another command here too


		LOGGER.info("hi mum, i made a fabric mod :3");
	}
}