package com.dotplays.abc;

import android.graphics.Bitmap;

public interface ImageListener<T> {

    void start();
    void finish(T t);


}
