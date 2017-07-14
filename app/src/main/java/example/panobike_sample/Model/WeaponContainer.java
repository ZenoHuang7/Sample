package example.panobike_sample.Model;

import android.content.Context;

/**
 * Created by 150812 on 2017/7/14.
 */

public class WeaponContainer extends WeaponContainerModel{
    public static final int MISSILE_1 = 1,MISSILE_2 = 2, MISSILE_3 = 3;
    private final int MISSILE_1_MINUS = 1, MISSILE_2_MINUS = 2, MISSILE_3_MINUS = 3;
    private int curMissileMinus = MISSILE_1_MINUS , curMissileCount = 0, curWeaponType = MISSILE_1_MINUS;
    private Context context;

    public WeaponContainer(Context context ,int missileCount , int missileType) {
        this.context = context;
        this.curMissileCount = missileCount;
        this.curWeaponType = missileType;
    }

    @Override
    void changeWeapon(int type) {
        curWeaponType = type;
        switch (type){
            case MISSILE_1:
                curMissileMinus = MISSILE_1_MINUS;
                break;
            case MISSILE_2:
                curMissileMinus = MISSILE_2_MINUS;
                break;
            case MISSILE_3:
                curMissileMinus = MISSILE_3_MINUS;
                break;
        }
    }

    @Override
    Boolean checkMissile() {
        return (curMissileCount - curMissileMinus >= 0);
    }

    @Override
    Missile getMissile() {
        switch (curWeaponType){
            case MISSILE_1:
                final Missile1 missile1 = new Missile1(context);
                curMissileCount -= curMissileMinus;
                return missile1;
            case MISSILE_2:
                final Missile2 missile2 = new Missile2(context);
                curMissileCount -= curMissileMinus;
                return missile2;
            case MISSILE_3:
                final Missile3 missile3 = new Missile3(context);
                curMissileCount -= curMissileMinus;
                return missile3;
            default: return null;
        }
    }

    public int getMissileCount(){ return curMissileCount;}

    public int getMissileType(){ return curWeaponType;}
}
