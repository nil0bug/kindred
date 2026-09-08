package net.silvertide.kindred.compat;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.silvertide.kindred.bond.CompanionAdapter;

import java.util.Optional;
import java.util.UUID;

public final class PettingCompat implements CompanionAdapter {
    public static final String MODID = "petting";
    private static final String TAMED_KEY = "pettingtamed";
    private static final String OWNER_KEY = "ownerUUID";
    private static final String SITTING_KEY = "sitstill";

    @Override
    public boolean handles(Entity entity) {
        return entity.getPersistentData().getBoolean(TAMED_KEY);
    }

    @Override
    public Optional<UUID> ownerOf(Entity entity) {
        CompoundTag data = entity.getPersistentData();
        if (!data.contains(OWNER_KEY)) return Optional.empty();
        try {
            return Optional.of(UUID.fromString(data.getString(OWNER_KEY)));
        } catch (IllegalArgumentException malformedUuid) {
            return Optional.empty();
        }
    }

    @Override
    public void wake(Entity entity) {
        entity.getPersistentData().putBoolean(SITTING_KEY, false);
    }
}
