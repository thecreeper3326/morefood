package net.creeperdev.morefood;

import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.component.ItemLore;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;

import java.util.List;
import java.util.function.Function;

public class ModItems {
    public static <T extends Item> T register(String name, Function<Item.Properties, T> itemFactory, Item.Properties settings) {

        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("morefood", name));


        T item = itemFactory.apply(settings.setId(itemKey));

        Registry.register(BuiltInRegistries.ITEM, itemKey, item);

        return item;
    } public static final Consumable GOLD_ROAST_COM = Consumables.defaultFood()

            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.REGENERATION, 6 * 20, 0), 1.0f))
            .build();
    public static final FoodProperties GOLD_ROAST_PRO = new FoodProperties.Builder()
            .nutrition(16)
            .saturationModifier(1.2f)
            .alwaysEdible()
            .build();
    public static final Item GOLDEN_ROAST = register("golden_roast", Item::new, new Item.Properties().food(GOLD_ROAST_PRO, GOLD_ROAST_COM));

    public static final Item CHOCOLATE = register("chocolate", Item::new, new Item.Properties().food(
            new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationModifier(0.4f)
                    .build())
    );
    public static final Item MEAT_SKEWER_WEAK = register("meat_skewer_weak", Item::new, new Item.Properties().food(
            new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationModifier(0.3f)
                    .build()

    ));

    public static final Item MEAT_SKEWER_MED = register("meat_skewer_med", Item::new, new Item.Properties().food(
            new FoodProperties.Builder()
                    .nutrition(6)
                    .saturationModifier(0.4f)
                    .build()

    ));
    public static final Item MEAT_SKEWER_STRONG = register("meat_skewer_strong", Item::new, new Item.Properties().food(
            new FoodProperties.Builder()
                    .nutrition(8)
                    .saturationModifier(0.5f)
                    .build()

    ));
    public static final Item COOKED_MEAT_SKEWER_WEAK = register("cooked_meat_skewer_weak", Item::new, new Item.Properties().food(
            new FoodProperties.Builder()
                    .nutrition(6)
                    .saturationModifier(0.4f)
                    .build()

    ));
    public static final Item COOKED_MEAT_SKEWER_MED = register("cooked_meat_skewer_med", Item::new, new Item.Properties().food(
            new FoodProperties.Builder()
                    .nutrition(8)
                    .saturationModifier(0.5f)
                    .build()

    ));
    public static final Item COOKED_MEAT_SKEWER_STRONG = register("cooked_meat_skewer_strong", Item::new, new Item.Properties().food(
            new FoodProperties.Builder()
                    .nutrition(12)
                    .saturationModifier(0.6f)
                    .build()

    ));
    public static final Item VEG_SKEWER = register("veg_skewer", Item::new, new Item.Properties().food(
            new FoodProperties.Builder()
                    .nutrition(0)
                    .saturationModifier(0)
                    .build()

    ));
    public static final Item COOKED_VEG_SKEWER = register("cooked_veg_skewer", Item::new, new Item.Properties().food(
            new FoodProperties.Builder()
                    .nutrition(0)
                    .saturationModifier(0)
                    .build()

    ));
    public static final Item COOKED_CARROT = register("cooked_carrot", Item::new, new Item.Properties().food(
            new FoodProperties.Builder()
                    .nutrition(6)
                    .saturationModifier(0.8f)
                    .build()

    ));
    public static final Item GRAND_ROAST = register("grand_roast", Item::new, new Item.Properties().food(
            new FoodProperties.Builder()
                    .nutrition(8)
                    .saturationModifier(0.8f)
                    .build()

    ));
    public static final Item COOKED_GRAND_ROAST = register("cooked_grand_roast", Item::new, new Item.Properties().food(
            new FoodProperties.Builder()
                    .nutrition(16)
                    .saturationModifier(0.8f)
                    .build()

    ));




    public static final Item GOLDEN_CHOCOLATE = register("golden_chocolate", Item::new, new Item.Properties().food(
            new FoodProperties.Builder()
                    .nutrition(14)
                    .alwaysEdible()
                    .saturationModifier(0.8f)
                    .build()

    ));
    public static final Item CHOCOLATE_APPLE = register("chocolate_apple", Item::new, new Item.Properties().food(
            new FoodProperties.Builder()
                    .nutrition(6)
                    .saturationModifier(0.5f)
                    .build()

    ));
    public static final Item CARAMEL_APPLE = register("caramel_apple", Item::new, new Item.Properties().food(
            new FoodProperties.Builder()
                    .nutrition(6)
                    .saturationModifier(0.5f)
                    .build()

    ));
    public static final Item COOKED_APPLE = register("cooked_apple", Item::new, new Item.Properties().food(
            new FoodProperties.Builder()
                    .nutrition(8)
                    .saturationModifier(0.3f)
                    .build()

    ));
    public static final Item SALT = register("salt", Item::new, new Item.Properties().food(
            new FoodProperties.Builder()
                    .nutrition(1)
                    .build()


    ));
    public static final Item SANDWICH = register("sandwich", Item::new, new Item.Properties().food(
            new FoodProperties.Builder()
                    .nutrition(10)
                    .saturationModifier(0.5f)
                    .build()

    ));
    public static final Item KELP_FISH = register("kelp_fish", Item::new, new Item.Properties().food(
            new FoodProperties.Builder()
                    .nutrition(6)
                    .saturationModifier(0.4f)
                    .build()

    ));
    public static final Item COOKED_KELP_FISH = register("cooked_kelp_fish", Item::new, new Item.Properties().food(
            new FoodProperties.Builder()
                    .nutrition(10)
                    .saturationModifier(0.4f)
                    .build()

    ));
    public static final Item CARAMEL = register("caramel",Item::new,new Item.Properties().food(
            new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationModifier(0.0f)
                    .alwaysEdible()
                    .build()
    ));
    public static final Item CARAMEL_CANDY = register("caramel_candy",Item::new,new Item.Properties().food(
            new FoodProperties.Builder()
                    .nutrition(6)
                    .saturationModifier(0.5f)
                    .alwaysEdible()
                    .build()
    ));

    public static final Item APPLE_PIE = register("apple_pie",Item::new,new Item.Properties().food(
            new FoodProperties.Builder()
                    .nutrition(8)
                    .saturationModifier(0.6f)
                    .alwaysEdible()
                    .build()
    ));



    public static final ResourceKey<CreativeModeTab> MOREFOOD_KEY = ResourceKey.create(BuiltInRegistries.CREATIVE_MODE_TAB.key(), Identifier.fromNamespaceAndPath("morefood", "morefood"));
    public static final CreativeModeTab MOREFOOD = FabricCreativeModeTab.builder()
            .icon(() -> new ItemStack(ModItems.CHOCOLATE))
            .title(Component.translatable("itemGroup.morefood"))
            .displayItems((params, output) -> {

                output.accept(ModItems.CHOCOLATE);
                output.accept(ModItems.GOLDEN_CHOCOLATE);

                output.accept(ModItems.COOKED_APPLE);
                output.accept(ModItems.CHOCOLATE_APPLE);

                output.accept(ModItems.COOKED_CARROT);

                output.accept(ModItems.MEAT_SKEWER_WEAK);
                output.accept(ModItems.MEAT_SKEWER_MED);
                output.accept(ModItems.MEAT_SKEWER_STRONG);

                output.accept(ModItems.COOKED_MEAT_SKEWER_WEAK);
                output.accept(ModItems.COOKED_MEAT_SKEWER_MED);
                output.accept(ModItems.COOKED_MEAT_SKEWER_STRONG);

                output.accept(ModItems.GRAND_ROAST);
                output.accept(ModItems.COOKED_GRAND_ROAST);
                output.accept(ModItems.GOLDEN_ROAST);

                output.accept(ModItems.VEG_SKEWER);
                output.accept(ModItems.COOKED_VEG_SKEWER);

                output.accept(ModItems.SALT);
                output.accept(ModItems.CARAMEL);
                output.accept(ModItems.CARAMEL_CANDY);
                output.accept(ModItems.CARAMEL_APPLE);

                output.accept(ModItems.SANDWICH);
                output.accept(ModItems.APPLE_PIE);
                output.accept(ModItems.KELP_FISH);
                output.accept(ModItems.COOKED_KELP_FISH);

            })
            .build();



    public static void initialize() {
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, MOREFOOD_KEY, MOREFOOD);
    }
}