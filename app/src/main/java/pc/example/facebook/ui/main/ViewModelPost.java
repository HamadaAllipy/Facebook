package pc.example.facebook.ui.main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import pc.example.facebook.data.Client;
import pc.example.facebook.pojo.Model;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewModelPost extends ViewModel {

    MutableLiveData<List<Model>> mutableLiveData = new MutableLiveData<>();

    public void setMutableLiveData(){
        Client.getINSTANCE().getPosts().enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
                mutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {

            }
        });
    }
}
