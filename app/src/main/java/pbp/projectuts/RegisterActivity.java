package pbp.projectuts;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.google.gson.Gson;
import pbp.projectuts.databinding.ActivityMainBinding;
import pbp.projectuts.ViewModel;

public class RegisterActivity extends AppCompatActivity {

    User user;
    ActivityMainBinding binding;
    private Button regButton;
//    private FirebaseAuth auth;                buat firebase
//    private String CHANNEL_ID="Channel 1";    buat firebase

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        regButton = findViewById(R.id.signin);
//        auth = FirebaseAuth.getInstance();    buat firebase

        binding = DataBindingUtil.setContentView(this, R.layout.activity_register);

        user = new User();
        binding.setUser(user);
        binding.setActivity(this);
    }

    public View.OnClickListener btnSave = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent detailActivity = new Intent(RegisterActivity.this, DetailActivity.class);

            Gson gson = new Gson();
            String strUser = gson.toJson(user);
            detailActivity.putExtra("objMhs",strUser);
            startActivity(detailActivity);
        }
    };
}
