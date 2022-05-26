package sg.edu.rp.c346.id20047102.democontextmenutranslation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView tvTranslatedText;
    TextView tvTranslatedText2;
    String wordClicked = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTranslatedText = findViewById(R.id.textViewTranslatedText);
        tvTranslatedText2 = findViewById(R.id.textViewTranslatedText2);

        registerForContextMenu(tvTranslatedText);
        registerForContextMenu(tvTranslatedText2);


    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        if (v == tvTranslatedText) {
            wordClicked = "hello";
        } else if (v == tvTranslatedText2) {
            wordClicked = "bye";
        }

        menu.add(0, 0, 0, "English");
        menu.add(0, 1, 1, "Italian");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        if (wordClicked.equalsIgnoreCase("hello")) {
            if (item.getItemId() == 0) {
                tvTranslatedText.setText("Hello");
                return true;
            } else if (item.getItemId() == 1) {
                tvTranslatedText.setText("Ciao");
                return true;
            }
        } else if (wordClicked.equalsIgnoreCase("bye")) {
            if (item.getItemId() == 0) {
                tvTranslatedText2.setText("Bye");
                return true;
            } else if (item.getItemId() == 1) {
                tvTranslatedText2.setText("Addio");
                return true;
            }
        }

        return super.onContextItemSelected(item);
    }

}