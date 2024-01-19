import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Entity implements ISingable, IWatch, IKeep {
    private String name;
    private int age;
    private String view = "прекрасно";

    private ArrayList<Item> items = new ArrayList<Item>();
    private ArrayList<Relationship> relationships = new ArrayList<Relationship>();

    public Entity(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void addItem(Item item) {
        this.items.add(item);

    }

    public void delItem(Item item) {
        if (this.haveItem(item)) {
            this.items.remove(item);

        }

    }

    public boolean haveItem(Item item) {
        for (int i = 0; i < items.size(); ++i) {
            if (items.get(i).equals(item)) {
                return true;
            }
        }
        return false;
    }

    public void giveItem(Item item, Entity person, boolean importance) {
        if (this.haveItem(item)) {
            person.addItem(item);
            this.delItem(item);
            System.out.println(this.getName() + " даёт " + item.getName() + " " + person.getName());
            if (importance) {
                System.out.println("этот предмет важен для " + person.getName());

                if (person.getRelationship(this)=="привязан к"){

                    System.out.println(person.getName() + " теперь относится ещё лучше к " + this.getName());
                }
                else {
                    person.addRelationship(person, this, "привязан к");
                }
            }

        } else {
            System.out.println(this.getName() + " не имеет " + item.getName());
        }
        System.out.println("-------------------------------------------");
    }


    public void addRelationship(Entity person1, Entity person2, String description) {
        if (person1.equals(this)) {
            for (int i = 0; i < relationships.size(); ++i) {
                if (relationships.get(i).getPerson2().equals(person2)) {
                    relationships.remove(i);
                }
            }
            this.relationships.add(new Relationship(person1, person2, description));
            System.out.println(person1.getName() + " " + description + " " + person2.getName());


        } else {
            System.out.println("Невозможно добавить отношение");
        }
        System.out.println("-------------------------------------------");

    }

    public String getRelationship(Entity person) {
        for (int i = 0; i < relationships.size(); ++i) {
            if (relationships.get(i).getPerson2().equals(person)) {
                return relationships.get(i).getDescription();
            }
        }
        return "нет отношений";
    }
    public void toWatch(Entity person){
        System.out.println(this.getName()+ " смотрит на " + person.getName());
        System.out.println("-------------------------------------------");

    }
    public void toWatch(Item item){
        if(item.getName() == "зеркало"){
            System.out.println(this.getName() + " смотрится в зеркало и выглядит " + this.getView());

        }
        else {System.out.println(this.getName()+ " смотрит на " + item.getName());

        }

        System.out.println("-------------------------------------------");

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "view='" + view + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity entity = (Entity) o;
        return age == entity.age && Objects.equals(name, entity.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public void toSing(Song song) {
        System.out.println(this.getName() + " начинает петь, и звучит");
        System.out.println(song.getDescription());
        System.out.println(song.getText());
        System.out.println("-------------------------------------------");
    }

    public void toWatch() {
        System.out.println(this.getName() + " смотрит на  " + getName() + this.getView());
        System.out.println("-------------------------------------------");
    }

}
