package sheizo.onepiece.item.animcontroller;


import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animation.AnimatableManager;

public interface ControllerProvider extends GeoItem {

     void register(AnimatableManager.ControllerRegistrar controllers);

}
