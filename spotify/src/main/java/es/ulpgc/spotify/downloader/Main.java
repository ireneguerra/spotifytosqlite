package es.ulpgc.spotify.downloader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Main {
public static void main(String[] args) throws Exception {
        Map<String, String> artists = new HashMap<>();
        artists.put("5pKCCKE2ajJHZ9KAiaK11H", "Rihanna");
        artists.put("06HL4z0CvFAxyc27GXpf02", "Taylor Swift");
        artists.put("7n2wHs1TKAczGzO7Dd2rGr", "Shawn Mendes");
        artists.put("5M9Bb4adKAgrOFOhc05Y50", "Pablo Alborán");
        artists.put("1Xyo4u8uXC1ZmMpatF05PJ", "The Weeknd");
        while (true) {
            System.out.println("SPOTIFY DATABASE");
            System.out.println("Introduce:");
            System.out.println("1: if you want to add an artist with their albums and tracks.");
            System.out.println("2: if you are not going to do anything.");
            Scanner scanner = new Scanner(System.in);
            int num = scanner.nextInt();
            if (num == 1) {
                System.out.println("Introduce the artist's id:");
                String id = scanner.next();
                artists.put(id, "");
            }
            if (num == 2) {
                break;
            }
        }
            Controller controller = new Controller();
            controller.control(artists);

    }
}
