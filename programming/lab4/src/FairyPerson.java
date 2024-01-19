public class FairyPerson extends Entity implements IFlyable, IShoot{
    private String description;
    private static final String mood ="чудесно";

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public FairyPerson(String name, int age, String description) {
        super(name, age);
        this.description = description;
    }
    public void help(UsualPerson person) {
    }

    public String getMood() {
        return mood;
    }

    @Override
    public void toShoot(Weapon weapon) {
        System.out.println(this.getName() + " стреляет из оружия: " + weapon.getName() + " "+ weapon.getDescription());
        for (int i = 0; i < 4; ++i) {
            System.out.println(weapon.getSound().getSoud());
        }
        System.out.println("-------------------------------------------");
    }
    @Override
    public void toFly() {
        System.out.println(this.getName() + " летит высоко в небе");
        System.out.println("-------------------------------------------");
    }
    @Override
    public void toFly(String place) {
        System.out.println(this.getName() + " прилетел в " + place);
        System.out.println("-------------------------------------------");
    }

}
