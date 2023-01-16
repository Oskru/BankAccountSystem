import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ExchangeRateAPI {
    private static final String API_URL = "https://open.er-api.com/v6/latest/USD";

    public static double getExchangeRate(String currency) throws Exception {
        URL url = new URL(API_URL);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        con.disconnect();

        String json = content.toString();
        int index = json.indexOf(currency);
        if (index == -1) {
            throw new Exception("Invalid currency code.");
        }
        int startIndex = json.indexOf(':', index) + 1;
        int endIndex = json.indexOf(',', startIndex);
        String rate = json.substring(startIndex, endIndex);
        return Double.parseDouble(rate);
    }
}
