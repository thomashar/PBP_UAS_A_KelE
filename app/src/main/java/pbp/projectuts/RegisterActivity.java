package pbp.projectuts;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

//import pbp.projectuts.databinding.ActivityRegisterBinding;

public class RegisterActivity extends AppCompatActivity {

    User user;
    ViewModel viewModel;
//    ActivityRegisterBinding binding;
    private Button regButton;
//    private FirebaseAuth auth;                buat firebase
//    private String CHANNEL_ID="Channel 1";    buat firebase

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
//        auth = FirebaseAuth.getInstance();    buat firebase

//        binding = DataBindingUtil.setContentView(this, R.layout.activity_register);
//
//        viewModel = new ViewModel();
//        binding.setVm(viewModel);
//        binding.setActivity(this);
    }

//    public View.OnClickListener btnSave = new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            Intent detailActivity = new Intent(RegisterActivity.this, DetailActivity.class);
//
//            Gson gson = new Gson();
//            String strUser = gson.toJson(viewModel);
//            detailActivity.putExtra("objMhs",strUser);
//            startActivity(detailActivity);
//        }
//    };

    public void btnSave(View view) {
        Intent detailActivity = new Intent(RegisterActivity.this, MainActivity.class);

        Gson gson = new Gson();
        String strMhs = gson.toJson(user);
        detailActivity.putExtra("objMhs",strMhs);
        startActivity(detailActivity);
    }
}
