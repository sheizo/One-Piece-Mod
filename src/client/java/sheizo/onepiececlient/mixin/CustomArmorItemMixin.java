package sheizo.onepiececlient.mixin;

import sheizo.onepiece.item.CustomArmorItem;
import sheizo.onepiececlient.item.CustomArmorRenderer;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

import java.util.function.Consumer;


@Mixin(CustomArmorItem.class)
public abstract class CustomArmorItemMixin implements GeoItem {

    @Shadow
    public abstract String getPath();

    @Override
    public void createGeoRenderer(Consumer<GeoRenderProvider> consumer) {
        consumer.accept(new GeoRenderProvider() {
            private GeoArmorRenderer<?> renderer;

            @Override
            public <T extends LivingEntity> BipedEntityModel<?> getGeoArmorRenderer(@Nullable T livingEntity, ItemStack itemStack, @Nullable EquipmentSlot equipmentSlot, @Nullable BipedEntityModel<T> original) {
                if (this.renderer == null) {
                    this.renderer = new CustomArmorRenderer(getPath());
                }

                return this.renderer;
            }
        });
    }

}
