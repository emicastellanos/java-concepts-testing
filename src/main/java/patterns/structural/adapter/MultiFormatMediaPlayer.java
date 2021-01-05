package patterns.structural.adapter;

public class MultiFormatMediaPlayer implements AdvancedMediaPlayer {

    @Override
    public void playVlc(String fileName) {
        System.out.println(String.format("Playing Vlc file: Name %s", fileName));
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println(String.format("Playing mp4 file. Name: %s", fileName));
    }
}



