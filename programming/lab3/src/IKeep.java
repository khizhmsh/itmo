public interface IKeep {
    public void addItem(Item item);
    public void delItem(Item item);
    public void giveItem(Item item, Entity person, boolean importance);
    public boolean haveItem(Item item);

}
