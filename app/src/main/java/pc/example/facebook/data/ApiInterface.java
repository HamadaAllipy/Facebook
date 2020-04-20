package pc.example.facebook.data;

import java.util.List;

import pc.example.facebook.pojo.Model;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("posts")
    public Call<List<Model>> getPosts();
}
