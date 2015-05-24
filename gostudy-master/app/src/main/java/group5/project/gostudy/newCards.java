
package group5.project.gostudy;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.view.View.*;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class newCards extends Activity implements OnClickListener
{
	TextView frontOfCard;
	TextView backOfCard;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newcards);
    	((Button)findViewById(R.id.addCard)).setOnClickListener(this);
    	((Button)findViewById(R.id.GoBack)).setOnClickListener(this);
    	frontOfCard = (TextView)findViewById(R.id.front_user);
    	backOfCard = (TextView)findViewById(R.id.back_user);
    }
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.flashmenu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menu)
    {
        Intent loader;
        switch(menu.getItemId())
        {
            case R.id.opensets: 	loader = new Intent(getBaseContext(), viewDecks.class);
                startActivity(loader);
                break;
            case R.id.addcards:	loader = new Intent(getBaseContext(), newCards.class);
                startActivity(loader);
                break;
            case R.id.saveNew: 	loader = new Intent(getBaseContext(), saveDeck.class);
                startActivity(loader);
                break;

        }
        return false;
    }

    public void onClick(View v)
    {
    	switch(v.getId())
    	{
    		case R.id.addCard:
    			if(!frontOfCard.getText().toString().equals("") && !backOfCard.getText().toString().equals(""))
    			{
    				flashcard.card_Deck.addCard(new FrontAndBack(frontOfCard.getText().toString(), backOfCard.getText().toString()));
    				frontOfCard.setText("");
    				backOfCard.setText("");
    			}
    			break;
    		case R.id.GoBack:
                finish();
                break;
    	}
    }

    private void viewset(){
        Intent intent = new Intent(this, flashcard.class);
        startActivity(intent);
        finish();
    }
}
