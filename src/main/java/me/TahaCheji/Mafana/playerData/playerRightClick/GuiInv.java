package me.TahaCheji.Mafana.playerData.playerRightClick;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class GuiInv implements InventoryHolder {

    public Inventory GuiInv;

    public GuiInv(Player player) {
        GuiInv = Bukkit.createInventory(null, 36, ChatColor.GRAY + "" + ChatColor.BOLD + player.getDisplayName() + "'s Inventory");
        ArrayList<String> lore = new ArrayList<String>();

        ItemStack closeShop = new ItemStack(Material.BARRIER);
        ItemMeta closeShopeta = closeShop.getItemMeta();
        closeShopeta.setDisplayName(ChatColor.GRAY + "Close Shop");
        closeShopeta.setLore(lore);
        closeShop.setItemMeta(closeShopeta);


        GuiInv.setContents(player.getInventory().getContents());
        ItemStack newItem = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta newmeta = newItem.getItemMeta();
        newmeta.setDisplayName(ChatColor.GRAY + " ");
        newmeta.setLore(lore);
        newItem.setItemMeta(newmeta);

    }

    @Override
    public Inventory getInventory() {
        return GuiInv;
    }

}
