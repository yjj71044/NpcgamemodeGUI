package com.mcloude.main.npcdata;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.mcloude.main.Main;
import com.mcloude.main.Ngui;

import dev.sergiferry.playernpc.api.NPC;
import dev.sergiferry.playernpc.api.NPCLib;
import dev.sergiferry.playernpc.api.NPC.FollowLookType;
import dev.sergiferry.playernpc.api.NPC.Slot;

public class Npcdata extends Thread{
	
	Main plugin;
	
	
	
	public Npcdata(Main plugin) {
		
		this.plugin = plugin;
		
		
	}



	@SuppressWarnings("static-access")
	public void Npc(Player player) {
		
		
		Location location = new Location(player.getWorld(), Ngui.npcloc.get(0), Ngui.npcloc.get(1),
				 Ngui.npcloc.get(2));
		NPC npc = NPCLib.getInstance().generateGlobalNPC(plugin, "1", location);
		npc.lookAt(player);
		npc.setText(plugin.prefix + "§6게임모드 관리자", "§b§lRight Click");
		npc.setFollowLookType(FollowLookType.PLAYER);
		npc.setItem(Slot.MAINHAND, new ItemStack(Material.COMPASS));
		npc.setSkin(
				"eyJ0aW1lc3RhbXAiOjE1NTk4NTY2MDY0NzgsInByb2ZpbGVJZCI6IjgyYzYwNmM1YzY1MjRiNzk4YjkxYTEyZDNhNjE2OTc3IiwicHJvZmlsZU5hbWUiOiJOb3ROb3RvcmlvdXNOZW1vIiwic2lnbmF0dXJlUmVxdWlyZWQiOnRydWUsInRleHR1cmVzIjp7IlNLSU4iOnsidXJsIjoiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS9iNWE5MmEzMGExZjYxYjFkZmNhNjI0ZGU5ODc4YTkxYTI2OTYwNGVhMzA2ODJkMGIyMzExNWU5NDdjOTViZTg2In19fQ==",
				"JyjGNbCLjLgupeW3qWF+LKiMt4r066gF4fdwm3LByaY/gz2PDiE6zT4RQ/J9jb17q9DB6cENVsGLazC/ICEk09iWr20R0AbipYbEAkYz1rzT6I7CDlYD0fhJ6lLXpKKKcwAvA9vUl3MueQ2FH0NRpZSVT7selHXi+A33WESmSdDpFShHkxC1R0d8+iUou68nFauIfhDWqxb0ocL3HVsTZl75RDtNgJF3kVwSwBaInovjt8EpCuZXVsM8zPS5y7eQdd1w+VH/c1wMJxB7aPaKElYY0ne4xYKsYtGQGoaVPKFWRTwsEy0FrNg/TCXVqVOaIdZeJqBu4ynzS5SXGZChUlD9YbQYcmrrUWvcYhVnf0KZycGwkT+sDzjpNrkKj0W3UpsRdl607gGVtzDHvdyakCIqVL9dVDIhMjnYyQ+Dx8LXqKIpGynXG/dAYxnOQZKGLCpfT1oXEWcY4dlOm8kUzepw9JP1mS1Vff9UQwv5lmy0CNW6EI4Xj50kGx1FEmxnymltVVda9kmXxWKGH9SepKwlNWH5IZho08i1Na5FxT3gxdE3cw7wMASrVn7UD+EG0LEsnzMjlMEQS7W3lQ/BywH9CRY/R/PC0HNeHfoMHZ3rRRYKvnIlleuC+e8Z8ISRIS9TRd5K1cUB7eG3GEyQY+XW1TDB1YfJkPuYht82OLc=");
		
		npc.getNPCLib().getInstance().getGlobalNPC(plugin, "1").update();
		npc.getNPCLib().getInstance().getGlobalNPC(plugin, "1").updateText();
		npc.getNPCLib().getInstance().getGlobalNPC(plugin, "1").forceUpdate();
		npc.getNPCLib().getInstance().getGlobalNPC(plugin, "1").update(player);
		npc.getNPCLib().getInstance().getGlobalNPC(plugin, "1").updateText(player);
		npc.getNPCLib().getInstance().getGlobalNPC(plugin, "1").forceUpdate(player);
		npc.getNPCLib().getGlobalNPC(plugin, "1").forceUpdate(player);
		npc.getNPCLib().getInstance().getGlobalNPC(plugin, "1").show(player);
		//npc.getNPCLib().getGlobalNPC(plugin, "1").update();
		//npc.getNPCLib().getGlobalNPC(plugin, "1").update(player);
		
	}

	
	
	
	
	

}
