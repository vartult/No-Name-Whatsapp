package com.cellfishpool.nonamewhatsapp

import android.graphics.Color.parseColor
import com.github.paolorotolo.appintro.AppIntroFragment
import android.R.attr.description
import android.content.Intent
import com.github.paolorotolo.appintro.model.SliderPage
import android.os.Bundle
import android.support.annotation.Nullable
import android.support.v4.app.Fragment
import com.github.paolorotolo.appintro.AppIntro
import com.github.paolorotolo.appintro.AppIntro2


class IntroActivity : AppIntro2() {

    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        addSlide(AppIntroFragment.newInstance(getString(R.string.title1),getString(R.string.description1),R.drawable.icon,getColor(R.color.blue)))

        addSlide(AppIntroFragment.newInstance(getString(R.string.title2),getString(R.string.description2),R.drawable.ss1,getColor(R.color.green)))

        addSlide(AppIntroFragment.newInstance(getString(R.string.title3),getString(R.string.description3),R.drawable.ss2,getColor(R.color.red)))

        addSlide(AppIntroFragment.newInstance(getString(R.string.title4),getString(R.string.description4),R.drawable.res,getColor(R.color.yellow)))
        showSkipButton(true)
        setProgressButtonEnabled(true)


        setVibrate(true)
        setVibrateIntensity(100)
    }

    override fun onSkipPressed(currentFragment: Fragment?) {
        super.onSkipPressed(currentFragment)


        finish()

    }

    override fun onDonePressed(currentFragment: Fragment?) {
        super.onDonePressed(currentFragment)
        // Do something when users tap on Done button.
        finish()

    }

}