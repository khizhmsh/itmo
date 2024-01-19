public enum Song {
    FunnySong("Веселая песня", "Лучший в мире Карлсон... хи-ти-ти-хи... стоит десять тысяч крон... И еще он поймал воров и стрелял из пистолета... Какое интересное зеркало... В нем целиком не виден лучший в мире Карлсон... Но то, что видно, красиво... хи-ти-ти-хи... И в меру упитанный, да, да... И хороший во всех отношениях... "),
    UpsetSong("Грустная песня", "Худший в мире Карлсон... ха-ха-ха-ха... не стоит ни одной кроны... И еще он не поймал воров и не стрелял из пистолета... Какое ужасное зеркало... В нем целиком не виден даже худший в мире Карлсон... ");

    private String text;
    private String description;

    private Song(String description, String text){
        this.text =text;
        this.description = description;
    }
    public String getText(){
        return this.text;
    }

    public String getDescription(){
        return this.description;
    }
}
