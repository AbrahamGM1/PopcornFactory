package gomez.abraham.popcornfactory

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_client_info.*

class PurchaseSumary : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_purchase_sumary)

        var bundle = intent.extras
        val button: Button = findViewById(R.id.botonok)
        val txtClientName: TextView = findViewById(R.id.txtViewClient)
        val txtPay: TextView = findViewById(R.id.txtViewPayment)
        val txtSeat: TextView = findViewById(R.id.txtViewSeat)


        if (bundle!=null){
            txtClientName.setText(bundle.getString("nombre"))
            txtPay.setText(bundle.getString("tipoPago"))
            txtSeat.setText(bundle.getString("asiento"))
        }

        button.setOnClickListener {
            var intento = Intent(this, MainActivity::class.java)
            this.startActivity(intento)
        }

    }
}