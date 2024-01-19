public class Accessory extends Item{
    private String color;

    public Accessory(String name, String description, String color){
        super(name, description);
        this.color=color;

    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
