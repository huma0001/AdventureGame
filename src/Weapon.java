public abstract class Weapon extends Item{

    public Weapon(){

    }

    public Weapon(String name, String description){
        super(name, description);
    }

    abstract void useWeapon();

}
