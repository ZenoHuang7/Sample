package example.panobike_sample.Model;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by 150812 on 2017/7/13.
 */

public abstract class MissileModel extends AppCompatImageView {
    public int speed = NORMAL;
    public static int FAST = 4 , NORMAL = 2 , SLOW = 1;

    public MissileModel(Context context) {
        super(context);
    }

    public MissileModel(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MissileModel(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public abstract void remove(ViewGroup viewGroup , View missileView);

    public abstract void setFlySpeed(int speed);

    public abstract void fly(Float startY);
}
