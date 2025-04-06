package at.dumphey.itemeditor.itemeditor.modules.enchantments;

import at.dumphey.itemeditor.itemeditor.ItemEditor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class EnchantUtils {

    private static final Map<Enchantment, Material> fancyMaterials = new HashMap<>();

    static {
        addFancyMaterial(Material.BOW, Enchantment.POWER, Enchantment.FLAME, Enchantment.INFINITY,
                Enchantment.PUNCH);
        addFancyMaterial(Material.TRIDENT, Enchantment.CHANNELING, Enchantment.RIPTIDE, Enchantment.LOYALTY,
                Enchantment.IMPALING);
        addFancyMaterial(Material.GOLDEN_SWORD, Enchantment.SHARPNESS, Enchantment.BANE_OF_ARTHROPODS,
                Enchantment.SMITE, Enchantment.FIRE_ASPECT, Enchantment.KNOCKBACK, Enchantment.LOOTING,
                Enchantment.SWEEPING_EDGE);
        addFancyMaterial(Material.DIAMOND_PICKAXE, Enchantment.FORTUNE, Enchantment.EFFICIENCY,
                Enchantment.SILK_TOUCH);
        addFancyMaterial(Material.IRON_BOOTS, Enchantment.FEATHER_FALLING, Enchantment.FROST_WALKER,
                Enchantment.DEPTH_STRIDER);
        addFancyMaterial(Material.LEATHER_CHESTPLATE, Enchantment.PROTECTION,
                Enchantment.BLAST_PROTECTION, Enchantment.FIRE_PROTECTION, Enchantment.PROJECTILE_PROTECTION,
                Enchantment.THORNS);
        addFancyMaterial(Material.TURTLE_HELMET, Enchantment.AQUA_AFFINITY, Enchantment.RESPIRATION);
        addFancyMaterial(Material.OBSIDIAN, Enchantment.UNBREAKING);
        addFancyMaterial(Material.WITHER_SKELETON_SKULL, Enchantment.BINDING_CURSE, Enchantment.VANISHING_CURSE);
        addFancyMaterial(Material.EXPERIENCE_BOTTLE, Enchantment.MENDING);
        addFancyMaterial(Material.FISHING_ROD, Enchantment.LURE, Enchantment.LUCK_OF_THE_SEA);

        if (ItemEditor.INSTANCE.getCompatUtils().getMajorVersion() >= 14) {
            addFancyMaterial(Material.getMaterial("CROSSBOW"), getByEnumName("MULTISHOT"),
                    getByEnumName("QUICK_CHARGE"),
                    getByEnumName("PIERCING"));
        }

        if (ItemEditor.INSTANCE.getCompatUtils().getMajorVersion() >= 16) {
            addFancyMaterial(Material.IRON_BOOTS, getByEnumName("SOUL_SPEED"));
        }
    }

    private static Enchantment getByEnumName(String enumName) {

        return Arrays.stream(Enchantment.values())
                .filter(p -> ItemEditor.INSTANCE.getCompatUtils().getEnchantmentKey(p).equalsIgnoreCase(enumName))
                .findFirst().get();
    }

    private static void addFancyMaterial(Material material, Enchantment... enchantments) {
        for (Enchantment enchantment : enchantments) {
            fancyMaterials.put(enchantment, material);
        }
    }

    public static Material getMaterial(Enchantment enchantment) {
        if (fancyMaterials.containsKey(enchantment)) {
            return fancyMaterials.get(enchantment);
        }
        return Material.ENCHANTED_BOOK;
    }

}
