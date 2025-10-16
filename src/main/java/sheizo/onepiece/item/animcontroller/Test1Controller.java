package sheizo.onepiece.item.animcontroller;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import sheizo.onepiece.item.ModItemInit;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.constant.DefaultAnimations;

import java.util.Set;

public class Test1Controller implements ControllerProvider {

    @Override
    public void register(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, 20, animationState -> {
            animationState.getController().setAnimation(DefaultAnimations.IDLE);

            Entity entity = animationState.getData(DataTickets.ENTITY);

            // We'll just have ArmorStands always animate, so we can return here
            if (entity instanceof ArmorStandEntity || !(entity instanceof LivingEntity owner)) {
                return PlayState.CONTINUE;
            }

            // For this example, we only want the animation to play if the entity is wearing all pieces of the armor
            // Let's collect the armor pieces the entity is currently wearing
            Set<Item> wornArmor = new ObjectOpenHashSet<>();

            for (ItemStack stack : owner.getAllArmorItems()) {
                // We can stop immediately if any of the slots are empty
                if (stack.isEmpty())
                    return PlayState.STOP;

                wornArmor.add(stack.getItem());
            }

            // Check each of the pieces match our set
            boolean isFullSet = wornArmor.containsAll(ObjectArrayList.of(
                    ModItemInit.STRAW_HAT
//                    ItemRegistry.EXAMPLE_ARMOR_LEGGINGS,
//                    ItemRegistry.EXAMPLE_ARMOR_CHESTPLATE,
//                    ItemRegistry.EXAMPLE_ARMOR_HELMET
            ));

            // Play the animation if the full set is being worn, otherwise stop
            return isFullSet ? PlayState.CONTINUE : PlayState.STOP;
        }));
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {

    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return null;
    }


}
