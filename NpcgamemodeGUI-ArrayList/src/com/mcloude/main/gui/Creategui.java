package com.mcloude.main.gui;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.mcloude.main.Main;

public class Creategui implements Listener{
	
	private Main plugin;
	
	int inv_total = 1;
	int totalinv = inv_total *9;
	
	
	public Creategui(Main plugin) {
		
		this.plugin = plugin;
		
		
	}
	
	public void itemset(String display, List<String> Lore, Material m, int amout, int slot, Inventory inv) {
		
		
		ItemStack item = new ItemStack(m, amout);
		ItemMeta items = item.getItemMeta();
		items.setDisplayName(display);
		if(Lore != null) items.setLore(Lore);
		item.setItemMeta(items);
		inv.setItem(slot, item);
	}



	public void open(Player p) {
		
		org.bukkit.inventory.Inventory inv = Bukkit.createInventory(null, totalinv , plugin.prefix + "게임모드");
		
		itemset("§f서바이벌", Arrays.asList("", "§f클릭 시 게임모드를 §c§l서바이벌§f로 변경합니다!"), Material.IRON_SWORD, 1, 1, inv);
		itemset("§f크리에이트브", Arrays.asList("", "§f클릭 시 게임모드를 §b§l크리에이티브§f로 변경합니다!", ""), Material.BRICKS, 1, 3, inv);
		itemset("§f어드벤처", Arrays.asList("", "§f클릭 시 게임모드를 §6§l어드벤처§f로 변경합니다!", ""), Material.RABBIT_STEW, 1, 5, inv);
		itemset("§f관전", Arrays.asList("", "§f클릭 시 게임모드를 §2§l관전모드§f로 변경합니다!", ""), Material.COMPASS, 1, 7, inv);
		p.openInventory(inv);
		
		
		
	}

}
