package com.example.sesion5

import android.content.pm.PackageManager
import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sesion5.databinding.ActivitySimplePermissionsBinding

class simplePermissionsActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySimplePermissionsBinding
    val contactsPermission = registerForActivityResult(
        ActivityResultContracts.RequestPermission(),
        ActivityResultCallback {
            updateUI(it)
        }
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySimplePermissionsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        /*if(shouldShowRequestPermissionRationale((android.Manifest.permission.READ_CONTACTS)){
            Toast(this,"the permission is needed for fun", Toast.LENGTH_LONG).show()
            }*/
        contactsPermissionRequest(android.Manifest.permission.READ_CONTACTS)
    }

    private fun contactsPermissionRequest(permission : String){
        if(ContextCompat.checkSelfPermission(this,permission)==PackageManager.PERMISSION_DENIED) {
            if (shouldShowRequestPermissionRationale(permission)) {
                Toast.makeText(this, "The permission is needed for fun", Toast.LENGTH_LONG).show()
            }
            contactsPermission.launch(permission)
        }
        else{
            updateUI(true)
        }
    }

    fun updateUI(flag : Boolean){
        if(flag){
            binding.status.text = "Permission Granted"
            binding.status.setTextColor(Color.GREEN)
        }
        else{
            binding.status.text = "Permission Denied"
            binding.status.setTextColor(Color.RED)
        }
    }
}