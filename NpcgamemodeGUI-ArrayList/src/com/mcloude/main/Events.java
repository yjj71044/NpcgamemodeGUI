package com.mcloude.main;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

import com.mcloude.main.gui.Creategui;

import dev.sergiferry.playernpc.api.NPC;
import dev.sergiferry.playernpc.api.NPCLib;
import dev.sergiferry.playernpc.api.NPC.Slot;

public class Events implements Listener {

	Main plugin;

	public Events(Main plugin) {

		this.plugin = plugin;

	}

	@SuppressWarnings("static-access")
	@EventHandler
	public void NpcInteract(NPC.Events.Interact event) {

		Player player = event.getPlayer();
		NPC npc = event.getNPC();
		NPC.Interact.ClickType clickType = event.getClickType();

		// npc.isShowOnTabList();

		if (npc.getCode().equalsIgnoreCase("npcgamemodegui.global_1")) {
			if (clickType.isRightClick()) {
				
				event.getPlayer().getWorld().playSound(player, Sound.BLOCK_CHAIN_PLACE, 0.6F, 0.5F);
				
				Creategui gui = new Creategui(plugin);
				
				gui.open(player);

				npc.getNPCLib().getGlobalNPC(plugin, "1").setText(plugin.prefix + "§c관리자§f카인", "§c창이 오픈되었습니다.");

				npc.getNPCLib().getInstance().getGlobalNPC(plugin, "1").setGlowingColor(ChatColor.AQUA);
				;
				npc.getNPCLib().getInstance().getGlobalNPC(plugin, "1").setGlowing(true);
				// npc.getNPCLib().getInstance().getGlobalNPC(plugin,
				// "1").setCustomTabListName("XD");
				npc.getNPCLib().getInstance().getGlobalNPC(plugin, "1").setShowOnTabList(true);
				/*player.sendMessage("NPC TEXT : " + npc.getText(), "\n NPC ID " + npc.getCode() + "\n탭리스트 이름: "
						+ npc.getNPCLib().getGlobalNPC(plugin, "1").getCustomTabListName()); */

				ItemStack bricks = new ItemStack(Material.DIAMOND);

				npc.setItem(Slot.OFFHAND, bricks);
				npc.getNPCLib().getInstance().getGlobalNPC(plugin, "1").update();
				npc.getNPCLib().getInstance().getGlobalNPC(plugin, "1").update(player);
				npc.getNPCLib().getInstance().getGlobalNPC(plugin, "1").forceUpdate();
				npc.getNPCLib().getInstance().getGlobalNPC(plugin, "1").forceUpdate(player);
				// npc.getNPCLib().getPersonalNPCs(player, player.getWorld())
				// npc.getAttributes().applyNPC(npc.getNPCLib().getPersonalNPCs(player, plugin),
				// isEnabled());

			}

		}

	}

	@SuppressWarnings("static-access")
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {

		Player p = event.getPlayer();
		Player player = event.getPlayer();

		if (Ngui.npcloc.size() > 0) {

			Location location = new Location(player.getWorld(), Ngui.npcloc.get(0), Ngui.npcloc.get(1),
					Ngui.npcloc.get(2));
			NPC npc = NPCLib.getInstance().generateGlobalNPC(plugin, "1", location);
			
			npc.setSkin(
					"eyJ0aW1lc3RhbXAiOjE1NTk4NTY2MDY0NzgsInByb2ZpbGVJZCI6IjgyYzYwNmM1YzY1MjRiNzk4YjkxYTEyZDNhNjE2OTc3IiwicHJvZmlsZU5hbWUiOiJOb3ROb3RvcmlvdXNOZW1vIiwic2lnbmF0dXJlUmVxdWlyZWQiOnRydWUsInRleHR1cmVzIjp7IlNLSU4iOnsidXJsIjoiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS9iNWE5MmEzMGExZjYxYjFkZmNhNjI0ZGU5ODc4YTkxYTI2OTYwNGVhMzA2ODJkMGIyMzExNWU5NDdjOTViZTg2In19fQ==",
					"JyjGNbCLjLgupeW3qWF+LKiMt4r066gF4fdwm3LByaY/gz2PDiE6zT4RQ/J9jb17q9DB6cENVsGLazC/ICEk09iWr20R0AbipYbEAkYz1rzT6I7CDlYD0fhJ6lLXpKKKcwAvA9vUl3MueQ2FH0NRpZSVT7selHXi+A33WESmSdDpFShHkxC1R0d8+iUou68nFauIfhDWqxb0ocL3HVsTZl75RDtNgJF3kVwSwBaInovjt8EpCuZXVsM8zPS5y7eQdd1w+VH/c1wMJxB7aPaKElYY0ne4xYKsYtGQGoaVPKFWRTwsEy0FrNg/TCXVqVOaIdZeJqBu4ynzS5SXGZChUlD9YbQYcmrrUWvcYhVnf0KZycGwkT+sDzjpNrkKj0W3UpsRdl607gGVtzDHvdyakCIqVL9dVDIhMjnYyQ+Dx8LXqKIpGynXG/dAYxnOQZKGLCpfT1oXEWcY4dlOm8kUzepw9JP1mS1Vff9UQwv5lmy0CNW6EI4Xj50kGx1FEmxnymltVVda9kmXxWKGH9SepKwlNWH5IZho08i1Na5FxT3gxdE3cw7wMASrVn7UD+EG0LEsnzMjlMEQS7W3lQ/BywH9CRY/R/PC0HNeHfoMHZ3rRRYKvnIlleuC+e8Z8ISRIS9TRd5K1cUB7eG3GEyQY+XW1TDB1YfJkPuYht82OLc=");
			
			
			plugin.ndata.Npc(player);

			return;

		} else {

			p.sendMessage(plugin.prefix + "현재 NPC의 좌표가 설정되어있지 앟습니다.");

		}

	}

}
