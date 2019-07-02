package longhoang.test.teko.utils.animation.blur;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class GBlurPic {

    private Bitmap mBitmap;

    private RenderScript mRS;
    private Allocation mInAllocation;
    private Allocation mOutAllocation;
    private ScriptIntrinsicBlur mBlur;

    public GBlurPic(Context context) {
        super();
        this.mRS = RenderScript.create(context);
        this.mBlur = ScriptIntrinsicBlur.create(mRS, Element.U8_4(mRS));
    }

    public Bitmap gBlurBitmap(Bitmap bitmap, float radius) {
        if (mBitmap != null) {
            mBitmap.recycle();
            mBitmap = null;
        }
        mBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
//		mBitmap = bitmap.copy(bitmap.getConfig(), true);

//        mBitmap = compressImage(mBitmap);
        mInAllocation = null;
        mOutAllocation = null;
        mInAllocation = Allocation.createFromBitmap(mRS, mBitmap,
                Allocation.MipmapControl.MIPMAP_NONE, Allocation.USAGE_SCRIPT);
        mOutAllocation = Allocation.createTyped(mRS, mInAllocation.getType());

        mBlur.setRadius(radius);
        mBlur.setInput(mInAllocation);
        mBlur.forEach(mOutAllocation);

        mOutAllocation.copyTo(mBitmap);

        return mBitmap;
    }


    public static Bitmap compressImage(Bitmap image) {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        int options = 100;
        while (baos.toByteArray().length / 1024 > 100) {
            baos.reset();
            image.compress(Bitmap.CompressFormat.JPEG, options, baos);
            options -= 10;
        }
        ByteArrayInputStream isBm = new ByteArrayInputStream(baos.toByteArray());
        Bitmap bitmap = BitmapFactory.decodeStream(isBm, null, null);
        return bitmap;
    }

}
