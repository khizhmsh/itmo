public class Furniture extends Item {
    private String color;

    public Furniture(String name, String description, String color) {
        super(name, description);
        this.color = color;

    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public static class Table {
        private String type;
        private int places;
        private int busy;

        public Table(String type, int places) {
            this.type = type;
            this.places = places;

        }

        public int getBusy() {
            return busy;
        }

        public void setBusy(int busy) {
            this.busy = busy;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getPlaces() {
            return places;
        }

        public void setPlaces(int places) {
            this.places = places;
        }


        //исключение контролируемое
        public void toSit(Entity[] entities) throws NotEnoughPlacesException {
            for (int i=0; i<entities.length;i++){
                System.out.println( entities[i].getName()+ " хочет сесть за стол");
            }
            if (entities.length > this.places) throw new NotEnoughPlacesException(this.places, entities.length);
            else {
                System.out.println("все уместились за столом");
                this.busy += entities.length;
            }

        }

        public void addPerson(Entity entity) throws NotEnoughPlacesException {
            System.out.println( entity.getName()+ " хочет сесть за стол");
            if (this.places == this.busy) throw new NotEnoughPlacesException(this.places, this.places + 1);
            else {
                System.out.println(entity.getName() + " тоже cел за стол");
            }


        }
    }
}
