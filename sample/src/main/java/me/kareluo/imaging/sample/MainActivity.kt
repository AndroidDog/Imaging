package me.kareluo.imaging.sample

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

const val REQ_IMAGE_EDIT = 1

const val REQ_IMAGE_CHOOSE = 2

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sdv_image_edit.setOnClickListener {
            startActivity(Intent(
                    this, ImageEditSampleActivity::class.java
            ))
        }

        sdv_image_album.setOnClickListener {
            startActivity(Intent(
                    this, GallerySampleActivity::class.java
            ))
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
                        && checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), 0)
        }
    }
}
