package sheizo.onepiece.item;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import sheizo.onepiece.OnePieceInit;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class ModArmorAttributes {

    public static RegistryEntry<ArmorMaterial> register(
            String id,
            Map<ArmorItem.Type,
                    Integer> defense,
            int enchantability,
            RegistryEntry<SoundEvent> equipSound,
            Supplier<Ingredient> repairIngredient,
            float toughness,
            float knockbackResistance,
            boolean dyeable)
    {
        List<ArmorMaterial.Layer> layers = List.of(
                new ArmorMaterial.Layer(Identifier.of(OnePieceInit.MOD_ID, id), "", dyeable)
        );

        var material = new ArmorMaterial(defense, enchantability, equipSound, repairIngredient, layers, toughness, knockbackResistance);
        material = Registry.register(Registries.ARMOR_MATERIAL,Identifier.of(OnePieceInit.MOD_ID, id), material);

        return RegistryEntry.of(material);
    }

    public static void initialize() {
    }

    public static final RegistryEntry<ArmorMaterial> STRAW_HAT = register("straw_hat", Map.of(
                ArmorItem.Type.HELMET, 2
            ),
            20,
            SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,
            () -> Ingredient.ofItems(Items.WHEAT),
            0.3f,
            0.1f,
            true
    );





}
