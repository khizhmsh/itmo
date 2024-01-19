public class NotEnoughPlacesException extends Exception {
    int needSit;
    int places;
    public NotEnoughPlacesException(int places, int needSit) {
        super("-------------------------" + "\nОШИБКА " + "\nМЕСТ ЗА СТОЛОМ " + places + "\nНЕОБЪОДИМО " + needSit + "\n-------------------------" );
        this.needSit = needSit;
        this.places = places;
    }

}