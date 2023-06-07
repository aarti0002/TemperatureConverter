package tempconverter.com;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView  showMeResult;
    private EditText editText;
    private Button celBtn;
    private Button farBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showMeResult= (TextView)findViewById(R.id.textView2);
        editText=(EditText)findViewById(R.id.editTextText);
        celBtn=(Button)findViewById(R.id.button);
        farBtn=(Button)findViewById(R.id.button2);

        celBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //convert to celsius
                String editTextVal = editText.getText().toString();
                if(editTextVal.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Please enter temperature!",Toast.LENGTH_LONG
                    ).show();
                }
                else{
                    double dEditText = Double.parseDouble(editTextVal);
                    double convertedValue = convertToCelsius(dEditText);

                    double finalValue = Math.round(convertedValue * 100.0)/100.0;

                    String result = String.valueOf(convertedValue);
                    showMeResult.setText(result);
                }

            }
        });
        farBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
               //convert to fahrenheit
                String editTextVal = editText.getText().toString();
                if(editTextVal.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Please enter temperature!",Toast.LENGTH_LONG
                    ).show();
                }
                else{
                    double dEditText = Double.parseDouble(editTextVal);
                    double convertedValue = convertToFahrenheit(dEditText);

                    double finalValue = Math.round(convertedValue * 100.0)/100.0;

                    String result = String.valueOf(convertedValue);
                    showMeResult.setText(result);
                }

            }
        });
    }
    public double convertToCelsius(double farVal){
        // c = (f-32)*5/9
        double resultVal;
        resultVal= (farVal-32)* 5/9;
        return resultVal;
    }
    public double convertToFahrenheit(double celVal){
        //f = c* 9/5 +32
        double resultVal;
        resultVal = celVal * 9/5 +32;
        return resultVal;
    }
}