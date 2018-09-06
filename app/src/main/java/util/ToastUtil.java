package util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.Toast;

/**
 * Created by 李君 on 2018/6/21.
 */

public class ToastUtil {

    private static Toast sToast;

    @SuppressLint("ShowToast")
    public static void shortToast(Context context, String text) {
        if (sToast == null) {
            sToast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
        } else {
            sToast.setText(text);
        }
        sToast.show();
    }

}
