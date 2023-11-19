package com.github.sqyyy.bot;

import com.github.sqyyy.bot.action.Action;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.inventory.EquipmentSlot;
import org.joml.Vector3i;
import org.joml.Vector3ic;

import java.util.UUID;

public class Bot {
    private final UUID uuid;
    private final ArmorStand entity;
    private Vector3ic position;
    private Action action;

    private Bot(UUID uuid, ArmorStand entity, Vector3ic position) {
        this.uuid = uuid;
        this.entity = entity;
        this.position = position;
    }

    public static Bot spawn(Location location) {
        var spawnedEntity = location.getWorld().spawn(location, ArmorStand.class, Bot::setupEntity);
        return new Bot(UUID.randomUUID(), spawnedEntity, location.toVector().toVector3i());
    }

    private static void setupEntity(ArmorStand entity) {
        entity.setInvulnerable(true);
        entity.setGravity(false);
        entity.setSmall(true);
        entity.setBasePlate(false);
        entity.setArms(true);
        entity.setDisabledSlots(EquipmentSlot.values());
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
