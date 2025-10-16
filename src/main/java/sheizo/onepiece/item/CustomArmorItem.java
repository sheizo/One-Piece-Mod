package sheizo.onepiece.item;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.registry.entry.RegistryEntry;
import org.jetbrains.annotations.Nullable;
import sheizo.onepiece.item.animcontroller.ControllerProvider;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;

public class CustomArmorItem extends ArmorItem implements GeoItem {

    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private final String path;
    private final ControllerProvider controllerProvider;

    public CustomArmorItem(RegistryEntry<ArmorMaterial> material, Type type, Settings settings, String path, @Nullable ControllerProvider controllerProvider) {
        super(material, type, settings);
        this.path = path;
        this.controllerProvider = controllerProvider;
    }

    public String getPath() {
        return this.path;
    }


    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        if (controllerProvider != null) {
            controllerProvider.register(controllerRegistrar);
        }
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }

}
