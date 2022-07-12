package com.mcloude.main;

import java.io.File;


public class Createconfig extends Thread {

	Main plugin;

	public Createconfig(Main plugin) {

		this.plugin = plugin;

	}

	public void run() {
		

		plugin.saveConfig();
		File cfile = new File(plugin.getDataFolder(), "config.yml");

		if (cfile.length() == 0) {
			plugin.getConfig().options().copyDefaults(true);
			plugin.saveConfig();

		}

	}

}
