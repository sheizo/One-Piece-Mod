package sheizo.onepiececlient.item;

import sheizo.onepiece.OnePieceInit;
import sheizo.onepiece.item.CustomEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class CustomEntityRenderer extends GeoEntityRenderer<CustomEntity> {

    public CustomEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new DefaultedEntityGeoModel<>(Identifier.of(OnePieceInit.MOD_ID, "test")));
    }
}
