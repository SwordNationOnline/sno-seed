package br.com.nation.api.group.type;

public enum GroupType {
    ESPADACHIM("Espadachim"),
    WARRIOR("Guerreiro"),
    TANK("Tank");


    private final String name;

    GroupType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static GroupType fromName(String name) {
        for(GroupType groupType : values()) {
            if(groupType.getName().equalsIgnoreCase(name)) {
                return groupType;
            }
        } return null;
    }

}
