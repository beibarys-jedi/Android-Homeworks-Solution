package kz.jusan.homeworks

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        initButtons()
    }

    private fun initButtons() {
        initShareButton()
        initSendEmailButton()
        initCallButton()
        initCameraButton()
    }

    private fun initShareButton() {
        val btnShare: Button = findViewById(R.id.btn_share)
        btnShare.setOnClickListener {
            val sendIntent = Intent()
            sendIntent.action = Intent.ACTION_SEND
            sendIntent.putExtra(Intent.EXTRA_TEXT, "Here is my profile!")
            sendIntent.type = "text/plain"
            startActivity(sendIntent)
        }
    }

    private fun initSendEmailButton() {
        val btnSendViaEmail: Button = findViewById(R.id.btn_send_via_email)
        btnSendViaEmail.setOnClickListener {
            val emailIntent = Intent()
            emailIntent.action = Intent.ACTION_SENDTO
            emailIntent.setData(Uri.parse("mailto:"))
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Here is my profile!")
            if (emailIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(emailIntent);
            }
        }
    }

    private fun initCallButton() {
        val btnCall: Button = findViewById(R.id.btn_call)
        btnCall.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "+77771234567"))
            startActivity(intent)
        }
    }

    private fun initCameraButton() {
        val btnCamera: Button = findViewById(R.id.btn_camera)
        btnCamera.setOnClickListener {
            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(cameraIntent)
        }
    }
}