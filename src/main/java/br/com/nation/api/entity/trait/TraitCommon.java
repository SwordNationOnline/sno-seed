package br.com.nation.api.entity.trait;

import br.com.nation.api.entity.NPCSustainer;
import net.citizensnpcs.api.trait.Trait;

public class TraitCommon extends Trait {

    public TraitCommon(NPCSustainer sustainer) {
        super(sustainer.getName());
    }
}
