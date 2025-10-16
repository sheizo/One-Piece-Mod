package sheizo.onepiececlient.item;

import sheizo.onepiece.OnePieceInit;
import sheizo.onepiece.item.CustomArmorItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class CustomArmorRenderer extends GeoArmorRenderer<CustomArmorItem> {

    public CustomArmorRenderer(String path) {
        super(new DefaultedItemGeoModel<>(Identifier.of(OnePieceInit.MOD_ID, path)));

    }
}
