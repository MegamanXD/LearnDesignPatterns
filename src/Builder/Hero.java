package Builder;

public class Hero {
    private final Profession profession;
    private final String name;
    private final Armor armor;
    private final Weapon weapon;

    public Hero(Builder builder){
        this.profession = builder.profession;
        this.name = builder.name;
        this.armor = builder.armor;
        this.weapon = builder.weapon;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name = '" + name + '\'' +
                ", profession = Profession." + profession +
                ", armor = Armor." + armor +
                ", weapon = Weapon." + weapon +
                "}";
    }

    //-------------------------------------------------------------//
    public static class Builder{
        public Profession profession;
        public String name;
        public Armor armor;
        public Weapon weapon;

        public Builder(String name, Profession profession) {
            if (profession == null || name == null){
                throw new IllegalArgumentException("profession & name cannot be null");
            }
            this.profession = profession;
            this.name = name;
        }

        public Builder setArmor(Armor armor){
            this.armor = armor;
            return this;
        }

        public Builder setHWeapon(Weapon weapon){
            this.weapon = weapon;
            return this;
        }

        public Hero build(){
            return new Hero(this);
        }
    }
}
