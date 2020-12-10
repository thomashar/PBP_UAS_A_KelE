package pbp.projectuts.util;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import pbp.projectuts.R;

public class CustomToast {

    private TextView toastTextView;

    public static void createToast(Context context, String message, boolean error) {
        Toast toast = new Toast(context);
        View view = LayoutInflater.from(context).inflate(R.layout.customtoast, null);
        TextView toastTextView = view.findViewById(R.id.textViewToast);

        SpannableString spannableString = new SpannableString(message);

        toastTextView.setText(spannableString);
        toast.setView(view);
        toast.setDuration(Toast.LENGTH_LONG);

        if (error) {
            toastTextView.setTextColor(Color.parseColor("#020202"));
        } else {
            toastTextView.setTextColor(Color.parseColor("#020202"));
        }

        toast.setGravity(Gravity.BOTTOM, 10, 10);
        toast.show();
    }
}
