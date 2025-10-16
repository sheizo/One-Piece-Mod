package sheizo.onepiece.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    private static final RegistryKey<ItemGroup> DEVIL_FRUITS_GROUP =
            RegistryKey.of(RegistryKeys.ITEM_GROUP, Identifier.of("one_piece", "devil_fruits_group"));

    public static void initialize() {
        // Get the event for modifying entries in the ingredients group.
        // And register an event handler that adds our suspicious item to the ingredients group.
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
                .register((itemGroup) -> itemGroup.add(ModItemInit.SUSPICIOUS_SUBSTANCE));

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS)
                .register((itemGroup) -> itemGroup.add(ModItemInit.RUBBER_PICKAXE));

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT)
                .register((itemGroup) -> itemGroup.add(ModItemInit.STRAW_HAT));

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT)
                .register((itemGroup) -> itemGroup.add(ModItemInit.TEST_ARMOR));

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT)
                .register((itemGroup) -> itemGroup.add(ModItemInit.PIROCA));

        Registry.register(Registries.ITEM_GROUP, DEVIL_FRUITS_GROUP, FabricItemGroup.builder()
                .displayName(Text.translatable("one_piece.devil_fruits_group"))
                .icon(() -> new ItemStack(ModItemInit.SUSPICIOUS_SUBSTANCE))
                .entries((context, entries) -> {
                    entries.add(ModItemInit.SUSPICIOUS_SUBSTANCE);
                })
                .build()
        );
    }



}
