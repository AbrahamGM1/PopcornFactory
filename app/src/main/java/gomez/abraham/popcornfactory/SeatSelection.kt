package gomez.abraham.popcornfactory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.get

class SeatSelection : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seat_selection)

        val row1: RadioGroup = findViewById(R.id.row1)
        val row2: RadioGroup = findViewById(R.id.row2)
        val row3: RadioGroup = findViewById(R.id.row3)
        val row4: RadioGroup = findViewById(R.id.row4)
        var asientoSeleccionado: RadioButton

        val title: TextView = findViewById(R.id.titleSeats)
        val bundle = intent.extras
        var posMovie = -1
        var asiento: Int = -1
        var contador = 1
        var asientoDisponible: RadioButton
        var asientos = arrayListOf<Int>(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20)


        if (bundle!=null){
            title.setText(bundle.getString("name"))
            posMovie = bundle.getInt("id")

        }

        for (i in 1..asientos.size){
            if (contador==asientos.get(i-1)){
                println(contador)
                contador++
            }
        }

        val confirm: Button = findViewById(R.id.confirm)

        confirm.setOnClickListener {
            //Reservar lugar seleccionado por el usuario
            if (asiento!=-1){
                Toast.makeText( this,"Enjoy the movie! :D", Toast.LENGTH_LONG).show()
                var intento = Intent(this, ClientInfo::class.java)
                intento.putExtra("asiento",asiento.toString())
                this.startActivity(intento)

            }else{
                Toast.makeText( this,"Select one available seat please", Toast.LENGTH_LONG).show()
            }
            //Hacer una nueva actividad donde se vea el resumen de la compra (que se agregue el nombre del cliente junto con su asiento seleccionado)



        }

        row1.setOnCheckedChangeListener{ group, checkedId ->
            if (checkedId>-1){
                row2.clearCheck()
                row3.clearCheck()
                row4.clearCheck()
                row1.check(checkedId)
                asientoDisponible = row1[checkedId] as RadioButton
            }

        }

        row2.setOnCheckedChangeListener{ group, checkedId ->
            if (checkedId>-1){
                row1.clearCheck()
                row3.clearCheck()
                row4.clearCheck()
                row2.check(checkedId)
                asiento = checkedId
            }

        }

        row3.setOnCheckedChangeListener{ group, checkedId ->
            if (checkedId>-1){
                row2.clearCheck()
                row1.clearCheck()
                row4.clearCheck()
                row3.check(checkedId)
                asiento = checkedId
            }

        }

        row4.setOnCheckedChangeListener{ group, checkedId ->
            if (checkedId>-1){
                row2.clearCheck()
                row3.clearCheck()
                row1.clearCheck()
                row4.check(checkedId)
                asiento = checkedId
            }

        }

    }
}