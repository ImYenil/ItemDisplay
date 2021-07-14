package net.choco.itemdisplay;

import org.bukkit.Bukkit;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener
{
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onItemDrop(PlayerDropItemEvent e) {
        ItemStack is = e.getItemDrop().getItemStack();
        if (is != null && is.hasItemMeta() && is.getItemMeta().hasDisplayName()) {
            Item i = e.getItemDrop();
            i.setCustomName(is.getItemMeta().getDisplayName());
            i.setCustomNameVisible(true);
        }
        else {
            Item i = e.getItemDrop();
            i.setCustomName(is.getType().toString());
            i.setCustomNameVisible(true);
        }
    }
}
