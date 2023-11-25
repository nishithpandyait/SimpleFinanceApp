import androidx.test.filters.MediumTest
import com.simplefinance.feature.news.domain.usecase.NewsUseCase
import com.simplefinance.feature.news.presentation.mapper.NewsMapper
import com.simplefinance.feature.news.presentation.viewmodel.NewsViewModel
/*import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest*/
import junit.framework.TestCase.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import javax.inject.Inject

@MediumTest
//@HiltAndroidTest
@RunWith(JUnit4::class)
class NewsViewModelTest {

    @Inject
    lateinit var mapper: NewsMapper

    @Inject
    lateinit var useCase: NewsUseCase
    lateinit var viewModel: NewsViewModel


    /*@get:Rule
    var hiltRule = HiltAndroidRule(this)*/

    @Before
    fun setup() {
        // Mock dependencies
        //hiltRule.inject()
        viewModel = NewsViewModel(useCase, mapper)
        // Create the ViewModel with mocked dependencies

    }


    @Test
    fun checkViewModelNotNull() {
        assertNotNull(viewModel)
    }

}