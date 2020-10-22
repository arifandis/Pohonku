package com.cahstudio.pohonku.ui.reader;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.FormatException;
import android.os.Bundle;
import android.widget.Toast;

import com.cahstudio.pohonku.R;
import com.cahstudio.pohonku.ui.addtree.AddTreeActivity;
import com.cahstudio.pohonku.ui.detailtree.DetailTreeActivity;
import com.cahstudio.pohonku.ui.login.LoginActivity;

import java.util.Timer;
import java.util.TimerTask;

import be.appfoundry.nfclibrary.activities.NfcActivity;
import be.appfoundry.nfclibrary.exceptions.InsufficientCapacityException;
import be.appfoundry.nfclibrary.exceptions.ReadOnlyTagException;
import be.appfoundry.nfclibrary.exceptions.TagNotPresentException;
import be.appfoundry.nfclibrary.tasks.interfaces.AsyncOperationCallback;
import be.appfoundry.nfclibrary.tasks.interfaces.AsyncUiCallback;
import be.appfoundry.nfclibrary.utilities.async.WriteEmailNfcAsync;
import be.appfoundry.nfclibrary.utilities.interfaces.NfcWriteUtility;
import be.appfoundry.nfclibrary.utilities.sync.NfcReadUtilityImpl;

public class NFCReaderActivity extends NfcActivity{
    AsyncOperationCallback mAsyncOperationCallback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n_f_c_reader);

//        scanning();
//        mAsyncOperationCallback = new AsyncOperationCallback() {
//
//            @Override
//            public boolean performWrite(NfcWriteUtility writeUtility) throws ReadOnlyTagException, InsufficientCapacityException, TagNotPresentException, FormatException {
//                return writeUtility.writeEmailToTagFromIntent("some@email.tld","Subject","Message",getIntent());
//            }
//        };
        scanning();
    }

    void scanning(){
        final String from = getIntent().getStringExtra("from");
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                if (from.equals("add")){
                    startActivity(new Intent(getApplicationContext(), AddTreeActivity.class));
                    finish();
                }else{
                    startActivity(new Intent(getApplicationContext(), DetailTreeActivity.class));
                    finish();
                }
            }
        }, 2500);
    }

    void getMessage(String message){
        final String from = getIntent().getStringExtra("from");
        Intent intent = new Intent();
        if (from.equals("add")){
            intent = new Intent(getApplicationContext(), AddTreeActivity.class);
            startActivity(intent);
            finish();
        }else{
            intent = new Intent(getApplicationContext(), DetailTreeActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        for (String message : getNfcMessages()) {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
            getMessage(message);
        }

//        scanning();
//        new WriteEmailNfcAsync(this,mAsyncOperationCallback).executeWriteOperation();
//        for (String message : getNfcMessages()){
//            Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
//        }
    }

//    @Override
//    public void callbackWithReturnValue(Boolean aBoolean) {
//        String message = aBoolean ? "Success" : "Failed!";
//        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    public void onProgressUpdate(Boolean... booleans) {
//        Toast.makeText(this, booleans[0] ? "We started writing" : "We could not write!",Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    public void onError(Exception e) {
//        Toast.makeText(this,e.getMessage(),Toast.LENGTH_SHORT).show();
//    }
}