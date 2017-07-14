package example.panobike_sample.Model;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

/**
 * Created by 150812 on 2017/7/13.
 */

public abstract class PlantModel extends AppCompatImageView {

    public PlantModel(Context context) {
        super(context);
    }

    public PlantModel(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PlantModel(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    abstract void attack();

    abstract void changeWeapon(int weaponType);
}
