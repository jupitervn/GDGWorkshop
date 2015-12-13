package vn.gddvietnam.workshop1;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btNext = (Button) findViewById(R.id.bt_next);
        final EditText etInput = (EditText) findViewById(R.id.et_input);
        if (btNext != null) {
            btNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String inputString = etInput.getText().toString();
                    Data data = new Data();
                    data.setInputString(inputString);
                    Intent gotoScreen2Intent = new Intent(MainActivity.this, Main2Activity.class);
                    gotoScreen2Intent.putExtra(Main2Activity.EXTRA_KEY, data);
                    startActivityForResult(gotoScreen2Intent, 1);
                }
            });
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                String storyName = data.getStringExtra(Main2Activity.EXTRA_STORY_CLICKED);
//                Toast.makeText(this, "You click story " + storyName, Toast.LENGTH_LONG).show();
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
                dialogBuilder.setMessage("You clicked story " + storyName);
                dialogBuilder.setTitle("Information");
                dialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Cancel dialog", Toast.LENGTH_LONG).show();
                    }
                });
                dialogBuilder.show();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_about) {
            Toast.makeText(this, "About clicked", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
