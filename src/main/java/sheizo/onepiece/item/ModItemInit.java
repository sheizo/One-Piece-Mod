package sheizo.onepiece.item;

import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import sheizo.onepiece.OnePieceInit;

public class ModItemInit {

    static ControllerInit controllerInit = new ControllerInit();


    public static final FoodComponent SUSPICIOUS_FOOD_COMPONENT = new FoodComponent.Builder()
            .alwaysEdible()
            .snack()
            // The duration is in ticks, 20 ticks = 1 second
            .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA , 15 * 20, 1), 1.0f)
            .build();



    public static Item register(String id, Item item) {
        // Create the identifier for the item.
        Identifier itemID = Identifier.of(OnePieceInit.MOD_ID, id);
        // Return the registered item!
        return Registry.register(Registries.ITEM, itemID, item);
    }



    public static final Item SUSPICIOUS_SUBSTANCE = register(
            "suspicious_substance",
            // Ignore the food component for now, we'll cover it later in the food section.
            new Item(new Item.Settings().food(SUSPICIOUS_FOOD_COMPONENT).maxCount(1))
    );

    public static final PickaxeItem RUBBER_PICKAXE = (PickaxeItem) register(
            "rubber_pickaxe",
            new PickaxeItem(ModToolAttributes.RUBBER_TOOLS, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolAttributes.RUBBER_TOOLS, 2, -2.4f)))
    );

    public static final ArmorItem STRAW_HAT = (ArmorItem) register(
            "armor/straw_hat",
            new CustomArmorItem(ModArmorAttributes.STRAW_HAT, ArmorItem.Type.HELMET, new Item.Settings(), "armor/straw_hat", null)
    );

    public static final ArmorItem TEST_ARMOR = (ArmorItem) register(
            "armor/testing",
            new CustomArmorItem(ModArmorAttributes.STRAW_HAT, ArmorItem.Type.CHESTPLATE, new Item.Settings(), "armor/testing", null)
    );

    public static final ArmorItem PIROCA = (ArmorItem) register(
            "piroca",
            new CustomArmorItem(ModArmorAttributes.STRAW_HAT, ArmorItem.Type.HELMET, new Item.Settings(), "piroca", controllerInit.test2Controller)
    );


    public static void initialize() {
        registryInit();
    }

     static void registryInit() {
        CompostingChanceRegistry.INSTANCE.add(ModItemInit.SUSPICIOUS_SUBSTANCE, 0.8f);
    }



}