package pbp.projectuts;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.google.gson.Gson;

import pbp.projectuts.databinding.ActivityMainBinding;

//  kelas buat halaman login
public class MainActivity extends AppCompatActivity {

    User user;
    ActivityMainBinding binding;
//    private FirebaseAuth auth;                buat firebase
//    private String CHANNEL_ID="Channel 1";    buat firebase

    //Akses Kamera
    private final int REQUEST_CAMERA_CODE = 102;
    private Camera mCamera = null;
    private CameraView mCameraView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        user = new User();
        binding.setUser(user);
        binding.setActivity(this);

        //Permission Allow Camera
        if(checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[]{Manifest.permission.CAMERA},REQUEST_CAMERA_CODE);
        }
    }

    public void btnSignin(View view) {
        Intent detailActivity = new Intent(MainActivity.this, RegisterActivity.class);

        Gson gson = new Gson();
        String strMhs = gson.toJson(user);
        detailActivity.putExtra("objMhs", strMhs);
        startActivity(detailActivity);
    }

    public void btnStatus(View view) {
        Intent detailActivity = new Intent(MainActivity.this, DetailActivity.class);

        Gson gson = new Gson();
        String strMhs = gson.toJson(user);
        detailActivity.putExtra("objMhs", strMhs);
        startActivity(detailActivity);
    }

    public void btnLocation(View view) {
        Intent detailActivity = new Intent(MainActivity.this, MapLocation.class);

        Gson gson = new Gson();
        String strMhs = gson.toJson(user);
        detailActivity.putExtra("objMhs", strMhs);
        startActivity(detailActivity);
    }
}



