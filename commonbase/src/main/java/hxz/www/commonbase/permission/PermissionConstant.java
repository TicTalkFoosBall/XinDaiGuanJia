package hxz.www.commonbase.permission;

import android.Manifest;
import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


public class PermissionConstant {
    public static final int STORAGE = 0;//读写外部存储空间
    public static final int MICROPHONE = 1;//录音
    public static final int CAMERA = 2;//相机
    public static final int LOCATION = 3;//定位
    public static final int CONTACTS = 4;//联系人权限
    public static final int PHONE = 5;//设备信息
    public static final int SMS = 6;//短信权限
    public static final int KELA_INIT_PERMISSION = 7; //克拉初始权限

    @IntDef({STORAGE, MICROPHONE, CAMERA, LOCATION, CONTACTS, PHONE, SMS, KELA_INIT_PERMISSION})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Permission {
    }

    private static final String[] GROUP_KELA = {
            Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION
    };

    private static final String[] GROUP_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    private static final String[] GROUP_MICROPHONE = {
            Manifest.permission.RECORD_AUDIO
    };

    private static final String[] GROUP_CAMERA = {
            Manifest.permission.CAMERA,  Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE
    };

    private static final String[] GROUP_LOCATION = {
            Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION
    };

    private static final String[] GROUP_PHONE = {
            Manifest.permission.READ_PHONE_STATE
//            , permission.READ_PHONE_NUMBERS, permission.CALL_PHONE,
//            permission.ANSWER_PHONE_CALLS, permission.READ_CALL_LOG, permission.WRITE_CALL_LOG,
//            permission.ADD_VOICEMAIL, permission.USE_SIP, permission.PROCESS_OUTGOING_CALLS
    };

    private static final String[] GROUP_CONTACTS = {
            Manifest.permission.READ_CONTACTS, Manifest.permission.WRITE_CONTACTS, Manifest.permission.GET_ACCOUNTS
    };

    private static final String[] GROUP_SMS = {
            Manifest.permission.SEND_SMS, Manifest.permission.RECEIVE_SMS, Manifest.permission.READ_SMS,
            Manifest.permission.RECEIVE_WAP_PUSH, Manifest.permission.RECEIVE_MMS,
    };


    public static String[] getPermissions(@Permission final int permission) {
        switch (permission) {
            case STORAGE:
                return GROUP_STORAGE;
            case MICROPHONE:
                return GROUP_MICROPHONE;
            case CAMERA:
                return GROUP_CAMERA;
            case LOCATION:
                return GROUP_LOCATION;
            case CONTACTS:
                return GROUP_CONTACTS;
            case PHONE:
                return GROUP_PHONE;
            case SMS:
                return GROUP_SMS;
            case KELA_INIT_PERMISSION:
                return GROUP_KELA;

        }
        return new String[]{""};
    }


}
