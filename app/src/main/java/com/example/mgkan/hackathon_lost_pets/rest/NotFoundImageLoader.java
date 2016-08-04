package com.example.mgkan.hackathon_lost_pets.rest;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.example.mgkan.hackathon_lost_pets.R;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.ImageViewBitmapInfo;

/**
 * Created by moonmayor on 8/4/16.
 */
public class NotFoundImageLoader {
  public static FutureCallback<ImageViewBitmapInfo> handleNotFound(final ImageView image, final Context context) {
      return new FutureCallback<ImageViewBitmapInfo>() {
        @Override
        public void onCompleted(Exception e, ImageViewBitmapInfo result) {
          // Check for exceptions

          // Check bitmaps first
          if (result != null && result.getBitmapInfo() != null && result.getBitmapInfo().bitmap != null) {
            Bitmap b = result.getBitmapInfo().bitmap;
            int size = b.getByteCount();

            // most found images are: 307200KB
            // most error images are:  76800KB
            // Log.d("IMAGE_SIZE", size + "KB " + url);
            if (size < 80000 && size > 75000) {
              // replace not-found images with our own not-found placeholder
              image.setImageDrawable(context.getResources().getDrawable(R.drawable.dog_cat_sil_480));
            }
          }
        }
      };
  }
}
