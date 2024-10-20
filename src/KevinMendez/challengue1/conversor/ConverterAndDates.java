package KevinMendez.challengue1.conversor;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public  class ConverterAndDates {




    @SerializedName("conversion_rate")
    private double calc;

    private  String moneda1;


    private String moneda2;

    private double cantidad;


public void HttpRequest(){
    try{
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/9d2720d7208efc8aedb5e406/pair/"+this.moneda1+"/"+this.moneda2))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());


        Gson gson= new Gson();
        ConverterAndDates converterAndDates=gson.fromJson(response.body(), ConverterAndDates.class);
        calc= converterAndDates.calc;

    }catch(IOException| InterruptedException e){
        System.out.println("ERROR");
    }
}

    public double getCalc() {

return calc;

    }

    public boolean Converter(String moneda1, String moneda2)  {

        this.moneda1 = moneda1;
        this.moneda2=moneda2;

          HttpRequest();
          return true;
    }


public double ConversionCalc(double cantidad){
this.cantidad=cantidad;
     double resultado;
     resultado=cantidad*getCalc();
return  resultado;
}

public String getMessage(){
    return "El valor de "+this.cantidad+" ["+moneda1.toUpperCase()+"] corresponde al valor final de == "+ConversionCalc(this.cantidad)+" ["+moneda2.toUpperCase()+"] ";
}

}


