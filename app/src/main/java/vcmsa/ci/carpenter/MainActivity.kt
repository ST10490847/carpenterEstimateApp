package vcmsa.ci.carpenter

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit var radioGroup: RadioGroup
    private lateinit var cbxWood: CheckBox
    private lateinit var cbxNails: CheckBox
    private lateinit var cbxHinges: CheckBox
    private lateinit var cbxStrews: CheckBox
    private lateinit var editTextNumberDecimal: EditText
    private lateinit var button: Button
    private lateinit var  textView: TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        radioGroup = findViewById(R.id.radioGroup)
        cbxWood = findViewById(R.id.cbxWood)
        cbxNails = findViewById(R.id.cbxNails)
        cbxHinges = findViewById(R.id.cbxHinges)
        cbxStrews = findViewById(R.id.cbxScrews)
        editTextNumberDecimal = findViewById(R.id.editTextNumberDecimal)
        button = findViewById(R.id.button)
        textView = findViewById(R.id.textView2)

        button.setOnClickListener {
            calculateCost()

        }
    }

        private fun calculateCost() {
            val hoursStr = editTextNumberDecimal.text.toString()
            if (hoursStr.isEmpty() || hoursStr.toIntOrNull() == null || hoursStr.toInt() <= 0) {
                Toast.makeText(this, "Enter valid number of hours", Toast.LENGTH_SHORT).show()
                return
            }

            if (radioGroup.checkedRadioButtonId == - 1) {
                Toast.makeText(this, "Please select task", Toast.LENGTH_SHORT).show()
                return

            }

                val hours = hoursStr. toInt()
                var materialCost = 0

                if (cbxWood. isChecked) materialCost += 200
                if (cbxNails.isChecked) materialCost += 50
                if (cbxHinges. isChecked) materialCost += 20
                if (cbxStrews. isChecked) materialCost += 25

                if (materialCost == 0) {
                    Toast.makeText(this, "Please select material", Toast.LENGTH_SHORT).show()
                        return
                }


            val totalCost = materialCost + (hours * 100)
            textView.text = "Total cost: R$totalCost"


            }


}

