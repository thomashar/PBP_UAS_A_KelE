package pbp.projectuts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.databinding.DataBindingUtil;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import pbp.projectuts.databinding.ActivityMainBinding;

//  kelas buat halaman login
public class MainActivity extends AppCompatActivity {

    User user;
    ActivityMainBinding binding;
    private Button regButton;
//    private FirebaseAuth auth;                buat firebase
//    private String CHANNEL_ID="Channel 1";    buat firebase

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        regButton = findViewById(R.id.signin);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        user = new User();
        binding.setUser(user);
        binding.setActivity(this);
    }


}