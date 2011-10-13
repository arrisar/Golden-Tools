package arrisar.GoldenTools;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import org.bukkit.event.Event.Priority;
import org.bukkit.event.Event;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.util.config.Configuration;

//import com.nijiko.permissions.PermissionHandler;
//import com.nijikokun.bukkit.Permissions.Permissions;
//xcfimport org.bukkit.plugin.Plugin;

/**
 * Golden Tools - Allowing you to harvest certain blocks using Golden Tools
 * @author Arrisar <james.dean.norman@gmail.com>
 */
public class GoldenTools extends JavaPlugin {
	private final GoldenToolsBlockListener blockListener = new GoldenToolsBlockListener(this);
	private final Logger log = Logger.getLogger("Minecraft");

	//public boolean usepermissions;


	//public static PermissionHandler permissionHandler;
	//private void setupPermissions() {
	 //   if (permissionHandler != null) {
	  //      return;
	 //  }

	  //  Plugin permissionsPlugin = this.getServer().getPluginManager().getPlugin("Permissions");

	  //  if (permissionsPlugin == null) {
	  //      log.info("[" + getDescription().getName() + "] Permission system not detected, Everyone can use Golden Tools!");
	  //      usepermissions = false;
	   //     return;
	  //  }

	  //  permissionHandler = ((Permissions) permissionsPlugin).getHandler();
	   // log.info("[" + getDescription().getName() + "] Found and will use plugin "+((Permissions)permissionsPlugin).getDescription().getFullName());
	 //   usepermissions = true;
	//}
	
	// Config
	public List<Integer> iceBlocks;
	public List<Integer> rshroomBlocks;
	public List<Integer> bshroomBlocks;
	public List<Integer> glassBlocks;
	public List<Integer> grassBlocks;
	public List<Integer> shrubBlocks;
	public List<Integer> deadshrubBlocks;
	public List<Integer> stoneBlocks;
	public List<Integer> glowStoneBlocks;
	public List<Integer> diamondBlocks;
	public List<Integer> coalBlocks;
	public List<Integer> iceTools;
	public List<Integer> rshroomTools;
	public List<Integer> bshroomTools;
	public List<Integer> glassTools;
	public List<Integer> grassTools;
	public List<Integer> shrubTools;
	public List<Integer> deadshrubTools;
	public List<Integer> stoneTools;
	public List<Integer> glowStoneTools;
	public List<Integer> diamondTools;
	public List<Integer> coalTools;

	public void onDisable() {
		log.info("[" + getDescription().getName() + "] " + getDescription().getName() + " was disabled.");
	}
	
	private void loadConfiguration() {
		Configuration config = getConfiguration();

		iceBlocks = config.getIntList("iceBlocks", Arrays.asList(79));
		rshroomBlocks = config.getIntList("rshroomBlocks", Arrays.asList(100));
		bshroomBlocks = config.getIntList("bshroomBlocks", Arrays.asList(99));
		glassBlocks = config.getIntList("glassBlocks", Arrays.asList(20));
		grassBlocks = config.getIntList("grassBlocks", Arrays.asList(2));
		shrubBlocks = config.getIntList("shrubBlocks", Arrays.asList(31));
		deadshrubBlocks = config.getIntList("deadshrubBlocks", Arrays.asList(32));
		stoneBlocks = config.getIntList("stoneBlocks", Arrays.asList(1));
		glowStoneBlocks = config.getIntList("glowStoneBlocks", Arrays.asList(89));
		diamondBlocks = config.getIntList("diamondBlocks", Arrays.asList(56));
		coalBlocks = config.getIntList("coalBlocks", Arrays.asList(16));
		
		iceTools = config.getIntList("iceTools", Arrays.asList(285));
		rshroomTools = config.getIntList("rshroomTools", Arrays.asList(294));
		bshroomTools = config.getIntList("bshroomTools", Arrays.asList(294));
		glassTools = config.getIntList("glassTools", Arrays.asList(286));
		grassTools = config.getIntList("grassTools", Arrays.asList(294));
		shrubTools = config.getIntList("shrubTools", Arrays.asList(284));
		deadshrubTools = config.getIntList("deadshrubTools", Arrays.asList(284));
		stoneTools = config.getIntList("stoneTools", Arrays.asList(285));
		glowStoneTools = config.getIntList("glowStoneTools", Arrays.asList(285));
		diamondTools = config.getIntList("diamondTools", Arrays.asList(285));
		coalTools = config.getIntList("coalTools", Arrays.asList(285));
	}
	
	public void onEnable() {
		
		File configfile = new File(getDataFolder(), "config.yml");
		Configuration config = getConfiguration();
		//setupPermissions();
		if (!configfile.exists()) {
			log.info("[" + getDescription().getName() + "] Config not found. Creating default config file.");
			
			config.setProperty("iceTools", Arrays.asList(285));
			config.setProperty("rshroomTools", Arrays.asList(294));
			config.setProperty("bshroomTools", Arrays.asList(294));
			config.setProperty("glassTools", Arrays.asList(286));
			config.setProperty("grassTools", Arrays.asList(294));
			config.setProperty("shrubTools", Arrays.asList(284));
			config.setProperty("deadshrubTools", Arrays.asList(284));
			config.setProperty("stoneTools", Arrays.asList(285));
			config.setProperty("glowStoneTools", Arrays.asList(285));
			config.setProperty("diamondTools", Arrays.asList(285));
			config.setProperty("coalTools", Arrays.asList(285));
			
			config.save();
			
			loadConfiguration();
		}
		else {
			loadConfiguration();
			
			log.info("[" + getDescription().getName() + "] Config has been loaded.");
		}
		
		// Register events
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvent(Event.Type.BLOCK_BREAK, blockListener, Priority.Normal, this);

		// Loaded
		log.info("[" + getDescription().getName() + "] " + getDescription().getName() + " version " + getDescription().getVersion() + " by Arrisar: enabled.");
	}
}
