package br.com.nation.sdk.registry.group;

import br.com.nation.api.group.Group;
import br.com.nation.api.manager.Manager;
import com.google.common.collect.Lists;

import java.util.List;

public class GroupManager implements Manager<Group, String> {

    private final List<Group> groupList = Lists.newLinkedList();

    @Override
    public List<Group> getList() {
        return groupList;
    }

    @Override
    public void put(Group group) {
        groupList.add(group);
    }

    @Override
    public void remove(Group group) {
        groupList.removeIf(group1 -> group1.getName().equalsIgnoreCase(group.getName()));
    }

    @Override
    public Group find(String uniqueID) {
        for (Group group : groupList) {
            if (group.getName().equalsIgnoreCase(uniqueID)) {
                return group;
            }
        }
        return null;
    }

}
