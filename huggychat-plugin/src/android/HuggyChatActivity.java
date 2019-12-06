package huggychat;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.os.Bundle;
import android.webkit.WebView;
import android.app.Activity;

import io.huggy.chatsdk.HuggyAttachments;
import io.huggy.chatsdk.HuggyChat;

import io.ionic.starter.R;

public class HuggyChatActivity extends Activity {
    private WebView webView;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent intent) {
        HuggyAttachments.handleAttachment(requestCode, resultCode, intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huggy_chat);
        
        Bundle b = getIntent().getExtras();
        setTitle(b.getString("title"));

        webView = findViewById(R.id.web_view);
        HuggyChat.getInstance().setUpWebView(webView, HuggyChatActivity.this);
    }
}
