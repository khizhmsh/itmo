import java.util.ArrayList;
import java.util.Objects;

public abstract class Entity implements ISingable, IWatch, IKeep, ISleep, ISniff {
    private String name;
    private int age;
    private String view = "прекрасно";

    private ArrayList<Item> items = new ArrayList<Item>();
    private ArrayList<Relationship> relationships = new ArrayList<Relationship>();

    private boolean isSleep = false;

    public Entity(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public boolean isSleep() {
        return isSleep;
    }

    public void setSleep(boolean sleep) {
        isSleep = sleep;
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

                if (person.getRelationship(this) == "привязан к") {

                    System.out.println(person.getName() + " теперь относится ещё лучше к " + this.getName());
                } else {
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

    public void toWatch(Entity person) {
        if (person.getName().equals("Карлсон") & this.getName().equals("Фрекен Бок")) {
            System.out.println(this.getName() + " смотрит на " + person.getName() + " и ворчит");
        } else {
            System.out.println(this.getName() + " смотрит на " + person.getName());
            System.out.println("-------------------------------------------");

        }
    }

    public void toWatch(Item item) {
        if (item.getName().equals("зеркало")) {
            System.out.println(this.getName() + " смотрится в зеркало и выглядит " + this.getView());

        } else {
            System.out.println(this.getName() + " смотрит на " + item.getName());

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

    //класс static
    public static class Opponent {
        private String name;
        private String type;

        public Opponent(String name, String type) {
            this.name = name;
            this.type = type;

        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public void battle(Entity entity) {
            System.out.println(entity.getName() + " сражается с " + this.getType() + " по имени " + this.getName());

        }


    }


    // класс non - static питомцы
    public class Pet {
        private String name;
        private String type;

        public Pet(String name, String type) {
            this.name = name;
            this.type = type;

        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        // анонимный класс
        public void toPlay(Entity entity, IPlay x) {
            System.out.println(x.toPlay(entity));
        }

        public void interact(Entity entity) {
            toPlay(entity, new IPlay() {
                public String toPlay(Entity entity) {
                    return entity.getName() + " играет c " + Entity.Pet.this.name;
                }

            });
        }

    }

    public void toSleep() {
        System.out.println(this.getName() + " пошёл спать");
        isSleep = true;

    }

    public void toSleep(Pet pet) {
        System.out.println(this.getName() + " пошёл спать c " + pet.getName());
        isSleep = true;

    }

    public void toWakeUp() {
        System.out.println(this.getName() + " проснулся");
        isSleep = false;

    }
    public void toSniff(Food food){
        System.out.println( this.getName() + " учуял запах " + food.getName());
        food.toSmell();
    }


}
