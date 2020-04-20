package pc.example.facebook.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

import pc.example.facebook.R;
import pc.example.facebook.pojo.Model;

public class MainActivity extends AppCompatActivity {

    //TODO   Retrofit  MVVM   RecyclerView


    ViewModelPost viewModelPost ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewModelPost = ViewModelProviders.of(this).get(ViewModelPost.class);

        viewModelPost.setMutableLiveData();
        RecyclerView recyclerView = findViewById(R.id.Recycler);
        CustomAdapter adapter = new CustomAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        viewModelPost.mutableLiveData.observe(this, new Observer<List<Model>>() {
            @Override
            public void onChanged(List<Model> models) {
                adapter.setModels(models);
            }
        });
    }
}
