package components.android.jeyabalaji.retrofit.retrofit;

import components.android.jeyabalaji.retrofit.data.PredictionResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PlaceAutoCompleteAPI
{
    @GET("api/place/autocomplete/json?types=address&key=YOUR-KEY")
    Call<PredictionResponse> loadPredictions(@Query("input") String address);
}
