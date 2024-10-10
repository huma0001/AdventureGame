public class MeleeWeapon extends Weapon{
    private int weaponDamage;

    public MeleeWeapon(String name, String description, int weaponDamage){
        super(name, description, weaponDamage);
    }


    @Override
    void playerUseWeapon() {
            System.out.println("\nYou have used your melee weapon '" + getName() + "' on a target\nit dealt " + getWeaponDamage() + " damage!");
    }

    @Override
    void enemyUseWeapon() {
        System.out.println("\nThe enemy swung back!\nthey used the melee weapon '" + getName() + "', on you!\nit dealt " + getWeaponDamage() + " damage to you!");

    }
}
