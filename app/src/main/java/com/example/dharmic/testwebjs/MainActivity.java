package com.example.dharmic.testwebjs;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      /*  WebView webView = (WebView) findViewById(R.id.webView);
        String summary2 ="1 When a train crosses a platform;the distance covered;= " +
                "Length of platform and the train.;" +
                "Speed = $${(Length of (platform + train))/(Time taken)}$$;" +
                "Thus we have inadequate data.";

        String htmlContent = "<%@ page contentType=\"text/html; charset=UTF-8\" %>\n" +
                "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "\t<meta charset=\"utf-8\">\n" +
                "\t\n" +
                "\t  <link rel=\"stylesheet\" href=\"file:///android_asset/jqmath-0.4.3.css\">\n" +
                "\t\n" +
                //file:///android_asset/www/script.js
                "\t<script src=\"file:///android_asset/jquery-1.4.3.min.js\"></script>\n" +
                "\t<script src=\"file:///android_asset/jqmath-etc-0.4.6.min.js\" charset=\"utf-8\"></script>\n" +
                "\t\n" +
                "</head><body>\n" +
                "\n" +
                "summary\n" +
                "\n" +
                "</body>\n" +
                "\n" +
                "</html>";

        webView.getSettings().setJavaScriptEnabled(true);


        String summary = "<html><body>You scored <b>192</b> points.</body></html>";

        htmlContent = htmlContent.replace("summary", summary2);

        webView.loadData(htmlContent,"text/html",null);
    */

        String summary2 ="1 When a train crosses a platform;the distance covered;= " +
                "Length of platform and the train.;" +
                "Speed = ${(Length of (platform + train))/(Time taken)}$;" +
                "Thus we have inadequate data.";

        WebView myWebView = (WebView) findViewById(R.id.webView);
        myWebView.loadDataWithBaseURL("file:///android_asset/",
                "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML Basic 1.1//EN\"\n" +
                        "    \"http://www.w3.org/TR/xhtml-basic/xhtml-basic11.dtd\">" +
                        "<html>\n" +
                        "<head><meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, user-scalable=no\">" +
                        "<link rel=\"stylesheet\" href=\"file:///android_asset/jqmath-0.4.3.css\">\n" +
                        "</head>" +
                        "<body onload=\"showAndroidToast('Hello from OnLoad!!')\">\n" +
                        "<input type=\"button\" value=\"Say hello\" onClick=\"showAndroidToast('Hello Android!!')\" />" +
                        "\n" +
                        summary2+
                        "</body>\n" +
                        "<script src=\"file:///android_asset/script.js\"></script>\n" +
                        "<script src=\"file:///android_asset/jquery-1.4.3.min.js\"></script>\n" +
                        "<script src=\"file:///android_asset/jqmath-etc-0.4.6.min.js\" charset=\"utf-8\"></script>\n" +
                        "<script src=\"file:///android_asset/script.js\"></script>\n" +

                        "</html>", "text/html", "UTF-8", null);

        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myWebView.addJavascriptInterface(new WebAppInterface(this), "Android");
        myWebView.setWebChromeClient(new WebChromeClient());







    }
}

 class WebAppInterface {
    Context mContext;

    /** Instantiate the interface and set the context */
    WebAppInterface(Context c) {
        mContext = c;
    }

    /** Show a toast from the web page */
    @JavascriptInterface
    public void showToast(String toast) {
        Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
    }
}