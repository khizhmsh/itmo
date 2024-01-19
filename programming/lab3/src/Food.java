public class Food extends Item{

    private boolean tasty;
    public Food(String name, String description, boolean tasty){
        super(name, description);
        this.tasty = tasty;

    }

    public boolean getTasty() {
        return tasty;
    }

    public void setTasty(boolean tasty) {
        this.tasty = tasty;
    }
}
