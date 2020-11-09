import java.util.*;
import java.io.*;
import java.net.*;

class Main {
    public static void main (String[] args) {
        System.setProperty("http.agent", "Chrome");
        try {
            URL url = new URL("https://coderbyte.com/api/challenges/json/age-counting");
            try {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(url.openStream()));
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    String[] strings = inputLine.split(":");
                    String parsedString = strings[1]
                            .replaceAll("\"}","")
                            .replace("\"","");
                    String[] keyValues = parsedString.split(",");
                    System.out.println(Arrays.stream(keyValues).filter(s -> s.contains("age") && Integer.parseInt(s.split("=")[1]) >= 50).count());
                }
                in.close();
            } catch (IOException ioEx) {
                System.out.println(ioEx);
            }
        } catch (MalformedURLException malEx) {
            System.out.println(malEx);
        }
    }
}
