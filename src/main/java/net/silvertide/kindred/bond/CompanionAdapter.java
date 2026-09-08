package net.silvertide.kindred.bond;

import net.minecraft.world.entity.Entity;

import java.util.Optional;
import java.util.UUID;

public interface CompanionAdapter {
    boolean handles(Entity entity);

    Optional<UUID> ownerOf(Entity entity);

    default void wake(Entity entity) {}
}
