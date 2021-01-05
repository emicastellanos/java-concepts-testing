package patterns.structural.adapter;

public interface MediaPlayer {

    void play(String audioType, String fileName) throws NoSuchFieldException;
}
