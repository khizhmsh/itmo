public class Furniture extends Item{
   private String color;
    public Furniture(String name, String description, String color){
        super(name, description);
        this.color = color;

    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
