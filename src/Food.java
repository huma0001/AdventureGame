public class Food extends Item {
    private int foodHealthPoints;


    public Food(String name, String description, int foodHealthPoints) {
        super(name, description);
        this.foodHealthPoints = foodHealthPoints;
    }

    public int getFoodHealthChange() {
        return foodHealthPoints;
    }

    public void setFoodHealthChange(int foodHealthChange) {
        this.foodHealthPoints = foodHealthPoints;
    }

}



