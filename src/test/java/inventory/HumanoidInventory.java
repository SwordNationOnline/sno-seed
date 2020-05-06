package inventory;

import br.com.nation.api.inventory.InventorySustainer;
import br.com.nation.api.inventory.size.InventorySize;
import br.com.nation.api.prototype.humanoid.Humanoid;
import br.com.nation.sdk.item.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class HumanoidInventory extends InventorySustainer {

    public HumanoidInventory(Humanoid humanoid) {
        super("Menu humanoid!", InventorySize.FIVE_LINES);

        Player player = humanoid.getPlayer();

        setItem(13, new ItemBuilder(Material.SKULL_ITEM)
                        .name("§aSuas informações!")
                        .lore(
                                " ",
                                " §eEsse é o seu menu de informações!",
                                " "
                        ).build(), e -> player.sendMessage("§aVocê clicou no inventario!"));
    }
}
