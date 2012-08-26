package me.sd5.billboard.commands;

import java.util.Arrays;
import java.util.List;

import me.sd5.billboard.Advertising;
import me.sd5.billboard.BBMain;
import me.sd5.billboard.BillBoard;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;

public class CommandList extends BaseCommand {
	
	public static final int PAGE_SIZE = 8;
	
	/**
	 * Creates a new command.
	 */
	public CommandList() {
		
		super("list", Arrays.asList(new String[] {"show"}), new Permission("billboard.list"));
		
	}

	/**
	 * Lists all advertising on the billboard.
	 */
	@Override
	public void execute(Player player, List<String> args) {
		
		int pages = (int) Math.ceil(BillBoard.size() / PAGE_SIZE) + 1;
		int page = 1;
		
		if(args.size() >= 1) {
			try {
				page = Integer.parseInt(args.get(0));
				page = Math.min(page, pages);
				page = Math.max(page, 0);
			} catch(NumberFormatException e) {
				page = 1;
			}
		}
		
		player.sendMessage(BBMain.chatName + "Showing page " + ChatColor.RED + page + ChatColor.BLUE + " of " + ChatColor.RED + pages + ChatColor.BLUE + " :");
		if(BillBoard.size() >= 1) {
			int page_start = (page - 1) * PAGE_SIZE;
			int page_end = Math.min(page * PAGE_SIZE, BillBoard.size());		
			for(int n = page_start; n < page_end; n++) {
				Advertising advertising = BillBoard.get(n);
				player.sendMessage(ChatColor.GREEN + advertising.getPlayer() + ChatColor.RED + " | " + ChatColor.GREEN + advertising.getMessage());
			}
		} else {
			player.sendMessage(ChatColor.RED + "There is no advertisement on the billboard.");
		}
		
	}
	
}
