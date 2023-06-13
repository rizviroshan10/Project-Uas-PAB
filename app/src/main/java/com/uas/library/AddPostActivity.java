package com.uas.library;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.uas.library.databinding.ActivityAddPostBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddPostActivity extends AppCompatActivity {
    private ActivityAddPostBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Events");



        binding = ActivityAddPostBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = binding.etContent.getText().toString();
                String judul = binding.etJudul.getText().toString();
                String foto = binding.etFoto.getText().toString();
                int jumlah = binding.etJumlah.getInputType();

                boolean bolehPost = true;

                if (TextUtils.isEmpty(judul)) {
                    bolehPost = false;
                    binding.etJudul.setError("judul tidak boleh kosong");
                }

                if (bolehPost) {
                    String userId = Utility.getValue(AddPostActivity.this, "xUserId");
                    addPost(userId, content, foto, judul, jumlah);
                }
            }
        });
    }

    private void addPost(String userId, String content, String foto, String judul, int jumlah) {
        binding.progressBar.setVisibility(View.VISIBLE);
        APIService api = Utility.getRetrofit().create(APIService.class);
        Call<<ValueData<Post>> call = api.addPost(userId, content, foto, judul, jumlah);
        call.enqueue(new Callback<ValueNoData>() {
            @Override
            public void onResponse(Call<<ValueData<Post>> call, Response<<ValueData<Post>> response) {
                binding.progressBar.setVisibility(View.GONE);
                if (response.code() == 200) {
                    int success = response.body().getSuccess();
                    String message = response.body().getMessage();

                    if (success == 1) {
                        Toast.makeText(AddPostActivity.this, message, Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(AddPostActivity.this, message, Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(AddPostActivity.this, "Response" + response.code(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<<ValueData<Post>> call, Throwable t) {
                binding.progressBar.setVisibility(View.GONE);
                System.out.println("Retrofit Error : " + t.getMessage());
                Toast.makeText(AddPostActivity.this, "Retrofit Error : " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}