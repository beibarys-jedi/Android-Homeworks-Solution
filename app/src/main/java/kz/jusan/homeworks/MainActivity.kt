package kz.jusan.homeworks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class MainActivity : AppCompatActivity(), NewsClickListener {

    val TAG = "MainActivity"
    private val newsList = mutableListOf<News>()
    private var selectedIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getNews()

        initNewsListFragment()
        initNavigationButtons()
    }
    
    private fun getNews() {
        newsList.add(News(title = "News 1", author = "Author 1", date = "Date 1"))
        newsList.add(News(title = "News 2", author = "Author 2", date = "Date 2"))
        newsList.add(News(title = "News 3", author = "Author 3", date = "Date 3"))
        newsList.add(News(title = "News 4", author = "Author 4", date = "Date 4"))
        newsList.add(News(title = "News 5", author = "Author 5", date = "Date 5"))
        newsList.add(News(title = "News 6", author = "Author 6", date = "Date 6"))
    }

    private fun initNewsListFragment() {
        val newsListFragment = NewsListFragment()

        supportFragmentManager
            .beginTransaction()
            .add(R.id.fl_list, newsListFragment)
            .commit()
    }

    override fun onNewsClick(index: Int) {
        selectedIndex = index
        val news = newsList[selectedIndex]
        openNewsDetails(news)
    }

    private fun openNewsDetails(news: News) {
        val newsDetailsFragment = NewsDetailsFragment.newInstance(news)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.fl_details, newsDetailsFragment)
            .addToBackStack(null)
            .commit()
    }

    fun initNavigationButtons() {
        val tvBack: TextView = findViewById(R.id.tv_back)
        tvBack.setOnClickListener {
            selectedIndex -= 1
            if (selectedIndex < 0) {
                selectedIndex = 0
            }
            val news = newsList[selectedIndex]
            openNewsDetails(news)
        }

        val tvForward: TextView = findViewById(R.id.tv_forward)
        tvForward.setOnClickListener {
            selectedIndex += 1
            if (selectedIndex > 5) {
                selectedIndex = 5
            }
            val news = newsList[selectedIndex]
            openNewsDetails(news)
        }
    }
}