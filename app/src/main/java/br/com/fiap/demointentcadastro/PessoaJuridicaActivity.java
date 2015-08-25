package br.com.fiap.demointentcadastro;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class PessoaJuridicaActivity extends AppCompatActivity {

    private EditText etNome;
    private EditText etCnpj;
    private EditText etTelefone;
    private EditText etEmail;
    private EditText etSite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pessoa_juridica);

        etNome = (EditText) findViewById(R.id.etNome);
        etCnpj = (EditText) findViewById(R.id.etCnpj);
        etTelefone = (EditText) findViewById(R.id.etTelefone);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etSite = (EditText) findViewById(R.id.etSite);
    }

    public void openSite(View v) {
        if (etSite.getText() != null) {
            String url = etSite.getText().toString();

            // Tive um erro pois no primeiro teste nao coloquei http. Esse validate resolve.
            if (!url.startsWith("https://") && !url.startsWith("http://")) {
                url = "http://" + url;
            }

            Intent siteIntent = new Intent(Intent.ACTION_VIEW);
            siteIntent.setData(Uri.parse(url));
            startActivity(siteIntent);
        }
    }

    public void sendMail(View v) {
        if (etEmail.getText() != null) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            Uri data = Uri.parse("mailto:" + etEmail.getText().toString());
            intent.setData(data);
            startActivity(intent);

            //Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
            //emailIntent.setType("text/html");
            //emailIntent.putExtra(Intent.EXTRA_EMAIL, etEmail.getText().toString());

            //startActivity(Intent.createChooser(emailIntent, "Send Email"));
        }
    }

    public void placeCall(View v) {
        if (etTelefone.getText() != null) {
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:" + etTelefone.getText().toString()));
            startActivity(callIntent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pessoa_juridica, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.itGravar) {
            Toast.makeText(this, R.string.message, Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
