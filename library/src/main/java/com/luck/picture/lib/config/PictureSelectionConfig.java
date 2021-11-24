package com.luck.picture.lib.config;

import android.content.pm.ActivityInfo;
import android.os.Parcel;
import android.os.Parcelable;

import com.luck.picture.lib.engine.CropEngine;
import com.luck.picture.lib.engine.SandboxFileEngine;
import com.luck.picture.lib.interfaces.OnCameraEventInterceptListener;
import com.luck.picture.lib.language.LanguageConfig;
import com.luck.picture.lib.manager.SelectedManager;
import com.luck.picture.lib.engine.CompressEngine;
import com.luck.picture.lib.engine.ImageEngine;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.io.ArrayPoolProvide;
import com.luck.picture.lib.interfaces.OnResultCallbackListener;
import com.luck.picture.lib.style.PictureSelectorStyle;
import com.luck.picture.lib.thread.PictureThreadUtils;
import com.luck.picture.lib.tools.SdkVersionUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author：luck
 * @date：2017-05-24 17:02
 * @describe：PictureSelector Config
 */

public final class PictureSelectionConfig implements Parcelable {
    public int chooseMode;
    public boolean isOnlyCamera;
    public boolean isDirectReturnSingle;
    public static PictureSelectorStyle selectorStyle;
    public static OnCameraEventInterceptListener interceptCameraListener;
    public String cameraImageFormat;
    public String cameraVideoFormat;
    public String cameraAudioFormat;
    public String cameraImageFormatForQ;
    public String cameraVideoFormatForQ;
    public String cameraAudioFormatForQ;
    public int requestedOrientation;
    public boolean isCameraAroundState;
    public int selectionMode;
    public int maxSelectNum;
    public int minSelectNum;
    public int maxVideoSelectNum;
    public int minVideoSelectNum;
    public int videoQuality;
    public int videoMaxSecond;
    public int videoMinSecond;
    public int recordVideoMaxSecond;
    public int recordVideoMinSecond;
    public int imageSpanCount;
    public long filterMaxFileSize;
    public long filterMinFileSize;
    public int language;
    public boolean zoomAnim;
    public boolean isOriginalControl;
    public boolean isDisplayOriginalSize;
    public boolean isEditorImage;
    public boolean isDisplayCamera;
    public boolean isGif;
    public boolean isWebp;
    public boolean isBmp;
    public boolean isEnablePreview;
    public boolean isEnPreviewVideo;
    public boolean isEnablePreviewAudio;
    public boolean isOpenClickSound;
    public boolean isEmptyResultReturn;
    public boolean isHidePreviewDownload;
    public boolean isWithVideoImage;
    public List<LocalMedia> selectionMedias;
    public HashSet<String> queryMimeTypeHashSet;
    public String cameraFileName;
    public boolean isCheckOriginalImage;
    public String outPutCameraPath;
    public String sandboxFolderPath;
    public String originalPath;
    public String cameraPath;
    public int pageSize;
    public boolean isPageStrategy;
    public boolean isFilterInvalidFile;
    public boolean isMaxSelectEnabledMask;
    public int animationMode;
    public boolean isAutomaticTitleRecyclerTop;
    public boolean isQuickCapture;
    public boolean isCameraRotateImage;
    public boolean isAutoRotating;
    public boolean isSyncCover;
    public boolean isAutoScalePreviewImage;
    public int ofAllCameraType;
    public boolean isOnlySandboxDir;

    public static ImageEngine imageEngine;
    public static CompressEngine compressEngine;
    public static CropEngine cropEngine;
    public static SandboxFileEngine sandboxFileEngine;
    public static OnResultCallbackListener<LocalMedia> resultCallListener;


