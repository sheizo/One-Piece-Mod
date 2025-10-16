package sheizo.onepiece.item;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.world.World;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;

public class CustomEntity extends PathAwareEntity implements GeoEntity {


    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public CustomEntity(EntityType<? extends CustomEntity> entityType, World world) {
        super(entityType, world);

    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {

    }


    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }



}
