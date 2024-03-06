package Resources;

public enum Devices {
    Pixel6Pro("1B181FDEE004X4", "14"),
    GalaxyS23("RFCW100BN4N", "13"),
    OnePlusNord20("Q4C6SC69OZ9HAEEU", "11"),
    GalaxyS21Plus("RFCNC0CZA8J", "12");

    private final String id;
    private final String platformVersion;

    private Devices(String id, String platfromVersion){
        this.id = id;
        this.platformVersion = platfromVersion;
    }

    public String getId(){
        return id;
    }

    public String getPlatformVersion(){
        return platformVersion;
    }
}
