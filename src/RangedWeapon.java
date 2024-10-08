public class RangedWeapon extends Weapon{
    private int totalUses;
    private int weaponDamage;

    public RangedWeapon(String name, String description, int totalUses, int weaponDamage){
        super(name, description);
        this.totalUses = totalUses;
        this.weaponDamage = weaponDamage;
    }

    @Override
    void useWeapon() {
        if(totalUses > 0){
            totalUses--;
            System.out.println("You fired your long range weapon '" + getName() + "' and dealt " + weaponDamage + " damage! \n" + "Ammo left: " + totalUses);
        } else {
            System.out.println("Your '" + getName() + "' has 0 ammo!");
        }

    }
}
