package arrisar.GoldenTools;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.block.BlockListener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class GoldenToolsBlockListener extends BlockListener {
	private final GoldenTools plugin;

	public GoldenToolsBlockListener(final GoldenTools plugin) {
		this.plugin = plugin;
		}
	public void onBlockBreak(BlockBreakEvent event) {
		Block block = event.getBlock();
		Player player = event.getPlayer();
		Location location = block.getLocation();
		
		if (event.isCancelled()) {
			return;
		}
		if (player.getItemInHand().getType() == Material.GOLD_HOE){
			player.getItemInHand().setDurability(
					(short) (player.getItemInHand().getDurability() + 1));
		}

		if(plugin.usepermissions == true){

		// [Tool] broke [Block], make it drop [Item] (Ice)
				if (plugin.iceTools.contains(player.getItemInHand().getTypeId()) && GoldenTools.permissionHandler.has(player, "goldentools.ice")) {
					if (plugin.iceBlocks.contains(block.getTypeId())) {
						// Stop destruction and turn into air
						block.setType(Material.AIR);
						block.getWorld().dropItemNaturally(location, new ItemStack(Material.ICE, 1));
			}
		}

		// [Tool] broke [Block], make it drop [Item] (Giant Red Mushroom)		
		if (plugin.rshroomTools.contains(player.getItemInHand().getTypeId()) && GoldenTools.permissionHandler.has(player, "goldentools.redshroom")) {
			if (plugin.rshroomBlocks.contains(block.getTypeId())) {
				// Stop destruction and turn into air
				block.setType(Material.AIR);
				block.getWorld().dropItemNaturally(location, new ItemStack(Material.HUGE_MUSHROOM_2, 1));
			}
		}

		// [Tool] broke [Block], make it drop [Item] (Giant Brown Mushroom)		
		if (plugin.bshroomTools.contains(player.getItemInHand().getTypeId()) && GoldenTools.permissionHandler.has(player, "goldentools.brownshroom")) {
			if (plugin.bshroomBlocks.contains(block.getTypeId())) {
				// Stop destruction and turn into air
				block.setType(Material.AIR);
				block.getWorld().dropItemNaturally(location, new ItemStack(Material.HUGE_MUSHROOM_1, 1));
			}
		}
			
		// [Tool] broke [Block], make it drop [Item] (Stone)
			if (plugin.stoneTools.contains(player.getItemInHand().getTypeId()) && GoldenTools.permissionHandler.has(player, "goldentools.stone")) {
				if (plugin.stoneBlocks.contains(block.getTypeId())) {
					// Stop destruction and turn into air
					block.setType(Material.AIR);
					block.getWorld().dropItemNaturally(location, new ItemStack(Material.STONE, 1));
				}
			}
			
		// [Tool] broke [Block], make it drop [Item] (Glass)
		if (plugin.glassTools.contains(player.getItemInHand().getTypeId()) && GoldenTools.permissionHandler.has(player, "goldentools.glass")) {
			if (plugin.glassBlocks.contains(block.getTypeId())) {
				// Stop destruction and turn into air
				block.setType(Material.AIR);
				block.getWorld().dropItemNaturally(location, new ItemStack(Material.GLASS, 1));
			}
		}
		
		// [Tool] broke [Block], make it drop [Item] (Grass)
		if (plugin.grassTools.contains(player.getItemInHand().getTypeId()) && GoldenTools.permissionHandler.has(player, "goldentools.grass")) {
			if (plugin.grassBlocks.contains(block.getTypeId())) {
				// Stop destruction and turn into air
				block.setType(Material.AIR);
				block.getWorld().dropItemNaturally(location, new ItemStack(Material.GRASS, 1));
			}
		}
		
		// [Tool] broke [Block], make it drop [Item] (Shrubs)
		if (plugin.shrubTools.contains(player.getItemInHand().getTypeId()) && GoldenTools.permissionHandler.has(player, "goldentools.tallgrass")) {
			if (plugin.shrubBlocks.contains(block.getTypeId())) {
				// Stop destruction and turn into air
				block.setType(Material.AIR);
				block.getWorld().dropItemNaturally(location, new ItemStack(Material.LONG_GRASS, 1));
			}
		}
		
		// [Tool] broke [Block], make it drop [Item] (Dead Shrubs)
		if (plugin.deadshrubTools.contains(player.getItemInHand().getTypeId()) && GoldenTools.permissionHandler.has(player, "goldentools.deadgrass")) {
			if (plugin.deadshrubBlocks.contains(block.getTypeId())) {
				// Stop destruction and turn into air
				block.setType(Material.AIR);
				block.getWorld().dropItemNaturally(location, new ItemStack(Material.DEAD_BUSH, 1));
					}
				}
			}
		else if(plugin.usepermissions == false){

			// [Tool] broke [Block], make it drop [Item] (Ice)
					if (plugin.iceTools.contains(player.getItemInHand().getTypeId())) {
						if (plugin.iceBlocks.contains(block.getTypeId())) {
							// Stop destruction and turn into air
							block.setType(Material.AIR);
							block.getWorld().dropItemNaturally(location, new ItemStack(Material.ICE, 1));
				}
			}

			// [Tool] broke [Block], make it drop [Item] (Giant Red Mushroom)		
			if (plugin.rshroomTools.contains(player.getItemInHand().getTypeId())) {
				if (plugin.rshroomBlocks.contains(block.getTypeId())) {
					// Stop destruction and turn into air
					block.setType(Material.AIR);
					block.getWorld().dropItemNaturally(location, new ItemStack(Material.HUGE_MUSHROOM_2, 1));
				}
			}

			// [Tool] broke [Block], make it drop [Item] (Giant Brown Mushroom)		
			if (plugin.bshroomTools.contains(player.getItemInHand().getTypeId())) {
				if (plugin.bshroomBlocks.contains(block.getTypeId())) {
					// Stop destruction and turn into air
					block.setType(Material.AIR);
					block.getWorld().dropItemNaturally(location, new ItemStack(Material.HUGE_MUSHROOM_1, 1));
				}
			}
				
			// [Tool] broke [Block], make it drop [Item] (Stone)
				if (plugin.stoneTools.contains(player.getItemInHand().getTypeId())) {
					if (plugin.stoneBlocks.contains(block.getTypeId())) {
						// Stop destruction and turn into air
						block.setType(Material.AIR);
						block.getWorld().dropItemNaturally(location, new ItemStack(Material.STONE, 1));
					}
				}
				
			// [Tool] broke [Block], make it drop [Item] (Glass)
			if (plugin.glassTools.contains(player.getItemInHand().getTypeId())) {
				if (plugin.glassBlocks.contains(block.getTypeId())) {
					// Stop destruction and turn into air
					block.setType(Material.AIR);
					block.getWorld().dropItemNaturally(location, new ItemStack(Material.GLASS, 1));
				}
			}
			
			// [Tool] broke [Block], make it drop [Item] (Grass)
			if (plugin.grassTools.contains(player.getItemInHand().getTypeId())) {
				if (plugin.grassBlocks.contains(block.getTypeId())) {
					// Stop destruction and turn into air
					block.setType(Material.AIR);
					block.getWorld().dropItemNaturally(location, new ItemStack(Material.GRASS, 1));
				}
			}
			
			// [Tool] broke [Block], make it drop [Item] (Shrubs)
			if (plugin.shrubTools.contains(player.getItemInHand().getTypeId())) {
				if (plugin.shrubBlocks.contains(block.getTypeId())) {
					// Stop destruction and turn into air
					block.setType(Material.AIR);
					block.getWorld().dropItemNaturally(location, new ItemStack(Material.LONG_GRASS, 1));
				}
			}
			
			// [Tool] broke [Block], make it drop [Item] (Dead Shrubs)
			if (plugin.deadshrubTools.contains(player.getItemInHand().getTypeId())) {
				if (plugin.deadshrubBlocks.contains(block.getTypeId())) {
					// Stop destruction and turn into air
					block.setType(Material.AIR);
					block.getWorld().dropItemNaturally(location, new ItemStack(Material.DEAD_BUSH, 1));
						}
					}
				}
	}
}