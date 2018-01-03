package com.draguve.droidducky;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

/**
 * Created by Draguve on 1/4/2018.
 */

public class CodeEditor extends AppCompatActivity {

    private Script currentScript = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_code);
        Intent callingIntent = getIntent();
        String scriptID = callingIntent.getExtras().getString("idSelected",null);
        ScriptsManager db = new ScriptsManager(this);
        if(scriptID!=null){
            currentScript = db.getScript(scriptID);
            if(currentScript!=null){
                EditText codeTextBox = (EditText)findViewById(R.id.codeEdit);
                EditText scriptName = (EditText)findViewById(R.id.scriptName);
                scriptName.setText(currentScript.getName());
                codeTextBox.setText(currentScript.getCode());
            }else{
                currentScript = new Script("","");
            }
        }else{
            currentScript = new Script("","");
        }
    }
}