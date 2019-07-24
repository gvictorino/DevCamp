package com.devcamp.ui

import android.os.Bundle
import android.os.PersistableBundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.devcamp.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    private var homeFragment: Fragment? = null
    private var accountFragment: Fragment? = null
    private var aboutFragment: Fragment? = null
    private var navigation: BottomNavigationView? = null

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_main)

        navigation = bottomNavigation
        navigation?.setOnNavigationItemSelectedListener(this)

    }

    override fun onSaveInstanceState(outState: Bundle?, outPersistentState: PersistableBundle?) {
        super.onSaveInstanceState(outState, outPersistentState)
        navigation?.selectedItemId?.let { outState?.putInt(MENU_ID_SELECTED, it) }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onRestoreInstanceState(savedInstanceState, persistentState)

        val idSelected = savedInstanceState?.getInt(MENU_ID_SELECTED)
        val fragmentManager = supportFragmentManager
        when (idSelected) {
            R.id.action_home -> homeFragment = fragmentManager.findFragmentByTag(HomeFragment.TAG)
            R.id.action_account -> accountFragment = fragmentManager.findFragmentByTag(AccountFragment.TAG)
            R.id.action_about -> aboutFragment = fragmentManager.findFragmentByTag(AboutFragment.TAG)
        }
    }

    private fun onClickHome() {
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()

        if (homeFragment == null) {
            homeFragment = HomeFragment()
            transaction.add(R.id.mainFrameLayout, homeFragment as Fragment, HomeFragment.TAG)
        }

        if (accountFragment != null) {
            transaction.hide(accountFragment as AccountFragment)

        }
        if (aboutFragment != null) {
            transaction.hide(aboutFragment as AboutFragment)

        }

        transaction.show(homeFragment as HomeFragment).commit()
    }

    private fun onClickAccount() {
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()

        if (accountFragment == null) {
            accountFragment = AccountFragment()
            transaction.add(R.id.mainFrameLayout, accountFragment as AccountFragment, AccountFragment.TAG)
        }

        if (homeFragment != null) {
            transaction.hide(homeFragment as HomeFragment)

        }

        if (aboutFragment != null) {
            transaction.hide(aboutFragment as AboutFragment)
        }

        transaction.show(accountFragment as AccountFragment).commit()
    }

    private fun onClickAbout() {
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()

        if (aboutFragment == null) {
            aboutFragment = AboutFragment()
            transaction.add(R.id.mainFrameLayout, aboutFragment as AboutFragment, AboutFragment.TAG)
        }

        if (homeFragment != null) {
            transaction.hide(homeFragment as HomeFragment)
        }

        if (accountFragment != null) {
            transaction.hide(accountFragment as AccountFragment)
        }

        transaction.show(aboutFragment as AboutFragment).commit()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_home -> {
                item.setIcon(R.drawable.ic_launcher_background)
                onClickHome()
            }

            R.id.action_account -> {
                item.setIcon(R.drawable.ic_launcher_background)
               onClickAccount()
            }
            R.id.action_about -> {
                item.setIcon(R.drawable.ic_launcher_background)
                onClickAbout()
            }
        }

        return true
    }

    companion object {
        val USERNAME : String? = null
        val PASSWORD : String? = null
        private val MENU_ID_SELECTED = "menuIdSelected"
    }
}