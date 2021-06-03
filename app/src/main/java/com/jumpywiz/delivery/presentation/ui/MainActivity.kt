package com.jumpywiz.delivery.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.view.menu.MenuView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.jumpywiz.delivery.Application
import com.jumpywiz.delivery.R
import com.jumpywiz.delivery.adapters.MenuRecyclerAdapter
import com.jumpywiz.delivery.presentation.viewmodel.MenuViewModel
import com.jumpywiz.delivery.repository.MenuRepos
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    private lateinit var menuRecyclerView: RecyclerView
    private lateinit var menuViewModel: MenuViewModel
    private var currentButton: Int = 0
    var requests = listOf("pizza", "burger", "sushi", "drink", "muffin")
    private lateinit var swipeLayout: SwipeRefreshLayout
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var repos: MenuRepos

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Application.appComponent.inject(activity = this)

        val adapter = MenuRecyclerAdapter(this.applicationContext)
        menuRecyclerView = findViewById(R.id.menuItemsRecycler)
        menuRecyclerView.adapter = adapter
        menuRecyclerView.layoutManager = LinearLayoutManager(this.applicationContext)

        menuViewModel = ViewModelProviders.of(this, viewModelFactory)[MenuViewModel::class.java]

        lifecycle.addObserver(menuViewModel)

        swipeLayout = findViewById(R.id.recyclerViewRefreshLayout)
        swipeLayout.setOnRefreshListener {
            menuViewModel.getData(requests[currentButton])
        }

        menuViewModel.getData().observe(this, Observer() {
            it?.let {
                adapter.setData(it)
                swipeLayout.setRefreshing(false)
            }
        })

        initButtons()
    }

    fun initButtons() {
        val buttons: MutableList<Button> = mutableListOf()
        val buttonIdList = listOf(
            R.id.pizzaButton,
            R.id.hamburgerButton,
            R.id.sushiButton,
            R.id.drinksButton,
            R.id.desertsButton
        )

        buttonIdList.forEach {
            buttons.add(findViewById(it))
        }

        val buttonClickListener = View.OnClickListener() {
            var position = 0
            for (i in 0 until buttonIdList.size) {
                if (it.id == buttonIdList[i]) {
                    position = i
                    break
                }
            }
            currentButton = position
            buttons.forEach {
                it.isEnabled = true
                it.setTextColor(
                    application.resources.getColor(
                        R.color.enabledButtonTextColor,
                        theme
                    )
                )
            }
            buttons[position].isEnabled = false
            buttons[position].setTextColor(
                application.resources.getColor(
                    R.color.disabledButtonTextColor,
                    theme
                )
            )
            menuViewModel.loadFoodData(requests[position])
        }

        buttons.forEach {
            it.setOnClickListener(buttonClickListener)
        }
    }
}

