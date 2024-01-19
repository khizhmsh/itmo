public class UsualPerson extends Entity{
    private String mood;

    public UsualPerson(String name, int age) {
        super(name, age);
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }
}
