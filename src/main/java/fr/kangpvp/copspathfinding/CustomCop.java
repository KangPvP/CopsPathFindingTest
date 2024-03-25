package fr.kangpvp.copspathfinding;

import net.minecraft.network.chat.Component;


import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.animal.Turtle;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_20_R3.CraftWorld;

public class CustomCop extends Zombie {


    public CustomCop(Location location) {
        super(EntityType.ZOMBIE, ((CraftWorld) location.getWorld()).getHandle());
        this.setPos(location.getX(), location.getY(), location.getZ());

        this.setBaby(false);
        this.setCustomName(Component.nullToEmpty("dsfsdf"));
        this.setItemInHand(InteractionHand.MAIN_HAND, new ItemStack(Items.BOW));

    }

    @Override
    public void registerGoals(){
        this.goalSelector.addGoal(0, new FloatGoal(this)); // Know how swim


        //this.goalSelector.addGoal(3, new RangedAttackGoal(this, 0.2D, 5, 32F));
        this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.addGoal(5, new MoveTowardsRestrictionGoal(this, 0.2D));
        this.goalSelector.addGoal(6, new MoveThroughVillageGoal(this, 0.2D, false, 1, null));
        this.goalSelector.addGoal(7, new RandomStrollGoal(this, 0.2D));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(9, new LookAtPlayerGoal(this, Player.class, 8.0F));

        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<Chicken>(this, net.minecraft.world.entity.animal.Chicken.class, true));
        this.targetSelector.addGoal(3, new AvoidEntityGoal<Turtle>(this, Turtle.class, 20, 1.0D, 1.0D));
    }



}