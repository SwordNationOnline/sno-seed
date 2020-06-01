package br.com.nation.api.group.type;

public enum Target {
    ESPADACHIM("Espadachim"),
    WARRIOR("Guerreiro"),
    TANK("Tank");


    private final String name;

    Target(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
