public class Main {
    public static void main(String[] args) {
        UsualPerson person1 = new UsualPerson("Малыш", 8);
        UsualPerson person2 = new UsualPerson("Дядя Юлиус", 42);
        UsualPerson person3 = new UsualPerson("Фрекен Бок", 45);
        FairyPerson fairyperson = new FairyPerson("Карлсон", 100, "Карлсон, который живёт на крыше");

        Weapon gun = new Weapon("ружьё", "чёрное", Sound.GUN);
        Weapon pistol = new Weapon("пистолет", "белый", Sound.PISTOL);
        Accessory wallet = new Accessory("кошелёк", "маленький", "чёрный");
        Accessory watch = new Accessory("часы", "наручные", " серые");
        Food jam = new Food("варенье", "малиновое", true, new String[]{"малина", "сахар", "клубника"});
        Furniture mirror = new Furniture("зеркало", " большое", "чёрное");

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

        System.out.println(person2.getName() + " " + person2.getRelationship(fairyperson) + " " + fairyperson.getName());
        fairyperson.addItem(wallet);
        fairyperson.addItem(watch);
        fairyperson.giveItem(wallet, person2, true);
        fairyperson.giveItem(watch, person2, true);

        System.out.println(fairyperson.getName() + " " + person3.getRelationship(fairyperson) + " " + person3.getName());
        person3.addItem(jam);
        person3.giveItem(jam, fairyperson, true);

        fairyperson.toWatch(person1);
        //System.out.println(person1.getName() +" "+ person1.getRelationship(fairyperson)+" "+ fairyperson.getName());

        // 4 лабораторная
        person2.toSleep();
        person3.toSleep();

        Entity.Opponent fille = new Entity.Opponent("Филле", "вор");
        Entity.Opponent rulle = new Entity.Opponent("Рулле", "вор");
        rulle.battle(person1);
        fille.battle(fairyperson);
        fairyperson.toShoot(gun);

        Entity.Pet Bimbo = person1.new Pet("Бимбо", "собака");
        person1.toSleep(Bimbo);

        person2.toWakeUp();
        person3.toWakeUp();
        person2.toSing(Song.UpsetSong);

        person1.toWakeUp();
        Bimbo.interact(person1);

        fairyperson.toFly("комнату Малыша");
        person1.toWatch(fairyperson);
        fairyperson.toSniff(jam);


        Furniture.Table dinnerTable = new Furniture.Table("обеденный стол", 3);
        try {
            dinnerTable.toSit(new Entity[]{person1, person2, person3});
        } catch (NotEnoughPlacesException e) {
            System.out.println(e.getMessage());
            System.out.println("никто не сел за стол");
        }


        try {
            dinnerTable.addPerson(fairyperson);
        } catch (NotEnoughPlacesException e) {
            System.out.println(e.getMessage());
            System.out.println(fairyperson.getName() + " не смог сесть за стол");
        }

        person3.toWatch(fairyperson);

        // RuntimeException
        try {
            person1.getRelationship(fairyperson);
        } catch (TooMuchRelationshipException e) {
            System.out.println(e.getMessage());
        }

    }

}