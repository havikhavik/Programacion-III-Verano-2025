import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class StockProfitMaximizer {
    private static final String BASE_URL = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=";
    private static final String API_KEY = "&apikey=";
    private static final String API_KEY_VALUE = "65PY1T8ARO1QH0WF";
    private static final String GET_METHOD = "GET";
    private static final String MEMBER_NAME = "Time Series (Daily)";
    private static final String MEMBER_NAME_1 = "4. close";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el símbolo de la empresa (IBM, AAPL, MSFT): ");
        String symbol = scanner.next().toUpperCase();
        scanner.close();
        List<Double> prices = fetchStockPrices(symbol);

        if (prices.isEmpty()) {
            System.out.println("No se obtuvieron los precios.");
        } else {
            int K = 2; // Número máximo de transacciones
            double maxProfit = maxProfitWithKTransactions(prices, K);
            System.out.println("Ganancia máxima con " + K + " transacciones para " + symbol + ": " + maxProfit);
        }
    }

    private static List<Double> fetchStockPrices(String symbol) {
        List<Double> prices = new ArrayList<>();
        
        try {
            URL url = new URL(BASE_URL + symbol + API_KEY + API_KEY_VALUE);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod(GET_METHOD);

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            JsonParser parser = new JsonParser();
            JsonObject jsonResponse = parser.parse(response.toString()).getAsJsonObject();
            JsonObject timeSeries = jsonResponse.getAsJsonObject(MEMBER_NAME);
            TreeMap<String, Double> sortedPrices = new TreeMap<>();

            if (timeSeries != null) {
                for (Map.Entry<String, JsonElement> entry : timeSeries.entrySet()) {
                    JsonObject dailyData = entry.getValue().getAsJsonObject();
                    double closePrice = dailyData.get(MEMBER_NAME_1).getAsDouble();
                    sortedPrices.put(entry.getKey(), closePrice);
                }
            }

            prices.addAll(sortedPrices.values());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return prices;
    }

    private static double maxProfitWithKTransactions(List<Double> prices, int K) {
        int n = prices.size();
        double[][] dp = new double[K + 1][n];

        for (int k = 1; k <= K; k++) { // transacciones
            double maxDiff = - prices.get(0);
            for (int i = 1; i < n; i++) { // dias
                dp[k][i] = Math.max(dp[k][i - 1], prices.get(i) + maxDiff);
                maxDiff = Math.max(maxDiff, dp[k - 1][i] - prices.get(i));
            }
        }

        return dp[K][n - 1];
    }
}
