package group5.project.gostudy;
import java.io.*;
import android.os.Bundle;
import android.widget.*;
import android.app.Activity;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.view.*;

public class flashcard extends Activity implements OnClickListener 
{
	TextView flashcard;
//	TextView backcard;
	Button nextButton;
	Button flipButton;
    Button howtobut;

	public static deck card_Deck;
	private FrontAndBack cardStatus;

    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
    	
    	card_Deck = new deck();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flashcardscreen);
        try
		{
			FileOutputStream filewrite = new FileOutputStream(new File(getExternalFilesDir(null), ".nomedia"));
			filewrite.write('a');
			filewrite.close();
		}
		catch(Exception e)
		{
		}
        flashcard = (TextView)findViewById(R.id.flashcardFB);
        nextButton = (Button)findViewById(R.id.nextButton);
        nextButton.setOnClickListener(this);
        //addnew = (Button)findViewById(R.id.addbutton);
        howtobut = (Button)findViewById(R.id.howtobutton);
        howtobut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helppage();
            }
        });

        flipButton = (Button)findViewById(R.id.flip);
        flipButton.setOnClickListener(this);
        
    }
    private void helppage(){
        Intent intent = new Intent(this, howto.class);
        startActivity(intent);
        finish();
    }

    public void onClick(View v)
    {
    	switch(v.getId())

    	{
    		case R.id.nextButton: 
    			cardStatus = card_Deck.getCard(true);
    			if(cardStatus !=null)
    			{
    				flashcard.setText(cardStatus.getFrontCard());

    				flipButton.setText("Flip to Back");
    			}
    			break;
    		case R.id.flip:
    			if(cardStatus != null && flashcard.getText().equals(cardStatus.getFrontCard()))
    			{
    				flashcard.setText(cardStatus.getBackCard());
    				flipButton.setText("Flip to Front");
    			}
    			else if (cardStatus != null )
    			{

                    flashcard.setText(cardStatus.getFrontCard());
    				flipButton.setText("Flip to Back");
    			}
    			break;
    	}
    	
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.flashmenu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menu)
    {
        Intent newIntent;
        switch(menu.getItemId())
        {
            case R.id.addcards:
                newIntent = new Intent(getBaseContext(), newCards.class);
                startActivity(newIntent);
                break;
            case R.id.opensets:
                newIntent = new Intent(getBaseContext(), viewDecks.class);
                startActivity(newIntent);
                break;
            case R.id.saveNew:
                newIntent = new Intent(getBaseContext(), saveDeck.class);
                startActivity(newIntent);
                break;
            case R.id.clear:
                card_Deck.clearArrays();
                flashcard.setText("Go to settings to load or create new deck/cards!");
                cardStatus = null;
                break;
        }
        return false;
    }
}
