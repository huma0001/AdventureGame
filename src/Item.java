public class Item {
    private String name;
    private String description;


    //Default constructor for Food class
    public Item (){

    }


    public Item(String name, String description){
        this.name = name;
        this.description = description;
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public void setName(String newName){
        name = newName;
    }

    public void setDescription(String newDescription){
        description = newDescription;
    }

    public String toString(){
        return name + description;
    }
}
