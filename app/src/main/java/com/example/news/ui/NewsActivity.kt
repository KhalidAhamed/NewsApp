package com.example.news.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.news.R
import com.example.news.databinding.ActivityNewsBinding
import com.example.news.db.ArticleDatabase
import com.example.news.repository.NewsRepository

class NewsActivity : AppCompatActivity() {
    lateinit var newsViewModel: NewsViewModel
    lateinit var binding: ActivityNewsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val newsRepository = NewsRepository(ArticleDatabase(this))
        val viewModelProvider = NewsViewModelProviderFactory(application,newsRepository)
        newsViewModel = ViewModelProvider(this,viewModelProvider).get(NewsViewModel::class.java)


        val navHostFragmnet = supportFragmentManager.findFragmentById(R.id.newsNavHostFragment) as NavHostFragment
        val navController = navHostFragmnet.navController

        binding.bottomNavigationView.setupWithNavController(navController)

    }
}