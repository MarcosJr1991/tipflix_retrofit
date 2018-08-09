package digitalhouse.com.tipflixapiretrofit.pojo;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Example {

    @SerializedName("results")
    private List<Result> example;


    public List<Result> getExample() {
        return example;
    }

    public void setExample(List<Result> example) {
        this.example = example;
    }
}