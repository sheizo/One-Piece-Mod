package sheizo.onepiece.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.registry.tag.FluidTags;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(LivingEntity.class)
public abstract class PlayerMovementMixin {


    @Inject(method = "baseTick", at = @At("TAIL"))
    public void baseTick(CallbackInfo ci) {
        LivingEntity player = (LivingEntity) (Object) this;

        if (player.isSubmergedIn(FluidTags.WATER)) {
            // add weakness to player
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 20, 3));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 20, 10));
            if (!player.hasStatusEffect(StatusEffects.NAUSEA)) player.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 20 * 15, 10));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 20, 3));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 20, 3));

        }

    }

    /*@Inject(method = "travel", at = @At("HEAD"))
    public void disableSwimmingInWater(Vec3d movementInput, CallbackInfo ci) {
        PlayerEntity player = (PlayerEntity) (Object) this;
        World world = player.getWorld();
        BlockPos playerPos = player.getBlockPos();
        BlockState blockState = world.getBlockState(playerPos);

        if (blockState.getBlock() == Blocks.WATER) {
            // Prevent the player from swimming by canceling the method
            player.setVelocity(0, player.getVelocity().y, 0);
            //ci.cancel();
        }
    } */

    /**
     * @author
     * @reason
     */
    /*@Overwrite
    public boolean shouldSwimInFluids() {
        PlayerEntity player = (PlayerEntity) (Object) this;
        if (player.isTouchingWater()){
            return false;
        }
        OnePi.LOGGER.info(abilities.toString());
        return !this.abilities.flying;
    }*/



}
