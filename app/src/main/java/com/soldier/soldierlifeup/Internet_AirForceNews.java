package com.soldier.soldierlifeup;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Internet_AirForceNews extends AppCompatActivity {

    private WebView mWebView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.internet);

        mWebView = (WebView) findViewById(R.id.webView);        //xml 자바코드 연결
        mWebView.getSettings().setJavaScriptEnabled(true);      //자바스크립트 허용

        mWebView.loadUrl("http://kookbang.dema.mil.kr/newsWeb/BBSMSTR_000000010025/list.do");      //웹뷰 실행
        mWebView.setWebChromeClient(new WebChromeClient());         //웹뷰에 크롬 사용 허용//이 부분이 없으면 크롬에서 alert가 뜨지 않음
        mWebView.setWebViewClient(new WebViewClientClass());        //새창열기 없이 웹뷰 내에서 다시 열기//페이지 이동 원활히 하기위해 사용

        //웹뷰 화면에 딱맞게 출력
        mWebView.getSettings().setLoadWithOverviewMode(true);
        mWebView.getSettings().setUseWideViewPort(true);

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {     //뒤로가기 버튼 이벤트
        if ((keyCode == KeyEvent.KEYCODE_BACK) && mWebView.canGoBack()) {       //웹뷰에서 뒤로가기 버튼을 누르면 뒤로가짐
            mWebView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private class WebViewClientClass extends WebViewClient {//페이지 이동

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            Log.d("check URL", url);
            view.loadUrl(url);
            return true;
        }
    }
}


