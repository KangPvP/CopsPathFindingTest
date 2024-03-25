package fr.kangpvp.copspathfinding;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.monster.Zombie;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_20_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_20_R3.entity.CraftPlayer;
import org.bukkit.event.entity.EntityTargetEvent;

public class CustomCopV2 extends Zombie {


    public CustomCopV2(Location location, org.bukkit.entity.Player player) {
        super(EntityType.ZOMBIE, ((CraftWorld) location.getWorld() ).getHandle());
        this.setPos(location.getX(), location.getY(), location.getZ());

        this.setTarget( (LivingEntity) ((CraftPlayer)player).getHandle(), EntityTargetEvent.TargetReason.CUSTOM, true);
    }

    @Override
    public void registerGoals(){
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, net.minecraft.world.entity.player.Player.class, 24F));

    }



}
