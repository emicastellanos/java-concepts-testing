package algorithms.strings;

public class URLify {

    private static final char BLANK_SPACE = ' ';

    public static void getConvertedUrl(final char[] urlToTransform, final int size) {
        int lastPosition = urlToTransform.length - 1;
        for (int i = size - 1; i > 0; i--) {
            if (urlToTransform[i] != BLANK_SPACE) {
                urlToTransform[lastPosition] = urlToTransform[i];
                lastPosition--;
            } else {
                urlToTransform[lastPosition] = '0';
                urlToTransform[lastPosition - 1] = '2';
                urlToTransform[lastPosition - 2] = '%';
                lastPosition -= 3;
            }
        }
    }
}
