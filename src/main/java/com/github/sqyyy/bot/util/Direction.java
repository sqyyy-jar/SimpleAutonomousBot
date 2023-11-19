package com.github.sqyyy.bot.util;

import org.bukkit.util.Vector;

public enum Direction {
    PLUS_X(1, 0, 0),
    MINUS_X(-1, 0, 0),
    PLUS_Y(0, 1, 0),
    MINUS_Y(0, -1, 0),
    PLUS_Z(0, 0, 1),
    MINUS_Z(0, 0, -1);

    public static final Direction NORTH = MINUS_Z;
    public static final Direction SOUTH = PLUS_Z;
    public static final Direction EAST = PLUS_X;
    public static final Direction WEST = MINUS_X;
    public static final Direction UP = PLUS_Y;
    public static final Direction DOWN = MINUS_Y;
    private final Vector vector;

    Direction(double x, double y, double z) {
        this.vector = new Vector(x, y, z);
    }

    public Vector vector() {
        return this.vector.clone();
    }
}
