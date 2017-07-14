package example.panobike_sample.Model;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;

import example.panobike_sample.R;

/**
 * Created by 150812 on 2017/7/13.
 */

public class Missile2 extends Missile {

    public Missile2(Context context) {
        super(context);
        setImageDrawable(ContextCompat.getDrawable(context, R.mipmap.missile2));
        setFlySpeed(Missile.NORMAL);
    }

    public Missile2(Context context, AttributeSet attrs) {
        super(context, attrs);
        setImageDrawable(ContextCompat.getDrawable(context,R.mipmap.missile2));
        setFlySpeed(Missile.NORMAL);
    }

    public Missile2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setImageDrawable(ContextCompat.getDrawable(context,R.mipmap.missile2));
        setFlySpeed(Missile.NORMAL);
    }
}
