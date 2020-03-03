package huggychat;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.text.Html;
import android.webkit.WebView;
import android.app.Activity;

import io.huggy.chatsdk.HuggyAttachments;
import io.huggy.chatsdk.HuggyChat;

public class HuggyChatActivity extends Activity {
    private WebView webView;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent intent) {
        HuggyAttachments.handleAttachment(requestCode, resultCode, intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int layoutId = getResources().getIdentifier("activity_huggy_chat", "layout", getPackageName());
        setContentView(layoutId);

        Bundle b = getIntent().getExtras();

        ActionBar actionBar = getActionBar();
        String actionBarBackground = b.getString("actionBarBackground");
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor((actionBarBackground))));

        String actionBarText = b.getString("actionBarText");
        String title = String.format("<font color='%s'>%s</font>", actionBarText, b.getString("title"));
        actionBar.setTitle(Html.fromHtml(title));

        int webViewId = getResources().getIdentifier("huggy_web_view", "id", getPackageName());
        webView = findViewById(webViewId);
        HuggyChat.getInstance().setUpWebView(webView, HuggyChatActivity.this);
    }
}
