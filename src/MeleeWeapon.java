public class MeleeWeapon extends Weapon{
    private int weaponDamage;

    public MeleeWeapon(String name, String description, int weaponDamage){
        super(name, description);
        this.weaponDamage = weaponDamage;
    }



    @Override
    void useWeapon() {
            System.out.println("You have used your melee weapon '" + getName() + "' on a target\nit dealt " + weaponDamage + " damage!");
    }
}
