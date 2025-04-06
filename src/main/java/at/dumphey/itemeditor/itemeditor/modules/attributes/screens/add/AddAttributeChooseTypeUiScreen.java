package at.dumphey.itemeditor.itemeditor.modules.attributes.screens.add;

import at.dumphey.itemeditor.itemeditor.modules.attributes.screens.manage.ManageAttributesUiScreen;
import at.dumphey.itemeditor.ui.items.BackUiItem;
import at.dumphey.itemeditor.ui.template.UiScreen;
import at.dumphey.itemeditor.utils.UiUtils;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AddAttributeChooseTypeUiScreen extends UiScreen {
    public AddAttributeChooseTypeUiScreen(Player player) {
        super(player, 45, "Choose attribute type");
    }

    private List<Attribute> getAttributes() {
        return Arrays.asList(Attribute.values()).stream()
                .sorted(Comparator.comparing(attribute -> attribute.name()))
                .collect(Collectors.toList());
    }



    @Override
    protected void onUpdate() {
        int i = 0;
        for (Attribute attribute : getAttributes()) {
            setItem(i++, new ChooseAttributeTypeUiItem(this, player, attribute));
        }
        setItem(44, new BackUiItem(this, player, () -> open(new ManageAttributesUiScreen(player))));
    }
}
