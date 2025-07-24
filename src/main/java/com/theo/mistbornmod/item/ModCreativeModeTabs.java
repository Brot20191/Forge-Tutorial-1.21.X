package com.theo.mistbornmod.item;

import com.theo.mistbornmod.MistbornMod;
import com.theo.mistbornmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MistbornMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> MISTBORN_ITEMS_TAB = CREATIVE_MODE_TABS.register("mistborn_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ZINC.get()))
                    .title(Component.translatable("creativetab.mistbornmod.mistborn_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.ZINC.get());
                        output.accept(ModItems.RAW_ZINC.get());
                        output.accept(ModItems.TIN.get());
                        output.accept(ModItems.RAW_TIN.get());
                        output.accept(ModItems.OBSIDIAN_SHARD.get());

                    }).build());

    public static final RegistryObject<CreativeModeTab> MISTBORN_BLOCKS_TAB = CREATIVE_MODE_TABS.register("mistborn_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.ZINC_BLOCK.get()))
                    .withTabsBefore(MISTBORN_ITEMS_TAB.getId())
                    .title(Component.translatable("creativetab.mistbornmod.mistborn_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.ZINC_BLOCK.get());
                        output.accept(ModBlocks.RAW_ZINC_BLOCK.get());
                        output.accept(ModBlocks.RAW_TIN_BLOCK.get());

                    }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
