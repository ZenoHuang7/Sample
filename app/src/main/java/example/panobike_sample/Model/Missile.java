package example.panobike_sample.Model;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;

/**
 * Created by 150812 on 2017/7/13.
 */

public class Missile extends MissileModel{
    private OnFinishListener onFinishListener;

    public Missile(Context context) {
        super(context);
    }

    public Missile(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Missile(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void remove(ViewGroup viewGroup, View missileView) {
        viewGroup.removeView(missileView);
    }

    @Override
    public void setFlySpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public void fly(Float startY) {
        ValueAnimator animator = ValueAnimator.ofFloat(startY,-200);
        animator.setDuration((long)(startY / speed ));
        animator.setInterpolator(new LinearInterpolator());
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Float curValue = (Float)animation.getAnimatedValue();
                setY(curValue);
            }
        });

        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                //super.onAnimationEnd(animation);
                if(onFinishListener != null) onFinishListener.onFinish();
            }
        });
        animator.start();
    }

    public interface OnFinishListener {
        void onFinish();
    }

    public void setOnFinishListener(OnFinishListener callBack) {
        onFinishListener = callBack;
    }

}
