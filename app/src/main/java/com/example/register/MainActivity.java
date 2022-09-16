package com.example.register;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.register.databinding.ActivityMainBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ApiInterface apiInterface;
    ActivityMainBinding mainBinding;
    String employeeName,employeeEmail,employeePassword,employeeCnfPassword,employid,company,role;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());

        mainBinding.registerSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                employeeName=  mainBinding.employeename.getText().toString().trim();
                employeeEmail= mainBinding.employeeemail.getText().toString().trim();
                employeePassword = mainBinding.employeepassword.getText().toString().trim();
                employeeCnfPassword = mainBinding.employeecnfpassword.getText().toString().trim();
                employid = mainBinding.employid.getText().toString().trim();
                company = mainBinding.company.getText().toString().trim();
                role = mainBinding.role.getText().toString().trim();



                RegisterRequest registerRequest=new RegisterRequest();

                registerRequest.setName(employeeName);
                registerRequest.setEmail(employeeEmail);
                registerRequest.setPassword(employeePassword);
                registerRequest.setConfirm_password(employeeCnfPassword);
                registerRequest.setEmpid(employid);
                registerRequest.setCompany(company);
                registerRequest.setRole(role);

                callApi(registerRequest);
            }
        });


    }

    private void callApi(RegisterRequest registerRequest) {
        apiInterface = Retrofit.getRetrofit().create(ApiInterface.class);
        apiInterface.getresponse(registerRequest).enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response)
            {
                if(response.body()!= null)
                {
                    if(response.body().getStatus()==200)
                    {
                        Toast.makeText(MainActivity.this, ""+response.body().getMsg(), Toast.LENGTH_SHORT).show();


                    }
                    if(response.body().getStatus()==400)
                    {
                        Toast.makeText(MainActivity.this,  "field is required", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(MainActivity.this, "server  not responding...", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t)
            {
                Toast.makeText(MainActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}