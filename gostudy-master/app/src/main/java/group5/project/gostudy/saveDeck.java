package group5.project.gostudy;

import android.app.*;
import android.os.Bundle;
import java.io.*;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.*;
import java.util.*;

public class saveDeck extends ListActivity implements OnClickListener
{
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.savenewdeck);
        ArrayList<String> files = new ArrayList<String>();
        File rootFile = getExternalFilesDir(null);
        ((Button)findViewById(R.id.save_button)).setOnClickListener(this);
		
        if(rootFile != null)
        {
        	for(File temp:rootFile.listFiles())
        		files.add(temp.getName());
        }
        else
        {
        	AlertDialog error = new AlertDialog.Builder(this).create();
            error.setMessage("no sd card");
            error.show();
        }
	    setListAdapter(new ArrayAdapter<String>(this, R.layout.row ,files));
    }
    protected void onListItemClick (ListView l, View v, int i, long id)
    {
        try
        {
            File[] decklist = getExternalFilesDir(null).listFiles();
            if(!decklist[i].getName().equals(".nomedia"))
            {
                ((EditText)findViewById(R.id.newName)).setText(decklist[i].getName());
            }
        }
        catch(Exception e)
        {
        }
    }
    public void onClick(View v)
    {
        String newfile = ((EditText)findViewById(R.id.newName)).getText().toString();
        File save = new File(getExternalFilesDir(null), newfile);
        try
        {
            FileOutputStream fileSave = new FileOutputStream(save);
            fileSave.write(flashcard.card_Deck.saveDeck().getBytes());
        }
        catch(Exception e)
        {
            AlertDialog error = new AlertDialog.Builder(this).create();
            error.setMessage("no sd card");
            error.show();
        }
        finish();
    }

    

}