    protected PictureSelectionConfig(Parcel in) {
        chooseMode = in.readInt();
        isOnlyCamera = in.readByte() != 0;
        isDirectReturnSingle = in.readByte() != 0;
        cameraImageFormat = in.readString();
        cameraVideoFormat = in.readString();
        cameraAudioFormat = in.readString();
        cameraImageFormatForQ = in.readString();
        cameraVideoFormatForQ = in.readString();
        cameraAudioFormatForQ = in.readString();
        requestedOrientation = in.readInt();
        isCameraAroundState = in.readByte() != 0;
        selectionMode = in.readInt();
        maxSelectNum = in.readInt();
        minSelectNum = in.readInt();
        maxVideoSelectNum = in.readInt();
        minVideoSelectNum = in.readInt();
        videoQuality = in.readInt();
        videoMaxSecond = in.readInt();
        videoMinSecond = in.readInt();
        recordVideoMaxSecond = in.readInt();
        recordVideoMinSecond = in.readInt();
        imageSpanCount = in.readInt();
        filterMaxFileSize = in.readLong();
        filterMinFileSize = in.readLong();
        language = in.readInt();
        zoomAnim = in.readByte() != 0;
        isOriginalControl = in.readByte() != 0;
        isDisplayOriginalSize = in.readByte() != 0;
        isEditorImage = in.readByte() != 0;
        isDisplayCamera = in.readByte() != 0;
        isGif = in.readByte() != 0;
        isWebp = in.readByte() != 0;
        isBmp = in.readByte() != 0;
        isEnablePreview = in.readByte() != 0;
        isEnPreviewVideo = in.readByte() != 0;
        isEnablePreviewAudio = in.readByte() != 0;
        isOpenClickSound = in.readByte() != 0;
        isEmptyResultReturn = in.readByte() != 0;
        isHidePreviewDownload = in.readByte() != 0;
        isWithVideoImage = in.readByte() != 0;
        selectionMedias = in.createTypedArrayList(LocalMedia.CREATOR);
        cameraFileName = in.readString();
        isCheckOriginalImage = in.readByte() != 0;
        outPutCameraPath = in.readString();
        sandboxFolderPath = in.readString();
        originalPath = in.readString();
        cameraPath = in.readString();
        pageSize = in.readInt();
        isPageStrategy = in.readByte() != 0;
        isFilterInvalidFile = in.readByte() != 0;
        isMaxSelectEnabledMask = in.readByte() != 0;
        animationMode = in.readInt();
        isAutomaticTitleRecyclerTop = in.readByte() != 0;
        isQuickCapture = in.readByte() != 0;
        isCameraRotateImage = in.readByte() != 0;
        isAutoRotating = in.readByte() != 0;
        isSyncCover = in.readByte() != 0;
        isAutoScalePreviewImage = in.readByte() != 0;
        ofAllCameraType = in.readInt();
        isOnlySandboxDir = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(chooseMode);
        dest.writeByte((byte) (isOnlyCamera ? 1 : 0));
        dest.writeByte((byte) (isDirectReturnSingle ? 1 : 0));
        dest.writeString(cameraImageFormat);
        dest.writeString(cameraVideoFormat);
        dest.writeString(cameraAudioFormat);
        dest.writeString(cameraImageFormatForQ);
        dest.writeString(cameraVideoFormatForQ);
        dest.writeString(cameraAudioFormatForQ);
        dest.writeInt(requestedOrientation);
        dest.writeByte((byte) (isCameraAroundState ? 1 : 0));
        dest.writeInt(selectionMode);
        dest.writeInt(maxSelectNum);
        dest.writeInt(minSelectNum);
        dest.writeInt(maxVideoSelectNum);
        dest.writeInt(minVideoSelectNum);
        dest.writeInt(videoQuality);
        dest.writeInt(videoMaxSecond);
        dest.writeInt(videoMinSecond);
        dest.writeInt(recordVideoMaxSecond);
        dest.writeInt(recordVideoMinSecond);
        dest.writeInt(imageSpanCount);
        dest.writeLong(filterMaxFileSize);
        dest.writeLong(filterMinFileSize);
        dest.writeInt(language);
        dest.writeByte((byte) (zoomAnim ? 1 : 0));
        dest.writeByte((byte) (isOriginalControl ? 1 : 0));
        dest.writeByte((byte) (isDisplayOriginalSize ? 1 : 0));
        dest.writeByte((byte) (isEditorImage ? 1 : 0));
        dest.writeByte((byte) (isDisplayCamera ? 1 : 0));
        dest.writeByte((byte) (isGif ? 1 : 0));
        dest.writeByte((byte) (isWebp ? 1 : 0));
        dest.writeByte((byte) (isBmp ? 1 : 0));
        dest.writeByte((byte) (isEnablePreview ? 1 : 0));
        dest.writeByte((byte) (isEnPreviewVideo ? 1 : 0));
        dest.writeByte((byte) (isEnablePreviewAudio ? 1 : 0));
        dest.writeByte((byte) (isOpenClickSound ? 1 : 0));
        dest.writeByte((byte) (isEmptyResultReturn ? 1 : 0));
        dest.writeByte((byte) (isHidePreviewDownload ? 1 : 0));
        dest.writeByte((byte) (isWithVideoImage ? 1 : 0));
        dest.writeTypedList(selectionMedias);
        dest.writeString(cameraFileName);
        dest.writeByte((byte) (isCheckOriginalImage ? 1 : 0));
        dest.writeString(outPutCameraPath);
        dest.writeString(sandboxFolderPath);
        dest.writeString(originalPath);
        dest.writeString(cameraPath);
        dest.writeInt(pageSize);
        dest.writeByte((byte) (isPageStrategy ? 1 : 0));
        dest.writeByte((byte) (isFilterInvalidFile ? 1 : 0));
        dest.writeByte((byte) (isMaxSelectEnabledMask ? 1 : 0));
        dest.writeInt(animationMode);
        dest.writeByte((byte) (isAutomaticTitleRecyclerTop ? 1 : 0));
        dest.writeByte((byte) (isQuickCapture ? 1 : 0));
        dest.writeByte((byte) (isCameraRotateImage ? 1 : 0));
        dest.writeByte((byte) (isAutoRotating ? 1 : 0));
        dest.writeByte((byte) (isSyncCover ? 1 : 0));
        dest.writeByte((byte) (isAutoScalePreviewImage ? 1 : 0));
        dest.writeInt(ofAllCameraType);
        dest.writeByte((byte) (isOnlySandboxDir ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<PictureSelectionConfig> CREATOR = new Creator<PictureSelectionConfig>() {
        @Override
        public PictureSelectionConfig createFromParcel(Parcel in) {
            return new PictureSelectionConfig(in);
        }

        @Override
        public PictureSelectionConfig[] newArray(int size) {
            return new PictureSelectionConfig[size];
        }
    };

    protected void initDefaultValue() {
        chooseMode = SelectMimeType.ofImage();
        isOnlyCamera = false;
        selectionMode = PictureConfig.MULTIPLE;
        selectorStyle = new PictureSelectorStyle();
        maxSelectNum = 9;
        minSelectNum = 0;
        maxVideoSelectNum = 1;
        minVideoSelectNum = 0;
        videoQuality = 1;
        language = LanguageConfig.UNKNOWN_LANGUAGE;
        videoMaxSecond = 0;
        videoMinSecond = 0;
        filterMaxFileSize = 0;
        filterMinFileSize = 1024;
        recordVideoMaxSecond = 60;
        recordVideoMinSecond = 0;
        imageSpanCount = PictureConfig.DEFAULT_SPAN_COUNT;
        isOriginalControl = false;
        isCameraAroundState = false;
        isWithVideoImage = false;
        isDisplayCamera = true;
        isGif = false;
        isWebp = true;
        isBmp = true;
        isCheckOriginalImage = false;
        isDirectReturnSingle = false;
        isEnablePreview = true;
        isEnPreviewVideo = true;
        isEnablePreviewAudio = true;
        isHidePreviewDownload = false;
        isOpenClickSound = false;
        isEmptyResultReturn = false;
        zoomAnim = true;
        cameraImageFormat = "";
        cameraVideoFormat = "";
        cameraAudioFormat = "";
        cameraImageFormatForQ = "";
        cameraVideoFormatForQ = "";
        cameraAudioFormatForQ = "";
        cameraFileName = "";
        queryMimeTypeHashSet = new HashSet<>();
        selectionMedias = new ArrayList<>();
        outPutCameraPath = "";
        sandboxFolderPath = "";
        originalPath = "";
        cameraPath = "";
        pageSize = PictureConfig.MAX_PAGE_SIZE;
        isPageStrategy = true;
        isFilterInvalidFile = false;
        isMaxSelectEnabledMask = false;
        animationMode = -1;
        isAutomaticTitleRecyclerTop = true;
        isQuickCapture = true;
        isCameraRotateImage = true;
        isAutoRotating = true;
        isSyncCover = !SdkVersionUtils.isQ();
        isAutoScalePreviewImage = true;
        isEditorImage = false;
        isDisplayOriginalSize = true;
        ofAllCameraType = SelectMimeType.ofAll();
        isOnlySandboxDir = false;
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED;
    }


    public static PictureSelectionConfig getCleanInstance() {
        PictureSelectionConfig selectionSpec = getInstance();
        selectionSpec.initDefaultValue();
        return selectionSpec;
    }

    private static PictureSelectionConfig mInstance;

    public static PictureSelectionConfig getInstance() {
        if (mInstance == null) {
            synchronized (PictureSelectionConfig.class) {
                if (mInstance == null) {
                    mInstance = new PictureSelectionConfig();
                    mInstance.initDefaultValue();
                }
            }
        }
        return mInstance;
    }

    public PictureSelectionConfig() {
    }

    /**
     * 释放监听器
     */
    public static void destroy() {
        PictureSelectionConfig.resultCallListener = null;
        PictureSelectionConfig.imageEngine = null;
        PictureSelectionConfig.compressEngine = null;
        PictureSelectionConfig.cropEngine = null;
        PictureSelectionConfig.sandboxFileEngine = null;
        PictureSelectionConfig.interceptCameraListener = null;
        PictureThreadUtils.cancel(PictureThreadUtils.getIoPool());
        ArrayPoolProvide.getInstance().clearMemory();
        SelectedManager.clear();
    }

}