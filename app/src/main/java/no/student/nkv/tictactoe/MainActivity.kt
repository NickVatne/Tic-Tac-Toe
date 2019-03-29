package no.student.nkv.tictactoe

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.view.Window
import android.view.WindowManager
import android.view.animation.AnimationUtils.loadAnimation
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var mViewPager: ViewPager? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        window.requestFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        window.requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)
        setContentView(R.layout.activity_main)


        val animZoom2 = loadAnimation(applicationContext, R.anim.zoom2)
        val animBlink = loadAnimation(applicationContext, R.anim.blink)
        //imgTicTacToe.startAnimation(animBlink)
        btnSingle.setOnClickListener{
            btnSingle.startAnimation(animZoom2)
            startActivity(Intent(this@MainActivity, SecondActivity::class.java))

        }

        btnMulti.setOnClickListener{
            btnMulti.startAnimation(animZoom2)
            startActivity(Intent(this@MainActivity, ThirdActivity::class.java))
        }
        imgTicTacToe.setOnClickListener{
            imgTicTacToe.startAnimation(animBlink)
        }
        // back ImageView
        imageViewBack.setOnClickListener {
            finish()
            moveTaskToBack(true)
        }

        // quit ImageView
        imageViewQuit.setOnClickListener {
            finish()
            moveTaskToBack(true)
        }

    }

    // for handling back button of the Android Device
    override fun onBackPressed() {
        super.onBackPressed()
        moveTaskToBack(true)
    }
    fun setupViewPager(viewPager: ViewPager) {
        val adapter = SectionsStatePagerAdapter(supportFragmentManager)
        adapter.addFragment(SecondActivity(), "Fragment1")
        //adapter.addFragment(ThirdActivity(), "Fragment2")
        viewPager.adapter = adapter
    }
    fun setViewPager(fragmentNumber: Int) {
        mViewPager!!.currentItem = fragmentNumber
    }
    }
