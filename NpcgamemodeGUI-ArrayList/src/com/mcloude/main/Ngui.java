package com.mcloude.main;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import dev.sergiferry.playernpc.api.NPC;
import dev.sergiferry.playernpc.api.NPC.FollowLookType;
import dev.sergiferry.playernpc.api.NPC.Slot;
import dev.sergiferry.playernpc.api.NPCLib;

public class Ngui implements CommandExecutor {

	// public Main plugin;

	public static ArrayList<Double> npcloc = new ArrayList<>();
	ArrayList<String> check = new ArrayList<>();
	
	//boolean 활성화 = false;
	
	Main plugin;

	public Ngui(Main plugin) {

		this.plugin = plugin;

	}

	@SuppressWarnings({ "static-access" })
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
		// TODO Auto-generated method stub

		if (!(sender instanceof Player)) {

			Bukkit.getConsoleSender().sendMessage(plugin.prefix + "플레이어만 명령어를 사용할 수 있습니다.");

			return false;

		}

		Player player = (Player) sender;
		
		Location location = new Location(player.getWorld(), npcloc.get(0), npcloc.get(1),
								npcloc.get(2));
		NPC npc = NPCLib.getInstance().generateGlobalNPC(plugin, "1", location);
		
		if (player.isOp() || player.hasPermission("ngui.command")) {
			if (args.length == 0) {

				player.sendMessage(plugin.prefix + "/ngui create - NPC소환");
				player.sendMessage(plugin.prefix + "/ngui loc or location - NPC소환할 위치 지정.");
				player.sendMessage(plugin.prefix + "/ngui remove or del [NPCID] - NPC삭제");
				player.sendMessage(plugin.prefix + "/ngui move - NPC를 플레이어의 위치로 이동시킵니다.");
				player.sendMessage(plugin.prefix + "/ngui reload - Config.yml을 리로드 합니다.");
				player.sendMessage(plugin.prefix + "/ngui list - NPC목록");

				return true;
			}

			if (args.length == 1) {
				if (args[0].equalsIgnoreCase("location") || args[0].equalsIgnoreCase("loc")) {

					//int playerx = (int) player.getLocation().getX();
					//int playery = (int) player.getLocation().getY();
					//int playerz = (int) player.getLocation().getZ();

					plugin.getConfig().set("설정.좌표.엑스", (double) player.getLocation().getX());
					plugin.getConfig().set("설정.좌표.와이", (double) player.getLocation().getY());
					plugin.getConfig().set("설정.좌표.제트", (double) player.getLocation().getZ());

					plugin.saveConfig();

					npcloc.add(0, plugin.getConfig().getDouble("설정.좌표.엑스"));
					npcloc.add(1, plugin.getConfig().getDouble("설정.좌표.와이"));
					npcloc.add(2, plugin.getConfig().getDouble("설정.좌표.제트"));

					player.sendMessage("NPC좌표가 : X: " + player.getLocation().getX() + " Y: " 
					+ player.getLocation().getY() + " Z: " + player.getLocation().getZ() + "로 설정되었습니다.");

					return false;
				}

				else if (args[0].equalsIgnoreCase("create")) {

					if (npcloc.size() != 0) {
						
						npc.setSkin(
								"eyJ0aW1lc3RhbXAiOjE1NTk4NTY2MDY0NzgsInByb2ZpbGVJZCI6IjgyYzYwNmM1YzY1MjRiNzk4YjkxYTEyZDNhNjE2OTc3IiwicHJvZmlsZU5hbWUiOiJOb3ROb3RvcmlvdXNOZW1vIiwic2lnbmF0dXJlUmVxdWlyZWQiOnRydWUsInRleHR1cmVzIjp7IlNLSU4iOnsidXJsIjoiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS9iNWE5MmEzMGExZjYxYjFkZmNhNjI0ZGU5ODc4YTkxYTI2OTYwNGVhMzA2ODJkMGIyMzExNWU5NDdjOTViZTg2In19fQ==",
								"JyjGNbCLjLgupeW3qWF+LKiMt4r066gF4fdwm3LByaY/gz2PDiE6zT4RQ/J9jb17q9DB6cENVsGLazC/ICEk09iWr20R0AbipYbEAkYz1rzT6I7CDlYD0fhJ6lLXpKKKcwAvA9vUl3MueQ2FH0NRpZSVT7selHXi+A33WESmSdDpFShHkxC1R0d8+iUou68nFauIfhDWqxb0ocL3HVsTZl75RDtNgJF3kVwSwBaInovjt8EpCuZXVsM8zPS5y7eQdd1w+VH/c1wMJxB7aPaKElYY0ne4xYKsYtGQGoaVPKFWRTwsEy0FrNg/TCXVqVOaIdZeJqBu4ynzS5SXGZChUlD9YbQYcmrrUWvcYhVnf0KZycGwkT+sDzjpNrkKj0W3UpsRdl607gGVtzDHvdyakCIqVL9dVDIhMjnYyQ+Dx8LXqKIpGynXG/dAYxnOQZKGLCpfT1oXEWcY4dlOm8kUzepw9JP1mS1Vff9UQwv5lmy0CNW6EI4Xj50kGx1FEmxnymltVVda9kmXxWKGH9SepKwlNWH5IZho08i1Na5FxT3gxdE3cw7wMASrVn7UD+EG0LEsnzMjlMEQS7W3lQ/BywH9CRY/R/PC0HNeHfoMHZ3rRRYKvnIlleuC+e8Z8ISRIS9TRd5K1cUB7eG3GEyQY+XW1TDB1YfJkPuYht82OLc=");
						
						plugin.ndata.Npc(player);
						
						
						if (check.indexOf("숨김") != -1) {

							npc.getNPCLib().getInstance().getGlobalNPC(plugin, "1").show(player);
							player.sendMessage(plugin.prefix + "생성되었습니다.");

							return true;

						} else {

							npc.getNPCLib().getInstance().generateGlobalNPC(plugin, "1", location);
							npc.getNPCLib().getGlobalNPC(plugin, "1").forceUpdate(player);
							player.sendMessage(plugin.prefix + "생성되었습니다.");

							return true;

						}

					} else {

						player.sendMessage(plugin.prefix + "좌표가 설정되어있지 않습니다. 좌표를 설정해주세요.");

					}

					return false;
				} else if (args[0].equalsIgnoreCase("remove") || args[0].equalsIgnoreCase("del")) {

					if (NPCLib.getInstance().getGlobalNPC(plugin, "1") != null) {

						if (args.length == 2) {

							check.add(0, "숨김");

							NPCLib.getInstance().getGlobalNPC(plugin, args[1]).hide(player);
							player.sendMessage(plugin.prefix + args[1] + "NPC가 제거되었습니다.");

							return false;

						} else {

							check.add(0, "숨김");

							NPCLib.getInstance().getGlobalNPC(plugin, "1").hide(player);
							player.sendMessage(plugin.prefix + "제거되었습니다.");

							return false;
						}

					} else {

						player.sendMessage(plugin.prefix + "해당 NPC는 현재 존재하지 않는 값을 가지고 있습니다.");

						return true;
					}
				} else if (args[0].equalsIgnoreCase("list")) {

					player.sendMessage(plugin.prefix + "개발중");
					player.sendMessage("x" + npcloc + "y" + npcloc + "z" + npcloc);
					player.sendMessage("x" + npcloc.get(0));

					return false;
				} else if (args[0].equalsIgnoreCase("move")) {

					/*Location location = new Location(player.getWorld(), player.getLocation().getX(),
							player.getLocation().getY(), player.getLocation().getZ()); */
					
					plugin.getConfig().set("설정.좌표.엑스", (double) player.getLocation().getX());
					plugin.getConfig().set("설정.좌표.와이", (double) player.getLocation().getY());
					plugin.getConfig().set("설정.좌표.제트", (double) player.getLocation().getZ());
					
					plugin.saveConfig();

					NPCLib.getInstance().getGlobalNPC(plugin, "1").teleport(location);
					player.sendMessage(plugin.prefix + player.getName() + "님의 위치로 이동되었습니다.");

					return false;
				} else if (args[0].equalsIgnoreCase("reload")) {

					plugin.reloadConfig();
					player.sendMessage(plugin.prefix + "config.yml을 성공적으로 리로드 하였습니다.");

					return false;
				}


			}
		} else if (!(player.hasPermission("ngui.command"))) {

			player.sendMessage(plugin.prefix + "당신은 권한을 가지고 있지 않습니다.");

			return false;
		}

		return false;
	}


}
