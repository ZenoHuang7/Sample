package example.panobike_sample.Model;

import android.app.Activity;
import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

import example.panobike_sample.R;

/**
 * Created by 150812 on 2017/7/13.
 */

public class Plant extends PlantModel implements View.OnTouchListener {

    private WeaponContainer weaponContainer;
    PointF DownPT = new PointF();
    PointF StartPT = new PointF();
    private int screenWidth , screenHeight;

    private ViewListener listener = new ViewListener() {
        @Override
        public void onChangeMissileImage(int type) {

        }

        @Override
        public void onChangeMissileCount(int count) {

        }
    };

    public Plant(Context context) {
        super(context);
        init();
    }

    public Plant(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Plant(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){

        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) getContext()).getWindowManager()
                .getDefaultDisplay()
                .getMetrics(displayMetrics);
        screenWidth = displayMetrics.widthPixels;
        screenHeight = displayMetrics.heightPixels;

        weaponContainer = new WeaponContainer(getContext(),100,WeaponContainer.MISSILE_1);

        this.setOnTouchListener(this);
    }

    @Override
    public void attack() {
        if(weaponContainer.checkMissile()){
            Missile missile = weaponContainer.getMissile();
            playMissile(missile);
            removeMissile(missile);
            listener.onChangeMissileCount(weaponContainer.getMissileCount());
        }
    }

    @Override
    public void changeWeapon(int weaponType) {
        weaponContainer.changeWeapon(weaponType);
        listener.onChangeMissileImage(weaponContainer.getMissileType());
    }

    private <T extends Missile> void playMissile(T missile){
        RelativeLayout.LayoutParams params=new RelativeLayout.LayoutParams
                (RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        int width = missile.getDrawable().getIntrinsicWidth();
        int height = missile.getDrawable().getIntrinsicHeight();
        missile.setX(getX()+(getWidth()/2)-(width/2));
        missile.setY(getY()-height);
        RelativeLayout layout = (RelativeLayout)getRootView().findViewById(R.id.background);
        missile.setLayoutParams(params);
        layout.addView(missile);
        missile.fly(missile.getY());
    }

    private <T extends Missile> void removeMissile(final T missile){
        missile.setOnFinishListener(new Missile.OnFinishListener() {
            @Override
            public void onFinish() {
                missile.remove((RelativeLayout)getRootView().findViewById(R.id.background),missile);
            }
        });
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
                DownPT.x = event.getX();
                DownPT.y = event.getY();
                StartPT = new PointF( getX(), getY() );
                break;
            case MotionEvent.ACTION_MOVE:
                PointF mv = new PointF( event.getX() - DownPT.x, event.getY() - DownPT.y);
                if((StartPT.x + mv.x) <= 0) {
                    setX(0);
                }else if((StartPT.x + mv.x) + getWidth() >= screenWidth){
                    setX(screenWidth - getWidth());
                } else setX((int) (StartPT.x + mv.x));
                if((StartPT.y + mv.y) <=0){
                    setY(0);
                }else if((StartPT.y + mv.y) + getHeight() >= screenHeight){
                    setY(screenHeight - getHeight());
                } else setY((int) (StartPT.y + mv.y));

                StartPT = new PointF( getX(), getY() );
                break;
        }
        return true;
    }

    public interface ViewListener{
        void onChangeMissileImage(int type);
        void onChangeMissileCount(int count);
    }

    public void setViewListener(ViewListener listener){
        this.listener = listener;
        listener.onChangeMissileCount(weaponContainer.getMissileCount());
        listener.onChangeMissileImage(weaponContainer.getMissileType());
    }
}
