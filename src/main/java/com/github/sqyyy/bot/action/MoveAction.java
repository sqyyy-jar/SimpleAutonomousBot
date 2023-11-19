package com.github.sqyyy.bot.action;

import com.github.sqyyy.bot.Bot;
import com.github.sqyyy.bot.util.Direction;
import org.bukkit.Location;

public final class MoveAction extends Action {
    private static final int TICKS = 15;
    private final Location start;
    private final Direction direction;

    public MoveAction(Location start, Direction direction) {
        this.ticks = TICKS;
        this.start = start;
        this.direction = direction;
    }

    @Override
    public void tick(Bot bot) {
        super.tick(bot);
        bot.entity().teleport(pos());
    }

    private Location pos() {
        var location = this.start.clone();
        location.add(this.direction.vector().multiply((TICKS - this.ticks) / TICKS));
        return location;
    }
}
