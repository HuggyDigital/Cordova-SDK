package huggychat;

import android.content.Intent;
import android.support.v4.app.TaskStackBuilder;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import io.huggy.chatsdk.HuggyNotification;

import io.ionic.starter.R;

import java.util.Map;

public class HuggyChatFirebaseMessagingService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        Map<String, String> payload = remoteMessage.getData();

        Intent resultIntent = new Intent(this, huggychat.HuggyChatActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addNextIntentWithParentStack(resultIntent);

        HuggyNotification.getInstance(this)
                .handleTapNotification(stackBuilder)
                .notifyAppInForeground()
                .notify(payload,
                        R.mipmap.ic_launcher,
                        "Você tem uma nova mensagem",
                        payload.get("text"));
    }
}
