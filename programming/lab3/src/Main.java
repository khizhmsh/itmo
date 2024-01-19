public class Main {
    public static void main(String[] args) {
        UsualPerson person1 = new UsualPerson("Малыш", 8);
        UsualPerson person2 = new UsualPerson("Дядя Юлиус", 42);
        UsualPerson person3 = new UsualPerson("Фрекен Бок", 45);
        FairyPerson fairyperson = new FairyPerson("Карлсон", 100, "Карлсон, который живёт на крыше");

        Weapon gun = new Weapon("ружьё", "чёрное", Sound.GUN );
        Weapon pistol =new Weapon("пистолет", "белый", Sound.PISTOL);
        Accessory wallet = new Accessory("кошелёк", "маленький");
        Accessory watch = new Accessory("часы","наручные");
        Food jam = new Food("варенье", "малиновое", true);
        Furniture mirror =  new Furniture("зеркало", " большое", "чёрное");

        // отношение Карлсона
        fairyperson.addRelationship(fairyperson, person1, "любит");
        fairyperson.addRelationship(fairyperson, person2, "не любит");
        fairyperson.addRelationship(fairyperson, person3, "боится");
        //отношение малыша
        person1.addRelationship(person1, fairyperson, "обожает");
        person1.addRelationship(person1, person2, "любит");
        person1.addRelationship(person1, person3, "не любит");
        //отношение Дяди Юлиуса
        person2.addRelationship(person2, fairyperson, "не любит");
        person2.addRelationship(person2, person1, "любит");
        person2.addRelationship(person2, person2, "уважает");
        //отношение Фрекен Бок
        person3.addRelationship(person3, fairyperson, "не любит");
        person3.addRelationship(person3, person1, "не любит");
        person3.addRelationship(person3, person2, "уважает");


        fairyperson.toFly();
        fairyperson.toSing(Song.FunnySong);
        fairyperson.toShoot(gun);
        fairyperson.toWatch(mirror);

        System.out.println(person2.getName() + " "+person2.getRelationship(fairyperson)+" "+ fairyperson.getName());
        fairyperson.addItem(wallet);
        fairyperson.addItem(watch);
        fairyperson.giveItem(wallet, person2, true);
        fairyperson.giveItem(watch, person2, true);

        System.out.println(fairyperson.getName() + " "+person3.getRelationship(fairyperson)+" "+ person3.getName());
        person3.addItem(jam);
        person3.giveItem(jam, fairyperson, true);

        fairyperson.toWatch(person1);
        //System.out.println(person1.getName() +" "+ person1.getRelationship(fairyperson)+" "+ fairyperson.getName());






    }
}