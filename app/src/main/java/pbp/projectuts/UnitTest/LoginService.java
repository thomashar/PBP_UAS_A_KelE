package pbp.projectuts.UnitTest;


import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;


public class LoginService {
    private CountDownLatch authSignal = null;
    private FirebaseAuth auth;

//    @Override
    public void setUp() throws InterruptedException {
        authSignal = new CountDownLatch(1);
//        Firebase.setAndroidContext(mContext); //initializeFireBase(context);

        auth = FirebaseAuth.getInstance();
        if(auth.getCurrentUser() == null) {
            auth.signInWithEmailAndPassword("thomasharyowibisono84@gmail.com", "password").addOnCompleteListener(
                    new OnCompleteListener<AuthResult>() {

                        @Override
                        public void onComplete(@NonNull final Task<AuthResult> task) {

                            final AuthResult result = task.getResult();
                            final FirebaseUser user = result.getUser();
                            authSignal.countDown();
                        }
                    });
        } else {
            authSignal.countDown();
        }
        authSignal.await(10, TimeUnit.SECONDS);
    }

//    @Override
    public void tearDown() throws Exception {
//        super.tearDown();
        if(auth != null) {
            auth.signOut();
            auth = null;
        }
    }

//    @Test
    public void testWrite() throws InterruptedException {
        final CountDownLatch writeSignal = new CountDownLatch(1);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Do you have data? You'll love Firebase. - 3")
                .addOnCompleteListener(new OnCompleteListener<Void>() {

                    @Override
                    public void onComplete(@NonNull final Task<Void> task) {
                        writeSignal.countDown();
                    }
                });

        writeSignal.await(10, TimeUnit.SECONDS);
    }
    public Boolean getValid(final LoginView view, String nim, String password) throws InterruptedException {
        final Boolean[] bool = new Boolean[1];
        setUp();
        return bool[0];
    }
}

