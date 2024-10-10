public class RangedWeapon extends Weapon{
    private int totalUses;
    private int weaponDamage;

    public RangedWeapon(String name, String description, int totalUses, int weaponDamage){
        super(name, description, weaponDamage);
        this.totalUses = totalUses;
        this.weaponDamage = weaponDamage;
    }


    @Override
    void playerUseWeapon() {
            if (totalUses > 0) {
                totalUses--;
                System.out.println("\nYou fired your long range weapon '" + getName() + "' and dealt " + weaponDamage + " damage! \n" + "Ammo left: " + totalUses);
            } else {
                System.out.println("Your '" + getName() + "' has 0 ammo!");
            }
    }

    @Override
    void enemyUseWeapon() {
        if (totalUses > 0) {
            totalUses--;
            System.out.println("\nThe enemy fired back!\nThey used a long range weapon '" + getName() + "' and dealt " + weaponDamage + " damage to you! \n" + "Ammo left: " + totalUses);
        } else {
            System.out.println("The enemy has 0 ammo!");
        }
    }


}
