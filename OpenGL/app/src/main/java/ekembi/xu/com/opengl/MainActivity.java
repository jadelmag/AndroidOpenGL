package ekembi.xu.com.opengl;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    String[]array;
    ListAdapter adapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupVariables();
        setupSelectors();

        //Array que asociaremos al adaptador
        array = new String[] {
                "Triangle 2D", "Cube 3D"
        };

        //Creación del adaptador
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, array);

        //Asociamos el adaptador a la vista.
        listView.setAdapter(adapter);
    }

    private void setupVariables() {
       listView  = (ListView) findViewById(android.R.id.list);
    }

    private void setupSelectors() {
        //Evento que se disparará al pulsar en un elemento de la lista
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

                switch (arg2) {
                    case 0:
                        Intent triangle2D = new Intent(MainActivity.this, GLTriangle2D.class);
                        startActivity(triangle2D);
                        break;
                    case 1:
                        Intent cube3D = new Intent(MainActivity.this, GLCube3D.class);
                        startActivity(cube3D);
                        break;
                    default:
                        break;
                }
            }
        });
    }
}
