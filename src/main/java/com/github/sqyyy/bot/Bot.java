package com.github.sqyyy.bot;

import com.github.sqyyy.bot.action.Action;
import com.github.sqyyy.bot.util.UuidPersistentDataType;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.ArmorStand;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.persistence.PersistentDataType;
import org.joml.Vector3ic;

import java.util.UUID;

public class Bot {
    private static final NamespacedKey UUID_KEY = new NamespacedKey("simple_autonomous_bot", "uuid");
    private final UUID uuid;
    private ArmorStand entity;
    private Vector3ic position;
    private Action action;

    private Bot(UUID uuid, ArmorStand entity, Vector3ic position) {
        this.uuid = uuid;
        this.entity = entity;
        this.position = position;
    }

    public static Bot spawn(Location location) {
        var bot = new Bot(UUID.randomUUID(), null, location.toVector().toVector3i());
        bot.entity = location.getWorld().spawn(location, ArmorStand.class, bot::setupEntity);
        return bot;
    }

    private void setupEntity(ArmorStand entity) {
        entity.setInvulnerable(true);
        entity.setPersistent(true);
        entity.setGravity(false);
        entity.setSmall(true);
        entity.setBasePlate(false);
        entity.setArms(true);
        entity.setDisabledSlots(EquipmentSlot.values());
        var data = entity.getPersistentDataContainer();
        if (!data.has(UUID_KEY, UuidPersistentDataType.UUID)) {
            data.set(UUID_KEY, UuidPersistentDataType.UUID, this.uuid);
        }
    }

    public UUID uuid() {
        return this.uuid;
    }

    public ArmorStand entity() {
        return this.entity;
    }

    public Vector3ic position() {
        return this.position;
    }

    public void position(Vector3ic position) {
        this.position = position;
    }

    public Action action() {
        return this.action;
    }

    public void action(Action action) {
        this.action = action;
    }
}
