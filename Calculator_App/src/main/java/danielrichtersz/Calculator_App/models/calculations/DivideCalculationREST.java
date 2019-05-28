package danielrichtersz.Calculator_App.models.calculations;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DivideCalculationREST implements Calculation {

    private static String baseURL = "https://cf-demo-divider-patient-camel.cfapps.io/api";

    @Override
    public double calculate(double a, double b) {
        try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
            HttpGet request = new HttpGet(baseURL + "/calculate/" + a + "/" + b);

            System.out.println("Sending GET request to: " + baseURL + "/calculate/" + a + "/" + b);
            String response = getResponse(httpClient.execute(request), httpClient, request);

            return Double.parseDouble(response);
        }
        catch (IOException e) {
            System.out.println(e);
            return Double.parseDouble(null);
        }
    }

    private String getResponse(CloseableHttpResponse execute, CloseableHttpClient httpClient, HttpRequestBase request) throws IOException {
        HttpResponse response = execute;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                response.getEntity().getContent()));

        System.out.println("Reading response...");

        StringBuilder stringBuilder = new StringBuilder();
        String line = "";
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
            stringBuilder.append(line);
        }

        return stringBuilder.toString();
    }
}
