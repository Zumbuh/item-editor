package at.dumphey.itemeditor.itemeditor.modules.attributes.items;

import at.dumphey.itemeditor.ui.template.UiItem;
import at.dumphey.itemeditor.ui.template.UiScreen;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;

import java.util.HashMap;
import java.util.Map;

public abstract class AttributeUiItem extends UiItem {

    protected static final Map<EquipmentSlot, Material> fancyEquipmentSlotMaterials = new HashMap<>();
    protected static final Map<Attribute, Material> fancyAttributeMaterials = new HashMap<>();

    static {
        initEquipmentSlotMaterials();
        initFancyAttributeMaterials();
    }

    private static void initFancyAttributeMaterials() {
        fancyAttributeMaterials.put(Attribute.ARMOR, Material.IRON_CHESTPLATE);
        fancyAttributeMaterials.put(Attribute.ARMOR_TOUGHNESS, Material.DIAMOND_CHESTPLATE);
        fancyAttributeMaterials.put(Attribute.ATTACK_DAMAGE, Material.DIAMOND_SWORD);
        fancyAttributeMaterials.put(Attribute.ATTACK_SPEED, Material.WOODEN_SWORD);
        fancyAttributeMaterials.put(Attribute.FLYING_SPEED, Material.ELYTRA);
        fancyAttributeMaterials.put(Attribute.FOLLOW_RANGE, Material.WHEAT);
        fancyAttributeMaterials.put(Attribute.KNOCKBACK_RESISTANCE, Material.SLIME_BLOCK);
        fancyAttributeMaterials.put(Attribute.LUCK, Material.DIAMOND);
        fancyAttributeMaterials.put(Attribute.MAX_HEALTH, Material.ENCHANTED_GOLDEN_APPLE);
        fancyAttributeMaterials.put(Attribute.MOVEMENT_SPEED, Material.LEATHER_BOOTS);
        fancyAttributeMaterials.put(Attribute.JUMP_STRENGTH, Material.HORSE_SPAWN_EGG);
        fancyAttributeMaterials.put(Attribute.SPAWN_REINFORCEMENTS, Material.ZOMBIE_SPAWN_EGG);
    }

    private static void initEquipmentSlotMaterials() {
        fancyEquipmentSlotMaterials.put(EquipmentSlot.CHEST, Material.DIAMOND_CHESTPLATE);
        fancyEquipmentSlotMaterials.put(EquipmentSlot.HEAD, Material.GOLDEN_HELMET);
        fancyEquipmentSlotMaterials.put(EquipmentSlot.FEET, Material.CHAINMAIL_BOOTS);
        fancyEquipmentSlotMaterials.put(EquipmentSlot.OFF_HAND, Material.TORCH);
        fancyEquipmentSlotMaterials.put(EquipmentSlot.HAND, Material.IRON_PICKAXE);
        fancyEquipmentSlotMaterials.put(EquipmentSlot.LEGS, Material.IRON_LEGGINGS);
    }

    public AttributeUiItem(UiScreen screen, Player player) {
        super(screen, player);
    }

    protected Multimap<Attribute, AttributeModifier> getAttributes() {
        Multimap<Attribute, AttributeModifier> modifiers = getEditedItem().getItemMeta().getAttributeModifiers();
        if (modifiers == null) {
            modifiers = ArrayListMultimap.create();
        }
        return modifiers;
    }
}
