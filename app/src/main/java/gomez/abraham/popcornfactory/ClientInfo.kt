package gomez.abraham.popcornfactory

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class ClientInfo : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_client_info)


        var button: Button = findViewById(R.id.okclient)
        val txtName: EditText = findViewById(R.id.txtName)
        val txtPaymentType: EditText = findViewById(R.id.txtPaymentType)

        var nombre: String
        var tipoPago: String
        var bundle = intent.extras
        var asiento: String? = bundle!!.getString("asiento")
        print(asiento)

        button.setOnClickListener {


            if (txtName.text.toString()=="" || txtPaymentType.text.toString()==""){
                Toast.makeText( this,"Please fill the requested fields", Toast.LENGTH_LONG).show()
            }else{
                nombre = txtName.text.toString()
                tipoPago = txtPaymentType.text.toString()
                var intento = Intent(this, PurchaseSumary::class.java)
                intento.putExtra("asiento",asiento)
                intento.putExtra("nombre", nombre)
                intento.putExtra("tipoPago",tipoPago)
                this.startActivity(intento)
            }


        }

    }
}