package cn.edu.ldu.myrestaurant.util;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import cn.edu.ldu.myrestaurant.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CustomDialog extends DialogFragment {

    private static final String TITLE_KEY = "title_key";
    private static final String CONTENT_KEY = "content_key";
    private CustomDialogListener mListener;

    public CustomDialog() {
        // Required empty public constructor
    }

    public static CustomDialog newInstance(String title, String info) {

        Bundle args = new Bundle();
        args.putString(TITLE_KEY, title);
        args.putString(CONTENT_KEY, info);
        CustomDialog fragment = new CustomDialog();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View dialogView = inflater.inflate(R.layout.fragment_custom_dialog, container, false);

        String title = getArguments().getString(TITLE_KEY);
        String content = getArguments().getString(CONTENT_KEY);
        TextView tv1 = dialogView.findViewById(R.id.dialog_title);
        TextView tv2 = dialogView.findViewById(R.id.dialog_content);
        tv1.setText(title);
        tv2.setText(content);
        Button btnOk = dialogView.findViewById(R.id.dialog_yes);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onCustomDialogComplete(true);
                dismiss();
            }
        });
        Button btnCancel = dialogView.findViewById(R.id.dialog_cancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onCustomDialogComplete(false);
                dismiss();
            }
        });
        return dialogView;

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mListener = (CustomDialogListener) context;
    }

    public interface CustomDialogListener {
        void onCustomDialogComplete(boolean ok);
    }
}

