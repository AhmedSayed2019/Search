package services;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.widget.TextView;


import com.asia.search.R;
import com.victor.loading.rotate.RotateLoading;

import java.util.Objects;

public class Dialogs {

    private static TextView txVw_message;

    //create dialog with ProgressBar
    public static Dialog createProgressBarDialog(Context mContext) {

        Dialog mDialog = new Dialog(mContext, R.style.Theme_Dialog);
        mDialog.setContentView(R.layout.dialog_progress_bar);

        //find Views
        RotateLoading rotateLoading = mDialog.findViewById(R.id.dialogProgress_rotate_loading);
        rotateLoading.start();

        TextView txVw_message = mDialog.findViewById(R.id.dialogProgress_txVw_message);

        Objects.requireNonNull(mDialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        mDialog.setCancelable(false);

        return mDialog;
    }

    public static void setMeesage(String message) {
        txVw_message.setText(message);
    }
}
