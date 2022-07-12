package com.mcloude.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;


public class VersionCheck extends Thread {
	
	
	Main plugin;
		
	
	public VersionCheck(Main plugin) {
		
		this.plugin = plugin;
		
	}

	public void run () {
		
		String version = Bukkit.getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3];
        int SerVersion = Integer.parseInt(version.replace("v1_", "").replaceAll("_R\\d", ""));
		
        
        if ((SerVersion == 18)) {
        	
        	if (plugin.getServer().getPluginManager().getPlugin("PlayerNPC") != null) {

    			Bukkit.getConsoleSender().sendMessage("");
    			Bukkit.getConsoleSender().sendMessage(plugin.prefix + "플러그인이 활성화 되었습니다. 버전:" + plugin.getDescription().getVersion());
    			Bukkit.getConsoleSender().sendMessage(" 이 플러그인은 1.18-1.18.2버젼을 권장합니다. ");
    			Bukkit.getConsoleSender().sendMessage("");
    			
    			Ngui.npcloc.add(0, plugin.getConfig().getDouble("설정.좌표.엑스"));
    			Ngui.npcloc.add(1, plugin.getConfig().getDouble("설정.좌표.와이"));
    			Ngui.npcloc.add(2, plugin.getConfig().getDouble("설정.좌표.제트"));
    			

    			return;

    		} else {

    			Bukkit.getConsoleSender().sendMessage(plugin.prefix + "필수 플러그인이 적용되어 있지 않아 종료됩니다.");
    			Bukkit.getPluginManager().disablePlugin((Plugin) this);

    		}
        	
        } else {
        	
        	Bukkit.getConsoleSender().sendMessage(plugin.prefix + "버킷 버전이 1.18 보다 낮습니다. 비활성화 됩니다.");
        	Bukkit.getPluginManager().disablePlugin((Plugin) this);
        	
        }
        
		/*
		String bukkitv = plugin.getServer().getBukkitVersion();
		
		Bukkit.getConsoleSender().sendMessage("버킷 버전:" + bukkitv);
		*/
		
		
	}


}
