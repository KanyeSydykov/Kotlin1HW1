package kg.geektech.kotlin1hw1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import kg.geektech.kotlin1hw1.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding
private lateinit var resultLauncher: ActivityResultLauncher<Intent>

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        activityResult()
        pressingButton()
    }

    private fun activityResult() {
        resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result: ActivityResult->if (result.resultCode == Activity.RESULT_OK){
                binding.editText1.setText(result.data?.getStringExtra(MASTER_KEY))
            }
        }
    }

    private fun pressingButton() { binding.button1.setOnClickListener {
        if (TextUtils.isEmpty(binding.editText1.text.toString())){
            Toast.makeText(this,"Empty field is not allowed",Toast.LENGTH_SHORT).show()
        }else openActivity()

    }
    }

    private fun openActivity() {
     val intent = Intent(this,SecondActivity::class.java).apply {
         putExtra(MASTER_KEY, binding.editText1.text.toString())
     }
        resultLauncher.launch(intent)
    }
    companion object{
        const val MASTER_KEY = "key"
    }
}


