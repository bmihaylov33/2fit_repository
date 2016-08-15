package com.example.user.a2fit;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebActivity extends Activity {

    WebView web;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        web = (WebView) findViewById(R.id.webView1);
        web.setWebViewClient(new myWebClient());
        web.getSettings().setJavaScriptEnabled(true);

        int pos = getIntent().getIntExtra("key",0);
        if(pos==0)
        {
            web.loadUrl("http://greatist.com/move/best-bodyweight-exercises-abs");
        }
        else if(pos==1)
        {
            web.loadUrl("http://www.bodybuilding.com/exercises/finder/lookup/filter/muscle/id/4/muscle/middle-back");
        }
        else if(pos==2)
        {
            web.loadUrl("http://www.bodybuilding.com/exercises/finder/lookup/filter/muscle/id/15/muscle/biceps");
        }
        else if(pos==3)
        {
            web.loadUrl("http://www.bodybuilding.com/exercises/finder/lookup/filter/muscle/id/9/muscle/calves");
        }
        else if(pos==4)
        {
            web.loadUrl("http://www.bodybuilding.com/exercises/finder/lookup/filter/muscle/id/1/muscle/chest");
        }
        else if(pos==5)
        {
            web.loadUrl("http://www.bodybuilding.com/exercises/finder/lookup/filter/muscle/id/2/muscle/forearms");
        }
        else if(pos==6)
        {
            web.loadUrl("http://www.bodybuilding.com/exercises/finder/lookup/filter/muscle/id/14/muscle/glutes");
        }
        else if(pos==7)
        {
            web.loadUrl("http://www.bodybuilding.com/exercises/finder/lookup/filter/muscle/id/8/muscle/hamstrings");
        }
        else if(pos==8)
        {
            web.loadUrl("http://www.bodybuilding.com/exercises/finder/lookup/filter/muscle/id/7/muscle/quadriceps");
        }
        else if(pos==9)
        {
            web.loadUrl("http://www.bodybuilding.com/exercises/finder/lookup/filter/muscle/id/6/muscle/neck");
        }
        else if(pos==10)
        {
            web.loadUrl("http://www.bodybuilding.com/exercises/finder/lookup/filter/muscle/id/11/muscle/traps");
        }
        else if(pos==11)
        {
            web.loadUrl("http://www.bodybuilding.com/exercises/finder/lookup/filter/muscle/id/10/muscle/triceps");
        }
    }

    public class myWebClient extends WebViewClient
    {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            // TODO Auto-generated method stub
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            // TODO Auto-generated method stub

            view.loadUrl(url);
            return true;

        }
        @Override
        public void onReceivedError(WebView view, int errorCode,
                                    String description, String failingUrl) {
        }
        @Override
        public void onPageFinished(WebView view, String url) {
            // TODO Auto-generated method stub
            super.onPageFinished(view, url);

        }
    }
}
