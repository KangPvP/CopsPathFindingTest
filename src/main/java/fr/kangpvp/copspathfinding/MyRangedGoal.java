package fr.kangpvp.copspathfinding;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.*;

import java.util.EnumSet;

public class MyRangedGoal extends Goal {

    private Mob a;

    private LivingEntity b;
    private double f;
    private float g; // distance btw player and pet

    private double c;
    private double d;
    private double e;

    public MyRangedGoal(Mob a, double speed, float distance){
        this.a = a;
        this.f = speed;
        this.g = distance;

        this.setFlags(EnumSet.of(Flag.MOVE));
    }



    @Override
    public boolean canUse() {
        System.out.println("OK");
        this.b = this.a.getTarget();
        if(this.b == null){
            System.out.println("OK 1" );

            return false;
        } else if(this.a.getDisplayName() == null){
            System.out.println("OK 2" );

            return false;
        } else if(this.b.distanceToSqr(this.a) > (double) (this.g * this.g)){
            a.setPos(this.b.getX(), this.b.getY(), this.b.getZ());
            System.out.println("Tp");
            return false;
        } else {
            System.out.println("Move");

            // follow the owner
            //RandomPos.
            //RandomPos.generateRandomPos((PathfinderMob) this.a, (Supplier<BlockPos>) this.b.getViewVector(16F));
            this.c = this.b.getX();
            this.d = this.b.getY();
            this.e = this.b.getZ();

            return true;
        }
    }

    public void start(){
        this.a.getNavigation().moveTo(this.c, this.d, this.e, this.f);
    }

    public boolean requiresUpdateEveryTick() { // or canContinueToUse
        // runs after c()
        // run every tick as long as its true (repeats c)
        return !this.a.getNavigation().isInProgress() && this.b.distanceToSqr(this.a) < (double) (this.g * this.g);
    }

    public void stop() {
        // runs when b() reuturns false
        this.b = null;
    }



}
