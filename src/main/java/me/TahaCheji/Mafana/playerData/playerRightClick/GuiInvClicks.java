package me.TahaCheji.Mafana.playerData.playerRightClick;

import de.tr7zw.changeme.nbtapi.NBTCompound;
import de.tr7zw.changeme.nbtapi.NBTEntity;
import me.TahaCheji.Mafana.Main;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.NPC;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;

public class GuiInvClicks implements Listener {

    @EventHandler
    public void clickEvent(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        Economy econ = Main.getEcon();
        if (!(e.getView().getTitle().contains("Inventory"))) {
            return;
        }
        e.setCancelled(true);
        if(e.getSlot() == 45) {
            GuiPlayerInfo gui = new GuiPlayerInfo(player);
            player.openInventory(gui.getInventory());
        }
    }

    @EventHandler
    public void clickEvent2(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        Economy econ = Main.getEcon();
        if (!(e.getView().getTitle().contains("Stats"))) {
            return;
        }
        e.setCancelled(true);
        if(e.getSlot() == 45) {
            GuiInv gui = new GuiInv(player);
            player.openInventory(gui.getInventory());
            return;
        }
    }


    @EventHandler
    public void rightClickPlayer(PlayerInteractAtEntityEvent e) {
        Player player = e.getPlayer();
        if(e.getRightClicked() instanceof ArmorStand) {
            e.setCancelled(true);
            return;
        }
        if(!(e.getRightClicked() instanceof Player)) {
            return;
        }
        if((e.getRightClicked() instanceof NPC)) {
            return;
        }
        if(e.getRightClicked().getCustomName() == null) {
            return;
        }
        NBTCompound nbt = new NBTEntity(e.getRightClicked()).getPersistentDataContainer();
        if(nbt.hasKey("NPC") || e.getRightClicked().getCustomName().contains("NPC")) {
            return;
        }
        GuiPlayerInfo gui = new GuiPlayerInfo((Player) e.getRightClicked());
        player.openInventory(gui.getInventory());
    }



}
