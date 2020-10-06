package user;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;

import freijer.app.projecthr.R;

public class UserStart extends AppCompatActivity {

    int counterChek = 0;
    int flag = 0;
    Intent intent;
    Button mentor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_start);
        mentor = findViewById(R.id.mentor);
    }


    public void ShowNewLvl(View v){
        if(flag == 0) {
            this.counterChek = counterChek + 1;
            if (counterChek >= 3) {
                ViewGroup.LayoutParams params = mentor.getLayoutParams();
                int sizeInPX = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 170, getResources().getDisplayMetrics());
                params.height = sizeInPX;
                params.width = sizeInPX;
                mentor.setLayoutParams(params);
                flag = 1;
            }
        } else if (flag == 1){
            this.counterChek = counterChek - 1;
            if (counterChek == 0) {
                ViewGroup.LayoutParams params = mentor.getLayoutParams();
                int sizeInPX = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 50, getResources().getDisplayMetrics());
                params.height = sizeInPX;
                params.width = sizeInPX;
                mentor.setLayoutParams(params);
                flag = 0;
            }
        }
    } //сеняет размер кнопки в зависимтости от наажтий количества

    public void OpenProfile(View v){
        intent = new Intent("profile.MyProfile");
        startActivity(intent);
    }


    public void GoMessage(View v){
        intent = new Intent("messages.messages");
        startActivity(intent);
    }

}
