package br.com.nation.sdk.registry.profission;

import br.com.nation.api.manager.Manager;
import br.com.nation.api.profession.Profession;
import com.google.common.collect.Lists;

import java.util.List;

public class ProfissionManager implements Manager<Profession, String> {

    private final List<Profession> professionList = Lists.newArrayList();

    @Override
    public List<Profession> getList() {
        return professionList;
    }

    @Override
    public void put(Profession profession) {
        professionList.add(profession);
    }

    @Override
    public void remove(Profession profession) {
        professionList.removeIf(profession1 -> profession1.getName().equalsIgnoreCase(profession.getName()));
    }

    @Override
    public Profession find(String uniqueID) {
        for(Profession profession : professionList) {
            if(profession.getName().equalsIgnoreCase(uniqueID)) {
                return profession;
            }
        } return null;
    }
}
