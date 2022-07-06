package com.luck.picture.lib;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.luck.picture.lib.basic.PictureCommonFragment;
import com.luck.picture.lib.config.InjectResourceSource;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.manager.SelectedManager;
import com.luck.picture.lib.photoview.PhotoView;
import com.luck.picture.lib.utils.BitmapUtils;
import com.luck.picture.lib.utils.DoubleUtils;

import java.util.ArrayList;
import java.util.List;

public class PictureSelectorChooseFragment extends PictureCommonFragment implements View.OnClickListener {

    public static final String TAG = PictureSelectorChooseFragment.class.getSimpleName();

    protected PhotoView photoView;
    protected TextView tvClose;
    protected TextView tvConfirm;
    protected TextView tvCrop;

    protected LocalMedia data;

    public static PictureSelectorChooseFragment newInstance(LocalMedia data) {
        Bundle args = new Bundle();
        args.putParcelable("data", data);
        PictureSelectorChooseFragment fragment = new PictureSelectorChooseFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getResourceId() {
        int layoutResourceId = InjectResourceSource.getLayoutResource(getContext(), InjectResourceSource.PREVIEW_LAYOUT_RESOURCE);
        if (layoutResourceId != InjectResourceSource.DEFAULT_LAYOUT_RESOURCE) {
            return layoutResourceId;
        }
        return R.layout.ps_fragment_choose;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null) {
            data = getArguments().getParcelable("data");
        }
        photoView = view.findViewById(R.id.preview_image);
        tvClose = view.findViewById(R.id.tvClose);
        tvConfirm = view.findViewById(R.id.tvConfirm);
        tvCrop = view.findViewById(R.id.tvCrop);
        tvClose.setOnClickListener(this);
        tvConfirm.setOnClickListener(this);
        tvCrop.setOnClickListener(this);

        int[] size = getRealSizeFromMedia(data);
        int[] maxImageSize = BitmapUtils.getMaxImageSize(size[0], size[1]);
        PictureSelectionConfig.imageEngine.loadImage(getContext(), photoView, data.getAvailablePath(), maxImageSize[0], maxImageSize[1]);

    }

    @Override
    public void onClick(View v) {
        if (DoubleUtils.isFastDoubleClick()) {
            return;
        }
        ArrayList<LocalMedia> result = new ArrayList<>();
        result.add(data);
        int id = v.getId();
        if (id == R.id.tvClose) {
            onBackCurrentFragment();
        } else if (id == R.id.tvConfirm) {
            onResultEvent(result);
        } else if (id == R.id.tvCrop) {
            onCrop(result);
        }

    }

    @Override
    public void onKeyBackFragmentFinish() {
        onBackCurrentFragment();
    }

    protected int[] getRealSizeFromMedia(LocalMedia media) {
        if (media.isCut() && media.getCropImageWidth() > 0 && media.getCropImageHeight() > 0) {
            return new int[]{media.getCropImageWidth(), media.getCropImageHeight()};
        } else {
            return new int[]{media.getWidth(), media.getHeight()};
        }
    }
}
