package com.shaheen.images;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.ImageLoader;
import com.shaheen.utils.Utils;

import java.io.File;
import java.nio.ByteBuffer;

/**
 * Created by shaheen on 11/13/13.
 */

    public class MyDiskImageCache extends DiskBasedCache implements ImageLoader.ImageCache {

    private File cacheDir;

    public MyDiskImageCache(File rootDirectory, int maxCacheSizeInBytes) {
            super(rootDirectory, maxCacheSizeInBytes);
        }

        public MyDiskImageCache(File cacheDir) {
            super(cacheDir);
        }

    public Bitmap getBitmap(String url) {

        final String volleyFileName = getFilenameForKey(url);

        if (getCacheDir().listFiles() != null)
            for (File file : getCacheDir().listFiles()) {
                BitmapFactory BitmapFactory = null;
                if (file.getName().equals(volleyFileName))
                    return BitmapFactory.decodeFile(file.getName());
            }

        return null;
    }

        public void putBitmap(String url, Bitmap bitmap) {
            final Entry entry = new Entry();

            ByteBuffer buffer = ByteBuffer.allocate(bitmap.getByteCount());
            bitmap.copyPixelsToBuffer(buffer);
            entry.data = buffer.array();

            put(url, entry);
        }

        // Volley creates a filename for the url with the following function, so we'll use the same function
        // for translating the url back to said filename
        private String getFilenameForKey(String key) {
            int firstHalfLength = key.length() / 2;
            String localFilename = String.valueOf(key.substring(0, firstHalfLength).hashCode());
            localFilename += String.valueOf(key.substring(firstHalfLength).hashCode());
            return localFilename;
        }

    public File getCacheDir() {
        return Utils.getPhotoDirectory();
    }
}
