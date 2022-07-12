package com.mcloude.main;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import com.mcloude.main.gui.Creategui;
import com.mcloude.main.gui.Inventory;
import com.mcloude.main.npcdata.Npcdata;

public class Main extends JavaPlugin implements Listener {

	public String prefix = this.getConfig().getString("설정.접두사");
	static Main plugin;

	public Ngui Ngui;
	public Createconfig cfgs;
	public Events eventlist;
	public VersionCheck versioncheck;
	public Creategui cgui;
	public Npcdata ndata;

	@Override
	public void onEnable() {

		plugin = this;
		
		versioncheck = new VersionCheck(this);
		cfgs = new Createconfig(this);
		Ngui = new Ngui(this);
		eventlist = new Events(this);
		cgui = new Creategui(this);
		ndata = new Npcdata(this);

		cfgs.start();
		versioncheck.start();
		
		

		getServer().getPluginManager().registerEvents(new Events(this), this);
		getServer().getPluginManager().registerEvents(new Inventory(this), this);
		getServer().getPluginManager().registerEvents(new Creategui(this), this);
		
		getCommand("ngui").setExecutor(new Ngui(this));

	}

}
