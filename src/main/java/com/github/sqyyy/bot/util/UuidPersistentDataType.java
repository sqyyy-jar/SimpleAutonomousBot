package com.github.sqyyy.bot.util;

import org.bukkit.persistence.PersistentDataAdapterContext;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class UuidPersistentDataType implements PersistentDataType<long[], UUID> {
    public static final UuidPersistentDataType UUID = new UuidPersistentDataType();

    @Override
    public @NotNull Class<long[]> getPrimitiveType() {
        return long[].class;
    }

    @Override
    public @NotNull Class<UUID> getComplexType() {
        return UUID.class;
    }

    @Override
    public long @NotNull [] toPrimitive(@NotNull UUID complex, @NotNull PersistentDataAdapterContext context) {
        return new long[]{complex.getMostSignificantBits(), complex.getLeastSignificantBits()};
    }

    @Override
    public @NotNull UUID fromPrimitive(long @NotNull [] primitive, @NotNull PersistentDataAdapterContext context) {
        return new UUID(primitive[0], primitive[1]);
    }
}
