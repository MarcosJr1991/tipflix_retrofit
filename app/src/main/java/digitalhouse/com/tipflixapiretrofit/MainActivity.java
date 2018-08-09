package digitalhouse.com.tipflixapiretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

import digitalhouse.com.tipflixapiretrofit.pojo.Example;
import digitalhouse.com.tipflixapiretrofit.Service.ConfiguradorRetrofit;
import digitalhouse.com.tipflixapiretrofit.Service.FilmesService;
import digitalhouse.com.tipflixapiretrofit.pojo.Result;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView text;
    private static final String TAG = "David";
    private int valor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.text);

        FilmesService service = ConfiguradorRetrofit.getRetrofitInstance().create(FilmesService.class);
        Call<Example> requestCatalogo = service.listCatalogo();

        requestCatalogo.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                if (response.isSuccessful()) {
                    Example result = response.body();
                    List <Result> lista = result.getExample();
                    //int i = 0;
                    text.setText(lista.get(2).getTitle());
                }
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Log.e(TAG, "Deu muito ruim" + t.getMessage());
            }
        });

    }
}
