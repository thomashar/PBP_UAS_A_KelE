package pbp.projectuts.UnitTest;

import android.content.Context;
import android.content.Intent;

import pbp.projectuts.MainActivity;
import pbp.projectuts.User;
import pbp.projectuts.UserActivity;

public class ActivityUtil {
    private Context context;
    public ActivityUtil(Context context) {
        this.context = context;
    }
    public void startMainActivity() {
        context.startActivity(new Intent(context, MainActivity.class));
    }
    public void startUserProfile(User user) {
        Intent i = new Intent(context, UserActivity.class);
        i.putExtra("id",user.getId());
        i.putExtra("name",user.getNama());
        i.putExtra("telp",user.getTelp());
        i.putExtra("berat",user.getBerat());
        i.putExtra("tglOrder",user.getTglOrder());
        i.putExtra("tglAmbil",user.getTglAmbil());
        context.startActivity(i);
    }
}
