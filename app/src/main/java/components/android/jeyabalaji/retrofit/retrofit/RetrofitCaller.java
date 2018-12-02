package components.android.jeyabalaji.retrofit.retrofit;

import android.os.Build;
import android.support.annotation.RequiresApi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import components.android.jeyabalaji.retrofit.data.PredictionResponse;
import components.android.jeyabalaji.retrofit.data.Prediction_;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitCaller implements Callback<PredictionResponse>
{
    private static String BASE_URL = "https://maps.googleapis.com/maps/";
    public void start() {
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        PlaceAutoCompleteAPI placeAutoCompleteAPI = retrofit.create(PlaceAutoCompleteAPI.class);

        Call<PredictionResponse> call = placeAutoCompleteAPI.loadPredictions("199 pope road");

        call.enqueue(this);

        }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onResponse(Call<PredictionResponse> call, Response<PredictionResponse> response)
    {

        if(response.isSuccessful()) {
            PredictionResponse predictionList = response.body();
            List<Prediction_> actualList = predictionList.getPredictions();
            actualList.forEach(prediction_ -> System.out.println(prediction_.getDescription()));
        }else {
            System.out.println(response.errorBody());
        }

    }

    @Override
    public void onFailure(Call<PredictionResponse> call, Throwable t)
    {
        t.printStackTrace();
    }
}
