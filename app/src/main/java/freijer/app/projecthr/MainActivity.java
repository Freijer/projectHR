package freijer.app.projecthr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Intent intent;
    EditText addNUser, addPass;
    Button login;


    private String nameUser = "user";
    private String nameAdmin = "admin";
    private String pass = "12345";
    private String errorLogin = "Не верное имя или пароль";

    private String addresses = " ";
    private String subject = "Востановление пароля";
    private String emailText = "Пароль: " + pass +"\n" + "Логин: " + nameUser + " или" + nameUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addNUser = findViewById(R.id.addUser);
        addPass = findViewById(R.id.addPass);
        login = findViewById(R.id.login);

    }

    public void Login(View v) {
        String readName = addNUser.getText().toString();
        String readPass = addPass.getText().toString();
        intent = new Intent("user.UserStart");
        if (readName.equalsIgnoreCase(nameUser) & readPass.equalsIgnoreCase(pass)) {
            startActivity(intent);
        } else if (readName.equalsIgnoreCase(nameAdmin) & readPass.equalsIgnoreCase(pass)){
            intent = new Intent("admin.AdminStart");
            startActivity(intent);
        }
        else {
            Toast toast = Toast.makeText(getApplicationContext(),
                    errorLogin, Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public void EmailSend(View v){
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, emailText);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void OpenTwitter(View v){
        Intent browseIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/"));
        startActivity(browseIntent);
    }
    public void OpenGoogle(View v){
        Intent browseIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
        startActivity(browseIntent);
    }
    public void OpenFb(View v){
        Intent browseIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/"));
        startActivity(browseIntent);
    }
    public void OpenLi(View v){
        Intent browseIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ru.linkedin.com/"));
        startActivity(browseIntent);
    }

}
