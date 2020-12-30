package algorithms.strings;

public class StringCompression {
    protected static final String EMPTY_STRING = "";

    private final String value;


    public StringCompression(String s) {
        this.value = s;
    }

    public String getCompressed() {
        //Stream<Character> valueStram = value.chars().mapToObj(c -> (char) c);
        //valueStram.filter();
        if (this.value.length() == 0) {
            return EMPTY_STRING;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        char target = this.value.charAt(0);
        int count = 0;
        while (i < this.value.length()) {
            if (this.value.charAt(i) == target) {
                count++;
            } else {
                stringBuilder.append(target);
                stringBuilder.append(count);
                target = this.value.charAt(i);
                count = 1;
            }
            i++;
        }

        stringBuilder.append(target);
        stringBuilder.append(count);

        return stringBuilder.length() < this.value.length() ?
                stringBuilder.toString()
                : value;
    }
}
