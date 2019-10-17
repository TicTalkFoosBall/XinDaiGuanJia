package com.xingxiu.frame.util

import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.example.pictureselector.PictureSelectionModel
import com.example.pictureselector.PictureSelector
import com.example.pictureselector.config.PictureConfig
import com.example.pictureselector.config.PictureMimeType

/**
@Author  :rickBei
@Date    :2019/7/10 17:34
@Descripe: 选取照片工具,后续加上Rxjava方式回调.目前先不加，回调还是在对应各自的onActivityResult中 PictureConfig.CHOOSE_REQUEST
 **          这样设计的目的是，避免调用复杂度，但在一定程度保持灵活性，prepare后如果有需要调整的参数可以继续修改
 **          ，最后调用start即可
 **             java中使用demo:
 *               PictureSelectionUtil.INSTANCE.prepare(this).pickImageMultiple(9).changeParams(new Function1<PictureSelectionModel, PictureSelectionModel>() {
 *                   @Override
 *                   public PictureSelectionModel invoke(PictureSelectionModel pictureSelectionModel) {
 *                    pictureSelectionModel.enableCrop(false);
 *                    return pictureSelectionModel;
 *                   }
 *               }).start();
 *
 *
 *               @Override
 *                public void onActivityResult(int requestCode, int resultCode, Intent data) {
 *                  super.onActivityResult(requestCode, resultCode, data);
 *                  if (resultCode == Activity.RESULT_OK) {
 *                     switch (requestCode) {
 *                      case PictureConfig.CHOOSE_REQUEST: // 图片选择
 *                       selectList = PictureSelector.obtainMultipleResult(data);
 *                          if (selectList != null && selectList.size() > 0) {
 *                              LocalMedia media = selectList.get(0);
 *                               GlideUtils.loadBaseImg(getContext(), photo, media.isCut() ? media.getCutPath() : media.getPath());
 *                               }
 *                          break;
 *                       }
 **/

object PictureSelectionUtil {
    private val aspect_ratio_x = 3
    private val aspect_ratio_y = 4
    private val compressSize = 1 *  1024//默认大小1M
    private lateinit var model: PictureSelectionModel
    private lateinit var pictureSelector: PictureSelector

    /**
     * 必须先调用prepare方法
     * 启动照片选择器,如果fragment中启动，activity参数为空即可，反之亦然
     */
    fun prepare(fragment: Fragment? = null): PictureSelectionUtil {
        fragment?.let {
            pictureSelector = PictureSelector.create(it)
        }
        return this
    }

    fun prepare(activity: AppCompatActivity? = null): PictureSelectionUtil {
        activity?.let {
            pictureSelector = PictureSelector.create(it)
        }
        return this
    }

    /**
     * 打开相机-照片
     */
    fun takePhoto(): PictureSelectionUtil {
        model = pictureSelector.openCamera(PictureMimeType.ofImage())
        setImageParams()
        return this
    }


    /**
     * 选取单张图片
     */
    fun pickImageSingle(): PictureSelectionUtil {
        model = pictureSelector.openGallery(PictureMimeType.ofImage())
                .maxSelectNum(1)
                .selectionMode(PictureConfig.SINGLE)
        setImageParams()
        return this
    }

    /**
     * 选取多张图片
     */
    fun pickImageMultiple(maxCount: Int): PictureSelectionUtil {
        model = pictureSelector.openGallery(PictureMimeType.ofImage())
                .maxSelectNum(maxCount)
                .selectionMode(PictureConfig.MULTIPLE)
        setImageParams()
        return this
    }

    private fun setImageParams() {
        model.minSelectNum(1)
                .previewImage(true)
                .isCamera(true)
                .enableCrop(true)
                //开启压缩
                .compress(true)
                .minimumCompressSize(compressSize)
//                .glideOverride(160, 160)
                .previewEggs(true)
                .imageSpanCount(3)
                .withAspectRatio(
                        aspect_ratio_x,
                        aspect_ratio_y
                )
                .hideBottomControls(true)
                .isGif(false)
                .freeStyleCropEnabled(false)
    }

    /**
     * 选取单个视频
     */
    fun pickVidoSingle(): PictureSelectionUtil {
        model = pictureSelector.openGallery(PictureMimeType.ofVideo())
                .maxSelectNum(1)
                .selectionMode(PictureConfig.SINGLE)
        return this
    }

    /**
     * 选取多个视频
     */
    fun pickVidoMultiple(maxCount: Int): PictureSelectionUtil {
        model = pictureSelector.openGallery(PictureMimeType.ofVideo())
                .maxSelectNum(maxCount)
                .selectionMode(PictureConfig.MULTIPLE)
        return this
    }

    /**
     * 拍摄视频
     */
    fun takeVideo(): PictureSelectionUtil {
        model = pictureSelector.openCamera(PictureMimeType.ofVideo())
        setVideoParams()
        return this
    }

    private fun setVideoParams() {
        model.minSelectNum(1)
                .previewImage(true)
                .previewVideo(true)
                .enablePreviewAudio(true) // 是否可播放音频
                .isCamera(true)
                .enableCrop(true)
                .compress(false)
                .glideOverride(160, 160)
                .previewEggs(true)
                .imageSpanCount(3)
                .withAspectRatio(
                        aspect_ratio_x,
                        aspect_ratio_y
                )
                .hideBottomControls(true)
                .isGif(false)
                .freeStyleCropEnabled(false)
                .circleDimmedLayer(false)
                .showCropFrame(true)
                .showCropGrid(true)
                .openClickSound(false)
    }

    /**
     * 如果需要修改参数，调用此方法修改
     */
    fun changeParams(changeModel: (PictureSelectionModel) -> PictureSelectionModel): PictureSelectionUtil {
        changeModel(model)
        return this
    }

    fun start() {
        model.forResult(PictureConfig.CHOOSE_REQUEST)
    }

    fun start(requestCode: Int) {
        model.forResult(requestCode)
    }
}