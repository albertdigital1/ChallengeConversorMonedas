package mychallenge;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Map;

public class Moneda {





    @SerializedName("result")
    public String status;
    //private Map<String, Double> conversion_rates;
    private JsonObject conversion_rates; // Uso de JsonObject para mantener flexibilidad


//    // Getters para acceder a los valores
//    public Map<String, Double> getConversionRates() {
//        return conversion_rates;
//    }


    // Getter para acceder a conversion_rates
    public JsonObject getConversionRates() {
        return conversion_rates;
    }


}


