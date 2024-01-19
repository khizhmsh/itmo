public class Relationship {
    private Entity person1;
    private Entity person2;

    private String description;
    public Relationship(Entity person1, Entity person2, String description){
        this.person1=person1;
        this.person2=person2;
        this.description=description;
    }

    public Entity getPerson1() {
        return person1;
    }

    public void setPerson1(Entity person1) {
        this.person1 = person1;
    }
    public Entity getPerson2() {
        return person2;
    }

    public void setPerson2(Entity person2) {
        this.person2 = person2;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
