package group5.project.gostudy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


/**
 * Created by chadlawson on 4/19/15.
 */


public class howto extends Activity implements View.OnClickListener
{

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.howto);
        ((Button)findViewById(R.id.back1)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewset();
            }
        });

    }
    private void viewset(){
        Intent intent = new Intent(this, flashcard.class);
        startActivity(intent);
        finish();
    }
   /* public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.flashmenu, menu);
        return true;
    }
*/
    public void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.back1:
                finish();
                break;
        }
    }


}
