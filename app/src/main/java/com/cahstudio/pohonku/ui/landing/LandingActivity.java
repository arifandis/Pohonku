package com.cahstudio.pohonku.ui.landing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.cahstudio.pohonku.R;
import com.cahstudio.pohonku.ui.main.MainActivity;

public class LandingActivity extends AppCompatActivity implements View.OnClickListener {
    ViewPager viewPager;
    AppCompatButton btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        initialize();
    }

    void initialize(){
        viewPager = findViewById(R.id.landing_viewPager);
        btnNext = findViewById(R.id.landing_btnNext);

        btnNext.setOnClickListener(this);

        LandingViewPager adapter = new LandingViewPager(getSupportFragmentManager());
        adapter.addFragment(new Landing1Fragment());
        adapter.addFragment(new Landing2Fragment());
        adapter.addFragment(new Landing3Fragment());
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        btnNext.setText("Lanjut");
                        break;
                    case 1:
                        btnNext.setText("Lanjut");
                        break;
                    case 2:
                        btnNext.setText("Mulai Sekarang");
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private int getItem(int i) {
        return viewPager.getCurrentItem() + i;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.landing_btnNext:
                String text = btnNext.getText().toString();
                if (text.equals("Lanjut")){
                    viewPager.setCurrentItem(getItem(1), true);
                }else{
                    startActivity(new Intent(this, MainActivity.class));
                    finish();
                }
                break;
        }
    }
}