package pc.example.facebook.data;

import java.util.List;

import pc.example.facebook.pojo.Model;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Client {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private ApiInterface apiInterface ;
    private static Client INSTANCE ;

    public Client() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();
        apiInterface = retrofit.create(ApiInterface.class);
    }

    public  static Client getINSTANCE(){

        if (INSTANCE == null){
            INSTANCE = new Client();
        }
        return INSTANCE ;
    }

    public Call<List<Model>> getPosts(){
        return apiInterface.getPosts();
    }
}
