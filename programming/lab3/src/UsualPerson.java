public class UsualPerson extends Entity{
    private boolean tension;

    public UsualPerson(String name, int age) {
        super(name, age);
    }


    public boolean getTension() {
        return tension;
    }

    public void setTension(boolean tension) {
        this.tension = tension;
    }
}
