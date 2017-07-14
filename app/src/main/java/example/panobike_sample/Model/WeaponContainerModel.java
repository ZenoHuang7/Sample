package example.panobike_sample.Model;

/**
 * Created by 150812 on 2017/7/14.
 */

public abstract class WeaponContainerModel {

    abstract void changeWeapon(int type);

    abstract Boolean checkMissile();

    abstract <T extends Missile> T getMissile();

}
