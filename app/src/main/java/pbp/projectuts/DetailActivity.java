package pbp.projectuts;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Filter;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import pbp.projectuts.databinding.ActivityDetailBinding;
import pbp.projectuts.adapter.UserRecyclerViewAdapter;

// kelas buat show data yg udh register
public class DetailActivity extends AppCompatActivity {
    User user;
    ActivityDetailBinding binding;
    private SearchView search;
    private RecyclerView recyclerView;
    private UserRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail); // isi layout nanti buat pas tampilin data pelanggan

        String strUser = getIntent().getStringExtra("objMhs");
        Gson gson = new Gson();
        user = gson.fromJson(strUser, User.class);

        binding.setUser(user);
        binding.setActivity(this);
    }

    public Filter getFilter() {
        return filterUser;
    }

    private void searchBar() {
        search = findViewById(R.id.bar_search);
        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });
    }

    public View.OnClickListener btnBackClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent mainActivity = new Intent(DetailActivity.this, MainActivity.class);
            mainActivity.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(mainActivity);
        }
    };
}
