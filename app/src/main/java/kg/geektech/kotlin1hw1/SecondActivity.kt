package kg.geektech.kotlin1hw1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import kg.geektech.kotlin1hw1.databinding.ActivitySecondBinding

private lateinit var binding: ActivitySecondBinding
class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        meetIntent()
        pressingButton()
    }

    private fun pressingButton() {
       binding.button2.setOnClickListener {
           if (TextUtils.isEmpty(binding.editText2.text.toString())){
               Toast.makeText(this,"Empty field is not allowed",Toast.LENGTH_SHORT).show()
           }else openIntent()
       }
    }

    private fun openIntent() {
        val intent = Intent(this,MainActivity::class.java).apply {
            putExtra(MASTER_KEY,binding.editText2.text.toString())
        }
        setResult(Activity.RESULT_OK,intent)
        finish()
    }

    private fun meetIntent() {
        binding.editText2.setText(intent.getStringExtra(MASTER_KEY))

    }
    companion object{
        const val MASTER_KEY = "key"
    }
}