package hxz.www.commonbase.permission;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.AudioFormat;
import android.media.AudioRecord;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.view.WindowManager;

import com.xingxiu.frame.view.dialog.KlDialog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import hxz.www.commonbase.R;
import hxz.www.commonbase.app.BaseApplication;
import hxz.www.commonbase.base.mvp.BaseActivity;



public class PermissionUtil {

    private static PermissionUtil mInstance;

    private static final List<String> PERMISSIONS = getPermissions();

    private PermissionCallback mPermissionCallback;
    private Set<String> mPermissions;
    private List<String> mPermissionsRequest;
    public String mRequestPermissionDes = "";

    private PermissionUtil() {
    }

    public static PermissionUtil getInstance() {
        if (mInstance == null) {
            mInstance = new PermissionUtil();
        }
        return mInstance;
    }

    /**
     * Set the permissions.
     *
     * @param permissions The permissions.
     * @return the single {@link PermissionUtil} instance
     */
    public PermissionUtil permission(@PermissionConstant.Permission final int... permissions) {
        mRequestPermissionDes = BaseApplication.getInstance().getString(R.string.string_help_text);
        mPermissions = new LinkedHashSet<>();
        for (int permission : permissions) {
            for (String aPermission : PermissionConstant.getPermissions(permission)) {
                if (PERMISSIONS.contains(aPermission)) {
                    mPermissions.add(aPermission);
                }
            }
        }
        return mInstance;
    }

    public PermissionUtil setRequestPermissionDes(String des) {
        mRequestPermissionDes = des;
        return this;
    }

    /**
     * Set the simple call back.
     *
     * @param callback the simple call back
     * @return the single {@link PermissionUtil} instance
     */
    public PermissionUtil callback(final PermissionCallback callback) {
        mPermissionCallback = callback;
        return this;
    }

    /**
     * Return the permissions used in application.
     *
     * @return the permissions used in application
     */
    public static List<String> getPermissions() {
        return getPermissions(BaseApplication.getInstance().getPackageName());
    }

