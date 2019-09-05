package example.myapplication11;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class BrowseActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);

        //初始化WEBVIEW
        WebView webView = (WebView)findViewById(R.id.id_webview);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        //获取传进来的参数，加载目标网址
        Intent intent = getIntent();
        String website = intent.getStringExtra("website");
        if(website != null)
        {
            webView.loadUrl(website);
        }
    }
}
