package digitalhouse.com.tipflixapiretrofit.Service;

import digitalhouse.com.tipflixapiretrofit.pojo.Example;
import digitalhouse.com.tipflixapiretrofit.pojo.Result;
import retrofit2.Call;
import retrofit2.http.GET;

public interface FilmesService {

    @GET("4sblo")
    Call<Example> listCatalogo();
}
