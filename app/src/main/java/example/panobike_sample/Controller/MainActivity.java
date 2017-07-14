package example.panobike_sample.Controller;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import example.panobike_sample.Model.Plant;
import example.panobike_sample.Model.WeaponContainer;
import example.panobike_sample.R;

public class MainActivity extends AppCompatActivity implements Plant.ViewListener {
    private Plant plant;
    private Button btnFire;
    private ImageView ivMissile1, ivMissile2, ivMissile3, ivCurMissile;
    private TextView tvMissileCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        plant = (Plant) findViewById(R.id.imageview_plant);
        btnFire = (Button) findViewById(R.id.btn_fire);
        ivMissile1 = (ImageView) findViewById(R.id.imageview_missile_type1);
        ivMissile2 = (ImageView) findViewById(R.id.imageview_missile_type2);
        ivMissile3 = (ImageView) findViewById(R.id.imageview_missile_type3);
        tvMissileCount = (TextView) findViewById(R.id.textview_count);
        ivCurMissile = (ImageView) findViewById(R.id.imageview_missile_type);

        ivMissile1.setOnClickListener(clickListener);
        ivMissile2.setOnClickListener(clickListener);
        ivMissile3.setOnClickListener(clickListener);
        btnFire.setOnClickListener(clickListener);
        plant.setViewListener(this);
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_fire:
                    plant.attack();
                    break;
                case R.id.imageview_missile_type1:
                    plant.changeWeapon(WeaponContainer.MISSILE_1);
                    break;
                case R.id.imageview_missile_type2:
                    plant.changeWeapon(WeaponContainer.MISSILE_2);
                    break;
                case R.id.imageview_missile_type3:
                    plant.changeWeapon(WeaponContainer.MISSILE_3);
                    break;
            }
        }
    };

    @Override
    public void onChangeMissileImage(int type) {
        switch (type) {
            case WeaponContainer.MISSILE_1:
                ivCurMissile.setImageDrawable(ContextCompat.getDrawable(getBaseContext(), R.mipmap.missile1));
                break;
            case WeaponContainer.MISSILE_2:
                ivCurMissile.setImageDrawable(ContextCompat.getDrawable(getBaseContext(), R.mipmap.missile2));
                break;
            case WeaponContainer.MISSILE_3:
                ivCurMissile.setImageDrawable(ContextCompat.getDrawable(getBaseContext(), R.mipmap.missile3));
                break;
        }
    }

    @Override
    public void onChangeMissileCount(int count) {
        tvMissileCount.setText(Integer.toString(count));
    }

}
