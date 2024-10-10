public abstract class Weapon extends Item{
    private int weaponDamage;

    public Weapon(){

    }

    public Weapon(String name, String description, int weaponDamage){
        super(name, description);
        this.weaponDamage = weaponDamage;
    }

    public int getWeaponDamage(){
        return weaponDamage;
    }

    abstract void playerUseWeapon();


    abstract void enemyUseWeapon();

}
