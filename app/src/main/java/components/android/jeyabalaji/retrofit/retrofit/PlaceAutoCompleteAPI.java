package components.android.jeyabalaji.retrofit.retrofit;

import components.android.jeyabalaji.retrofit.data.PredictionResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PlaceAutoCompleteAPI
{
    /*
    * @Query() appends the parameter to the HTTP request.
    * In this case, the request made by retrofit looks like
    * BASEURL/api/place/autocomplete/json?types=address&key=YOUR-KEY&input=addressFromUser
    * */
    @GET("api/place/autocomplete/json?types=address&key=YOUR-KEY")
    Call<PredictionResponse> loadPredictions(@Query("input") String address);
}
