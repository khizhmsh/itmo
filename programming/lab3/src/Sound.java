public enum Sound {
    GUN("Ружьё", "ба-бах"),
    PISTOL("Пистолет", "пив-пав"),
    LAUGHTER("Смех", "хи-ти-ти-хи");
    private String name;
    private String soud;
    private Sound(String name, String sound){
        this.soud = sound;
        this.name = name;

    }
    public String getSoud() {
        return this.soud;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "Wepon{" +
                "name='" + name + '\'' +
                ", loud='" + soud + '\'' +
                '}';
    }
}

