package components.android.jeyabalaji.retrofit.data;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PlaceAutoCompleteAPI
{
    @GET("api/place/autocomplete/json?types=address&key=YOUR-KEY")
    Call<Prediction> loadPredictions(@Query("input") String address);
}
