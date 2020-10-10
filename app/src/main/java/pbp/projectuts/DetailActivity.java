package pbp.projectuts;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Filter;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.gson.Gson;

import java.util.List;

import pbp.projectuts.adapter.UserRecyclerViewAdapter;
import pbp.projectuts.database.DatabaseClient;
import pbp.projectuts.databinding.ActivityDetailBinding;

// kelas buat show data yg udh register
public class DetailActivity extends AppCompatActivity {
    User user;
    ActivityDetailBinding binding;
    private SearchView search;
    private RecyclerView recyclerView;
    private UserRecyclerViewAdapter adapter;
    private SwipeRefreshLayout refreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail); // isi layout nanti buat pas tampilin data pelanggan

        recyclerView();
        refreshView();
        searchBar();

        String strUser = getIntent().getStringExtra("objMhs");
        Gson gson = new Gson();
        user = gson.fromJson(strUser, User.class);

        binding.setUser(user);
        binding.setActivity(this);
    }

    private void recyclerView() {
        recyclerView = findViewById(R.id.user_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void refreshView() {
        refreshLayout = findViewById(R.id.swipe_refresh);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getUsers();
                refreshLayout.setRefreshing(false);
            }
        });
    }

    private void getUsers(){
        class GetUsers extends AsyncTask<Void, Void, List<User>> {

            @Override
            protected List<User> doInBackground(Void... voids) {
                List<User> userList = DatabaseClient
                        .getInstance(getApplicationContext())
                        .getDatabase()
                        .userDao()
                        .getAll();
                return userList;
            }

            @Override
            protected void onPostExecute(List<User> users) {
                super.onPostExecute(users);
                adapter = new UserRecyclerViewAdapter(DetailActivity.this, users);
                recyclerView.setAdapter(adapter);
                if (users.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Empty List", Toast.LENGTH_SHORT).show();
                }
            }
        }
        GetUsers get = new GetUsers();
        get.execute();
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

    public View.OnClickListener btnBack = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent mainActivity = new Intent(DetailActivity.this, MainActivity.class);
            mainActivity.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(mainActivity);
        }
    };
}
