package cleancode.listing.refinement14;

public class Main {

    public static void main(String... args) {
        try {
            String[] arguments = {"-l", "-p", "8080", "-d", "/usr/logs"};
            Args arg = new Args("l,p#,d*", arguments);
            boolean logging = arg.getBoolean('l');
            int port = arg.getInt('p');
            String directory = arg.getString('d');
            System.out.println("logging " + logging + " port: " + port + " dir: " + directory);
        } catch (ArgsException e) {
            System.out.printf("Argument error: %s\n", e.errorMessage());
        }

    }
}
