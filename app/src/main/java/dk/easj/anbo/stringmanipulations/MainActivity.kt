package dk.easj.anbo.stringmanipulations

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import dk.easj.anbo.stringmanipulations.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /* binding.upperCaseButton.setOnClickListener {
             val text = binding.inputEditText.text.trim().toString()
             if (text.isEmpty()) {
                 binding.inputEditText.error = "No input"
                 return@setOnClickListener
             }
             val result = text.uppercase()
             binding.resultTextView.text = result
         }

         binding.lowerCaseButton.setOnClickListener {
             /* val text = binding.inputEditText.text.trim().toString()
             if (text.isEmpty()) {
                 binding.inputEditText.error = "No input"
                 return@setOnClickListener
             }
             val result = text.lowercase()
             binding.resultTextView.text = result */
             doIt { s -> s.lowercase() }
         }*/

        binding.reverseButton.setOnClickListener {
            /* val text = binding.inputEditText.text
             if (text.isEmpty()) {
                 binding.inputEditText.error = "No input"
                 return@setOnClickListener
             }
             val result = text.reversed()
             binding.resultTextView.text = result */
            doIt { s -> s.reversed() }
        }

        binding.capitalizeButton.setOnClickListener {
            /*val text = binding.inputEditText.text.trim().toString()
            if (text.isEmpty()) {
                binding.inputEditText.error = "No input"
                return@setOnClickListener
            }
            // https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/replace-first-char.html
            val result = text.replaceFirstChar { it.uppercase() }
            binding.resultTextView.text = result */
            doIt { s -> s.replaceFirstChar { it.uppercase() } }
        }
    }

    private fun doIt(transformation: (String) -> String) { // EXTRA
        val text = binding.inputEditText.text.trim().toString()
        if (text.isEmpty()) {
            binding.inputEditText.error = "No input"
            return
        }
        val result = transformation.invoke(text)
        binding.resultTextView.text = result
    }

    fun buttonClicked(view: View) { // EXTRA
        val text = binding.inputEditText.text.trim().toString()
        if (text.isEmpty()) {
            binding.inputEditText.error = "No input"
            return
        }

        when (view) {
            binding.lowerCaseButton -> {
                binding.resultTextView.text = text.lowercase()
            }
            binding.upperCaseButton -> {
                binding.resultTextView.text = text.uppercase()
            }
        }
    }
}