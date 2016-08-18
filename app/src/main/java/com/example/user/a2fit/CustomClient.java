package com.example.user.a2fit;

import android.graphics.Bitmap;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

/**
 * Created by User on 13.7.2016 г..
 */
public class CustomClient extends WebViewClient {

    View progressBar ;

    public CustomClient(View progressBar){
        this.progressBar = progressBar;

    }


    @Override
    public void onLoadResource(WebView view, String url) {
        super.onLoadResource(view, url);

    }

    @Override
    public void onPageFinished(WebView mWebView, String url) {

        super.onPageFinished(mWebView, url);

        Log.d("Client", "pagefinished");

        String removeFooterJS = "(function() { " + "var foot = document.getElementsByTagName('footer')[0];" +
                "foot.parentNode.removeChild(foot);})()";
        String removeHeaderJS = "(function() { " + "var head = document.getElementsByTagName('header')[0];" +
                "head.parentNode.removeChild(head);})()";
        //removes the Запознайте се in Екипът
        String js1 = "(function(){var classname=\"tippy_link\"; var cells = document.getElementsByClassName(classname); while(cells[0]){cells[0].parentNode.removeChild(cells[0]);}})()";
        //nz
        String js2 = "(function(){var classname=\"nr_inner\"; var cells = document.getElementsByClassName(classname); while(cells[0]){cells[0].parentNode.removeChild(cells[0]);}})()";
        //removes the Social network buttons in Екипът
        String js3 = "(function(){var classname=\"social\"; var cells = document.getElementsByClassName(classname); while(cells[0]){cells[0].parentNode.removeChild(cells[0]);}})()";
        //naj-weroqtno ne mi trqbwa, za6toto we4e e social?
        String js4 = "(function(){var classname=\"sociable\"; var cells = document.getElementsByClassName(classname); while(cells[0]){cells[0].parentNode.removeChild(cells[0]);}})()";
        //remove the post box (both box to comment and comments from other users)
        String removePostBox = "(function(){var classname=\"disqus_thread\"; var cells = document.getElementById(classname); cells.parentNode.removeChild(cells);})()";
        //remove the box from which you can go to the shop
        String removeNau4iPowe4e = "(function(){var classname=\"hp-intro\"; var cells = document.getElementsByClassName(classname); while(cells[0]){cells[0].parentNode.removeChild(cells[0]);}})()";
        //remove filter
        String removeFilter = "(function(){var classname=\"finderLeft\"; var cells = document.getElementsByClassName(classname); while(cells[0]){cells[0].parentNode.removeChild(cells[0]);}})()";
        //remove an ad
        String removeSomeAd = "(function(){var classname=\"textwidget\"; var cells = document.getElementsByClassName(classname); while(cells[0]){cells[0].parentNode.removeChild(cells[0]);}})()";
        //I forgot what I'm removing here
        String removeToggles = "(function(){var classname=\"accordion toggles\"; var cells = document.getElementsByClassName(classname); while(cells[0]){cells[0].parentNode.removeChild(cells[0]);}})()";
        //remove Spodeli from Novini screen
        String removeSpodeli = "(function(){var classname=\"share\"; var cells = document.getElementsByClassName(classname); while(cells[0]){cells[0].parentNode.removeChild(cells[0]);}})()";
        //remove the spodeli options, we have a toolbar for this
        String removeSpodeliNadNovina = "(function(){var classname=\"at-above-post\"; var cells = document.getElementsByClassName(classname); while(cells[0]){cells[0].parentNode.removeChild(cells[0]);}})()";
        //edit the padding of the articles in Новини so it shows all of its content
        String editPostInfos = "(function(){var classname=\"post-headline\"; var cells = document.getElementsByClassName(classname); var i = 0; while(cells[i]){cells[i].style.padding = \"25px\";i++;}})()";
        //remove the subscriber box
        String removeSubscriberBox = "(function(){var classname=\"mc-embedded-subscribe-form\"; var cells = document.getElementById(classname); cells.parentNode.removeChild(cells);})()";
        //remove the categories in the novini screen
        String removeCategoriesBox = "(function(){var classname=\"btn light green\"; var cells = document.getElementsByClassName(classname); while(cells[0]){cells[0].parentNode.removeChild(cells[0]);}})()";

        mWebView.loadUrl("javascript:" + removeHeaderJS);
        mWebView.loadUrl("javascript:" + removeFooterJS);
        mWebView.loadUrl("javascript:" + js1);
        mWebView.loadUrl("javascript:" + js2);
        mWebView.loadUrl("javascript:" + js3);
        mWebView.loadUrl("javascript:" + js4);
        mWebView.loadUrl("javascript:" + removePostBox);
        mWebView.loadUrl("javascript:" + removeNau4iPowe4e);
        mWebView.loadUrl("javascript:" + removeFilter);
        mWebView.loadUrl("javascript:" + removeSomeAd);
        mWebView.loadUrl("javascript:" + removeToggles);
        mWebView.loadUrl("javascript:" + removeSpodeli);
        mWebView.loadUrl("javascript:" + removeSpodeliNadNovina);
        mWebView.loadUrl("javascript:" + editPostInfos);
        mWebView.loadUrl("javascript:" + removeSubscriberBox);
        mWebView.loadUrl("javascript:" + removeCategoriesBox);


        progressBar.setVisibility(View.GONE);
        mWebView.setVisibility(View.VISIBLE);
    }


    @Override
    public void onPageStarted(WebView mWebView, String url, Bitmap favicon) {
        super .onPageStarted(mWebView, url, favicon);

        Log.d("Client", "pagestarted");

        mWebView.setVisibility(View.INVISIBLE);
    }
//
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView mWebView, String url) {
//                mWebView.loadUrl(url);
//                return true;
//            }
}
