package patterns.structural.adapter;

public class AudioPlayer implements MediaPlayer {
    private static final String FORMAT = ".mp3";
    private AdvancedMediaPlayer advancedMediaPlayer;

    public AudioPlayer(AdvancedMediaPlayer advancedMediaPlayer) {
        this.advancedMediaPlayer = advancedMediaPlayer;
    }

    @Override
    public void play(String audioType, String fileName) throws NoSuchFieldException{
        if (audioType.equals(FORMAT)) {
            System.out.println(String.format("Playing %s%s", fileName, audioType));
        }
        switch (audioType) {
            case FORMAT:
                System.out.println(String.format("Playing %s%s", fileName, audioType));
            case ".Vlc":
                advancedMediaPlayer.playVlc(fileName + audioType);
            case ".mp4":
                advancedMediaPlayer.playMp4(fileName + audioType);
            default:
                throw new NoSuchFieldException(String.format("could execute %s files", audioType));
        }
    }
}
