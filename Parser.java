import java.util.stream.*;
import java.io.*;
import java.net.*;


public class Main {

    public static String fromStream(final InputStream inputStream) {
        String result = null;
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            result = reader.lines().collect(Collectors.joining("\n"));
        } catch (UnsupportedEncodingException exception) {
            exception.printStackTrace();
            return null;
        } finally {
            try {
                if(reader != null)
                    reader.close();
                if(inputStream != null)
                    inputStream.close();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }

        return result;
    }

    public static String jsonParser(String json, final String propertyName) {
        if(json == null)
            return null;
        int lastIndex = json.lastIndexOf(String.format("\"%s\"", propertyName));
        json = json.substring(lastIndex);
        lastIndex = json.lastIndexOf("[");
        json = json.substring(lastIndex+1);
        return json = json
                .replaceAll("[\\]}\"]", "")
                .replaceAll("\\,", ", ")
                .trim();
    }
    public static void main(String[] args) {
        System.setProperty("http.agent", "Chrome");
        try {
            URL url = new URL("https://coderbyte.com/api/challenges/json/age-counting");
            try {
                URLConnection connection = url.openConnection();
                InputStream inputStream = connection.getInputStream();
                System.out.println(jsonParser(fromStream(inputStream), "data"));
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        } catch (MalformedURLException exception) {
            exception.printStackTrace();
        }
    }
}
