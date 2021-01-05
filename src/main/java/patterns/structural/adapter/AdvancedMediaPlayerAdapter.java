package patterns.structural.adapter;

public class AdvancedMediaPlayerAdapter implements MediaPlayer {
    private final AdvancedMediaPlayer advancedMediaPlayer;

    public AdvancedMediaPlayerAdapter() {
        advancedMediaPlayer = new MultiFormatMediaPlayer();
    }

    @Override
    public void play(String audioType, String fileName) {
        if(audioType.equalsIgnoreCase("vlc")){
            advancedMediaPlayer.playVlc(fileName);
        }
        else if(audioType.equalsIgnoreCase("mp4")){
            advancedMediaPlayer.playMp4(fileName);
        }
    }
}
