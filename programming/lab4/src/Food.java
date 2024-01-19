public class Food extends Item{

    private boolean tasty;
    private String[] ingredients;
    public Food(String name, String description, boolean tasty, String[] ingredients){
        super(name, description);
        this.tasty = tasty;
        this.ingredients = ingredients;
    }

    public boolean getTasty() {
        return tasty;
    }

    // Локальный класс
    public void toSmell (){
        int t = 1;


        class Smell {
            String smell = "";
            public Smell(boolean tasty, String[] ingredients){
                if (tasty){
                    this.smell += "пахнет очень вкусно, среди всех запахов можно выделить:\n";
                }
                else{
                    this.smell += "пахнет очень плохо, особенно плохо пахнут:\n";
                }
                for (int i=0; i<ingredients.length; i+=2){
                    this.smell += ingredients[i] + " ";
                }
            }

            public String getSmell() {
                return smell;
            }

            public void setSmell(String smell) {
                this.smell = smell;
            }
        }
        Smell smell = new Smell(this.tasty, this.ingredients);

        System.out.println(this.getName() + " " + smell.getSmell());
    }


}
