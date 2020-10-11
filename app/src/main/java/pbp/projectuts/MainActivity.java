package pbp.projectuts;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.hardware.Camera;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

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
    private Button BtnFoto;
    private final int REQUEST_CAMERA_CODE = 102;
    private Camera mCamera = null;
    private CameraView mCameraView = null;
    static final int REQUEST_IMAGE_CAPTURE = 1;

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
        //Mengambil foto
        BtnFoto = (Button)findViewById(R.id.Btnfoto);
        BtnFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dispatchTakePictureIntent();
            }
        });
    }

    //Fungsi untuk take picture
    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
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
//    public View.OnClickListener signin = new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            Intent detailActivity = new Intent(MainActivity.this, RegisterActivity.class);
//
//            Gson gson = new Gson();
//            String strMhs = gson.toJson(user);
//            detailActivity.putExtra("objMhs",strMhs);
//            startActivity(detailActivity);
//        }
//    };

//    public View.OnClickListener status = new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            Intent detailActivity = new Intent(MainActivity.this, DetailActivity.class);
//
//            Gson gson = new Gson();
//            String strMhs = gson.toJson(user);
//            detailActivity.putExtra("objMhs",strMhs);
//            startActivity(detailActivity);
//        }
//    };


