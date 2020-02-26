package com.fragment;


import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.book.R;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

/**
 * A simple {@link Fragment} subclass.
 */
public class InteractionFragment extends Fragment {
    View view;
    private SimpleDraweeView draweeView;
    private String url = "https://7365-server-z1qmi-1301202059.tcb.qcloud.la/1582376794803.jpg?sign=6e759385b056710a331ae28bf09e1a96&t=1582457590";
    public InteractionFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_interaction, container, false);
        draweeView = view.findViewById(R.id.my_image_view);
//        Uri uri = Uri.parse(url);
//        draweeView.setImageURI(uri);
        requestImage();

        return view;
    }
    private void requestImage(){
        ImageRequest request = ImageRequestBuilder.newBuilderWithSource(Uri.parse(url))
                .setProgressiveRenderingEnabled(true)
                .build();
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setImageRequest(request)
                .setOldController(draweeView.getController())
                .build();
        draweeView.setController(controller);
    }
}
