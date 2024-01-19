public class Weapon extends Item{
    private Sound sound;
    public Weapon(String name, String description, Sound sound){
        super(name, description);
        this.sound = sound;

    }



    public Sound getSound() {
        return sound;
    }

    public void setSound(Sound sound) {
        this.sound = sound;
    }
}
