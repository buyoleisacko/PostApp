import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.postapp.R
import java.util.Observer

class MainActivity : AppCompatActivity() {
    lateinit var postsViewModel: PostViewModel
    lateinit var postsViewModelFactory: PostViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        postsViewModelFactory = PostViewModelFactory(PostRepository())
        postsViewModel =
            ViewModelProvider(this, postsViewModelFactory).get(PostViewModel::class.java)
        postsViewModel.getPosts()
        val observe: Any = postsViewModel.postsLiveData.observe(this, Observer { posts ->

            val recyclerPost = null
            recyclerPost.apply {
                var layoutManager = LinearLayoutManager(this@MainActivity)
                var post = null
                var adapter = PostAdapter(post)
            }

            Toast.makeText(baseContext, "${post.size} posts fetched", Toast.LENGTH_LONG).show()
        })

        postsViewModel.postsFailedLiveData.observe(this, Observer { error ->
            Toast.makeText(baseContext, error, Toast.LENGTH_LONG).show()
        })
    }
}

enum class PostViewModel {

}

class PostViewModelFactory {

}
