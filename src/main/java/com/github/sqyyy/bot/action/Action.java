package com.github.sqyyy.bot.action;

import com.github.sqyyy.bot.Bot;

public class Action {
    protected int ticks;

    public void tick(Bot bot) {
        this.ticks--;
    }

    public boolean isDone() {
        return this.ticks <= 0;
    }
}
