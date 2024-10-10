public class Enemy {
    private String name;
    private String description;
    private int enemyHealth;
    private Weapon enemyEquippedWeapon;


    public Enemy(){

    }


    public Enemy(String name, String description, int enemyHealth, Weapon enemyEquippedWeapon){
        this.name = name;
        this.description = description;
        this.enemyHealth = enemyHealth;
        this.enemyEquippedWeapon = enemyEquippedWeapon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getEnemyHealth() {
        return enemyHealth;
    }

    public void setEnemyHealth(int enemyHealth) {
        this.enemyHealth = enemyHealth;
    }

    public Weapon getEnemyEquippedWeapon() {
        return enemyEquippedWeapon;
    }

    public void setEnemyEquippedWeapon(Weapon enemyEquippedWeapon) {
        this.enemyEquippedWeapon = enemyEquippedWeapon;
    }



    // Enemy attack method
    public void enemyHitPlayer(Player player){
        if(player.enemiesInCurrentRoom() && !enemyIsDead() ){
            player.playerHit(getEnemyEquippedWeapon().getWeaponDamage());
            System.out.println(getName() + " attacks back with a '" + getEnemyEquippedWeapon() + "!");
            System.out.println(getName() + " damaged you for " + getEnemyEquippedWeapon().getWeaponDamage() + "!\n");

            player.printHealth();
        }
    }


    public void enemyHit(int enemyDamageTaken){
        enemyHealth -= enemyDamageTaken;
    }

    public boolean enemyIsDead(){
        if(getEnemyHealth() <= 0) {
            return true;
        }
        return false;
    }


    public Weapon enemyDroppedWeapon(){
        return getEnemyEquippedWeapon();
    }




    public String toString(){
        return name + " " + description;
    }
}
