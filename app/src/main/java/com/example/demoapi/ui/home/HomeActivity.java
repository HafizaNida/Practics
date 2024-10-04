package com.example.demoapi.ui.home;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.demoapi.R;
import com.example.demoapi.data.model.GetSignUpUserdata;
import com.example.demoapi.databinding.ActivityHomeBinding;
import com.example.demoapi.utils.SharedPref;

public class HomeActivity extends AppCompatActivity {

 TextView textView;
 private ActivityHomeBinding binding;
 GetSignUpUserdata userdata;
 TextView TV1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);
       textView=findViewById(R.id.TV);

//       viewModel = new ViewModelProvider(this).get(HomeViewMOdel.class);

        GetSignUpUserdata userData= SharedPref.getObject(this,"userData",GetSignUpUserdata.class);
        binding.TV1.setText("Welcome! "+userData);
   }

}