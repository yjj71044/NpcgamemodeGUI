package com.mcloude.main.gui;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;

import com.mcloude.main.Main;
import com.mcloude.main.Ngui;

import dev.sergiferry.playernpc.api.NPC;
import dev.sergiferry.playernpc.api.NPCLib;

public class Inventory implements Listener {

	private Main plugin;

	public Inventory(Main plugin) {

		this.plugin = plugin;

	}

	@EventHandler
	public void InventoryClickEvent(org.bukkit.event.inventory.InventoryClickEvent event) {
		if (event.getView().getTitle().equalsIgnoreCase(plugin.prefix + "게임모드")) {
			Player p = (Player) event.getWhoClicked();
			// p.sendMessage("ClickType: " + event.getClick() + "Name: " +
			// p.getDisplayName() + "아이템: "
			// + event.getCurrentItem().getItemMeta().getDisplayName());
			event.setCancelled(true);

			if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§f서바이벌")) {

				p.setGameMode(GameMode.SURVIVAL);
				p.sendMessage(plugin.prefix + "성공적으로 게임모드가 변경되었습니다.");

			} else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§f크리에이트브")) {

				p.setGameMode(GameMode.CREATIVE);
				p.sendMessage(plugin.prefix + "성공적으로 게임모드가 변경되었습니다.");

			} else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§f어드벤처")) {

				p.setGameMode(GameMode.ADVENTURE);
				p.sendMessage(plugin.prefix + "성공적으로 게임모드가 변경되었습니다.");

			} else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§f관전")) {

				p.setGameMode(GameMode.SPECTATOR);
				p.sendMessage(plugin.prefix + "성공적으로 게임모드가 변경되었습니다.");

			}
		}

	}

	@EventHandler
	public void InventoryOpen(InventoryOpenEvent event) {

		Player p = (Player) event.getPlayer();

		p.sendMessage("값: " + event.getView().getTitle());

		if (event.getView().getTitle().equals(plugin.prefix + "게임모드")) {

			p.sendMessage(plugin.prefix + "인벤토리를 오픈했구나!");

		}

	}

	@EventHandler
	public void InventoryClose(InventoryCloseEvent event) {

		Player p = (Player) event.getPlayer();

		if (event.getView().getTitle().equals(plugin.prefix + "게임모드")) {

			p.sendMessage(plugin.prefix + "창을 닫았구나!");

			Location location = new Location(p.getWorld(), Ngui.npcloc.get(0), Ngui.npcloc.get(1), Ngui.npcloc.get(2));
			NPC npc = NPCLib.getInstance().generateGlobalNPC(plugin, "1", location);

			npc.setText(plugin.prefix + "§6게임모드 관리자", "§b§lRight Click");
			NPCLib.getInstance().getGlobalNPC(plugin, "1").setGlowing(false);
			NPCLib.getInstance().getGlobalNPC(plugin, "1").updateText(p);
			NPCLib.getInstance().getGlobalNPC(plugin, "1").forceUpdate(p);

		}

	}

}
