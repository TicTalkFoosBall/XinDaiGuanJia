package com.longer.creditManager;


import android.Manifest;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.longer.creditManager.util.AndroidBug54971Workaround;
import com.tbruyelle.rxpermissions.RxPermissions;

import org.angmarch.views.NiceSpinner;

import java.util.ArrayList;
import java.util.List;

import hxz.www.commonbase.permission.PermissionConstant;
import hxz.www.commonbase.permission.PermissionUtil;
import rx.functions.Action1;


public class Main5Activity extends AppCompatActivity implements View.OnClickListener {
    private Button b1, b2;
    private ImageView iv;
    private NiceSpinner ns;
    private List<String> data = new ArrayList<>();
    //    public static final String[] SET_PERMISSION = new String[]{
//            Permission.READ_EXTERNAL_STORAGE,
//            Permission.WRITE_EXTERNAL_STORAGE,
//             Permission.CAMERA};
    private Intent intent;

    /**
     * 表示选择的是相机--0
     */
    public static final int IMAGE_CAPTURE = 0;
    /**
     * 表示选择的是相册--1
     */
    public static final int IMAGE_MEDIA = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        AndroidBug54971Workaround.assistActivity(findViewById(android.R.id.content), this);

        initView();
        initData();
    }

    private void initData() {

        data.add("1");
        data.add("2");
        data.add("3");
        data.add("4");
        data.add("5");
        data.add("6");

        ns.attachDataSource(data);

    }

    private void initView() {

        b1 = findViewById(R.id.b1);
        b1.setOnClickListener(this);
        b2 = findViewById(R.id.b2);
        b2.setOnClickListener(this);
        iv = findViewById(R.id.iv);

        ns = findViewById(R.id.ns);

        //ns.setOnItemSelectedListener();

        ns.addOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Main5Activity.this, "你点击的是：" + position, Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == b1.getId()) {
//            if (!AndPermission.hasPermissions(this,SET_PERMISSION)) {
//                testRxPermission();
//            } else {
//                take2Pic();
//            }
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
                Log.e("z", "num" + Build.VERSION_CODES.N + "-----" + Build.VERSION.SDK_INT);
                take2Pic();
            } else {
                int audioPermission = PermissionConstant.MICROPHONE;
                if (PermissionUtil.isGranted(PermissionConstant.getPermissions(PermissionConstant.STORAGE),PermissionConstant.getPermissions(PermissionConstant.CAMERA)))
                {

                }
                else
                {
                    take2Pic();
                }
                if (!AndPermission.hasPermissions(this, SET_PERMISSION)) {
                    testRxPermission();
                    take2Pic();
                } else {

                }
            }


        } else if (v.getId() == b2.getId()) {
            if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.M) {
                Log.e("z", "num" + Build.VERSION_CODES.N + "-----" + Build.VERSION.SDK_INT);
                pic2Images();
            } else {

                if (!AndPermission.hasPermissions(this, SET_PERMISSION)) {
                    testRxPermission2();
                } else {
                    pic2Images();
                }
            }

        }

    }

    // 动态权限
    private void testRxPermission() {


        RxPermissions.getInstance(this)
                .request(Manifest.permission.CAMERA)//这里填写所需要的权限
                .subscribe(new Action1<Boolean>() {
                    @Override
                    public void call(Boolean aBoolean) {
                        if (aBoolean) {//true表示获取权限成功（注意这里在android6.0以下默认为true）
                            Log.i("permissions", Manifest.permission.CAMERA + "：" + "获取成功");
                            take2Pic();
                        } else {
                            Toast.makeText(Main5Activity.this, "权限被您拒绝", Toast.LENGTH_SHORT).show();
                            Log.i("permissions", Manifest.permission.CAMERA + "：" + "获取失败");
                        }
                    }
                });


    }

    // 动态权限
    private void testRxPermission2() {


        RxPermissions.getInstance(this)
                .request(Manifest.permission.CAMERA)//这里填写所需要的权限
                .subscribe(new Action1<Boolean>() {
                    @Override
                    public void call(Boolean aBoolean) {
                        if (aBoolean) {//true表示获取权限成功（注意这里在android6.0以下默认为true）
                            Log.i("permissions", Manifest.permission.CAMERA + "：" + "获取成功");
                            take2Pic();
                        } else {
                            Log.i("permissions", Manifest.permission.CAMERA + "：" + "获取失败");
                        }
                    }
                });


    }


    /**
     * 拍照
     */
    private void take2Pic() {

        intent = new Intent();
        intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, IMAGE_CAPTURE);
    }

    /**
     * 选择图片
     */
    private void pic2Images() {
        intent = new Intent();
        intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, IMAGE_MEDIA);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            if (requestCode == IMAGE_MEDIA) {
                try {
                    if (data.getData() == null) {

                    } else {
                        Uri selectedImage = data.getData();
                        String[] filePathColumn = {MediaStore.Images.Media.DATA};
                        Cursor cursor = getContentResolver().query(selectedImage,
                                filePathColumn, null, null, null);
                        cursor.moveToFirst();
                        int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                        Glide.with(Main5Activity.this).
                                load(cursor.getString(columnIndex)).
                                into(iv);
                        cursor.close();

                    }
                } catch (Exception e) {
                    Log.e("GetPicActivity- ERROR", e.getMessage());
                }
            } else if (requestCode == IMAGE_CAPTURE) {
                if (data != null) {
                    if (data.getExtras() == null) {
                    } else {
                        iv.setImageBitmap((Bitmap) data.getExtras().get("data"));
                    }
                }
            }

        }


    }
}
