package profile;

import androidx.appcompat.app.AppCompatActivity;

import data.DataHelper;
import freijer.app.projecthr.R;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MyProfile extends AppCompatActivity {

    Intent intent;
    int flag;
    public int getFlag() {
        return flag;
    }
    public void setFlag(int flag) {
        this.flag = flag;
    }

    DataHelper dbHelper;
    EditText editName, editTeam, editWork, editNumber, editSelf;
    Button save, readDB, home;
    ProgressBar progressBar;

    String name;
    String team;
    String work;
    String number;
    String selfinfo;

    int name_count;
    int team_count;
    int work_count;
    int number_count;
    int selfinfo_count;

    public int getName_count() {
        return name_count;
    }
    public void setName_count(int name_count) {
        this.name_count = name_count;
    }
    public int getTeam_count() {
        return team_count;
    }
    public void setTeam_count(int team_count) {
        this.team_count = team_count;
    }
    public int getWork_count() {
        return work_count;
    }
    public void setWork_count(int work_count) {
        this.work_count = work_count;
    }
    public int getNumber_count() {
        return number_count;
    }
    public void setNumber_count(int number_count) {
        this.number_count = number_count;
    }
    public int getSelfinfo_count() {
        return selfinfo_count;
    }
    public void setSelfinfo_count(int selfinfo_count) {
        this.selfinfo_count = selfinfo_count;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);
        dbHelper = new DataHelper(this);

        editName = findViewById(R.id.editName);
        editTeam= findViewById(R.id.editTeam);
        editWork = findViewById(R.id.editWork);
        editNumber= findViewById(R.id.editNumber);
        editSelf= findViewById(R.id.editSelf);
        save = findViewById(R.id.save);
        readDB = findViewById(R.id.readDB);
        home = findViewById(R.id.home);

//        if(getFlag()==1) {
          ReadfromDB();
//        }
        progressBar = findViewById(R.id.progressBar);
        progressBar.setMax(5);

        ProgressProfile();
        progressBar.setProgress(getName_count()+getTeam_count()+getWork_count()+getNumber_count()+getSelfinfo_count());
    }


    public void AddDB(View v)   {
        name = editName.getText().toString();
        team = editTeam.getText().toString();
        work = editWork.getText().toString();
        number = editNumber.getText().toString();
        selfinfo = editSelf.getText().toString();
        dbHelper.WriteDB(name, team, work,  number, selfinfo);

        if (name.isEmpty() || name.length() == 0 || name.equals("") || name == null){
            setName_count(0);
        }else {
            setName_count(1);}
        if (team.isEmpty() || team.length() == 0 || team.equals("") || team == null){
            setTeam_count(0);
        } else {
            setTeam_count(1); }
        if (work.isEmpty() || work.length() == 0 || work.equals("") ||work == null){
            setWork_count(0);
        } else {
            setWork_count(1); }
        if (number.isEmpty() || number.length() == 0 || number.equals("") ||number == null){
            setNumber_count(0);
        } else {
            setNumber_count(1); }
        if (selfinfo.isEmpty() || selfinfo.length() == 0 || selfinfo.equals("") ||selfinfo == null){
            setSelfinfo_count(0);
        } else {
            setSelfinfo_count(1);
        }
//        setFlag(1);
    } // добавить запись

    public void ReadfromDB() {
        dbHelper.ReadDB();
        editName.setText(dbHelper.getValueName());
        editTeam.setText(dbHelper.getValueTeam());
        editWork.setText(dbHelper.getValueWork());
        editNumber.setText(dbHelper.getValueNumber());
        editSelf.setText(dbHelper.getValueSelfinfo());
    } // прочесть последнюю запись

    public void GoHome(View v){
        intent = new Intent("user.UserStart");
        startActivity(intent);
    }

    public void GoMessage(View v){
        intent = new Intent("messages.messages");
        startActivity(intent);
    }

    public void  ProgressProfile(){
        name = editName.getText().toString();
        team = editTeam.getText().toString();
        work = editWork.getText().toString();
        number = editNumber.getText().toString();
        selfinfo = editSelf.getText().toString();
        if (name.isEmpty() || name.length() == 0 || name.equals("") || name == null){
           setName_count(0);
        }else {
            setName_count(1);}
        if (team.isEmpty() || team.length() == 0 || team.equals("") || team == null){
           setTeam_count(0);
        } else {
            setTeam_count(1); }
        if (work.isEmpty() || work.length() == 0 || work.equals("") ||work == null){
            setWork_count(0);
        } else {
            setWork_count(1); }
        if (number.isEmpty() || number.length() == 0 || number.equals("") ||number == null){
            setNumber_count(0);
        } else {
            setNumber_count(1); }
        if (selfinfo.isEmpty() || selfinfo.length() == 0 || selfinfo.equals("") ||selfinfo == null){
            setSelfinfo_count(0);
        } else {
            setSelfinfo_count(1);
        }
    }

}
