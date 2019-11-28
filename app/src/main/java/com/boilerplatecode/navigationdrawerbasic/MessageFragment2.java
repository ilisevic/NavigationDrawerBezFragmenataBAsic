package com.boilerplatecode.navigationdrawerbasic;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MessageFragment2 extends Fragment {
    WebView vw;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_message2, container, false);

        vw= view.findViewById(R.id.webview_frame2);
        vw.setWebViewClient(new WebViewClient());
        vw.loadUrl("http://politika.rs");


        vw.setOnKeyListener(new View.OnKeyListener() {//Ovo vraća nazad stranu
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                //This is the filter
                if (event.getAction()!=KeyEvent.ACTION_DOWN)
                    return true;
                if (keyCode == KeyEvent.KEYCODE_BACK) {
                    if (vw.canGoBack()) {
                        vw.goBack();

                    } else {

                        (getActivity()).onBackPressed();
                    }
                    return true;
                }
                return false;
            }
        });






        return  view;
    }


}