    /**
     * Return the permissions used in application.
     *
     * @param packageName The name of the package.
     * @return the permissions used in application
     */
    public static List<String> getPermissions(final String packageName) {
        PackageManager pm = BaseApplication.getInstance().getPackageManager();
        try {
            return Arrays.asList(pm.getPackageInfo(packageName, PackageManager.GET_PERMISSIONS).requestedPermissions);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }


    /**
     * Return whether <em>you</em> have granted the permissions.
     *
     * @param permissions The permissions.
     * @return {@code true}: yes<br>{@code false}: no
     */
    public static boolean isGranted(final String... permissions) {
        for (String permission : permissions) {
            if (!isGranted(permission)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isGranted(final String permission) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M)
            return true;
//        if (permission.equals(Manifest.permission.RECORD_AUDIO)) {
//            return hasAudioRecordPermission();
//        }
        return PackageManager.PERMISSION_GRANTED == ContextCompat.checkSelfPermission(BaseApplication.getInstance(), permission);
    }

    /**
     * Launch the application's details settings.
     */
    public static void startAppSetting() {
        try {
            // MIUI 8
            Intent localIntent = new Intent("miui.intent.action.APP_PERM_EDITOR");
            localIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            localIntent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
            localIntent.putExtra("extra_pkgname", BaseApplication.getInstance().getPackageName());
            BaseApplication.getInstance().startActivity(localIntent);
        } catch (Exception e) {
            try {
                // MIUI 5/6/7
                Intent localIntent = new Intent("miui.intent.action.APP_PERM_EDITOR");
                localIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                localIntent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
                localIntent.putExtra("extra_pkgname", BaseApplication.getInstance().getPackageName());
                BaseApplication.getInstance().startActivity(localIntent);
            } catch (Exception e1) {
                // 否则跳转到应用详情
                Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setData(Uri.parse("package:" + BaseApplication.getInstance().getPackageName()));
                BaseApplication.getInstance().startActivity(intent);
            }
        }
    }


    /**
     * Start request.
     */
    public void request() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            if (mPermissionCallback != null)
                mPermissionCallback.onGranted();
        } else {
            mPermissionsRequest = new ArrayList<>();
            for (String permission : mPermissions) {
                if (!isGranted(permission)) {
                    mPermissionsRequest.add(permission);
                }
            }
            if (mPermissionsRequest.isEmpty()) {
                if (mPermissionCallback != null)
                    mPermissionCallback.onGranted();
            } else {
                startPermissionActivity();
            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void startPermissionActivity() {
        PermissionActivity.start(BaseApplication.getInstance());
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    public static class PermissionActivity extends BaseActivity {
        private boolean isRequireCheck = true; // 是否需要系统权限检测, 防止和系统提示框重叠
        private String[] permissions;

        public static void start(final Context context) {
            Intent starter = new Intent(context, PermissionActivity.class);
            starter.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(starter);
        }


        @Override
        protected boolean checkDeviceHasNavigationBar(Context context) {
            return false;
        }

        @Override
        protected void init(@Nullable Bundle savedInstanceState) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            if (getInstance().mPermissionsRequest == null) {
                if (getInstance().mPermissionCallback != null)
                    getInstance().mPermissionCallback.onGranted();
                finish();
            } else {
                int size = getInstance().mPermissionsRequest.size();
                permissions = getInstance().mPermissionsRequest.toArray(new String[size]);
                if (permissions == null || permissions.length == 0) {
                    if (getInstance().mPermissionCallback != null)
                        getInstance().mPermissionCallback.onGranted();
                    finish();
                    return;
                }
            }
        }

        @Override
        protected int getLayoutId() {
            return R.layout.activity_permission;
        }


        @Override
        protected void onResume() {
            super.onResume();
            if (isGranted(permissions)) {
                if (getInstance().mPermissionCallback != null)
                    getInstance().mPermissionCallback.onGranted();
                dissmissPermissionDialog();
                finish();
                return;
            } else if (isRequireCheck) {
                requestPermissions(permissions, 1);
            }

        }


        @Override
        public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
            for (String permission : permissions) {
                if (!isGranted(permission)) {
                    isRequireCheck = false;
                    showMissingPermissionDialog();
                    return;
                }
            }
            if (getInstance().mPermissionCallback != null) {
                isRequireCheck = true;
                getInstance().mPermissionCallback.onGranted();
                finish();
            }
        }

        private KlDialog mPermissionDialog = null;

        public void dissmissPermissionDialog() {
            try {
                if (mPermissionDialog != null) {
                    mPermissionDialog.dismiss();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // 显示缺失权限提示
        public void showMissingPermissionDialog() {
            mPermissionDialog = KlDialog.builder(this).setDialogTitle(R.string.help).setMessage(getInstance().mRequestPermissionDes)
                    .setNegativeButton("取消", klDialog -> {
                        if (getInstance().mPermissionCallback != null) {
                            getInstance().mPermissionCallback.onDenied();
                        }
                        finish();
                        return null;
                    }).setPositiveButton(R.string.settings, klDialog -> {
                        startAppSetting();
                        return null;
                    });
            mPermissionDialog.setCancelable(false);
            mPermissionDialog.show();

//            AlertDialog.Builder builder = new AlertDialog.Builder(this);
//            builder.setTitle(R.string.help);
//            builder.setMessage(getInstance().mRequestPermissionDes);
//
//            // 拒绝, 退出应用
//            builder.setNegativeButton(R.string.quit, new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                    if (getInstance().mPermissionCallback != null) {
//                        getInstance().mPermissionCallback.onDenied();
//                    }
//                    finish();
//                }
//            });
//
//            builder.setPositiveButton(R.string.settings, new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                    startAppSetting();
//                }
//            });
//
//            builder.setCancelable(false);
//
//            builder.show();
        }



        @Override
        protected void onDestroy() {
            try {
                super.onDestroy();
                mInstance.destroy();
            } catch (Exception e) {

            }

        }
    }

    /**
     * 音频获取源
     */
    private static int audioSource = MediaRecorder.AudioSource.MIC;
    /**
     * 设置音频采样率，44100是目前的标准，但是某些设备仍然支持22050，16000，11025
     */
    private static int sampleRateInHz = 44100;

    /**
     * 设置音频的录制的声道CHANNEL_IN_STEREO为双声道，CHANNEL_CONFIGURATION_MONO为单声道
     */
    private static int channelConfig = AudioFormat.CHANNEL_IN_STEREO;
    /**
     * 音频数据格式:PCM 16位每个样本。保证设备支持。PCM 8位每个样本。不一定能得到设备支持。
     */
    private static int audioFormat = AudioFormat.ENCODING_PCM_16BIT;
    /**
     * 缓冲区字节大小
     */
    private static int bufferSizeInBytes = 0;

    private static AudioRecord audioRecord;

    /**
     * 判断是是否有录音权限.
     */
    public static boolean hasAudioRecordPermission() {
        try {
            bufferSizeInBytes = 0;
            bufferSizeInBytes = AudioRecord.getMinBufferSize(sampleRateInHz, channelConfig, audioFormat);
            if (audioRecord == null) {
                audioRecord = new AudioRecord(audioSource, sampleRateInHz, channelConfig, audioFormat, bufferSizeInBytes);
            }
            //开始录制音频
            try {
                // 防止某些手机崩溃，例如联想
                audioRecord.startRecording();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }

            /**
             * 根据开始录音判断是否有录音权限
             */
            if (audioRecord.getRecordingState() != AudioRecord.RECORDSTATE_RECORDING) {
                return false;
            }
            audioRecord.stop();
            //释放资源
            audioRecord.release();
            audioRecord = null;

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

///////////////////////////////////////////////////////////////////////////
// interface
///////////////////////////////////////////////////////////////////////////

    public interface PermissionCallback {
        void onGranted();

        void onDenied();

    }

    public void destroy() {
        mPermissions = null;
        mPermissionsRequest = null;
        mInstance = null;
        mPermissionCallback = null;
    }


}
