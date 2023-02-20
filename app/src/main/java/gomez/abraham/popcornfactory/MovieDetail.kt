package gomez.abraham.popcornfactory

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_movie_detail.*


class MovieDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        val bundle = intent.extras
        var ns = 0
        var id = -1
        var title = ""

        //Si se selecciono una pelicula, agarra su titulo, encabezado, sinopsis y los asientos
        //que tiene, estos datos los saca de los put extra del catalog activity
        if (bundle != null){

            ns = bundle.getInt("numberSeats")

            title = bundle.getString("titulo")!!
            movie_header.setImageResource(bundle.getInt("header"))
            movie_title_detail.setText(bundle.getString("titulo"))
            movie_summary.setText(bundle.getString("sinopsis"))
            seatsLeft.setText("$ns seats available")
            id = bundle.getInt("pos")


        }

        if (ns==0){
            buyTickets.isEnabled = false
        }else{
            buyTickets.isEnabled = true
            buyTickets.setOnClickListener{
                val intent: Intent = Intent(this, SeatSelection::class.java)

                intent.putExtra("id", id)
                intent.putExtra("name",title)

                this.startActivity(intent)

            }
        }
    }


}